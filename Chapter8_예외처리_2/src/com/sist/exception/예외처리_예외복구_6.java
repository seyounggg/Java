package com.sist.exception;
// 에러발생 시 메세지 확인 => 자바에서 지원
/*
 *  getMessage() : 에러에 대한 메세지만 전송
 *  printStackTrace() : 실행하는 과정 => 어디서 에러가 발생했는지 확인
 *  ----------------
 *  => 오라클 연결
 *     ---- 게시판(500줄)
 *     null
 *     7줄 에러
 */
public class 예외처리_예외복구_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] arr=new int[100];
			arr[100]=100;
		}catch(ArrayIndexOutOfBoundsException e) {
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			System.err.println(e.getMessage());// 권장사항
		}
	}

}
