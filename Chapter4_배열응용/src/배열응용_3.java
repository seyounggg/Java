import java.util.Arrays;

//6개 난수 발생 => 1~45
//조건: 중복된 수가 나오면 안됨

public class 배열응용_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lotto=new int[10];
		/*for(int i=0;i<lotto.length;i++)
		{
			lotto[i]=(int)(Math.random()*45)+1;
			for(int j=0;j<i;j++) //이 조건식이 이해가 안됨
			{
				if(lotto[i]==lotto[j])
				{
					i--; //예, 두번째에서 중복값이 있을 경우 위 for문에 의해서 i++돼서 세번째데이터로 이동하게 되는데,
						//여기서 i--를 해주므로 두번째값이 다시 비교될 수 있도록 하기 위해서?? 이해안됨
					break;
				}
			}
		}*/
		int su=0;//난수 저장
		boolean bCheck=false;//중복여부 확인
		for(int i=0;i<lotto.length;i++)
		{
			bCheck=true;
			while(bCheck)//난수발생
			{
				su=(int)(Math.random()*10)+1;
				bCheck=false; //default
				for(int j=0;j<i;j++)
				{
					if(lotto[j]==su) {
						bCheck=true;
						break;
					}
				}
			}
			lotto[i]=su;
		}
		System.out.println(Arrays.toString(lotto));
	}

}