/*
 * 클래스 구성 요소
 * --------------------
 *  변수 : 프로그램 종료시까지 유지하는 변수(전역변수,멤버변수)
 *        메소드안에서 사용되는 변수(지역변수)
 *       - 기본형 => 정수 : int, long
 *              => 실수 : double
 *              => 논리 : boolean
 *       - 참조형 => 데이터가 여러개(메모리 주소 이용해서 연결)
 *              => 배열(1차원) --- 같은 크기의 데이터형
 *              => 클래스 ------- 다른 크기의 데이터형(핵심!)
 *        
 * --------------------
 *  생성자 : 변수의 초기화, 클래스를 메모리에 저장시 사용
 * --------------------
 *  메소드 : 하나의 기능을 수행하기 위한 명령문의 집합
 *         기능을 수행(연산자/제어문), 다른 클래스와 연결(메세지)
 *         다른 클래스와 통신
 *         재사용 목적(기능을 최소화/한개의 기능만 수행할 수 있다)
 * --------------------
 * 
 * 1. 메소드 형식
 *    [접근지정어]        [옵션]         리턴형 메소드명(매개변수)
 *     public  static/final/abstract
 * 2. 메소드 종류
 *    리턴형    매개변수
 *    --------------
 *      O       O
 *    => String
 *    String substring(int s)
 *    String replace(String s1, String s2)
 *    --------------
 *      O       X
 *    String trim()
 *    double random()
 *    --------------
 *      X       O
 *    void println(String s)
 *    void main(String[] arg)
 *    --결과값이 없는 경우 void
 *    --------------
 *      X       X
 *    void println()
 *    --------------
 * 3. 메소드 구성요소
 *    = 리턴형(처리 결과 값) => 화면출력(데이터)
 *                          여러개인 경우: 배열, 클래스
 *                          예) 검색, 상세보기
 *                          한개인 경우 : 기본형
 *                          예) 최대값, 최소값, 합, 평균
 *    = 사용자 요청값(매개변수) : 여러개 : 3개 이상이면 => 배열, 클래스
 *                           한개 : 기본형
 *    = 메소드명
 *      - 알파벳으로 시작한다(대소문자 구분)
 *      - 숫자 사용 가능(문자 뒤에 가능)
 *      - 특수문자 가능( _ , $) -> _ 는 임시메소드 또는 단어가 두개 이상일 때 주로 사용한다.(_main, file_name)
 *      - 키워드 사용 불가
 *      - 공백 불가
 *      (약속)소문자로 시작한다
 *      ----------------------------------- 식별자
 *      *** 변수는 같은 이름으로 사용이 불가능하다.
 *      *** 메소드는 같은 이름을 사용할 수 있다.(오버로딩)
 *          (매개변수가 다르면 다른 메소드로 인식한다)
 *      *** 매개변수 개수를 알지 못하는 경우
 *      1. 장바구니 => 가변매개변수
 *         (int...arg) <- ... 이 붙어있다.
 *    
 */
import java.util.Arrays;
import java.util.Scanner;
public class 메소드_1 {
	// 사용자가 원하는 갯수만큼 난수 발생(1~100)
	// 사용자 -> 갯수(매개변수)
	// 리턴형 => 배열
	// 예약 가능한 날 /예약 가능한 시간
	static int[] rand(int count)
	{
		int[] arr=new int[count];
		for(int i=0;i<=arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printf(String forman, Objact...args)
//		System.out.printf("%d\n",10);
//		System.out.printf("%d %c %.2f %d\n",10,'A',20,30);
//		System.out.printf("%d %d %d %d\n",10,20,30,40);
		Scanner scan=new Scanner(System.in);
		System.out.println("난수 갯수 입력:");
		int count=scan.nextInt();
		int[] arr=rand(count);
		// 메소드 호출 : 메소드명(매개변수값) => 자신의 클래스
		//            클래스명.메소드명(매개변수값) => 다른 클래스
		System.out.println(Arrays.toString(arr));
	}

}