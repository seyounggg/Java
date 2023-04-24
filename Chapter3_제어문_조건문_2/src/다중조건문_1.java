/*
 * 	다중 조건문 : 조건이 맞는 문장을 수행하고 종료(한개 문장만 수행)
 * 										=> 여러 문장 수행 : 단일 조건문 사용(독립적)
 * 	예) 1~100까지 숫자 중 3의 배수, 5의 배수, 7의 배수의 합을 출력한다.
 * 					  ------------------------ 단일 3개 사용(!!'15'는 3과 5의배수 둘다 해당되므로 다중조건문을 사용할 수 없음)
 * 	형식) 
 *		if(조건문)
 *		{
 * 			true일 때 수행하는 문장 작성 => 종료
 * 			false 경우 다음문장으로 (↓)
 *		}
 *		else if(조건문)
 *		{
 *			true일 때 수행하는 문장 작성 => 종료
 * 			false 경우 다음문장으로 (↓)
 *		}
 *		else if(조건문)
 *		{
 *			true일 때 수행하는 문장 작성 => 종료
 * 			false 경우 다음문장으로 (↓)
 *		}
 *		else  => 생략이 가능
 *		{
 *			해당 조건이 없는 경우에 처리되는 문장
 *		}
 *		
 */
// 사칙연산 처리
import java.util.Scanner;
public class 다중조건문_1 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번째 정수 입력 :");
		int num1=scan.nextInt();
		System.out.print("두번째 정수 입력 :");
		int num2=scan.nextInt();
		System.out.print("연산자 입력(+,-,*,/):");
		char op=scan.next().charAt(0);//문자열 중에 첫번째에 있는 문자를 추출	 .. 0번부터 시작 ex 3번째 문자 추출하고 싶으면 charAt(2)로 작성하면 됨
		// +,-,*/ => charAt(1) => 자바의 단점 : char는 받을 수 없다(문자열)
		// 경우 +,-,*,/, 다른문자 입력시(else)
		if(op=='+')
		{
			System.out.printf("%d+%d=%d\n",num1,num2,num1+num2);
		}
		else if(op=='-')
		{
			System.out.printf("%d-%d=%d\n",num1,num2,num1-num2);
		}
		else if(op=='*')
		{
			System.out.printf("%d*%d=%d\n",num1,num2,num1*num2);
		}
		else if(op=='/')
		{
			if(num2==0)
				System.out.println("0으로 나눌 수 없습니다!");
			else // 0이 아니라면
				System.out.printf("%d/%d=%2f\n",num1,num2,num1/(double)num2);
		}
		else
		{
			System.out.println("잘못된 연산자입니다!!!");
		}

	}

}