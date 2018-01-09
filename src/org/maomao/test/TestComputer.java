package org.maomao.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.maomao.entity.Computer;

public class TestComputer {
	public static void main(String[] args) {
		System.out.println("=======获取所有的属性===========");
		Field[] fields = Computer.class.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName() + "\t"+field.getModifiers() + "\t" + field.getType());
		}
		
		System.out.println("类中的方法");
		Method[] methods = Computer.class.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName() + "\t" + method.getParameterTypes());
		}
		
		System.out.println("类的构造方法");
		//单例设计模式:只有一个实例
		Constructor[] constructors = Computer.class.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			Class[] classes = constructor.getParameterTypes();
			for (Class class1 : classes) {
				System.out.print(class1 + "   ");
			}
			System.out.println();
		}
		
		System.out.println("类所处的包");
		System.out.println(Computer.class.getPackage().getName());
		
		System.out.println("Computer的父类");
		System.out.println(Computer.class.getSuperclass());
		
		System.out.println("该类都实现了哪些借口");
		Class[] interfaces = Computer.class.getInterfaces();
		for (Class class1 : interfaces) {
			System.out.println(class1);
		}
		
		System.out.println("获取注解信息");
		Annotation[] annotations = Computer.class.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation.getClass());
		}
		
		Computer computer = new Computer();
		//通过反射创建类的实例
		String className = "org.maomao.entity.Computer";
		try {
			Computer com = (Computer)Class.forName(className).newInstance();
			com.playGame();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//3.通过Constructor来创建
		try {
			Constructor constructor = Computer.class.getConstructor(new Class[]{String.class,double.class,String.class});
			Computer com = (Computer) constructor.newInstance("联想",4350.55,"暗黑");
			
			com.playGame();
			//通过反射修改字段的值
			Field field = com.getClass().getDeclaredField("brand");
			field.setAccessible(true);
			field.set(com, "宏基");
			
			com.playGame();
			
			System.out.println(com.price);
			
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		for (int i = 0; i < 7; i++) {
			System.out.println();
		}
		
	}
}

















