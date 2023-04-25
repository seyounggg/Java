package com.sist.main3;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GenieMusicSystem {
	protected Music[] musics=new Music[50]; // 모든 사람에게 공유
	protected String title="지니뮤직 Top50";
	// 1. 초기화
	/*
	 * 1) 인스턴스 블록
	 * 2) static 블록
	 * -------------- 자동 호출
	 * 3) 생성자 ----> 직접 호출
	 * 
	 * ** 예외처리 **
	 *   에러의 경우)
	 *      사용자가 잘못 입력 했을 때
	 *      프로그래머의 실수
	 *      
	 *   - 에러 : 소스상에서 처리할 수 없는 심각한 에러
	 *           => 메모리 공간 부족
	 *   - 예외 : 수정이 가능한 (가벼운)에러
	 *         => 예외복구/예외회피
	 *     목적) 비정상 종료를 방지하고, 정상 수행이 가능하도록...
	 *         => io,net,thread,web
	 *         io => 파일 경로명, 파일명
	 *         net => IP/URL
	 *         tread => 충돌
	 *         web => 404, 500, 403...
	 */
	{
		try {
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			//Document : 문서저장공간 => HTML
			// web에서 데이터를 가져올때 에러가 생길까봐 예외처리를 해주는거임(try~catch)
			//System.out.println(doc.toString());
			/*
			 * HTML => tag <> => Markup language
			 * <a>값</a>
			 * Element => tag
			 * Elements => 같은 태그 여러개를 모아준것
			 */
			// 노래명
			// 구분자 => 모든 태그 class(중복)/ id(중복이 없다)
			// class => .   id=> #
			Elements title=doc.select("table.list-wrap td.info a.title");
			System.out.println(title);
			// 가수명
			Elements singer=doc.select("table.list-wrap td.info a.artist");
			System.out.println(singer);
			// 앨범명
			Elements album=doc.select("table.list-wrap td.info a.albumtitle");
			System.out.println(album);
			// 상태
			Elements etc=doc.select("table.list-wrap td.number span");
			System.out.println(etc);
			
			for(int i=0;i<title.size();i++) { //size=저장된 갯수
				/*System.out.println("순위:"+(i+1));
				System.out.println("노래명:"+title.get(i).text());
				System.out.println("가수명:"+singer.get(i).text());
				System.out.println("앨범명:"+album.get(i).text());*/
				String s=etc.get(i).text();
				String state="";
				String value="";
				if(s.equals("유지")) {
					state="유지";
					value="0";
				}
				// 2상승
				else {
					state=s.replaceAll("[0-9]", ""); // 2상승이면 state에 숫자를 공백으로 바꿔라 -> "상승"만 남음
					value=s.replaceAll("[가-힣]", ""); // 2상승이면 value에 한글을 공백으로 바꿔라 -> "2"만 남음
					/*
					 * split
					 * replaceAll
					 * ---------- 정규식(한글형태, 숫자형태 => 패턴)
					 * [0-9] => 숫자전체
					 * [가-힣] => 한글 전체
					 * [A-Za-z] => 알파벳 전체
					 */
				}
				/*System.out.println("상태:"+state);
				System.out.println("등폭:"+value);
				System.out.println("==========================");*/
				
				musics[i]=new Music();
				musics[i].setRank(i+1);
				musics[i].setTitle(title.get(i).text());
				musics[i].setSinger(singer.get(i).text());
				musics[i].setAlbum(album.get(i).text());
				musics[i].setState(state);
				musics[i].setIdcrement(value);
			}
		}catch(Exception ex) {}
		
	}
	// 2.기능(어떤 기능) ==> 메소드
	public Music[] musicAllData() {
		return musics;
	}
	// 2-1. 목록 출력  => type=1 => title, type=2 => singer,type=3 => album... 
	public Music[] musicFind(String fd, int type) {
		int i=0;
		for(Music m:musics) {
			boolean bCheck=false;
			if(type==1) {
				bCheck=m.getTitle().contains(fd);
				if(bCheck==true)
				i++;
			}
			else {
				bCheck=m.getSinger().contains(fd);
				if(bCheck==true)
				i++;
			}
			
		}// 검색한 결과 갯수
		System.out.println(i);
		
//		if(i==0) { // 검색 결과가 없는 경우
//			return new Music[0]; // 길이가 0인 배열 반환
//		}
		
		Music[] mm=new Music[i];
		i=0;
		/*
		 * A a=new A();
		 * A b=a;
		 */
		for(Music m:musics) {
			boolean bCheck=false;
			if(type==1) {
				bCheck=m.getTitle().contains(fd);
			
			}
			else {
				bCheck=m.getSinger().contains(fd);
			
			}
			if(bCheck==true) {
				mm[i]=m;
				i++;
			}
		}
		return mm;
		
	}
	/*
	 * 결과값을 전송 : 리턴형 (O) // 웹은 결과값을 전송하는 경우가 많으므로 리턴형 공부 많이 해야된다
	 * 자체 출력 : void 
	 */
	// 2-2. 검색
	public static void main(String[] args) {
		GenieMusicSystem g=new GenieMusicSystem();
		Music[] aa=g.musicFind("사",1);
		for(Music a:aa) {
			System.out.println(a.getTitle());
		}
	}
}

