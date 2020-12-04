package com.module;

public interface ProcessingModule<T> extends Module<T>{
	public void processingData(T data);
}
