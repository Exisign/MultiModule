package com.module;

import java.util.Collection;

public interface SendModule<T extends Collection> extends Module{
	public void sendData(T collectionChild) throws Exception;
}
