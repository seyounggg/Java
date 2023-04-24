/*
 * 	반복제어문
 * 	= break
 * 		- 의미 : 반복문 종료
 * 		- 사용범위 : 반복문(for,while,do~while), 선택문(switch~case)
 * 		- break문 밑에는 소스 코딩 불가능
 * 		- ex) 
 * 			for() {
 * 				if() {
 * 					break; 
 * 					//코딩 불가능
 * 				}
 * 			}
 * 
 * 
 * 	= continue
 * 		- 의미 : 특정 부분을 제외할 때 사용(반복문 계속 수행)
 * 		- 사용범위 : 반복문(for, while, do~while)
 * 		- 웹에서는 특별한 경우에만 사용
 */
public class 반복제어문_1 {

	public static void main(String[] args) {
		
		System.out.println("==== break ====");
		for(int i=1;i<=10;i++)
		{
			if(i==5)
				break; //반복문 중단 ==> 결과값 : 1 2 3 4
			System.out.print(i+" ");
			//break; <- 여기에 있으면 5까지 수행 후 종료
		}
		/*
		 * 	for => break 종료, continue => 증감식으로 이동
		 * 	while => break 종료, continue => 조건식으로 이동
		 * 					    --------------> 처음부터 다시 실행할 때 / but, 잘못하면 무한루프에 걸릴 수 있음
		 * 		[while]continue 사용 시 무한루프 예시
		 * 		int i=1;
		 * 		while(i<=10)
		 * 		{
		 * 			if(i==5)
		 * 				continue; -> 조건식으로가면 i=5 로 들어가고 조건(i<=10) 기준으로는 true 이므로, 다시 if로 내려가면서 무한루프 걸림
		 * 						  // 게임 : 잘못된 입력이 있는 경우 처음으로 다시 돌아갈 때 주로 사용
		 * 			system.out.print(i+" "); // 결과값 : 1,2,3,4 
		 * 			i++;
		 * 		}
		 */
		System.out.println("\n=====continue========");
		for(int i=1;i<=10;i++)
		{
			if(i==5 || i==7 || i==9)
				continue; //5,7,9가 나오면 제외하고 다시 i++로 이동
			System.out.print(i+" "); // 결과값 : 1 2 3 4 6 8 10
		}
		System.out.println("\n====================");
		
	}

}