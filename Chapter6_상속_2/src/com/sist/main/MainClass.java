package com.sist.main;
/* 
 * 스프링
 *   1) 가급적이면 상속없이 독립적인 클래스(POJO)
 *   2) new를 사용하지 않는다
 * 
 * 포함(has-a)
 *    - 제공한 그대로 사용(오버라이딩 가능/익명의 클래스)
 *    
 * 상속(is-a) => 재사용
 *    - 단점 : 실행속도가 늦다(사용빈도가 극히 드물다) => 포함(has-a) 클래스
 *    - 기능 수정(메소드) 하거나 변수를 추가해서 사용
 *    - 기능(메소드) 수정 하거나 변수를 추가해서 사용
 *    - 자식클래스에는 부모클래스를 대입할 수 없다 (예, B b=new A() -> (X) )
 *    - 기존의 클래스를 재사용 가능, 수정, 추가
 *       가능 : 소스 코딩량을 줄일 수 있다 => 스프링(AOP)
 *           : 코드를 공통적으로 사용하기 때문에 관리가 편하다
 *      
 *   
 */
class Super {
	int a,b;
	static int c;
	
	public Super() { // 생성자 호출되면 메모리가 할당
		System.out.println("Super클래스 메모리 할당");
	}
}
class Sub extends Super{
	int d,e;
	public Sub() {
		System.out.println("Sub클래스 메모리 할당");
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub sub=new Sub();
		
	}

}
