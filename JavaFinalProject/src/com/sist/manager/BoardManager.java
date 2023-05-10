package com.sist.manager;
import java.util.*;

import com.sist.inter.BoardInterface;

import java.io.*;
public class BoardManager implements BoardInterface{
	// 관리자니까 게시물 전체를 가지고 있는다 => List => 접속한 모든 사람이 공유
	
	// 다른사람과 공유할 목적으로 static 
	private static List<BoardVO> list=
					new ArrayList<BoardVO>();
/*
 *   Collection
 *       |
 *   ----------
 *   |        |        |
 *  List     Set      Map
 *   |        |        |
 * ArrayLsit  HashSet  HashMap
 * 
 *   ✓ List : 순서가 존재(인덱스), 데이터 중복 허용
 *     - 게시판...
 *   ✓ Set : 순서가 없다, 데이터 중복을 허용하지 않는다
 *     - 회원가입...
 *   ✓ Map : 순서가 없다, 두개를 동시에 저장
 *     - key, value => key는 중복이 없다 , value는 중복이 가능
 *     - 데이터 송수신 => 웹에서 지원하는 대부분의 클래스가 Map형식이다
 */
	static {
		// 초기화
		/*
		 *   멤버변수에 대한 초기화
		 *     - 인스턴스번수 : new를 이용하여 메모리에 저장(따로 저장된다)
		 *                (heap공간에 저장)
		 *     - 정적변수(static) : 컴파일시에 자동 저장
		 *   1) 명시적 초기화
		 *   2) 생성자
		 *   3) 초기화블럭
		 *      - 인스턴스 변수를 초기화
		 *        {
		 *        }
		 *      - static 변수를 초기화
		 *        static {
		 *        }
		 *   ✓ 명시적초기화 = static{} = {} = 생성자
		 *   ✓ 명시적초기화는 선언과 동시에 값을 부여
		 *     -------- 구현이 필요한 경우에는 사용할 수 없다
		 *     #구현? 파일 읽기, 데이터 읽기, 메소드를 호출...
		 *          -> 클래스 영역에서는 구현이 불가능하다
		 */
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("/Users/seyeong/Desktop/Java/java_datas/board.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
		// -> 객체단위로 데이터를 읽어온다
			list=(List<BoardVO>)ois.readObject();
			ois.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				fis.close();
			}catch(Exception ex) {}
		}
	}
	// 기능 설정
	// 1. 목록 출력
	@Override
	public List<BoardVO> boardListData(int page) {
		List<BoardVO> bList=new ArrayList<BoardVO>();
		int j=0;
		int rowSize=10; // 한페이지 10개씩
		int start=(page-1)*rowSize; // 인덱스 시작점부터 10개씩 가져온다
		for(int i=0;i<list.size();i++) {
			if(j<10 && i>=start) {
				bList.add(list.get(i));
				j++;
			}
		}
		return bList;
	}
	// 1-1. 총페이지
	public int boardTotalPage() {
		return (int)(Math.ceil(list.size()/10.0));
	}
	// 3. 상세보기
	@Override
	public BoardVO boardDetailData(int no) {
		BoardVO vo=new BoardVO();
		// 조회수 증가
		for(BoardVO bvo:list) {
			if(no==bvo.getNo()) {
				bvo.setHit(bvo.getHit()+1); // 조회수 증가
			}
		}
		for(BoardVO bvo:list) {
			if(no==bvo.getNo())
				vo=bvo;
		}
		return vo;
	}
	// 2. 글쓰기
	@Override
	public void boardInsert(BoardVO vo) {
		int no=noIncrement();
		vo.setNo(no);
		vo.setRegdate(new Date());
		list.add(vo);
		try {
			FileOutputStream fos=
					new FileOutputStream("/Users/seyeong/Desktop/Java/java_datas/board.txt");
			ObjectOutputStream oos=
					new ObjectOutputStream(fos);
			oos.writeObject(list);
			fos.close();
			oos.close();
		}catch(Exception ex) {}
	}
	// 4, 수정할 데이터 읽기
	@Override
	public BoardVO boardUpdateData(int no) {
		BoardVO vo=new BoardVO();
		for(BoardVO bvo:list) {
			if(bvo.getNo()==no)
				vo=bvo;
		}
		return vo;
	}
	// 4, 실제 수정
	@Override
	public String boardUpdate(BoardVO vo) {
		
		return null;
	}
	// 5. 삭제
	@Override
	public String boardDelete(int no, String pwd) {
		
		return null;
	}
	// 6. 자동증가번호
	// CREATE SQUENCE no_seq START WITH 1 INCREMENT BY 1
	// => 오라클
	// AUTO_INCREMENT
	// => MySQL
	@Override
	public int noIncrement() {
		int max=0;
		for(BoardVO vo:list) {
			if(vo.getNo()>max)
				max=vo.getNo();
		}
		return max+1;
	}
}
