package com.sist.lib;
/*
	1. 문자열이 지정한 문자로 시작하는지 판단 같으면 true반환 아니면 false를 반환한다.(대소문자구별)
	   --------------------
	   boolean startsWith(String s)
	   => 사용처 : 검색기(Search Bar)
	   
	2. 문자열 마지막에 지정한 문자가 있는지를 판단후 있으면 true, 없으면 false를 반환한다.(대소문자구별)
	   --------------------
	   boolean endsWith(String s)
	   => 사용빈도가 많지는 않다

📍 3. 두개의 String에 값만을 비교해서 같으면 true, 다르면 false를 반환한다.(대소비교)
   -----------------------
	   boolean equals(String s)
	   => 사용처 : 로그인 처리, 아이디 중복, 상세보기...

📍 4. 지정한 문자가 문자열에 몇번째에 있는지를 반환한다.
   ----------------------
	   String 은 char[] 이므로 index번호가 0번부터 시작
	   int indexOf(String s), int indexOf(char c)

📍 5. 문자열에 지정한 문자가 마지막 몇번째에 있는 int를 반환한다.
                     ---------
   int lastIndexOf(String s), int lastIndexOf(char c)

	6. 문자열의 길이를 반환한다.
	   ---------- 문자 갯수
	   int length()
	   
	7. 정규표현식을 지정한 문자로 바꿔서 출력한다.
	   ------------------통계 / 분석 => 추천
	   문자형식(패턴)을 만들어서 변경하는 역할
	   String replaceAll(String regex,String s)

📍 8. 지정한 문자로 문자열을 나눌수 있다.(배열로 반환)
	   String[] split(String regex)
	   => 패턴
	   [가-핳] 한글전체
	   [A-Za-z] 영문 전체
	   [0-9] tntwk wjscp
   
📍 9. 문자열에 지정한 문자" "가 있으면 새로 지정한 문자" "로 바꿔서 출력한다.
	   Sting replace(String s,String s1) // 문자열을 변경
	   String replace(char a1, char c2) // 단어 한개만 변경
 
📍	10. 문자열에 지정한 범위에 속하는 문자열을 반환한다.(시작범위에 값은 포함하고, 끝나는 범위에 값은 포함하지않는다.)
               ---------
        시작범위에 값을 포함하고, 끝나는 범위에 값은 포함하지 않는다)
        String substring(nt s,int e)
                               ----- e-1
	
	11.  문자열에 대문자를 소문자로 변환한다.
	     String toLowerCase() => 오라클(LOWER())
	
	12. 문자열에 소문자를 대문자로 변환한다.
	    String toUpperCase() => 오라클(UPPER())
	    ** 오라클은 대소문자를 구분하지 않는다
	       (실제 저장된 값에서는 대소문자를 구분함)
	       
📍	13. 문자열을 그대로 반환해준다.
	    String toString()
	
	14. 문자열에 공백을 제거해 준다.
	    => 좌우에 있는 공백만 제거
	    String trim()
	 
	15. 지정한 개체의 원시 값을 반환 (데이터형을 문자열로 변경)
	    String ValueOf(모든 데이터형)
	    => static 메소드
	 
📍	16. 두개의 String을 비교해서 비교대상 String을 포함하고 있으면true, 다르면 false를 반환한다.
	    boolean contains(String s)
	    => 사용처 : 검색
	
	17. 지정한 index번째에 문자를 반환한다.
	    char charAt(int index)
	
	18. 문자와 문자를 결합해준다.
		+ , String concat(String s)
	
	19. 서식문자열을 이용해서 서식화된 문자열을 반환한다.
		String format("%d%d....")
		=> static 메소드
 */
public class String_문제풀이 {

}
