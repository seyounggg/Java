package com.sist.util;
// Date => Calendar
import java.util.*;
public class 라이브러리_Calendar_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력:");
		int year=scan.nextInt();
		System.out.print("월 입력:");
		int month=scan.nextInt();
		System.out.print("일 입력:");
		int day=scan.nextInt();
		
		Calendar cal=Calendar.getInstance(); // 오늘날짜 가져옴
		cal.set(Calendar.YEAR, year); // 날짜를 바꾸려고 함. set이용!!!
		cal.set(Calendar.MONTH , month-1); // 0부터 시작하므로 -1을 해야함 
		cal.set(Calendar.DATE , day);
		
		System.out.println("===== 설정된 날짜 =====");
		System.out.println("년도:"+cal.get(Calendar.YEAR));
		System.out.println("월:"+(cal.get(Calendar.MONTH)+1)); // 0부터 출력하므로 +1을 해야함
		System.out.println("일:"+cal.get(Calendar.DATE));
		
		String[] week= {"","일","월","화","수","목","금","토"};
		System.out.println("요일:"+week[cal.get(Calendar.DAY_OF_WEEK)]);
		//이건 week배열 0번에 공백을 넣어뒀으므로 1~7까지로 읽어 올 수 있음
		//만약, 0번째에 ""설정하지 않을 경우에는 week[cal.get(Calendar.DAY_OF_WEEK)-1]로 코딩해야함
		
	}

}
