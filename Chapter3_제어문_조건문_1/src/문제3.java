//문제3. 1학년부터 4학년까지 중간고사 시험을 보았다. 4학년은 70점 이상이면 합격, 그 이외의 학년은 60점 이상이면 합격이다. 이를 판단하는 프로그램을 작성해보자.
//      점수가 0미만 100초과이면 경고문구 출력!
// 오류처리 먼저 진행[경고문구 출력] 먼저 했어야함.
/*
 * if(score<0 || score>100)
 * {
 * 		경고
 * }
 */

import java.util.Scanner;
public class 문제3 {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.print("1학년 점수:");
		int a=scan.nextInt();
		System.out.print("2학년 점수:");
		int b=scan.nextInt();
		System.out.print("3학년 점수:");
		int c=scan.nextInt();
		System.out.print("4학년 점수:");
		int d=scan.nextInt();

		if(a>=60)
			System.out.println("1학년 합격입니다");
		else
			System.out.println("1학년 불합격입니다");
		if(b>=60)
			System.out.println("2학년 합격입니다");
		else
			System.out.println("2학년 불합격입니다");
		if(c>=60)
			System.out.println("3학년 합격입니다");
		else
			System.out.println("3학년 불합격입니다");
		if(d>=70)
			System.out.println("4학년 합격입니다");
		else
			System.out.println("4학년 불합격입니다");
	}
	
}