package com.sist.temp;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledEditorKit;

//750 730
public class ChatPanel extends JPanel {
	JTextPane pane;
	JTextField tf; // 입력창
	JButton b1,b2;
	JTable table; // 화면UI(접속자 목록)
	DefaultTableModel model; //데이터 관리(접속자 목록)
	JComboBox<String> box;
	/*
	 * 화면관리 / 데이터관리를 따로 하는 프로그램
	 * -----    -------
	 *  View     Model  ==> 연결(Controller)
	 *  MVC(Spring)
	 */
	public ChatPanel() {
		// 초기화
		pane=new JTextPane();
		pane.setEditable(false);
		JScrollPane js1=new JScrollPane(pane);
		tf=new JTextField();
		box=new JComboBox<String>();
		
		// red => 알림
		box.addItem("black");
		box.addItem("blue");
		box.addItem("yellow");
		box.addItem("green");
		box.addItem("pink");
		box.addItem("orange");
		box.addItem("cyan");
		
		// 테이블
		String[] col= {"아이디","이름","성별"};
		String[][] row=new String[0][3];
		model=new DefaultTableModel(row,col);
		table=new JTable(model);
		JScrollPane js2=new JScrollPane(table);
		b1=new JButton("쪽지보내기");
		b2=new JButton("정보보기");
		JPanel p=new JPanel();
		p.add(b1);
		p.add(b2);
		
		// 배치
		setLayout(null);
		js1.setBounds(10, 15, 500, 600);
		tf.setBounds(10, 620, 380, 30);
		box.setBounds(395, 620, 115, 30);
		js2.setBounds(520, 15, 230, 250);
		p.setBounds(520, 270, 230, 35);
		
		// 윈도우에 추가
		add(js1);
		add(tf);
		add(box);
		add(js2);
		add(p);
		String[] data= {"hong","홍길동","남자"};
		model.addRow(data);
		
		// 이벤트
	}
	public void initStyle() {
		Style blue=pane.addStyle("blue", null);
		StyleConstants.setForeground(blue, Color.blue);
		
		Style yellow=pane.addStyle("yellow", null);
		StyleConstants.setForeground(yellow, Color.yellow);
		
		Style green=pane.addStyle("green", null);
		StyleConstants.setForeground(green, Color.green);
		
		Style pink=pane.addStyle("pink", null);
		StyleConstants.setForeground(pink, Color.pink);
		
		Style orange=pane.addStyle("orange", null);
		StyleConstants.setForeground(orange, Color.orange);
		
		Style cyan=pane.addStyle("cyan", null);
		StyleConstants.setForeground(cyan, Color.cyan);
	}
	public void append(String msg, String color) {
		try {
			Document doc=pane.getDocument();
			doc.insertString(doc.getLength(), msg+"\n", pane.getStyle(color));
		}catch(Exception ex) {}
		
	}
}
