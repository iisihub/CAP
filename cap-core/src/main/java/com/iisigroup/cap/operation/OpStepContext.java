/* 
 * OpStepContext.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.operation;

import com.iisigroup.cap.response.IResult;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2012/9/24
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/9/24,iristu,new
 *          </ul>
 */
public class OpStepContext {

    String goToStep;
    IResult result;

    public OpStepContext(String goToStep) {
        this.goToStep = goToStep;
    }

    public String getGoToStep() {
        return goToStep;
    }

    public OpStepContext setGoToStep(String goToStep) {
        this.goToStep = goToStep;
        return this;
    }

    public IResult getResult() {
        return result;
    }

    public OpStepContext setResult(IResult result) {
        this.result = result;
        return this;
    }
}
