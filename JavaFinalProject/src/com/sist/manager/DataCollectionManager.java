package com.sist.manager;
// 데이터 수집을 위한 임시 클래스
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;
/*
 * <table class="list-wrap">

   <tbody>
	<tr class="list rank-1" songid="101268096">
    <td class="check"><input type="checkbox" class="select-check" title=" I AM ">
   </td><td class="number">1
       <span class="rank"><span class="rank-none"><span class="hide">유지</span></span></span>
   </td>
    <td><a href="#" class="cover" onclick="fnViewAlbumLayer(83665559); return false;" ontouchend="fnViewAlbumLayer(83665559); return false;"><span class="mask"></span><img onerror="this.src='//image.genie.co.kr/imageg/web/common/blank_68.gif';" src="//image.genie.co.kr/Y/IMAGE/IMG_ALBUM/083/665/559/83665559_1681116738103_1_140x140.JPG/dims/resize/Q_80,0" alt="I AM"></a></td>
    <td class="link"><a href="#" class="btn-basic btn-info" onclick="fnViewSongInfo(101268096); return false;" ontouchend="fnViewSongInfo(101268096); return false;">곡 제목 정보 페이지</a></td>
      <td class="info">
           <a href="#" class="title ellipsis" title="I AM" onclick="fnPlaySong('101268096;','1'); return false;" ontouchend="fnPlaySong('101268096;','1'); return false;">
I AM</a>
            <a href="#" class="artist ellipsis" onclick="fnViewArtist(81271496); return false;" ontouchend="fnViewArtist(81271496); return false;">IVE (아이브)</a>           <div class="toggle-button-box" id="hide-button">
               <button type="button" class="btn artist-etc" onclick="fnRelationArtistList('101268096'); artist_etc_layer._show(this);return false;" ontouchend="fnRelationArtistList('101268096'); artist_etc_layer._show(this);return false;">외</button>
               <dl class="list" id="RelationArtist_101268096">
               </dl>
           </div>
            <i class="bar">|</i>
            <a href="#" class="albumtitle ellipsis" onclick="fnViewAlbumLayer(83665559); return false;" ontouchend="fnViewAlbumLayer(83665559); return false;">I've IVE</a>
        </td>
 */
public class DataCollectionManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<GenieMusicVO> list=
				new ArrayList<GenieMusicVO>();
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		
		try {
			fos=new FileOutputStream("/Users/seyeong/Desktop/Java/java_datas/genie_music.txt");
			oos=new ObjectOutputStream(fos);
			
			//사이트 연결
			String[] urls= {
					"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0100",
					"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0200",
					"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0300",
					"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0107",
					"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0500",
					"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0600"
			};
			int k=1; // 고유번호
			for(int i=0;i<urls.length;i++) {
				Document doc=Jsoup.connect(urls[i]).get();
				Elements title=doc.select("table.list-wrap td.info a.title");
				Elements singer=doc.select("table.list-wrap td.info a.artist");
				Elements album=doc.select("table.list-wrap td.info a.albumtitle");
				Elements poster=doc.select("table.list-wrap a.cover img");
				Elements etc=doc.select("table.list-wrap span.rank");
				
				/*
				 *   <a> 값 </a>  => text()
				 *   <img src="이미지 주소"> => attr()
				 * 
				 */
				for(int j=0;j<title.size();j++) {
					System.out.println("고유번호:"+k);
					System.out.println("카테고리번호:"+(i+1));
					System.out.println(title.get(j).text());
					System.out.println(singer.get(j).text());
					System.out.println(album.get(j).text());
					System.out.println(poster.get(j).attr("src"));
					String ss=etc.get(j).text();
					System.out.println(ss);
					String state="";
					String id=""; // 증폭
					if(ss.contains("유지")) {
						state="유지";
						id="0";
					}
					else if(ss.contains("new")) {
						state="NEW";
						id="0";
					}
					else {
						state=ss.replaceAll("[0-9]", ""); // 상승
						id=ss.replaceAll("[가-힣]", ""); // 
					}
					
					System.out.println("상태:"+state);
					System.out.println("등폭:"+id);
					System.out.println("동영상:"+youtubekeyData(title.get(j).text()));
					System.out.println("===========================");
					GenieMusicVO vo=new GenieMusicVO();
					vo.setNo(k);
					vo.setCno(i+1);
					vo.setTitle(title.get(j).text());
					vo.setSinger(singer.get(j).text());
					vo.setAlbum(album.get(j).text());
					vo.setPoster(poster.get(j).attr("src"));
					vo.setState(state);
					vo.setIdcreament(Integer.parseInt(id));
					vo.setKey(youtubekeyData(title.get(j).text()));
					list.add(vo);
					k++;
				}
			}
			
			oos.writeObject(list);
			System.out.println("저장 완료!!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				fos.close();
				oos.close();
			}catch(Exception ex) {}
		}
	}
	public static String youtubekeyData(String title) {
		String key="";
		try {
			String url="https://www.youtube.com/results?search_query="
		                +URLEncoder.encode(title, "UTF-8");
			Document doc=Jsoup.connect(url).get();
			String data=doc.toString();
			Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+"); //[^가-힣]+ => 한글을 제외한 나머지를 다 가져와라
			Matcher m=p.matcher(data);
			while(m.find()) {
				String s=m.group(); //값을 가져오는 것
				s=s.substring(s.indexOf("=")+1, s.indexOf("\""));
				key=s;
				break;
			}
		}catch(Exception ex) {}
		return key;
	}
}