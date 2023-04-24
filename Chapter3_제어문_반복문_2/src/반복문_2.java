//while => 반복횟수가 업슨 경우에 주사용(무한루프_종료하지 않는 프로그램)
public class 반복문_2 {

	public static void main(String[] args) {
		// 1~100까지의 합, 짝수의 합, 홀수의 합을 구하라
		int sum=0,even=0,odd=0; // 누적하려면 0값으로 초기화
		
		// 1~100까지 증가하는 변수 => 루프변수
		/*int i=1;
		while(i<=100)
		{
			sum+=i; //총합
			if(i%2==0)
				even+=i; //짝수합
			else
				odd+=i; //홀수합
			i++;
		}*/
		for(int i=1;i<=100;i++)
		{
			sum+=i;
			
			if(i%2==0)
				even+=i;
			else
				odd+=i;
					
		}
		System.out.println("1~100까지의 총 합:"+sum);
		System.out.println("1~100까지의 총 합:"+even);
		System.out.println("1~100까지의 총 합:"+odd);
		
	}

}