
/*
 * [데이터를 묶어서 관리]
 * 변수     연산자     메소드     출력
 * ---     --------------    ----
 *  |            |             |
 * 배열          명령문       Application
 * 클래스        -----       -----------
 *              메소드        web Application
 * -----------------------------------------
 * 
 * [클래스]
 *    1) 메소드
 *      = 사용자 정의
 *      = 라이브러리(암기) => 리턴형 / 매개변수 / 기능
 *    2) 변수(멤버) => 프로그램 종료시까지 메모리 유지
 *    3) 생성자
 *    -------------------------------------------
 *    객체 지향 프로그램 : 유지보수 (데이터보호(캡슐화), 재사용(상속/포함), 수정, 추가)
 *                                                          --------- 오버라이딩/오버로딩
 *    4) 비정상 종료를 방지하는 프로그램 : 견고한 => 예외처리
 *    -------------------------------------------- 8장(기본)
 *    5) 자바에서 지원하는 라이브러리 => 조립식
 *    --------------------------------------------
 *    *핵심* 오라클 연결 => 웹
 *    *핵심* 브라우저 연결
 *    -------------------- 위 2개를 통합 => (Spring)
 */
//연도를 입력 받아서 윤년여부 확인
/*
 *   메소드 안에서 출력 ===> void
 *   결과값을 받아서 출력 ==> boolean
 *   --------------------------- 리턴형으로 결정!
 *   매개변수 ==> 년도 
 */
import java.util.Scanner;
public class 메소드_1 {
	static void isYear(int year) 
	{
		if((year%4==0 && year%100!=0)||(year%400==0))
		{
			System.out.println(year+"년도는 윤년입니다.");
		}
		else
			System.out.println(year+"년도는 윤년이 아닙니다.");
	}
	
	static void process()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력:");
		int year=scan.nextInt();
		//메소드 호출
		//isYear(year);
		//호출시에는 실제 데이터값을 전송
		boolean bCheck=isYear2(year);
		if(bCheck==true)
			System.out.println(year+"년도는 윤년입니다.");
		else
			System.out.println(year+"년도는 윤년이 아닙니다.");
	}
	
	static boolean isYear2(int year)
	{
		boolean bCheck=false; // default 값으로 false를 썼기때문에 else 필요 없
		if((year%4==0 && year%100!=0)||(year%400==0))
			bCheck=true;
		return bCheck;
	}
	public static void main(String[] args) {
		
		process();
		

	}

}