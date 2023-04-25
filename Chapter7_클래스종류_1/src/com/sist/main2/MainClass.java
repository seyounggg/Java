package com.sist.main2;
import java.util.*;

// 인터페이스 => 여러개의 클래스를 묶어서 쉽게 관리할 목적
// 스프링(클래스 관리자) => 인터페이스
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("해당 클래스 번호:");
		int no=scan.nextInt();
		Container cc=new Container();
		
		// interface 이용
		Exec a=(Exec)cc.getBean(no);
		a.execute();
		
		/*if(no==1) {
			A a=(A)cc.getBean(no);
			// Object가 A보다 커서 명시적 초기화를 해야한다.
			// getBean에 있는 A만 가져오라는 의미
			a.execute();
		}
		if(no==2) {
			B a=(B)cc.getBean(no); 
			a.execute();
		}
		if(no==3) {
			C a=(C)cc.getBean(no);
			a.execute();
		}
		if(no==4) {
			D a=(D)cc.getBean(no); 
			a.execute();
		}
		if(no==5) {
			E a=(E)cc.getBean(no); 
			a.execute();
		}*/
	}

}
