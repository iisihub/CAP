/* 
 * IErrorResult.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

package com.iisigroup.cap.component;

/**
 * <pre>
 * 錯誤訊息處理
 * </pre>
 * 
 * @since 2011/1/28
 * @author iristu
 * @version
 *          <ul>
 *          <li>2011/1/28,iristu,new
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public interface ErrorResult extends Result {

    void putError(Request request, Exception e);

}
