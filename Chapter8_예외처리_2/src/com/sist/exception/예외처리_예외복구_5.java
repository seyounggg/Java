package com.sist.exception;
// 책 274page
// finally : 생략이 가능
// finally => try수행, catch를 수행 관계없이 무조건 수행되는 문장
// 파일 닫기, 오라클 연결 해제, 서버 연결 해제 => 오라클 연결, 네트워크 연결
/*
 *    try {
 *        정상수행이 가능
 *        => 에러(예상하지 못한에러가 발생할 수 있다)
 *        프로그래머의 실수, 사용자의 입력값 오류 ...
 *    } catch(예상되는 예외클래스) {
 *        에러가 바생시에 처리
 *        = 에러를 확인
 *        = 복구를 할 수 있다 => 오류 메세지 전송도 가능
 *    } finally { ==> 생략이 가능
 *        무조건 수행하는 문장을 코딩
 *        (파일 닫기, 오라클 연결 해제, 서버 연결 해제 => 오라클 연결, 네트워크 연결)
 *    }
 *    실행순서
 *    ------
 *    문장 1
 *    문장 2
 *    try {
 *       문장 3
 *       문장 4 => 에러발생 => catch 이동
 *       문장 5
 *    }catch(예외처리 클래스) {
 *       문장 6
 *    }catch(예외처리 클래스) {
 *       문장 7
 *    }catch(예외처리 클래스) {
 *       문장 8
 *    }finally {
 *       문장 9
 *    }
 *    문장 10
 *    문장 11
 *    
 *    : 1. try가 정상수행
 *         1-2-3-4-5 = catch수행 X => 9-10-11
 *      2. try => 에러(1)
 *         1-2-3 = catch(!) => 6-9-10-11
 *      3. try => 에러(2)
 *         1-2-3 = catch(!) => 7-9-10-11
 *      4. try => 에러(3)
 *         1-2-3 = catch(!) => 8-9-10-11
 *    => 목적 에러시에 제외를 하고 나머지 문장을 수행
 *    
 * 멀티 예외처리
 *    
 */
public class 예외처리_예외복구_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			int[] arr=new int[2];
			arr[0]=10;
			arr[1]=0;
			System.out.println(arr[0]/arr[1]);
		}catch(ArithmeticException | ArrayIndexOutOfBoundsException e) // 멀티 블록(or는 | 한개)
		{
			System.out.println("에러 발생");
		}
		System.out.println("프로그램 종료");
	}

}
