# uart_team2 👨‍🎨🖼 
팀장: 조재윤  팀원: 김서윤, 조재원, 이현지, 박재형  
기간: 22.10.25~22.12.16


## 1. 프로젝트 주제 및 기획의도
**주제**:
AI플랫폼을 활용한  Spring boot기반의  전시 예매 웹 서비스 개발 

#### 기획의도  
1. 전 연령대를 대상으로 서비스 제공이 가능하다는 점에서 공연,전시 예매 사이트로 주제 선정- ERD설계, DB 생성 , Mybatis를 활용한 DB연동, CRUD설계, NCP환경에서의 개발 등 교육받은 내용을 바탕으로 웹 서비스 구현                 
2. 반응형 웹 서비스와  네이버 클라우드 플랫폼에서 제공하는 AI Service, 카카오 api를 활용하며 기존의 사이트와 차별화  
3. 소비자 페이지와 관리자 페이지 별도 개발, 페이지 간 적절히 연동
4. 사용자의 편의를 고려한 화면구성과 기능 구현

## 2. 프로젝트 역할분담

|이름|역할|
|--|--| 
|조재윤|예매 & 예매내역 DB구축 및 CRUD 설계<br>sns로그인(Kakao&Naver)<br>이벤트 OCR_CLOVA OCR<br>Fullcalendar전시 일정<br>공공데이터api, 결제api(i'mport)<br>예매내역 조회/취소<br>소비자&관리자 페이징처리|  
|김서윤|위시리스트 DB 구축 및 CRUD 설계<br>주문페이지, 위시리스트 추가/중복방지/삭제<br>관리자페이지 매출 차트 전체, 실시간 서버시간<br>관리자페이지 가입자수, 동적 리뷰별 추천전시 |
|조재원| 고객 & 티켓 DB 구축 및 CRUD 설계<br>sns공유하기_카카오api<br>소비자&관리자 login/logout 및 조회/수정/탈퇴<br>FAQ, 한줄평, @media작업, favicon|
|이현지|상품 & 카테고리 DB 구축 및 CRUD 설계<br>챗봇_CLOVA Chatbot<br>검색기능_Autocomplete<br>소비자 메인, 전시목록, 상세정보페이지<br>관리자페이지 전시목록 조회/등록/수정/삭제|
|박재형|Marker & 리뷰 & 이벤트 DB 구축 및 CRUD 설계<br>지도API_장소안내<br>소비자&관리자 회원가입
  
## 3. 프로젝트 수행 방법 및 도구 
✨**시스템 구성도** 

<img width="736" alt="시스템 구성도" src="https://user-images.githubusercontent.com/111713782/206954676-a3c6981c-40b9-412e-9376-e93618b5a9a2.PNG">

✨**개발 환경 및 수행 도구**

|개발도구|협업도구|언어|웹|DB|프레임워크|API|라이브러리|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|Eclipse|Zoom<br>Github<br>ERD Cloud<br>Google Docs<br>Naver Band|Java<br>SQL|HTML<br>CSS<br>JS<br>jQuery<br>Ajax<br>Bootstrap<br>Thymeleaf|MySQL|Spring Boot<br>MyBatis|API로그인<br>Naver OCR<br>Naver Chatbot<br>Kakao Map<br>i'mport|Fullcalendar<br>Autocomplete|

✨**DB 설계**

<img width="985" alt="erd" src="https://user-images.githubusercontent.com/111727476/206938526-473926e0-98c2-4af2-8a03-840282c09ec6.png">

✨**UI 설계**

<img width="933" alt="통합UI" src="https://user-images.githubusercontent.com/111713782/206375750-e2ce8aac-66f5-427b-97c1-596ae4f5ae28.PNG">

## 4. 프로젝트 구현 기능

<img width="80" height="30" alt="fav" src="https://user-images.githubusercontent.com/111713782/206620993-70808226-5ae0-478e-82c5-41bb216121b2.png">  

**1-1) 회원가입 및 로그인(+kakao/naver)&로그아웃/회원정보 조회/수정/탈퇴**  
- jQuery를 활용해 post방식으로 form 전송  
- 회원탈퇴 시 ‘withdrawal’필드 값 ‘1 (회원)’→ ‘0 (탈퇴)’ 변경
=> 중복아이디로 다시 가입 불가
=> 해당 아이디로 로그인 불가  

**1-2) sns로그인(+kakao/naver)&로그아웃**
- SNS계정으로 처음 로그인을 하는 경우, 카카오/네이버 서버는 redirect url로 인증코드를 전달 → 클라이언트(Web)쪽에서 인증코드를 이용하여  access_token발급받은 후 서버로 전송 → 서버에서는 access_token을 이용하여 카카오/네이버 서버로부터 사용자 정보(이름, 이메일, 성별)를 받음 → 사용자정보를 db에 저장함으로서 회원가입 진행한 후 로그인되도록 구현

- SNS계정이 이미 있는 경우, 해당 계정으로 로그인 되도록 구현

**2-1) 공연•전시 상세페이지(상세정보, 예매/취소 안내)**  
- Bootstrap tab을 사용하여 한 페이지에서 다양한 정보 탐색 가능
- 카카오 API 사용하여 지도정보 전송 => db에 있는 전시장소별 위도 & 경도 데이터를 가져와서 해당 위치의 지도정보 화면에 보여줌  

**2-2) 공연•전시 상세페이지(한줄평)**  
- 해당 전시 예매내역이 있는지 여부 확인 & 예매내역이 있는 경우, 리뷰 작성을 한적이 있는지 여부 확인
- 해당 전시 예매자만 리뷰 작성이 가능하되 리뷰 중복 작성 방지되도록 기능 구현  

**2-3) 공연•전시 상세페이지(sns공유하기)**  
- URL을 전달하여 SNS 공유하기 기능 구현 카카오 API를 활용하여 제작한 카카오 메시지 템플릿 전송  

**3) 카테고리별 정렬 및 추천작품(별점순)** 
- XML query문 사용하여 맵핑하여 Mapper 함수호출 
- 전시 카테고리 별 화면구현/ 전시 마감순/시작순 목록구현/ 리뷰 별점순 추천작품 목록 구현
- 공연예술 페이지 - 공공데이터 포털 API호출하여 가져온 데이터를 화면에 나타냄

**4) 위시리스트**
- Mapper 함수를 사용하여 위시리스트 중복확인 가능한 모달 구현
- 함수 onclick 기능 사용하여 위시리스트로 이동가능한 모달 구현

**5) 예매내역**
- 취소가능일에만 예매취소가 가능하도록 기능 구현
- 예매취소버튼 클릭 => jQuery로 취소하려는 날짜와 취소가능일 비교하는 함수 호출 => 예매취소가 가능한 경우, ajax로 해당 데이터 전송 후 예매내역 삭제 => 모달창으로 알림

**6) 예매 및 결제**
- 대상에 따라 상이한 가격정보와 수량 데이터 가져오기
- 이벤트 테이블의 sort 필드 값  
1 : 이벤트 참여로 지급된 쿠폰   사용하지 않은 경우/ 0 : 이벤트 참여로 지급된 쿠폰 사용한 경우  
 => 결제시, 50%할인쿠폰 중복으로 적용되지 않도록 함  
 => 쿠폰적용 가능여부에 따른 버튼 활성화/비활성화
- I’mport(아임포트) API 사용하여 실제 가능한 결제기능 구현

**7) 예매 및 결제(모바일 환경)**
- I’mport(아임포트) API 사용하여 모바일 웹 환경에서도 결제 가능하도록 구현
- 모바일 웹 환경에서는 특정 PG사(ex.KG 이니시스..)의 웹사이트로 리디렉션되면 requestPay()함수에 지정한 callback 함수가 메모리에서 해제되기 때문에, pc 웹 환경에서와 달리 결제 프로세스 완료 후 callback 함수가 실행될 수 없음 => requestPay()함수에 결제 프로세스 완료 후 리디렉션 될 URL을 지정함 => redirect_url의 파라미터로 데이터를 서버로 넘겨서 db에 결제 데이터가 들어가도록 함  

![모바일결제](https://user-images.githubusercontent.com/111713782/206960430-fa4653da-e47f-437a-a3af-3777d121a09b.gif)

**8) 검색 및 검색어 자동완성기능**
- ajax 이용하여 form 전송
- jQuery 라이브러리를 사용 => JSON Array를 사용하여 배열을 만들고 ajax 이용하여 전송

✨**NCP시스템 구성도**

<img width="707" alt="NCP환경" src="https://user-images.githubusercontent.com/111713782/206957393-0efd25a4-5034-4a09-87fd-badac1a4d134.PNG">

**9) OCR 수험생 인증 이벤트**

<img width="889" alt="OCR수험생 이벤트" src="https://user-images.githubusercontent.com/111713782/206957643-49aa0308-ce02-4ebf-b2bc-88e947a23999.PNG">

- Naver Cloud Platform의 CLOVA OCR에 수험표 검증에 필요한 영역들(수험년도, 이름, 주민등록번호 앞자리, 수험번호)을 설정함.
- 사용자가 U-ART 에서 수험표 이벤트 참여를 위해 사진을 업로드하면 OCR을 통해 JSON형태의 응답을 받음
- 수험표 사진인지 여부를 판별  
수험표 사진일 경우, 이번년도 수험표인지 여부와 db에 있는 사용자 정보와 일치하는지 여부 판별,  
모든 조건에 일치하는 경우에만 전시예매 50% 할인 쿠폰 지급, 해당 이벤트의 중복 참여를 방지하기 위해 이벤트 참여 회원의 수험번호를 db에 저장

**10) 챗봇**

<img width="907" alt="챗봇" src="https://user-images.githubusercontent.com/111713782/206958397-61d94768-8d61-4d29-9878-2dd64f1ffc27.PNG">

- 웹소켓: 접속되어 있는 서버간 통신가능 =>접속되어 있는 모든 사용자 사용가능
- Naver Cloud Platform의 CLOVA Chatbot 빌더 실행=> 대화목록 생성
- Websocket을 사용하여 관리자페이지에 서버 생성(관리자페이지의 서버에 소비자페이지를 접속시켜 기능 구현)  
- 등록된 질문 입력시 그에 해당되는 답변 전송(로그인 후 사용가능한 기능으로 구현하여 사용자의 이름을 상단과 채팅창에 출력하여 실제 채팅하는 환경 조성, 
연결상태를 한 눈에 볼 수 있도록 시작/종료 상태 알림)


<img width="120" height="30" alt="afav" src="https://user-images.githubusercontent.com/111713782/206620706-641f588a-cb24-4f06-81d8-17bb45c01b91.PNG">  

**1)회원가입 및 로그인&로그아웃** 
- 관리자 레벨에 따라 권한 다르게 부여 => A레벨 관리자(admin01)만 모든 정보조회 및 등록 가능

**2) 고객정보, 예매내역 조회 및 검색**  

**3) 관리자 정보 조회(수정/삭제)&등록**

**4) 전시 목록 조회(수정/삭제)&등록**

**5) 전시 일정 fullcalendar조회**

**6) 매출 차트**

**7) 페이징 처리 & 반응형 웹**


## 5. Troubleshooting

|  Name  |Issues|Problem solving|
|--|--|--| 
|--|..|..| 
|김서윤|..|..| 
|--|..|..| 
|--|..|..| 
|박재형|sql구문에 맞춰서 xml파일을 잘 맟춰야 원하는 정보가 나오는 것과 어떻게 정보를 화면에 출력하는지에 대해 이해가 완벽히 되었다. | 
