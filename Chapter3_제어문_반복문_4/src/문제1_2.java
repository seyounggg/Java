// 100~999 사이의 4의 배수가 아닌 수의 갯수 및 합
public class 문제1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s=0, c=0;
		for(int i=100;i<=999;i++)
		{
			if(i%4!=0)
			{
				c++;
				s+=i;
			}
			
		}
		System.out.println("갯수:"+c);
		System.out.println("합:"+s);
	}

}