/* 
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.hg.event;

/**
 * <pre>
 * event action
 * </pre>
 * 
 * @since 2012/2/24
 * @author rodeschen
 * @version <ul>
 *          <li>2012/2/24,rodeschen,new
 *          </ul>
 */
public interface IHGEventAction {

    /**
     * excute action
     * 
     * @param object
     *            object
     */
    void excute(Object object);
}
