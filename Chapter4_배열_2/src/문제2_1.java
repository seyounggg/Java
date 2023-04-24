// continue와 break 관련
public class 문제2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=3;j++)
			{
				//i=1 j=1,2,3
				//i=2 j=1,2,3
				//i=3 j=1,2,3
				if(j==2)
					break; // <- 포함된 블럭 안에서만 기능함(여기서는 2차 for만 제어)
				System.out.println("i="+i+",j="+j);
			}
		}
	}

}