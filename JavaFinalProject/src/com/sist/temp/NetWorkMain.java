package com.sist.temp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.sist.common.Function;
import com.sist.common.ImageChange;
import com.sist.manager.GenieMusicVO;
import com.sist.manager.MusicSystem;
import java.util.*;
// List,io,net => 네트워크 관련 패키지
import java.util.List;
import java.io.*;
import java.net.*;
/*
 *   프로그램이 2개 동작함
 *   1) 로그인, 채팅 문자열 입력 ... => 일반 사용자
 *   2) 서버에서 전송되는 데이터를 출력 (=> thread 역할)
 */
/*   << 공부 과정 >>
 *   웹에서 필요한 기술
 *   => 데이터베이스(오라클 => MySQL)
 *      ------------------------ MyBatis / JPA
 *   => 데이터베이스 제어 => 자바
 *      자바
 *        - 클래스 개념 : 변수, 메소드, 생성자
 *        - 인터페이스 : 요구사항 분석(기능)
 *        - 예외처리
 *        - 라이브러리
 *        java.lang
 *             Object / String / StringBuffer / Math / Wrapper
 *        java.util
 *             StringTokenizer / Date, Calendar
 *             Collection => ArrayList, Hashmap, HashSet
 *        java.net
 *             URL / URLEncoder
 *        java.io : 웹 => 업로드,다운로드(File)
 *                  => Buffered~
 *                     FileInputStream, FileOutputStream
 *                     FileReader, FileWriter
 *                     BufferedReader, File
 *        java.text : SimpleDateFormat
 *   -----------------------------------------------------------
 *   2차 자바(web관련)
 *      java.sql , javax.sql, javax.nameing
 *      javax.servlet.*
 *      
 *      브라우저 ===== 자바 ===== 오라클
 *                            ----- 데이터를 저장
 *       윈도우 ===== 자바 ===== 파일
 *                  --- 데이터 읽기 / 데이터전송
 *   => 1) 오라클 제어
 *        SELECT / UPDATE / DELETE / INSERT => DML
 *        --------------------------------- 데이터 조작언어
 *        CREATE / ALTER / DROP / TRUNCATE / RENAME => DDL
 *        ----------------------------------------- 데이터 저장/생성
 *        GRANT / REVOKE => DCL
 *        -------------- Admin
 *        COMMIT / ROLLBACK => TCL
 *        ----------------- 일괄처리
 *      2) 기타 : VIEW / SEQUENCE / PS-SQL(FUNCTION,PROCEDUR/TRIGGER)
 *      3) 데이터베이스 모델링 (정규화, 제약조건)
 *
 *   => 브라우저에 데이터 출력 : HTML / CSS / JavaScript
 *   => 자바스크립트 라이브러리 : JQuery / Ajax
 *   ================================================[1차 프로젝트]===
 *   Spring (Back-End) / VueJS(Front-End)
 *   ------------------------------------[2차 프로젝트]---------------
 *   Spring-Boot / My-SQL / ReactJS / JPA
 *   ------------------------------------[3차 프로젝트]---------------
 *   AWS => 호스팅
 */
public class NetWorkMain extends JFrame 
				implements ActionListener,Runnable,MouseListener{
	MenuPanel mp;
	ControlPanel cp;
	TopPanel tp;
	JButton b1,b2,b3,b4,b5,b6;
	JLabel logo;
	Login login=new Login();
	// 페이지 지정
	int curpage=1;
	int totalpage=0;
	MusicSystem ms=new MusicSystem();
	
	// 네트워크와 관련 클래스
	// 서버 연결 => 연결 기기
	Socket s; // -> 서버에 메모리 연결
	// 서버에서 보내준 값 받기
	BufferedReader in;
	// 서버로 값을 보내기
	OutputStream out;
	// id저장
	String myId;
	// 테이블 선택 인덱스 번호
	int selectRow=-1; // 선택이 안될 가능성이 있기 때문에 -1로 설정
	// 쪽지보내기
	SendMessage sm=new SendMessage();
	RecvMessage rm=new RecvMessage();
	
	public NetWorkMain() {
		logo=new JLabel();
		Image img=ImageChange.getImage(new ImageIcon("/Users/seyeong/Desktop/Java/music.jpg"), 200, 130);
		logo.setIcon(new ImageIcon(img));
		mp=new MenuPanel();
		cp=new ControlPanel();
		tp=new TopPanel();
		
		setLayout(null); //Layout없이 직접 배치
		logo.setBounds(10, 15, 200, 130);
		mp.setBounds(10, 150, 200, 300);
		cp.setBounds(220, 15, 750, 780);
		tp.setBounds(980, 15, 200, 730);
		
		b1=new JButton("홈");
		b2=new JButton("뮤직검색");
		b3=new JButton("채팅");
		b4=new JButton("뉴스검색");
		b5=new JButton("커뮤니티"); //CURD
		b6=new JButton("나가기");
		mp.setLayout(new GridLayout(6,1,10,10));
		mp.add(b1);
		mp.add(b2);
		mp.add(b3);
		mp.add(b4);
		mp.add(b5);
		mp.add(b6);
		
		//추가
		add(mp);
		add(cp);
		add(tp);
		add(logo);
		
		//윈도우크기
		setSize(1200, 800);
		//setVisible(true);
		
		//종료
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("네트워크 뮤직 프로그램");
		
		//이벤트 등록
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		   //login
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		   //채팅
		cp.cp.tf.addActionListener(this);
		List<GenieMusicVO> list=ms.musicListData(curpage);
		cp.hp.cardInit(list);
		cp.hp.cardPrint(list);
		totalpage=ms.musicTotalPage();
		cp.hp.b1.addActionListener(this); // 이전
		cp.hp.b2.addActionListener(this); // 다음
		cp.hp.pageLa.setText(curpage+" page /"+totalpage+"pages");
		
		cp.cp.b1.addActionListener(this); // 쪽지보내기
		cp.cp.b2.addActionListener(this); // 정보 보기
		cp.cp.table.addMouseListener(this);
		
		//쪽지보내기
		sm.b1.addActionListener(this);
		sm.b2.addActionListener(this);
		rm.b1.addActionListener(this);
		rm.b2.addActionListener(this);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		}catch(Exception ex) {}
		new NetWorkMain();
	}
	//버튼 처리 //
	
	public void musicDisplay() {
		List<GenieMusicVO> list=ms.musicListData(curpage);
		cp.hp.cardInit(list);
		cp.hp.cardPrint(list);
		totalpage=ms.musicTotalPage();
		cp.hp.pageLa.setText(curpage+" page /"+totalpage+"pages");
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			curpage=1;
			musicDisplay();
			cp.card.show(cp, "home");
		}
		else if(e.getSource()==b2) {
			cp.card.show(cp, "find");
		}
		else if(e.getSource()==b3) {
			cp.card.show(cp, "chat");
		}
		else if(e.getSource()==b4) {
			cp.card.show(cp, "news");
		}
		else if(e.getSource()==b5) {
			cp.card.show(cp, "board");
		}
		else if(e.getSource()==login.b1) {
			// 로그인 데이터 읽기
			String id=login.tf1.getText();
			if(id.length()<1) {
				JOptionPane.showMessageDialog(this, "ID를 입력하세요");	
				login.tf1.requestFocus();
				return;
			}
			String name=login.tf2.getText();
			if(id.length()<1) {
				JOptionPane.showMessageDialog(this, "이름를 입력하세요");	
				login.tf2.requestFocus();
				return;
			}
			String sex="남자";
			if(login.rb1.isSelected()) { // 남자 라디오버튼이 선택됐다면..
				sex="남자";
			}
			else{ // 남자가 아니라면..
				sex="여자";
			}
			// 입력된 값을 서버로 전송
			try {
				// 서버 연결
				s=new Socket("localhost",33333);
				// 서버 컴퓨터 => IP
				// 211.238.142.()
				
				// 읽는 위치 / 쓰는 위치
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				// s 는 서버 메모리 => 서버 메모리로부터 값을 읽어온다
				out=s.getOutputStream();
				// 서버에서 읽어갈 수 있게 메모리에 저장
				
				// 서버로 로그인 요청
				out.write((Function.LOGIN+"|"+id+"|"+name+"|"+sex+"\n").getBytes());
			}catch(Exception ex) {}
			// 서버로 부터 전송된 값을 받아오기
			new Thread(this).start(); // run() 호출
		}
		else if(e.getSource()==login.b2) {
			System.exit(0);
		}
		else if(e.getSource()==cp.cp.tf) {
			String msg=cp.cp.tf.getText();
			String color=cp.cp.box.getSelectedItem().toString();
			if(msg.length()<1) return;
			
			// 서버로 전송
			try {
				out.write((Function.CHAT+"|"+msg+"|"+color+"\n").getBytes());
			}catch (Exception ex) {}
			cp.cp.tf.setText("");
		}
		else if(e.getSource()==cp.hp.b1) {
			if(curpage>1) {
				curpage--;
				musicDisplay();
			}
		}
		else if(e.getSource()==cp.hp.b2) {
			if(curpage<totalpage) {
				curpage++;
				musicDisplay();
			}
		}
		else if(e.getSource()==cp.cp.b2) { // 정보보기
			// selectRow==-1 선택 안된 경우
			if(selectRow==-1) {
				JOptionPane.showMessageDialog(this, "정보 볼 대상을 선택하세요");
				return;
			}
			// 선택이 된 경우
			String youId=cp.cp.table.getValueAt(selectRow, 0).toString();
			try {
				// 선택된 아이디의 정보를 보여달라(서버에 요청)
				out.write((Function.INFO+"|"+youId+"\n").getBytes());
			//  --------- 서버요청 ==> \n이 포함돼야 한다
			// 처리 => 서버 => 결과값을 받아서 클라이언트에서 출력
			}catch(Exception ex) {}
		}
		else if(e.getSource()==cp.cp.b1) {
			// 쪽지 보내기
			sm.ta.setText("");
			String youId=cp.cp.table.getValueAt(selectRow, 0).toString();
			sm.tf.setText(youId);
			sm.setVisible(true);
		}
		// 쪽지 보내기 관련
		else if(e.getSource()==sm.b2) {
			sm.setVisible(false);
		}
		else if(e.getSource()==rm.b2) {
			rm.setVisible(false);
		}
		else if(e.getSource()==sm.b1) {
			String youId=sm.tf.getText();
			String msg=sm.ta.getText();
			if(msg.length()<1) {
				sm.ta.requestFocus();
				return;
			}
			try {
				out.write((Function.MSGSEND+"|"+youId+"|"+msg+"\n").getBytes());
				// youId를 찾아서 msg를 보내주는 기능 수행
			}catch(Exception ex) {}
			// 창을 감춘다
			sm.setVisible(false);
		}
		else if(e.getSource()==rm.b1) { 
			sm.tf.setText(rm.tf.getText());
			sm.ta.setText("");
			sm.setVisible(true);
			sm.setVisible(false);
		}
		else if(e.getSource()==b6) { // 나가기
			try {
				out.write((Function.EXIT+"|"+myId+"\n").getBytes());
			}catch(Exception ex) {}
		}
	}

	// 서버에서 결과값을 받아서 출력 => Thread (자동화)
	// member.jsp?id=aaa&pwd=1234&name=홍길동
	//    100
	@Override
	public void run() {
		try {
			while(true) {
				String msg=in.readLine();
				// 서버에서 보낸 값
				StringTokenizer st=
						new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				// 100|id|name|sex
				switch(protocol){
				// 서버에서 로그인이 들어온 경우
				// LOGIN => 테이블에 정보를 출력한다
				case Function.LOGIN :
				{
					String[] data=
						       {st.nextToken(), // ID
								st.nextToken(), // name
								st.nextToken()  // sex
						       };
					cp.cp.model.addRow(data);
				} break;
				// C/S => 모든 명령을 서버로부터 받아서 처리
				// MyLog => 로그인을 종료하고 메인창을 보여준다
				case Function.MYLOG:
				{
					setTitle(st.nextToken());
					myId=st.nextToken(); // id저장
					login.setVisible(false);
					setVisible(true);
				}break;
				case Function.CHAT:
				{
					cp.cp.initStyle();
					cp.cp.append(st.nextToken(), st.nextToken());
					//           --------------  --------------
					//             채팅 문자열           색상
				}break;
				case Function.INFO:{
					String data="아이디:"+st.nextToken()+"\n"
							+"이름:"+st.nextToken()+"\n"
							+"성별:"+st.nextToken();
					JOptionPane.showMessageDialog(this, data);
				}break;
				case Function.MSGSEND:{
					String id=st.nextToken();
					String  strMsg=st.nextToken();
					rm.tf.setText(id);
					rm.ta.setText(strMsg);
					rm.setVisible(true);
				}break;
				case Function.MYEXIT:
				{
					dispose(); //윈도우 메모리 해제
					System.exit(0); //프로그램 종료
				}break;
				case Function.EXIT:
				{
					String mid=st.nextToken();
					for(int i=0;i<cp.cp.model.getRowCount();i++) {
						String uid=cp.cp.table.getValueAt(i, 0).toString();
						// table 에 있는 모든 id 가져오기
						if(mid.equals(uid)) {
							cp.cp.model.removeRow(i);
							break;
						}
					}
				}break;
				}
			}
		}catch(Exception ex) {}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cp.cp.table) {
			//if(e.getClickCount()==2) { // e.getClickCount()==2 => 더블클릭
				selectRow=cp.cp.table.getSelectedRow(); // 선택한 줄을 가져오기
				String id=cp.cp.table.getValueAt(selectRow, 0).toString();
				//JOptionPane.showMessageDialog(this, "선택된 ID:"+id);
				if(id.equals(myId)) { 
		// myId와 선택한 id가 같을 경우에는(본인이면) 쪽지보내기, 정보보기를 못하게 b1,b2 (버튼)을 비활성화
					cp.cp.b1.setEnabled(false);
					cp.cp.b2.setEnabled(false);
				}
				else {
		// 본인이 아니면 쪽지보내기, 정보보기가 가능하게 b1,b2를 활성화
					cp.cp.b1.setEnabled(true);
					cp.cp.b2.setEnabled(true);
				}
			//}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
