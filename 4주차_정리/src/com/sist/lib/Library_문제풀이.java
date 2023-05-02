package com.sist.lib;

public class Library_문제풀이{
/*
 * 라이브러리 문제.ppt / 6번 설명
 */
	public static void main(String[] args) {
//		try {
//			for(int i=1;i<=3;i++) {
//				if(i==2) { // 종료
//					System.out.println(i/0);
//				}
//				System.out.println("i="+i);
//			}
//		}catch(Exception e) {
//			System.out.println("예외 발생");
//		}
		// 크롤링 => try를 for문 블럭 안에 배치
		for(int i=1;i<=3;i++) {
			try {
				if(i==2) { // 제외 
					System.out.println(i/0);
				}
				System.out.println("i="+i);
			}catch(Exception e) {
				System.out.println("예외발생");
			}
		}
//    	String[] strArray = { "10" , "2a" };
//        int value = 0; 
//        for(int i = 0; i <= 2; i++ ){
//        	try{
//            	value = Integer.parseInt(strArray[i]); //value=10
//            } catch(ArrayIndexOutOfBoundsException e){
//            	System.out.println("인덱스를 초과했음");
//            } catch(NumberFormatException e) {
//            	System.out.println("숫자로 변환할 수 없음");
//            } finally {
//            	System.out.println(value);
//            }
//        }
/*  // for문에서 오류가 나면 catch로 나감
 *  try {
 *  	for(int i=0;i<=2;i++){
 *  		i=0 : 정상수행
 *  		i=1 : 에러발생 ==> 종료 ==> for
 *  	}
 *  }catch(Exception e) {
 *  	수행
 *  }
 *  // for문을 끝까지 돌려야 하면 예외처리가 for{}블럭 안으로
 *  for(int i=0;i<=2;i++){ 
 *  	try{
 *  	i=0 : 정상수행
 *  	i=1 : 에러발생
 *      }catch(Exception e) {
 *      => i의 증가값으로 이동
 *      }
 *  }
 */
	}
}
