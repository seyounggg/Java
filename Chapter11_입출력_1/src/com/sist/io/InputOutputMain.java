package com.sist.io;
/*
 *   IO : Input(읽기) / Output(쓰기)
 *   
 *     1. 자바에서 IO는 Stream을 사용하고 있다
 *                   ------ 데이터 이동하는 통로(FIFO=>Queue)
 *        => IO
 *           = 메모리 입출력
 *           = 파일 입출력
 *           = 네트워크 입출력
 *        => IO 특징 : 단방향 통신 => (like)빨대
 *     2. 읽기 / 쓰기 (1byte, 2byte)
 *       = 1byte => ~InputStream, ~OutputStream
 *                  => 한글자당 1byte 읽기 / 쓰기 => 한글은 깨짐
 *                  => 업로드 , 다운로드
 *       = 2byte => ~Reader , ~Writer (한글)
 *                  => 한글제어
 *       ---------------                                    ---------------
 *       메모리 (데이터저장)  ========== 자바응용프로그램 ==========    모니터 출력
 *       ---------------      |                       |     ---------------
 *                       InputStream            OutputStream
 *  
 *   책 356page
 *   
 *   Stream : 데이터가 이동하는 통로(단방향)
 *          - 읽기 통로 : 데이터가 저장된 위치로부터 프로그램에서 데이터를 읽어 들이기 위한 연결
 *                      InputStream(바이트 스트림 :1byte씩 이동) / Reader(문자 스트림 : 2byte)
 *                      메모리에 있는 데이터 : 
 *                      파일에 있는 데이터
 *                      소켓에 있는 데이터(네트워크)
 *          - 쓰기 통로 : 출력위치로 프로그램에 전송하는 통로
 *                      OutPutStream(바이트 스트림 : 1byte씩 이동) / Writer(문자 스트림 : 2byte)
 *   IO 관련 클래스
 *         Object
 *           |
 *      바이트스트림(1byte)                  문자스트림(2byte)     
 *          -------------------------------------
 *          |                                   |   
 *      -----------------                   파일 입출력(추천)
 *                 📍업로드/다운로드           ----------------
 *      |               |                  |               |
 *   InputStream  OutputStream             Reader          Writer
 *      |               |                  |               |
 *  FileInputStream FileOutputStream       FileReader    FileWriter
 *  FilterInputStream FilterOutputStream   |               |
 *      |               |                  BufferedReader  BufferedWriter
 *  BufferedInputStream BufferedOutputStream
 *  ----------------------------------------
 *  ObjectInputStream / ObjectOutputStream
 *  
 *  📍모드 (mode) => r(read), w(write), a(append)
 *                   Reader , Writer
 *                 
 *                 => new FileWriter("파일명",true) => append
 *                 => new FileWriter("파일명") => create
 *  📍File => 독립클래스 // 책 376page
 *          1) 파일
 *          2) 디렉토리(폴더)
 *         - File 사용방법
 *           = 생성방법
 *             File file=new File("파일명"); => 파일 정보 읽기
 *             File file=new File("폴더명"); => 디렉토리 정보 읽기
 *         - File 주요기능(메소드)
 *           = 파일 정보
 *             getName() : 파일명
 *             getPath() : 경로명/파일명
 *             getParent() : 경로명
 *           = 파일 특성 : Boolean
 *             canRead() : 읽기전용
 *             canWrite() : 쓰기전용
 *             isHidden() : 숨긴파일
 *           = 파일 여부 확인_파일인지? 폴더인지?
 *             boolean isFile()
 *             boolean isDirectory()
 *           = 파일 조작
 *             createNewFile() : 파일 만들기
 *             mkdir() : 디렉토리 만들기
 *           = 파일 삭제
 *             delete() : 한개만(파일이 있는 디렉토리 삭제 불가)
 *                      => 파일을 먼저 삭제 -> 디렉토리 삭제
 *           = 파일 / 디렉토리의 존재여부
 *             boolean exists()
 *           = 수정 날짜
 *             long lastModified()
 *           = 파일 크기
 *             long length()
 *           = 디렉토리 목록 읽기
 *             listFiles()
 *   => read(), write(), close()
 *     - FileInputStream
 *       int read() write(byte)
 *     - FileReader
 *       char read() write(String)
 */
//CheckedException => 반드시 예외처리를 해야 사용이 가능
/*
 * [CheckedException]
 *   FileInputStream  ---
 *   FileOutputStream    | ==> 3개는 ( try~catch / throws )로 반드시 예외처리를 해줘야 한다
 *   FileReader       ---
 */
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class InputOutputMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// File 선언
		File file=new File("/Users/seyeong/Desktop/Java/back.jpg"); 
		long size=file.length();
		String res="";
		if(size/1024==0) {
			res=size+"Bytes";
		}
		else {
			size=size/1024;
			res=size+"KB";
		}
		System.out.println("파일 크기:"+res);
		// 출력 : 파일 크기:72KB
		System.out.println("읽기 전용:"+file.canRead());
		// 출력 : 읽기 전용:true
		System.out.println("쓰기 전용:"+file.canWrite());
		// 출력 : 쓰기 전용:true
		System.out.println("숨긴 파일:"+file.isHidden());
		// 출력 : 숨긴 파일:false
		System.out.println("수정 날짜:"+file.lastModified()); //long형이라서 출력하면 확인할 수 없음
		// 출력 : 수정 날짜:1683006176266
		System.out.println("수정 날짜:"+new Date(file.lastModified())); // new Date()를 사용해서 날짜를 확인
		// 출력 : 수정 날짜:Tue May 02 14:42:56 KST 2023
		System.out.println("수정 날짜:"+new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초")
				            .format(file.lastModified()));
		// 출력 : 수정 날짜:2023년 05월 02일 02시 42분 56초
		System.out.println("경로명:"+file.getParent());
		// 출력 : 경로명:/Users/seyeong/Desktop/Java
		System.out.println("파일명:"+file.getName());
		// 출력 : 파일명:back.jpg
		System.out.println("경로명+파일명:"+file.getPath());
		// 출력 : 경로명+파일명:/Users/seyeong/Desktop/Java/back.jpg
		
		// 위 내용은 file의 간단한 정보를 가져온 것으로, 예외처리를 하지 않아도 된다
	}
}
