package com.sist.exception;
/*
 *   final 클래스 => 종단클래스(java.lang)
 *        (확장을 할 수 없다 => 있는 그대로 사용) => 상속을 내리지 못한다..상위클래스가 될 수 없다
 *  
 *  # 기본 라이브러리
 *    java.lang
 *    java.util
 *    java.io
 *    java.net
 *    java.text
 *    
 *    java.sql : 오라클
 *    javax.http : 브라우저
 *   
 *   오버라이딩(상속의 기본) => 변경해서 사용(다형성)
 *      객체지향의 3대 요소
 *         1. 데이터 보호
 *            - 캡슐화 : 변수를 은닉화 => 메소드를 통해 접근이 가능하게 만든다
 *                     -------private           -------- public
 *                     => 변수가 2가지 기능만 수행하게 만든다
 *                        메모리 저장(setter) / 메모리에서 데이터 읽기(getter)
 *                     => 모든 멤버변수 : private
 *                     => 모든 메소드(생성자) : public _ 다른 클래스 와연결이 가능하게!!
 *                     
 *                     접근지정어
 *                     1) private : 자신의 클래스에서만 사용 가능(은닉화)
 *                                  다른 클래스에서는 접근이 불가능
 *                     2) default : 같은 패키지안에서만 사용 가능
 *                     3) public : 패키지 상관없이 모든 클래스에서 사용 가능
 *                     
 *         2. 재사용 : 상속 / 포함 => 클래스 크기 결정 => 형변환
 *         
 *                  1) 상속 : 하위 클래스의 내용을 변경해서 사용하고 싶을 경우
 *                  class A
 *                  class B extends A => A가 가지고 있는 모든 내용을 가지고 온다
 *                          ------- 확장(A의 내용을 변경해서 사용, 추가 가능)
 *                                  라이브러리 => 프로그램에 맞지 않는 경우(수정)
 *                  
 *                  2) 포함 : 기능을 있는 그대로 사용하려는 경우
 *                  class A {
 *                       
 *                       B b=new B(); // 특별한 경우가 아니면 재정의하지 않는다
 *                  }
 *                  
 *                  # 클래스 크기
 *                  1) 상속
 *                     A는 상속을 내린 클래스 > B는 상속을 받은 클래스
 *                        A a=new A()
 *                        B b=new B()
 *                        A c=new B() => 묵시적 형변환(자동)
 *                          ----> 추상클래스, 인터페이스가 많이 등장(둘다 메모리 할당이 되지 않는다)
 *                                메모리 할당 시 상속을 받은 클래스를 이용해서 메모리 할당을 한다
 *                                미완성 클래스(메소드가 구현이 안된 상태)
 *                                => 설계, 같은 기능 (처리를 프로그램에 맞게 할 때) 
 *                        B d=(B)c; => 명시적 형변환(강제)
 *                                     라이브러리에서 많이 사용
 *                        클래스를 저장해서 관리 (클래스) => Collection
 *                        
 *         3. 수정 및 추가(유지보수가 쉽게) : 수정(오버라이딩) / 추가(오버로딩) => 메소드관련
 *            
 *            --------------------------------------------------
 *                           오버로딩              오버라이딩
 *            --------------------------------------------------
 *            관계          한개의 클래스             상속관계
 *                           상속관계
 *            -------------------------------------------------
 *            메소드명          동일                  동일
 *            --------------------------------------------------
 *            매개변수     갯수 or 데이터형 다름         동일
 *            --------------------------------------------------
 *            리턴형           관계없음               동일
 *            --------------------------------------------------
 *            접근지정어        관계없음               확장가능
 *            --------------------------------------------------
 *            사용처           생성자            인터페이스/추상클래스
 *            --------------------------------------------------
 *            *** 상속
 *               1) 호출 => 상위클래스의 생성자가 먼저 호출(기본생성자)
 *                  class A
 *                  {
 *                      => public A(){}
 *                  	public A(int a){}
 *                  }
 *                  class B extneds A
 *                  {
 *                      public B(int a, int b){}
 *                  }
 *                  
 *                  B b=new B();
 *                     => new () => new B()
 *                  // 상위클래스에 매개변수가 있는 생성자를 만들고자 하면, 기본 생성자를 반드시 추가해줘야 한다
 *               2) 예외조건 => static, 생성자, 초기화블록, private
 *   # 형변환
 *      class A
 *      class B extneds A
 *      class C extends B
 *      class E extends B
 *      
 *      A a=new A();
 *      A a=new B();
 *      B b=new B();
 *      B b=new D();
 *      B b=new E();
 *      B b=(B)new A(); (X) => CalssCastException
 *          -> A a=new B(); -> B b=(B)a; (O)
 *          
 *   # 클래스의 종류
 *      = 추상클래스
 *      = 인터페이스 => 추상클래스의 단점을 보완(클래스와 동일하게 취급)
 *      = 차이점)
 *         - 클래스 : 단일 상속 / 인터페이스 : 다중상속
 *      = 특징)
 *         - 설계도(구현이 안된 생타) => 미완성된 클래스(자신이 메모리를 할당할 수 없다)
 *         - 여러개의 관련된 클래스를 모아서 한개의 객체명으로 제어
 *         
 *      ---------------------------------------------------------------
 *                 추상클래스                         인터페이스
 *      ---------------------------------------------------------------
 *      상속관계      단일상속                            다중상속
 *      ---------------------------------------------------------------
 *      상속기호      extends                          implements
 *      ---------------------------------------------------------------
 *      멤버변수     인스턴스변수                           상수형 변수
 *                  정적변수
 *      ---------------------------------------------------------------
 *      메소드      구현된 메소드                            구현 안된 메소드
 *                구현 안된 메소드
 *      ---------------------------------------------------------------
 *      기법         오버라이딩                               오버라이딩
 *      ---------------------------------------------------------------
 *      형식 
 *         [접근지정어] abstract class ClassName
 *         {
 *            -----------------------------
 *            변수
 *               인스턴스 변수
 *               static 변수
 *            -----------------------------
 *            메소드
 *               구현된 메소드
 *               [접근지정어] 리턴형 메소드명(매개변수...)
 *               {
 *               }
 *               
 *               구현이 안된 메소드
 *               [접근지정어]abstract 리턴형 메소드명(매개변수...);
 *               
 *            -----------------------------
 *            생성자
 *               오버로딩이 가능하다
 *            -----------------------------
 *         }
 *      
 *      
 *         인터페이스
 *         [접근지정어] interface Iterface명 {
 *            --------------------------
 *            변수선언 : 상수형 변수
 *               int a=10; // 반드시 값을 명시적으로 지정
 *               => public static final int a=10;
 *                  -------------------자동추가
 *            --------------------------
 *            구현이 안된 메소드 목록
 *               void display();
 *             => public abstract void display();
 *                ---------------자동추가
 *            --------------------------
 *            구현된 메소드 목록 -> public 자동추가
 *            default void aaa(){} // 일반메소드 _ 재정의 하려면 default
 *            => public default void aaa(){}
 *            static void bbb(){} // 정적
 *            => public static void bbb(){} 
 *            --------------------------
 *         }
 *         => 인터페이스는 변수나 메소드가 public 이다
 *         => 연결을 목적으로 하기에 언제든 연결 가능하도록 public 으로 선언해야한다
 *      ---------------------------------------------------------------
 *      
 *      # 상속
 *         interface ========> interface
 *                    extends
 *         interface ========> class
 *                   implements
 *         
 *      # 다중상속
 *         class A implements 인터페이스, 인트페이스...
 *         
 *   
 */
import java.util.*;
class AAA{
	public void aaa() {}
	public AAA() {}
	int ㅁ=10;
}
abstract class C {
	C(){}
	C(int a){};
}
class A{
	int a=10;
	String name="호길동";
	public A() {}
	public A(int a) {
		this.a=a;
	}
}
// new A()
class B extends A{
	int b=20;
	public B() {
		super(); // public A(){} 호출
		// super(); 가 보이지 않지만 포함되어 있다
	}
}
public class 정리_7장 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//B b=(B)new A();
		//A a=new A();
		//B b=(B)a;
		
		String s1="Hello";
		String s2="Hello";
		String s3=new String("Hello");
		
		if(s1==s2)
			System.out.println("같다");
	}

}
