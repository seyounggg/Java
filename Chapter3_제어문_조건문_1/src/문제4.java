//문제4. 사용자로부터 세 개의 정수를 입력받아, 그 수들의 최대값과 최소값, 합계와 평균을 구해보자.

//import java.util.Scanner;
public class 문제4 {

	public static void main(String[] args) {
		int a,b,c,max,min,total;
		double avg;
		/*Scanner scan=new Scanner(System.in);
		System.out.print("정수 세개 입력(1 2 3):");
		a=scan.nextInt();
		b=scan.nextInt();
		c=scan.nextInt();*/
		
		a=(int)(Math.random()*100)+1;
		b=(int)(Math.random()*100)+1;
		c=(int)(Math.random()*100)+1; //강사님은 랜덤으로 받아오려고 Math.random() 사용함
		
		
		total=a+b+c;
		avg=total/3.0;
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		System.out.println("total="+total);
		System.out.printf("평균:%.2f\n",avg);
		
		//최대값
		max=a;
		if(max<b)max=b;
		if(max<c)max=c;
		
		//최소값
		min=a;
		if(min>b)min=b;
		if(min>c)min=c;
		
		System.out.println("최대값:"+max);
		System.out.println("최소값:"+min);
		

	}

}