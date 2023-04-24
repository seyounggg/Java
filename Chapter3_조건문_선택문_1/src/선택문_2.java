//성적 계산
/*
 * [if(month>=3 && month<=5)] == [case 3: case 4: case5:] / if문 == switch
 */

import java.util.Scanner;
public class 선택문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		System.out.print("세개의 정수 입력(10 20 30):");
		int kor=scan.nextInt();
		int eng=scan.nextInt();
		int math=scan.nextInt();
		int avg=(kor+eng+math)/3;
		
		//학점 출력
		//case는 중복 안돼~!
		char score='A';
		switch(avg/10)
		{
		case 10: // 100
		case 9: // 99~90 => (avg/10)==10 || (avg/10)==9
			score='A';
			break;
		case 8:
			score='B';
			break;
		case 7:
			score='C';
			break;
		case 6:
			score='D';
			break;
		default: // 생략 가능 ==> if문에서의 else와 같다
			score='F';
			
		}
		System.out.println("학점:"+score);
	}

}