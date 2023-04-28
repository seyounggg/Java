package com.sist.util;
import java.util.*;
/*
 *   StringTokenizer : 문자열 분리
 *      1) split() => 대체
 *      2) 빅데이터 / 네트워크 / 웹
 *      
 *      기능
 *        = 생성자
 *          StringTokenizer st=new StringTokenizer("구분할 문자열", 구분자)
 *          StringTokenizer st=new StringTokenizer("구분할 문자열") => 공백으로 분리
 *          
 *          예)
 *          String s1="에니메이션/어드벤처/코디미";
 *          String s2="박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬";
 *          StringTokenizer st=new StringTokenizer(s1, "/");
 *          StringTokenizer st=new StringTokenizer(s2);
 *        = countTokens() : 분리된 데이터 갯수
 *        = nextToken() : 분리된 데이터 읽기
 *        = hasMoreTokens() : 분리된 갯수만큼 루프 수행
 */
public class 라이브러리_StringTokenizer_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1="애니메이션/어드벤처/코디미";
//		StringTokenizer st=new StringTokenizer(s1, "/");
//		System.out.println(st.countTokens()); //3
//		System.out.println(st.nextToken()); //애니메이션
//		System.out.println(st.nextToken()); //어드벤처
//		System.out.println(st.nextToken()); //코미디
		
		String s2="박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 "
				 +"박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 "
				 +"박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 "
				 +"박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 "
				 +"박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 "
				 +"박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 "
				 +"박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 ";
		StringTokenizer st=new StringTokenizer(s2);
		
		//hasMoreTokens
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		/*System.out.println(st.countTokens());
		int a=st.countTokens();
		for(int i=0;i<a;i++) {
			System.out.println(st.nextToken());
		}
		*/
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
	}

}
