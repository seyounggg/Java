//12) 1부터 30까지의 정수에서 짝수만 한 줄에 3개씩 출력하라

public class 문제12 {

	public static void main(String[] args) {

		for(int i=1;i<=30;i++)
		{
			if(i%2==0)
			{
				System.out.printf("%2d\t",i); //%2d -> 2자리 차지!
				if(i%3==0)
					System.out.println(); //다음줄에 출력하라
			}
		}
	}

}
