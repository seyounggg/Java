package com.sist.lib;
//equals => Object에서는 객체비교 / String에서는 문자열
class Student2{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Student2(String name) {
		this.name=name;
	}
	
	//Object 에서의 equals는 반드시 오버라이딩 하여 사용해야하므로 사용빈도가 많지는 않다
	//String ... equals가 재정의 되어 있다
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Student2)
			return name==((Student2)obj).name;
		else
			return false;
	}
	public void print() {
		System.out.println("이름:"+name);
	}
	
}
// == (객체=>주소) , equals (객체가 가지고 있는 변수값 비교)
public class 라이브러리_Object_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student2 s1=new Student2("홍길동");
		Student2 s2=new Student2("홍길동");
		
		System.out.println("s1="+s1);
		System.out.println("s2="+s2);

		if(s1==s2) {
			System.out.println("s1과 s2는 같다");
		}
		else {
			System.out.println("s1과 s2는 같지 않다");
		}
		/*
		 * 객체비교에서 == 은 주소값을 비교하는 것이다
		 * s1=com.sist.lib.Student2@66133adc
		 * s2=com.sist.lib.Student2@7bfcd12c
		 * 따라서, s1과 s2는 주소값이 다르므로 else 값이 나오게 된다
		 */
		
		// 주소 => default(=> 주소값 비교)
		if(s1.equals(s2)) {
			System.out.println("s1과 s2는 같다");
		}
		else {
			System.out.println("s1과 s2는 같지 않다");
		}
		s1.print();
		new Student2("홍길동").print();
		
		// 재정의
		/*
		 * @Override
			public boolean equals(Object obj) {
				// TODO Auto-generated method stub
				if(obj instanceof Student2)
					return name==((Student2)obj).name; => 자주 사용하는 형변환(기억 잘해야해!!)
					             --------------- 괄호를 치는 이유는 <.name> 이 우선순위 이므로
					                             obj를 Student2로 형변환을 먼저 할 수 있도록 괄호를 쳐줘야 한다
					                             그래야 Student2에 있는 name값을 가져올 수 있다
				else
					return false;
           
           ==> equals 메소드의 default인 주소값 비교를 오버라이딩 하여 사용
               재정의(오버라이딩)하지 않으면 == 과 동일한 기능을 수행한다
		 */
		
	}

}
