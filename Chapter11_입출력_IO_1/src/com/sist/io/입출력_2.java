package com.sist.io;
// 365~366page
// 파일 읽기
// FileInputStream(1byte) / FileReader (2byte)
// 한글이 포함 ==> 반드시 2byte씩 읽어야 한글 깨짐 방지
import java.io.*;
public class 입출력_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader reader=null;
		try {
			reader=new FileReader("/Users/seyeong/Desktop/Java/데이터모음/movie.txt");
			
			// 네트워크 통신시에도 많이 사용
			// char[8192] 이 생성
			BufferedReader in=
					new BufferedReader(reader);
			int i=0; // 한글자씩 읽기 => read()
			// int read() => 글자의 ASC코드를 읽어온다(정수)
			// 예) A => read() => 65
			// int read(byte[], int, int) => 여기서 int는 읽은 바이트 수
			long start=System.currentTimeMillis();
			/*while((i=in.read())!=-1) {
				// -1 : EOF/ 읽을 데이터가 없는 경우 /전체 데이터를 읽은 경우
				System.out.print((char)i);
			}
			*/
			while(true) {
				String data=in.readLine(); // \n까지 한줄씩 읽음 -> 속도가 빠름
				if(data==null) break;
				System.out.println(data);
			}
			long end=System.currentTimeMillis();
			System.out.println("읽은 시간:"+(end-start));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try{
				reader.close();
			}catch(Exception ex) {}
		}
	}
}
