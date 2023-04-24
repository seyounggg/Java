import java.util.Arrays;

//10개의 정수를 입력 받아 그 중 가장 큰 수를 출력하는 프로그램
public class 문제11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		int max=arr[0];
		for(int i:arr) {
			if(max<i)
				max=i;
		}
		System.out.println("최대값:"+max);
	}

}