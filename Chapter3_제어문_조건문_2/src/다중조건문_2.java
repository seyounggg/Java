// 성적 계산
// 세개의 정수를 받아서 평균을 구해서 등급 출력
// 다중 조건문 사용
/*
 * >=90
 * >=80
 * >=70
 * >=60
 * -----else
 */

import java.util.Scanner;
public class 다중조건문_2 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		// Scanner는 도스에서만 사용이 가능
		// System.in(키보드 입력값) : 입력값을 받아서 메모리에 저장해주는 역할
		// 정수:nextInt() , 실수:nextDouble(), 논리:netxtBoolean(), 문자열:next()
		System.out.print("세개의 정수 입력(10 20 30):");
		int kor=scan.nextInt();
		int eng=scan.nextInt();
		int math=scan.nextInt();
		int avg=(kor+eng+math)/3;
		System.out.println("국어점수:"+kor);
		System.out.println("영어점수:"+eng);
		System.out.println("수학점수:"+math);
		
		System.out.println("총점:"+(kor+eng+math));
		System.out.printf("평균:%.2f\n",(kor+eng+math)/3.0);
		
		// 학점 계산
		char score='F'; //default 값이 'F'라서 조건에 해당되지 않으면 자동으로 'F'가 나옴 (else를 작성하지 않아도 돼)
		//값 변경이 없는 경우 처리되는 값(default)
		if(avg>=90)
			score='A'; // 하나의 문장 수행 후 종료
		else if(avg>=80)
			score='B'; // 하나의 문장 수행 후 종료
		else if(avg>=70)
			score='C'; // 하나의 문장 수행 후 종료
		else if(avg>=60)
			score='D'; // 하나의 문장 수행 후 종료
		else // 생략이 가능
			score='F';
		System.out.println("학점:"+score);
			
	}

}