import java.util.Scanner;
/*
 * 같은 문자열인지 확인
 *   문자열에서는 비교(equals(), !equals()) -> 기본형에서는 ==,!=
 *   login -> id, password
 */
public class 문자열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String ID="hong";
		final String PWD="H1234";
		
		Scanner scan=new Scanner(System.in);
		System.out.print("ID :");
		String id=scan.next();
		System.out.print("PWD :");
		String pwd=scan.next();
		//String => 문자열 저장이 아니고 메모리 주소
		//.equals() => 메모리에 저장된 실제 문자열 비교
		//          => 대소문자 구분!!
		//          => 로그인, 아이디 찾기, 아이디 중복체크, 비밀번호 찾기...
		// 포털 사이트에서 검색할 때에는 대소문자를 구분하면 안되기 때문에 .equalsIgnoreCase를 사용
		
		//login
		if(id.equalsIgnoreCase(ID) && pwd.equalsIgnoreCase(pwd)) //문자열은 == 으로 비교할 수 없음
		{
			System.out.println(id+"님 로그인 되었습니다");
		}
		else
		{
			System.out.println("아이디나 비밀번호가 틀립니다.");
		}
	}

}