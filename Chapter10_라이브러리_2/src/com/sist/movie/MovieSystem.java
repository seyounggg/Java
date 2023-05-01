package com.sist.movie;
import java.util.*;
import java.io.*;
public class MovieSystem {
	private static ArrayList list=new ArrayList();
	//데이터 모음은 모두 static -> 모든사람들과 같은 데이터를 공유해야하니까~!
	static {
		try {
			//파일읽기
			FileReader fr=new FileReader("/Users/seyoung/Downloads/데이터모음/movie.txt");
			int i=0; // 한글자 읽기 => 'A' => 65 (i가 int니까)
			StringBuffer sb=new StringBuffer(); // 데이터가 많은데 한번에 결합해야할떄 Buffer
			while((i=fr.read())!=-1) { //-1 EOF
				sb.append((char)i);
			}
			fr.close(); // 파일은 열면 항상 닫아야 한다
			//System.out.println(sb.toString());
			String[] movies=sb.toString().split("\n"); // 한줄이 영화 하나라서 한줄씩 저장
			for(String m:movies) {
				StringTokenizer st=new StringTokenizer(m,"|");
				MovieVO vo=new MovieVO();
				/*
				 *  1 => st.nextToken()
				 * |쇼생크 탈출 => st.nextToken() ... > 다음 문자 가져오는거 
				 * |드라마
				 * |https://movie-phinf.pstatic.net/20160119_278/14531650465287bcuk_JPEG/movie_image.jpg?type=m77_110_2
				 * |팀 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)
				 * |2016 .02.24 재개봉, 1995 .01.28 개봉
				 * |15세 관람가
				 * |프랭크 다라본트
				 */
				vo.setNo(Integer.parseInt(st.nextToken())); // Integer.parseInt() <- 문자열을 정수형으로 바꿔서 가져오는거 
				// no는 정수인데 문자열로 되어있으니까!
				vo.setTitle(st.nextToken());
				vo.setGenre(st.nextToken());
				vo.setPoster(st.nextToken());
				vo.setActor(st.nextToken());
				vo.setRegdate(st.nextToken());
				vo.setGrade(st.nextToken());
				vo.setDirector(st.nextToken());
				list.add(vo);
				// 값을 다 채워서 저장
			}
		} catch (Exception e) {}
	}
//	public static void main(String[] args) {
//		MovieSystem ms=new MovieSystem();
//	}
	// menu
	public int movieMenu() {
		System.out.println("==========영화메뉴==========");
		System.out.println("1.목록출력");
		System.out.println("2.상세보기");
		System.out.println("3.영화검색");
		System.out.println("9.시스템 종료");
		System.out.println("==========================");
		Scanner scan=new Scanner(System.in);
		System.out.print("메뉴 선택 : ");
		return scan.nextInt();
	}
	// 목록출력(페이지가 나눠진다)
	public ArrayList movieListData(int page) {
		int totalpage=(int)(Math.ceil(list.size()/10.0));
		//size() => 1938 ... 1938/10.0 => 193.8 = ceil(올림) => 194page
		int start=(page-1)*10;
		// 10개씩 나눠놨으니까 0,10,20,...
		int end=page*10;
		//subList(s,e-1) 이니까 0~10, 10~20, 20~30...
		if(page==totalpage) {
			//194page => (194*10)-(10-8) ==> 1938
			end=(page*10)-(10-list.size()%10);
		}
		ArrayList movieList=new ArrayList(list.subList(start, end));
		return movieList;
	}
	// 상세보기
	public MovieVO movieDetailData(int no) {
		return (MovieVO)list.get(no-1);
		// MovieVO에 있는 데이터를 가져오고 싶으니까, MovieVO로 형변환을 하는거임 / 기본은 Object
		// 영화는 1번부터 시작이고, 인덱스 번호는 0번부터 시작하니까 no-1을 하는거임
	}
	// 영화 검색
	// 조립
	public void process(){
		while(true) {
			int menu=movieMenu();
			if(menu==9) {
				System.out.println("프로그램 종료");
				break;
			}
			else if(menu==1) {
				Scanner scan=new Scanner(System.in);
				System.out.print("페이지 입력:");
				int page=scan.nextInt();
				ArrayList mList=movieListData(page);
				for(int i=0;i<mList.size();i++) {
					MovieVO vo=(MovieVO)mList.get(i);
					System.out.println(vo.getNo()+"."
							+vo.getTitle());
				}
			}
			else if(menu==2) {
				Scanner scan=new Scanner(System.in);
				System.out.print("궁금한 영화번호 입력(1~1938):");
				int no=scan.nextInt();
				MovieVO vo=movieDetailData(no);
				System.out.println("======= 상세보기 =======");
				System.out.println("순위:"+vo.getNo());
				System.out.println("영화명:"+vo.getTitle());
				System.out.println("감독:"+vo.getDirector());
				System.out.println("출연:"+vo.getActor());
				System.out.println("장르:"+vo.getGenre());
				System.out.println("개봉일:"+vo.getRegdate());
			}
		}
	}
}