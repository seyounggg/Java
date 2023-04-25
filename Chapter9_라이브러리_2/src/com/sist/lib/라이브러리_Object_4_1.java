package com.sist.lib;

class Card {
	private int number;
	private String type;
	public Card() {
		number=7;
		type="하트";
	}
	public void print() {
		System.out.println("번호:"+number+",Type:"+type);
	}
}
public class 라이브러리_Object_4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card c1=new Card();
		c1.print();
		System.out.println("==========");
		
		try {
			Class clsName=Class.forName("com.sist.lib.Card");
			Object obj=clsName.getDeclaredConstructor().newInstance();
			//객체생성
			((Card)obj).print();
			//(Card).obj.print(); <- .이 우선순위이므로 obj에 있는 print를 먼저 찾게 되므로 ((Card)obj) 괄호를 하나 더 쳐줘야 한다
		}catch(Exception ex) {}
	}

}
