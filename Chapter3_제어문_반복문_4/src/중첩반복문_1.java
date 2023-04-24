//2차 for
/*
 * 	중첩
 * 	조건문
 * 		if()
 * 		{
 * 			if()
 * 			{
 * 			}
 * 		}
 * 		
 * 		switch()
 * 		{
 * 			case 값:
 * 				switch()
 * 				{
 * 				}
 * 		}
 * 		for(4) => 줄수
 * 		{
 * 			for(5) => 출력 갯수
 * 			{
 * 			}
 * 		}
 * 		
 * 		
 *      
 *      for(①초기값;②조건식;⑧증감식) => 줄수
 *      {
 *      	③ for(④초기값;⑤조건식;⑦증감식) => 실제 출력물
 *      	{
 *      		⑥반복수행문장
 *      	} ==> ⑤가 false ==> ⑧증감식으로 이동
 *      	다음줄로 내려준다
 *      }
 *      
 */
public class 중첩반복문_1 {

	public static void main(String[] args) {
		
		/*char c='A';
		for(int i=1;i<=5;i++) // 줄만생성
		{
			for(int j=1;j<=3;j++)
			{
				System.out.print(c++ + " ");
			}
			System.out.println();
		}*/
		/*for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				System.out.println("i="+i+",j="+j);
			}
		}*/
		System.out.println("=====구구단=====");
		for(int i=1;i<=9;i++)
		{
			for(int j=2;j<=9;j++)
			{
				System.out.printf("%2d*%2d=%2d\t",j,i,j*i);
			}
			System.out.println();
		}

	}

}