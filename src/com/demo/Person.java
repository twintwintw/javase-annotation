package com.demo;

public class Person {

	@PersonAnnotation(name = "Tom")
	private String name;

	@PersonAnnotation(age = 11)
	private int age;
	
	public Person() {
		super();
	}

	@PersonAnnotation(name="Na",age=30)
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	@PersonAnnotation(name="Jerry")
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@PersonAnnotation(age = 20)
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}
