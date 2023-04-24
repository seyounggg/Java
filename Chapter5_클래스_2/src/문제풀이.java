// 1. 사용자로부터 아이디를 받아서 중복 체크하는 메소드 원형을 작성
/*
 * static boolean idCheck(String id)
 */
// 2. 우편번호를 검색하는 메소드 원형을 작성
/*
 * static String[] postfind(String dong)
 */
// 3. 2단에서 9단까지 구구단을 출력하는 메소드 원형 작성
/*
 * Static void gugudan()
 */
public class 문제풀이 {
	//1. 1~10까지 출력하는 메소드 구현
	static void method1()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	//2. 1~10까지 합 
	/*static void method2()
	{
		int sum=0;
		for(int i=1;i<=10;i++)
		{
			sum=+i;
		}
		System.out.println("sum="+sum);
	}*/
	static int method2()
	{
		int sum=0;
		for(int i=1;i<=10;i++)
		{
			sum=+i;
		}
		return sum;
	}
	
	//3.1~n까지 합을 구하는 메소드
	static void method3(int n)
	{
		int sum=0;
		for(int i=1;i<=n;i++) //여기서 n은 매개변수 n!
		{
			sum+=i;
		}
		System.out.println("sum="+sum);
	}
	
	//4. 두 정수의 나눗셈 결과를 구해주는 메소드
	static double method4(int a,int b)
	{
		return a/(double)b; // return이 실수값으로 나가야하니까 b앞에 double 붙여준거임
	}
	
	//5. 문자열의 소문자를 대문자로 바꿔주는 메소드 구현
	static String method5(String s)
	{
		String result="";
		for(int i=0;i<=s.length();i++)
		{
			if(s.charAt(i)>='A' && s.charAt(i)<='Z')
				result+=s.charAt(i);
			else if(s.charAt(i)>='a' && s.charAt(i)<='z')
				result+=(char)(s.charAt(i)-32);
		}
		return result;
		//return s.toUpperCase(); < for문 안돌리고 이렇게 쓸 수 있음.
	}
	
	//6. 문자열을 거꾸로 출력하는 메소드 구현
	static void method6(String s)
	{
		for(int i=s.length()-1;i>=0;i--)
		{
			System.out.println(s.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
		//method2();
		int sum=method2();
		System.out.println("sum="+sum);
		
		method3(100);
		
		double d=method4(10,3);
		System.out.printf("%.2f\n",d);
		
		String s=method5("Hello Java");
		System.out.println(s);
		
		method6("Hello JAva");
	}

}