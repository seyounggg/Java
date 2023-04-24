//0-12까지의 2의 배수,3의 배수의 합을 구하여라

public class 문제2_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a2=0,a3=0;
		for(int i=1;i<=12;i++)
		{
			if(i%2==0)
				a2+=i;
			if(i%3==0)
				a3+=i;
			/*
			 * if(i%2==0 || i%3==0)
			 * 		int sum+=i; //2의 배수, 3의 배수가 중복값이 있으므로 각각 누적되지 않음.
			 * 					//그래서 사용하면 안됨
			 */
		}
		System.out.println("sum="+(a2+a3));

	}

}
