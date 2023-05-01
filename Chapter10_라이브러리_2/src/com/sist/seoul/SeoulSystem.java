package com.sist.seoul;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SeoulSystem {
	private static ArrayList list=new ArrayList();
	static {
		try {
			FileReader fr=new FileReader("/Users/seyoung/Downloads/데이터모음/seoul_location.txt");
			StringBuffer sb=new StringBuffer();
			int i=0;
			while((i=fr.read())!=-1) { 
			// .read()는 파일에서 문자를 하나씩 읽어들어온 다음에 그 문자를 반환
			// EOF(End Of File : 파일의 끝을 나타냄, -1은 파일에서 데이터를 더이상 읽어들일 수 없는 위치를 의미)
				sb.append((char)i);
			}
			fr.close();
			
			String[] locations=sb.toString().split("\n");
			for(String s:locations) {
				StringTokenizer st=new StringTokenizer(s,"|");
				SeoulVO vo=new SeoulVO();
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setName(st.nextToken());
				vo.setContent(st.nextToken());
				vo.setAddress(st.nextToken());
			}
		}catch(Exception ex) {}
				
	}

	// 1. 목록보기
	public ArrayList seoulListData(int page) {
		int totalpage=(int)(Math.ceil(list.size()/10.0));
		int start=(page-1)*10;
		int end=page*10;
		if(page==totalpage) {
			end=(page*10)-(10-list.size()%10);
		}
		ArrayList seoulList=new ArrayList(list.subList(start, end));
		return seoulList;
	}
	
	// 상세보기
	public SeoulVO seoulDetailData(int no) {
		return (SeoulVO)list.get(no-1);
	}
	
	// 메뉴
	public int seoulMenu() {
		System.out.println("======= 서울명소 ========");
		System.out.println("1.목록보기");
		System.out.println("2.상세보기");
		System.out.println("9.종료하기");
		System.out.println("========================");
		Scanner scan=new Scanner(System.in);
		System.out.print("메뉴선택:");
		return scan.nextInt();
	}
	
	// 조립
	public void process() {
		while(true) {
			int menu=seoulMenu();
			if(menu==9) {
				System.out.println("PROGRAM EXIT");
				break;
			}
			else if(menu==1) {
				Scanner sc=new Scanner(System.in);
			System.out.print("페이지 입력(1~28):");
				int page=sc.nextInt();
				ArrayList sList=seoulListData(page);
				for(int i=0;i<sList.size();i++) {
					SeoulVO vo=(SeoulVO)sList.get(i);
					System.out.println(vo.getNo()+"."+
							vo.getName());
				}
 			}
			else if(menu==2) {
				Scanner sc=new Scanner(System.in);
				System.out.println("상세페이지 입력:");
				int no=sc.nextInt();
				SeoulVO vo=seoulDetailData(no);
				System.out.println("===== 상세보기 =====");
				System.out.println("번호:"+vo.getNo());
				System.out.println("명소명:"+vo.getName());
				System.out.println("내용:"+vo.getContent());
				System.out.println("주소:"+vo.getAddress());
			}
		}
	}
	
}
