package com.sist.main;
/*
 *  멤버변수의 초기화
 *    1. default 값
 *       int  => 0, String => null, boolean => false...
 *       class A {
 *         int a;
 *       }
 *    2. 명시적인 초기화 : 직접 값을 설정
 *       class A {
 *          int a=10;
 *       }
 *    3. 생성자를 통한 초기화
 *       class A {
 *          int a;
 *          A(){
 *             a=10;
 *          }
 *       }
 *    4. 초기화 블록
 *       class A {
 *       int a;
 *       // a=1000;
 *       {
 *          a=1000;
 *       }
 *    }
 *    
 *    디폴트 -> 명시적 -> 초기화 블록 -> 생성자
 *    int a=0 int a=10 int a=100   int a=1000
 */
/*class Student{
	int hakbun=10;
	String name;
	{
		hakbun=100; // 연산처리, 제어문, 파일읽기 ...
	}
	
	Student() {
		hakbun=1000;
	}
	
}*/
// 디폴트 생성자는 생성자가 아예 없는 상태에만 호출이 가능하고, 생성자가 하나라도 있을 경우에는 디폴트생성자를 호출 할 수 없음.

class Student {
	int hakbun;
	String name;
	Student(){ // 단점 : 값을 하나밖에 입력하지 못한다...
		System.out.println("Student() call...");
		hakbun=1;
		name="홍길동";
	}
	Student(int h,String n){ // 매개변수가 있는 생성자
		hakbun=h;
		name=n;
	}
}
public class 생성자_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s=new Student();
		System.out.println(s.hakbun);
		System.out.println(s.name);
		// 생성자 호출 new를 앞에 붙여서 호출한다
		//new Student();
		Student s1=new Student();
		System.out.println(s1.hakbun);
		System.out.println(s1.name);
		// 위의 s와 s1은 같은 값을 가지고 가는 것
		
		Student s2=new Student(2,"심청이"); // 초기값을 여기서 지정하므로 아래 s3과 다른 초기값을 설정할 수 있다
		System.out.println(s2.hakbun);
		System.out.println(s2.name);
		Student s3=new Student(3,"박문수");
		System.out.println(s3.hakbun);
		System.out.println(s3.name);
		
	}

}