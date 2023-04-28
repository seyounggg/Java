package com.sist.lang;
/*
 * 책 317page
 *   Wrapper : 전체를 감싼다
 *             CSS (container)
 *   프로그램 개발 => 기본형 데이터형을 객체단위로 저장할 때
 *   
 *   List<int> => 오류
 *       ----- 클래스형
 *   List<Integer>
 *   => 기본형을 클래스화해서 사용
 *      ------------- Wrapper
 *      
 *     기본형        클래스형   => 기본형에 기능을 추가해서 클래스화 시킨것을 다 모아서 => Wrapper
 *     int         Integer
 *     long        Long
 *     byte        Byte
 *     double      Double
 *     boolean     Boolean
 *     
 *   = 사용처 : 문자열을 원하는 데이터형으로 변경할 때 주로 사용
 *     클라이언트에 배포 => 윈도우/브라우저/핸드폰 => 모든 데이터형 문자열(정수라는 개념이 없음)
 *   
 *   [*** 암기 ***]
 *    1. 클래스명 : 객체단위로 저장
 *    2. 문자열 => 해당데이터형으로 변환 ==> parseXxxxx (parseInteger) <- 이런 형식
 *    3. 오토박싱 : 클래스에 해당 데이터값을 설정
 *       Integer i=new Integer(10); <- 원래 클래스는 new를 사용하는데
 *       Integer i=10; <- 오토박싱은 이런 형식으로 작성한다 => String s="";
 *    4. 언박싱 : 기본형에 클래스 객체를 설정
 *       int aa=i; <- 여기서 i는 위의 Integer i 를 의미함
 *       
 *    [Wrapper의 주요 역할]
 *    1. 문자열을 해당 데이터형으로 변환
 *       문자열 => 정수형 Integer.parseInt("10")
 *       문자열 => 실수형 Double.parsedouble("4.5")
 *       문자열 => 논리형 Boolean.parseboolean("true")
 *    2. 객체단위로 저장할때가 있다 *** (자료구조 => Collection)
 *  ----------------------------------------------------------------------------
 *   끌레망꾸꾸 4.3
 *   ------  ---
 *   String   double => String(웹 => 문자열)
 *   String score=(String)4.3; == 오류
 *   String score=(double)"4.3"; ==> 오류
 *     
 */
public class 라이브러리_Wrapper_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="4.3";
		double d=Double.parseDouble(s);
		
		//오토박싱
		Integer i=100;
		System.out.println("i="+i);
		//언박싱
		int aa=i;
		System.out.println("aa="+aa);
		/*
		 *    void display(Integer i1,Integer i2)
		 *    => display(10,20)
		 */
		
	}

}
