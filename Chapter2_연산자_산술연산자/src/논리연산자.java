// && ||
/*
 * 	(조건) %% (조건)
 * 	-----	 -----
 * 	  |		   |
 * 	  ----------
 * 		  |
 * 		 결과
 * 
 * 	
 * 	&& => 범위나 기간을 포함한 경우
 * 	--------------------
 * 	true true  => true
 * --------------------
 * 	true false => false
 * --------------------
 *  false true => false
 *  --------------------
 *  false false => true
 *  --------------------
 *  
 *  || => 범위나 기간을 벗어난 경우 : 행사
 *  --------------------
 * 	true true  => true
 *  --------------------
 * 	true false => true
 *  --------------------
 *  false true => true
 *  --------------------
 *  false false => false
 *  --------------------
 *  
 *  => 효율적 연산 : 앞의 조건이 false or true면 뒤 조건은 확인 안해
 *    () && ()
 *          -- 
 *   false
 *    () || ()
 *          -- 
 *   true
 *   
 *   	예)
 *   		int a=10;
 *   		int b=9;
 *   		(a<b) && ++b==a
 */
public class 논리연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int a=10;
		int b=9;
		boolean bCheck= (a<b) && ++b==a;
		System.out.println(bCheck);
		System.out.println("b="+b); //(a<b)가 이미 false이므로 ++b==a 조건을 수행하지 않기때문에 ++b에서 b는 증가하지 않아 b=9
		
		bCheck= (a<b) || ++b==a;
		System.out.println(bCheck);
		System.out.println("b="+b); // 앞조건이 false라 뒤 조건을 수행하기 때문에 b가 10으로 하나 증가*/
		
		/*int a=100;
		int b=99;
		boolean bCheck= (a>b) && (b==a); // b==a가 false이므로 결과는 false
		System.out.println(bCheck);
		
		bCheck= (a>b) || (b==a); //a>b가 true 이므로 결과는 true
		System.out.println(bCheck);*/
		
		/*char c=(char)((Math.random()*26)+65);
		boolean bCheck= c>='a' && c<='z'; // 범위안에 포함이 됐는지 확인하는 조건
		System.out.println(bCheck);*/
		
		/*char sex='M';
		int score=87;
		boolean bCheck= (sex=='M' && score>=80); //예) 로그인 시 id와pw가 맞는지 확인할 때 이런 조건을 사용할 수 있다
		System.out.println(bCheck);*/
		
		/*int a=10;
		boolean bCheck= a%2==0 && a<2; // ||일 경우는 true
		System.out.println(bCheck);*/
		
		/*int year=2024;
		boolean bCheck=((year%4==0 && year%100!=0)||(year%400==0)); // 윤년 계산 시 사용되는 계산법(2월 29일)
		System.out.println(bCheck);*/
	}

}