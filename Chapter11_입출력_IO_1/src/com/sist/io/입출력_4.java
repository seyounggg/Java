package com.sist.io;
// FileReader / FileWriter => 기반스트림
// BufferedReader / BufferedWriter => 필터스트림
import java.io.*;
public class 입출력_4 {

	public static void main(String[] args) throws Exception {
		FileWriter out=new FileWriter("/Users/seyeong/Desktop/Java/java_datas/movie_1.txt");
		// (create)
		// 지정한 파일을 자동으로 생성 , 이미 똑같은 파일명이 존재할 경우는 기존 파일위로 덮어쓴다
		/* (append) 추가 기능 
		 * new FileWriter("/Users/seyeong/Desktop/Java/java_datas/movie_1.txt",true);
		 *                                                                     -----
		 *  추가할 경우에는, 기존 파일 내용 뒤에 추가하는 내용이 붙여진다 (문장열 결합)
		 */
		FileReader in=new FileReader("/Users/seyeong/Desktop/Java/데이터모음/movie.txt");
		
		BufferedReader br=new BufferedReader(in);
		BufferedWriter bw=new BufferedWriter(out);

		while(true) {
			String data=br.readLine();
			if(data==null) break;
			bw.write(data+"\n");
		}
		System.out.println("읽기/쓰기 완료!");
		in.close();
		out.close();
	}
}
