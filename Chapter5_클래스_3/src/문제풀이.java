/*
 * method (책 140page)
 * 1) 메소드 형식 => 기능 처리
 *    --------
 *      웹 => 화면 변경
 *      ------------ 메뉴 클릭, 버튼 클릭, 이미지 클릭...
 *      검색, 글쓰기, 수정, 회원가입, 회원탈퇴...
 *      사용자의 동작과 관련
 *        
 *   = 리턴타입(리턴형)
 *     처리 후 결과값 한개만 전송이 가능하다
 *     (*) 여러개인 경우 : 배열, 클래스
 *     (*) 한개인 경우 : 기본형, String
 *     1) 결과값이 있는 경우
 *        리턴형 메소드명(매개변수...)
 *        {
 *             return 값;
 *        }
 *        예) 
 *           int method()
 *           {
 *                return 10.5; => 오류 발생  -> return (int)10.5;는 가능(형변환)
 *           }
 *           _호출 : int a=method();
 *        예)
 *           int[] method()
 *           {
 *              int[] arr={1,2,3,4,5,6,7,8};
 *              return arr; <- 배열은 주소값만 넘겨준다.
 *           }
 *       
 *       2) 결과값이 없는 경우(return이 없는 경우)
 *          void method()
 *          {
 *             return; // 생략 시 컴파일러가 자동으로 return 추가
 *          }
 *          _호출 : method();
 * 
 * ------------------------------------------
 * import java.lang.* => import가 자동으로 추가
 *          system
 *          String
 *          Math
 * -------------------------------------------        
 *   = 메소드명 => 식별자와 동일 / 글자수의 제한이 없다 _ 의미부여 / 
 *   = 매개변수 => 사용자 요청값
 */

import java.util.Scanner;
public class 문제풀이 {
	//process1 : 정수를 입력받아서 이진법을 출력하는 메소드 작성
	/*
	 * 1. 정수입력
	 * 2. 이진법 처리
	 * 3. 출력
	 */
	static void process1()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("0~32767까지의 정수 입력 :");
		int num=scan.nextInt();
		// api활용 -> System.out.println(Integer.toBinaryString(num));
		int[] binary=new int[16];
		int index=15; // 맨 뒤에서부터 나누고 나머지 값을 넣어야해
		while(true)
		{
			binary[index]=num%2;
			num=num/2;
			if(num==0)
				break;
			index--;
		}
		for(int i=0;i<binary.length;i++)
		{
			if(i%4==0 && i!=0)
				System.out.print(" ");
			System.out.print(binary[i]);
		}
	}
	
	//process2 : 임의의 정수를 배열로 생성해서 입력하고 정렬하는 프로그램 작성
	/*
	 * 1. 임의의 정수 입력(배열 생성 후)
	 * 2. 정렬처리
	 * 3. 출력
	 */
	static void process2()
	{
		// select sort(v)
		// 버블 sort
		// api sort Arrays.sort()
	}
	
	//process3 : 년도를 입력받아 윤년여부를 확인하는프로그램 작성
	/*
	 * 1. 년도 입력
	 * 2. 윤년 처리
	 * 3. 출력
	 */
	static void process3()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("년도입력:");
		int year=scan.nextInt();
		if((year%4==0 && year%100!=0) || (year%400==0))
			System.out.println(year+"년은 윤년입니다.");
		else
			System.out.println(year+"년은 윤년이 아닙니다.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process1();
	}

}