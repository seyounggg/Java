package com.sist.server;
import java.util.*;

import com.sist.common.Function;
import com.sist.server.Server.Client;

import java.net.*;
import java.io.*;
public class Server implements Runnable{
	// 클라이언트 접속시에 정보(IP) 
	private Vector<Client> waitVc=new Vector<Client>();
	/*
	 *   Vector => ArrayList(데이터베이스 읽기)
	 *   ------    ----------
	 *     동기화      비동기화 
	 *      |
	 *     네트워크 
	 *     
	 *     add , get , size 
	 */
    private ServerSocket ss;
    private final int PORT=33333;
    // 서버 가동 ==> 한컴퓨터안에서 서버를 두개 실행 할 수 없다 
    public Server()
    {
    	try
    	{
    		ss=new ServerSocket(PORT);
    		// bind() => listen()
    		// PORT => 50명 한정 
    		System.out.println("Server Start...");
    	}catch(Exception ex) 
    	{
    		ex.printStackTrace();
    	}
    }
	// 접속시마다 처리 
	public void run()
    {
    	try
    	{
    		while(true)
    		{
    			Socket s=ss.accept();
    			// 접속시마다 발신자 정보를 확인 
    			// => 전화번호 => Socket(ip) 
    			Client client=new Client(s);
    			//waitVc.add(client);
    			client.start();
    			// 클라이언트마다 따로 생성 => 각자 통신이 가능하게 만든다 
    		}
    	}catch(Exception ex){}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
        // Server안에 있는 run을 호출한다 
	}
	
	// 통신 서버 ==> 저장된 클라이언트 정보 사용 
	/*
	 *   내부 클래스 : 클래스끼리 공유하는 변수/메소드가 있는 경우 
	 *              서버 프로그램 / 빅데이터 프로그램 
	 *   class Server
	 *   {
	 *      class Client
	 *      {
	 *      }
	 *   }
	 */
	class Client extends Thread
	{
		String id,name,sex;
		// 클라이언트에서 보낸값 읽기 
		BufferedReader in;
		// 클라이언트로 결과값 전송 
		OutputStream out;
		// 클라이언트와 연결 ==> 연결 기기(전화기)
		Socket s;
		
		// 연결 시도
		public Client(Socket s)
		{
			try
			{
				this.s=s;
				in=new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				// socket => 클라이언트의 메모리 
				out=s.getOutputStream();
			}catch(Exception ex) {}
			
		}
		// 개인적으로 전송 
		public synchronized void messageTo(String msg)
		{
			// synchronized : 동기화 
			// 디폴트는 비동기화 
			// => VueJS ==> async 메소드명() , sync 메소드명()
			try
			{
				out.write((msg+"\n").getBytes());
				// Byte단위 ==> Char단위로 변경 
				// InputStreamReader()
			}catch(Exception ex){}
		}
		// 접속자 전체 전송 
		public synchronized void messageAll(String msg)
		{
			try
			{
				for(Client c:waitVc)
				{
					c.messageTo(msg);
				}
			}catch(Exception ex) {}
		}
		// 요청에 대한 처리 
		public void run()
		{
		  while(true)
		  {
			try
			{
				//요청값을 받는다 
				String msg=in.readLine();
				// 100|id|name|sex 
				StringTokenizer st=
						new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				switch(protocol)
				{
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
				    case Function.CHAT:
				    {
				    	String strMsg=st.nextToken();
				    	String color=st.nextToken();
				    	messageAll(Function.CHAT+"|["+name+"]"
				    			+strMsg+"|"+color);
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
			}catch(Exception ex){}
		  }
		}
		
	}
	

}