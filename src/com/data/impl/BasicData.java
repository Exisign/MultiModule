package com.data.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.data.Data;
import com.data.attribute.TestDataEnum;

public class BasicData<O extends Object, E extends Enum> implements Data{

	private final List<O> dataList = new ArrayList();
	
	private BasicData() {
		super();
	}

	public BasicData(Class<E> clazz) {
		this();
		initList(clazz);
	}

	public void initList(Class clazz){
		
		if(clazz!=null && clazz.isEnum()) {
			Object[] obj = clazz.getEnumConstants();
			
			if(this.dataList!=null) {
				this.dataList.clear();
			}
			
			for(int i = 0; i < obj.length; i++) {
					this.dataList.add(null);
			}
		}
	}
	
	@Override
	public boolean setColumnData(Object obj, Enum enumClass) throws Exception {
		// TODO Auto-generated method stub
		return setColumnData(obj, enumClass.ordinal());
	}
	
	
	public boolean setColumnData(Object obj, int index) throws Exception{
		
		boolean isSuccess = false;
		
		try {
			this.dataList.set(index,(O)obj);
			isSuccess = true;
		}catch(Exception e) {
			throw e;
		}
		
		return isSuccess;
	}
	
	public Object getValue(Enum enumClass) throws Exception{
		return getValue(enumClass.ordinal());
	}
	
	public O getValue(int index) throws Exception{
		O value = null;
		
		try{
			value = this.dataList.get(index);
		}catch(Exception e) {
			throw e;
		}
		
		return value;
	}
	
	/**
	 * 해당 method는 deep copy를 지원하지 않습니다.
	 * @return List
	 */
	public List<O> getSwallowCopyList() {
		List<O> copyList = new ArrayList();

		if(this.dataList!=null) {
			copyList.addAll(this.dataList);
		}
		return copyList;
	}
}
