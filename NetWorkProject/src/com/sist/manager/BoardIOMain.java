package com.sist.manager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardIOMain {
	
	public static void main(String[] args) {
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("/Users/seyeong/Desktop/Java/java_datas/board_.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			List<BoardVO> list = new ArrayList<BoardVO>();
			BoardVO vo=new BoardVO();
			vo.setNo(1);
			vo.setName("홍길동");
			vo.setSubject("파일 입출력을 이용한 게시판 만들기");
			vo.setContent("파일 입출력을 이용한 게시판 만들기");
			vo.setRegdate(new Date());
			vo.setPwd("1234");
			vo.setHit(0);
			list.add(vo);
			oos.writeObject(list);
			System.out.println("저장 완료");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				fos.close();
				
			}catch(Exception ex) {}
			
		}
	}
}

