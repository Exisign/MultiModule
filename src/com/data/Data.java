package com.data;

import java.util.ArrayList;
import java.util.List;

public interface Data<O extends Object, E extends Enum>{
	public void initList(Class<E> clazz);
	public boolean setColumnData(O obj, E enumClass) throws Exception;
	public O getValue(E enumClass) throws Exception;
	public List<O> getSwallowCopyList();
}
