package com.data.impl;

import java.util.List;

import com.data.Data;
import com.data.attribute.TestDataEnum;

public class TestData<T extends Enum> implements Data{

	TestData(){
		super();
	}

	TestData(Class<T> clazz){
		super();
//		initList(enumClass);
		initList(clazz);
	}
	
	public List getList() {
		return this.dataList;
	}
	
	public static void main(String[] args) {	
		new TestData(TestDataEnum.class);
		new TestData(String.class);
	}

	public void initList(Class<T> clazz) {
		
		if(clazz instanceof Object) {
			System.out.println(clazz.getName());
		}
		
		Object[] obj = clazz.getEnumConstants();
		
		for(int i = 0; i < obj.length; i++) {
			
			System.out.println(obj[i].toString());
		}
	}
}
