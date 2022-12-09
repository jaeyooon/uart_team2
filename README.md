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
|김서윤|위시리스트 DB 구축 및 CRUD 설계<br>주문페이지, 위시리스트 추가/중복방지/삭제<br>관리자메인페이지 매출 차트 전체, 실시간 서버시간, 가입자수, 리뷰별 추천전시 |
|조재원| 고객 & 티켓 DB 구축 및 CRUD 설계<br>sns공유하기_카카오api<br>소비자&관리자 login/logout 및 조회/수정/탈퇴<br>FAQ, 한줄평, @media작업, favicon|
|이현지|상품 & 카테고리 DB 구축 및 CRUD 설계<br>챗봇_CLOVA Chatbot<br>검색기능_Autocomplete<br>소비자 메인, 전시목록, 상세정보페이지<br>관리자페이지 전시목록 조회/등록/수정/삭제|
|박재형|Marker & 리뷰 & 이벤트 DB 구축 및 CRUD 설계<br>지도API_장소안내<br>소비자&관리자 회원가입
  
## 3. 프로젝트 수행 방법 및 도구 
✨**시스템 구성도**  

✨**개발 환경 및 수행 도구**

|개발도구|협업도구|언어|웹|DB|프레임워크|API|라이브러리|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|Eclipse|Zoom<br>Github<br>ERD Cloud<br>Google Docs<br>Naver Band|Java<br>SQL|HTML<br>CSS<br>JS<br>jQuery<br>Ajax<br>Bootstrap<br>Thymeleaf|MySQL|Spring Boot<br>MyBatis|API로그인<br>Naver OCR<br>Naver Chatbot<br>Kakao Map<br>i'mport|Fullcalendar<br>Autocomplete|

✨**DB 설계**

<img width="550" alt="ERD최종" src="https://user-images.githubusercontent.com/111713782/206343172-b33ae936-56e1-4e92-a82d-7237596124b5.PNG">

✨**UI 설계**

<img width="933" alt="통합UI" src="https://user-images.githubusercontent.com/111713782/206375750-e2ce8aac-66f5-427b-97c1-596ae4f5ae28.PNG">

## 4. 프로젝트 구현 기능

<img width="80" height="30" alt="fav" src="https://user-images.githubusercontent.com/111713782/206620993-70808226-5ae0-478e-82c5-41bb216121b2.png">  


<img width="120" height="30" alt="afav" src="https://user-images.githubusercontent.com/111713782/206620706-641f588a-cb24-4f06-81d8-17bb45c01b91.PNG">  


## 5. Troubleshooting

|Issues|Problem solving|
|--|--| 
|..|..| 
|..|..| 
|..|..| 
|..|..| 
|박재형|sql구문에 맞춰서 xml파일을 잘 맟춰야 원하는 정보가 나오는 것과 어떻게 정보를 화면에 출력하는지에 대해 이해가 완벽히 되었다. | 
