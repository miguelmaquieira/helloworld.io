package com.helloworldio.common;

import java.lang.reflect.Method;

public class CommonBeanUtils {

	public static String toString(Object bean) {
		StringBuilder buffer = new StringBuilder();
		Class<?> objClass = bean.getClass();
		Method[] methods = objClass.getMethods();
		buffer.append(bean.getClass().getName()).append("[\n");
		for (Method method : methods) {
			if (method.getName().startsWith("get") && method.getParameterTypes().length == 0) {
				String name = method.getName();
				buffer.append(name);
				buffer.append(": ");
				try	{
					buffer.append(method.invoke(bean));
				} catch(Exception exp) {
					buffer.append("Property invoke exception: ")
							.append(exp.getMessage());
				}
				buffer.append("\n");
			}
		}
		buffer.append("]");
		return buffer.toString();
	}
}
