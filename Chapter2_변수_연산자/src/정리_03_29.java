/*
 * 4page : 자바 실행과정
 * 	A.java =============> A.class ==============> 화면에 결과값 출력
 * 			  컴파일(javac)            인터프리터(java)  ==> 동시에 처리(ctrl+F11)
 * 
 * 5page : 운영체제 독립적 (운영체제마다 같은 번역을 한다) 
 * 
 * 11page : 자바 프로그램 작성 및 실행
 * 
 * 19page : 
 * 	1) 파일명과 클래스명이 동일해야 된다 // 클래스에 public이나 main이 있는게 저장명이 되고, 없으면 아무거나 상관없음
 * 	2) 가급적이면 한개의 파일에 한클래스를 사용하는 것 권장
 * 	3) 클래스명은 대문자
 * 	4) 실행 => main
 * 	자바의 화면 출력 메소드
 * 	------------------
 *  System.out.print() => 옆에 출력
 *  System.out.println() => \n (다음줄에 출력)
 *  System.out.printf() => 출력 형식을 만들 경우
 *  
 * 22page : 들여쓰기 // 열고 닫고 {} 코딩하면 에러가 안난다!!
 * 	// 작업에 대한 내용을 미리 작성하고 들여쓰기 하기
 * 	{
 *  }
 *  
 * 23page 주석 : 번역이 안되는 파트 // 
 * 
 * 25page 변수 => 한개의 데이터만 저장하는 메모리 공간
 * 			  => 데이터 값을 변경할 수 있다
 * 
 * 26page 변수 선언 규칙. 변수 이름 저장
 * 		  데이터형 변수명=초기값;
 * 		  예) int a=10;
 */
public class 정리_03_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a='A'; char op='+';
		System.out.println(a+""+op); // char+char 은 int 이므로 "" 문자열을 결합시켜서 A+ 결과값 얻기
	}

}