//char를 한개 보내서 => 대문자,소문자 => 리턴형(String)
import java.util.Scanner;
public class 메소드_3 {
	static String isAlpha(char c)
	{
		String result=""; //default 값 false // else 필요없엉
		if(c>='A' && c<='Z')
			result="대문자 입니다.";
		else if(c>='a' && c<='z')
			result="소문자 입니다.";
		else
			result="알파벳이 아닙니다.";
		
		return result;
	}
	static void process()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("알파벳 입력:");
		String s=scan.next();
		char c=s.charAt(0); //문자 한개를 읽어와서 char로 전환
		/*
		 * String s="Hello"
		 *           01234
		 *           => s.charAt(2) ==> l 
		 */
		String result=isAlpha(c);
		System.out.println(c+"는(은)"+result);
		// 가급적이면 결과값이 여러개인 경우 => 문자열로 처리
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

}