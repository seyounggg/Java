// 정수를 입력 받아서 3의배수, 5의배수, 7의배수인지 확인, 아닌경우 "배수가 아니다" 로 출력
// 다중조건문은 하나만 수행하고 빠져나가기 때문에, 반복적으로 수행되는 부분이 있으면 단일조건문을 사용해야함
public class 조건문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int num=(int)(Math.random()*100)+1;
		int num=15;
		System.out.println("num="+num);
		if(num%3==0)
		{
			System.out.println(num+"는(은) 3의 배수입니다.");	
		}
		if(num%5==0)
		{
			System.out.println(num+"는(은) 5의 배수입니다.");
		}
		if(num%7==0)
		{
			System.out.println(num+"는(은) 7의 배수입니다.");
		}
		if(!(num%3==0 || num%5==0 || num%7==0))
				System.out.println("해당 배수가 아닌 수 입니다.");
			
		
// else if 를 사용한 경우에는 int 값이 15일 경우 [15는(은) 3의 배수입니다] 1개만 출력함
	}

}