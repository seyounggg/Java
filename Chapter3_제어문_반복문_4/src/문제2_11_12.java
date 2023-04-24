//11. 10개의 정수를 입력 받아 그 수들 중 짝수의 개수가 몇 개 인지 출력하라
//12. 10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력


public class 문제2_11_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//11번 문제
		int c=0;
		for(int i=1;i<=10;i++)
		{
			int num=(int)(Math.random()*100)+1;
			System.out.println("num="+num);
			if(num%2==0)
				c++;
		}
		System.out.println("===결과값===");
		System.out.println("짝수의 총 갯수:"+c);
		
		//12번 문제
		int c3=0,c5=0;
		for(int i=1;i<=10;i++)
		{
			int num=(int)(Math.random()*100)+1;
			System.out.println("num="+num);
			if(num%3==0)
				c3++;
			if(num%5==0)
				c5++;
		}
		System.out.println("===결과값===");
		System.out.println("3의 배수의 총 갯수:"+c3);
		System.out.println("5의 배수의 총 갯수:"+c5);
	}

}