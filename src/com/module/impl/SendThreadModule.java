package com.module.impl;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import com.attribute.SocketE;
import com.module.SendModule;
import com.util.Parser;

public class SendThreadModule<T extends Collection> implements SendModule{

	List<String> ipPortList = new LinkedList<String>();
	Queue<Socket> socketQueue = new LinkedBlockingQueue<Socket>();
	
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
					socketQueue.add(socket);
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
		
		T queue = (T)new LinkedBlockingQueue<String>();
		queue.addAll(collectionChild);
		
		int threadCount = 10;
		
		ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
		ThreadPoolExecutor threadPoolExcecutor = (ThreadPoolExecutor) executorService;
		List<DataSendThead> threadList = new ArrayList();
		
		for(int i = 0; i < queue.size(); i++) {
			
			Socket tSocket = socketQueue.poll();
			
			if(tSocket!=null) {
				threadList.add(new DataSendThead(queue.toArray(), tSocket));
			}
		}
		
	}
}

class DataSendThead implements Runnable{

	private Object[] object = {};
	private Socket socket = new Socket();
	
	DataSendThead(Object[] object, Socket socket) {
		this.object = object;
		this.socket = socket;
	}

	@Override
	public void run() {
		Object[] obj = object;
	}
}
