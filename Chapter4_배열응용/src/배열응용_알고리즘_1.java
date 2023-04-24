import java.util.Arrays;

/*
 * 정렬 : ASC(오름차순)/DESC(내림차순)
 *    - 선택정렬(select sort):
 *    10 30 50 20 40 -정렬-> 10 20 30 40 50(올림차순), 50 40 30 20 10(내림차순)
 *      i     j
 *    start  횟수
 *      0     4
 *      1     3
 *      2     2
 *      3     1
 *      --------i+j=4 => j=4-i
 *                        ---length-1-i
 *    - 버블정렬:
 */
public class 배열응용_알고리즘_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[5];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println("===== 정렬전 =====");
		System.out.println(Arrays.toString(arr));
		System.out.println("===== 정렬후(DESC) =====");
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					int temp=arr[i];//변수안의 값을 교환하고 싶으면 임시변수를 생성하여 교환해야한다.
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			System.out.println("===== for "+(i+1)+"회차 =====");
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("===== 정렬후(ASC) =====");
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					int temp=arr[i];//변수안의 값을 교환하고 싶으면 임시변수를 생성하여 교환해야한다.
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			System.out.println("===== for "+(i+1)+"회차 =====");
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
	}

}