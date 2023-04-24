/*
 * 자바에서 지원하는 반복문
 * ------------------
 * 	for :  반복 횟수가 지정된 경우에 주로 사용
 * 		= 일반 for
 * 		= for - each : 출력용(웹에서 가장 많이 등장 : 향상된 for)
 * 		while : 반복 횟수를 모르는 경우 (선조건)
 * 		do ~ while : 반복횟수를 모르는 경우(후조건) => 무조건 1이상은 수행이 가능하다
 * 		
 * 		=> 유사한 내용을 여러번 출력을 할때 주로 사용 (합계 구하기, 통계..목록 출력...
 * 		=> 형식)
 * 			for
 * 			for(int i=1;<=10;i++) => 10번 수행 // for(int i=0;i<9;i++) 똑같이 10번 수행하는 식
 * 			{
 * 			}
 * 			for(초기값;조건식;증감식)
 * 			{
 * 				반복 실행문장
 * 			}
 * 
 * 			초기값 : 시작점 ==> 한번만 수행
 * 			조건식 : 수행을 중단할 때(종료점)
 * 			증감식 : 초기값 ~ 조건식 => false 일때까지 수행
 * 				 : 감소도 가능 for(int i=10;i>=1;i--) 
 * 				 : 증가는 여러개 증가도 가능하다 for(int i=1;i<10;i+=2) i=1, i=3, i=5 ...
 * 													      ------ 복합 대입연산자
 * 		=> 실행순서(★프로그램에서 가장 많이 사용되는 제어문 : for,if)
 * 			for문은 한 문장만 수행이 가능
 * 			여러문장 사용시에는 {}을 이용해서 처리한다
 *                       
 *                       ↗ false → 반복문 종료
 * 			     ①  →  ②  ← ④
 * 			for(초기값;조건식;증감식)
 * 			{              ↗ 
 *                  ↓ true
 *                  ③
 * 				반복 실행문장
 * 			}
 * 			①초기값 => ②조건식에 대입 => false => 종료(for)
 * 										=> true => ③반복수행문장 수행 => ④초기값 증가
 * 					 ② → ③ → ④ 를 n차 반복하다가 false가 되면 종료
 * 
 * 
 */
public class 반복문_1 {

	public static void main(String[] args) {
		//Hello Java를 10번 출력
		System.out.println("hello Java");
		System.out.println("hello Java");
		System.out.println("hello Java");
		System.out.println("hello Java");
		System.out.println("hello Java");
		System.out.println("hello Java");
		System.out.println("hello Java");
		System.out.println("hello Java");
		System.out.println("hello Java");
		System.out.println("hello Java");

		System.out.println("=======for문 이용=======");
		// 반복문 이용
		for(int i=1;i<=10;i++)
		{
			System.out.println("Hello Java");
		}
		System.out.println("=======for문 이용=======");
		// 반복문 이용
		for(int i=0;i<10;i++)
		{
			System.out.println((i+1)+". Hello Java");
		}
	}

}