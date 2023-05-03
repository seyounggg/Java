package com.sist.io3;

import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;
public class DataCollectionManager {
	public static void main(String[] args) {
		List<MovieVO> list=new ArrayList<MovieVO>();
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try {
			String[] urls= {
					"https://movie.daum.net/main",
					"https://movie.daum.net/ranking/reservation",
					"https://movie.daum.net/premovie/theater",
			};
			int k=0;
			for(int i=0;i<urls.length;i++) {
				Document doc=Jsoup.connect(urls[i]).get();
				Elements title=doc.select("");
				Elements poster=doc.select("");
				Elements score=doc.select("");
				Elements reservate=doc.select("");
				Elements open=doc.select("");
				
				for(int j=0;j<title.size();j++) {
					System.out.println("고유번호:"+k);
					System.out.println("카테고리번호:"+(i+1));
					
					System.out.println(title.get(j).text());
					System.out.println(score.get(j).text());
					System.out.println(reservate.get(j).text());
					System.out.println(open.get(j).text());
					System.out.println(poster.get(j).attr("src"));
					System.out.println("==============================");
					MovieVO vo=new MovieVO();
					vo.setNo(k);
					vo.setCno(i+1);
					vo.setTitle(title.get(j).text());
					vo.setReservate(reservate.get(j).text());
					vo.setOpen(open.get(j).text());
					vo.setScore(score.get(j).text());
					vo.setPoster(poster.get(j).attr("src"));
					k++;
				}
			}
			oos.writeObject(list);
			System.out.println("저장완료!!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				fos.close();
				oos.close();
			}catch(Exception ex) {}
		}
	}
}
