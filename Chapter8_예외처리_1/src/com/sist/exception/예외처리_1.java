package com.sist.exception;
/*
 *    에러 => 컴파일(javac) / 실행(java)
 *           -----------   ---------
 *           Check          UnCheck => 생략
 *           자바문법(반드시 예외처리)
 *           
 *   [에러]
 *     Error => 수정이 불가능한 에러(심각한 오류) : 메모리 부족, 윈도우 덤프
 *        
 *     Exception => 수정이 가능한 에러(가벼운 오류) : 소스상에서 수정이 가능 
 *        - 파일 읽기 중 파일명 틀린 경우, 배열의 인덱스 번호를 벗어난 경우
 *        - 웹연결 시 URL주소가 틀린 경우 ...
 *     
 *   [에러 발생]
 *      1. 프로그래머의 실수
 *         => 초기화 값이 없는 상태에서 비교
 *         => 배열 인덱스 오류
 *         => 무한루프
 *         => 파일명 오류...
 *      2. 사용자 입력 오류
 *         => 계산기에서 나누기를 하는데 0을 입력
 *         => 정수를 입력해야하는데 문자열을 입력
 *         - - - - - - - - - - - - - - - - > 웹에서 유효성 검사!!(사용자가 정상적으로 입력하도록)
 *   
 *   [예외처리 목적]
 *      1. 견고한 프로그램을 만들기 위해서 사용
 *         => 어떤 상태던 종료하지 않아야 한다.(비정상 종료를 방지)
 *         => 정상상태를 유지한다
 *      2. 사전에 에러를 방지하는 프로그램
 *      
 *   [예외처리 방식]
 *      1. 우선적으로 고려할 점 : if -> 예외처리
 *      2. 예외처리 : 복잡한 에러, if문으로 해결이 불가능
 *         웹 : 404(파일이 없는 경우), 500(소스 오류), 415(한글변환), 400(값을 잘못받는 경우), 403(접속거부)...
 *         
 *   [예외처리 종류]
 *      1. 예외발생 시? 복구
 *         try~catch
 *         형식)
 *            try {
 *               <정상 수행하는 문장>
 *               int a=10;
 *               int b=0;
 *               double d=a/(double)b; ==> catch로 이동!
 *               System.out.println(d); (수행을 못하는 문장) /catch로 갔다가 다시 돌아오지 않음
 *            }catch(Exception e) {
 *               <예외발생 시 처리하는 영역>
 *            }
 *            
 *            사용자로부터 문자열을 받아서 정수 변경후에
 *                     --------------------catch(NumberFormatException e)
 *            배열에 저장
 *            --------catch(ArrayIndexOutOfBoundsException e)
 *            나누기를 한 후에 출력
 *            ----------catch(나누기...)
 *            catch(Exception e)
 *            
 *      2. 예외발생 시? 회피
 *         throws
 *      3. 예외발생 시? 발생해~ => 테스트
 *         throw 
 *      4. 사용자정의 예외
 *         지원하지 않는 예외가 존재
 *         
 *      [예외처리의 계층구조]
 *               Object
 *                 |
 *             Throwable
 *                 |
 *      -------------------------
 *      |                       |        
 *    Error                  Exception
 *                              |
 *                   ---------------------------
 *                   |                         |
 *             CheckException           UnCheckException
 *        (존재하지 않음)[반드시 예외처리]  (존재하지 않음)[필요시에만 사용]
 *                   |                         |
 *                   |                 RunTimeException
 *                   |                         |
 *                   |               NumberFormatException
 *                   |               문자열 => 정수형으로 변경
 *                   |               main.jsp?page= 1
 *                   |               => 오류" " 공백
 *                   |               NullPointerException
 *                   |               => 객체 초기화가 안된 상태
 *                   |               => 참조형 주소가 없는 경우(선언만 했을 경우)
 *                   |               ArrayIndexOfOutBoundsException
 *                   |               => 배열범위 초과시 발생
 *                   |               ArithmeticException
 *                   |               => 0으로 나눌 경우
 *                   |               Class CastException
 *                   |               => class 형변환이 틀린 경우
 *                   |               IllegalArgumentException
 *                   |               => 부적절한 인자 전달
 *                   |               IndexOfOutBoundsException
 *                   |               
 *                IOException(입출력) => 메모리 입출력, 파일 입출력, 네트워크 입출력
 *                  - java.io => 클래스가 동일
 *                SQLException(오라클 연동)
 *                  - java.sql => 네트워크 통신
 *                    자바응용프로그램 ==========> 오라클
 *                       (C)                   (S)
 *                      Client                Server
 *                    => 웹에 출력하는 모든 데이터 => 오라클
 *                    => 자바 =================> 오라클
 *                              자바전송(X)
 *                              오라클이 인식하는 언어 전송(SQL)
 *                              SELECT * FROM 테이블명
 *                ClassNotFoundException(리플렉션)
 *                 => 클래스명이 틀린 경우
 *                  class.for.forName("패키지.클래스명")
 *                Malformed URLException
 *                => URL주소가 틀린 경우
 *                => Jsoup
 *                InterrupedException
 *                => 쓰레드 충돌
 *
 *   책 263page
 *   예외의미 : 프로그램에서 돌발적으로(의도하지 않은 상황)에서
 *           문제가 발생 시 어떻게 처리를 할 것인지
 *           ----------- 프로그램은 비정상으로 종료 => 방지
 *           정상적으로 종료가 가능하게 만드는 과정(예외처리)
 *   
 */
class BBBB{
	
}
class CCCC extends BBBB{
	//cc.disp('A',10,'B');
	public void disp(int a,int b,int c) {
		System.out.println("1");
	}
	public void disp(int a,char b,byte c) {
		System.out.println("2");
	}
	public void disp(char a,char b,int c) {
		System.out.println("3");
	}
}
public class 예외처리_1 {
	static String s; // null
	public static void main(String[] args) {
		String ss="Hello Java!!";
		System.out.println(ss.substring(ss.indexOf("K"),ss.lastIndexOf("J")));
		
//		if(s.equals("Hello")) {
//			System.out.println("OK");
//		} //s의 주소값이 null인데 비교해서 NullPointerException 이 나온다

		CCCC cc=new CCCC();
		cc.disp('A',10,'B');
		System.out.printf("%d %c %s\n",10,65,"30");
		
//		System.out.println(10/0);
//		System.out.println("1");
//		int[] arr=new int[2];
//		arr[2]=10;
//		System.out.println("2");
//		int a=10;
//		int b=0; // 사용자로부터 값을 받았을 때
//		// 처리
//		if(b!=0) { // 정상수행 -> try
//			int c=a/b;
//			System.out.println("c="+c);
//		}
//		else { // 예외처리 -> catch
//			System.out.println("0으로 나눌 수 없습니다");
//		}
//		//1. 정상적으로 종료가 되도록 만들어야 한다
//		//2. 우선 조건문(if)으로 할 수 있는가?
//		//2-1. if는 주로 사용하는게 => 검색용도, 사용자 입력 제한 ...
//		//3. if로 처리하기 어려우면 자바에서 제공하는 예외처리를 이용한다
//		String page=" 1";
//		System.out.println(Integer.parseInt(page));
	}

}
