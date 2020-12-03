package com.data.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.data.Data;
import com.data.attribute.Test2;
import com.data.attribute.TestDataEnum;

public class TestData<T extends Enum> implements Data{
	
	private Class<T> enumClass = null;
	private List dataList = new ArrayList();
	
	TestData(){
		super();
	}

	TestData(Class<T> clazz) {
		super();
		initList(clazz);
	}

	private void initClass(Class<T> clazz) {
		
		if(clazz!=null && clazz.isEnum()) {
			this.enumClass = clazz;
		}else {
			this.enumClass = null;
		}
	}

	public void initList(Class clazz){
		
		initClass(clazz);
		Class<T> localClass = this.enumClass;
		
		if(localClass!=null) {

			Object[] obj = localClass.getEnumConstants();
			
			if(this.dataList!=null) {
				this.dataList.clear();
			}
			
			for(int i = 0; i < obj.length; i++) {
					this.dataList.add("");
			}
		}
	}
	
	public boolean putColumnData(String str, int index ) {
		
		boolean isSuccess = false;
		
		try {
			this.dataList.set(index, str);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static void main(String[] args) {
		TestData td = new TestData(TestDataEnum.class);
		td.putColumnData("", TestDataEnum.ID.ordinal());
	}
}
