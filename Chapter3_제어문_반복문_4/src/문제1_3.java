//1~30 짝수합, 홀수합을 출력하는 프로그램을 작성
public class 문제1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s1=0,s2=0;
		for(int i=1;i<=30;i++)
		{
			if(i%2==0)
				s1+=i;
			else
				s2+=i;
		}
		System.out.println("짝수합:"+s1);
		System.out.println("홀수합:"+s2);
	}

}