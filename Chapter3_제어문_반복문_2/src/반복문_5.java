// 가위바위보 게임
/*
 * 	컴퓨터       사용자
 * 		가위(0)  가위(0),바위(1),보(2)
 * 		바위(1)  가위(0),바위(1),보(2)
 * 		 보(2)  가위(0),바위(1),보(2)
 * 	식 : 컴퓨터 - 사용자 = ?
 * 	비기는 경우 : 0
 *  사용자가 이길 경우 : -1,2
 *  컴퓨터가 이길 경우 : -2,1
 */

import java.util.Scanner;
public class 반복문_5 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		int win=0,lose=0,same=0;
		while(true) //for(;;) - 무한루프식
		{
			System.out.print("가위(0),바위(1),보(2),종료(9):");
			// 컴퓨터가 난수 발생
			int com=(int)(Math.random()*3); //0,1,2
			int user=scan.nextInt();
			
			if(user==9)
			{
				System.out.println("게임 종료!!");
				//System.exit(0); > 이걸 사용하면 while문 에서 바로 끝남
				break; //while 종료 > while에서 빠져나오기
			}
			
			//컴퓨터와 사용자의 가위바위보
			if(com==0)
				System.out.println("컴퓨터:가위");
			else if(com==1)
				System.out.println("컴퓨터:바위");
			else if(com==2)
				System.out.println("컴퓨터:보");
			
			if(user==0)
				System.out.println("사용자:");
			else if(user==1)
				System.out.println("사용자:바위");
			else if(user==2)
				System.out.println("사용자:보");
			
			//결과값 출력
			switch(com-user)
			{
			case -1: case 2:
				System.out.println("사용자 WIN");
				win++;
				break;
			case 1: case -2:
				System.out.println("컴퓨터 WIN");
				lose++;
				break;
			case 0:
				System.out.println("비겼다");
				same++;
				break;
			}
			
		} //while 종료
		System.out.println("=====결과값=====");
		int total=win+lose+same;
		System.out.printf("%d전 %d승 %d패 %d무\n",total,win,lose,same);
	}

}