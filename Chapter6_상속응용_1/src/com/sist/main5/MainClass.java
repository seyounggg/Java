package com.sist.main5;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Human h=new Human();
		h.print();
		
		h=new Member();
		h.print();
		
		h=new Sawon();
		h.print();
		*/
		Scanner scan=new Scanner(System.in);
		System.out.print("선택(Human(1),Member(2)mSawon(3)):");
		int select=scan.nextInt();
		/*if(select==1) {
			Human h=new Human();
			h.print();
			h.aaa();
			h.bbb();
		}
		else if(select==2) {
			Member h=new Member();
			h.print();
			h.aaa();
			h.bbb();
		}
		else if(select==3) {
			Sawon h=new Sawon();
			h.print();
			h.aaa();
			h.bbb();
		}*/
		Human h=null;
		if(select==1)
			h=new Human();
		else if(select==2)
			h=new Member();
		else if(select==3)
			h=new Sawon();
		//덮어쓰기는 가능한데, 다른 메소드에 추가된 내용은 가져올 수 없음
		h.print();
		h.aaa();
		h.bbb();
		// 추가 
	}

}
