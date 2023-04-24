import java.util.Scanner;

//UpDown 게임
/*
 * 컴퓨터가 난수 발생 (1~100 사이의 난수)
 * => 사용자 입력
 * => 입력시에 힌트
 * => for문 횟수 ? 맞출때까징~
 * 		=> ★무한루프 : for(;;)
 * 
 */

public class 반복문_6 {

	public static void main(String[] args) {
		int com=(int)(Math.random()*100)+1;
		int count=0; // 몇번만에 맞췄는지 횟수!!
		Scanner scan=new Scanner(System.in);
		
		for(;;) // 무한루프 => while문 => 종료시점 ★중요중요★
		{
			System.out.print("1~100까지 사이의 정수 입력:");
			int user=scan.nextInt();
		
			
			if(user>=1 && user<=100)
			{
				count++; //정상 입력값만 count 하겠다는 의미
				//힌트
				if(com>user)
				{
					System.out.println("입력한 수보다 큰값을 입력하세요(UP)");
				}
				else if(com<user)
				{
					System.out.println("입력한 수보다 큰값을 입력하세요(DOWN)");
				}
				else if(com==user)
				{
					System.out.println("--------GAME OVER--------");
					System.out.println("입력회수:"+count);
					System.exit(0);
				}
				
			}
			else
			{
				System.out.println("잘못된 입력입니다!!");
			}
				
			}
		
	}

}