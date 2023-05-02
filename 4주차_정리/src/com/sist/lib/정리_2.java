package com.sist.lib;
/*
 *   제네릭(JDK1.5에 도입)
 *     => JDK1.8 (호환성이 좋다) ==> 우리는 17버전 , SpringFrame(14버전)
 *                                     ----Spring-Boot
 *   1. 제네릭의 도입 배경
 *      1) 컬렉션(ArrayList, Set, Map) => 데이터형(매개변수,리턴형)이 => Object
 *         반드시 형변환후에 사용
 *         오류 발생이 많다 => 모든 데이터형을 사용할 수 있다 => 방지
 *      2) 데이터형을 통일화, 데이터형의 안정성 => 데이터형 고정
 *      3) 데이터형을 명시화 => 가독성이 좋다
 *         List<Object> list=new ArrayList<Object>(); // 가독성이 낮다
 *             -------- 생략 가능
 *         List<String> list=new ArrayList<String>();
 *             --------        "일치"      --------
 *         *** 기본형은 사용할 수 없다 ==> Wrapper
 *         => 데이터형을 모르는 경우 (와일드 카드)
 *            List<?> list=new ArrayList<String>()
 *                ---          ==       --------
 *            ?가 선언된 경우 뒤의 데이터형을 보고 확인하면 된다!!<> 는 서로 일치해야하므로!
 *            
 *         예) 
 *            class Box<T> => T는 임시클래스 => default (T -> Object)
 *            {
 *            }
 *            Box<String> => Object -> String : 매개변수, 리턴형을 변경
 *            <> 안에는 라이브러리만 첨부하는 것이 아니고 사용자정의 클래스 첨부 가능
 *            Box<MovieVO> ...
 *            
 *            임시제네릭
 *            -------
 *            T => 임시데이터형(클래스형 => type) => 사용자 정의 제네릭
 *            E => 임시데이터형(클래스형 => element)요소
 *                 ArrayList<E>, Vector<E>, LinkedList<E>
 *            K => key (클래스형)
 *            V => value (클래스형)
 *            Map<K,V>
 *   -------------------------------------------------------------------------
 *   Iterator / listIterator => 데이터를 모아서 관리
 *   Iterator
 *      hasNext(), next(), remove()
 *   LisIterator
 *      hasNext(), next(), remove(), hasPrevious()
 *   - 순서가 없는 경우에 주로 사용 Set, Map
 *   
 *   ArrayList는 for가 더 편해(Index를 이용해서)
 */
import java.util.*;
public class 정리_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*List<String> list=new ArrayList<>();
		
		// 값을 첨부(초기화)
		list.add("사과");
		list.add("배");
		list.add("수박");
		list.add("딸기");
		list.add("바나나");
		
		// 일반 출력 => for-each
		for(String s:list) {
			System.out.print(s+" ");
		}
		System.out.println();
		
		// Iterator : 데이터를 모아서 출력
		// 출력이 어려운 경우 => 단방향
		// 출력을 한번 하면 재출력을 할 수 없다
		System.out.println("========== Iterator ==========");
		Iterator<String> it=list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println("\n==== 재출력 ====");
		while(it.hasNext()) {
			System.out.println(it.next()+" ");
		}*/
		
		//ListIterator => List에서만 사용이 가능
		//List<?> list=new ArrayList<Integer>();
		//List<String> list1=new ArrayList<String>();
		//list1=new ArrayList<Integer>(); // 한번 스트링 선언하면 변경 불가능
		//List<?> list=new ArrayList<String>();
		//list.clear(); // 와일드카드를 사용하기전에 clear를 사용하여 데이터를 지워주는 것이 좋음
		//list=new ArrayList<Integer>(); // ?(와일드카드)를 사용하면 변경이 가능
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		/*for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println("\n======================");
		for(int i=list.size()-1;i>=0;i--) {
			//              ---- -1 안하면 배열범위 벗어남...
			System.out.print(list.get(i)+" ");
		}*/
		ListIterator<Integer> it=list.listIterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println("\n==================");
		while(it.hasPrevious()) {
			System.out.print(it.previous()+" ");
		}
	}

}
