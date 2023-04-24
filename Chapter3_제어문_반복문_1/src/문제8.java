// 8) 2+4+6+....100까지의 정수의 합을 구하고 출력하라 (for 사용)
public class 문제8 {

	public static void main(String[] args) {

		int sum=0;
		for(int i=2;i<=100;i+=2)
		{
			sum+=i;
		} //i는 {} 안에서만 사용 가능하며, } 끝나면 자동으로 사라진다
		System.out.println("2+4+...100의 합:"+sum);
	}

}