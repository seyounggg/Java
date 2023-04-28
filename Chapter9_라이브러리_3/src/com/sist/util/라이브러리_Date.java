package com.sist.util;

import java.text.SimpleDateFormat;
/*
 *   Date(java.util) : 시스템의 현재 시간/날짜를 읽어오는 클래스
 *      1. 단점
 *         1) 기능이 빈약하다
 *         2) 날짜만 저장하는 클래스(오라클의 데이터형과 호환/오라클도 DATE)
 *      
 *      2. 사용처 : 웹(등록일)
 *         
 *  Date => simpleDateFormat => java.text
 *  Date클래스의 단점을 보완한게 Calendar클래스
 *     
 */
import java.util.Date;
import java.io.*;
public class 라이브러리_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		System.out.println(date.toString());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(sdf.format(date));
		/*
		 *   년도 : yyyy(2023) , yyy(023)
		 *   월 : MM(04, 12 => 한자리 월이면 0이 붙는다) , M(4 => 0없이)
		 *   일 : dd , d(dd면 0이 붙고, d면 0이 안붙는다)
		 *   시간 : hh , h
		 *   분 : mm, m
		 *   초 : ss, s
		 */
	}
}