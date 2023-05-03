package com.sist.io3;
import java.io.*;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.List;
public class MovieSystem {
	//데이터 읽기
	private static List<MovieVO> list=
			new ArrayList<MovieVO>();
	
	static {
		
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		
		try {
			
			fis=new FileInputStream("/Users/seyeong/Desktop/Java/java_datas/movie.txt");
			ois=new ObjectInputStream(fis);
			list=(List<MovieVO>)ois.readObject();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				fis.close();
				ois.close();
			}catch(Exception ex) {}
		}
	}
	public void movieCategoryData(int cno) {
		for(MovieVO vo:list) {
			System.out.println(vo.getNo()+"."+vo.getTitle());
			}
		}
	}
