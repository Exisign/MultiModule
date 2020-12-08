package com.module;

import java.util.List;
import java.util.Queue;

public interface ReadModule<E extends Enum> extends Module{
	public Queue<List<String>> readData(Class<E> enumClass) throws Exception;
}
