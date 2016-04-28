/*_
 * Copyright (c) 2006 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

/**
 * Copyright (c) 2009-2011 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.operation.step;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.operation.OpStepContext;
import com.iisigroup.cap.operation.OperationStep;

/**
 * <pre>
 * AbstractCustomizeOpStep
 * </pre>
 * 
 * @since 2010/11/24
 * @author iristu
 * @version
 *          <ul>
 *          <li>2010/11/24,iristu,new
 *          </ul>
 */
public abstract class AbstractCustomizeOpStep implements OperationStep {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    String name;

    Map<String, String> ruleMap;

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.flow.OperationStep#getName()
     */
    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.flow.OperationStep#getRuleMap()
     */
    public Map<String, String> getRuleMap() {
        return ruleMap;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.flow.OperationStep#handleException(java.lang.Exception)
     */
    public OpStepContext handleException(OpStepContext ctx, Exception e) {
        ctx.setGoToStep(ERROR);
        return ctx;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.flow.OperationStep#setName(java.lang.String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tw.com.iisi.cap.flow.OperationStep#setRuleMap(java.util.Map)
     */
    public void setRuleMap(Map<String, String> ruleMap) {
        this.ruleMap = ruleMap;
    }

}
