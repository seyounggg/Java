//문제6. 임의의 문자를 추출하여 대문자인지 소문자인지 확인하는 프로그램 작성
/*
 * 임의의 문자가 대문자도 나올 수 있어야 하고 소문자도 나올 수 있어야 하기떄문에 int로 조건 건다.(0 or 1)
 */

public class 문제6 {

	public static void main(String[] args) {
		int a=(int)(Math.random()*2);
		char b;
		if(a==0)
			b=(char)((Math.random()*26)+65);
		else
			b=(char)((Math.random()*26)+97); // 여기까지는 대문자인지 소문자인지 모르게 만들어둠
		
		if(b>='A' && b<='Z')
			System.out.println(b+"은(는) 대문자 입니다");
		else
			System.out.println(b+"은(는) 소문자 입니다");
		
	}

}