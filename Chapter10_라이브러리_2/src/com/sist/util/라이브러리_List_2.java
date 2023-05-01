package com.sist.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// List 메소드
/*
 *   기본메소드 : add, remove, set, size, clear
 *   
 *   containsAll() : 두개의 list에서 중복된 데이터를 모아서 관리
 *      => JOIN
 *   retainAll() : 두개의 list에서 중복된 데이터만 남기기
 *   addAll() : 데이터 전체를 복사
 *   subList() : 부분적으로 데이터를 복사할 경우에 사용
 *   
 *   => 장바구니, 예매..
 *      ------ 중복 구매
 *   
 */
public class 라이브러리_List_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list.add(3); //0
		list.add(5); //1
		list.add(7); //2
		list.add(6); //3
		list.add(9); //4
		list.add(2); //5
		list.add(1); //6
		list.add(4); //7
		// 출력
		for(Object o:list) { // list에 저장된 값이 Object 이니까 Object로 출력
			System.out.println(o);
		}
		// 일부만 추가 subList(start, end)
		ArrayList list2=new ArrayList(list.subList(1, 4));
		list2.add(10);
		list2.add(11);
		list2.add(12);
		
		// end-1 => 1,2,3
		System.out.println("============");
		for(Object o:list2) { 
			System.out.println(o);
		}
		// sort
		System.out.println("============");
		Collections.sort(list);
		for(Object o:list) { 
			System.out.println(o);
		}
		// list에 list2데이터가 모두 포함되어 있는지 확인
		System.out.println("============");
		System.out.println(list.containsAll(list2)); // 10,11,12가 없으니까 false
		for(Object o:list) { 
			System.out.println(o);
		}
		// 중복된 데이터만 추출 => INSERECT (=교집합)
		System.out.println("============");
		System.out.println(list.retainAll(list2)); // print 만 하는게 아니라 list=중복된 데이터만 저장되게 해버림
		for(Object o:list) { 
			System.out.println(o);
		}
		// addAll
		System.out.println("============");
		ArrayList list3=new ArrayList();
		list3.addAll(list);
		for(Object o:list3) {
			System.out.println(o);
			
		}
	}

}
