//1~1000까지에서 7의 배수의 합, 9의 배수의 합, 7의배수+9의배수 합
public class 문제1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s1=0,s2=0;
		for(int i=1;i<=1000;i++)
		{
			if(i%7==0)
				s1+=i;
			if(i%9==0)
				s2+=i;
		}
		System.out.println("7의 배수:"+s1);
		System.out.println("9의 배수:"+s2);
		System.out.println("7의배수+9의배수:"+(s1+s2));
	}

}