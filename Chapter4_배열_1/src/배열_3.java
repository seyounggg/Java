/*
 * 3명의 학생 국어, 영어, 수학 => 총점, 평균, 학점, 등수
 * 2차원배열 : [3][7] -> 학생 3명/배열 7개 -> 학생 1명당 7개 배열을 갖고있고, 학생 3명
 */

import java.util.Scanner;
public class 배열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] kor=new int[3]; // index 번호 0 1 2
		int[] eng=new int[3]; // index 번호 0 1 2
		int[] math=new int[3]; // index 번호 0 1 2
		
		int[] total=new int[3];
		double[] avg=new double[3];
		char[] score=new char[3];
		int[] rank=new int[3];
		// Object[] student=new Object[3]; Object는 모든 데이터 통합
		
		Scanner scan=new Scanner(System.in);
		// 성적입력
		for(int i=0;i<kor.length;i++)
		{
			System.out.print((i+1)+"번째 국어점수 입력:");
			kor[i]=scan.nextInt();
			System.out.print((i+1)+"번째 영어점수 입력:");
			eng[i]=scan.nextInt();
			System.out.print((i+1)+"번째 수학점수 입력:");
			math[i]=scan.nextInt();
			
			total[i]=kor[i]+eng[i]+math[i];
			avg[i]=total[i]/3.0;
		}
		// 학점계산
		for(int i=0;i<kor.length;i++)
		{
			switch((int)avg[i]/10) // 점수가 89, 88 일 경우 10으로 나누면 8 -> 8이면 학점 'B'주려고
			{
			case 10:
			case 9: //avg가 >=90
				score[i]='A';
				break;
			case 8:
				score[i]='B';
				break;
			case 7:
				score[i]='C';
				break;
			case 6:
				score[i]='D';
				break;
			default:
				score[i]='F';
			}
		}
		//등수계산
		for(int i=0;i<kor.length;i++)
		{
			rank[i]=1;
			for(int j=0;j<kor.length;j++)
			{
				if(total[i]<total[j])
				{
					rank[i]++;
				}
			}
		}
		
		System.out.println("============성적표=============");
		for(int i=0;i<kor.length;i++)
		{
			System.out.printf("%-5d%-5d%-5d%-7d%-7.2f%-3c%-5d\n",
					kor[i],eng[i],math[i],total[i],avg[i],score[i],rank[i]);
		}
	}

}