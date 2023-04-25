package com.sist.lib;
/*
 *   toString을 자주 사용하는 예제
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class 라이브러리_Object_2_1 extends JFrame implements ItemListener{
	JComboBox box;
	JLabel la;
	public 라이브러리_Object_2_1() {
		box=new JComboBox();
		box.addItem("홍길동"); // addItem의 경우 리턴값이 Object이다
		box.addItem("심청이");
		box.addItem("박문수");
		la=new JLabel();
		
		//배치
		add("North",box);
		add("Center",la);
		
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 라이브러리_Object_2_1();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// 선택이 바뀌었을 때 구현하는 메소드
		if(e.getSource()==box) {
			String name=box.getSelectedItem().toString();
			//getSelectedItem의 리턴값이 Object라서 오류가 발생함
			//문자열로 변환하여 사용해야 하는데, 아래 3가지 방법을 사용할 수 있다
			//1) (String)box.getSelectedItem()
			//2) box.getSelectedItem().toString();
			//3) String.valueOf(box.getSelectedItem());
			la.setText(name);
		}
		
	}

}
