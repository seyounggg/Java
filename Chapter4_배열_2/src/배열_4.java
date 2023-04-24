// 16비트 => 0과1만 저장

import java.util.Scanner;
public class 배열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력:");
		int input=scan.nextInt();
		//System.out.println(Integer.toBinaryString(input)); <- 원래는 이렇게 사용
		//저장공간(0,1)
		int[] binary=new int[16];
		int index=15; //뒤에서부터 채워넣으려고
		while(true)// 횟수를 지정할 수 없어서 while 사용
		{
			binary[index]=input%2;
			input=input/2;
			if(input==0)
				break;
			index--;
			
		}
		// 0%4==>0
		for(int i=0;i<binary.length;i++)
		{
			if(i%4==0 && i!=0)
			{
				System.out.print(" ");
			}
			System.out.print(binary[i]);
		}
		
	}

}