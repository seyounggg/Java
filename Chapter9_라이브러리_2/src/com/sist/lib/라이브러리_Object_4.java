package com.sist.lib;
//getClass => 데이터 타입을 읽어 온다
/*
 *    class A
 *    
 *    A a=new A();
 *    a.getClass() ==> class A
 *    
 *    String s="";
 *    s.getClass() ==> java.lang.String
 */

class Student3 {
	
}
public class 라이브러리_Object_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student3 s=new Student3();
		System.out.println(s.getClass());
		String s2="";
		System.out.println(s2.getClass());
	}

}
