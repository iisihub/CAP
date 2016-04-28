/* 
 * MCIHGTxnBean.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.hg.bean;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.hg.enums.ConnStatusEnum;
import com.iisigroup.cap.hg.service.HGService;

/**
 * <pre>
 * MCIHGTxnBean action
 * </pre>
 * 
 * @since 2011/12/12
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2011/12/12,rodeschen,new
 *          </ul>
 */
public class MultiAsyncHGTxnBean implements HGTxnBean {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private List<ActionBean> services;

    private Object sendData;
    private String txnCd;
    private int rTimeout;
    private int nrTimeout;
    private Object resultData;

    public List<ActionBean> getServices() {
        return services;
    }

    public void setServices(List<ActionBean> services) {
        this.services = services;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bqd.mci.bean.IHGTxnBean#execute()
     */
    @Override
    public void execute() throws CapException {
        List<HGService> rService = new ArrayList<HGService>();
        List<HGService> nrService = new ArrayList<HGService>();
        HGService ts;
        long startTime = System.currentTimeMillis();
        for (ActionBean s : services) {
            ts = s.getService();
            int rt = s.getTimeout();
            if (s.isRequired()) {
                if (rt > rTimeout) {
                    rTimeout = rt;
                }
                rService.add(ts);
            } else {
                if (rt > nrTimeout) {
                    nrTimeout = rt;
                }
                nrService.add(ts);
            }
            // ts.setProperty(MCIConstants.TXNCD, getTxnCd());
            ts.setSendData(getSendData());
            ts.initConnection();
            try {
                ts.execute();
            } catch (CapException e) {
                throw e;
            } catch (Exception e) {
                throw new CapException(e, e.getClass());
            }
        }
        executeService(startTime, rService, rTimeout);
        executeService(startTime, nrService, nrTimeout);
        // merge data
        resultData = null;
        for (ActionBean s : services) {
            ts = s.getService();
            if (s.getResponseAction() != null) {
                resultData = s.getResponseAction().margeResponse(resultData, ts.getReceiveData());
            } else if (resultData == null) {
                resultData = ts.getReceiveData();
            }
        }
    }

    private void executeService(long startTime, List<HGService> service, int timeout) throws CapException {
        HGService s;
        while (true) {
            for (int i = service.size() - 1; i >= 0; i--) {
                s = service.get(i);
                if (!ConnStatusEnum.RUNNING.equals(s.getStatus())) {
                    service.remove(s);
                }
            }
            if (service.isEmpty() || System.currentTimeMillis() - startTime >= timeout) {
                for (HGService s2 : service) {
                    s2.setStatus(ConnStatusEnum.TIMEOUT);
                    logger.error(s2.getClass().getName() + " status: timeout");
                }
                break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    public Object getSendData() {
        return sendData;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bqd.mci.bean.IHGTxnBean#setSendData(java.lang.Object)
     */
    @Override
    public void setSendData(Object sendData) {
        this.sendData = sendData;
    }

    public String getTxnCd() {
        return txnCd;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bqd.mci.bean.IHGTxnBean#setTxnCd(java.lang.String)
     */
    @Override
    public void setTxnCd(String txnCd) {
        this.txnCd = txnCd;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bqd.mci.bean.IHGTxnBean#getResultData()
     */
    @Override
    public Object getResultData() {
        return resultData;
    }

    /**
     * set resultData
     * 
     * @param resultData
     *            resultData
     */
    protected void setResultData(Object resultData) {
        this.resultData = resultData;
    }

}
