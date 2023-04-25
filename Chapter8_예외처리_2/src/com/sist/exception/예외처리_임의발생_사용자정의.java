package com.sist.exception;
/*
 * throws : 예상되는 에러를 선언해둔다
 *         => 메소드를 사용시에 다른 메소드에서 처리 후 사용
 *         => 선언만 할 수도 있고, 처리 후에 사용할 수도 있다
 *         => 다른 메소드로 전가
 *         => 라이브러리가 보통 선언을 하고 있다
 *            -------- 선언(CheckException만 등록)
 *            IO / NET / Thread / Web / JDBC => 웹 관련 
 *  throw : 고의로 예외를 발생(테스트용)
 * 
 */
import java.util.*;
public class 예외처리_임의발생_사용자정의 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			/*try {
			Scanner scan=new Scanner(System.in);
			System.out.print("정수 입력 :");
			int score=scan.nextInt();
			//System.out.println("score="+score);
			if(score<0) {
				throw new IllegalArgumentException(); //catch를 호출한다
			}
			System.out.println("score="+score);
	
		}catch(IllegalArgumentException e) {
			System.out.println("정수는 음수를 사용할 수 없습니다");
		}*/
			Scanner scan=new Scanner(System.in);
			System.out.print("정수 입력 :");
			int score=scan.nextInt();	
			if(score<0) {
				System.out.println("정수는 음수를 사용할 수 없습니다");
			}
			else {
				System.out.println("score="+score);
			}
			// 위 문장에서는 if문을 사용하는 것이 더 편하다.
			// 예외처리를 할 경우에는 조건문으로 처리가 가능한지 먼저 확인 후 클래스를 이용하는 것이 더 편하다
	}
}
