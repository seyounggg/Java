/*
 *	컴퓨처 / 사용자 => 가위바위보
 *	=> 가정 : 0-가위, 1-바위, 2-보
 */
//(순서)1. 컴퓨터 난수 (0~2) → 2. 사용자가 입력 → 3. 컴퓨터/사용자 확인 → 4. 결과값

import java.util.Scanner;
public class 삼항연산자_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int com=(int)(Math.random()*3); // 1.컴퓨터 차례
		Scanner scan=new Scanner(System.in);
		System.out.print("가위(0),바위(1),보(2) 입력:");
		int user=scan.nextInt(); // 2. 사용자 입력
		
		// 3. 확인
		System.out.println(com==0?"컴퓨터:가위":"");
		System.out.println(com==1?"컴퓨터:바위":"");
		System.out.println(com==2?"컴퓨터:보":"");
		
		System.out.println(user==0?"플레이어:가위":"");
		System.out.println(user==1?"플레이어:바위":"");
		System.out.println(user==2?"플레이어:보":"");
		
		System.out.println("=====결과====="); // 4. 결과값
		/*System.out.println(com==0 && user==0?"Same":"");
		System.out.println(com==0 && user==1?"User Win":"");
		System.out.println(com==0 && user==2?"Com Win":"");
		
		System.out.println(com==1 && user==0?"Com Win":"");
		System.out.println(com==1 && user==1?"Same":"");
		System.out.println(com==1 && user==2?"User Win":"");
		
		System.out.println(com==2 && user==0?"User Win":"");
		System.out.println(com==2 && user==1?"Com Win":"");
		System.out.println(com==2 && user==2?"Same":"");*/
		int res=com-user;
		System.out.println(res==0?"Same":"");
		System.out.println(res==-1 || res==2?"User Win":"");
		System.out.println(res==1 || res==-2?"Com Win":""); // 위 9줄과 같은 값이 나옴
		
		/*
		 * 	com           user
		 * 		0(가위)	0(가위) => 비김   
		 * 				1(바위) => user Win
		 * 				2(보)  => com Win
		 * 
		 * 		1(바위)  0(가위) => com Win
		 * 				1(바위) => 비김
		 * 				2(보)  => user Win
		 * 
		 * 		2(보)    0(가위) => user Win
		 * 				1(바위) => com Win
		 * 				2(보)  => 비김
		 */
	}

}