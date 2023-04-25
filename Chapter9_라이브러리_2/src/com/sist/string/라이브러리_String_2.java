package com.sist.string;
import java.io.*;
public class 라이브러리_String_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			long start=System.currentTimeMillis();
			FileReader fr=new FileReader("/Users/seyoung/Downloads/데이터모음/movie.txt");
			int i=0; //문자읽기 => int로 읽는다
			StringBuffer data=new StringBuffer();
			while((i=fr.read())!=-1) { //-1(EOF) file의 끝
				data.append((char)i);
			}
			long end=System.currentTimeMillis();
			
			fr.close();
			System.out.println(data.toString());
			System.out.println("걸린시간:"+(end-start));
		}catch(Exception ex) {
			ex.printStackTrace(); // 에러메세지 확인+위치확인
			// getMessage() <- 에러메세지만 확인
		}
	}
}