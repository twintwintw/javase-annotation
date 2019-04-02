package com.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Demo01 {

	public static void main(String[] args) {

		// 反射 + 注解
		// 框架 注解 反射

		try {
			Class clazz = Class.forName("com.demo.Person");

			Object object = clazz.getDeclaredConstructor().newInstance();

			// 使用注解 初始化 属性值

			Field[] fields = clazz.getDeclaredFields();

			for (Field field : fields) {

				System.out.println(field);

				if (field.isAnnotationPresent(PersonAnnotation.class)) {

					PersonAnnotation personAnnotation = field.getAnnotation(PersonAnnotation.class);

					if (field.getName().equals("name")) {

						if (!field.isAccessible())
							field.setAccessible(true);

						field.set(object, personAnnotation.name());
					}

				}
				if (field.isAnnotationPresent(PersonAnnotation.class)) {

					PersonAnnotation personAnnotation = field.getAnnotation(PersonAnnotation.class);

					if (field.getName().equals("age")) {

						if (!field.isAccessible())
							field.setAccessible(true);

						field.set(object, personAnnotation.age());
					}

				}

			}

			// 方法
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {

				if (method.isAnnotationPresent(PersonAnnotation.class)) {

					PersonAnnotation anno = method.getDeclaredAnnotation(PersonAnnotation.class);

					if (!method.isAccessible())

						method.setAccessible(true);

					if (method.getName().equals("setName")) {

						method.invoke(object, anno.name());

					}
				}
				if (method.isAnnotationPresent(PersonAnnotation.class)) {
					
					PersonAnnotation anno = method.getDeclaredAnnotation(PersonAnnotation.class);
					
					if (!method.isAccessible())
						
						method.setAccessible(true);
					
					if (method.getName().equals("setAge")) {
						
						method.invoke(object, anno.age());
						
					}
				}

			}

			System.out.println(object);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class T {

	private String name;

	@Override
	public String toString() {
		return "T [name=" + name + "]";
	}

	@Deprecated
	public void test() {

		System.out.println("dasodjaosj");

	}

	public void test(String string) {

		System.out.println("test:" + string);
	}

}
