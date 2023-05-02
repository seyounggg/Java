package com.sist.io;
import java.io.*;
public class FileMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*
			// File 설정
			File file=new File("/Users/seyeong/Desktop/Java/school.txt");
			// 파일의 존재여부 확인
				if(!file.exists()) { // 파일이 존재하지 않는 경우
					file.createNewFile(); // 파일을 생성
				}
				System.out.println("파일 만들기 성공...");
				*/
			/*
			File dir=new File("/Users/seyeong/Desktop/Java/java_datas");
			if(!dir.exists()) {
				dir.mkdir();
				System.out.println("폴더 만들기 성공...");
			}
			*/
			File dir=new File("/Users/seyeong/Desktop/Java");
			File[] files=dir.listFiles(); //폴더에 있는 모든 파일을 가져와랑
			for(File f:files) {
				if(f.isFile()) {
					System.out.println(f.getName()+" "+f.length());
				}
				else if(f.isDirectory()) {
					System.out.println(f.getName()+" DIR");
				}
			}
		/*
		 * 출력
		    jar파일 DIR
			.DS_Store 10244
			4주차_정리 DIR
			.metadata DIR
			school.txt 0
			정리 DIR
			데이터모음 DIR
			java_datas DIR
			Chapter11_입출력_1 DIR
			제출 DIR
			문제 DIR
			back.jpg 74624
		 */
		}catch(Exception ex) {}
	}

}
