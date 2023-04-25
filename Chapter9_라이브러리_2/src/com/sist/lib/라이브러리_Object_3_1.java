package com.sist.lib;
class Sawon2 {
	private int sabun;
	private String name;
	
	//초기화
	//생성자는 한번만! 값 변경은 getter/setter 이용
	public Sawon2(int sabun, String name) {
		this.sabun=sabun;
		this.name=name;
	}
	
	//private 변수값을 자유롭게 변경하기 위해 getter/setter
	//하나의 메모리 안에서 값을 변경하기 위함
	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//equals 오버라이딩
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student2) {
			Sawon2 s=(Sawon2)obj; // 리턴값이 Object 이므로 Sawon2로 형변환을 먼저 진행해야한다
			return name==s.name; //문자열 비교
		}
		else
			return false;
	}
	/*
	 * 1)
	 * String s="Hello";
	 * s.length();
	 * 
	 * 2)
	 * "Hello".length();
	 * 
	 * 1)과 2)는 같은 기능이다
	 */
}
public class 라이브러리_Object_3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon2 s1=new Sawon2(1, "홍길동");
		Sawon2 s2=new Sawon2(1, "홍길동");
		// s1에 new Sawon2(1,"홍길동") 을 대입한거니까 두개가 같은 거다
		// 예) int a=10; 이런 느낌으로 기억하자
		
		if(s1.equals(s2)) {
			System.out.println("같은 사원입니다");
		}
		else {
			System.out.println("다른 사원입니다");
		}
		/*
		 * 출력내용 : 다른 사원입니다
		 * 이유 : equals를 재정의(오버라이딩)하지 않으면 주소값을 비교하는 == 와 기능이 같기 때문이다
		 */
		
		//재정의
		/*
		 * 1)
		 * @Override
			public boolean equals(Object obj) {
				// 리턴값이 Object 이므로 Sawon2로 형변환을 먼저 진행해야한다
				Sawon2 s=(Sawon2)obj;
				return name.equals(s.name) && sabun==s.sabun;
		 *	출력내용 : 같은 사원입니다
		 *
		 * 2)
		 * @Override
			public boolean equals(Object obj) {
				if(obj instanceof Student2) {
					Sawon2 s=(Sawon2)obj; // 리턴값이 Object 이므로 Sawon2로 형변환을 먼저 진행해야한다
					return name==s.name; //문자열 비교
				}
				else
					return false;
			}
		 * 1) 과 2) 모두 같은 방법이다
		 * 
		 * << 형변환 >>
		 * Sawon2 s=(Sawon2)obj; <- 먼저 obj를 sawon2로 형변환 시키는 방법
		 * ((Sawon2)obj).name <- obj를 sawon2로 형변환 하면서 name값 가져오는 방법// 괄호로 우선순위 설정 필수!!
		 */
	}

}
