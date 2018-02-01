package com.learn.springboot.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.lang.reflect.Type;


public class BeanConvertUtil {
	private static Logger logger= LoggerFactory.getLogger(BeanConvertUtil.class);
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	public static String bean2Xml(Object obj,boolean headFlag) {
		try {
			JAXBContext ctx=JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller=ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, headFlag);
			OutputStream os=new ByteArrayOutputStream();
			marshaller.marshal(obj, os);
			return os.toString();
		} catch (Exception e) {
			logger.error("bean convert to xml fail",e);
		} 
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T xml2Bean(String xml,Class clzz){
		if(StringUtils.isBlank(xml)){
			return null;
		}
		try {
			JAXBContext ctx=JAXBContext.newInstance(clzz);
			Unmarshaller unmarshaller=ctx.createUnmarshaller();
			Object result= unmarshaller.unmarshal(new StringReader(xml));
			return (T)result;
		} catch (JAXBException e) {
			logger.error("xml convert to bean fail",e);
		}
		return null;
	}
	
	public static String bean2Json(Object object){
		String json = gson.toJson(object);
		return json;
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T Json2Bean(String json,Class clzz){
		if(null==gson.fromJson(json, clzz)) {
			return null;
		}
        try {
			return (T) gson.fromJson(json, clzz);
		} catch (JsonSyntaxException e) {
			logger.error("json convert fail",e);
		}
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void  setField(Object entity,String fieldName,T value){
		String getMethodName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
		Class clz = entity.getClass();
		try {
			Method getMethod = clz.getDeclaredMethod(getMethodName,value.getClass());
			getMethod.invoke(entity,value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static <T> T getField(Object entity,String fieldName){
		String getMethodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
		Class clz = entity.getClass();
		try {
			Method getMethod = clz.getDeclaredMethod(getMethodName);
			Object res =getMethod.invoke(entity);
			if(res!=null){
				return (T)res;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static String getFieldType(Object entity,String fieldName){
		String getMethodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
		Class clz = entity.getClass();
		try {
			Method getMethod = clz.getDeclaredMethod(getMethodName);
			Type type= getMethod.getGenericReturnType();
			return type.getTypeName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
