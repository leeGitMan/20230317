package edu.kh.jsp.model.vo;



public class Person {
	
	// 필드
	
	private String name;
	private String address;
	private int age;
	
	
	// 기본 생성자
	
	public Person() {
		
	}

	// 매개변수 생성자
	public Person(String name, int age, String address ) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	// Object.toString() 오버라이딩
	@Override
	public String toString() {
		return name + " / " + age + " / " + address;
	}
	
	
	
	
	
	
	
	
	
	
}
