package com.sist.io;
// 파일 쓰기
import java.io.*;
public class 입출력_3 {

	public static void main(String[] args) {
		
		FileWriter out=null;
		// BufferedWrite
		
		FileReader in=null;
		// BufferedReader
		try {
			
			// 1. 파일 만들기
			File file = new File("/Users/seyeong/Desktop/Java/java_datas/movie.txt");
			if(!file.exists()) { // file 이 존재하지 않는다면
				file.createNewFile(); // file 생성 명령
			}
			
			// 파일 읽기
			in=new FileReader("/Users/seyeong/Desktop/Java/데이터모음/movie.txt");
			out=new FileWriter(file); // file 경로가 같아서 file 입력
			//out=new FileWriter("/Users/seyeong/Desktop/Java/java_datas/movie.txt"); // 경로지정도 가능
			
			// 생성된 파일 쓰기
			int i=0;
			while((i=in.read())!=-1) {
				out.write(i);
			}
			System.out.println("파일 읽기/쓰기 완료");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				in.close();
				out.close();
			}catch(Exception ex) {}
		}
	}

}
