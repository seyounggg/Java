package com.sist.util;
/*
 *   책 335page => Collection => 데이터를 묶어서 관리를 할 수 있게 만든 클래스
 *                 --> 배열의 단점을 보완
 *   컬렉션 프레임워크(프레임워크 => 표준화)
 *        --------> 모든 개발자가 동일한 형태로 소스코딩
 *                  소스의 통일화 목적 : Spring, MyBatis,JQuery
 *                                   VueJS, ReactJS
 *                  일정 틀 => 쉽게 다른 개발자의 코딩을 분석
 *        = 완전 통일화 : 라이브러리
 *   
 *   Collection : 데이터 그룹, 다수의 데이터 => 모아서 관리
 *                --------------------------------
 *                              |
 *                          배열, 클래스
 *   배열의 단점 => 고정적(배열크기를 정해놓고 작업)
 *                중가 / 감소 => 새로운 배열을 만들어서 처리
 *                ---------------------------------
 *                배열을 크게 만들면 => 메모리 누수 현상이 발생
 *      
 *   Collection은 데이터 크기에 맞게 클래스를 제작(가변형) => 최적화
 *             => default (10개) => 추가(자동으로 10개...)
 *             => 저장 메모리를 결정하지 않는다
 *         종류 )
 *       interface   구현된 클래스
 *     -------------------------------------
 *         List       ArrayList(비동기) -> Vector보완 => 데이터베이스 연동
 *                   (가장 많이 사용)
 *                    Vector(동기화)
 *                    LinkedList => C언어 호환
 *       
 *         Set        HashSet => 중복없는 데이터 저장
 *                    TreeSet => 검색
 *     --------------------------------------
 *         Map        HashMap
 *                    Hashtable
 *     
 *     List
 *     1) 순서를 가지고 있다(인덱스) => 0부터 시작
 *     2) 저장된 데이터 중복을 허용
 *     3) CURD 프로그램에 주로 사용
 *        ---- Create  Update  Read  Delete  
 *               저장    수정     읽기    삭제
 *            -----------------------------
 *            Insert  Update  Select  Delete
 *     4) 비동기화 => 데이터베이스 프로그램 연동 시 사용
 *     5) 주요 메소드
 *        - 데이터 추가 : add(Object)
 *        - 데이터 삭제 : remove()
 *        - 데이터 수정 : set()
 *        - 데이터 읽기 : get()
 *        - 저장된 데이터 갯수 : size()
 *        - 전체삭제 : clear()
 *        - 데이터 존재 여부 확인 : isEmpty()
 *        = 오라클에서 데이터 읽어서 저장(List) => 브라우저 전송
 *               
 *     Set
 *     1) 순서가 없다(인덱스 번호가 없다) => ForEach
 *     2) 데이터 중복을 허용하지 않는다
 *     3) 주로 사용처 => List에 중복된 데이터를 제거
 *     4) 구현 클래스 : HashSet , TreeSet
 *     5) 주요메소드
 *        - 데이터 추가 : add(Object)
 *        - 데이터 삭제 : remove()
 *        - 데이터 수정 : set()
 *        - 데이터 읽기 : get()
 *        - 저장된 데이터 갯수 : size()
 *        - 전체삭제 : clear()
 *        - 데이터 존재 여부 확인 : isEmpty()
 *        
 *     Map(웹에서 지원하는 모든 클래스는 Map형식을 가지고 있다)
 *        request, response, session, cookie
 *        new Cookie(key, 값)
 *                   ---
 *        => 사용자가 값 3개
 *        request.setAttribute("id","hong")
 *        request.setAttribute("pwd","hong")
 *        request.setAttribute("sex","man")
 *      ==> key와 값을 쌍으로 저장한다
 *      ==> key는 중복을 허용하지 않는다, 값은 중복을 허용한다
 *           -> key가 동일할 때는 덮어쓴다
 *      ==> 사용처 : 웹에서 주로 사용(클래스 관리, SQL관리 시 많이 사용)
 *                              --------   ----------------
 *                                Spring       MyBatis      
 *      ==> 구현된 클래스 : HashMap
 *      ==> 주요메소드
 *          저장 : put()
 *          읽기 : get(key)
 *     ---------------------------------------------------------------------------------
 *     프로젝트
 *       1차 : 데이터베이스 사용법(SQL) / JQuery(AJax)
 *       2차 : Spring / String 라이브러리 / VueJS(Vuex)
 *       3차 : 최신기술(우대) : Spring-Boot / ReactJS(Redux)
 *     
 *     웹프로그램
 *       Model 1
 *       => 간단한 사이트 만들때 사용
 *       Model 2
 *       => 큰 사이트 만들때 사용  : MVC
 *       => 데이터관리 / 화면출력
 */	
import java.util.*;
public class 라이브러리_List_1 {
// ArrayList => 사용빈도가 가장 많다
// => 배열과 유사 => 인덱스번호를 사용한다 => 자동으로 저장
// => 순차적이다(인덱스가 항상 0~~)
// => 크기를 지정하지 않는다 (가변형)
// => 데이터베이스 연동
/*
 *   생성
 *   
 *   List list=new ArrayList(); => 기본생성자 => 메모리가 10개
 *   ArrayList list=new ArrayList();
 *   => 10개를 넘으면 자동 10개를 추가...
 *   
 *   ArrayList list-new ArrayList(10);
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 생성
		ArrayList list=new ArrayList(); // 저장 => 기본 default Object
		// list에는 모든 데이터형을 첨부할 수 있다(클래스, 기본형, ...)
		// 가급적이면 같은 데이터형을 첨부하는 것이 관리하기 편리하다
		// list라는 공간에 데이터 추가
		// 순서가 존재 ==> for
		// 데이터 추가 시 => add()를 이용한다
		/*
		 * add -> 오버로딩
		 * add(Object o) , add(int index, Object o)
		 *                 ------------------------
		 * 맨 마지막에 추가  =>  속도가 늦다 (되도록 사용하지 않는 것을 권장)
		 */
		// 중간에 인덱스번호를 변경해도 자동으로 인덱스 번호가 변경되어 충돌이 없다
		// 이름 관리
		list.add("홍길동"); // index=0 
		list.add("박문수"); // index=1
		list.add("심청이"); // index=2 -> 3 -> 4
		list.add("춘향이"); // index=3 -> 4 -> 5
		list.add("이순신"); // index=4 -> 5 -> 6
		list.add(2, "강감찬"); // index=2 list.add(인덱스번호,저장할 값)
		list.add(3, "을지문덕"); // index=3 
		list.add("박문수"); // index => 7
		// 출력
		// 저장된 갯수를 가져오는 것 -> size() ==> 배열의 length() 와 같다
		//          ---> <= 을 붙이면 안되고, < 만!!
		for(int i=0;i<list.size();i++) {
			System.out.println(i+"."+list.get(i));
			// .toString() => 생략이 가능
		}
		//
		System.out.println("======== 삭제 ========");
		 // list.remone(index no) , list.remove(Object o)
		/*
		 * 중간에 생략하는 번호(index번호) 없이 순차적으로 자동 설정이 된다
		    0.홍길동
			1.박문수
			2.강감찬
			3.을지문덕 --> 삭제
			4.심청이
			5.춘향이
			6.이순신
			=> 3.을지문덕이 삭제되면, 심청이가 3번, 춘향이가 4번... 순차적으로 !!
			=> 이름으로 삭제 요청(list.remove(Object o)) => 가장 처음에 있는 이름만 삭제
		 */
		list.remove(3);
		for(int i=0;i<list.size();i++) {
			System.out.println(i+"."+list.get(i));
		}
		/*
		 * 결과값
		    0.홍길동
			1.박문수
			2.강감찬
			3.심청이
			4.춘향이
			5.이순신
			6.박문수
		 */
		System.out.println("======== 수정 ========");
		// 수정 -> set
		// set은 매개변수가 있다 -> set(index번호,변경할 데이터)
		list.set(0, "홍길수");
		for(int i=0;i<list.size();i++) {
			System.out.println(i+"."+list.get(i));
			
		}
		/*
		 * 결과값
		    0.홍길수
			1.박문수
			2.강감찬
			3.심청이
			4.춘향이
			5.이순신
			6.박문수
		 */
		System.out.println("======== 저장 갯수 ========");
		System.out.println("인원수 : "+list.size());
		
		System.out.println("======== 전체 삭제 ========");
		list.clear(); // 메모리 공간 삭제
		System.out.println("인원수 : "+list.size());
		
		/*
		 * << 적어도 이정도는 기억해두자!! >>
		 *   add(Object o)
		 *   set(int index, Object o)
		 *   remove(int index)
		 *   Object get(int index)
		 *   int size()
		 */
	}

}
