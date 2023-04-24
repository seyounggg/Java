import java.util.Arrays;

public class 배열응용_알고리즘_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[5];
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*100)+1;
			
		}
		System.out.println("====정렬전====");
		System.out.println(Arrays.toString(arr));
		
		System.out.println("====정렬후====");
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-1-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}