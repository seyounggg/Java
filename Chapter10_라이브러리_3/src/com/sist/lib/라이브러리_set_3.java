package com.sist.lib;
import java.util.*;

import javax.lang.model.element.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/*
 * <div class="wrap_song_info">
   <div class="ellipsis rank01"><span>
   <a href="javascript:melon.play.playSong('1000002721',36356993);" title="I AM 재생">I AM</a>
   </span></div><br>
 */
public class 라이브러리_set_3 {
	public static Set genieMusic() {
		Set set=new HashSet();
		try {
			for(int i=1;i<=2;i++) { // genieMusic은 1~50위까지 1페이지, 51~100 2페이지라서 2번 반복
				Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20230428&hh=11&rtm=Y&pg="+i).get();
				Elements title=doc.select("table.list-wrap a.title");
				for(int j=0;j<title.size();j++) {
					//System.out.println(title.get(j).text());
					set.add(title.get(j).text());
				}
			}
		} catch (Exception ex) {}
		return set;
	}
	public static Set melonMusic() {
		Set set=new HashSet();
		try {
			Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements title=doc.select("div.wrap_song_info div.rank01 a");
			// System.out.println(title);
			for(int i=0;i<title.size();i++) {
				//System.out.println(title.get(i).text()); // 제목을 가져올때
				set.add(title.get(i).text()); // set에 title추가
			}
		} catch (Exception ex) {}
		return set;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 지니뮤직 읽기
		Set genie=genieMusic();
		System.out.println(genie);
		// 멜론 읽기
		Set melon=melonMusic();
		System.out.println(melon);
		
		// 지니뮤직에만 있는 노래 찾기
		//genie.removeAll(melon); // 차집합
		// removeAll -> [1,2,3,4,5]-[1,2,3,6,7] => 4,5남음
		//System.out.println(genie);
		/*for(Object obj:genie) {
			System.out.println(obj.toString());
		}*/
		melon.retainAll(genie); // 교집합
		System.out.println("멜론과 지니뮤직의 동일한 곡 갯수:"+melon.size());
		for(Object obj:melon) {
			System.out.println(obj.toString());
			
		}
	}

}
