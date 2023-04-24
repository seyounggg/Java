package com.sist.exam;

import java.util.Scanner;
/*
 * 네트워크 => 접속(사용자 정보) =>ip
 */
public class MemberSystem {
	static Member[] members=new Member[10]; // 배열 공간 확보(주소 할당된게 아님)
	static int index=0; // 공유(static)를 해야 증가할 수 있음
	// 오라클 => 모든 데이터 static
	// 회원가입
	public void join() {
		Scanner scan=new Scanner(System.in);
		System.out.print("아이디,이름,성별 입력(hong 홍길동 남자):");
		members[index]=new Member(); // 메모리 주소 할당
		members[index].setId(scan.next());
		members[index].setName(scan.next());
		members[index].setSex(scan.next());
		index++;
		
	}
	public void print() {
		for(Member m:members) {
			if(m!=null) {
				System.out.println(m.getId()+" "+m.getName()+" "+m.getSex());
			}
		}
	}
}
