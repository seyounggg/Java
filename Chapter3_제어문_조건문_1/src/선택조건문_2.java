//한개의 점수를 받아서 60점 이상이면 합격 아니면 불합격 / 조건은 한개만 걸면 돼

import java.util.Scanner;
public class 선택조건문_2 {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.print("점수입력:");
		//입력을 받아서 -> 저장
		int num=scan.nextInt();
		
		//요청 -> 처리
		if(num>=60)
			System.out.println(num+"는(은) 합격입니다");
		else
			System.out.println("불합격입니다");
	}

}