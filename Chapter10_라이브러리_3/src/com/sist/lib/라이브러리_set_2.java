package com.sist.lib;
import java.util.*;
class Student{
	private String name;
	private int age;
	//데이터보호 => 은닉화
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// getter/setter 해야 "캡슐화"
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (name+age).hashCode();
	}
	// 원래는 주소값으로 비교를 하는데, (name+age)로 비교하게 오버라이딩 해서
	// 다른객체인데 같은 객체로 나오는거??
	
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//		if(obj instanceof Student) {
//			Student s=(Student)obj; //형변환
//			return name.equals(s.name) && age==s.age;
//		}
//		return false;
//	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return name+"("+age+")";
//	}
	//Object에서 받은 메소드
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
public class 라이브러리_set_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 객체비교 => 메모리 주소, 실제저장된 값
		// -------- 기본은 
		Set set=new HashSet();
		Student s1=new Student("홍길동", 25);
		Student s2=new Student("홍길동", 25);
		System.out.println("s1="+s1);
		System.out.println("s2="+s2);
		if(s1.equals(s2)) {
			System.out.println("s1==s2");
		}
		else {
			System.out.println("s1!=s2");
		}
		// equals 를 주소값이 아닌 데이터값을 비교하는 것으로 재정의 해놨음
		// 그래서 재정의된 equals로 비교를 하면 s1과 s2가 같은 객체이고,
		// 기본 equals로 비교하면 s1과 s2는 다른 객체이다
		
		set.add(new Student("홍길동", 20));
		set.add(new Student("홍길동", 20));
		System.out.println(set);

	}

}
