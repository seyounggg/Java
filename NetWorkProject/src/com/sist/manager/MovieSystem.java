package com.sist.manager;

import java.io.*;
import java.util.*;

public class MovieSystem {

	// 데이터 읽기
	private static List<MovieVO> list = new ArrayList<MovieVO>();

	// 초기화 블럭
	static {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("/Users/seyeong/Desktop/Java/java_datas/movie.txt");
			ois = new ObjectInputStream(fis);

			list = (List<MovieVO>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				ois.close();
			} catch (Exception e) {}
		}
	}
	public List<MovieVO> movieListData(int page){
		List<MovieVO> gList=
				new ArrayList<MovieVO>();
		int j=0; //20개씩 나눠주는 변수
		int rowSize=12;
		int start=(page-1)*rowSize;
		/*
		 *   1page => 0~19
		 *   2page => 20~39
		 */
		for(int i=0;i<list.size();i++) {
			if(j<rowSize && i>=start) {
				gList.add(list.get(i));
				j++;
			}
		}
		return gList;
	}
	public int movieTotalPage() {
		return (int)(Math.ceil(list.size()/12.0));
	}
	public List<MovieVO> movieCategoryData(int cno) {
		List<MovieVO> mlist=
				new ArrayList<MovieVO>();
		for (MovieVO vo : list) {
			if (vo.getCno() == cno) {
				mlist.add(vo);
			}
		}
		return mlist;
	}
	public List<MovieVO> movieFindData(String title){
		List<MovieVO> mlist=
				new ArrayList<MovieVO>();
		for(MovieVO vo:list) {
			if(vo.getTitle().contains(title)) {
				mlist.add(vo);
			}
		}
		return mlist;
	}
	public MovieVO movieDetailData(String title) { // 상세보기
		MovieVO vo=new MovieVO();
		for(MovieVO gvo:list) {
			if(gvo.getTitle().equals(title)) {
				vo=gvo;
				break;
			}
		}
		return vo;
	}
	public static void main(String[] args) {
		MovieSystem ms = new MovieSystem();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("예매순위(1) 박스오피스(2) OTT(3) : ");
			String cno = in.readLine();
			ms.movieCategoryData(Integer.parseInt(cno));
		} catch (Exception e) {}
	}
}