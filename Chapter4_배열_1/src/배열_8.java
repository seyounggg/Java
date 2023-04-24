import java.util.Arrays;

public class 배열_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1= {10,20,30,40,50};
		int[] arr2=arr1.clone(); // .clone() -> 새로운 메모리를 생성하라, 값 복사 가능
		//int[] arr2=arr1 // 별칭(참조데이터) // arr1과 arr2가 같은 메모리 제어(주소값 동일)
		
		System.out.println(arr1);
		System.out.println(arr2);
		
		System.out.println("arr1="+Arrays.toString(arr1));
		System.out.println("arr2="+Arrays.toString(arr2));
		
		System.out.println("========배열값 변경========");
		arr2[0]=100;
		arr2[1]=200;
		arr2[2]=300;
		arr2[3]=400;
		arr2[4]=500;
		System.out.println("arr2="+Arrays.toString(arr2));
		System.out.println("arr1="+Arrays.toString(arr1));

		int[] arr3=new int[10];
		for(int i=0;i<arr1.length;i++)
		{
			arr3[i]=arr1[i];
		}//기존의 배열(arr1)은 고정이므로, 배열의 크기를 늘리고 싶으면 복사하는 배열(arr3)에서 배열 크기를 증가시켜야함. /원래 값 복사하는 방법
		System.out.println(Arrays.toString(arr3));
	}

}