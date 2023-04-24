
public class 산술연산자_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		int b=3;
		
		System.out.println(a+"%"+b+"="+(a%b));
		System.out.println(-a+"%"+b+"="+(-a%b));
		System.out.println(a+"%"+-b+"="+(a%-b));
		System.out.println(-a+"%"+-b+"="+(-a%-b)); // % : 결과값은 왼쪽 부호가 남는다(%에서만 해당되고, *,/ 에서는 정상적으로 연산처리됨 / 아래 확인)
		System.out.println(-a+"*"+-b+"="+(-a*-b)); 
		System.out.println(-a+"/"+-b+"="+(-a/-b));
	}

}