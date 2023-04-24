/*문제7. 정수 3개를 입력받아서 총점과 평균을 구하고 학점을 구하는 프로그램
        작성 ( 90이상이면 A,80이상이면 B, 70이상이면 C,60이상이면 D, 
        나머지는 F)*/
import java.util.Scanner;
public class 문제7 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		int a,b,c,total;
		double avg;
		
		System.out.print("정수 세개 입력(1 2 3):");
		a=scan.nextInt();
		b=scan.nextInt();
		c=scan.nextInt();
		total=a+b+c;
		avg=total/3.0;
		
		System.out.println("총점:"+total);
		System.out.printf("평균:%.2f\n",avg);
		
		int temp=(int)avg;
		if(temp>=90)
			System.out.println("A");
		if(temp>=80 && temp<90)
			System.out.println("B");
		if(temp>=70 && temp<80)
			System.out.println("c");
		if(temp>=60 && temp<70)
			System.out.println("D");
		if(temp<60)
			System.out.println("F");

	}

}