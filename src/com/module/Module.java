package com.module;

public interface Module<T> {
	public boolean readProperty();
	public T readData();
	public void sendData(T data);
}