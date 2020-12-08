package com.thread;

import java.util.List;
import java.util.Queue;

import com.module.ReadModule;

public class ReadThreadModule<T> implements Runnable{

	private ReadModule readModule = null;
	private Queue<List<String>> queue = null;
	
	public ReadThreadModule(ReadModule readModule) {
		this.readModule = readModule;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	//해당 thread에서는 Queue에 데이터를 적재하는 것을 처리한다.
	//정렬 된 데이터가 직렬화되어 들어온다면, 받아들이는대로 읽어서 처리하는 것이 가능하지만...
	//정렬되지 않은 데이터가 직렬화되어 들어온다면... 사실상 효용성이 없어질 수도 있다.
}
