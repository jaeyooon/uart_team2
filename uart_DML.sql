-- customer(고객) table ---------------------------------------------------------
INSERT INTO customer VALUES('id01', 'pwd01', '박민준', '001010', '남', 'mjpark@naver.com','010-1234-5678', '2017-11-30', 1);
INSERT INTO customer VALUES('id02', 'pwd02', '이서연', '040907', '여', 'syleek@gmail.com','010-2534-1173', '2019-09-13', 1);
INSERT INTO customer VALUES('id03', 'pwd03', '강예준', '040425', '남', 'yjkang@naver.com','010-5436-6879', '2019-01-23', 1);
INSERT INTO customer VALUES('id04', 'pwd04', '최서현', '961212', '여', 'shchoi@daum.net','010-6678-9030', '2010-11-30', 0);
INSERT INTO customer VALUES('id05', 'pwd05', '이하준', '971110', '남', 'hjlee@naver.com','010-2298-1029', '2012-12-11', 1);
INSERT INTO customer VALUES('id06', 'pwd06', '박지민', '921013', '여', 'jmpark@gmail.com','010-4847-6902', '2010-01-08', 1);
INSERT INTO customer VALUES('id07', 'pwd07', '조우진', '641110', '남', 'wjcho@daum.net','010-2256-8612', '2000-10-22', 0);
INSERT INTO customer VALUES('id08', 'pwd08', '김연지', '040203', '여', 'yjkim@naver.com','010-1243-8765', '2021-03-05', 1);
INSERT INTO customer VALUES('id09', 'pwd09', '최연우', '881106', '남', 'ywchoi@gamil.com','010-0504-2245', '2020-02-08', 1);
INSERT INTO customer VALUES('id10', 'pwd10', '조하린', '900802', '여', 'hlcho@naver.com','010-6654-6879', '2010-11-11', 1);

SELECT * FROM customer;

-- cate(카테고리) table ---------------------------------------------------------
INSERT INTO cate VALUES(1, '미디어전시');
INSERT INTO cate VALUES(2, '체험형전시');
INSERT INTO cate VALUES(3, '개인전');
INSERT INTO cate VALUES(4, '특별전');
INSERT INTO cate VALUES(5, '공연예술');

SELECT*FROM cate;

-- item(상품) table ---------------------------------------------------------
INSERT INTO item VALUES(NULL, 1, 'GUSTAV KLIMT(구스타프 클림트)', 'img01.jpg', '빛의 시어터','서울특별시 광진구 워커힐로 177 그랜드워커힐 호텔앤리조트', '37.55496636787816' ,'127.11102799216009', '전체관람가',  '온라인수령', 200, '2022.05.27', '2023.03.05', '2022.02.12');
INSERT INTO item VALUES(NULL, 1, '골드베렌의 100번째 생일 기념전', 'img02.jpg', '안녕인사동 B1인사센트럴 뮤지엄','서울특별시 종로구 인사동길 49', '37.57447443356658' ,'126.98352625760418','전체관람가',  '온라인수령', 200, '2022.10.13', '2023.03.12', '2022.02.12');
INSERT INTO item VALUES(NULL, 1, 'POKÉMON THE DREAMING(포켓몬)', 'img03.jpg', '현대백화점 판교점 10층 토파즈홀','경기도 성남시 분당구 판교역로 146번길 20', '37.3926484929912' ,'127.11206705409401', '전체관람가',  '온라인수령', 200, '2022.10.07', '2022.11.30', '2022.02.12');
INSERT INTO item VALUES(NULL, 1, 'MONET INSIDE(모네)', 'img04.jpg', '그라운드시소 명동','서울특별시 중구 남대문로 73 에비뉴엘 9F','37.56472090184002' ,'126.98178531990453','전체관람가',  '온라인수령', 200, '2022.09.01', '2023.03.09', '2022.02.12');
INSERT INTO item VALUES(NULL, 1, '어린왕자 IN SEOUL', 'img05.jpg', '띠아트 홍대','서울특별시 마포구 와우산로21길 20-11', '37.5528060922814' ,'126.92269684219683','전체관람가',  '온라인수령', 200, '2022.06.03', '2022.12.31', '2022.02.12');
INSERT INTO item VALUES(NULL, 1, 'SPACE OF LIGHT AND MEMORY', 'img06.jpg', '여수 녹테마레','전라남도 여수시 만성로 294', '34.77451516416573', '127.72588113208423','전체관람가',  '온라인수령', 200, '2022.02.23', '2022.12.31', '2022.02.12');

INSERT INTO item VALUES(NULL, 2, '2022 대한민국 국향대전', 'img07.jpg', '함평엑스포공원','전라남도 함평군 함평읍 곤재로 27', '35.056352555598586' ,'126.52011712601204', '전체관람가', '온라인수령', 200, '2022.10.21', '2022.11.06', '2022.02.12');
INSERT INTO item VALUES(NULL, 2, 'Tape Seoul', 'img08.jpg', 'K현대미술관 2층','서울특별시 강남구 선릉로 807', '37.524427658385115' ,'127.03907671497953', '전체관람가', '온라인수령', 200, '2022.07.30', '2023.01.29', '2022.02.12');
INSERT INTO item VALUES(NULL, 2, 'Tube Seoul', 'img09.jpg', 'K현대미술관 2층','서울특별시 강남구 선릉로 807', '37.524427658385115' ,'127.03907671497953', '전체관람가', '온라인수령', 200, '2022.07.30', '2023.01.29', '2022.02.12');
INSERT INTO item VALUES(NULL, 2, 'VIVA ARTE', 'img10.jpg', '더현대 서울6층 ALT.1','서울특별시 영등포구 여의대로 108', '37.52581797837272' ,'126.9283924397105', '전체관람가', '온라인수령', 200, '2022.10.08', '2023.01.08', '2022.02.12');
INSERT INTO item VALUES(NULL, 2, 'LOGOUT(로그아웃)', 'img11.jpg', '뚝섬미술관','서울특별시 성동구 아차산로 33 삼일빌딩 B1F', '37.547183497832656' ,'127.04835646477147', '전체관람가', '온라인수령', 200, '2022.10.19', '2023.03.01', '2022.02.12');
INSERT INTO item VALUES(NULL, 2, '왓츠유어컬러 홍대', 'img12.jpg', '아이뮤지엄 젤리스','서울특별시 마포구 양화로 지하188 3F', '37.55780449558387' ,'126.9264095399382', '전체관람가', '온라인수령', 200, '2022.07.06', '2023.02.28', '2022.02.12');

INSERT INTO item VALUES(NULL, 3, 'FRANCO FONTANA:COLOR IN LIFE', 'img13.jpg', '마이아트 뮤지엄','서울특별시 강남구 테헤란로 518 섬유센터빌딩 B1F', '37.507592345149696' ,'127.06057975975207', '전체관람가', '온라인수령', 200, '2022.09.30', '2023.03.01', '2022.02.12');
INSERT INTO item VALUES(NULL, 3, 'Henri Matisse:Life and Joy', 'img14.jpg', '부산문화회관 전시실','부산광역시 남구 유엔평화로 76번길 1', '35.12739783209687' ,'129.0935485796624','전체관람가', '온라인수령', 200, '2022.07.09', '2023.10.30', '2022.02.12');
INSERT INTO item VALUES(NULL, 3, 'Road To Purple', 'img15.jpg', '스페이스K 서울','서울특별시 강서구 마곡중앙8로 32', '37.56111217525553' ,'126.83095153740605', '전체관람가', '온라인수령', 200, '2022.10.27', '2023.01.19', '2022.02.12');
INSERT INTO item VALUES(NULL, 3, '에릭요한슨전', 'img16.jpg', '63빌딩 아쿠아플라넷63','서울특별시 영등포구 63로 50', '37.51993875653349' , '126.94021623781514','전체관람가', '온라인수령', 200, '2022.09.29', '2022.10.31', '2022.02.12');
INSERT INTO item VALUES(NULL, 3, '장 줄리앙', 'img17.jpg', 'DDP배움터 디자인전시관','서울특별시 중구 을지로 281', '37.56732793680855' , '127.01087768691039','전체관람가', '온라인수령', 200, '2022.10.01', '2023.01.08', '2022.02.12');
INSERT INTO item VALUES(NULL, 3, 'NATALIE KARPUSHENKO', 'img18.jpg', '그라운드시소 성수','서울특별시 성동구 아차산로 17길 49 생각공장A동 B1F 111호', '37.54671359155754' , '127.0652820890506' ,'전체관람가', '온라인수령', 200, '2022.12.23', '2023.05.07', '2022.02.12');

INSERT INTO item VALUES(NULL, 4, '데미안', 'img19.jpg', 'K현대미술관 전시실 지하 1F/1.5F','서울특별시 강남구 선릉로 807', '37.524452440622824','127.03906258709115','전체관람가', '온라인수령', 200, '2022.06.08', '2022.12.08', '2022.02.12');
INSERT INTO item VALUES(NULL, 4, 'DINOBAY(다이노베이)', 'img20.jpg', '기흥리빙파워센터 4층','경기도 용인시 기흥구 신고매로 59', '37.22328122820267','127.11412862846856', '전체관람가', '온라인수령', 200, '2022.09.30', '2023.09.24', '2022.02.12');
INSERT INTO item VALUES(NULL, 4, 'DUBUFFET(뒤뷔페전)', 'img21.jpg', '올림픽공원 소마미술관 2관','서울특별시 송파구 위례성대로 51', '37.516903656406306' ,'127.11795643081663', '전체관람가', '온라인수령', 200, '2022.10.01', '2023.01.31', '2022.02.12');
INSERT INTO item VALUES(NULL, 4, '포토아크, 너의 이름은', 'img22.jpg', '북서울꿈의숲상상톡톡 미술관','서울특별시 강북구 월계로 173', '37.622542951990624','127.04139634646819', '전체관람가', '온라인수령', 200, '2022.10.18', '2022.11.27', '2022.02.12');
INSERT INTO item VALUES(NULL, 4, '에바알머슨 특별전', 'img23.jpg', '용산전쟁기념관 기획전시실','서울특별시 용산구 이태원로29', '37.537079698874564', '126.97704275907775', '전체관람가', '온라인수령', 200, '2022.05.13', '2022.12.04', '2022.02.12');
INSERT INTO item VALUES(NULL, 4, '합스부르크 600년, 매혹의 걸작들', 'img24.jpg', '국립중앙박물관 기획전시실','서울특별시 용산구 서빙고로 137', '37.52396168041694' ,'126.9801464256272', '전체관람가', '온라인수령', 200, '2022.10.25', '2023.03.01', '2022.02.12');

SELECT*FROM item;

-- review(리뷰) table ---------------------------------------------------------
INSERT INTO review VALUES (NULL, 100, 'id01', "너무나 유익한 전시에요", 5.0, '2022-01-30');
INSERT INTO review VALUES (NULL, 102,'id02', "동선이 복잡하고 전시된 작품들이 난잡해서 알아보기 힘들어요", 1.0, '2022-02-09');
INSERT INTO review VALUES (NULL, 103, 'id03', "마치 해외 박물관에 있는 기분입니다!", 5.0, '2022-03-08');
INSERT INTO review VALUES (NULL, 104, 'id05', "좋긴 한데 앉을 공간 없이 서 있어야 해서 힘들었습니다", 3.5, '2022-04-02');
INSERT INTO review VALUES (NULL, 105, 'id06', "나쁘지 않았습니다", 3.5, '2022-05-10');
INSERT INTO review VALUES (NULL, 107, 'id08', "전시 분위기가 좋았어요!", 4.0, '2022-06-30');
INSERT INTO review VALUES (NULL, 108, 'id09', "아이가 좋아해요.", 4.5, '2022-07-18');
INSERT INTO review VALUES (NULL, 109, 'id10', "전시 구성은 좋았습니다.", 3.5, '2022-08-27');
INSERT INTO review VALUES (NULL, 110, 'id01', "생기있고 호기심 넘치는 전시였어요.", 5.0, '2022-10-03');
INSERT INTO review VALUES (NULL, 114, 'id02', "마음에 힐링과 위로를 주는 전시였습니다!", 4.5, '2022-10-12');
INSERT INTO review VALUES (NULL, 116, 'id03', "기대에 못 미치는 전시였습니다..", 3.5, '2022-11-10');
INSERT INTO review VALUES (NULL, 118, 'id05', "전시 보는 것만으로도 행복했어요!!", 4.0, '2022-12-19');
INSERT INTO review VALUES (NULL, 120, 'id06', "기대만큼이나 만족스러운 전시였어요.", 5.0, '2022-12-27');

SELECT * FROM review;

-- wish(위시리스트) table ---------------------------------------------------------
INSERT INTO wish VALUES (NULL,'id01', 100, sysdate());
INSERT INTO wish VALUES (NULL,'id01', 109, sysdate());
INSERT INTO wish VALUES (NULL,'id02', 101, sysdate());
INSERT INTO wish VALUES (NULL,'id02', 110, sysdate());
INSERT INTO wish VALUES (NULL,'id03', 102, sysdate());
INSERT INTO wish VALUES (NULL,'id03', 111, sysdate());
INSERT INTO wish VALUES (NULL,'id05', 103, sysdate());
INSERT INTO wish VALUES (NULL,'id05', 112, sysdate());
INSERT INTO wish VALUES (NULL,'id06', 104, sysdate());
INSERT INTO wish VALUES (NULL,'id06', 113, sysdate());
INSERT INTO wish VALUES (NULL,'id08', 105, sysdate());
INSERT INTO wish VALUES (NULL,'id08', 114, sysdate());
INSERT INTO wish VALUES (NULL,'id09', 106, sysdate());
INSERT INTO wish VALUES (NULL,'id09', 115, sysdate());
INSERT INTO wish VALUES (NULL,'id10', 107, sysdate());
INSERT INTO wish VALUES (NULL,'id10', 116, sysdate());

SELECT * FROM wish;

-- itemoption(상품옵션) table ---------------------------------------------------------
INSERT INTO itemoption VALUES(NULL,100,'성인',20000,'청소년',20000,'어린이',20000);
INSERT INTO itemoption VALUES(NULL,101,'성인',20000,'청소년',20000,'어린이',20000);
INSERT INTO itemoption VALUES(NULL,102,'성인',20000,'청소년',20000,'어린이',20000);
INSERT INTO itemoption VALUES(NULL,103,'성인',20000,'청소년',20000,'어린이',20000);
INSERT INTO itemoption VALUES(NULL,104,'성인',20000,'청소년',20000,'어린이',20000);
INSERT INTO itemoption VALUES(NULL,105,'성인',20000,'청소년',20000,'어린이',20000);
INSERT INTO itemoption VALUES(NULL,106,'성인',29000,'청소년',27000,'어린이',20000);
INSERT INTO itemoption VALUES(NULL,107,'성인',29000,'청소년',27000,'어린이',20000);
INSERT INTO itemoption VALUES(NULL,108,'성인',29000,'청소년',27000,'어린이',20000);
INSERT INTO itemoption VALUES(NULL,109,'성인',29000,'청소년',27000,'어린이',20000);
INSERT INTO itemoption VALUES(NULL,110,'성인',29000,'청소년',27000,'어린이',20000);
INSERT INTO itemoption VALUES(NULL,111,'성인',29000,'청소년',27000,'어린이',20000);
INSERT INTO itemoption VALUES(NULL,112,'성인',17000,'청소년',15000,'어린이',10000);
INSERT INTO itemoption VALUES(NULL,113,'성인',17000,'청소년',15000,'어린이',10000);
INSERT INTO itemoption VALUES(NULL,114,'성인',17000,'청소년',15000,'어린이',10000);
INSERT INTO itemoption VALUES(NULL,115,'성인',17000,'청소년',15000,'어린이',10000);
INSERT INTO itemoption VALUES(NULL,116,'성인',17000,'청소년',15000,'어린이',10000);
INSERT INTO itemoption VALUES(NULL,117,'성인',17000,'청소년',15000,'어린이',10000);
INSERT INTO itemoption VALUES(NULL,118,'성인',17000,'청소년',15000,'어린이',10000);
INSERT INTO itemoption VALUES(NULL,119,'성인',17000,'청소년',15000,'어린이',10000);
INSERT INTO itemoption VALUES(NULL,120,'성인',17000,'청소년',15000,'어린이',10000);
INSERT INTO itemoption VALUES(NULL,121,'성인',17000,'청소년',15000,'어린이',10000);
INSERT INTO itemoption VALUES(NULL,122,'성인',17000,'청소년',15000,'어린이',10000);
INSERT INTO itemoption VALUES(NULL,123,'성인',17000,'청소년',15000,'어린이',10000);

SELECT * FROM itemoption;

-- orderlist(예매) table ---------------------------------------------------------
INSERT INTO orderlist VALUES (NULL, 100, 'id01', '2022-01-28', 1, 20000, '카카오페이', '010-8765-4321', '2022-02-28');
INSERT INTO orderlist VALUES (NULL, 106, 'id02', '2022-01-28', 4, 116000, '네이버페이', '010-9225-1345', '2022-02-28');
INSERT INTO orderlist VALUES (NULL, 112, 'id03', '2022-01-28', 2, 34000, '신용카드', '010-2589-7370', '2022-02-28');
INSERT INTO orderlist VALUES (NULL, 118, 'id05', '2022-01-28', 2, 30000, '카카오페이', '010-8691-1723', '2022-02-28');
INSERT INTO orderlist VALUES (NULL, 124, 'id06', '2022-01-28', 3, 15000, '네이버페이', '010-9223-9517', '2022-02-28');

INSERT INTO orderlist VALUES (NULL, 101, 'id09', '2022-02-05', 3, 60000, '카카오페이', '010-6523-2704', '2022-03-05');
INSERT INTO orderlist VALUES (NULL, 107, 'id10', '2022-02-05', 2, 54000, '네이버페이', '010-2589-8440', '2022-03-05');
INSERT INTO orderlist VALUES (NULL, 113, 'id01', '2022-02-05', 1, 15000, '신용카드', '010-2589-7370', '2022-03-05');
INSERT INTO orderlist VALUES (NULL, 119, 'id02', '2022-02-05', 4, 68000, '네이버페이', '010-9225-1345', '2022-03-05');
INSERT INTO orderlist VALUES (NULL, 125, 'id03', '2022-02-05', 3, 24000, '신용카드', '010-2589-7370', '2022-03-05');

INSERT INTO orderlist VALUES (NULL, 102, 'id05', '2022-03-05', 1, 20000, '카카오페이', '010-8691-1723', '2022-04-08');
INSERT INTO orderlist VALUES (NULL, 108, 'id06', '2022-03-05', 3, 60000, '네이버페이', '010-9223-9517', '2022-04-08');
INSERT INTO orderlist VALUES (NULL, 114, 'id08', '2022-03-05', 4, 40000, '신용카드', '010-5321-9287', '2022-04-08');
INSERT INTO orderlist VALUES (NULL, 120, 'id09', '2022-03-05', 4, 68000, '카카오페이', '010-6523-2704', '2022-04-08');
INSERT INTO orderlist VALUES (NULL, 126, 'id10', '2022-03-05', 5, 60000, '네이버페이', '010-2589-8440', '2022-04-08');

INSERT INTO orderlist VALUES (NULL, 103, 'id01', '2022-04-01', 2, 40000, '카카오페이', '010-8691-1723', '2022-05-04');
INSERT INTO orderlist VALUES (NULL, 109, 'id02', '2022-04-01', 3, 87000, '네이버페이', '010-9225-1345', '2022-05-04');
INSERT INTO orderlist VALUES (NULL, 115, 'id03', '2022-04-01', 1, 15000, '신용카드', '010-2589-7370', '2022-05-04');
INSERT INTO orderlist VALUES (NULL, 121, 'id05', '2022-04-01', 1, 17000, '카카오페이', '010-8691-1723', '2022-05-04');
INSERT INTO orderlist VALUES (NULL, 127, 'id06', '2022-04-01', 2, 16000, '네이버페이', '010-9223-9517', '2022-05-04');

INSERT INTO orderlist VALUES (NULL, 104, 'id09', '2022-05-01', 2, 40000, '카카오페이', '010-6523-2704', '2022-06-04');
INSERT INTO orderlist VALUES (NULL, 110, 'id10', '2022-05-01', 4, 108000, '네이버페이', '010-2589-8440', '2022-06-04');
INSERT INTO orderlist VALUES (NULL, 116, 'id01', '2022-05-01', 2, 54000, '카카오페이', '010-8691-1723', '2022-06-04');
INSERT INTO orderlist VALUES (NULL, 122, 'id02', '2022-05-01', 4, 40000, '네이버페이', '010-9225-1345', '2022-06-04');
INSERT INTO orderlist VALUES (NULL, 128, 'id03', '2022-05-01', 5, 25000, '신용카드', '010-2589-7370', '2022-06-04');

INSERT INTO orderlist VALUES (NULL, 105, 'id05', '2022-06-14', 2, 40000, '카카오페이', '010-2270-3599', '2022-07-17');
INSERT INTO orderlist VALUES (NULL, 111, 'id06', '2022-06-14', 2, 47000, '네이버페이', '010-1330-7813', '2022-07-17');
INSERT INTO orderlist VALUES (NULL, 117, 'id08', '2022-06-14', 2, 30000, '신용카드', '010-5321-9287', '2022-07-17');
INSERT INTO orderlist VALUES (NULL, 123, 'id09', '2022-06-14', 1, 17000, '카카오페이', '010-6523-2704', '2022-07-17');
INSERT INTO orderlist VALUES (NULL, 129, 'id10', '2022-06-14', 4, 32000, '네이버페이', '010-2589-8440', '2022-07-17');

INSERT INTO orderlist VALUES (NULL, 100, 'id03', '2022-07-14', 1, 20000, '신용카드', '010-1351-7813', '2022-08-17');
INSERT INTO orderlist VALUES (NULL, 106, 'id02', '2022-07-14', 5, 145000, '신용카드', '010-6767-4320', '2022-08-17');
INSERT INTO orderlist VALUES (NULL, 112, 'id03', '2022-07-14', 2, 34000, '카카오페이', '010-3519-7502', '2022-08-17');
INSERT INTO orderlist VALUES (NULL, 118, 'id05', '2022-07-14', 1, 10000, '카카오페이', '010-2270-3599', '2022-08-17');
INSERT INTO orderlist VALUES (NULL, 130, 'id06', '2022-07-14', 10, 84000, '네이버페이', '010-1330-7813', '2022-08-17');

INSERT INTO orderlist VALUES (NULL, 101, 'id09', '2022-08-19', 4, 60000, '카카오페이', '010-6523-2704', '2022-09-19');
INSERT INTO orderlist VALUES (NULL, 107, 'id10', '2022-08-19', 8, 224000, '카카오페이', '010-3519-7502', '2022-09-19');
INSERT INTO orderlist VALUES (NULL, 113, 'id06', '2022-08-19', 4, 60000, '신용카드', '010-1351-7813', '2022-09-19');
INSERT INTO orderlist VALUES (NULL, 119, 'id02', '2022-08-19', 8, 108000, '신용카드', '010-6767-4320', '2022-09-19');
INSERT INTO orderlist VALUES (NULL, 131, 'id03', '2022-08-19', 5, 50000, '신용카드', '010-1351-7813', '2022-09-19');

INSERT INTO orderlist VALUES (NULL, 102, 'id05', '2022-09-15', 2, 40000, '카카오페이', '010-2270-3599', '2022-10-15');
INSERT INTO orderlist VALUES (NULL, 108, 'id06', '2022-09-15', 6, 148000, '네이버페이', '010-1330-7813', '2022-10-15');
INSERT INTO orderlist VALUES (NULL, 114, 'id08', '2022-09-15', 12, 180000, '신용카드', '010-5321-9287', '2022-10-15');
INSERT INTO orderlist VALUES (NULL, 120, 'id09', '2022-09-15', 6, 88000, '카카오페이', '010-6523-2704', '2022-10-15');
INSERT INTO orderlist VALUES (NULL, 132, 'id10', '2022-09-15', 8, 80000, '네이버페이', '010-2589-8440', '2022-10-15');

INSERT INTO orderlist VALUES (NULL, 103, 'id03', '2022-10-03', 4, 80000, '신용카드', '010-1351-7813', '2022-11-06');
INSERT INTO orderlist VALUES (NULL, 109, 'id02', '2022-10-03', 12, 324000, '신용카드', '010-6767-4320', '2022-11-06');
INSERT INTO orderlist VALUES (NULL, 115, 'id03', '2022-10-03', 8, 136000, '카카오페이', '010-3519-7502', '2022-11-06');
INSERT INTO orderlist VALUES (NULL, 121, 'id10', '2022-10-03', 6, 102000, '카카오페이', '010-2270-3599', '2022-11-06');
INSERT INTO orderlist VALUES (NULL, 133, 'id06', '2022-10-03', 10, 55000, '네이버페이', '010-1330-7813', '2022-11-06');

INSERT INTO orderlist VALUES (NULL, 104, 'id09', '2022-11-03', 10, 200000, '카카오페이', '010-6523-2704', '2022-12-06');
INSERT INTO orderlist VALUES (NULL, 110, 'id10', '2022-11-03', 10, 290000, '네이버페이', '010-2589-8440', '2022-12-06');
INSERT INTO orderlist VALUES (NULL, 116, 'id03', '2022-11-03', 4, 51000, '신용카드', '010-1351-7813', '2022-12-06');
INSERT INTO orderlist VALUES (NULL, 122, 'id02', '2022-11-03', 10, 170000, '신용카드', '010-6767-4320', '2022-12-06');
INSERT INTO orderlist VALUES (NULL, 134, 'id06', '2022-11-03', 10, 100000, '카카오페이', '010-3519-7502', '2022-12-06');

INSERT INTO orderlist VALUES (NULL, 105, 'id05', '2022-12-11', 1, 20000, '카카오페이', '010-2270-3599', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 111, 'id06', '2022-12-11', 2, 58000, '네이버페이', '010-1330-7813', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 117, 'id08', '2022-12-11', 1, 17000, '신용카드', '010-5321-9287', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 123, 'id09', '2022-12-11', 1, 17000, '카카오페이', '010-6523-2704', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 135, 'id10', '2022-12-11', 10, 100000, '네이버페이', '010-2589-8440', '2023-01-21');

INSERT INTO orderlist VALUES (NULL, 105, 'id05', '2022-12-12', 1, 20000, '카카오페이', '010-2270-3599', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 111, 'id06', '2022-12-12', 4, 116000, '네이버페이', '010-1330-7813', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 117, 'id08', '2022-12-12', 2, 34000, '신용카드', '010-5321-9287', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 123, 'id09', '2022-12-12', 1, 17000, '카카오페이', '010-6523-2704', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 135, 'id10', '2022-12-12', 5, 50000, '네이버페이', '010-2589-8440', '2023-01-21');

INSERT INTO orderlist VALUES (NULL, 105, 'id05', '2022-12-13', 1, 20000, '카카오페이', '010-2270-3599', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 111, 'id06', '2022-12-13', 2, 58000, '네이버페이', '010-1330-7813', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 117, 'id08', '2022-12-13', 2, 34000, '신용카드', '010-5321-9287', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 123, 'id09', '2022-12-13', 1, 17000, '카카오페이', '010-6523-2704', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 135, 'id10', '2022-12-13', 6, 60000, '네이버페이', '010-2589-8440', '2023-01-21');

INSERT INTO orderlist VALUES (NULL, 105, 'id05', '2022-12-14', 2, 20000, '카카오페이', '010-2270-3599', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 111, 'id06', '2022-12-14', 2, 38000, '네이버페이', '010-1330-7813', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 117, 'id08', '2022-12-14', 2, 34000, '신용카드', '010-5321-9287', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 123, 'id09', '2022-12-14', 1, 17000, '카카오페이', '010-6523-2704', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 135, 'id10', '2022-12-14', 2, 15000, '네이버페이', '010-2589-8440', '2023-01-21');

INSERT INTO orderlist VALUES (NULL, 105, 'id05', '2022-12-15', 2, 40000, '카카오페이', '010-2270-3599', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 111, 'id06', '2022-12-15', 4, 116000, '네이버페이', '010-1330-7813', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 117, 'id08', '2022-12-15', 3, 51000, '신용카드', '010-5321-9287', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 123, 'id09', '2022-12-15', 2, 34000, '카카오페이', '010-6523-2704', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 135, 'id10', '2022-12-15', 2, 20000, '네이버페이', '010-2589-8440', '2023-01-21');

INSERT INTO orderlist VALUES (NULL, 105, 'id05', '2022-12-16', 1, 20000, '카카오페이', '010-2270-3599', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 111, 'id06', '2022-12-16', 2, 58000, '네이버페이', '010-1330-7813', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 117, 'id08', '2022-12-16', 1, 17000, '신용카드', '010-5321-9287', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 123, 'id09', '2022-12-16', 2, 34000, '카카오페이', '010-6523-2704', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 135, 'id10', '2022-12-16', 3, 30000, '네이버페이', '010-2589-8440', '2023-01-21');
INSERT INTO orderlist VALUES (NULL, 119, 'id01', '2022-12-15', 2, 20000, '네이버페이', '010-8765-4321', '2023-01-15');

SELECT * FROM orderlist;

-- orderdetail(예매내역) table ---------------------------------------------------------
INSERT INTO orderdetail VALUES (NULL, 1000, 100);
INSERT INTO orderdetail VALUES (NULL, 1001, 106);
INSERT INTO orderdetail VALUES (NULL, 1002, 112);
INSERT INTO orderdetail VALUES (NULL, 1003, 118);
INSERT INTO orderdetail VALUES (NULL, 1004, 124);
INSERT INTO orderdetail VALUES (NULL, 1005, 101);
INSERT INTO orderdetail VALUES (NULL, 1006, 107);
INSERT INTO orderdetail VALUES (NULL, 1007, 113);
INSERT INTO orderdetail VALUES (NULL, 1008, 119);
INSERT INTO orderdetail VALUES (NULL, 1009, 125);
INSERT INTO orderdetail VALUES (NULL, 1010, 102);
INSERT INTO orderdetail VALUES (NULL, 1011, 108);
INSERT INTO orderdetail VALUES (NULL, 1012, 114);
INSERT INTO orderdetail VALUES (NULL, 1013, 120);
INSERT INTO orderdetail VALUES (NULL, 1014, 126);
INSERT INTO orderdetail VALUES (NULL, 1015, 103);
INSERT INTO orderdetail VALUES (NULL, 1016, 109);
INSERT INTO orderdetail VALUES (NULL, 1017, 115);
INSERT INTO orderdetail VALUES (NULL, 1018, 121);
INSERT INTO orderdetail VALUES (NULL, 1019, 127);
INSERT INTO orderdetail VALUES (NULL, 1020, 104);
INSERT INTO orderdetail VALUES (NULL, 1021, 110);
INSERT INTO orderdetail VALUES (NULL, 1022, 116);
INSERT INTO orderdetail VALUES (NULL, 1023, 122);
INSERT INTO orderdetail VALUES (NULL, 1024, 128);
INSERT INTO orderdetail VALUES (NULL, 1025, 105);
INSERT INTO orderdetail VALUES (NULL, 1026, 111);
INSERT INTO orderdetail VALUES (NULL, 1027, 117);
INSERT INTO orderdetail VALUES (NULL, 1028, 123);
INSERT INTO orderdetail VALUES (NULL, 1029, 129);
INSERT INTO orderdetail VALUES (NULL, 1030, 100);
INSERT INTO orderdetail VALUES (NULL, 1031, 106);
INSERT INTO orderdetail VALUES (NULL, 1032, 112);
INSERT INTO orderdetail VALUES (NULL, 1033, 118);
INSERT INTO orderdetail VALUES (NULL, 1034, 130);
INSERT INTO orderdetail VALUES (NULL, 1035, 101);
INSERT INTO orderdetail VALUES (NULL, 1036, 107);
INSERT INTO orderdetail VALUES (NULL, 1037, 113);
INSERT INTO orderdetail VALUES (NULL, 1038, 119);
INSERT INTO orderdetail VALUES (NULL, 1039, 131);
INSERT INTO orderdetail VALUES (NULL, 1040, 102);
INSERT INTO orderdetail VALUES (NULL, 1041, 108);
INSERT INTO orderdetail VALUES (NULL, 1042, 114);
INSERT INTO orderdetail VALUES (NULL, 1043, 120);
INSERT INTO orderdetail VALUES (NULL, 1044, 132);
INSERT INTO orderdetail VALUES (NULL, 1045, 103);
INSERT INTO orderdetail VALUES (NULL, 1046, 109);
INSERT INTO orderdetail VALUES (NULL, 1047, 115);
INSERT INTO orderdetail VALUES (NULL, 1048, 121);
INSERT INTO orderdetail VALUES (NULL, 1049, 133);
INSERT INTO orderdetail VALUES (NULL, 1050, 104);
INSERT INTO orderdetail VALUES (NULL, 1051, 110);
INSERT INTO orderdetail VALUES (NULL, 1052, 116);
INSERT INTO orderdetail VALUES (NULL, 1053, 122);
INSERT INTO orderdetail VALUES (NULL, 1054, 134);
INSERT INTO orderdetail VALUES (NULL, 1055, 105);
INSERT INTO orderdetail VALUES (NULL, 1056, 111);
INSERT INTO orderdetail VALUES (NULL, 1057, 117);
INSERT INTO orderdetail VALUES (NULL, 1058, 123);
INSERT INTO orderdetail VALUES (NULL, 1059, 135);

INSERT INTO orderdetail VALUES (NULL, 1060, 105);
INSERT INTO orderdetail VALUES (NULL, 1061, 111);
INSERT INTO orderdetail VALUES (NULL, 1062, 137);
INSERT INTO orderdetail VALUES (NULL, 1063, 123);
INSERT INTO orderdetail VALUES (NULL, 1064, 135);
INSERT INTO orderdetail VALUES (NULL, 1065, 105);
INSERT INTO orderdetail VALUES (NULL, 1066, 111);
INSERT INTO orderdetail VALUES (NULL, 1067, 117);
INSERT INTO orderdetail VALUES (NULL, 1068, 123);
INSERT INTO orderdetail VALUES (NULL, 1069, 135);
INSERT INTO orderdetail VALUES (NULL, 1070, 105);
INSERT INTO orderdetail VALUES (NULL, 1071, 111);
INSERT INTO orderdetail VALUES (NULL, 1072, 117);
INSERT INTO orderdetail VALUES (NULL, 1073, 123);
INSERT INTO orderdetail VALUES (NULL, 1074, 135);
INSERT INTO orderdetail VALUES (NULL, 1075, 105);
INSERT INTO orderdetail VALUES (NULL, 1076, 111);
INSERT INTO orderdetail VALUES (NULL, 1077, 117);
INSERT INTO orderdetail VALUES (NULL, 1078, 123);
INSERT INTO orderdetail VALUES (NULL, 1079, 135);
INSERT INTO orderdetail VALUES (NULL, 1080, 105);
INSERT INTO orderdetail VALUES (NULL, 1081, 111);
INSERT INTO orderdetail VALUES (NULL, 1082, 117);
INSERT INTO orderdetail VALUES (NULL, 1083, 123);
INSERT INTO orderdetail VALUES (NULL, 1084, 135);
INSERT INTO orderdetail VALUES (NULL, 1085, 119); 

SELECT * FROM orderdetail;

-- eventbl(이벤트) table ---------------------------------------------------------
INSERT INTO eventbl VALUES (NULL,'id10', '2022-11-17', '2022-12-31', '수험표 인증시, 전시 50% 할인!','sevent.png', 50, '2022-11-18', 1);

SELECT * FROM eventbl;

-- emanage(수험생 이벤트 관리) table ---------------------------------------------------------
INSERT INTO emanage VALUES ('12349876', '2022-11-05');

SELECT * FROM emanage;

-- admintbl(관리자) table ---------------------------------------------------------
INSERT INTO admintbl VALUES ('admin01', 'pwd01', 'Josh', 'rtfgh13456@uart.com' , '010-5234-4782' ,'A');
INSERT INTO admintbl VALUES ('admin02', 'pwd02', 'Cho', 'jycho0208@uart.com', '010-3782-1922' , 'I');
INSERT INTO admintbl VALUES ('admin03', 'pwd03', 'Kim', 'sykim0405@uart.com' , '010-9543-8932' , 'B');
INSERT INTO admintbl VALUES ('admin04', 'pwd04', 'Lee', 'hjlee0722@uart.com' , '010-4518-1989' , 'B');
INSERT INTO admintbl VALUES ('admin05', 'pwd05', 'Park', 'pjh7265@uart.com' , '010-5023-7265' , 'B');
INSERT INTO admintbl VALUES ('admin06', 'pwd06', 'Won', 'jwcho0131@uart.com' , '010-8911-9304' , 'B');

SELECT * from admintbl;

