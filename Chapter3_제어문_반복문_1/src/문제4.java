//4) 년도를 입력 받아 윤년인지 아닌지를 판별하는 방법을 if~else문으로 사용하라

import java.util.Scanner;
public class 문제4 {

	public static void main(String[] args) {

			Scanner scan=new Scanner(System.in);
			System.out.print("정수입력:");
			int year=scan.nextInt();

			if((year%4==0 && year%100!=0) || (year%400==0)) //윤년조건 외워두기(달력 만들 때 윤년 필요!)
			{
				System.out.println(year+"년도는 윤년입니다");
			}
			else
			{
				System.out.println(year+"년도는 윤년이 아닙니다");
			}
	}

}