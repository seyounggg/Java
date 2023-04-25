package com.sist.exception;

import java.io.*;
//Checked Exception
public class 예외처리_예외복구_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		/*FileReader fr=null;
		// int i=0; 하듯이 클래스도 초기화를 해야하고, 초기화 시 null값을 반드시 줘야한다
		// 블록{}안에 들어가면 지역변수가 되므로 {} 밖으로 선언
		// fr=new FileReader(""); // 예외처리 없이 사용할 경우 오류 발생되므로 반드시 예외처리를 해줘야함
		try {
			fr=new FileReader("/Applications/Java/Chapter8_예외처리_2/src/com/sist/exception/예외처리_예외복구_1.java");
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close(); // 초기값이 없을 경우 오류발생!
			}catch(IOException e) {}
		}*/
		
		// resource-with -> fr을 자동으로 닫는다(finally를 사용하지 않는다)
		try (FileReader fr=new FileReader("/Applications/Java/Chapter8_예외처리_2/src/com/sist/exception/예외처리_예외복구_1.java"))
		{
			i=0;
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
