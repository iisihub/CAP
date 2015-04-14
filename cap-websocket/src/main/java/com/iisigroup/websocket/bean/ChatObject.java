/* 
 * ChatObject.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.websocket.bean;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2013/8/6
 * @author rodeschen
 * @version <ul>
 *          <li>2013/8/6,rodeschen,new
 *          </ul>
 */
public class ChatObject {
    private String userName;
    private String message;

    public ChatObject() {
    }

    public ChatObject(String userName, String message) {
        super();
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
