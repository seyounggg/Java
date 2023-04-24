
// 장르별 노래제목 출력
import java.util.Scanner;

import javax.lang.model.util.Elements;
import javax.swing.text.Element;

import org.w3c.dom.Document;
public class 메소드_4 {
	static int menu() {
		Scanner scan=new Scanner(System.in);
		System.out.println("======= 메뉴======");
		System.out.println("1.가요");
		System.out.println("2.POP");
		System.out.println("3.OST");
		System.out.println("4.트롯");
		System.out.println("5.JAZZ");
		System.out.println("9. 종료");
		System.out.println("=================");
		System.out.print("메뉴 선택:");
		int menu=scan.nextInt();
		return menu;
	}
	static void titlePrint(int no)
	{
		final String BASIC_CRL="https://www.genie.co.kr/genre/";
		String[] url= {
				"",
				"M0100",
				"M0200",
				"M0300",
				"L0107",
				"M0500", // no 넘버(1.가요)가 1부터 시작이라서, 가장 첫번째는 0이니까 0에 아예 입력 안한거
				
		};
		try
		{
//			Document doc=Jsoup.connect(BASIC_URL+url[no]).get();
//			Elements title=doc.select("tr.list td.info a.title");
//			for(int i=0;i<title.size();i++)
//			{
//				System.out.println(title.getConstantExpression(i).text());
//			}
		}catch(Exception ex) {}
	}
	static void process()
	{
		while(true)
		{
			int m=menu();
			if(m==9)
			{
				System.out.println("프로그램 종료");
				break;
			}
			titlePrint(m);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

}