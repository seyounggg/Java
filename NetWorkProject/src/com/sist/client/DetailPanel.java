package com.sist.client;

import java.util.*;
import com.sist.manager.*;
import com.sist.client.ControlPanel;

import java.awt.*;

import javax.print.event.PrintJobAttributeEvent;
import javax.print.event.PrintJobAttributeListener;
import javax.swing.*;
import java.awt.event.*;

public class DetailPanel extends JPanel implements ActionListener{
	JLabel imgLa;
	JLabel la1, la2, la3, la4, la5;
	JButton b1, b2;
	JLabel titleLa, regdateLa, gradeLa, ageLa, contentLa, keyLa;
	ControlPanel cp;
	public DetailPanel(ControlPanel cp) {
		this.cp=cp; // controlPanel에 이미 메모리 할당을 해두었으므로, controlPanel을 가져옴
		// 생성자 : 시작과 동시에 구현
		// 웹 => 데이터베이스 설정, 자동로그인 ...
		imgLa=new JLabel();
		la1=new JLabel("제목");
		la2=new JLabel("개봉일");
		la3=new JLabel("평점");
		la4=new JLabel("연령");
		la5=new JLabel("주요정보");
		b1=new JButton("동영상");
		b2=new JButton("목록"); // 목록으로 돌아가기
		titleLa=new JLabel("");
		regdateLa=new JLabel("");
		gradeLa=new JLabel("");
		ageLa=new JLabel("");
		contentLa=new JLabel("");
		keyLa=new JLabel("");
		
		//배치
		setLayout(null);
		imgLa.setBounds(100, 15, 530, 350); //cp.setbounds 비교
		la1.setBounds(100, 375, 60, 40);
		titleLa.setBounds(165, 375, 300, 40);
		
		la2.setBounds(100, 425, 60, 40);
		regdateLa.setBounds(165, 425, 300, 40);
		
		la3.setBounds(100, 475, 60, 40);
		gradeLa.setBounds(165, 475, 300, 40);
		
		la4.setBounds(100, 525, 60, 40);
		ageLa.setBounds(165, 525, 300, 40);
		
		la5.setBounds(100, 575, 60, 40);
		contentLa.setBounds(165, 575, 300, 40);
		
		keyLa.setBounds(100, 625, 300, 40);
		keyLa.setVisible(false); // 안보이게 감춰둔거
		
		JPanel p=new JPanel();
		p.add(b1);
		p.add(b2);
		p.setBounds(100, 670, 365, 40);
		
		//윈도우에 추가
		add(imgLa);
		add(keyLa);
		add(la1); add(titleLa);
		add(la2); add(regdateLa);
		add(la3); add(gradeLa);
		add(la4); add(ageLa);
		add(la5); add(contentLa);
		add(p);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			try {
				//Runtime.getRuntime().exec("/Applications/Firefox.app/Contents/MacOS/firefox-bin http://youtube.com/embed/"+keyLa.getText());
				/*
				 * Runtime.getRuntime().exec("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome http://youtube.com/embed/" + keyLa.getText());

				 */
				String[] command = {"/Applications/Google Chrome.app/Contents/MacOS/Google Chrome", "http://youtube.com/embed/" + keyLa.getText()};
				Runtime.getRuntime().exec(command);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else if(e.getSource()==b2) {
			cp.card.show(cp, "home");
		}
	}
}
