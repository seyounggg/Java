// 주로 사용되는 while문

import java.io.*;
public class 반복문_4 {

	public static void main(String[] args) {
		
		try
		{
			int i=0;
			FileReader fr=
					new FileReader("C:\\javaDev\\javaStudy\\Chapter3_제어문_반복문_2\\src\\반복문_2.java");
			while((i=fr.read())!=-1)//-1 파일 종료
			{
				System.out.print((char)i);
				// 네트워크로 파일 전송 가능
			}
		}catch(Exception ex){}
		
	}

}