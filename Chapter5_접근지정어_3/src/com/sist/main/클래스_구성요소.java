package com.sist.main;
/*
 * 1. 클래스 구성요소
 * class ClassName
 * {
 *  --------------------------------------------------------------
 *  변수(멤버변수)
 *  1) 멤버변수(인스턴스)
 *     [접근지정어] 데이터형 변수명; // 어느 클래스까지 사용이 가능한지 설정
 *     => new를 사용시 마다 메모리가 따로 생성되는 변수
 *     => new를 이용해서 반드시 메모리를 만들고 사용해야 된다
 *     => 자동 초기화가 된다
 *        기본형
 *           int => 0
 *           long => 0L
 *           double => 0.0
 *           boolean => false
 *        참조형 : 배열, 클래스 => 메모리 주소를 참조해서 저장된 모든 데이터를 관리
 *                         ** 배열은 같은 크기의 데이터만 관리
 *                            사과박스, 배박스...
 *                         ** 클래스는 다른 크기의 데이터 관리
 *                            종합과일세트 ...
 *                         ** 초기화는 null(주소가 배정되지 않은 상태)
 *                         
 *  2) 정적변수(공유변수) : 메모리 공간을 한개만 생성 => 모든 객체가 공유
 *     [접근지정어] static 데이터형 변수명;
 *     => 데이터형으로는 기본형, 배열, 클래스가 될 수 있다
 *     => new를 사용하지 않아도 컴파일러에 의해서 자동으로 메모리 저장
 *  
 *  3) 변수 사용 방법
 *     인스턴스 변수 => 반드시 메모리에 저장을 해야한다
 *        class A {
 *           int aa;   => A a=new A(); => a.aa=100;
 *        }                              - 객체(인스턴스)를 통해서 접근해야 된다
 *     정적 변수
 *        class A {
 *           static int a;  => 메미로 할당을 하지 않아도 된다 => A.a(클래스 명으로 접근이 가능)
 *        }                                             - 클래스 변수, 공유변수
 *     ** 보안 중심
 *        1) 모든 멤버변수는 private 데이터를 은닉화
 *     ** 멤버변수는 사용이 가능한 옵션 : static, final(상수)
 *  --------------------------------------------------------------
 *  생성자
 *   1. 특징
 *      1) 생성자는 클래스명과 동일
 *      2) 생성자는 리턴형을 가지고 있지 않다
 *      3) 오버로딩 지원(중복메소드 중복) => 생성자는 필요시 여러개 만들 수 있다
 *         *** 생성자를 만들지 않는 경우 (컴파일러가 자동으로 default 생성자를 만들어 준다)
 *         오버로딩 => 같은 메소드명으로 여러개의 기능을 만들어서 사용
 *                = 메소드명이 동일
 *                = 매개변수의 갯수나 데이터형이 다르다
 *                   // int a, int b처럼 데이터형은 같으면서 변수명이 다르다고 오버로딩이 되진 않음
 *                = 한개의 클래스 안에서 제작
 *                = 리턴형은 관계 없다
 *                
 *              오버로딩의 예) plus 이름 하나로!! 만들어 버리면 돼~!
 *                 plusInt(int a,int b)             ->    plus(int a,int b)     
 *                 plusDouble(double d1,double d2)  ->    plus(double d1,double d2)
 *                 plusString(String s1,String s2)  ->    plus(String s1,String s2)
 *                 plusChar(char c1,char c2)        ->    plus(char c1,char c2)
 *                 plusByte(byte b1,byte b2)        ->    plus(byte b1,byte b2)
 *                 plusIntDouble(int a,double d)    ->    plus(int a,double d)
 *                 plusCharInt(char c,int a)        ->    plus(char c,int a)
 *                 plusStringInt(String s,int a)    ->    plus(String s,int a)
 * 
 *   2. 역할
 *      = 객체 생성시에는 호출되는 메소드
 *        생성자 호출시에는 반드시 new 생성자()
 *      = 멤버변수의 초기화
 *        - 외부에서 데이터를 읽어서 초기화(구현)
 *        *** 초기화
 *        1) 명시적 초기화
 *           class A {
 *              int a=10;
 *              static int b=20;
 *           }
 *        2) 초기화 블록 : 멤버변수, static변수 초기화가 가능
 *           => this 사용 가능
 *           class A{
 *              int a;
 *              { => 인스턴스 초기화 블록
 *                 for(int i=0;i<10;i++) {
 *                      a=i;
 *                 } // 구현해야하는 내용이있으면 {} 블럭 사용
 *              }
 *           }
 *        3) static 초기화 블록 : static변수만 가능
 *           => this 사용 불가능
 *           class A {
 *           	static int b;
 *           	static {
 *                 for(int i=0;i<10;i++) {
 *                    b=i;
 *                 }
 *              }
 *           }
 *        4) 생성자 : 멤버변수, static변수 초기화가 가능
 *           => this 사용 가능
 *           class A {
 *              int a;
 *              A() {
 *                 for(int i=0;i<10;i++) {
 *                    a=i;
 *                 }
 *              }
 *           }
 *       ** 인스턴스변수는 생성자를 주로 이용한다
 *       ** static변수는 생성자보다 static블록을 많이 사용한다
 *       ** 생성자는 반드시 필요시 마다 호출
 *          초기화 블록은 자동 호출
 *         [초기화 순서]
 *         명시적 초기화 -> static 블록 -> 인스턴스 블록 -> 생성자
 *         => 초기화 (1. 윈도우, 2. 네트워크, 3. 파일읽기, 4. 데이터베이스 연결)
 *         => 오버로딩을 지원
 *            ------ 생성자 여러개 사용 가능
 *            class A {
 *               this() => 자신의 생성자 호출시 사용
 *               A() {
 *                 
 *                  => 기본생성자 => 생성자가 존재하지 않는 경우 자동 생성된다
 *               } 
 *               this(10) ---> A(10)
 *               A(int a) {
 *                  => 다른 생성자 호출이 가능
 *                  this() : 생성자 블록 첫 줄에만 사용이 가능하다
 *                  => 초기값을 주기 위해서 사용자로부터 데이터값을 받는다
 *               } 
 *               
 *               this(10,"") ---> A(10,"")
 *               A(int a,String n) {
 *                  => 초기값을 주기 위해서 사용자로부터 데이터값을 받는다 
 *               }
 *            }
 *            
 *            1) void display(int a,int b,int c)
 *            2) void display(int a,double d,int c)
 *            3) void display(int a,int b,float f)
 *            4) void display(double a,double b,double c)
 *            
 *            => display(10.5,10,'c')
 *                      double,int,char  => 4번이 호출됨
 *            this() => 생성자 호출(자신의 생성자)
 *            this => 자신의 객체
 *            ----
 *               구분자 => 지역변수와 멤버변수가 같은 경우에 구분
 *               class A {
 *                  int a;
 *                  void disp(int a) {
 *                     //a를 사용하면  => 매개변수값만 사용이 가능
 *                  }
 *               }
 *               
 *             => 멤버메소드(stiatc이 아닌 메소드)
 *                => 모든 멤버변수, static 변수, 메소드 사용이 가능 
 *  --------------------------------------------------------------
 *  메소드 : 다른 클래스와 연결 담당(메세지)
 *         멤버변수에 대한 제어
 *         반복제어, 재사용, 수정 ...
 *                ----------
 *                 한가지 기능만 수행이 가능하게 만든다
 *         메소드는 호출시에 처음부터 끝까지 수행한다 => 호출한 위치로 돌아간다
 *         웹에서는 동작하는 부분이 메소드이다
 *                --- > 메뉴, 버튼, 이미지를 클릭한다, 입력하고 엔터친다 등...
 *     멤버메소드
	 *     [접근지정어] 리턴타입 메소드명(매개변수 목록) <- 선언부
	 *     {
	 *               구현부
	 *     }
 *     공유메소드
	 *     [접근지정어] static 리턴타입 메소드명(매개변수 목록) <- 선언부
	 *     static [접근지정어] 리턴타입 메소드명(매개변수 목록) <- 선언부 --둘다 가능
	 *     {
	 *               구현부
	 *     }
 *     메소드 호출
 *        멤버메소드
 *           클래스 객체명=new 생성자();
 *           객체명.메소드()
 *        공유메소드
 *           클래스명.메소드()
 *     메소드 유형
 *        리턴타입  매개변수
 *        ------  ------> 여러개 있는 경우도 있다(최소화한다)
 *        -> 한개만 사용이 가능(결과값이 많은 경우=> 클래스,배열)
 *           O       O
 *           O       X
 *           X       O
 *           X       X
 *        예) 
 *           사용자 로그인 요청
 *           boolean ==> String id,String pwd
 *           plus : 사용자는 두개의 정수 => 결과값은 더한 값
 *           검색  : 사용자는 검색어를 보낸다 => 결과값은 찾은 모든 내용
 *           ----------------------------------------------
 *                 String[] find(String findData)
 *           상세 => 한개만 찾는다(번호)
 *                Movie[] detail(int 영화번호)
 *  --------------------------------------------------------------
 *  }
 */
/*class C {
	int a=10;
}
class B extends C{
	int a=20;
	void display(int a) {
		System.out.println(a);
		System.out.println(this.a); // 지역변수와 충돌되지 않으려면 this.를 붙여줘야한다
		System.out.println(super.a); // class C에 있는 int a 를 불러올때
	}
}*/
class C {
	int a=10;
	int b=20;
	static int c=30;
}
class B extends C{
	int a=20; // <-오버라이딩
	int aaa=20;
	void display(int aa) {
		
		System.out.println(aa);
		System.out.println(a);
		// 지역변수가 없으면 멤버변수를 찾는다
	}
	void aaa() {
		
	}// Bㅡㄹ래스가 소유하고 있는게 아니라 공유 목적이다
	static void bbb() {
		B a=new B(); // static 메모리 할당 먼저!
		a.aaa();
		a.display(10);
	}
}

class A {
	int a=10;
	static int b=20;
	{
		System.out.println("인스턴스 초기화 블록(변경전): a ="+a);
		a=100;
		System.out.println("인스턴스 초기화 블록(변경후): a ="+a);
	}
	static
	{
		System.out.println("static 초기화 블록(변경전): b ="+b);
		b=100;
		System.out.println("static 초기화 블록(변경후): b ="+b);
	}
	A() {
		System.out.println("인스턴스 생성자 블록(변경전): a ="+a);
		a=1000;
		System.out.println("인스턴스 생성자 블록(변경후): a ="+a);
		
		System.out.println("static 생성자 블록(변경전): b ="+b);
		b=2000;
		System.out.println("static 생성자 블록(변경후): b ="+b);
	}
}
public class 클래스_구성요소 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aa=new A();
		System.out.println(aa.a);
		System.out.println(A.b);
	}

}