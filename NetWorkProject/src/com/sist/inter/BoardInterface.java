package com.sist.inter;
import java.util.*;
import com.sist.manager.*;
public interface BoardInterface {
	// 1. 목록 출력
	public List<BoardVO> boardListData(int page);
	// 2. 상세 보기
	public BoardVO boardDetailData(int no);
	// 3. 글쓰기
	public void boardInsert(BoardVO vo);
	// 4. 수정 하기
	public BoardVO boardUpdateData(int no);
	// 5. 실제 수정
	public String boardUpdate(BoardVO vo); // 비밀번호 확인(비밀번호가 맞으면 수정, 아님 안돼)
	// 6. 삭제
	public String boardDelete(int no, String pwd); // 비밀번호 확인(비밀번호가 맞으면 삭제, 아님 안돼)
	// 7. 자동 증가번호
	public int noIncrement(); // 번호 중복 없이 만들기위해 자동으로 증가하게!!
	
	// 댓글, 답변...
}