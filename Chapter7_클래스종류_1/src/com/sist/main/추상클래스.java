package com.sist.main;
/*
 *  책 232page
 *  [추상클래스] _ abstract
 *      메소드 관련 (구현이 안된 메소드)
 *      ------------------------ 상속 관련(오버라이딩)
 *      
 *      오버라이딩(상속을 받아서 기존의 기능을 변경해서 사용하는 기법(modify))
 *         - 조건
 *           1) 상속관계가 존재
 *              => 추상클래스는 단독으로 사용이 불가능(미완성된 클래스)
 *              => 사용법 : 상속을 내린 후에 상속받은 클래스를 통해서 메모리 할당
 *                 class A
 *                 class B extends A
 *                 A a=new B();
 *                 A a=new A(); => 자기 자신은 메모리 할당을 못함/오류!!
 *           2) 메소드명 동일
 *           3) 리턴형 동일
 *           4) 매개변수 동일(매개변수가 다를 경우 -> 오버로딩)
 *           4) 접근지정어는 확대만 가능하며, 축소될 경우 오류 발생
 *              private < default < protected < public
 *       
 *     - 기본 목적 : 여러개의 클래스를 모아서 한개의 이름으로 제어
 *     - 프로그램 설계(미완성된 클래스)
 *       = 요구사항 분석
 *         - 벤치마킹 : 여러개 사이트를 참조
 *         예) 로그인 >> 10000개의 레시피
 *            회원가입 >> 망고플레이트
 *             예약 >> CGV
 *             결제 >> 옵션
 *       = 프로그램에 맞게 구현해서 사용
 *         예)
 *            void btnClick()                 void getConnection(){}
 *            {                               => 데이터베이스 연결
 *                 계산지 1번 버트               => 오라클/MY-SQL/MYSQL/MariaDB...
 *            }
 *            => 로그인 버튼
 *       = 한개의 객체로 여러개를 제어하는 프로그램
 *         게시판 
 *         갤러리게시판
 *         댓글게시판
 *         묻고답하기
 *         
 * 
 * 추상클래스
 * =======
 * => 공통적으로 사용하는 부분(코딩 내용이 다르게 만들 경우)
 * 에)
 *    게시판 : 목록출력, 찾기, 글쓰기, 내용보기, 수정하기, 삭제하기
 *    묻고답하기 : 목록출력, 찾기, 글쓰기, 내용보기, 수정하기, 삭제하기, 답변하기
 *    댓글게시판 : 목록출력, 찾기, 글쓰기, 내용보기, 수정하기, 삭제하기, 댓글
 *    후기게시판 : 목록출력, 찾기, 글쓰기, 내용보기, 수정하기, 삭제하기, 업로드
 *    
 *    abstract class Board
 *    {
 *         목록출력(); // 게시판의 목록을 출력하는 기능이 다 다르므로 구현하지 않음
 *         찾기(){}; // 찾기 기능은 어느 게시판이나 기능이 같으니까 구현
 *         글쓰기(); // 기능이 다른게 있으니까 선언만
 *         내용보기(){};  ...
 *         수정하기(){}; ...
 *         삭제하기(); ...
 *    }
 *    
 *    *** 권장사항 => 한개 이상의 추상메소드를 포함한다
 *                           -------- 구현이 안된 메소드
 *        abstract void find(); // 구현이 안된 메소드
 *        Board content(){}; // 구현된 메소드
 *        void write(){}; // 구현된 메소드     
 *  
 *  추상클래스의 특징
 *  1) 단일상속 => extends
 *  2) 메소드가 구현이 안된 것이 있으면 미완성된 클래스 => 메모리에 단독으로 저장 불가
 *     abstract class A
 *     => A a=new A(); (X)
 *  3) 상속을 내려서 구현된 클래스를 이용해 메모리를 할당
 *     abstract class A
 *     class B extends A
 *     ------------------구현이 안되넴소드를 구현한다
 *     => A a=new B(); => 묵시적 형변환(자동형변환)
 *     => A a=new B();
 *        B b=(B)a; ==> 명시적 형변환(강제)
 *     *** 클래스는 상속관계,포함관계 => 크기를 잴 수 있다
 *         -> 상속을 내리는 클래스 > 상속 받는 클래스
 *         -> 포함하고 있는 클래스 > 포함되는 클래스
 *  4) 목적 : 관련된 여러 클래스를 묶어서 한개의 이름으로 관리
 *           -------------- 공통된 기능
 *           예) 버스={마을버스,고속버스,좌석버스...}
 *              ---- 버스가 추상클래스
 *           예) 개,돼지,말... => 동물
 *                             --- 추상클래스
 *           예) 선, 네모, 삼각형, 원... => 도형
 *  5) 선언된 메소드가 있는 경우 => 상속 시 반드시 구현해야 한다(강제성)
 *   
 */
import java.io.*;
abstract class 도형
{
	// 무조건 구현이 필요
	public abstract void draw();
	// 필요하면 오버라이딩해서 사용
	public void color() {
		System.out.println("검정색");
	}
}
class 선 extends 도형
{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("선울 그린다");
	}
	
}
class 원 extends 도형
{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("원을 그린다");
	}
	
}
class 네모 extends 도형
{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("네모를 그린다");
	}
	
}
/*
 *   1. 일반클래스 = 저장시 new
 *   2. 추상클래스 = 구현 후 사용
 *   3. interface = 구현 후 사용
 *   4. 종단 클래스 = 상속해서 확장이 불가능
 *   5. static = 메모리->클래스명으로 접근
 *   --------------------------------
 *   주로 많이 사용하는 건 일반클레스 or interface
 */
abstract class A
{
	public abstract void aaa();
	public void bbb() {};
	public void ccc() {};
	public void ddd() {};
	public abstract void eee();
}
// aaa와 eee는 필수로 구현해야하는 메소드이고, bbb,ccc,ddd는 필요시에 따라 오버라이딩 하면 된다
// abstract 선언은 서언 후 구현이 필요한 메소드에만 사용하는게 좋다
class B extends A
{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eee() {
		// TODO Auto-generated method stub
		
	}
	
}
public class 추상클래스 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 오버라이딩 기법
		도형 a=new 선();
		a.draw();
		a=new 원();
		a.draw();
		a=new 네모();
		a.draw();
		OutputStream out; // 파일에 글쓰는 기능인데, 어떤 파일에 글을 쓸지 모르니까 추상 클래스이다
		
	}

}
