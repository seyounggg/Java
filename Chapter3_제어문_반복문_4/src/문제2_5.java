/*
 * 1. int형 변수x가 10보다 크고 20보다 작을 때 true인지 조건식 작성
 * 		x>10 && x<20;
 * 2. char형 변수 ch가 공백이고 탭이 아닐 때 true인 조건식 작성
 * 		ch==' ' && ch!='\t'
 * 3. char형 변수 ch가 'x' 또는 'X'일 때 true인 조건식
 * 		ch=='x' || ch=='X'
 * 4. char형 변수 ch가 숫자('0'~'9')일 때 true인 조건식
 * 		ch>='0' && ch<='9'
 * 
 * 
 * 5. 두개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램
 */
public class 문제2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=1;i<=6;i++) //첫번째 주사위
		{
			for(int j=1;j<=6;j++) //두번째 주사위
			{
				if(i+j==6)
					System.out.printf("[%d,%d]\n",i,j);
			}
		}
			
		
	}

}