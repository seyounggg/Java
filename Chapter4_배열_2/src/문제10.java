import java.util.Arrays;

//정수 10개를 입력받은 후 세번째, 다섯번째와 마지막으로 입력받은 정수를 차례로 출력하는 프로그램
public class 문제10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[10];
		//초기화
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*10)+1;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[2]+" "+arr[4]+" "+arr[arr.length-1]);
		System.out.printf("세번째 숫자는:%d\n"
				+ "다섯번째 숫자는:%d\n"
				+ "마지막 숫자:%d",arr[2],arr[4],arr[arr.length-1]);
	}

}