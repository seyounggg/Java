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
	JLabel titleLa, regdateLa, gradeLa, ageLa, keyLa;
	JTextPane contentTa;
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
		la5=new JLabel("줄거리");
		b1=new JButton("동영상");
		b2=new JButton("목록"); // 목록으로 돌아가기
		titleLa=new JLabel("");
		regdateLa=new JLabel("");
		gradeLa=new JLabel("");
		ageLa=new JLabel("");
		//contentLa=new JLabel(""); -> 이걸 JTextPanel로 변경
		contentTa=new JTextPane();
		contentTa.setEditable(false);
		JScrollPane js=new JScrollPane(contentTa);
		keyLa=new JLabel("");
		
		//배치
		setLayout(null);
		imgLa.setBounds(150, 15, 630, 500); //cp.setbounds 비교
		la1.setBounds(100, 530, 60, 20);
		titleLa.setBounds(165, 530, 300, 20);
		
		la2.setBounds(100, 560, 60, 20);
		regdateLa.setBounds(165, 560, 300, 20);
		
		la3.setBounds(100, 590, 60, 20);
		gradeLa.setBounds(165, 590, 300, 20);
		
		la4.setBounds(100, 620, 60, 20);
		ageLa.setBounds(165, 620, 300, 20);
		
		la5.setBounds(100, 650, 60, 20);
		//contentLa.setBounds(165, 575, 300, 40);
		js.setBounds(165, 650, 600, 70);
		
		keyLa.setBounds(100, 730, 300, 40);
		keyLa.setVisible(false); // 안보이게 감춰둔거
		
		JPanel p=new JPanel();
		p.add(b1);
		p.add(b2);
		p.setBounds(100, 770, 365, 40);
		
		//윈도우에 추가
		add(imgLa);
		add(keyLa);
		add(la1); add(titleLa);
		add(la2); add(regdateLa);
		add(la3); add(gradeLa);
		add(la4); add(ageLa);
		add(la5); add(js);
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
				String[] command = {"/Applications/Google Chrome.app/Contents/MacOS/Google Chrome", "https://tv.naver.com/v/" + keyLa.getText()};
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
