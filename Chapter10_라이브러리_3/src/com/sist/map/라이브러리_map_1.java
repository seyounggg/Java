package com.sist.map;
/*
 *   Map (인터페이스)
 *    |
 *   --------------
 *   |            |
 * HashTable   HashMap
 *  
 * 특징)
 *    두개를 동시에 저장(key, value)
 *    (단, key는 중복할 수 없다)
 *    ("id","hong")
 *    ("id","shim")
 *     ==> X (에러가 나지는 않지만, id에 shim만 들어가고, hong은 없어진다)
 *    -------------id값을 가지고 오라고 하면 => shim
 *    ("id1","hong")
 *    ("id2","shim") 
 *    ------------- 이건 가능!!
 * 
 * 사용처)
 *   = 웹에서 제공하는 모든 클래스(Map형식)
 *     HttpServletRequest
 *     -> request.setAttribute("key","value")
 *     HttpServletResponse
 *     HttpSession
 *     Cookie
 *   = Spring, MyBatis => Map형식
 *     ------  -------
 *    클래스등록    SQL("all","SELECT * FROM emp")
 *   ("a",new A())
 *   = 저장 / 읽기
 *     저장 : put("key","값")
 *     읽기 : get(key)
 *     ---------------------- JSON , Properties
 *     => 데이터는 구분자를 필요로 한다
 *               -----
 *     # 구분자 #
 *     ArrayList -> index번호
 *     Set       -> 중복없이
 *     Map       -> key
 *     오라클      -> Primary key
 *    -----------------------------
 *    영화 : 영화번호
 *    뮤직 : 뮤직번호
 *    맛집 : 맛집번호
 *    게시판 : 게시판번호
 *    회원관리 : ID
 *    -------------- 이런게 정형화된 데이터!!
 *    비정형화 => 빅데이터 => 정형화된 데이터
 *                       ============
 *                         통계/확률
 */
import java.util.*;
public class 라이브러리_map_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		
		// 데이터 저장
		map.put("id", "admin");
		map.put("password", "1234");
		map.put("name", "홍길동");
		map.put("sex", "남자");
		map.put("age", 25);
		map.put("password", "4567"); //key가 중복되면, 덮어쓴다!!
		
		// 데이터 출력
		/*
		System.out.println("ID: "+map.get("id"));
		System.out.println("PWD: "+map.get("password"));
		System.out.println("NAME: "+map.get("name"));
		System.out.println("SEX: "+map.get("sex"));
		System.out.println("AGE: "+map.get("age"));
		*/
		Set set=map.keySet(); //key.Set() = key전체를 모아서 관리 (key를 읽어온다)
		System.out.println(set);
		// 출력값 : [password, sex, name, id, age]
		// password가 중복되니까 하나만 나옴
		
		for(Object o:set) {
			String key=(String)o; // map.get에 들어가있는 데이터값이 String이므로 String으로 형변환 시킨거임
			System.out.println(key+":"+map.get(key));
		}
		/*
		 * Clear() : 전체 삭제
		 * get() : 실제 데이터값을 읽을 때
		 * put() : 데이터 추가
		 * isEmpty() : 데이터가 있는지 여부(true/false)
		 * size() : 저장된 갯수
		 * values() : 실제 저장된 값 전체
		 */
		
		//values() 적용
		for(Object o:map.values()) {
			System.out.println(o);
		}
	}

}
