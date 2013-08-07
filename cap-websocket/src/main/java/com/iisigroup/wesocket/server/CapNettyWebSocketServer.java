/* 
 * CapNettyWebSocketServer.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.wesocket.server;

import java.util.Collection;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;

/**<pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * @since  2013/8/6
 * @author rodeschen
 * @version <ul>
 *           <li>2013/8/6,rodeschen,new
 *          </ul>
 */
public class CapNettyWebSocketServer {
	public CapNettyWebSocketServer(){
		 Configuration config = new Configuration();
	       // config.setHostname("192.168.1.227");
	        config.setPort(9092);
	        
	        final SocketIOServer server = new SocketIOServer(config);
	        
	        server.addConnectListener(new ConnectListener() {
				
				@Override
				public void onConnect(SocketIOClient client) {
					// TODO Auto-generated method stub
					System.out.println(client);
				
					
				}
			});
	        server.addEventListener("chatevent", ChatObject.class, new DataListener<ChatObject>() {
	            @Override
	            public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
	            		Collection<SocketIOClient> clients = server.getAllClients();
	            		for(SocketIOClient c : clients){
	            			c.getNamespace();
	            		}
	                server.getBroadcastOperations().sendEvent("chatevent", data);
	            }
	        });
	        
	        server.start();

	      //  Thread.sleep(Integer.MAX_VALUE);

	       // server.stop();
	}
}
