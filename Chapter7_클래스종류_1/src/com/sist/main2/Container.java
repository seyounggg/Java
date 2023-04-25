package com.sist.main2;
//Object는 모든 클래스의 상위 클래스(모든 클래스는 Object 상속을 받는다)
//      -> 최상위 클래스!!!
/*
 *    class A (extends Object)
 *    class B extends A 
 * 상속 순서 : Object -> A -> B
 *    Object o=new A() - 가능
 *    Object o=new B() - 가능
 *    
 *    Object[] a={10,"",10.6...} - 가능 // Object는 모든 데이터형을 가지고 있으므로
 *                                                 데이터형이 다른 배열도 가능하다
 */
public class Container { // 클래스 관리하는 클래스(영역)
	public Object getBean(int no) {
		Object o=null;
		if(no==1)
			o=new A();
		else if(no==2)
			o=new B();
		else if(no==3)
			o=new C();
		else if(no==4)
			o=new D();
		else if(no==5)
			o=new E();
		
		return o;
	}
}
