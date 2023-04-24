// 세개의 정수를 입력 받아서 총점 / 평균 / 학점 구하라

import java.util.Scanner;
public class 조건문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor,eng,math;
		Scanner scan=new Scanner(System.in);
		System.out.print("점수 입력(80 90 80):");
		kor=scan.nextInt();
		eng=scan.nextInt();
		math=scan.nextInt();
		
		//결과값 출력
		int total=kor+eng+math;
		double avg=total/3.0;
		// 학점
		int temp=(int)avg;
		char score='A'; // 값이 없으면 null 처리 되므로 띄어쓰기나 값을 꼭 넣어줘야함.
		// 독립적인 문장 => 모든 if를 수행한다(속도가 늦다)
		if(temp>=90 && temp<=100)  // 포함 조건을 사용하므로 && 사용
			score='A';
		if(temp>=80 && temp<90)
			score='B';
		if(temp>=70 && temp<80)
			score='C';
		if(temp>=60 && temp<70)
			score='D';
		if(temp<60)
			score='F'; 
// 단일if문은 전체 다 수행하기 때문에 범위를 정확하게 지정해줘야함.
// 정확한 범위가 설정되지 않으면 평균이 90이더라도 학점은 'D'로 나옴
		
		System.out.println("국어점수는:"+kor);
		System.out.println("영어점수는:"+eng);
		System.out.println("수학점수는:"+math);
		System.out.println("총점:"+total);
		System.out.printf("평균:%.2f\n",avg);
		System.out.println("학점:"+score);
	}

}
