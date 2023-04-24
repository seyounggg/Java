// 문제3 다음 중 배열 선언이 잘못된 것은? 4)
/*
 * 1) int[] n= {1,2,3,4,5};
 * 2) int n[]={0};
 * 3) int[] n=new int[3];
 * 4) int n[3]=new int[3];
 *        ----입력(X)/ int[]면 이거 자체가 데이터형!_데이터형 안에 입력 안됨
 */
//문제4 배열을 선언하고 생성하는 다음 물음에 답하라
/*
 * 1) 10개의 문자를 가지는 배열 c를 생성하는 코드를 한 줄로 쓰라
 * 	char[] c=new char[10];
 * 2) 0에서 5까지 정수 값으로 초기화된 정수 배열 n을 선언하라
 * 	int[] n={0,1,2,3,4,5};
 * 3) 일,월,화,수,목,금,토 로 초기화된 배열 day를 선언하라
 * 	 char[] day={'일','월','화','수','목','금','토'};
 * 4) 4개의 논리 값을 가진 배열 bool을 선언하고, true, false,false,true 로 선언하라
 *	 boolean[] bool={true,false,false,true};
 */
//문제5 배열alpha를 모두 출력하고자 한다. 빈칸에 적절한 코드를 삽입하시오
public class 문제3_4_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] alpha= {'a','b','c','d'};
		for(int i=0;i<alpha.length;i++) //[채워야 하는 빈칸 부분]
		{
			System.out.print(alpha[i]);
		}
		//for(char c:alpha)
		//{
		//	System.out.print(c);
		//} <- 권장사항 /향상된 for문
		
	}

}