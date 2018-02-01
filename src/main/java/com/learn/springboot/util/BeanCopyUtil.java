package com.learn.springboot.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/** * 
author  zhongjie
date 创建时间：2017年9月19日 下午5:41:38
version 1.0
parameter 
since 
return  
*/
public class BeanCopyUtil {
	public static void copyProperties(Object source, Object target,String ... innerFields){
		BeanUtils.copyProperties(source, target);  
		if(innerFields!=null&&innerFields.length>0){
			for(String field:innerFields){
				Object innerValue= BeanConvertUtil.getField(source, field);
				if(null!=innerValue){
					String clzName=BeanConvertUtil.getFieldType(target, field);
					if(null!=clzName){
						try {
							Class clz=Class.forName(clzName);
							Object innerObj=clz.newInstance();
							BeanUtils.copyProperties(innerValue, innerObj);
							BeanConvertUtil.setField(target, field, innerObj);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	public static <T,E> void copyWithCallBack(T source, E target,ICopyCallBack<T,E> callBack) throws IllegalAccessException, InvocationTargetException, InstantiationException{  
		BeanUtils.copyProperties(source, target);
		callBack.invoke(source, target);
	} 
}
