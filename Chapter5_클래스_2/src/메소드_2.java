// ID/PWD를 받아서 로그인 처리
import java.util.Scanner;
/*
 *   리턴형은 경우의 수로 판단!
 *   경우의 수 2개 => boolean(true/false)
 *   경우의 수 3개 => int , String
 *                 1. ID가 없는 경우 => NOID
 *                 2. ID는 맞는데, PWD가 틀린 경우 => NOPWD
 *                 3. ID,PWD가 맞는 경우 => LOGIN
 *             -> 1,2,3 (int)로 처리할 경우 다음에 유지보수 시에 이전의 코드를 분석해야하므로 String사용이 좋다.
 *   프로그램의 3대 원칙 : 재사용 / 견고 / 가독성
 */
public class 메소드_2 {
	static String isLogin(String id,String pwd)
	{
		String[] ids={"hong","park","shim","lee","kang"};
		String[] pwds= {"1234","3456","4567","5678","6789"};
		String[] names= {"홍길동","박문수","심청이","이순신","강감찬"};
		// 파일, 오라클, 메모리(휘발성)에 저장
		
		
		//id 검색
		int index=0;
		boolean bCheck=false;
		for(int i=0;i<ids.length;i++)
		{
			if(id.equals(ids[i]))
			{
				bCheck=true; //ID가 존재한다.
				index=i;
				break;
			}
		}
		
		String result="";
		if(bCheck=true) //bCheck==true <<ID가 있으면!
		{
			//비밀번호 검색
			if(pwd.equals(pwds[index]))
			{
				result=names[index]; // 로그인 된 상태
			}
			else
			{
				result="NOPWD"; //비밀번호가 틀리다
			}
		}
		else
		{
			//ID 없음
			result="NOID";
		}
		return result;
	}
	static void process()
	{
		//id와 pwd 값 받기
		Scanner scan=new Scanner(System.in);
		System.out.print("ID 입력:");
		String id=scan.next();
		
		System.out.print("Password 입력:");
		String pwd=scan.next();
		
		//검증(로그인 처리)
		String result=isLogin(id, pwd);
		
		if(result.equals("NOID")) //id가 없는 상태
		{
			System.out.println("아이디가 존재하지 않습니다.");
		}
		else if(result.equals("NOPWD")) //비밀번호가 틀린 상태
		{
			System.out.println("비밀번호가 틀립니다.");
		}
		else // 로그인된 상태
		{
			System.out.println(result+"님 로그인 되었습니다.");
		}
	}
	public static void main(String[] args) {
		process();

	}

}