//do ~ while => 후조건 / 무조건 1번 수행 가능하다.
/*
 * 	1. 초기화
 * 	2. 게임
 * 	3. 형식)
 * 		① 초기값
 * 		do
 * 		{
 * 			② 반복 실행 문장
 * 			③ 증가식
 *	 	}while(④ 조건식); -> true면 증가된 변수로 조건검색 / false면 종료
 */
import java.util.Scanner; //import java.util.* <- util안에 들어가있는것 모두 / 2개 이상시에만 * 사용
public class 반복문_6 {

	public static void main(String[] args) {
		//1~10 출력
		int i=1;
		do
		{
			System.out.print(i+" ");
			i++;
			// i=2...i=10 i=11(종료)
		}while(i<=10);
		System.out.println("\n==============");
		Scanner scan=new Scanner(System.in);
		System.out.print("단 입력:");
		int dan=scan.nextInt();
		i=1; // 1로 i값 초기화(위에서 i가 11까지 증가했기 때문에)
		do
		{
			System.out.printf("%2d*%2d=%2d\n",dan,i,dan*i); // ex) %5d에 100을 입력하면 □□100 / %-5d의 경우 100□□ => 빈공간의 위치를 + -로 구분!
			i++;
		}while(i<=9);
		System.out.println("================================");
		i=10;
		System.out.println("===for===");
		for(i=10;i<10;i++) {
			System.out.println("i="+i);
		} // 조건식이 false이므로 종료
		i=10;
		System.out.println("===while===");
		while(i<10)
		{
			System.out.println("i="+i);
			i++;
		} // 조건식이 false이므로 종료
		System.out.println("====do while===");
		i=10;
		do
		{
			System.out.println("i="+i);
			i++;
		}while(i<10); // 조건이 false지만 반복문장을 먼저 수행하므로 i=10이 출력됨
	}	

}
