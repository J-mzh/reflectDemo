package org.maomao.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	
	public void showClassInfo(Object o){
		//使用反射能够获取类的结构信息
		Method[] methods = o.getClass().getDeclaredMethods();
		for (Method method : methods) {
			//碰到toUpperCase方法，就执行
			if(method.getName().equals("toUpperCase")){
				try {
					Object result = method.invoke(o);
					System.out.println(result);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
//			System.out.println(method.getName());
		}
		
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.showClassInfo("hello World");
	}
}















