import java.util.Arrays;

/*
 * [자바의 메모리 구조]
 *   Method Area => method, static
 *   stack => 메모리 관리(지역변수, 매개변수) / 지역변수는 {} 안에서만 사용 가능
 *   heap => 동적 메모리 할당(new) => 배열/클래스
 *   
 * ★ 변수(변수,배열,클래스) => 초기화 후에 사용 ★
 * 변수 : 저장공간 한개에 하나만 저장 ex) int a=10; 
 * 								  --- 기본형(자바에서 지원하는 데이터형)
 * 배열 : 같은 데이터형을 모아서 관리
 *       연속적인 메모리 배치 -> 인덱스번호를 이용(인덱스번호는 0번부터 시작)
 *       ex) int[] arr={1,2,3.4.5}
 * 
 * 	1. 배열선언
 * 		데이터형[] 배열명;
 * 	    데이터형 배열명[];
 *  2. 배열할당 (연속적으로 몇개 만들지 여부)
 *      데이터형[] 배열명 = new : 메모리를 만든 후 메모리의 주소값을 넘겨준다
 *      데이터형 배열명[] = new 데이터형[크기결정]
 *      
 *  3. 사용방법
 *  	1) 인덱스를 이용한 초기화
 *         int[] arr=new int[3]; // 처음에 arr[0~2] 까지에는 0값이 할당
 *         arr[0]=10;
 *         arr[1]=20;
 *         arr[2]=30; // arr[0~2]에 각 값을 대입
 *         
 *  	2) for문을 이용한 초기화(인덱스 번호가 필요하기 때문에 일반 for문 사용)__for each는 출력용이 주 사용 목적
 *         for(int i=0;i<arr.length;i++)
 *         {
 *         arr[i]=(i+1)+10
 *         }
 *         
 *  	3) 선언과 동시에 초기화
 *         영화/ 노래...(파일,오라클,크롤링)
 *         int[] arr={1,2,3,4,5}; =>(javascript)->[1,2,3,4,5]
 *         char[] c={'A','B','C','D','E'...};
 *         String[] s={"","",""....}; => 웹에서 80% 차치
 *      4) 배열은 크기가 고정되어 있음
 *         확장을 하려면 새로운 배열을 생성해야함.
 *         <배열복사>
 *         - 얕은 복사 => 별칭, 참조(같은 메모리 주소 활용)
 * 				int[] arr={};
 * 				int[] arr2=arr; => 같은 메모리를 제어
 * 		   - 깊은 복사 => 데이터만 복사, 새로운 메모리 만들어 저장
 * 				int[] arr={};
 * 				int[] arr2=arr.clone
 *          <배열확장>
 *         - arraycopy()
 *         - for를 이용해서 데이터값만 복사
 *         
 *         ★ new를 이용하는 경우=> 기본 디폴트 값이 설정됨
 *         int[]    ==> 0
 *         char[]   ==>'\u0000'
 *         String[] ==> null(모든 클래스의 기본 디폴트는 null)
 *                                                ----- 메모리 주소가 없는 경우
 *                                                ----- NullPointerException
 *         double[] ==> 0.0
 *         boolean[] ==> false
 */
public class 배열응용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// char배열 선언 =>26개 ==> 초기값 -> A~Z
		char[] alpha=new char[26];
		//초기화
		char c='A';
		for(int i=0;i<alpha.length;i++)
		{
			alpha[i]=c++;
		}
		// 출력
		for(char cc:alpha) //배열,컬렉션에서만 사용 가능
		{
			System.out.print(cc+" ");
		}
		System.out.println();
		System.out.println(Arrays.toString(alpha));
	}

}