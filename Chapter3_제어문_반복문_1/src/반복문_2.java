// 1~100까지의 합
public class 반복문_2 {

	public static void main(String[] args) {
		
		int sum=0;
		for(int i=1;i<=100;i++)
		{
			sum=sum+i; //sum+=i;
			System.out.println("sum="+sum+",i="+i);
		}
		System.out.println("=====최종 결과 값=====");
		System.out.println("1~100까지의 합:"+sum);
		
		sum=0; // 값을 변경 => 다시 누적(합의 초기값은 0/곱의 초기값은 1)
		for(int i=0;i<=100;i+=2)// 짝수를 구하기 위해서 i=0 으로 시작 및 +2씩 증가
		{
			sum+=i; //sum+=i;
		}
		System.out.println("=====최종 결과 값=====");
		System.out.println("1~100까지의 짝수합:"+sum);
		
		sum=0;
		for(int i=1;i<=100;i+=2)// 홀수를 구하기 위해서 i=1 으로 시작 및 +2씩 증가
		{
			sum+=i; 
		}
		System.out.println("=====최종 결과 값=====");
		System.out.println("1~100까지의 홀수합:"+sum);
		
		sum=0;
		for(int i=3;i<=100;i+=3) // 0으로 시작하면 0,3,6,9 가 되므로 0으로 시작하지 않음
		{
			sum+=i; 
		}
		System.out.println("=====최종 결과 값=====");
		System.out.println("1~100까지의 3의 배수합:"+sum);
	}

}