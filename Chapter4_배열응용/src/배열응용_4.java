import java.util.Arrays;
import java.util.Scanner;
/*
 * 숫자 야구게임
 * 1. 컴퓨터 => 임의의 숫자 3개 발생 (1~9까지 중복없는 난수)
 * 	  3 6 9
 * 2. 사용자가 숫자를 입력해서 발생된 난수를 맞추는 게임
 * 3. 힌트
 * 예) 2 9 6 0S-2B
 *    3 7 8 1S-0B
 *    3 9 8 1S-1B
 *    3 6 9 3S-0B
 */
public class 배열응용_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] com=new int[3]; //난수 -> 저장
		int[] user=new int[3]; //입력을 받아야함
		for(int i=0;i<com.length;i++)
		{
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0;j<i;j++)
			{
				if(com[i]==com[j])
				{
					i--;
					break;
				}
			}
		}
		//System.out.println(Arrays.toString(com));
		//사용자가 입력
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.print("세자리 정수 입력:");
			int input=scan.nextInt();
			if(input<100 || input>999) //세자리정수가 입력되지 않을 경우의 오류를 잡기 위해 작성하는 if문
			{
				System.out.println("잘못 입력 했습니다");
				continue; // 처음부터 다시 수행(while)
			}
			
			//세자리 정수를 입력했다면
			user[0]=input/100; //369/100 => 3
			user[1]=(input%100)/10;//369%100 =>69/10 =>6
			user[2]=input%10;//369%10 =>9
			
			//1. 같은 정수를 입력하면 안된다
			if(user[0]==user[1] || user[1]==user[2] || user[2]==user[0])
			{
				System.out.println("중복된 수는 사용할 수 없습니다.");
				continue;
			}
			
			//2. 0을 포함 할 수 없다
			if(user[0]==0 || user[1]==0 || user[2]==0)
			{
				System.out.println("0을 포함할 수 없습니다");
				continue;
			}
			// 여기까지 user입력 관련 오류 처리
			
			//힌트 준비
			int s=0,b=0;
			for(int i=0;i<com.length;i++)
			{
				for(int j=0;j<i;j++)
				{
					if(com[i]==user[j])
					{
						if(i==j) // 같은자리인지?
							s++;
						else //다른자리인지?
							b++;
					}
				}
			}
			//힌트제공
			//System.out.printf("Input:%d,result:%dS-%dB\n",input,s,b);
			System.out.println("==============");
			System.out.print("S:");
			for(int i=0;i<s;i++)
			{
				System.out.print("●");
			}
			System.out.print("\nB:");
			for(int i=0;i<b;i++)
			{
				System.out.print("○");
			}
			
			System.out.println("\n==============");
			//종료 시점 ==> s==>3
			if(s==3)
			{
				System.out.println("GAME OVER!!");
				break;
			}
		}
		
	}

}