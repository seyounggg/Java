package com.sist.io;
import java.io.FileInputStream;
import java.io.FileReader;
/*
 *   FileInputStream : 단위 byte(1byte씩 읽어온다)
 *      => 한글이 포함된 데이터는 읽기는 가능하지만, 한글이 깨진다
 *         --------------- FileReader
 *   📍사용 : 웹에서 자료실, 갤러기 게시판 만들기, 업로드/다운로드(.zip/.ppt/.png)
 *   📍주요메소드
 *      read() => 1byte => 리턴형 => int
 *      close() => 닫기
 *   📍생성자(둘중 하나 선택)
 *      new FileInputStream(File file)
 *      new FileInputStream(String path)
 */
import java.util.*;
public class FileInputStream_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 파일 읽기
			// System.in / System,out
			// 표준 입출력
			// 파일 읽기
			FileReader/*InputStream*/ fis=
					new FileReader/*InputStream*/("/Users/seyeong/Desktop/Java/Chapter11_입출력_1/src/com/sist/io/InputOutputMain.java");
			int i=0; // 한개의 문자를 읽어 온다 => 문자번호를 넘겨준다
			// 문자번호를 받는 변수
			// -1은 더이상 읽을 데이터가 없을떄까지 => EOF(End Of File) / file의 마지막!
			while((i=fis.read())!=-1) {
				System.out.print((char)i); // 'A' => 65 니까 char로 형변환 시켜야한다
			}
		}catch(Exception ex) {}
		//FileInputStream 을 사용하면 한글이 다 꺠져서 FileReader로 변경해서 출력내용 확인!
	}
}
