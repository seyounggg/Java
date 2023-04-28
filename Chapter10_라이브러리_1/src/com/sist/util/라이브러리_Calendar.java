package com.sist.util;
/*
 *   라이브러리
 *    = 자바에서 지원
 *       java.lang, java.util, java.io, java.net, java.text, java.sql..
 *       웹과 관련 : javax.xml, javax.servlet ...
 *    = 외부업체에서 지원
 *       Jsoup(HTMl, parse), 셀레니움, MyBatis, Spring, DBCP ...
 *    
 *    4/27까지 배운거
 *    = java.lang(import 생략 가능)
 *      : Object, String, System, Math, StringBuffer ..
 *      
 *      Object : 최상위 클래스, 모든 데이터형을 받을 수 있다
 *               저장 => 일반 기본형, 사용자정의 클래스 => 기본적으로 설정 Object / 형변환
 *               주요기능
 *                  clone() : 복제(새로운 메모리 생성) => 디자인패턴(GOF 23)
 *                  finalize() : 소멸자(자동호출 => 메모리해제)
 *                  toString() : 객체를 문자열화
 *                  equals(0 : 객체비교 (default = 객체의 주소값 / 데이터값 비교하려면 오버라이딩 해야함)
 *      System : gc()
 *               System.out , System.in => 표준입출력
 *      Math : 수학
 *         주요기능
 *         round() : 반올림
 *         ceil() : 올림
 *         random() : 난수(임의의 수 추출)
 *     StringBufer : 문자열이 많은 경우의 제어
 *        append() : 문자열 결합
 *        delete() : 문자 제거
 *        insert() : 문자 추가
 *        -------------------append, delete, insert는 String에 존재하지 않는다
 *     
 *     String : 문자열을 쉽게 제어가 가능하게 만든 클래스
 *              웹, 윈도우, 빅데이터(AI)
 *              주요기능
 *              equals() : 비교
 *              substring() : 문자 자르기
 *              trim() : 좌우 공백 제거
 *              length() : 문자갯수
 *              valueOf() : 
 *              contains() : 포함된 글자
 *              startsWith() : 
 *              split()
 *              replace()
 *              replaceAll()
 *      
 *   = java.util : 사용빈도가 많다
 *     - StringTokenizer : 문자열 분리(쉽게 분리)
 *       counterToken() : 분리된 단어의 갯수
 *       hasMoreTokens() : 분리된 갯수만큼 반복문 수행
 *       nextToken(): 실제 분리된 단어 읽기
 *     - Wrapper : 기본형을 클래스화 시켜서 기능을 수행하게 한다
 *       Integer : int
 *       Double : double
 *       Boolean : boolean
 *       Long : long
 *       => 기본형 / Wrapper는 호환이 된다
 *          오토박싱 : Integer i=10; ... 실제값(리터럴) 대입
 *          언박싱  : int a=new Integer(10) ... 기본형에서 클래스 객체값을 받는다
 *       => parseInt(), parseDouble(), parseBoolean(), parseLong() 
 *       // 문자인 데이터를 정수, 실수 등으로 가져오는 메소드!
 *          웹은 무조건 데이터가 String
 *          요청 ======> 요청처리(응답)
 *               String
 *     - Random
 *       netxInt(int bound)
 *       nextInt(10) => 0~9
 *     - Arrays : 배열을 쉽게 관리할 수 있다
 *       sort() : 정렬
 *       toString() : 배열출력
 *       asList() : List형으로 변환
 *     
 *     - 날짜관련
 *     - Date : 잘짜 저장용으로 주로 사용 / 기능이 없다 => 다른 프로그램과 호환
 *              오라클 / MySQL에서 전송된 날짜 데이터를 받는 경우에 사용
 *              
 *     - Calendar : 날짜에 대한 기능 필요 시 사용 (Date를 보완한 클래스)
 *       set() : 년도/월/일/시간/분/초
 *       get() : 설정된 값을 가져올때 사용하는 메소드
 *       getActualMaximum(): 각 달의 마지막 날
 *       요일 읽기 : get(Calendar.DAY_OF_WEEK)
 * --------------------------------------------------------------------------------------------------
 *  # 자바의 3대 클래스
 *    String, Integer, List
 *  
 *  = 배열을 대체
 *     - Collection : 데이터를 쉽게 관리 => 10개 (자동으로 저장공간이 설정)
 *            |
 *   -----------------
 *   |               |             |
 *  List            Set           Map  => interface
 *   |
 *  ArrayList       HashSet      HashMap
 *  Vector          TreeSet      Hashtable
 *  LinkedList-Queue
 *  => 제네릭스
 *  -----------------------------------------------------------------
 */
//Calendar응용
import java.util.*; // util패키지에서 Calendar , Scanner 사용
public class 라이브러리_Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 사용자로부터 년도/월 => 예약/체크인, 체크아웃 => 달력 만들줄 알아야함!
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 월 입력(2023 4):");
		int year=scan.nextInt();
		int month=scan.nextInt();
		
		// 첫날(1일)의 요일을 가져온다 (예, 사용자가 4월을 입력하면 4월1일의 요일)
		Calendar cal=Calendar.getInstance();
		// 추상클래스는 미완성된 클래스(메소드가 구현되지 않음)
		// 구현된 클래스, 싱글턴(newInstance(), getInstance) 이용한다
		/*
		 * static과 추상클래스 구분 방법
		 * 
		 *  static 메소드 => 클래스명.메소드명() 
		 *        ex) Math.random()
		 *        
		 *  클래스명 객체명=new 생성자() => 추상클래스 또는 상속 또는 인터페이스
		 *  -----           ------ 클래스명과 생성자명이 다르다!!
		 *  클래스명 객체명=메소드() => 추상클래스
		 */
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1); // month => 0부터 시작
		cal.set(Calendar.DATE, 1); // 1일자를 확인하고 싶어서
		
		// 요일 구하기
		int week=cal.get(Calendar.DAY_OF_WEEK)-1; // week => 1부터 시작
		                                          //위 set에 입력된 요일을 가져와라
		// 사용자가 입력한 달의 마지막 날 구하기
		int lastday=cal.getActualMaximum(Calendar.DATE);
		//              ---------------- 마지막 날 구하는 메소드
		
		// 달력 출력
		String[] strWeek= {"일","월","화","수","목","금","토"};
		System.out.println(year+"년도 "+month+"월");
		System.out.println("\n");
		for(String s:strWeek) {
			System.out.print(s+"\t"); // 일정간격 띄기
		}
		System.out.println(); // 한칸 내려서 출력
		for(int i=1;i<=lastday;i++) {
			if(i==1) { // 맨처음 => 공백을 줘야함
				for(int j=0;j<week;j++) {
					System.out.print("\t");
				}
			}
			//달력 출력
			System.out.printf("%2d\t",i);
			week++;
			if(week>6) { // 일요일이 0 / 일요일이면 다음줄에 출력하라!
				week=0; // 일요일 설정
				System.out.println(); // 다음줄에 출
			}
		}
	}

}
