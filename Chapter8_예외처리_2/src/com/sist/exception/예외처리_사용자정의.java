package com.sist.exception;
import java.util.*;
// 사용자정의 => Exception 을 상속
class MyException extends Exception{
	public MyException(String message) {
		super(message); //getMessage()
	}
}
public class 예외처리_사용자정의 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력:");
		int num=scan.nextInt();
		try {
			if(num%2==0) {
				throw new MyException("짝수입니다!!");
				//사용자 정의는 반드시 예외처리 시 호출을 해야함
			}
		}catch(MyException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
