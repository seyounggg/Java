package com.sist.lib;
/*
 *   컬렉션 프레임워크
 *   
 *   1. 다수의 데이터를 쉽고 효율적으로 처리할 수 있게 만든 표준화된 클래스의 집합
 *      - 자바에서 라이브러리로 지원
 *   2. 데이터 => 수정,삭제,추가,읽기 (자료구조)
 *   3. 배열 => 정적 메모리 할당(정적메모리할당 : 메모리 크기가 고정적 / 추가가 어렵다)
 *          => 추가, 삭제를 할경우 새로운 배열을 만들어야 하고, 기존의 배열에서는 추가, 삭제를 할 수 없다)
 *           # 동적 메모리 할당 : 추가가 될 떄마다 자동으로 메모리 추가(추가가 쉽다)
 *   4. 컬렉션의 종류
 *      1) 순서가 있고, 데이터 중복을 허용한다
 *         List(interface)
 *          |
 *        ArrayList, Vector, LinkedList
 *      2) 순서가 없고, 데이터 중복을 허용하지 않는다
 *         Set (interface)
 *          |
 *        HashSet(웹 채팅, List에서 중복된 데이터 추출), TreeSet(검색)
 *      3) 먼저 들어온 데이터를 먼저 출력해준다
 *         Queue(FIFO), Stack(LIFO) => 코테
 *         -----------  -----------
 *          순차적으로        뒤에서    => 1차원 배열
 *          
 *          [Queue]
 *          for(int i=0;i<ar.length;i++){
 *         		값 설정
 *          } 
 *          for(int i=0;i<ar.length;i++){
 *         	 	출력
 *          } 
 *          
 *          [Stack]
 *          for(int i=0;i<ar.length;i++){
 *          	값 설정
 *          } 
 *          for(int i=arr.length-1;i>=0;i++){
 *          	출력
 *          } 
 *      4) KEY-VALUE를 동시에 저장
 *         Map (interface)
 *          |
 *        HashMap(HashTable의 단점을 보완), HashTable
 *  -------------------------------------------------------
 *        전체 상속도
 *        Collection
 *            |
 *     ---------------------------
 *     |            |            |           |
 *    List         Set         Queue        Map
 *     |            |            |           |
 *   ArrayList    HashSet                  HashMap
 *   LinkedList   TreeSet                  HashTable
 *   Vector
 *      |
 *    Stack
 *  ---------------------------------------------------------
 *   1. List
 *      중복된 데이터를 저장해야 할 때, 저장순서는 인덱스(순차적으로 저장)
 *      인덱스번호가 항상 0번부터 순차적으로 유지를 한다
 *      (중간에 값을 추가 또는 삭제할 경우 자동으로 인덱스번호를 변경한다)
 *      
 *      ArrayList
 *      장점)
 *      1. 단방향 포인터(인덱스)를 자기고 있다. 조회하기 편리하다(성능이 좋다)
 *      2. 검색이 빠르다 , 데이터 추가 시 속도가 빠르다
 *      단점)
 *      3. 수정, 중간에 추가, 삭제시에 속도가 느려진다
 *         ------------------- LinkedList를 사용하는게 낫다
 *      주로)
 *      4. 변경이나 삭제가 없는 상태에서 사용한다 => 데이터베이스(오라클)
 *      
 *      LinkedList
 *      단점)
 *      1. 양방향 포인터를 가지고 있다
 *      2. 검색속도가 느리다
 *      주로)
 *      3. 수정, 삭제, 추가가 많은 경우에 사용한다
 *      
 *      Vector : 유지보수
 *      1. 대용량 데이터 처리 => 채팅, 서버연결
 *      2.                  ----------- 동기화
 *      # 비동기화 보완 => ArrayList
 *      
 *      *** 데이터는 반드시 구분이 되게 만들어야 한다 ***
 *      ex)
 *         hong1 홍길동 남자
 *         hong2 홍길동 남자
 *         hong3 홍길동 남자
 *   2. Set
 *      순서가 없다(인덱스), 데이터 중복을 허용하지 않는다
 *      => 장르별 / 부서별
 *      => 데이터베이스 이용
 *         중복없는 데이터 => DISTINCT
 *      
 *      HashSet => 속도가 빠르다
 *      TreeSet => 정렬, 검색속도
 *      
 *   3. Map
 *      key, value를 동시에 저장
 *      구분자 => 찾기(
 *      웹에서 주로 사용, 클래스 관리, 도서목록, 우편번호
 *      
 *      HashMap
 *      
 *      HashTable => HashMap보다 속도가 느리다
 *  
 *  Set클래스 (인터페이스)
 *  1) 순서가 없다(인덱스가 존재하지 않는다)
 *  2) 데이터 중복을 허용하지 않는다
 *  3) 주요 메소드
 *     => 데이터 저장 : add() -> Object
 *     => 삭제 : remove(Object)
 *     => 전체삭제 : clear()
 *     => 빈공간(데이터 존재여부 확인) : isEmpty()
 *     => 저장갯수 : size()
 *     => 데이터를 한번에 모아서 관리 : iterator()
 *   TreeSet : 검색용으로 주로 사용
 *             LIKE, REGEXP_LIKE(오라클)
 *      = headSet
 *      = tailSet
 */
import java.util.*;
public class 라이브러리_Collection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set set=new HashSet(); // 생성
		set.add("A"); // add(Object)이므로 정수, 실수, 문자 등 다 들어간다
		set.add("B");
		set.add("C");
		set.add("D");
		// 아래부터는 중복된 데이터 이므로 허용하지 않는다
		set.add("A");
		set.add("B");
		set.add("C");
		//출력
		for(Object obj:set) {
			// for-each구문은 받는값(Object obj)형변환이 안된다
			String s=(String)obj; // 형변환을 원한다면 이런식으로!!
			System.out.print(s+" "); // 출력값 : A B C D (중복된 값은 출력하지 않는다)
		}
		

	}

}
