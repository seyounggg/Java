package com.sist.io_2;
import java.util.*;
import java.io.*;
public class StudentSystem {
	// 모든 학생을 읽어서 메모리에 저장
	private static List<Student> stdList=new ArrayList<Student>();
	
	// 파일을 읽어서 메모리에 저장
	static {
		FileReader fr=null;// file 닫기 위해서 먼저 try절 밖에서 선언을 먼저 해야함
		try {
			fr=new FileReader("/Users/seyeong/Desktop/Java/java_datas/school.txt");
			StringBuffer sb=new StringBuffer();
			int i=0; //문자를 받기 위한 int변수
			while((i=fr.read())!=-1) {
				sb.append((char)i);
			}
			
			// 홍길동|90|90|90|270|90.00\r\n
			// 모아두고 자르는게 편해서 split을 먼저 사용하고, StringTokenizer로 분리
			String[] stds=sb.toString().split("\n"); // 한줄씩 저장
			for(String ss:stds) {
				StringTokenizer st=new StringTokenizer(ss,"|");
				// 학생 데이터별
				Student s=new Student();
				s.setHakbun(Integer.parseInt(st.nextToken()));
				//st.nextToken()의 리턴값이 String이어서 Integer로 형변환!
				s.setName(st.nextToken());
				s.setKor(Integer.parseInt(st.nextToken()));
				s.setEng(Integer.parseInt(st.nextToken()));
				s.setMath(Integer.parseInt(st.nextToken()));
				int total=s.getKor()+s.getEng()+s.getKor();
				s.setTotal(total);
				s.setAvg(total/3.0);
				stdList.add(s);
			}
		}catch(Exception ex) {
			ex.printStackTrace(); // 에러 위치 확인하기 위함
		}
		finally {
			try {
				fr.close();
			}catch(Exception ex) {}
		}
	}
	public int menu() {
		System.out.println("========== 메뉴 ==========");	
		System.out.println("1. 학생 목록");
		System.out.println("2. 학생 등록");
		System.out.println("3. 학생 수정");
		System.out.println("4. 학생 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.println("=========================");
		int no=0;
		try {
			BufferedReader in=
					new BufferedReader(new InputStreamReader(System.in));
			//키보드 읽기 => 예외처리 => Scanner 대체
			System.out.print("메뉴번호 입력:");
			String str=in.readLine(); // 입력한 값 가져오기
			no=Integer.parseInt(str);
		}catch(Exception ex) {}
		return no;
	}
	public void process() {
		while(true) {
			int no=menu();
			if(no==5) {
				System.out.println("프로그램 종료");
				FileWriter fw=null; //한글 저장시
				// FileOutputStream => FileWriter 가 더 편리
				try {
					
					// 자바프로그램과 파일 연결 => 스트림(출력 스트림)
					// 2byte씩 전송한다 (문자 스트림) => 한글은 2byte!
					// 알파벳, 숫자는 1byte, 2byte 상관없이 가능
					fw=new FileWriter("/Users/seyeong/Desktop/Java/java_datas/school.txt");
					String temp="";
					for(Student ss:stdList) {
						temp+=ss.getHakbun()+"|"+ss.getName()+"|"
						      +ss.getKor()+"|"+ss.getEng()+"|"
						      +ss.getMath()+"\n";
					}
					fw.write(temp);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				finally { //finally는 try-catch 소속이 아니다
					try {
						fw.close();
					}catch(Exception ex) {}
				}
				break;
			}
			else if(no==1) {
				for(Student ss:stdList) {
					int total=ss.getKor()+ss.getEng()+ss.getKor();
					ss.setTotal(total);
					ss.setAvg(total/3.0);
					System.out.println(
					ss.getHakbun()+" "
					+ss.getName()+" "
					+ss.getKor()+" "
					+ss.getEng()+" "
					+ss.getMath()+" "
					+ss.getTotal()+" "
					+String.format("%.2f", ss.getAvg()) // 출력형식 변경
					);
				}
			}
			else if(no==2) {
				try {
					BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
				System.out.print("이름 입력:");
				String name=in.readLine();
				System.out.print("국어 점수 입력:");
				String kor=in.readLine();
				System.out.print("영어 점수 입력:");
				String eng=in.readLine();
				System.out.print("수학 점수 입력:");
				String math=in.readLine();
				
				// 시퀀스 => 자동 증가 번호 만들기 => 구분자
				// 구분자..이름이 같은 학생이 있을 수 있어서 학점으로 구분을 함!
				int max=0;
				for(Student ss:stdList) {
					if(ss.getHakbun()>max)
						max=ss.getHakbun();
				}
				
				Student s=new Student();
				s.setName(name);
				s.setHakbun(max+1);
				s.setKor(Integer.parseInt(kor));
				s.setEng(Integer.parseInt(eng));
				s.setMath(Integer.parseInt(math));
				stdList.add(s);
				}catch(Exception ex) {}
			}
			else if(no==4) {
				try {
					BufferedReader in=
							new BufferedReader(new InputStreamReader(System.in));
					System.out.print("학번 입력:");
					int i=0;
					String hak=in.readLine();
					for(Student ss:stdList) {
						if(ss.getHakbun()==Integer.parseInt(hak)) {
							stdList.remove(i);
							break;
						}
						i++;
					}
				}catch(Exception ex) {}
			}
		}
	}
}
