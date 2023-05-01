package com.sist.util;
import java.util.*;
/*
 *   subLine(int start, int end)
 *     => index번호가 start부터 end(end-1)까지 부분적으로 데이터 복사
 *     => 페이지 나누기 가능
 *   addAll
 *     => ArrayList가 가지고 있는 모든 데이터 복사
 *   retainAll()
 *     => 두개의 ArrayList에서 같은 값을 가지고 있는 데이터 복사
 *   Collections.sort()
 *     => ArrayList 정렬
 */
public class 라이브러리_List_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList names1=new ArrayList();
		names1.add("홍길동");
		names1.add("심청이");
		names1.add("이순신");
		names1.add("강감찬");
		names1.add("춘향이");
		for(Object name:names1) {
			System.out.println(name);
		}
		System.out.println("====================");
		ArrayList names2=new ArrayList();
		names2.add("홍길수");
		names2.add("심청이");
		names2.add("이순이");
		names2.add("강감차");
		names2.add("성춘향");
		
		// 교집합 => retainAll
		// 1) names1과 names2 데이터 중 같은 데이터를 찾아라
		// 2) 찾은 데이터를 names1에 저장해라
		// 왜냐면 메모리 주소로 변경하기때문에
		// names1의 원본이 변경되지 않으려면 임시 저장소를 만들어서 관리해야함
		ArrayList temp=new ArrayList();
		temp.addAll(names1); // temp에 names1 데이터를 저장
		temp.retainAll(names2); // temp데이터로 retainAll() 
		
		for(Object name:names1) { // names1데이터 변경없는지 for-each로 출력해보기!
			System.out.println(name);
		}
		// 결과값 : 심청이
		System.out.println("=====================");
		for(Object name:temp) {
			System.out.println(name);
		}
		
		
	}

}
