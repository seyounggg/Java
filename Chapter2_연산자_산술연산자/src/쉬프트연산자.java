// << , >> / 왼쪽으로 이동, 오른쪽으로 이동
/*
 *<<
 * 	x<<y ==> x*2^y
 * 	(예)
 *		10<<2
 *		1010 에서 두칸 옮겨져서 1010(0)(0)=> 101000 => 40 //이진법 계산
 *		7<<3
 *		111 => 111000 => 56(32+16+8)
 *		8<<2
 *		1000 => 100000 => 32
 *		9<<3 => 9*2^3 => 9*8 => 72
 *
 *>>
 *	x>>y ==> x/2^y
 *	(예)
 *		10>>2
 *		1010 => 10 => 2
 *		15>>3
 *		1111 => 1 => 1
 *		27>>3
 *		11011 => 11 => 3
 *		100>>3 => 100/2^3 => 12
 */
public class 쉬프트연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(10<<2); //40
		System.out.println(7<<3); //56
		System.out.println(8<<2); //32
		System.out.println(15>>3); //1
		System.out.println(10>>2); //2
		System.out.println(27>>3); //3
	}

}