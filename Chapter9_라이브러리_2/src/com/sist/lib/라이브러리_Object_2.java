package com.sist.lib;
// toString() : 객체를 문자열화 시킨다
/*
 *   <문자열 변환>
 *    (String)
 *    .toString()
 *    
 *    class A {
 *    }
 *    A a=new A();
 *    1) 명시적 : System.out.println(a.toString()) => a의 주소값을 출력
 *    2) 묵시적 : System.out.println(a) // 뒤에 .toString이 숨겨져 있는 것
 *    
 */
class Member {
	private int mno;
	private String name;
	
	public Member(int m,String n) {
		mno=m;
		name=n;
		//멤버변수명과 지역변수명이 다르므로(충돌되지 않으므로), this. 을 생략해도 된다
		//순서 : 지역변수, 매개변수를 찾는다 -> 없는 경우 멤버변수를 찾는다
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "회원번호:"+mno+",이름:"+name;
	}
	// 원래 toString을 호출하면 주소값이 나왔는데,
	// return값을 <"회원번호:"+mno+",이름:"+name>로 변경하므로서 오버라이딩 시킴
	
}
// 객체를 문자열로 변환
public class 라이브러리_Object_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m1=new Member(1, "박문수");
		Member m2=new Member(2, "심청이");
		
		System.out.println("묵시적 호출 m1:"+m1);
		System.out.println("명시적 호출 m1:"+m1.toString());
		
		System.out.println("묵시적 호출 m2:"+m2);
		System.out.println("명시적 호출 m2:"+m2.toString());
	}

}
