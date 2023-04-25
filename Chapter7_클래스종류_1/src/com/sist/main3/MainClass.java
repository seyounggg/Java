package com.sist.main3;
/*
 *   인터페이스 간의 상속
 *   interface A
 *   interface B extends A
 *   
 *   interface A
 *   {
 *        void aaa();
 *   }
 *   interface B extends A
 *   {
 *        void bbb();
 *        // void aaa()
 *   }
 *   
 *   class C implements B
 *   {
 *        public void aaa(){}
 *        public void bbb(){}
 *        // B가 aaa도 상속을 받아왔기 때문에 aaa도 구현을 해줘야한다
 *   }
 */
interface A
{
	
}
interface B extends A // 크기 : A > B
{
	
}
class C implements B // 크기 : C < B => interface 도 클래스와 동일하다.(클래스 내리는 쪽이 더 크다)
{
	
}
// 클래스와 인터페이스의 차이는 상속이 단일만 가능한지 다중상속도 가능한지이다
// 클래스 = 단일상속 , 인터페이스는 다중상속 가능
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new C(); // C안에 A가 포함되어 있으니까 가능
		B b=new C();
		C c=new C(); // -> 한번에 다 처리가 가능하므로 c 가 가장 편하다
		
		/*if(c instanceof A)
			// c객체는 A에 포함인건지?_ C < A = true
			System.out.println("OK");
		if(c instanceof B) // C < B = true
			System.out.println("OK2");
		if(b instanceof A) // B < A = true
			System.out.println("OK3");
		if(a instanceof C) // A == C
			System.out.println("OK4"); 
		if(a instanceof B) // A<B
			System.out.println("OK5");*/
		
		String s="";
		StringBuffer sb=new StringBuffer();
		Object o=new Object();
		if(s instanceof Object)
			System.out.println("OK");
		if(sb instanceof Object)
			System.out.println("OK2");
		if(o instanceof String) // o<String? = false
			System.out.println("OK3");
		
		// instanceof 는 객체크기 비교
		// 오른쪽 클래스가 크거나 같으면 true , 반대면 false!!
		//if(s instanceof StringBuffer) => 오류!!(상속, 포함관계가 아니라서)
		// 상속 또는 포함 관계가 아닌 경우에는 크기를 베교할 수 없다
	}

}
