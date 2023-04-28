package com.sist.lang;
// delete, insert => 자체변경되므로 원본이 변경됨
// substring => 원본변겨이 없음(새로운 메모리에 저장하므로)
public class 라이브러리_StringBuffer_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("홍길동입니다");
		sb.delete(3, 6); // delete(int s, int e) => e는 e-1이므로 e값에 들어갈 번호에 +1을 해야한다
		System.out.println(sb.toString());
		sb.insert(3, "입니다");
		System.out.println(sb.toString());
		//delete , insert 는 자체변경이 가능해서 새로운 메모리에 저장할 필요가 없다
		
		String s=sb.substring(3);
		//단독으로 sb.subString(3)을 하면 sb값이 변경이 되지 않아서 => 'String s=' 을 사용하여 새로운 메모리에 저장을 해야한다
		System.out.println(s.toString());
		System.out.println(sb.substring(3));
	}

}
