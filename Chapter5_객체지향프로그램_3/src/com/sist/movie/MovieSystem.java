package com.sist.movie;
import java.util.List;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;

/*
 * 일별 박스오피스 : searchMainDailyBoxOffice.do
 * 실시간 예매율 : searchMainRealTicket.do
 * 좌석 점유율 : searchMainDailySeatTicket.do
 * JSON
 * https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do
 */
/*
 * [{"startYearDate":"2023.04.12",
 * "endYearDate":"2023.04.12",
 * "startDate":"2023년 04월 12일(수)",
 * "endDate":"2023년 04월 12일(수)",
 * "movieCd":"20231089",
 * "showDt":"20230412",
 * "thumbUrl":"/common/mast/movie/2023/04/thumb/thn_30be7bc08e504eaab8cd9545aa64749d.jpg",
 * "movieNm":"존 윅 4",
 * "movieNmEn":"John Wick: Chapter 4",
 * "synop":"죽을 위기에서 살아난 ‘존 윅’은 ‘최고 회의’를 쓰러트릴 방법을 찾아낸다.\r\n비로소 완전한 자유의 희망을 보지만 
 * NEW 빌런 ‘그라몽 후작’과 전 세계의 최강 연합은 \r\n‘존 윅’의 오랜 친구까지 적으로 만들어 버리고, 새로운 위기에 놓인 ‘존 윅’은 
 * 최후의 반격을 준비하는데...\r\n\r\n레전드 액션 블록버스터 &lt;존 윅&gt;의 새로운 챕터가 열린다!",
 * "prdtYear":"2023",
 * "indieYn":null,
 * "artmovieYn":null,
 * "multmovieYn":null,
 * "showTm":"169",
 * "showTs":"5",
 * "director":"채드 스타헬스키",
 * "prNm":null,"dtNm":"(주)레드아이스 엔터테인먼트","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"액션","watchGradeNm":"청소년관람불가","openDt":"20230412","salesAmt":1144439006,"audiCnt":113149,"scrCnt":1525,"showCnt":4665,"rank":1,"rankInten":-1,"rankOldAndNew":"NEW","rownum":1},{"startYearDate":"2023.04.12","endYearDate":"2023.04.12","startDate":"2023년 04월 12일(수)","endDate":"2023년 04월 12일(수)","movieCd":"20226270","showDt":"20230412","thumbUrl":"/common/mast/movie/2023/01/thumb/thn_493d957e6b894177bb380f3d83a7eed0.jpg","movieNm":"스즈메의 문단속","movieNmEn":"Suzume","synop":"큐슈의 작은 마을에서 살고 있는 소녀 ‘스즈메’는\r\n어느 날, 여행을 하며 ‘문’을 찾고 있는 한 청년을 만난다.\r\n그의 뒤를 쫓아간 소녀는 산속 폐허에서 덩그러니 남겨진 낡은 문을 발견한다. \r\n무언가에 이끌린 듯 ‘스즈메’는 문으로 손을 뻗는데…\r\n\r\n2023년, ‘문단속을 위한 여행’이 시작된다!","prdtYear":"2022","indieYn":null,"artmovieYn":null,"multmovieYn":"Y","showTm":"121","showTs":"47","director":"신카이 마코토","prNm":null,"dtNm":"(주)쇼박스","repNationCd":"일본","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"12세이상관람가","openDt":"20230308","salesAmt":255639582,"audiCnt":25978,"scrCnt":922,"showCnt":3048,"rank":2,"rankInten":-1,"rankOldAndNew":"OLD","rownum":2},{"startYearDate":"2023.04.12","endYearDate":"2023.04.12","startDate":"2023년 04월 12일(수)","endDate":"2023년 04월 12일(수)","movieCd":"20226489","showDt":"20230412","thumbUrl":"/common/mast/movie/2023/03/thumb/thn_8b331270379640558ed268d97b211887.jpg","movieNm":"리바운드","movieNmEn":"Rebound","synop":"농구선수 출신 공익근무요원 ‘양현’은\r\n해체 위기에 놓인 부산중앙고 농구부의 신임 코치로 발탁된다.\r\n하지만 전국대회에서의 첫 경기 상대는 고교농구 최강자 용산고.\r\n팀워크가 무너진 중앙고는 몰수패라는 치욕의 결과를 낳고\r\n학교는 농구부 해체까지 논의하지만,\r\n‘양현’은 MVP까지 올랐던 고교 시절을 떠올리며 다시 선수들을 모은다.\r\n\r\n주목받던 천재 선수였지만 슬럼프에 빠진 가드 ‘기범’\r\n부상으로 꿈을 접은 올라운더 스몰 포워드 ‘규혁’\r\n점프력만 좋은 축구선수 출신의 괴력 센터 ‘순규’\r\n길거리 농구만 해온 파워 포워드 ‘강호’\r\n농구 경력 7년 차지만 만년 벤치 식스맨 ‘재윤’\r\n농구 열정만 만렙인 자칭 마이클 조던 ‘진욱’까지\r\n\r\n아무도 주목하지 않은 최약체 팀이었지만 신임 코치와 6명의 선수가\r\n2012년 전국 고교농구대회에서 써 내려간 8일간의 기적\r\n\r\n모두가 불가능이라 말할 때, 우리는 ‘리바운드’라는 또 다른 기회를 잡는다.","prdtYear":"2022","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"122","showTs":"8","director":"장항준","prNm":"(주)비에이엔터테인먼트,워크하우스컴퍼니(주)","dtNm":"(주)바른손이앤에이","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"드라마","watchGradeNm":"12세이상관람가","openDt":"20230405","salesAmt":157513095,"audiCnt":16830,"scrCnt":750,"showCnt":2371,"rank":3,"rankInten":-1,"rankOldAndNew":"OLD","rownum":3},{"startYearDate":"2023.04.12","endYearDate":"2023.04.12","startDate":"2023년 04월 12일(수)","endDate":"2023년 04월 12일(수)","movieCd":"20231009","showDt":"20230412","thumbUrl":"/common/mast/movie/2023/04/thumb/thn_7bac689e1d754dba8fa824363b5daf51.jpg","movieNm":"거울 속 외딴 성","movieNmEn":"Lonely Castle in the Mirror","synop":"“꼭 이루고 싶은 한 가지 소원이 있어”\r\n\r\n학교에서도 집에서도 마음 둘 곳 없이 외로운 시간을 보내던 ‘코코로’.\r\n어느 날, 방 안의 거울이 갑자기 빛나기 시작하고,\r\n‘코코로’는 홀린 듯 거울 속으로 빨려 들어가게 되는데…\r\n\r\n거울 속 세상은 바다 위에 떠있는 신비로운 성이었고,\r\n그곳에서 처음 보는 여섯 명의 친구들과\r\n늑대 가면을 쓴 정체불명의 소녀 ‘늑대님’을 만나게 된다.\r\n\r\n“성에 숨겨진 열쇠를 찾으면, 원하는 소원을 한 가지 들어주지”\r\n열쇠를 찾으며 조금씩 가까워진 ‘코코로’와 친구들은 뭔가 수상한 점을 하나씩 발견하게 되는데…\r\n\r\n모든 수수께끼가 풀리는 순간 상상을 초월하는 기적이 펼쳐진다!\r\n","prdtYear":"2022","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"116","showTs":"21","director":"하라 케이이치","prNm":null,"dtNm":"워터홀컴퍼니(주)","repNationCd":"일본","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션,미스터리,판타지","watchGradeNm":"12세이상관람가","openDt":"20230412","salesAmt":48791545,"audiCnt":5070,"scrCnt":324,"showCnt":539,"rank":4,"rankInten":28,"rankOldAndNew":"OLD","rownum":4},{"startYearDate":"2023.04.12","endYearDate":"2023.04.12","startDate":"2023년 04월 12일(수)","endDate":"2023년 04월 12일(수)","movieCd":"20228555","showDt":"20230412","thumbUrl":"/common/mast/movie/2022/12/thumb/thn_de3eb9d23b1b49e58b5f06b96d5fa6b5.jpg","movieNm":"더 퍼스트 슬램덩크","movieNmEn":"The First Slam Dunk","synop":"전국 제패를 꿈꾸는 북산고 농구부 5인방의 꿈과 열정, 멈추지 않는 도전을 그린 영화","prdtYear":"2022","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"124","showTs":"26","director":"이노우에 다케히코","prNm":null,"dtNm":"(주)넥스트엔터테인먼트월드(NEW)","repNationCd":"일본","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"12세이상관람가","openDt":"20230104","salesAmt":52342808,"audiCnt":4268,"scrCnt":272,"showCnt":444,"rank":5,"rankInten":0,"rankOldAndNew":"OLD","rownum":5},{"startYearDate":"2023.04.12","endYearDate":"2023.04.12","startDate":"2023년 04월 12일(수)","endDate":"2023년 04월 12일(수)","movieCd":"20231010","showDt":"20230412","thumbUrl":"/common/mast/movie/2023/03/thumb/thn_6e5a49d4cc3f437ea6d30def90937f40.jpg","movieNm":"에어","movieNmEn":"Air","synop":"세기의 아이콘을 만든 그들의 실화\r\n당신이 알고 있는 그 이상의 이야기\r\n\r\n1984년, 업계 꼴찌를 벗어나지 못하고 있는 나이키는\r\n브랜드의 간판이 되어 줄 새로운 모델을 찾는다.\r\n나이키의 스카우터 소니 바카로(맷 데이먼)는\r\nNBA의 떠오르는 루키 마이클 조던이 나이키의 미래라고 생각한다.\r\n그런데, 이미 시장을 장악한 컨버스와 아디다스가 그와의 계약을 노리는 상황\r\n나이키 팀은 조던의 마음을 얻기 위한 전략을 세우는데….\r\n\r\n누구에게나 점프하는 순간이 온다!","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"111","showTs":"49","director":"벤 애플렉","prNm":null,"dtNm":"워너브러더스 코리아(주)","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"드라마","watchGradeNm":"15세이상관람가","openDt":"20230405","salesAmt":26337418,"audiCnt":2762,"scrCnt":351,"showCnt":547,"rank":6,"rankInten":-3,"rankOldAndNew":"OLD","rownum":6},{"startYearDate":"2023.04.12","endYearDate":"2023.04.12","startDate":"2023년 04월 12일(수)","endDate":"2023년 04월 12일(수)","movieCd":"20226410","showDt":"20230412","thumbUrl":"/common/mast/movie/2023/03/thumb/thn_644062f09eb24f9ebd3d08e378aeeb59.jpg","movieNm":"던전 앤 드래곤: 도적들의 명예","movieNmEn":"Dungeons &amp; Dragons: Honor Among Thieves","synop":"한때는 명예로운 기사였지만, ‘어떤 사건’ 이후\r\n‘홀가’, ‘사이먼’, ‘포지’와 함께 도적질을 하게 된 ‘에드긴’.\r\n‘소피나’의 제안으로 ‘부활의 서판’을 얻기 위해 ‘코린의 성’에 잠입하지만 \r\n‘포지’와 ‘소피나’의 배신으로 실패하고 감옥에 갇힌다.\r\n\r\n기발한 방법으로 탈옥에 성공한 ‘에드긴’과 ‘홀가’는 소중한 사람들과 다시 만나고, \r\n‘부활의 서판’도 되찾기 위해 자신만의 팀을 꾸리기 시작하는데…\r\n\r\n옛 동료인 소질 없는 소서러 ‘사이먼’과\r\n새롭게 합류한 변신 천재 드루이드 ‘도릭’, 재미 빼고 다 가진 팔라딘 ‘젠크’까지\r\n어딘가 2% 부족한 오합지졸로 가득한 이 팀,\r\n과연 무사히 모험을 끝마칠 수 있을까?\r\n\r\n&lt;가디언즈 오브 갤럭시&gt;&lt;어벤져스: 에이지 오브 울트론&gt; 제작진이 선보이는\r\n매력만점 롤플레잉 액션 어드벤처 무비가 온다!","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"133","showTs":"59","director":null,"prNm":null,"dtNm":"롯데컬처웍스(주)롯데엔터테인먼트","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"액션,어드벤처,판타지","watchGradeNm":"12세관람가","openDt":"20230329","salesAmt":18638778,"audiCnt":1896,"scrCnt":238,"showCnt":404,"rank":7,"rankInten":-3,"rankOldAndNew":"OLD","rownum":7},{"startYearDate":"2023.04.12","endYearDate":"2023.04.12","startDate":"2023년 04월 12일(수)","endDate":"2023년 04월 12일(수)","movieCd":"20231035","showDt":"20230412","thumbUrl":"/common/mast/movie/2023/03/thumb/thn_e72a719bbb8f4c95beba44cd08233f6c.jpg","movieNm":"카구야 님은 고백받고 싶어 -첫 키스는 끝나지 않아-","movieNmEn":"Kaguya-sama: Love Is War -The First Kiss That Never Ends-","synop":"장래가 기대되는 우수한 수재들이 모인 슈치인 학원.\r\n슈치인 학원 학생회에서 만난 부회장 시노미야 카구야와 회장 시로가네 미유키.\r\n낭만적인 두뇌 싸움 끝에 두 천재는 서로에 대한 감정을 공유하고 문화제에서 첫 키스를 한다.\r\n그러나 아직 두 사람 사이에 이렇다 할 고백은 이루어지지 않고,\r\n연인처럼 보였던 두 사람의 관계는 여전히 애매모호한 상태에서 크리스마스를 맞이하는데..\r\n\r\n완벽해지고 싶은 시로가네와 그의 완벽하지 않은 곳을 찾는 카구야.\r\n천재들의 매우 \"정상적인\" 사랑 이야기가 시작된다!\r\n아직 우리들의 첫 키스는 진행 중!","prdtYear":"2022","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"96","showTs":"7","director":"하타케야마 마모루","prNm":null,"dtNm":"(주)디스테이션","repNationCd":"일본","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"12세이상관람가","openDt":"20230406","salesAmt":15723800,"audiCnt":1505,"scrCnt":74,"showCnt":125,"rank":8,"rankInten":7,"rankOldAndNew":"OLD","rownum":8},{"startYearDate":"2023.04.12","endYearDate":"2023.04.12","startDate":"2023년 04월 12일(수)","endDate":"2023년 04월 12일(수)","movieCd":"20210544","showDt":"20230412","thumbUrl":"/common/mast/movie/2023/03/thumb/thn_e62e0de74538455bbfa5e74ede3cd8d9.jpg","movieNm":"웅남이","movieNmEn":"woongnami","synop":"인간을 초월하는 짐승 같은 능력으로 국제 범죄 조직에 맞서는 웅남이의 좌충우돌 코미디 &lt;웅남이&gt;","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"97","showTs":"17","director":"박성광","prNm":"(주)영화사김치","dtNm":"씨제이 씨지브이(CJ CGV)(주)","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"코미디,액션","watchGradeNm":"15세이상관람가","openDt":"20230322","salesAmt":8922800,"audiCnt":1022,"scrCnt":132,"showCnt":182,"rank":9,"rankInten":-3,"rankOldAndNew":"OLD","rownum":9},{"startYearDate":"2023.04.12","endYearDate":"2023.04.12","startDate":"2023년 04월 12일(수)","endDate":"2023년 04월 12일(수)","movieCd":"20179462","showDt":"20230412","thumbUrl":"/common/mast/movie/2017/12/thumb/thn_a4c279a135c94c598995fd017b53053c.jpg","movieNm":"위대한 쇼맨","movieNmEn":"The Greatest Showman","synop":"불가능한 꿈, 그 이상의 쇼!\r\n쇼 비즈니스의 창시자이자, 꿈의 무대로 전세계를 매료시킨 남자 ‘바넘’의 이야기에서 영감을 받아 탄생한 오리지널 뮤지컬 영화 &lt;위대한 쇼맨&gt;. &lt;레미제라블&gt; 이후 다시 뮤지컬 영화로 돌아온 휴 잭맨부터 잭 에프론, 미셸 윌리엄스, 레베카 퍼거슨, 젠다야까지 할리우드 최고의 배우들이 합류해 환상적인 앙상블을 선보인다. 여기에 &lt;미녀와 야수&gt; 제작진과 &lt;라라랜드&gt; 작사팀의 합류로 더욱 풍성해진 비주얼과 스토리, 음악까지 선보일 &lt;위대한 쇼맨&gt;은 ‘우리는 누구나 특별하다’는 메시지로 관객들에게 재미는 물론, 감동까지 선사할 것이다.\r\nTHIS IS ME! 우리는 누구나 특별하다!\r\n\r\n","prdtYear":"2017","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"104","showTs":"9","director":"마이클 그레이시","prNm":null,"dtNm":"월트디즈니컴퍼니코리아 유한책임회사,이십세기폭스코리아(주)","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"드라마,뮤지컬","watchGradeNm":"12세이상관람가","openDt":"20171220","salesAmt":9137828,"audiCnt":882,"scrCnt":42,"showCnt":57,"rank":10,"rankInten":-3,"rankOldAndNew":"OLD","rownum":10}]
 */
public class MovieSystem {
	Movie[] movie=new Movie[10]; //Movie에 5개가 들어가있고, 각 10개씩 저장
	int menu() {
		Scanner scan=new Scanner(System.in);
		System.out.println("===========메뉴============");
		System.out.println("1.일별 박스오피스");
		System.out.println("2.실시간 예매율");
		System.out.println("3.좌석 점유율");
		System.out.println("4.상세보기");
		System.out.println("9.종료하기");
		System.out.println("===========================");
		System.out.print("메뉴 선택:");
		return scan.nextInt();
	}
	//목록 출력
	Movie[] movieListData(int no) {
		String[] strUrl= {
				"",
				"searchMainDailyBoxOffice.do",
				"searchMainRealTicket.do",
				"searchMainDailySeatTicket.do"
		};
		String url="https://www.kobis.or.kr/kobis/business/main/"+strUrl[no];
		try {
			//[{},{},[],[} ...] JSON? 객체표현법
			//[] => JSONArray
			//{} => JSONObject 
			org.jsoup.nodes.Document doc=Jsoup.connect(url).get();
			//System.out.println(doc.toString());
			String msg=doc.toString();
			msg=msg.substring(msg.indexOf("["),msg.lastIndexOf("]")+1); // +1을 하지 않으면 ] 포함돼서 잘림.
			//System.out.println(msg);
			JSONParser jp=new JSONParser();
			JSONArray arr=(JSONArray)jp.parse(msg);
			for(int i=0;i<arr.size();i++) {
				
				JSONObject obj=(JSONObject)arr.get(i);
				movie[i]=new Movie();
				movie[i].title=(String)obj.get("movieNm");
				movie[i].time=(String)obj.get("showTm");
				movie[i].genre=(String)obj.get("genre");
				movie[i].director=(String)obj.get("director");
				movie[i].story=(String)obj.get("synop");
				
			}
		}catch (Exception ex) {}
		return movie;
	}
	Movie movieDetailData(int no) {
		return movie[no-1];
	}
	/*public static void main(String[] args) {
		MovieSystem ms=new MovieSystem();
		ms.movieListData(1);
		Movie[] mm=ms.movieListData(1);
		for(int i=0;i<mm.length;i++) {
			System.out.println((i+1)+"."+mm[i].title);
		}
		
	}*/
}