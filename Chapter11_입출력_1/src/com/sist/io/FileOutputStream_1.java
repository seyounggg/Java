package com.sist.io;
import java.util.*;
import java.io.*;
public class FileOutputStream_1 {

	public static void main(String[] args) {
		try {
			// 파일 지정
			File file=new File("/Users/seyeong/Desktop/Java/java_datas/school.txt");
			
			// 파일 존재 여부 확인
			if(!file.exists()) {
				file.createNewFile(); // 파일을 만들기 명령!
			}
			
			// 파일이 존재할 때 사용
			FileOutputStream fos=
					new FileOutputStream(file,true); // 있으면, 파일 쓰기를 하겠다!
			String msg="안녕하세요 지금은 파일 입출력을 하고 있습니다\r\n";
			//System.out.println((int)'안');
			fos.write(msg.getBytes()); //getBytes => String을 byte[]로 변경!!
			fos.close();
			System.out.println("저장완료!!");
			
			
		}catch(Exception ex) {}
		

	}

}
