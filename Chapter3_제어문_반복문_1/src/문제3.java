// 3) Scanner 클래스를 이용하여 한 개의 정수를 입력 받아 정수의 절대값을 출력하라

import java.util.Scanner;
public class 문제3 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입럭:");
		int a=scan.nextInt();
		
		if(a<0)
			System.out.println(-a);
		else
			System.out.println(a);
		//System.out.println(Math.abs(a));
		
	}

}