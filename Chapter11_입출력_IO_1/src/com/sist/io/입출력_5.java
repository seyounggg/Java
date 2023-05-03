package com.sist.io;
import java.io.*;
import java.net.*;

/*
 * # 25줄 형변환 설명
 *       URLConnection => url.openConnection()
 *            |
 *    -------------------
 *    |                 |
 *   HttpURLConnection  HttpsURLConnection
 *   
 *   -------- 아래와 같다 -----------------------
 *   class A
 *   class B extends A
 *   B b=(B)new A(); 
 *   
 *   
 */
public class 입출력_5 {

	public static void main(String[] args) throws Exception {
		URL url=new URL("https://www.10000recipe.com/recipe/list.html");
		HttpURLConnection conn=
				(HttpURLConnection)url.openConnection(); // 형변환(상속관계여서)
		
		// 연결이 되었다면
		if(conn!=null) {
			// 브라우저 => 1byte씩 전송
			// 1byte => 2byte로 변환해야함 ===> InputStreamReader
			BufferedReader in=
					new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			//                             ------------------                      ---------
			//                             => 한글이 깨지지 않음                      유니코드로 읽어오겠다
			while(true) {
				String data=in.readLine();
				if(data==null) break;
				System.out.println(data);
			}
			in.close();
			conn.disconnect();
			//
		}
	}

}
