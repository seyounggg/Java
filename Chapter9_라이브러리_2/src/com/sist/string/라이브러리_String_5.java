package com.sist.string;
// concat : 문자열 결합 (+)
/*
 *   형식)
 *   String concat(String s)
 *   
 *    String s1="Hello";
 *    String s2="Java";
 *    s1.concat(s2) ==> "Hello Java";
 *    
 *    ==> concat은 MySQL LIKE문장을 만들 때
 *        WHERE name LIKE CONCAT(%','홍','%')
 *        WHERE name LIKE '%'||'홍'||'%'
 */

// endsWith : 끝나는 문자열이 같은 경우에 사용
/*
 *   형식)
 *   boolean endsWith(String s)
 */

// 책 310page < 암기 >
/*
 *  charAt()
 *  equals() : 대소문자 구분하여 비교 / id,pwd ...
 *  equalsIgnorecase() : 대소문자 구분 없이 비교 /영어검색, 영문이름 ...
 *  indexOf() : 앞에서부터 찾기 위치확인(문자/문자열)
 *  lastIndexOf() : 뒤에서부터 찾기 위치확인(문자/문자열)
 *  length() : 문자의 갯수
 *  startsWith() : 시작문자열이 같은 경우 => suggest (예, 크롬에 java 검색하면 java로 시작되는 관련 검색어가 제시되는 것 같은 느낌)
 *  substring() : 원하는 문자열을 자르는 경우
 *  trim() : 좌우 공백 제거
 *  split() : 특정문자로 자르는 경우
 *  contains() : 포함문자열인지 확인
 *  valueOf() : 모든 데이터형을 문자열로 변환;
 */
public class 라이브러리_String_5 {

	public static void main(String[] args) {
		// concat 예제
		/*String s1="Hello ";
		String s2="Java!!";
		System.out.println(s1.concat(s2));
		System.out.println(s1+s2);*/
		
		
		// endsWith 예제
		// 공백도 문자에 포함된다
		/*if(s1.endsWith(" "))
			System.out.println("공백으로 끝났다");
		else
			System.out.println("공백으로 끝나지 않았다");*/
		
		// equals() : 대소문자 구분하여 비교 / id,pwd ...
		// equalsIgnorecase() : 대소문자 구분 없이 비교 /영어검색, 영문이름 ...
		String[] data= {"JAVA","java","Java","JAva","JAVa","jaVA","javA"};
		for(String s:data) {
			if(s.equals("java")) {
				System.out.println(s);
			}
		}
		// equals는 대소문자를 구분해서 비교
	    // 원형 : boolean equals(String s)
		// 사용처 : 로그인, 상태보기 ...
		
		System.out.println("==== equalsIgnorecase() ====");
		for(String s:data) {
			if(s.equalsIgnoreCase("java")) {
				System.out.println(s);
			}
		}
		// equalsIgnorecase() : 대소문자를 구분하지 않고 비교
		// 원형 : boolean equalsIgnorecase(String s)
		// 사용처 : 검색, 영문이름, 영문으로된 데이터 검색 시..
		// 한글 => equals
		// 한글 => 자음으로 찾기 => 사용자 정의
		
		System.out.println("==== length() ====");
		String[] data2= {"apple","avocado","banana", "blackberry","blueberry","cherry tomato","cherry",
				  "coconut","grape","kiwi","lemon","lime","mango","melon","orange","papaya","peach",
				  "pear","persimmon","pineapple","plum","strawberry","tangerine","tomato","watermelon"};
		//1. 각 과일명의 문자길이 출력
		for(String s:data2) {
			System.out.println(s+":"+s.length());
		}
		System.out.println("======================");
		
		// 2. 과일 이름 중 가장 긴 이름의 과일 명 출력하기
		System.out.println("가장 긴 이름의 과일명을 출력하시오");
		int max=0;
		for(String s:data2) {
			if(max<s.length()) {
				max=s.length();
			}
		} // 1) 가장 긴 이름의 길이를 찾아서 max변수에 대입
		for(String s:data2) {
			if(s.length()==max) {
				System.out.println(s);
			}
		} // 2) max의 길이와 같은 단어 출력
		// length() : 문자갯수
		// 원형 : int length()
		// 사용처 : 문자 제한이 있는 경우, 비밀번호... 
		
		System.out.println("==== startsWith ====");
		for(String s:data2) {
			if(s.startsWith("p")) {
				System.out.println(s);
//				try {
//					Thread.sleep(1000); // CheckException 이라서 예외처리!!
//				}catch(Exception ex) {}
			}
		}
		// startsWith : 시작문자열이 같은 경우
		// 원형 : boolean startsWith(String s)
		// 사용처 : 자동완성기(검색기), 쿠키 검색
			// 쿠키 => key는 중복 없이 => 구분 : hotel1 hotel2..
		
		System.out.println("==== trim() ====");
		String id="admin";
		if(id.equals(" admin".trim())) { // .trim() 을 사용하여 좌우 공백을 제거
			System.out.println("같은 아이디 입니다");
		}
		else {
			System.out.println("다른 아이디 입니다");
		}
		// trim() : 좌우 공백 제거
		// 원형 : String trim()
		// 사용처 : 로그인, 회원가입, 검색
		// 사용자가 입력 시 => space누르면 공백이 생기니까!
		// String id="admin" => " admin"이렇게 입력할 수도 있으니까!

		System.out.println("==== contains ====");
		for(String s:data2) {
			if(s.contains("a")) {
				System.out.println(s);
			}
		}
		// contains() : 포함된 문자열인지 확인
		// 원형 : boolean contains(String s)
		// 사용처 : 검색, 추천 ...
		// 추천 => 네이버 블로그, 카페 => 포함된 영화명...
		
		System.out.println("==== valueOf() ====");
		System.out.println(String.valueOf(10)+String.valueOf(30)); // 문자열(10)+문자열(30) => 1030
		// valueOf : String에서 유일한 static 메소드 , 모든 데이터형을 문자열로 변환
		// 원형 : static String valueOf((type)) => 오버로딩된 상태
		// 사용처 : 자바에서 윈도우로 전송, 네트워크 전송, 웹 전송... (String만 인식)
		
		System.out.println("=== subString() ===");
		String ss="http://localhost:8080/JSPProject/main/main.do";
		
		//main.do 만 잘라내기
		String res=ss.substring(ss.lastIndexOf("/")+1);
		System.out.println(res);
		
		//localhost:8080 잘라내기
		ss=ss.substring(ss.indexOf("//")+2);
		System.out.println(ss);
		res=ss.substring(0,ss.indexOf("/"));
		System.out.println(res);
		
		// 도로명과 지번주소 분리하기
		ss="서울특별시 용산구 소월로2길 27 지번 서울시 용산구 후암동 445-8";
		res=ss.substring(0,ss.indexOf("지"));
		System.out.println(res.trim());
		
		res=ss.substring(ss.indexOf("지")+2); // 지를 포함한 2칸을 지운다 => (지번)을 지원다
		System.out.println(res.trim());
		// subString()는 <indexOf(), lastIndexOf()> 와 자주 같이 사용된다
		// subString() : 문자열을 자르는 경우
		// 원형 : String subString(int s)
		//       String subString(int s, int e)
		// 사용처 : URL주소 제어, 주소 제어, 문자열이 긴 경우...
		/* 오버로딩
		 * subString(int s) => s번째부터 마지막까지 잘라온다
		 * subString(int s, int e) => s번째부터 e-1까지 잘라온다
		 */
		
		System.out.println("==== split() ====");
		ss="홍길동,이순신,강감찬,박문수,을지문덕,심청이,춘향이";
		String[] names=ss.split(",");
		for(String name:names) {
			System.out.println(name);
		}
		
		ss="뽀요쁘리또"
			+ " 12,000원"
			+ "칠리쁠라또"
			+ " 13,000원"
			+ "발레아다 (2pcs)"
			+ " 8,000원"
			+ "갓튀긴바나나와 아이스크림2스쿱"
			+ " 6,000원"
			+ "레몬라임타르트"
			+ " 7,000원"; // 하나의 문자열
		String[] menu=ss.split("원");
		for(String m:menu) {
			System.out.println(m+"원");
		}
		
		ss="red|blue|green|black|white|yellow";
		String[] color=ss.split("\\|");
		for(String m:color) {
			System.out.println(m);
		}
		// split() : 특수문자별로 잘라서 배열에 저장
		// 원형 : String[] split(String regex) -> regex 는 정규식을 의미함
		// 사용처 : 구분이 되어 있는 문자열이 있는 경우 문자를 분리
		// |, ?, ., +, *, ^ ==> 정규식 기호
		// 정규식에서 사용되는 기호를 사용하고 싶으면 기호 앞에 '\\'역슬러시 두개 추가해야 한다
		
		System.out.println("==== replace() ====");
		ss="https://mp-seoul-image-production-s3.mangoplate.com/"
			+ "756210_1667892732041968.jpg?fit=around|512:512&crop=512:512;"
			+ "*,*&output-format=jpg&output-quality=80";
		// 오라클에 저장 시 &는 Scanner 기능을 수행한다
		res=ss.replace("&", "#");
		System.out.println(res);
		System.out.println(res.replace("#", "&"));
		// replace() : 문자나 문자열을 변경할때 사용
		// 원형 : String replace(char old,char new) => old를 new로 바꿔라
		//       String replace(String old,char new)
		// 사용처 : 데이터 수집 시 html 제거...
	}
	
}
