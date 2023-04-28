package com.sist.util;
import java.util.*;
// 보너스!!
// new를 사용하지 않는 경우는 '추상클래스' 또는 '인터페이스'이다
/*
 * 구분 방법
 * new를 사용하지 않는데 기능을 가지고 있다면!! => 추상클래스
 *    - 추상클래스는 구현된 메소드와 구현이 안된 메소드를 가지고 있다
 * new를 사용하지 않고 기능도 가지고 있지 않다면 !! => 인터페이스
 *    - 인터페이스는 구현이안된 메소드만 가지고 있다
 *    ex) List list=new ArrayList() => List가 인터페이스!!
/*
 *  Calendar : Date클래스를 보완해서 새롭게 만든 클래스
 *           => 추상클래스(new를 사용하지 않는다)
 *           => 필요시에 오버라이딩을 해서 사용한다
 *           
 *    1) 생성
 *       Calendar cal=Calendar.getInstance();
 *    2) 날짜 설정 : set()
 *    3) 날짜 읽기 : get()
 *    4) 각달의 마지막 날 : getActualMaximum()
 *    5) 요일 읽기 : get()
 */
public class 라이브러리_Calendar_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal=Calendar.getInstance();
		
		//year
		System.out.println("년도:"+cal.get(Calendar.YEAR));
		//System.out.println("년도:"+cal.get(1));
		
		//month는 0번부터 시작(0~11) --> +1을 줘야한다!
		System.out.println("월:"+(cal.get(Calendar.MONTH)+1));
		//                       ---------------------------
		// "월:3"+1 => "월:31" --> 괄호로 묶어서 처리!!
		
		//date
		System.out.println("일"+cal.get(Calendar.DATE));
		
		//hour+minute+second
		System.out.println("시간"+cal.get(Calendar.HOUR));
		System.out.println("분"+cal.get(Calendar.MINUTE));
		System.out.println("초"+cal.get(Calendar.SECOND));
		
		//getActualMaximum + day_of_month
		System.out.println("이번달 마지막 날:"+cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		//day_of_week
		String[] week= {"","일","월","화","수","목","금","토"};
		// week => 1~7
		// 배열의 첫 자리는 0번이니까 "" 공백처리
		System.out.println("요일:"+week[cal.get(Calendar.DAY_OF_WEEK)]);
	}

}
