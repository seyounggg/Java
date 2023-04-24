/*
 *   1. 같은 자바파일에 클래스를 여러개 만들 수 있다.
 *      ---------
 *      public은 한개의 클래스에만 적용 가능
 *   2. 권장 사항 : 파일을 따로 만든다
 */
class Category
{
	int no; // (구분자)
	String poster;
	String title;
	String subject;
	
}
/*
 *  멤버변수(인스턴스변수)
 *    1. 기본형
 *    2. 배열
 *    3. 클래스
 */
class FoodHouse
{
	int no; // (구분자) 중복이 안되는 숫자 => primary key => 상세보기 _ 배열의 인덱스번호의 느낌
	int cno; // 참조키 => foreign key /카테고리 넘버
	String[] poster=new String[5];
	String name;
	double score;
	String address1, address2;
	String tel;
	String type;
	String price;
	String parking;
	String stime, etime;
	String hol;
	String menu;
}
public class 사용자정의_데이터형_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}