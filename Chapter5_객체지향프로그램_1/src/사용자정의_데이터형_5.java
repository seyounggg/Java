import java.util.Scanner;
class Sawon {
	//---------------
	int sabun;
	String name;
	String dept;// 부서
	String job;// 직위
	String loc;// 근무
	long pay;// 연봉
	//--------------- 여기까지 인스턴스 변수(클래스가 메모리에 저장)
	static String company; // static을 사용하여 저장공간을 별도의 1개만 만들어서, 저장공간을 공유함.
	// -------------- 메모리 공간이 1개만 설정 => 컴파일러에 의해 자동 생성 / new가 없어도 사용 가능
}
public class 사용자정의_데이터형_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon.company="kkk";
		// 클래스변수명.변수명 ==> hong.company
		// 클래스명.변수명 ==> Sawon.company
		// 공유변수, 클래스변수(클래스명으로 접근이 가능)
		// 인스턴스변수 => 인스턴스명.변수
		
		Sawon hong=new Sawon();
		// new를 썼을 때 ==> 5개를 저장하는 공간을 생성
		/*
		hong.sabun=1;
		hong.name="홍길동";
		hong.dept="개발부";
		hong.job="대리";
		hong.loc="서울";
		hong.pay=4500;
		hong.company="ABC";
		*/
		
		Sawon shim=new Sawon();
		// new를 썼을 때 ==> 5개를 저장하는 공간을 생성
		shim.sabun=1;
		shim.name="심청이";
		shim.dept="개발부";
		shim.job="사원";
		shim.loc="서울";
		shim.pay=3300;
		shim.company="ABC";
		
		Sawon park=new Sawon();
		// new를 썼을 때 ==> 5개를 저장하는 공간을 생성
		park.sabun=1;
		park.name="박문수";
		park.dept="개발부";
		park.job="과장";
		park.loc="서울";
		park.pay=6200;
		park.company="ABC";
		
//		hong.company="BCD";
//		shim.company="CDE";
//		park.company="DEF";
		System.out.println("회사명:"+hong.company);
		System.out.println("회사명:"+shim.company);
		System.out.println("회사명:"+park.company);
		// ABC 회사가 망했다 => 회사명변경 => BCD
		hong.loc="부산";
		System.out.println("근무지:"+hong.loc);
		System.out.println("근무지:"+shim.loc);
		System.out.println("근무지:"+park.loc);
	}

}