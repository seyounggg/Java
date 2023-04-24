package com.sist.music;

import java.util.Scanner;

public class MusicSystem {
	Music[] music=new Music[50]; // <- 여기에는 null 값이 들어가 있음(배열을 생성한거지 객체를 생성한것은 아님/메모리가 할당된 것이 아님)
	// List<music>
	// 1. 메소드 이용해서 구현 처리(for, while 같은 반복문은 class 안에서 사용할 수 없기 때문에)
	void init() {
		/*
		 * 인스턴스 : 객체 생성(new)을 먼저 하고 -> 객체명.변수 또는 배열..
		 * static : 클래스명.배열명..
		 * 
		 * int[] arr=new int[10]
		 * for(int i=0;i<10;i++)
		 * {
		 *    arr[i]=(int)(Math,random()*100)+1
		 * }
		 */
		for(int i=0;i<MusicData.title.length;i++) //title이 static
		{
			//System.out.println("메모리 할당 전 : music["+i+"]"+music[i]);
			music[i]=new Music(); //Music크기의 메모리공간을 50개 생성
			//System.out.println("메모리 할당 후 : music["+i+"]"+music[i]);
			music[i].title=MusicData.title[i];
			music[i].singer=MusicData.singer[i];
			music[i].album=MusicData.album[i];
			music[i].state=MusicData.state[i];
			music[i].modify=MusicData.modify[i];
		}
	}
	
	int menu() {
		System.out.println("===========Menu=========");
		System.out.println("1.목록보기");
		System.out.println("2.검색하기");
		System.out.println("3.상세보기");
		System.out.println("9.프로그램 종료");
		System.out.println("========================");
		Scanner scan=new Scanner(System.in);
		System.out.print("메뉴 선택:");
		return scan.nextInt();
	}
	Music[] musicListData() {
		return music;
	}
	Music musicDetailData(int no) {
		return music[no-1];
	}
	Music[] musicFindData(String title) {
		int count=0;
		for (Music mm:music) {
			if(mm.title.contains(title)) {
				count++;
			}
		}
		Music[] m=new Music[count];
		int i=0;
		for(Music mm:music) {
			if(mm.title.contains(title)) {
				m[i]=mm;
				i++;
			}
		}
		//Music[] m=new Music[count]; // 배열 갯수를 고정시키기 어려울 경우에는 위에 for와 if를 사용하여 동적으로 만들어 주면됨
		return m;
	}
	/*public static void main(String[] args) {
		MusicSystem ms=new MusicSystem();
		ms.init();
		Scanner scan=new Scanner(System.in);
		System.out.print("검색어 입력:");
		String title=scan.next();
		Music[] data=ms.musicFindData(title);
		int i=1;
		for(Music m:data)
		{
			System.out.println(i+"."+m.title);
			i++;
		}
		System.out.println("===========================");
		System.out.print("상세보기(1~50):");
		int no=scan.nextInt();
		Music mm=ms.musicDetailData(no);
		System.out.println("곡명:"+mm.title);
		System.out.println("가수명:"+mm.singer);
		System.out.println("앨범명:"+mm.album);
		System.out.println("상태:"+mm.state);
		System.out.println("변동폭:"+mm.modify);
		
	}*/
	/*public static void main(String[] args) {
		MusicSystem ms=new MusicSystem();
		ms.init();
	}*/

}