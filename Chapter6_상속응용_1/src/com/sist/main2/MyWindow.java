package com.sist.main2;
//상속
import javax.swing.*;
import java.awt.*;
//생성자, 초기화블록, static => 상속 제외
public class MyWindow extends JFrame{
	//시작하자마자 동작을 해야할 때 생성자를 이용한다
	JLabel la1,la2; //포함클래스
	JTextField tf; //포함클래스
	JPasswordField pf; //포함클래스
	JButton b1,b2; //포함클래스
	public MyWindow() {
		la1=new JLabel("아이디");
		la2=new JLabel("비밀번호");
		tf=new JTextField();
		pf=new JPasswordField();
		b1=new JButton("로그인");
		b2=new JButton("취소");
		setLayout(null);
		la1.setBounds(10, 15, 55, 30);
		la2.setBounds(10, 50, 55, 30);
		tf.setBounds(70, 15, 150, 30);
		pf.setBounds(70, 50, 150, 30);
		JPanel p=new JPanel();
		p.add(b1);
		p.add(b2);
		p.setBounds(10,90,210,35);
		add(p);
		add(la1);add(tf);
		add(la2);add(pf);
		setSize(640,480);
		setVisible(true); // 자동로그인
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyWindow m=new MyWindow();
	}

}
