//조건문(if)

public class 비교연산자_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c1=(char)((Math.random()*26)+65); // 전체를 char로 변환해야 하므로 +65까지 합쳐서 괄호를 쳐줘야 오류가 나지 않음
											   // 알파벳의 시작이 65(대문자 A)이므로 무조건 65를 넣어줘야함 (랜덤숫자가 65미만일수 있어서)
		char c2=(char)((Math.random()*26)+65);
		System.out.println("c1="+c1);
		System.out.println("c2="+c2); 
		// 'A'=65, 'a'=97 => char는 연산시에 정수로 변경후에 처리
		boolean b1=c1==c2;
		System.out.println("c1==c2"+b1);
		
		b1=c1!=c2;
		System.out.println("c1!=c2="+b1);
		
		b1=c1<c2;
		System.out.println("c1<c2="+b1);
		
		b1=c1>c2;
		System.out.println("c1>c2="+b1);
		
		b1=c1<=c2;
		System.out.println("c1<=c2="+b1);
		
		b1=c1>=c2;
		System.out.println("c1>=c2="+b1);
		
	}

}