// 100~999 사이에 7의 배수의 갯수와 합을 출력하는 프로그램 작성

public class 문제1_1 {

	public static void main(String[] args) {
		
		int s=0, c=0;
		for(int i=100;i<1000;i++)
		{
			if(i%7==0)
			{
				c++;
				s+=i;
			}

		}
		System.out.println("7의 배수 갯수:"+c);
		System.out.println("7의 배수 합:"+s);
	}
}