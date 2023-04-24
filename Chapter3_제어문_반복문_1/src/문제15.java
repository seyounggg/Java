//15) Scanner 클래스를 이용하여 2자리의 정수(10~99사이)를 입력받고, 
//   십의 자리와 1의 자리가 같은 지 판별하여 출력하는 프로그램을 작성하라

import java.util.Scanner;
public class 문제15 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		System.out.print("2자리수 정수 입력(10~99):");
		int a=scan.nextInt();
		if(a>=10 && a<=99) // 범위를 초과할 수 있기때문에 오류 방지를 위한 조건!
		{
			if(a%11==0)
				System.out.println("10의 자리와 1의 자리가 같습니다.");
			else
				System.out.println("같지 않습니다");
		}
		else
		{
			System.out.println("잘못된 입력입니다.");
		}
	}

}