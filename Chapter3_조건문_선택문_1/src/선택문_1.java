/*
 * 	switch ~ case
 *  => 범위를 지정하는 것이 아니라 특정값으로 설정
 *  => 사용 가능한 특정값은 : char(문자), int(정수), string(문자열) //실수, 논리 불가!
 *  => 많이 사용 되는 위치 : 게임(키보드별 처리), 메뉴, 네트워크(기능별 처리)
 *  	웹에서는? 화면전환
 */
import java.util.Scanner;
public class 선택문_1 {

	public static void main(String[] args) {
		
		System.out.println("=======메뉴=======");
		System.out.println("1.로그인");
		System.out.println("2.회원가입");
		System.out.println("3.로그아웃");
		System.out.println("4.맛집추천");
		System.out.println("5.레시피 만들기");
		System.out.println("6.프로그램 종료");
		System.out.println("=================");

		Scanner scan=new Scanner(System.in);
		System.out.print("메뉴 클릭(1~6):");
		int menu=scan.nextInt();
		switch(menu)
		{
		case 1:
			System.out.println("로그인 요청!!");
			break;
		case 2:
			System.out.println("회원가입 요청!!");
			break;
		case 3:
			System.out.println("로그아웃 요청!!");
			break;
		case 4:
			System.out.println("맛집 추천 요청!!!");
			break;
		case 5:
			System.out.println("레시피 만들기 요청");
			break;
		case 6:
			System.exit(0); //프로그램을 완전 종료
			// 0이면 정상 종료, 다른 수는 비정상 종료
			break;
		default://없는 메뉴 선택시에 => else와 비슷 :)
			System.out.println("메뉴에 없는 번호입니다");
		
		}
	}

}