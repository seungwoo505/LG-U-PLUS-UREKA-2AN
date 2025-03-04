CREATE DATABASE TESTDB; -- DB 생성

SHOW DATABASES; -- DB 보기

DROP DATABASE TESTDB; -- DB 제거

USE UREKA; -- 해당 스키마로 변경

-- user 생성
CREATE USER 'ureca'@'%' IDENTIFIED BY 'ureca';
GRANT ALL PRIVILEGES ON *.* TO 'ureca'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

-- 스키마에 테이블 생성
CREATE TABLE PRODUCT(
NAME VARCHAR(50),
PRICE INT
);

-- 테이블 조회
SELECT *
FROM PRODUCT
;

CREATE TABLE PERSONS(
PERSON_ID INT,
LASTNAME VARCHAR(255),
FIRSTNAME VARCHAR(255),
ADDRESS VARCHAR(255),
CITY VARCHAR(255)
);

-- 컬럼 생성
ALTER TABLE PRODUCT
ADD SIZE INT;

-- 컬럼 제거
ALTER TABLE PRODUCT
DROP COLUMN SIZE;

-- row 추가
INSERT INTO MEMBER
VALUES('이승우', 27)
;

INSERT INTO MEMBER(AGE, NAME)
VALUES(20, '홍길동')
;

SELECT *
FROM MEMBER
;

-- 이미 생성된 ROW 때문에 추가 불가(ID를 생성과 함께 기본키로 지정하는데 이미있는 ROW는 NULL로 가기에 설정 불가)
ALTER TABLE `ureka`.`member` 
ADD COLUMN `ID` VARCHAR(45) NOT NULL AFTER `age`,
ADD COLUMN `PW` VARCHAR(45) NOT NULL AFTER `ID`,
CHANGE COLUMN `name` `name` VARCHAR(50) NOT NULL ,
CHANGE COLUMN `age` `age` INT NOT NULL ,
ADD PRIMARY KEY (`ID`);
;

-- CREATE TABLE 했을 당시처럼 초기화 상태로 만듬 (rollback을 해도 안 살아난다)
TRUNCATE TABLE MEMBER;

-- TABLE 제거 (rollback을 해도 안 살아난다)
DROP TABLE MEMBER;

-- 조건에 해당하는 것만 표시
SELECT *
FROM MEMBER
WHERE
AGE = 20
;

-- row를 제거
delete from member;

-- transaction 시작하고 rollback을 하면 북구 가능
start transaction;

delete from member;

rollback; -- 반영하지않고 시작 시점으로 복구

commit; -- 반영

-- 특정 컬럼에 내용을 변경
UPDATE MEMBER
SET AGE = 20
;

-- id가 b에 해당하는 row에 name을 전은수로 변경
UPDATE MEMBER
SET NAME = '전은수'
WHERE ID = 'b' 
;
