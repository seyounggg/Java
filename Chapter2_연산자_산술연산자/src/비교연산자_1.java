/*
 * 	단항연산자, 산술연산자 : 계산방향 → 
 * 	대입연산자, 삼항연산자 : 계산방향 ←
 *  괄호연산자() : 최우선순위
 *  
 * 	비교연산자 => 결고값 (boolean) => true / false
 * 		== 같다
 * 		!= 같지않다
 * 		<  작다 -> 왼쪽이 기준
 * 		>  크다 -> 왼쪽이 기준
 * 		<= 작거나 같다
 * 		>= 크거나 같다
 * 		예)
 * 			7==6 false
 * 			7!=6 true
 * 			---- byte, int, short, long, double, float, boolean, char
 * 			---- "a"=="a" => equals() <- 가장많이 등장하는 연산자*** //아직은 안배웠엉
 * 			'A'<'B' (65<66) true
 * 			10>5 true
 * 			10<=10 true (10<10||10==10) / 10<=10 true (10>10||10==10)
 * 		
 * 
 */
public class 비교연산자_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=(int)(Math.random()*100)+1; //랜덤발생
		/*
		 * int a=(int) (Math.random() *100) +1;
		 *       ----  --------------  ---  ---
		 *         3          1         2   4
		 *       (0~99)   (00~0.99)         (1~100)
		 */
		int b=(int)(Math.random()*100)+1; //랜덤발생
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		//1. ==
		boolean b1=a==b;
		System.out.println("a==b"+b1);
		//2. !=
		b1=a!=b;
		System.out.println("a!=b"+b1);
		//3. <
		b1=a<b;
		System.out.println("a<b"+b1);
		//4. >
		b1=a>b;
		System.out.println("a>b"+b1);
		//5. <=
		b1=a<=b;
		System.out.println("a<=b"+b1);
		//5. >=
		b1=a>=b;
		System.out.println("a>=b"+b1);
				
	}

}