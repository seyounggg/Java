// 정수 입력 받아서 60이상 합격 => 불합격 if else

import java.util.Scanner;
public class 문제1_7 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print
		("점수 입력:");
		int a=scan.nextInt();
		if(a>=60)
			System.out.println("합격");
		else
			System.out.println("불합격");
			
	}
		
}