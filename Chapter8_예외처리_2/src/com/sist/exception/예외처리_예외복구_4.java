package com.sist.exception;
/*
 * 책 272page
 *    배열에 데이터 저장 => 배열범위 초과
 *    나누기를 처리 => 0
 *    기타 예외처리 => 통합
 *    ------------------ RuntimeException
 *    (***) 가장 큰 예외처리는 마지막에 사용한다!
 *    
 */
public class 예외처리_예외복구_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] arr= new int[2];
			arr[0]=10;
			arr[1]=2;
			System.out.println(arr[0]/arr[1]); //<- 이 코드는 정상 수행이 가능한 코드이므로 catch절 수행 없이 종료! 
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 초과");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다");
		}catch(RuntimeException e) { // 가장 큰거는 가장 마지막에 작성해야함. 안그러면 오류발생
			System.out.println("예츨 못한 에러!!!");
		}
		System.out.println("PROGRAM OVER");
	}

}
/*
* RuntimeException이 ArraIn...와 Arithme.. 을 포함하고 있기 때문에
* 먼저 선언을 할 경우 catch문에 오류가 발생한다.  상속도를 잘 확인해서 큰게 아래로 내려갈 수 있도록 코드를 작성해야 한다
*/