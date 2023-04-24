//.length() => 문자갯수 => 
//.trim() ==> 좌우 공백 제거
//javascript => java 메소드와 동일 => jquery / vuejs / reactjs
import java.util.Scanner;
public class 문자열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scan=new Scanner(System.in);
//		System.out.print("문자열 입력:");
//		String s=scan.next();
//		System.out.println("입력된 값:"+s);
//		System.out.println("문자 갯수:"+s.length());
		String s=" Hello Java!! "; //공백도 문자
		System.out.println(s.length());
		System.out.println(s.trim().length()); // trim()은 좌우에 있는 공백만 제거하고, 가운데(중간)은 제거 하지 않
	}

}