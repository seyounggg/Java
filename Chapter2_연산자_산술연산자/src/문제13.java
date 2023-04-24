/*
 * 14) 두 개의 정수를 입력 받아서 첫째 수를 둘째 수로 나눈 나머지를 출력하는 프로그램을 작성해 보자.
 */
import java.util.Scanner;
public class 문제13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("정수1:");
		int num1=scan.nextInt();
		System.out.print("정수2:");
		int num2=scan.nextInt();
		
		System.out.println(num1%num2);
/*
 * [강사님 풀이]-사용자에게 입력받지 않고 랜덤으로 설정해두었음
 * int a,b;
 * a=(int)(Math.random()*100)+1;
 * b=(int)(Math.random()*100)+1;
 * System.out.printf("a=%d, b=%d, a%%b=%d",a,b,a%b);
 */
	}

}