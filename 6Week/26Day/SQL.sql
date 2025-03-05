-- 중복 제거
SELECT DISTINCT COUNTRY 
FROM CUSTOMERS
;

-- 집계 함수
SELECT COUNT(DISTINCT COUNTRY) 
FROM CUSTOMERS
;

SELECT COUNT(COUNTRY)
FROM 
( -- 서브 쿼리
SELECT DISTINCT COUNTRY
FROM CUSTOMERS
) AS C
;

SELECT *
FROM CUSTOMERS
WHERE 1=1
AND CUSTOMERID > 80;

SELECT *
FROM PRODUCTS
WHERE PRICE BETWEEN 50 AND 60
;

SELECT *
FROM CUSTOMERS
WHERE 
CITY IN ('Paris', 'London') -- or 과 같음
;

SELECT *
FROM CUSTOMERS
ORDER BY COUNTRY asc, customername desc
-- desc 내림차순 asc 오름차순
;

SELECT *
FROM CUSTOMERS
WHERE CUSTOMERNAME LIKE 'a%' -- 한 글자 이상의 글자가 아무거나 들어와도 됨
;

SELECT *
FROM CUSTOMERS
WHERE city LIKE 'l_nd__' -- _를 사용 시 한 글자가 아무거나 들어와도됨
;

SELECT *
FROM CUSTOMERS
WHERE
COUNTRY = 'Spain'
and 
(
customername like 'G%'
or customername like 'R%'
)
;

SELECT CUSTOMERNAME, CONTACTNAME, ADDRESS
FROM CUSTOMERS
WHERE ADDRESS IS NOT NULL
;

SELECT *
FROM CUSTOMERS
LIMIT 3
;

SELECT MAX(PRICE) AS MAX
FROM PRODUCTS
;

SELECT MIN(PRICE) AS MIN
	 , CATEGORYID
FROM PRODUCTS
GROUP BY CATEGORYID
;

-- INNER JOIN 기본 조인
SELECT O.ORDERID, O.ORDERDATE, O.CUSTOMERID, C.CUSTOMERNAME
FROM ORDERS AS O
JOIN CUSTOMERS AS C
ON (O.CUSTOMERID = C.CUSTOMERID)
;

-- LEFT JOIN ORDERS를 기준으로 조인이 됨 고객 정보이 없는 주문도 표시(비회원 주문 같은거?)
SELECT O.ORDERID, O.ORDERDATE, O.CUSTOMERID, C.CUSTOMERNAME
FROM ORDERS AS O
LEFT JOIN CUSTOMERS AS C
ON (O.CUSTOMERID = C.CUSTOMERID)
;

-- RIGHT JOIN CUSTOMERS를 기준으로 조인이 됨 주믄을 하지않아도 모든 고객이 표시
SELECT O.ORDERID, O.ORDERDATE, O.CUSTOMERID, C.CUSTOMERNAME
FROM ORDERS AS O
RIGHT JOIN CUSTOMERS AS C
ON (O.CUSTOMERID = C.CUSTOMERID)
;
