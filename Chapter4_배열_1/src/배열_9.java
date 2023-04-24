import java.util.Arrays;

public class 배열_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열 확장 -> 기존크기를 늘리는게 아니라 새로운 배열을 확장시켜야함
		int[] arr1= {10,20,30,40,50};
		int[] arr2=new int[10];
		//System.arraycopy(arr1, 1, arr2, 0, 3); -> 의미: arr1의 1번쩨(20)부터 복사, arr2의 0번째에 복사값 입력, 3개 복사
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		System.out.println(Arrays.toString(arr2));
	}

}