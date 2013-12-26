/* 
 * MessagesItemWriter.java
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

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

/**<pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * @since  2012/10/30
 * @author iristu
 * @version <ul>
 *           <li>2012/10/30,iristu,new
 *          </ul>
 */
@Component("messageWriter")
public class MessagesItemWriter implements ItemWriter<Message>{

	@Override
	public void write(List<? extends Message> items) throws Exception {
		for (Message m : items){
			System.out.println(m.getContent());
		}
	}

}
