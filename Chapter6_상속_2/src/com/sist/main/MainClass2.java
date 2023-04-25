package com.sist.main;
// 책 221page
// 상속이 있는 경우 => 객체 생성 방법
// 묵시적 타입변환 : double d=10; => d=10.0;
/*
 * class A
 * class B extends A
 *    A (상위클래스)
 *    ^ 
 *    B (하위클래스)
 *    ==> 크기 (범위) 상위>하위
 *       ---------- 상속, 포함
 *         A > B
 *         -----
 * A a=new A();
 * B b=new B();
 * B c=new B();
 * B d=new A(); <- X
 * B e=(B)new A(); <- X
 * 
 * [상속]
 *  1. 형식
 *     class A extends B => 단일 상속
 *  2. 클래스 크기
 *     상속을 내리는 클래스 > 상속을 받는 클래스
 *  3. 형변환
 *     작은 클래스 = 큰 클래스
 *  4. 자바의 최상위 클래스 => Object
 *  5. 상속의 예외 : static => 공유, 초기화블록, 생성자, private 접근이 안됨
 *  6. 변수 접근 : 선언된 클래스에 등록 변수까지만 접근이 가능
 *  7. 사용 범위 : 상위클래스는 하위 클래스의 추가된 내용에 접근이 불가능하다
 *  // 클래스명과 생성자가 다른 경우
		/*
		 * 클래스명 변수명 = new 생성자();
		 *  1) 변수제어 => 클래스 타입
		 *  2) 메소드제어 =>> 생성자 타입
 *  8. 실제 상속 => 라이브러리(윈도우, 데이터베이스)
 */
class Human {
	int a=10;
	int b=20;
	static int c=30; // 상속은 안되지만 공유 변수이므로 Student에서도 사용이 가능함
	public void display() {
		System.out.println("Human:display() Call...");
	}
}
class Student extends Human{
	int d=40;
	int e=50;
	public void display() {
		System.out.println("Student:display() Call..."); // <- 상속을 받아서 변경(오버라이딩)
	}
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Human h=new Human(); // a,b,c
		h.display();
		Student s=new Student(); //a,b,c,d,e
		s.display();
		Human h2=new Student(); // 작은 클래스를 대입했기때문에 문제 없음
		h2.display();
	    // Student s2=new Human(); => 큰거를 작은거에 대입했기 때문에 XX
		// Student s2=(Student)new Human(); =>  ClassCastException => 형변환 오류
		
		Student s2=(Student)h2; // 정상수행(생성자가 동일해야 형변환을 사용할 수 있음)
		s2.display();
		//Student s3=(Student)h; // ClassCastException => 형변환 오류
		
	}

}
