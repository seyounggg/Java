package com.sist.server;
/*
 *   1. 전환 / 우편
 *      ---   ---> 손실 가능성 있음(속도가 빠름) => UDP
 *     -> 신뢰성이 뛰어남(속도가 느림) => TCP
 *      TCP+UDP 의 장점
 *       - 신뢰성 + 속도 => RTCP(화상) => ZOOM / 웨일온...
 *   2. TCP 제작
 *      1) PORT(전화선) : 연결선
 *         0~66535까지 사용이 가능
 *         --> 알려진 PORT(이미 사용중) => 0~1023은 사용중
 *             80 : http (웹)
 *             23 : telnet
 *             25 : smtp
 *             21 : ftp
 *             8080 : 프록시(임시포트)
 *             4000 : 머드서버
 *             1521 : 오라클 서버
 *             1433 : MS-SQL
 *             3306 : MySQL
 *             3000 : ReactJS
 *         => 화상 => 30000
 *         => 음성 => 20000
 *         
 *      2) IP(전화번호) : 컴퓨터 구분
 *         --------------------- 개통
 *         서버는 1대 / 클라이언트는 여러대
 *         ---------------------
 *   3. 프로그램 제작
 *      1) 서버 동작
 *         ServerSocket ss=
 *                 new ServerSocket(port번호)
 *         => bind() : 개통 (ip, port) => 유심(개통)
 *         => listen() : 클라이언트 연결시까지 대기
 *      2) 클라이언트가 접속시 처리
 *         => ss.accept()
 *            ✔ 클라이언트가 서버 연결 호출(연결시마다 호출)
 *            ✔ 진동 / 음악 ...
 *         => 클라이언트 정보(ip, port)
 *                        -------- Socket(묶어서 처리하는 것)
 *      3) 클라이언트마다 따로 통신이 가능하게 넘겨준다 ==> 쓰레드
 *         ✔ 쓰레드는 한개의 프로그램안에서 여러개의 프로그램이 동시에 작동하게 만든다
 *                  -----------> 프로세스
 *         쓰레드는 시분할 => CPU를 나눠서 작업하므로 속도가 향상된다
 *                        실시간 또는 동시 수행시 사용되는 기술
 *                        ----------------------------
 *                        => 웹 (Ajax, VueJS, ReactJS)
 *                        => 쓰레드 : 게임에 많이 사용된다
 *         ✔ 쓰레드 작동과정
 *           생성
 *                        start()       run()         sleep()
 *           new Thread() =====> 대기상태 =====> Running =====> 대기상태
 *                                                | --> interrupt()
 *                                               Dead
 *           => 서버는 1개 작동 => 통신하는 프로그램을 여러개 실행
 *                              -----------------------> 쓰레드
 *      
 */
import java.util.*;

import com.sist.common.Function;

import java.net.*;
import java.io.*;
public class Server implements Runnable{
	// 클라이언트 접속 시 정보(IP)
	private Vector<Client> waitVc=new Vector<Client>();
	/*
	 *   Vector => ArrayList
	 *    동기화      비동기화
	 *   네트워크    데이터베이스 읽기
	 *   
	 *   add, get, size
	 */
	private ServerSocket ss;
	private final int PORT=33333;
	// 서버 가동 ==> 한 컴퓨터안에서 서버를 두개 실행 할 수 없다
	public Server() {
		try {
			ss=new ServerSocket(PORT);
			// bind() => listen()
			// PORT => 50명 한정
			/*
			 * ss=new ServerSocket(PORT,1000);
			 *                          -----안적으면 50명
			 */
			System.out.println("Server Start...");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// 접속 시 마다 처리
	public void run() {
		try {
			while(true) {
				Socket s=ss.accept();
				// 접속시마다 발신자 정보를 확인
				// => 전화번호 => Socket(ip)
				Client client=new Client(s);
				//waitVc.add(client);
				client.start();
				// 클라이언트마다 따로 생성 => 각자 통신이 가능하게 만든다
			}
		}catch(Exception ex) {}
	}
	public static void main(String[] args) {
		Server server=new Server();
		new Thread(server).start();
		// Server클래스 안에 있는 run을 호출한다
	}
	
	// 통신서버 => 저장된 클라이언트 정보 사용
	/*
	 *   내부 클래스 : 클래스기리 공유하는 변수, 메소드가 있는 경우
	 *              서버 프로그램 / 빅데이터 프로그램
	 *   class Server {
	 *      class Client {
	 *      }
	 *   }
	 */
	class Client extends Thread{
		String id, name, sex;
		// 클라이언트에서 보낸값 읽기
		BufferedReader in;
		
		// 클라이언트로 결과값 전송
		OutputStream out;
		
		// 클라이언트와 연결 ==> 연결 기기(전화기)
		Socket s;
		
		// 연결 시도
		public Client(Socket s) {
			try {
				this.s=s;
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				// Socket => 클라이언트의 메모리
				out=s.getOutputStream();
			}catch(Exception ex) {}
		}
		// 개인적으로 전송
		public synchronized void messageTo(String msg) {
			// synchronized : 동기화
			// default는 비동기화
			// VueJS => async 메소드명() , sync 메소드명()
			try {
				out.write((msg+"\n").getBytes());
				// 전송단위 = byte단위 ==> char단위로 변경해야함
				// InputStreamReader() => char단위로 변경해줌
			}catch (Exception e) {}
		}
		
		// 접속자 전체 전송
		public synchronized void messageAll(String msg) {
			try {
				for(Client c:waitVc) {
					c.messageTo(msg);
				}
			}catch(Exception ex) {}
		}
		
		// 요청에 대한 처리
		public void run() {
			while(true) {
				try {
					//요청값 받는다
					String msg=in.readLine();
					//100(기능번호)|id|name|sex
					System.out.println("Client 전송값 : "+msg);
					StringTokenizer st =
							new StringTokenizer(msg, "|");
					int protocol=Integer.parseInt(st.nextToken());
					switch(protocol) {
					case Function.LOGIN:
					{
						id=st.nextToken();
						name=st.nextToken();
						sex=st.nextToken();
						
						// 이미 접속자에게 정보 전송
						messageAll(Function.LOGIN+"|"+id+"|"+name+"|"+sex);
						
						// waitVc에 첨부
						waitVc.add(this);
						
						// 로그인창은 사라지고 main창을 보여주는 기능
						messageTo(Function.MYLOG+"|"+name+"|"+id);
						
						// 로그인하는 접속자에게 모든 정보를 전송
						for(Client user : waitVc) {
							messageTo(Function.LOGIN+"|"+user.id+"|"+user.name+"|"+user.sex);
						}
					}
					break;
					case Function.CHAT :
					{
						String strMsg=st.nextToken();
						String color=st.nextToken();
						messageAll(Function.CHAT+"|["+name+"]"+strMsg+"|"+color);
					}
					break;
					case Function.INFO :
					{
						// 상대방의 ID를 받는다
						String youId=st.nextToken();
						for(Client user : waitVc) {
							// 정보 볼 대상 찾아주는 과정
							/*
							 *   서버의 역할
							 *   1. 저장 기능(클라이언트의 정보)
							 *      => waitVc(Vector)
							 *   2. 검색 기능 : id, name...
							 *   3. 수정 기능 : id, name, pwd...
							 *   4. 클라이언트 전송기능
							 *   5. 요청에 대한 처리기능
							 */
							if(youId.equals(user.id)) {
								// 전송기능
								messageTo(Function.INFO+"|"+user.id+"|"+user.name+"|"+user.sex);
								break;
							}
						}
					}break;
					case Function.MSGSEND :{
					String youId=st.nextToken();
					String strMsg=st.nextToken();
					for(Client user:waitVc) {
						if(youId.equals(user.id)) {
							user.messageTo(Function.MSGSEND+"|"+id+"|"+strMsg);
							break;
						}
					}
					}break;
					case Function.EXIT :
					{
						String mid=st.nextToken();
						int i=0;
						for(Client user:waitVc) {
							if(user.id.equals(mid)) {
								user.messageTo(Function.MYEXIT+"|");
								waitVc.remove(i); // 명단에서 제거
								in.close();
								out.close();
								// 서버 종료
								break;
							}
							i++;
						}
						// 전체 메세지 날리기
						messageAll(Function.EXIT+"|"+mid);
					}
					}
				}catch(Exception ex) {}
			}
		}
	}
	
}
