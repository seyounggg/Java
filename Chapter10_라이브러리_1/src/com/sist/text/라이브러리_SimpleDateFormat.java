package com.sist.text;
/*
 *   java.text => 출력 형태를 만들어서 사용(변경)
 *     
 *     - SimpleDateFormat : 날짜 변경
 *     - DecimalFormat : 숫자변환 ( 가격출력 10,000원)
 *     - MessageFormat : 데이터베이스 => INSERT, UPDATE
 *                     String name="", sex="", addr="", tel="";
 *                     int age=10;
 *                     String sql="INSERT INTO member VALUES("
 *                               +"'"+name+"','"+sex+"','"+addr+"','"+tel+"','+"+age+")"
 *                     String sql="INSERT INTO member VALUES('{1}','{2}','{3}','{4}','{5})
 *                     
 *   Java     =>   Oracle                  
 *   yyyy 년도 =>   rrrr
 *   MM 월     =>   mm
 *   dd 일     =>   dd
 *   hh 시간   =>   hh24
 *   mm 분     =>   mi
 *   ss 초     =>   ss                            
 *   
 */
// util과 sql안에 Date클래스가 충돌되므로 어느 패키지에 있는것을 사용할 것인지 표시해줘야함
// util.Date 처럼 작성해도 되고, main메소드 안에 java.util.Date date=new java.util.Date(); 로 작성할 수 있다
import java.util.Date;
import java.text.*;
import java.sql.*;
public class 라이브러리_SimpleDateFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일");
		// yyyy-MM-dd , yyyy/MM/dd 이런 형식도 많음
		System.out.println(sdf.format(date));
		
		
	}

}
