package com.sist.exam2;

public class HelloImpl implements Hello{
	
	@Override
	public void sayHello(String name) {
		System.out.println(name+"님 환영합니다.");
	}

}
