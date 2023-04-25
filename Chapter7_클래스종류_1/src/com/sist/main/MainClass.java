package com.sist.main;
/*
 * 1. 제어어
 *    1) static : 공통적인
 *       => Math가 갖고있는 모든 메소드
 *          
 *    2) final : 마지막 =>변수(상수)/class(종단 클래스 => 확장 불가능, 상속할 수 없다)
 *       => class final className
 *          = java.lang에 포함된 System, String, Math, StringBuffer => 있는 그대로 사용
 *    3) abstract : 추상적인 => 공통점을 모아준다 => 프로그램에 맞게 구현
 * -------------------------------------------------------------------------------
 * 2. 클래스의 종류
 *    1) 추상클래스
 *       형식)
 *          public abstract class ClassName 
 *          {
 *             ---------------------------
 *             1. 변수(멤버변수)
 *             ---------------------------
 *             2. 메소드 : 구현된 메소드
 *             ---------------------------
 *             3. 메소드 : 구현이 안된 메소드 (선언)
 *                => 자신이 메모리 할당을 할 수 없다
 *                예) 
 *                 abstract class A {
 *                 }
 *                 
 *                 A a=new A(); ==> 오류
 *                 => 상속을 받는다 => 구현이 안된 메소드를 구현한 후에 사용
 *                 => 오버라이딩 기법
 *                 
 *                 class B extends A {
 *                 }
 *                 
 *                 A a=new B(); => 묵시적 형변환(자동 형변환)
 *                     -------- a가 가지고 있는 메소드는 B로 대체
 *                 B b=new B();
 *             ---------------------------
 *             4. 생성자
 *             ---------------------------
 *          }
 *    2) 인터페이스 : 
 *       1)단일상속 -> 다중상속으로 바꿈(추상 클래스의 단점을 보완)
 *       2) 추상 클래스의 일종 (클래스 => 상위클래스)
 *       3) 구성요소
 *       public interface InterfaceName
 *       {
 *         ---------------------------
 *          변수 설정
 *           상수형 변수
 *           int a; => 오류 발생
 *           int a=10; => 정상 수행
 *              => 컴파일 시 "public static final" 자동 추가
 *              => public static final int a=10;
 *         ---------------------------
 *          메소드(구현이 안된 메소드)
 *             void display();
 *             => 컴파일 시
 *             => public abstract void display();
 *               --------------> 자동추가
 *                         
 *          interface A {
 *          (public abstract)void display();
 *          }
 *          class B implements A
 *          {
 *               private int a=10; => 오류// 접근지정어는 public만 가능!
 *               void display() { 
                 }
 *               => 오버라이딩 조건에서 오류 발생
 *               => 접근지정어 축소 // display메소드가 public 으로 선언되었으므로
 *                                 상속받아 사용할 때 public 을 써줘야 한다
 *           }
 *           (**) 인터페이스의 모든 메소드와 변수는 public
 *         ---------------------------
 *         메소드(구현된 메소드(JDK 1.8이상))
 *         => 인터페이스에 선언된 메소드를 추가 시 관련된 모든 클래스가 오류 발생
 *            default void methodName()
 *            ------- public 자동 추가
 *            {
 *            }
 *         ---------------------------
 *         메소드(구현된 메소드(JDK 1.8이상))
 *         static void methodName()
 *         ------ public 자동 추가
 *         {
 *         }
 *         => public static void methodName()
 *         ---------------------------
 *       }
 *       (***) 추상클래스, 인터페이스는 상속을 받는 경우
 *             반드시 선언만 된 메소드를 구현해서 사용한다
 *       (***) 추상클래스 : 입출력, 네트워크, 데이터베이스 연결
 *       (***) 인터페이스 : 윈도우 이벤트_ 버튼클릭, 마우스 클릭, 키보드...
 *        
 *    3) 내부클래스(네트워크, 빅데이터)
 *       - 멤버클래스 : 쓰레드 => 데이터를 공유
 *         class A { =>(Server)
 *              A,B,C,D,E => 변수나 메소드
 *              class B { =>(총신)
 *                   A, B... => 그냥 가져다가 쓸 수 있음
 *              }
 *         }
 *       - 익명의 클래스 : 상속이 없이 오버라이딩이 가능
 *       class A {
 *            B b=new B(){
 *                 void display(){}
 *            } // 상속 없이 오바라이딩
 *       }
 *       class B {
 *            void display(){}
 *       }
 *    
 */
import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MainClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
