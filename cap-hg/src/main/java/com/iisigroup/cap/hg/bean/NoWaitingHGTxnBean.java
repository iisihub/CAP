/* 
 * MCIHGTxnNoWattingBean.java
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.hg.event.HGEventAction;

/**
 * <pre>
 * MCIHGTxnNoWatting Bean
 * </pre>
 * 
 * @since 2012/2/24
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2012/2/24,rodeschen,new
 *          </ul>
 */

public class NoWaitingHGTxnBean implements HGTxnBean {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private HGTxnBean txnBean;

    private HGEventAction afterAction;
    private HGEventAction beforeAction;

    /*
     * (non-Javadoc)
     * 
     * @see com.bqd.mci.bean.IHGTxnBean#setTxnCd(java.lang.String)
     */
    @Override
    public void setTxnCd(String txnCd) {
        txnBean.setTxnCd(txnCd);
    }

    /**
     * before action
     * 
     */
    public void beforeAction() throws CapException {
        if (beforeAction != null) {
            beforeAction.excute(this);
        }
    }

    /**
     * after action
     * 
     * @param resultData
     *            resultData
     */
    public void afterAction(Object resultData) throws CapException {
        if (afterAction != null) {
            afterAction.excute(resultData);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bqd.mci.bean.IHGTxnBean#setSendData(java.lang.Object)
     */
    @Override
    public void setSendData(Object requestData) {
        txnBean.setSendData(requestData);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bqd.mci.bean.IHGTxnBean#execute()
     */
    @Override
    public void execute() throws CapException {
        beforeAction();
        new excuteThread().start();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bqd.mci.bean.IHGTxnBean#getResultData()
     */
    @Override
    public Object getResultData() {
        return null;
    }

    public HGTxnBean getTxnBean() {
        return txnBean;
    }

    public void setTxnBean(HGTxnBean txnBean) {
        this.txnBean = txnBean;
    }

    public HGEventAction getBeforeAction() {
        return beforeAction;
    }

    public void setBeforeAction(HGEventAction beforeAction) {
        this.beforeAction = beforeAction;
    }

    public HGEventAction getAfterAction() {
        return afterAction;
    }

    public void setAfterAction(HGEventAction afterAction) {
        this.afterAction = afterAction;
    }

    /**
     * <pre>
     * 送出後不等待結束
     * </pre>
     * 
     * @since 2012/2/24
     * @author rodeschen
     * @version
     *          <ul>
     *          <li>2012/2/24,rodeschen,new
     *          </ul>
     */
    private class excuteThread extends Thread {

        @Override
        public void run() {
            try {
                logger.info("send Message Start");
                txnBean.execute();
                afterAction(txnBean.getResultData());
                logger.info("send Message End");
            } catch (CapException e) {
                logger.info("send Message Error", e);
            }

        }
    }

}
