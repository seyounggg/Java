package com.sist.util;
import java.util.*;
public class 라이브러리_Random_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] alpha=new char[10];
		Random r=new Random();
		for(int i=0;i<alpha.length;i++) {
			alpha[i]=(char)(r.nextInt(5)+65); // +65를 하면서 int로 데이터형이 변환되므로 ()를 이용해서 우선순위를 지정해야
			if(alpha[i]=='E')
				alpha[i]='F'; // E라는 성적은 없으니까 E를 F로 바꾸는거임
			System.out.println((i+1)+"번 학생 성적:"+alpha[i]);
		}
//		System.out.println(Arrays.toString(alpha));
//		Arrays.sort(alpha);
//		System.out.println(Arrays.toString(alpha));
	}

}
