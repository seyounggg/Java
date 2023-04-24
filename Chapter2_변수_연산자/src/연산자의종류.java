/*
 * 	피연산자 / 연산자
 * 	------ 연산 대상
 * 
 * 	피연산자 1개 : 단항연산자 a++
 * 	피연산자 2개 : 이항연산자 10+20
 * 	피연산자 3개 : 삼항연산자
 * 
 * 	1. 단항연산자
 * 	 = 증감연산자 (++ , --) 한개 증가 or 한개 감소 => 반복문
 * 		[형식]
 * 		전치연산자 : 먼저 증가/감소 ++a
 * 		후치연산자 : 나중에 증가/감소 a++
 * 		int a=10;
 * 		int b = ++a; // 증가하고 대입
 * 		     -- --
 * 			     1
 * 			  2 =======> a=11, b=11
 * 
 * 		int b = a++; // 대입을 하고 증가
 *           -- --
 *           1 ======> b=10 a=11
 *              2 
 *    예) int b= a++ + a++ + a++ + a++ = 46
 *    예) int b= ++a + ++a + ++a + ++a = 50
 *    예) int b= a-- + a-- + --a = 26
 *      
 *      
 * 	 = 부정연산자 (boolean만 사용 가능)  ! => 턴 
 * 		boolean b=true;
 * 		!b; ==> false
 * 		!true => false
 * 		!false => true
 * 		
 * 		== . != !(조건)		
 * 
 * 	 = 형변환연산자 (데이터형)
 * 		(int)10.5 => 10 소수점 제거
 * 		(char)65 => 'A'
 * 		------------------------> downcasting (강제형변환)
 * 		(double)10 => 10.0
 *  	(int)'A' => 65
 *  	------------------------> upcasting (자동형변환)
 *  
 *  	예) 10.5+10.5 ==> 21.0
 *		(int)10.5  +  (int)10.5 => 20
 *		--------  ---  ---------
 *		     1     3      2      > 순서
 *		(int)(10.5+10.5) => 21
 *      ----  -----------
 *        2        1
 *        
 *      10.5+10=20.5 ==> 데이터형이 동일할 때 연산이 가능
 * 		    ---
 * 			10.0으로 변환             
 *
 * 		==> int 이하의 데이터형은 연산시에 결과값이 int다
 * 		------- byte/short/char
 * 		char+char int
 * 		car+byte int
 * 		==> char는 연산이 되면 정수로 변경된다
 * 
 * 		int + double => double
 * 		char + long => long
 * 		int + long => long
 * 		long + double => double
 * 		byte + char => int
 * 
 * 	 = 반전연산자 (양수->음수) 음수표현 ~
 * 
 * 2. 이항연산자
 * 	 = 산술연산자 : + , -, *, /, %
 * 		=> + , -, * : 데이터형
 * 		=> + 
 * 		  산술연산, 문자열 결합
 * 		=> /
 * 		  정수/정수=정수 ==> 10/3 => 3
 * 		  정수/실수 ==> 10/3.0
 * 		  0으로 나누면 오류발생
 * 		=> % //나누고 남은 수
 * 		  10%2 ==> 0
 * 		  10%2 ==> 1
 * 		-------------
 * 		  5%2=1
 * 		  -5%2=-1
 * 		  5%-2=1
 * 		  -5%-2=-1
 * 		------------- 부호는 왼쪽편을 따라간다
 * 		 (중요중요) + 연산자
 * 			+  10+9=19
 * 			+ : 문자열 결합
 * 			"7"+77 ==> "777"
 * 			7+"7"+7 ==> "777"
 * 			7+7+"7" ==> "147" // 더하기 연산자가 앞에 있으므로 7+7=14를 먼저 진행 후 "7"을 결합
 * 			7+"7"+7+7 ==> "7777" 
 * 			7+"7"+(7+7) ==> "7714"
 * 		  
 */
public class 연산자의종류 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*byte b=10;
		char c='A';
		int a=b+c;*/
		/*byte b=10;
		byte c=20;
		int d=b+c;
		System.out.println(~10);*/
		/*int a=10;
		int b=a--+a--+--a;
		System.out.println("a="+a);
		System.out.println("b="+b);*/
		/*boolean bCheck=false;
		System.out.println(bCheck); // false
		System.out.println(!bCheck); // true*/
		int a=(int)(Math.random()*100)+1;
		//1		  -------------------
		//              0.0~0.99
		//2   ----
		//3                            --
		System.out.println(a);
		System.out.println(10/0);
		System.out.println(10/3.0);

	}

}