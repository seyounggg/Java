import java.util.Arrays;

// 정수 10개 저장공간 => 임의로 초기화(1~100)
// 최대값과 최소값 ==> 배열 몇번째에 위치해있는지 찾기!

public class 배열응용_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		//최대값, 최소값 찾기
		int max=arr[0];
		int min=arr[0]; // max와 min에 첫번째 값 넣기
		for(int i:arr)
		{
			if(max<i)
				max=i;
			if(min>i)
				min=i;
		}
		System.out.println("최대값:"+max);
		System.out.println("최소값:"+min);
		
		int index1=0, index2=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==max)
			{
				index1=i; //i가 인덱스번호, max랑 같은값을 index1에 저장해라
			}
			else if(arr[i]==min)
			{
				index2=i;//i가 인덱스번호, min랑 같은값을 index2에 저장해라
			}
		}
		System.out.println("최대값 위치:"+index1
				+","+(index1+1)+"번째 위치"); //뒤에 (index1+1)+"번째 위치" <- 보이는 위치
		System.out.println("최소값 위치:"+index2
				+","+(index2+1)+"번째 위치"); //뒤에 (index2+1)+"번째 위치" <- 보이는 위치
	}

}