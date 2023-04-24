// 사용자로부터 두개의 정수(시작, 끝)를 입력받아 시작(포함)해서 끝(포함)까지의 곱을 출력
// 첫번째 정수보다 두번째 정수가 커야한다...?
import java.util.Scanner;
public class 문제2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번째 정수 입력:");
		int s=scan.nextInt();
		//System.out.print("두번째 정수 입력:");
		//int e=scan.nextInt();
		int e=0;
		while(true)
		{
			System.out.print("두번째 정수 입력:");
			e=scan.nextInt();
			if(e<s)
			{
				System.out.println("첫번째 정수보다 큰수여야 합니다");
				continue;
			}
			break; // while 오류 처리 _ 두번쨰 정수가 작았을 때 프로그램이 꺼지지 않게 하기 위해
		}
		int g=1;
		for(int i=s;i<=e;i++)
		{
			g*=i;
		}
		System.out.println(s+"부터"+e+"까지의 합:"+g);
		
	}

}