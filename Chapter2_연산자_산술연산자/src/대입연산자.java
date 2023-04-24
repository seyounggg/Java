/*
 * 대입연산자
 * 	연산순서 : 좌 ← 우
 * 		예) a=10+30 경우 10+30을 먼저 계산 후 a에 대입!
 * 	=  대입연산자
 * 	------------ 복합대입연산자
 * 	***+= => 누적(총합) 
 * 	***-=
 * 	*=
 * 	/=
 * 	%=
 * 	<<=
 * 	>>=
 * 	&=
 * 	|=
 * 	^=
 * 
 * 	+= 예)
 * 	int a=10;
 * 	a+=10; ==> a=a+10 => 20
 * 	a+=1; ==> a=a+1 => a++ ++a
 * 
 * 
 */
public class 대입연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int a=10;
		a++;
		a++;
		a++;
		System.out.println(a);*/
		
		/*int a=10;
		a+=3;
		System.out.println(a);*/
		
		int a=10;
		a=a+3; // a+=3
		System.out.println(a);
	}

}