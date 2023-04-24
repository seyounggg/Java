//5개 정수를 입력받은 후 차례로 출력하는 프로그램 ?? 

import java.util.Scanner;
public class 문제8 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("입력:");
		int[] arr=new int[5];
		
		for(int i=0;i<arr.length;i++)
		{	
			System.out.print("입력:");
			arr[i]=scan.nextInt();
		}
		System.out.println();
		
		/*
		 * int[] arr={1 2 3 4 5};
		 */

	}

}