package com.sist.string;
// 라이브러리 공부 순서 => 1) 기능 2) 리턴형 3) 매개변수 4) 사용처
/*
 *   책 305page
 *    
 *   String : 문자열을 조작하고 처리하는 기능
 *          = String은 클래스, 일반 데이터형으로 취급
 *          => 모든 클래스는 Call By Reference가 가능한데,
 *             String은 Call By Value만 가능하다
 *          
 *             #일반적으로
 *             A a=new A();
 *             A b=a; // a와 b가 같은 주소를 제어한다 => 참조형
 *          
 *             #String은
 *             String s="Hello";
 *             String s1=s; // 이럴 경우에 s1을 변경한다고 해도 s값은 변경사항이 없다
 *          
 *          = 메모리 할당(저장)
 *            String s="Hello";
 *            String s=new String("Hello");
 *      (***) 문자열은 자체가 주소이다
 *            => 같은 문자열이면 같은 주소를 갖는다
 *            => new를 이용해서 생성을 할 경우에는 다른 주소로 저장이 된다
 *            
 *            #대체적으로
 *            String s="Hello"; 형식을 많이 사용한다
 */
public class 라이브러리_String_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="Hello";
		String s2="Hello";
		// s1과 s2는 같은 메모리 주소에 저장이 되어있다
		String s3=new String("Hello");
		String s4=new String("Hello");
		// s3는 새로운 메모리 주소에 저장되어 있다 _ new를 사용하면 다른 메모리 주소를 가진다
		// String => 저장은 주소를 저장하고 있다 ?? 이게 무슨말...?
		// char[] => 쉽게 사용이 가능하게 만들어 준다
		
		if(s1==s2) { // 같은 곳에 저장이 되어 있는지 확인(메모리 주소 확인)
			System.out.println("s1과 s2는 같다");
		}
		else {
			System.out.println("s1과 s2는 같지않다");
		}
		
		// 실제 저장된 데이터값이 같은지 확인한다 : equals
		// s1에 저장된 데이터값과 s3에 저장된 데이터값이 같은지 확인
		if(s1.equals(s3)) {
			System.out.println("s1과 s3는 같은 값을 가지고 있다");
		}
		else {
			System.out.println("s1과 s3는 다른 값을 가지고 있다");
		}
		
		//308page 예제(문자열 결합)
		String ss="Hello";
		String ss1="Java!!";
		String ss2=ss+ss1; // ss와 ss1이 결합하면서 새로운 메모리 주소가 생성
		System.out.println(ss2); 
	}

}
