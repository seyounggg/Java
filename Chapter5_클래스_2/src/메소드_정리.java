/*
 * 메소드 : 클래스의 구성 요소(동적)
 *       1)특정 기능을 수행하는 명령문의 집합
 *                         ----- 연산자 / 제어문 묶어서 하나로 만드는거!
 *       2)한가지 기능만 수행 할 수 있게 한다
 *         예)
 *            댓글
 *            ----------- 댓글(class)
 *            댓글 목록 출력
 *            댓글 쓰기
 *            댓글 수정
 *            댓글 삭제
 *            ------------
 *            게시판 (class)
 *            ------
 *            글쓰기
 *            목록출력
 *            상세보기
 *            수정
 *            삭제
 *            -------
 *            영화 (class)  (CGV) --> 상속 (메가박스) --> 상속(롯데시네마)
 *            -------
 *            목록출력
 *            상세보기
 *            예약하기
 *            추천하기
 *            검색하기
 *            -------
 *        3) 메소드 구성 요소
 *           선언부
 *           void display()
 *           구현부
 *           {
 *           	처리
 *           }
 *           
 *           선언부
 *           [접근지정어][옵션] 리턴형 메소드명(매개변수)
 *                                      ------ 사용자가 요청한 값
 *                                             0개~여러개
 *                                ----- 알파벳, 한글로 시작(알파벳은 대소문자 구분), 
 *                                      숫자 가능(뒤에만 사용 가능), 키워드 사용 금지, 특수문자 사용 가능( _ $),공백불가
 *                                      (약속) 소문자로 시작
 *                          ----기본형(int,long,byte,double,char,boolean)
 *                          ----배열, 클래스
 *           --------  ---- static/final/abstract
 *           public/protected/default/private
 *           {
 *           }
 *           
 *           static int add(int a,int b)
 *           {
 *                return a+b;
 *           }
 *           
 *           호출
 *           넘겨준 데이터를 받아서 저장
 *           int result=add(10,20);
 *               ------ 30
 *           
 *   (***) 메소드 호출 시에는 메소드는 처음부터 끝까지 수행한 후에 호출된 위치로 온다.
 *   
 *   메소드를 만드는 방법
 *   ---------------
 *   리턴형     매개변수
 *  1  O        O   => String substring(int s,int e)
 *                     String s="Hello Java"; // 아래에서 substring 한다고 해서 원본이 짤리지는 않음
 *                     String ss=s.substring(0,5); // 자른값을 다른 변수에 저장해야하기 때문에 ss 가 필요함.
 *  2  O        X   
 *  3  X        O
 *  4  X        X
 *  ----------------
 *   */
public class 메소드_정리 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="Hello Java";
		String ss=s.substring(0,5);
		System.out.println(ss);
		System.out.println(s);
	}

}