/*
 * 12) 사용자로부터 두 개의 정수를 입력 받아서 뺄셈과 곱셈 연산의 결과를 출력하는 프로그램을 작성
	
		[작성 순서 및 형식]
		1. 변수 : int a,b
		2. 초기화 : Scanner
		3. 연산처리 : a-b, a*b
		4. 결과 출력
		
		데이터 저장 =====> 데이터 가공(연산처리) =====> 결과값 출력(system.out.println)
														
		# 데이터 저장 : 1) 직접 값 입력(int a=10) / 2) 사용자로부터 입력 받기 / 3)난수 / 4)파일에서 일기 / 5)오라클에서 값 읽기
					------------------------------------------------------   ------------------------------
									    	(메모리)
 */
import java.util.Scanner;
public class 문제11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in); //System.in = 키보드 입력값
		System.out.print("정수1:");
		int num1=scan.nextInt();
		System.out.print("정수2:");
		int num2=scan.nextInt();
		
		System.out.println("정수1-정수2:"+(num1-num2));
		System.out.println("정수1*정수2:"+num1*num2);
		/*
		 * [강사님 풀이]
		 * import java.util.Scanner;
				public class 문제12번 {
				public static void main(String[] args) {
				// TODO Auto-generated method stub
				Scanner scan=new Scanner(System.in);
				System.out.print("정수 두개를 입력하세요(a b):"); // 입력하는 숫자 사이에 띄어쓰기를 하면 동시에 두개를 입력할 수 있음
				int a=scan.nextInt();
				int b=scan.nextInt();
				System.out.println(a-b));
				System.out.println(a*b);
		 * 
		 */
	}

}