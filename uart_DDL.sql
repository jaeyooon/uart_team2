DROP DATABASE IF EXISTS uartdb;
CREATE DATABASE uartdb;

USE uartdb;

-- customer(고객) table ---------------------------------------------------------
DROP TABLE IF EXISTS customer;
CREATE TABLE customer(
   custid VARCHAR(100),
    pwd VARCHAR(10),
    cname VARCHAR(30) NOT NULL,
    birth VARCHAR(10),
    gender VARCHAR(20),
    email VARCHAR(30),
    phone VARCHAR(20),
    custdate DATE,
    withdrawal INT
);

ALTER TABLE customer ADD CONSTRAINT PRIMARY KEY(custid);

-- cate(카테고리) table ---------------------------------------------------------
DROP TABLE IF EXISTS cate;
CREATE TABLE cate(
cateid INT,
catename VARCHAR(20)
);

ALTER TABLE cate ADD CONSTRAINT PRIMARY KEY(cateid);

-- item(상품) table ---------------------------------------------------------
DROP TABLE IF EXISTS item;
CREATE TABLE item(
itemid INT,
cateid INT,
itemname VARCHAR(500),
itemimg VARCHAR(100),
itemplace VARCHAR(50),
itemplace_address VARCHAR(100),
lat DOUBLE,
lng DOUBLE,
itemguide VARCHAR(20),
itemticket VARCHAR(20),
itemstock INT,
estart DATE,
efin DATE,
rdate DATE
);

ALTER TABLE item ADD CONSTRAINT PRIMARY KEY(itemid);
-- ALTER TABLE item ADD FOREIGN KEY(cateid) REFERENCES cate(cateid);
ALTER TABLE item MODIFY itemid INT AUTO_INCREMENT;
ALTER TABLE item AUTO_INCREMENT=100;

-- review(리뷰) table ---------------------------------------------------------
DROP TABLE IF EXISTS review;
CREATE TABLE review(
    reviewid INT,
    itemid INT,
    custid VARCHAR(100),
    reviewcontent VARCHAR(100),
    reviewgrade DOUBLE,
    reviewdate Date
);

ALTER TABLE review ADD CONSTRAINT PRIMARY KEY (reviewid);
-- ALTER TABLE review ADD CONSTRAINT FOREIGN KEY (itemid) REFERENCES item (itemid);
-- ALTER TABLE review ADD CONSTRAINT FOREIGN KEY (custid) REFERENCES customer (custid);
ALTER TABLE review MODIFY reviewid INT AUTO_INCREMENT;
ALTER TABLE review AUTO_INCREMENT = 10;

-- wish(위시리스트) table ---------------------------------------------------------
DROP TABLE IF EXISTS wish;
CREATE TABLE wish(
wishid INT,
custid VARCHAR(100),
itemid INT,
wishdate DATETIME
);

ALTER TABLE wish ADD CONSTRAINT PRIMARY KEY (wishid);
-- ALTER TABLE wish ADD CONSTRAINT FOREIGN KEY (itemid) REFERENCES item (itemid);
-- ALTER TABLE wish ADD CONSTRAINT FOREIGN KEY (custid) REFERENCES customer (custid);
ALTER TABLE wish MODIFY wishid INT AUTO_INCREMENT;
ALTER TABLE wish AUTO_INCREMENT = 20;

-- itemoption(상품옵션) table ---------------------------------------------------------
DROP TABLE IF EXISTS itemoption;
CREATE TABLE itemoption(
    optionid INT,
    itemid INT ,
    obj1 VARCHAR(10) ,
    price1 INT,
    obj2 VARCHAR(10) ,
    price2 INT ,
    obj3 VARCHAR(10),
    price3 INT 
);

ALTER TABLE itemoption ADD CONSTRAINT PRIMARY KEY(optionid);
ALTER TABLE itemoption MODIFY optionid INT AUTO_INCREMENT;
ALTER TABLE itemoption AUTO_INCREMENT = 30;
ALTER TABLE itemoption ADD CONSTRAINT CHECK (price1 > 0);
ALTER TABLE itemoption ADD CONSTRAINT CHECK (price2 > 0);
ALTER TABLE itemoption ADD CONSTRAINT CHECK (price3 > 0);
-- ALTER TABLE itemoption ADD CONSTRAINT FOREIGN KEY(itemid) REFERENCES item(itemid);

-- orderlist(예매) table ---------------------------------------------------------
DROP TABLE IF EXISTS orderlist;
CREATE TABLE orderlist (
orderlistid INT,
itemid INT NOT NULL,
custid VARCHAR(100) NOT NULL,
orderdate DATE NOT NULL,
ordercnt INT NOT NULL,
totalprice INT NOT NULL,
pay VARCHAR(20) NOT NULL,
phone2 VARCHAR(20),
candate DATE
);

ALTER TABLE orderlist ADD CONSTRAINT PRIMARY KEY (orderlistid);
-- ALTER TABLE orderlist ADD CONSTRAINT FOREIGN KEY (itemid) REFERENCES item (itemid);
-- ALTER TABLE orderlist ADD CONSTRAINT FOREIGN KEY (custid) REFERENCES customer (custid);
ALTER TABLE orderlist MODIFY orderlistid INT AUTO_INCREMENT;
ALTER TABLE orderlist AUTO_INCREMENT = 1000;
ALTER TABLE orderlist ADD CONSTRAINT CHECK (totalprice > 0);

-- orderdetail(예매내역) table ---------------------------------------------------------
DROP TABLE IF EXISTS orderdetail;
CREATE TABLE orderdetail (
orderdetailid INT,
orderlistid INT NOT NULL,
itemid INT NOT NULL
);

ALTER TABLE orderdetail ADD CONSTRAINT PRIMARY KEY (orderdetailid);
-- ALTER TABLE orderdetail ADD CONSTRAINT FOREIGN KEY (orderlistid) REFERENCES orderlist (orderlistid);
-- ALTER TABLE orderdetail ADD CONSTRAINT FOREIGN KEY (ticketid) REFERENCES ticket (ticketid);
ALTER TABLE orderdetail MODIFY orderdetailid INT AUTO_INCREMENT;
ALTER TABLE orderdetail AUTO_INCREMENT = 40;

-- eventbl(이벤트) table ---------------------------------------------------------
DROP TABLE IF EXISTS eventbl;
CREATE TABLE eventbl(
    eid INT,
    custid VARCHAR(100),
    sdate DATE, 
    fdate DATE,
    content VARCHAR(100),
    image VARCHAR(50),
    sale INT,
    pdate DATE,
    sort INT
);

ALTER TABLE eventbl ADD CONSTRAINT PRIMARY KEY (eid);
ALTER TABLE eventbl MODIFY eid INT AUTO_INCREMENT;
ALTER TABLE eventbl AUTO_INCREMENT = 50;

-- emanage(수험생 이벤트 관리) table ---------------------------------------------------------
DROP TABLE IF EXISTS emanage;
CREATE TABLE emanage(
    tnumber VARCHAR(50),
    rdate DATE NOT NULL
);

ALTER TABLE emanage ADD CONSTRAINT PRIMARY KEY (tnumber);

-- admintbl(관리자) table ---------------------------------------------------------
DROP TABLE IF EXISTS admintbl;
CREATE TABLE admintbl(
   adminid VARCHAR(10),
   adminpwd VARCHAR(20),
  aname VARCHAR(100),
   ademail VARCHAR(20),
   adphone VARCHAR(20),
   lev VARCHAR(30)
);

ALTER TABLE admintbl ADD CONSTRAINT PRIMARY KEY (adminid);











