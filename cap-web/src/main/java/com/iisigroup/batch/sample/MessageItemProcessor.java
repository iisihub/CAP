/* 
 * MessageItemProcessor.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.batch.sample;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2012/10/30
 * @author iristu
 * @version <ul>
 *          <li>2012/10/30,iristu,new
 *          </ul>
 */
@Component("messageProcessor")
public class MessageItemProcessor implements ItemProcessor<User, Message> {

	@Override
	public Message process(User user) throws Exception {
		Message m =  new Message();
		m.setContent("Hello " + user.getName()
				+ ",please pay promptly at the end of this month.");
		return m;
	}

}
