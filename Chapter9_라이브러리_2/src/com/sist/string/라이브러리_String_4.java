package com.sist.string;

import java.util.*;

// charAt(0)
// 코딩테스트
// 문자열을 입력해서 좌우 대칭 여부 확인 = ABBA
public class 라이브러리_String_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String data="";
		// while문 => 오류처리 // 좌우대칭이 맞는지 비교하려면 총 문자열이 짝수여야 하므로 홀수로 입력됐을 경우의 오류처리
		while(true) {
			System.out.print("문자열 입력:");
			data=scan.next();
			if(data.length()%2!=0) {
				System.out.println("문자 갯수가 짝수여야 합니다");
				continue;
			}
			break;
		}
		//오류처리 방식2 -> 더 간단하게 처리할 수 있는 방법도 있다
		/*
		if((data.length()/2)%2!=0) {
			System.out.println("문자 갯수가 짝수여야 합니다.");
		}
		else { boolean ~ for문 } 여기까지 }
		*/
		System.out.println("data값은:"+data);
		boolean bCheck=false; // default 값 false 인 이유는 else를 쓸 경우에 계속 if~else가 돌기때문에
		int j=data.length()-1;
		for(int i=0;i<data.length()/2;i++) {
			char s=data.charAt(i);
			char e=data.charAt(data.length()-1-i);
			if(s==e)
				bCheck=true;
			else {
				bCheck=false;
				break;
			}
		}
		if(bCheck==true) {
			System.out.println(data+"는(은) 좌우대칭입니다!!");
		}
		else {
			System.out.println(data+"는(은) 좌우대칭이 아닙니다ㅜ");
		}
	}

}
