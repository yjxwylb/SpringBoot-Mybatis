package com.learn.springboot.util;
/** * 
author  zhongjie
date 创建时间：2017年10月23日 下午4:47:42
version 1.0
parameter 
since 
return  
*/
public interface ICopyCallBack<T,E> {
	public  void  invoke(T source, E target);
}
