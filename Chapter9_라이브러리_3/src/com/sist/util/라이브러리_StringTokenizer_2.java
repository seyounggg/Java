package com.sist.util;

import java.util.StringTokenizer;

//네트워크
/*
 *  String s="red|green|blue|black|yellow";
 *  => split , StringTokenizer 두가지 방식을 사용할 수 있음
 *  
 *  -> StringTokenizer st=new StringTokenizer(s,"|");
 *  -> String[] colors=s.split("\\")
 *                     => 원형 : split(String regex)
 *                     = split은 정규식이므로 | 만 사용할 수는 없고 \\ 이렇게 작성해야한다
 *   
 *   StringTokenizer st=new StringTokenizer(s,"|");
 *   
 *   hasMoreToken
 *   1) cursor
 *   --------------------------------
 * -> before First
 *   --------------------------------
 *   red => nextToken()
 *   --------------------------------
 *   green => nextToken()
 *   --------------------------------
 *   blue => nextToken()
 *   --------------------------------
 *   black => nextToken()
 *   --------------------------------
 *   yellow => nextToken()
 *   --------------------------------
 *   after Last => nextToken() => false(읽기종료)
 *   --------------------------------
 */
public class 라이브러리_StringTokenizer_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="red|green";
		StringTokenizer st=new StringTokenizer(s,"|");
		/*
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		*/
		
		//갯수를 모를 경우에는 while문+hasMoreTokens() 를 사용하는 것을 권장한다
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
