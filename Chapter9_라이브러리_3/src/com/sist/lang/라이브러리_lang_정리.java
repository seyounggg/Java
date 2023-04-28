package com.sist.lang;
/*
 * java.lang => 기본(가장 많이 사용되는 클래스의 집합)
 *              import를 생략할 수 있다
 *    Object(최상위 클래스) => 모든 클래스 Object 상속
 *                       => 데이터형으로도 사용(가장 큰 데이터형)
 *                           Object o=10, "", 'A', true ... 다 가능
 *                       => 여러개의 데이터형을 묶어서 관리
 *                           Object[] oo={10,10.5,true,'A',"AA" ...}
 *                       => 라이브러리에 제공하는 메소드
 *                          리턴형 / 매개변수 ==> 대부분 Object
 *                          => 형변환 ==> 제네릭스(리턴형/매개변수변경)
 *                       => 기능
 *                          1) clone : 복제(새로운 메모리 생성)
 *                          2) toString : 객체를 문자열화
 *                          3) finalize : 소멸자
 *                          4) equals : 객체비교(기본은 '주소값'비교 / 실제데이터값을 비교하고자 하면 '오버라이딩'해야함)
 *    String : 문자열을 저장하는 클래스
 *           = 기능)
 *             length()
 *             substring()
 *             trim()
 *             charAt()
 *             replace()
 *             equals()
 *             startsWith()
 *             contains()
 *             indexOf()
 *             lastindexOf()
 *             valueOf()
 *   ------------------------------ Chapter9_라이브러리_2_com_sist_string 참고!
 *    
 *    StringBuffer : append() 문자열 결합
 *    Wrapper : 기본형을 클래스화 시킨 클래스 집합
 *            - int ==> Integer ===> 정수변환 : Integer.parseInt()
 *            - long ==> Long 
 *            - double ==> Double ===> 실수변환 : Double.parseDouble()
 *            - boolean ==> Boolean ===> 논리변환 : Boolean.parseBoolean()
 *            => 기본형을 객체형으로 저장, 문자열을 기본형으로 변환
 *    Math : 수학
 *         - .random() : 난수발생 (0.0~0.99)
 *         - .ceil() : 올림메소드 => 홈페이지 구하기..
 *         - .round() : 반올림멤소드 => 평균,통계..
 *    System 
 *           - .currentTimeMillis() : 실제시간을 => long
 *             로그파일 => 웹
 *           - .gc() : 가비지 컬렉션 호출(메모리 회수)
 *           - .out : 화면 출력(outputStream)
 *           - .in : 키보드 입력값(inputStream)
 */
import java.util.*;
public class 라이브러리_lang_정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List list=new ArrayList();
		//list.add("aaa");
		//list.add(1);
		//String a=(String)list.get(0); // list가 Object이므로 String으로 형변환시켜줘야함
		//int b=(int)list.get(1); // <- 언박싱
		// list가 Object이므로 int(Integer)로 형변환시켜줘야함
		//int a=new Integer(10); // 경고
		
		/*
		 * List<String> list=new ArrayList<String>();
		 * list.add("aaa");
		 * String a=list.get(0);
		 */
		
		
	}

}
