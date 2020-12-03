package com.data;

import java.util.ArrayList;
import java.util.List;

public interface Data<T extends Enum>{
	public void initList(Class<T> clazz);
}
