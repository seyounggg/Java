package com.sist.main4;

public class Main {

	public static void main(String[] args) {
		Human man=new Human();
		man.setData("심청이");
		System.out.println(man.getData());
		Student s=new Student();
		s.setData("박문수");
		System.out.println(s.getData());
		System.out.println(man.getData());
	}
}
