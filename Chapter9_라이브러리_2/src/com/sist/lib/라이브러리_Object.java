package com.sist.lib;
/*
 *    사용자 정의 클래스 + 라이브러리
 *    
 *    1) 자바의 모든 클래스(라이브러리 클래스, 사용자 정의 클래스)
 *       => 상위 클래스 (Object)
 *    2) 자바에서 지원하는 라이브러리
 *     -------------------------[UnCheckException]-----------------------------
 *       = java.lang : 자바의 기본 클래스(가장 많이 사용 되는 라이브러리)
 *          -> import를 생략한다
 *          -> Object, String, StringBuffer, Wrapper, System, Thread 등이 들어가 있다
 *       = java.util : 유용하게 사용이 가능하게 만든 라이브러리
 *          -> Scanner, StringTokenizer, 자료구조(데이터를 쉽게 관리)
 *          -> Date, Calendar ...
 *     -------------------------[CheckException]--------------------------------
 *       = java.io : 입출력(메모리, 파일, 네트워크)
 *       = java.net : 네트워크
 *       = java.sql : 데이터베이스 연결
 *       = java.text : 변환할때(날짜형식, 문자열 형식)
 *     -------------------------[Web관련 라이브러리]---------------------------------
 *     -------------------------[Spring 관련 라이브러]-------------------------------
 *     -------------------------[데이터 수집(Jsoup,JSON)]---------------------------
 *     
 *    자동 처리
 *    1) import java.lang.*
 *    2) 메소드
 *       void method(){
 *       return => 생략 => 자동 추가
 *       }
 *    3) 생성자
 *       class A {
 *          public A(){} => 자동 추가
 *       }
 *    4) 상속
 *       class A extends Object
 *    -------------------------------------
 *    java.lang에서 지원하는 클래스는 대부분이 final 클래스
 *    => 상속을 받아서 확장이 불가능(있는 그대로 사용)
 *    => 상속을 받아서 확장이 가능 => Object
 *    => Object : 모든 데이터형을 받을 수 있다
 *       Object o=10 , Object o="" ...
 *       -> 데이터형을 여러개 사용시에는 라이브러리에서 리턴형이 대부분 Object이다
 *       -> 형변환을 해야 사용이 가능하다
 *       -> 클래스의 형변환
 *          (int)new Object() ------ X
 *          (Integer)new Object() -- O
 *        
 *          Integer i=10; => 오토박싱
 *          int a=new Integer(10); => 언박싱
 *    
 *    => Object의 주요 기능
 *       1) finalize() : 소멸자(메모리 할당 => 해제할때 호출)
 *       2) toString() : 객체를 문자열화 시킨다
 *       3) clone() : 새로운 메모리를 생성할 대 복제
 *       4) getClass() : 클래스 객체 읽기
 *       5) equals() : 객체 비교
 *       
 *       class A //A클래스의 super는 Object
 *       class B extends A(A+Object) // B클래스의 super는 A클래스(A+Object)
 */
class Student{
	private int hakbun;
	private String name;
	public Student() {
		//super => Object
		hakbun=1; // this.은 생략이 가능 -> 지역변수와 같은 이름일 때 구분
		name="홍길동";
		System.out.println("생성자 : 멤버변수에 대한 초기화");
	}
	public void print() {
		System.out.println("학번:"+hakbun+",이름:"+name);
	}
	// 소멸자
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("객체 메모리 해제");
	}
	
}
public class 라이브러리_Object /*extends Object*/{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 객체 메모리 할당(메모리에 저장)
		Student s=new Student();
		
		// 객체 활용(메소드 호출, 변수변경)
		s.print();
		
		// 객체 메모리 해제(메모리에서 삭제)
		s=null; //GC대상
		
		//메모리를 해제 => 강제로 명령
		System.gc(); // finalize --> 멀티미디어에서 많이 사용됨
		
	}

}
