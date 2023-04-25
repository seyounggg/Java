package com.sist.main2;
//캡슐화 만들기
/*
 * => 데이터 보호
 * => 데이터를 은닉화(private)/메소드를 통해서 접근이 가능(다른 클래스 연결 => public)
 */
// 사용자 정의 데이터형 => 필요에 의해서 데이터를 묶어서 관리
// 사용자 정의 데이터형 => ~VO
class SutdaCard {
	private int num;
	private boolean isKwang;
	// getter => 읽기
	// setter => 저장
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public boolean isKwang() {
		return isKwang;
	}
	public void setKwang(boolean isKwang) {
		this.isKwang = isKwang;
	}
}

//Student 클래스 정의
class Student123 {
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
}

// 다음 코드에 정의된 변수들을 종류별로 구분해서 적으시오
class PlayingCard {
	int kind;
	int num;
	static int width;
	static int height;
	PlayingCard(int k, int n) {
		kind=k;
		num=n;
	}
}
/*
 * 인스턴스 변수_ 데이터 각각 저장시에 사용 : kind, num
 * 정적변수(공유변수)_ 공통으로 사용되는 변수_ 메모리가 한개만 생성된다 : width, height
 * -------------------------------------------------------------------- 프로그램 종료시까지 메모리 유지(자동 초기화)
 * 지역변수_ 메소드에서 선언되는 변수_ 지역변수,매개변수_ 메소드 블록 벗어나면 사라진다_ 반드시 초기화 후에 사용 : k, n
 */

/*
 * 다음중 생성자에 대한 설명으로 옳지 않은 것은?
 * 1) 모든 생성자의 이름은 클래스명과 동일하다
 * 2) 생성자는 객체를 생성하기 위한 것이다 (X) => new
 * 3) 클래스에는 생성자를 반드시 하나 이상 있어야 한다 (X) => 없어도 상관 없다
 * 4) 생성자가 없는 클래스는 컴파일러가 자동으로 기본 생성자를 추가한다
 * 5) 생성자는 오버로딩을 할 수 있다
 *           ----- 같은 이름의 메소드를 여러개 만들어서 사용
 */
/*
 * 다음 중 this에 대한 설명으로 맞지 않은 것은?
 * this?
 * 1) 모든 클래스는 this를 가지고 있다
 * 2) 객체 자신을 가리키는 참조변수(static Object this) => new
 *    => this는 생성자, 인스턴스 메소드에서 사용이 가능
 * 3) 클래스 내에서는 어디서든 사용이 가능하다 (X) static에서는 사용할 수 없음
 * 4) 지역변수와 인스턴스 변수를 구분할 때 사용한다
 * 5) 클래스 메소드내에서는 사용할 수 없다
 *    인스턴스메소드, 객체메소드
 *    ~~> 객체명.메소드
 *    정적메소드, 공유메소드, 클래스메소드
 * 	  ~~> 클래스명.메소드
 */
// 다음 중 오버로딩이 성립하기 위한 조건이 아닌 것은?
// 오버로딩의 조건
/*
 * 1. (메소드) 이름이 같아야 한다 // 한개의 이름으로 여러개의 새로운 기능을 추가
 * 2. (매개변수) 의 개수 또는 타입이 달라야 한다
 * 3. 리턴형은 관계 없다
 * 4. 매개변수는 같고 (매개변수의 이름)이 다른 경우는 오버로딩이 성립되지 않는다 //
 */
/*
 *  다음 중 아래의 add메소드를 올바르게 오버로딩 한 것은? b,c,d
 *  long add(int a, int b) { return a+b; }
 *  
	a. long add(int x, int y) { return x+y; }        add(int,int)
	b. long add(long a, long b) { return a+b; }      add(long,long)
	c. int add(byte a, byte b) { return a+b; }       add(byte,byte)
	d. int add(long a, int b) { return (int)(a+b); } add(long,int)
 */
/*
 * 다음 중 초기화에 대한 설명으로 옳지 않은 것은?
	a. 멤버변수는 자동 초기화되므로 초기화하지 않고도 값을 참고할 수 있다.
	   ** -----인스턴스변수,정적변수 => 자동 초기화
	   ** int => 0 / double=> 0.0 / boolean=> false / String => null(클래스,배열) ..null : 참조하는 주소가 없는 경우
	b. 지역변수는 사용하기 전에 반드시 초기화해야 한다.
	   ** 지역변수는 초기화가 안된다(반드시 초기화 후에 사용)
	c. 초기화 블럭보다 생성자가 먼저 수행된다.(X)
	   ** 명시적인 초기화 => 초기화 블록 => 생성자
	   *                  -클래스변수 => 인스턴스변수
	d. 명시적 초기화를 제일 우선적으로 고려해야 한다.
	e. 클래스변수보다 인스턴스변수가 먼저 초기화된다.(X)
	   ------- 컴파일시, new
 */
/* 다음 중 인스턴스변수의 초기화 순서가 올바른 것은? a. 기본값 -> 명시적 초기화 -> 초기화블럭 -> 생성자
	a. 기본값-명시적초기화-초기화블럭-생성자
	                   -> static => instance
	b. 기본값-명시적초기화-생성자-초기화블럭
	c. 기본값-초기화블럭-명시적초기화-생성자
	d. 기본값-초기화블럭-생성자-명시적초기화
 */
/* 다음 중 지역변수에 대한 설명으로 옳지 않은 것은? 
	a. 자동 초기화되므로 별도의 초기화가 필요없다.(X) // 초기화를 해야한다
	b. 지역변수가 선언된 메서드가 종료되면 지역변수도 함께 소멸된다.
	c. 메서드의 매개변수로 선언된 변수도 지역변수이다.
	d. 클래스변수나 인스턴스변수보다 메모리 부담이 적다. (X) // 클수도 있다
	e. 힙(heap)영역에 생성되며 가비지 컬렉터에 의해 소멸된다. (X) stack영
 */
/*
 * 다음 중 접근제어자를 접근범위가 넓은 것에서 좁은 것의 순으로 바르게 나열한 것은?
	a. public-protected-(default)-private (O)
	b. public-(default)-protected-private
	c. (default)-public-protected-private
	d. private-protected-(default)-public
	
	접근 제어자가 사용될 수 있는 곳 - 클래스, 멤버변수, 메서드, 생성자
	(private) - 같은 클래스 내에서만 접근이 가능하다.
	(default) - 같은 패키지 내에서만 접근이 가능하다.
	(protected) - 같은 패키지 내에서, 그리고 다른 패키지의 자손클래스에서 접근이 가능하다.
	(public) - 접근 제한이 전혀 없다.
 */
/*
 * 다음 중 접근 제어자에 대한 설명으로 옳지 않은 것은? c
	a. public은 접근제한이 전혀 없는 접근 제어자이다.
	b. (default)가 붙으면, 같은 패키지 내에서만 접근이 가능하다.
	c. 지역변수에도 접근 제어자를 사용할 수 있다. (x)
	   ------ 지역변수는 static, 접근지정어, abstract 는 사용이 불가능하다
	          지역변수 중에 유일하게 사용 가능 : final
	d. protected가 붙으면, 같은 패키지 내에서도 접근이 가능하다.
	e. protected가 붙으면, 다른 패키지의 자손 클래스에서 접근이 가능하다.

 */
class A {
	int a=10;
	static int b=20;
	{
		a=100;
		System.out.println("a="+a);
	}
	static
	{
		b=200;
		System.out.println("b="+b);
	}
	A(){
		a=1000;
		b=2000;
		System.out.println("a="+a+",b="+b);
	}
}
public class 문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		
	}

}
