package com.sist.lib;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;
/*
 * Back => Java/JSP/Oracle/Spring
 * Front => JavaScript/TypeScript/Ajax/Vue/React
 * HTMl/CSS
 */

class A{
	public void aaa() {
		System.out.println("aaa() Call...");
	}
	public void bbb() {
		System.out.println("bbb() Call...");
	}
	public void ccc() {
		System.out.println("ccc() Call...");
	}
	public void ddd() {
		System.out.println("ddd() Call...");
	}
	public void eee() {
		System.out.println("eee() Call...");
	}
	// 4개 더 추가해도 메소드를 호출하는데에 문제 없다!!
	public void kkk() {
		System.out.println("kkk() Call...");
	}
	public void ooo() {
		System.out.println("ooo() Call...");
	}
	public void ppp() {
		System.out.println("ppp() Call...");
	}
	public void vvv() {
		System.out.println("vvv() Call...");
	}
}
public class 라이브러리_Object_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("메소드명 입력:");
		String m=scan.next();
//		A a=new A();
//		if(m.equals("aaa")) {
//			a.aaa();
//		}
//		else if(m.equals("bbb")) {
//				a.bbb();
//		}
//		else if(m.equals("ccc")) {
//			a.bbb();
//	}
//		else if(m.equals("ddd")) {
//			a.bbb();
//	}
//		else if(m.equals("eee")) {
//			a.bbb();
//	}
// 이렇게 if~else if를 사용하기 보다는 try~catch를 이용하여 코딩 해야한다.
// 최대장점!! 유지보수에 용이함 !!
		
		try {
			// 리플렉션 => 클래스이름으로 클래스 정보 읽기 => 모든 제어가 가능
			// 모든 제어란? 변수, 자동 메모리 할당, 메소드 호출, 생성자 변경...
			Class clsName=Class.forName("com.sist.lib.A");
			Object obj=clsName.getDeclaredConstructor().newInstance();
			//메소드 읽기
			
			Method[] methods=clsName.getDeclaredMethods();
			//System.out.println(Arrays.toString(methods));
			for(Method mm:methods) {
				if(m.equals(mm.getName())) {
					mm.invoke(obj, null);
					// 설명 : m이름을 가진 메소드를 호출해라
				}
			}
		}catch(Exception ex) {}
	}

}
