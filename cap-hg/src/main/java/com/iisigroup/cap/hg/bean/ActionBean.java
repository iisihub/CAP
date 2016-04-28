/* 
 * ActionBean.java
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

import com.iisigroup.cap.hg.action.ResponseAction;
import com.iisigroup.cap.hg.service.HGService;

/**
 * <pre>
 * HG action setting
 * </pre>
 * 
 * @since 2011/12/14
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2011/12/14,rodeschen,new
 *          </ul>
 */
public class ActionBean {
    private HGService service;
    private boolean required;
    private ResponseAction responseAction;
    private int timeout;

    public HGService getService() {
        return service;
    }

    public void setService(HGService service) {
        this.service = service;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public ResponseAction getResponseAction() {
        return responseAction;
    }

    public void setResponseAction(ResponseAction responseAction) {
        this.responseAction = responseAction;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

}
