package com.module.impl;

import java.net.Socket;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.attribute.SocketE;
import com.module.SendModule;
import com.util.Parser;

public class SendThreadModule<T extends Collection> implements SendModule{

	List<String> ipPortList = new LinkedList<String>();
	List<Socket> socketList = new LinkedList<Socket>();
	
	private String essentialIP = "";
	private String delimiter = "";
	
	public SendThreadModule(Properties properties) throws Exception{
		readProperty(properties);
	}
	
	private void makeSocket() {
		for(int i = 0; i < ipPortList.size(); i++) {
			
			String[] arrIpPort = Parser.trimParser(ipPortList.get(i), ":");
			
			Socket socket = null;
			
			if(arrIpPort.length == 2) {
				try {
					int port = Integer.parseInt(arrIpPort[SocketE.PORT.ordinal()]);
					socket = new Socket(arrIpPort[SocketE.IP.ordinal()], port);
					socketList.add(socket);
				}catch(Exception e){
					if(socket!=null){
						try{
							socket.close();
						}catch(Exception e2){}
					}
				}
			}
		}
	}
	
	@Override
	public void readProperty(Properties properties) throws Exception{
		
		try {
			essentialIP = properties.getProperty("ipportlist");
			delimiter = properties.getProperty("delimiter");
			
			String[] parseResult = Parser.trimParser(essentialIP, delimiter);
			
			for(int i = 0; i < parseResult.length; i++) {
				ipPortList.add(parseResult[i]);
			}
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void sendData(Collection collectionChild) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
