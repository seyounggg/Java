package com.sist.main;
/*
 *   1. 사용처
 *      - 인터페이스 : 추상클래스의 일종(보완)
 *         <특징>
 *         1) 다중상속이 가능(***)
 *         2) 인터페이스는 클래스와 동일(상속받으면 상위클래스)
 *         3) 설계만 되어 있다(구현이 안된 메소드만 모아서 선언)
 *         4) JDK1.8 이상에서는 구현된 메소드 사용이 가능한데 반드시 default 를 작성해야한다
 *         5) interface는 상수, 메소드 모드 public 만 사용한다
 *         6) 선언만 되어있다 => 상속을 내린다
 *            -> 상속받은 클래스를 구현해서 사용해야한다 ==> 오버라이딩 기법
 *         
 *         책 249page
 *           ㄱ. 인터페이스는 객체를 생성할 수 없다(구현이 안된 메소드를 가지고 있기때문에 메모리 저장이 불가능 하다)
 *              인터페이스 = new 구현한 클래스()
 *              => 거짓말이다(익명의 클래스를 이용하면 객체 생성이 가능하다)
 *           ㄴ. 인터페이스는 다중상속이 가능하다
 *              형식)
 *              class A implements 인터페이스, 인터페이스...
 *              
 *        
 *         <장점>
 *         1) 기능설계가 되어 있으므로 개발시간 단축
 *             아키텍쳐(PM)         DBA                    퍼블리셔   웹프로그래머 테스터    PL
 *             요구사항 분석 -> 데이터베이스 설계 -> 데이터 수집 -> 화면UI -> 구현 ---> 테스팅 -> 배포
 *             ---------------------------------------
 *             추상클래스/인터페이스 설계
 *         2) 표준화 가능 : 같은 메소드를 사용
 *         3) 서로 관계없는 클래스 연결해서 사용 가능
 *         4) 유지보수(수정)가 편리하다
 *         5) 독립적으로 사용 가능
 *         
 *         <형식>
 *         [접근지정어] interface InterfaceName
 *         {
 *           ------------------------------
 *           상수
 *           (public static final)int a=10; // 항상 값을 부여해야함
 *           -------------------- 자동추가   
 *           ------------------------------
 *           추상메소드
 *           (public abstract)void display(); //; <- 꼭 찍어줘야함
 *           ----------------- 자동추가
 *           ------------------------------
 *         }
 *         
 *         <상속과정>
 *         interface A
 *         class B extends A ==> 오류!!(extends 는 확장해서 사용하겠다는 의미)
 *         class B implements A ==> implements 는 구현후에 사용한다는 의미
 *         
 *         1) interface ==> interface
 *            interface A
 *            interface B( extends ) A
 *         2) interface ==> class
 *            interface A
 *            class B ( implements ) A
 *         3) class ==> interface
 *            class A
 *            interface B (  ) A =====> "오류" // 이런건 없다!!!
 *            
 *            interface A
 *            interface B extends A
 *            class C implements B ==> 단일 상속
 *            
 *            interface A
 *            interface B
 *            class C implements A,B ==> 다중 상속
 *            
 *            interface A
 *            interface B
 *            class C
 *            class D extends C implements A,B ==> 가능!!
 *            
 *            [Game : 마우스 이용, 키보드 이용, 버튼 이용, 쓰레드 이용]
 *            => class E extends JFrame implements MouseListener,KeyListener,
 *                                                 ActionListener,Runnable
 *            
 *    ------------------------------------------------
 *   (***) 클래스 여러개를 묶어서 한개의 이름으로 제어가 가능
 *    ex)                   List 
 *                           |
 *         -----------------------------------------
 *         |           |          |        |       |
 *     ArrayList   LinkedList   Vector   Queue   Stack
 *     
 *     List list=new ArrayList()
 *     list=new Vector()
 *     list=new LinkedList()
 *     list=new Queue()
 *     lint=new Stack()
 *     // 이렇게 List 하나로 다양하게 사용 가능
 *     
 *     웹에서 가장 많이 사용하는 3대 라이브러리
 *     1. String
 *     2. List
 *     3. Integer(int를 사용하기 편리하게 만든 클래스)
 *        웹/윈도우 => 모든 데이터형이 String
 *        page=1 => "1" => 1 => Wrapper
 */     
interface AA
{
	int a=10;
	void aaa();
}
interface BB
{
	int a=20;
	void bbb();
}
class CC implements AA,BB {
	// AA.a, BB.a => 클래스가 다르므로 변수명이 같아도 상관없다
	public void print() {
		System.out.println(AA.a);
		System.out.println(BB.a); // a가 static 변수이므로 클래스명을 붙여야함
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		System.out.println("BB.bbb() 구현");
	}

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		System.out.println("AA.aaa() 구현");
	}
	
}
public class 인터페이스 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CC c=new CC();
		c.print();
		c.aaa();
		c.bbb();
		
		//interface 이용
		AA aa=new CC(); // implements 도 extends와 동일하게 적용
		// 접근 가능 범위 : aaa()
		aa.aaa();
		//aa.bbb(); <- AA가 bbb를 가지고 있지 않기 때문에 aa.으로 호출 할 수 없음
		
		BB bb=new CC();
		bb.bbb();
		// 접근 가능 범위 : bbb()
		
		// AA, BB 둘다 CC 가 가지고 있는 print() 접근 불가능 => 각 클래스가 갖고 있는 것만 접근 가능
		// CC 접근 가능 범위 : aaa,bbb,print()
		// int a 는 static변수(공유변수)이므로 모두 접근이 가능하다
	}

}
