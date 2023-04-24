import java.util.Arrays;
import java.util.Scanner;
/*
 *  1. 난수발생
 *  2. 사용자 입력
 *  ------------- 메소드1
 *  3. 비교
 *  4. 힌트
 *  ------------- 메소드2
 *  5. 종료여부
 *  ------------- 메소드3
 */

public class 메소드조립법_3 {
	

	public static void main(String[] args) {

		int[] com=new int[3];
		int[] user=new int[3];
		// 난수발생
		for(int i=0;i<3;i++)
		{
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0;j<i;j++) // 두번째 부터 비교하려고 < 사용
			{
				if(com[i]==com[j])
				{
					i--; // 현재 저장된 데이터에 다시 난수 발생을 한다.(중복이라면, 증가하지 말고 i차례를 다시 해라!)
					break;
				}
			}
		}
		//System.out.println(Arrays.toString(com));
		Scanner scan=new Scanner(System.in);
		//사용자 입력
		while(true)
		{
			System.out.print("세자리 정수 입력:");
			int input=scan.nextInt();
			// 정상 입력 => &&
			// 오류 => ||
			if(input<100 || input>999)
			{
				System.out.println("잘못된 입력입니다!!!");
				//while의 조건식으로 이동 => 처음부터 다시 시작
				continue;
			}
			user[0]=input/100; //369/100=>3
			user[1]=(input%100)/10; //(369%100) =>69/10 => 6
			user[2]=input%10;
			
			// 세자리 정수가 모두 같을 경우의 오류처리
			if(user[0]==user[1] || user[1]==user[2] || user[2]==user[0])
			{
				System.out.println("같은 숫자는 사용이 불가능합니다!!!");
				continue;
			}
			// [0]0이 입력되면 10진수가 되므로 0을 입력하지 못하게 하는 오류처리
			if(user[0]==0 || user[1]==0 || user[2]==0)
			{
				System.out.println("0을 입력할 수 없습니다!!!");
				continue;
			}
			
			//비교
			int s=0,b=0;
			//s=같은 자리의 수가 동일, b=다른 자리에 있는 수가 동일
			for(int i=0;i<3;i++) //com
			{
				for(int j=0;j<3;j++) //user
				{
					if(com[i]==user[j]) // 같은 수가 있는지
					{
						if(i==j) // 같은 위치가 있는지
							s++;
						else     // 같은 수는 있는데 위치가 다를경우
							b++;
					}
				}
			}
			
			//힌트
			System.out.printf("Input:%d,Result:%dS-%dB\n",input,s,b);
			if(s==3)
			{
				System.out.println("GAME OVER!!!");
				break;
			}
		}
	}

}