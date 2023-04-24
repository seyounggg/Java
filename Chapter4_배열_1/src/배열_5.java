import java.util.Arrays;

public class 배열_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr=new char[20];
		for(int i=0;i<arr.length;i++)
		{
			int n=(int)(Math.random()*2); //0 1
			if(n==0)
				arr[i]=(char)((Math.random()*26)+65); //대문자
			else
				arr[i]=(char)((Math.random()*26)+97); //소문자
		}
		System.out.println(Arrays.toString(arr));
		
		int c1=0, c2=0;
		for(char d:arr)
		{
			if(d>='A' && d<='Z')
				c1++;
			else
				c2++;
		}
		System.out.println("대문자 갯수:"+c1);
		System.out.println("소문자 갯수:"+c2);
	}

}