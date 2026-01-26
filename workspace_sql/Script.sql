SELECT * FROM emp;

SELECT empno, ename, deptno FROM emp;
SELECT empno, deptno FROM emp;
SELECT deptno FROM emp;

SELECT 
	sal,
	ename,
	123,
	'문자eng123'
FROM emp;

SELECT DISTINCT deptno FROM emp;
SELECT DISTINCT job FROM emp;

SELECT ename, sal, sal*12+comm, comm FROM emp;
SELECT ename, sal, sal*12+comm AS ANNSAL, comm FROM emp;
SELECT ename, sal, sal*12+comm AS "ANN SAL", comm FROM emp;
SELECT ename, sal, sal*12+comm ANNSAL, comm FROM emp;
SELECT ename name FROM emp;
SELECT ename AS name FROM emp;
SELECT ename AS 이름 FROM emp;

SELECT * FROM EMP 
ORDER BY sal;

SELECT * FROM EMP
ORDER BY sal ASC;

SELECT * FROM EMP
ORDER BY sal DESC;

SELECT * FROM emp
ORDER BY empno DESC;

SELECT * FROM emp
ORDER BY deptno, sal, empno;

SELECT * FROM emp
ORDER BY deptno ASC, sal desc, empno;

SELECT DISTINCT job FROM EMP;

SELECT empno AS EMPLOYEE_NO, ename EMPLOYEE_NAME FROM emp
ORDER BY deptno DESC, ename asc;

SELECT * 
	FROM EMP
WHERE deptno = 30;

SELECT * 
	FROM EMP
WHERE deptno = 30
	AND job = 'SALESMAN';

SELECT * 
	FROM EMP
WHERE empno = 7499
	AND deptno = 30;

SELECT * 
	FROM EMP
WHERE mgr = 7839
	AND deptno = 20;

SELECT * 
	FROM EMP
WHERE deptno = 30
	or job = 'CLERK';

SELECT *
	FROM EMP
WHERE 
	deptno = 30
	OR deptno = 20
	AND job = 'CLERK';

SELECT *
	FROM EMP
WHERE 
	(deptno = 30
	OR deptno = 20)
	AND job = 'CLERK';

-- 한줄 주석
/*
	범위 주석
*/

SELECT * 
	FROM EMP
WHERE sal * 12 = 36000;

SELECT * 
	FROM EMP
WHERE sal >= 3000;

SELECT * 
	FROM EMP
WHERE sal >= 2500
	AND job = 'ANALYST';

SELECT *
	FROM EMP
WHERE sal != 3000;

SELECT *
	FROM EMP
WHERE sal <> 3000;

SELECT * 
	FROM EMP
WHERE NOT sal = 3000;

SELECT * 
	FROM EMP
WHERE NOT sal <= 3000;

-- ctrl + / 주석처리 단축키

-- 문제1 급여가 1500 이상이고 3000 미만인 사원을 출력
SELECT * 
	FROM EMP
WHERE sal >= 1500
	AND sal < 3000;

-- 문제2 job이 CLERK 이거나 급여가 2000 초과 이면서 부서번호 10번인 사원 출력
SELECT *
	FROM EMP
WHERE job = 'CLERK'
	OR sal > 2000
	AND deptno = 10;

-- 문제2 괄호 연습
SELECT *
	FROM EMP
WHERE (job = 'CLERK'
	OR sal > 2000)
	AND deptno = 10;

SELECT *
	FROM EMP
WHERE job = 'CLERK'
	AND (sal > 2000
	OR deptno = 10);

-- 문제3 deptno가 10 또는 20인 모든 사원
SELECT *
	FROM EMP
WHERE deptno = 10
	OR deptno = 20;

-- 문제4 부서번호가 20또는 30인 사원 중에서 급여가 2000~3000 사이(포함)인 사람의
-- 연봉이 작은 순으로 출력. 단, 연봉이 같은 경우 이름이 빠른 순으로 정렬하여 출력
SELECT * 
	FROM EMP
WHERE (deptno = 20
	OR deptno = 30)
	AND sal >= 2000
	AND sal <= 3000
ORDER BY sal, ename;

SELECT *
	FROM EMP
WHERE job IN ('MANAGER', 'SALESMAN', 'CLERK');

SELECT *
	FROM EMP
WHERE deptno IN (10, 20);

SELECT *
	FROM EMP
WHERE deptno NOT IN (10, 20);

SELECT *
	FROM EMP
WHERE sal BETWEEN 2000 AND 3000; /* 이상 이하만 표현*/

SELECT *
	FROM EMP
WHERE sal NOT BETWEEN 2000 AND 3000;

--2000 이상이고 3000 이하 
--2000 >= sal and sal <= 3000
--2000 미만이거나 3000 초과
--NOT (2000 >= sal and sal <= 3000)
--2000 < sal OR sal > 3000

SELECT *
	FROM EMP
WHERE (sal BETWEEN 2000 AND 3000)
	AND deptno = 30;

SELECT *
	FROM EMP
WHERE ename LIKE 'S%';

SELECT *
	FROM EMP
WHERE ename LIKE '%N';

SELECT *
	FROM EMP
WHERE ename LIKE '_L%';

SELECT *
	FROM EMP
WHERE ename LIKE '_____';

SELECT *
	FROM EMP
WHERE ename LIKE '%';

SELECT *
	FROM EMP
WHERE ename LIKE '%AM%';

SELECT *
	FROM EMP
WHERE ename NOT LIKE '%AM%';

SELECT *
	FROM EMP
WHERE ename LIKE 'S%'
	OR ename LIKE '%AM%';

SELECT *
	FROM EMP
WHERE ename LIKE '%A%S%';

SELECT comm FROM EMP;

SELECT *
	FROM EMP
WHERE comm = NULL;

SELECT *
	FROM EMP
WHERE comm IS NULL;

SELECT *
	FROM EMP
WHERE comm IS NOT NULL;

SELECT *
	FROM EMP
WHERE mgr IS NOT NULL;

-- 복습
SELECT * FROM EMP
ORDER BY ename;

SELECT ename name, job, sal money, sal*12+comm AS "H A P P Y"
	FROM EMP
WHERE (mgr IS NOT NULL
	OR comm IS NOT NULL)
	AND job IN ('CLERK', 'MANAGER', 'SALESMAN')
	AND sal BETWEEN 900 AND 2700
	AND ename LIKE '%A%'
	AND NOT ename LIKE 'J%'
	OR job = 'PRESIDENT'
ORDER BY sal desc, ename ASC;

SELECT ename 
	FROM EMP
WHERE ename BETWEEN 'ALLEN' AND 'King'
ORDER BY ename;

SELECT DISTINCT job FROM emp
ORDER BY job;

SELECT * FROM EMP
WHERE deptno = 10;  -- 3명
SELECT * FROM EMP
WHERE deptno = 20;  -- 5명

SELECT * FROM EMP
WHERE deptno = 10
UNION 
SELECT * FROM EMP
WHERE deptno = 20;

SELECT empno, ename, sal, deptno 
	FROM EMP
WHERE deptno = 10
UNION
SELECT sal, job, deptno, sal 
	FROM EMP
WHERE deptno = 20;

SELECT empno, ename, sal, deptno
	FROM emp
WHERE deptno = 10
UNION
SELECT empno, ename, sal, deptno
	FROM emp
WHERE deptno = 10;

SELECT empno, ename, sal, deptno
	FROM emp
WHERE deptno = 10
UNION ALL
SELECT empno, ename, sal, deptno
	FROM emp
WHERE deptno = 10;

-- 되새김 문제

-- 문제1
SELECT * FROM emp
WHERE ename LIKE '%S';

-- 문제2
SELECT empno, ename, job, sal, deptno
	FROM EMP
WHERE deptno = 30
	AND job = 'SALESMAN';

-- 문제3

-- 집합 연산자 사용
SELECT empno, ename, job, sal, deptno
	FROM EMP
WHERE deptno IN (20, 30)
	AND sal > 2000;

-- 집합연산자 사용 안함
SELECT empno, ename, job, sal, deptno
	FROM EMP
WHERE deptno = 20
	AND sal > 2000
UNION ALL
SELECT empno, ename, job, sal, deptno
	FROM EMP
WHERE deptno = 30
	AND sal > 2000;

-- 문제4
SELECT * FROM EMP
WHERE NOT (2000 <= sal AND sal <= 3000);

-- 문제5
SELECT ename, empno, sal, deptno
	FROM EMP
WHERE ename LIKE '%E%'
	AND deptno = 30
	AND sal NOT BETWEEN 1000 AND 2000;

-- 문제6
SELECT * FROM EMP
WHERE comm IS NULL
	AND mgr IS NOT NULL
	AND job IN ('MANAGER', 'CLERK')
	AND ename NOT LIKE '_L%';

-- 함수 part

SELECT ename, upper(ename), lower(ename), initcap(ename)
	FROM emp;

SELECT 1 FROM dual;

SELECT upper('aBc') FROM dual;
SELECT lower('aBc') FROM dual;
SELECT initcap('aBc') FROM dual;

SELECT upper(lower('aBc')) FROM dual;

-- 검색에 적용(ex.사용자는 대소문자 구분 없이 검색함)
SELECT * FROM emp
WHERE ename LIKE upper('%aM%');

SELECT * FROM emp
WHERE lower(ename) LIKE lower('%aM%');

SELECT ename, length(ename)
	FROM emp;

SELECT * FROM EMP
WHERE length(ename) = 5;

SELECT * FROM EMP
WHERE length(job) = 7;

-- 복습
SELECT upper(ename) AS "NAME", lower(ename) "name", initcap(ename) "Name"
	FROM EMP
WHERE comm IS NULL 
	AND (lower(ename) NOT LIKE ('_l%')
	OR length(ename) = 6)
UNION ALL
SELECT ename, ename, ename FROM emp
WHERE length(job) > 5
ORDER BY "NAME" ASC;
--

SELECT LENGTH('a'), length('한'), lengthb('a'), lengthb('한') FROM dual;

SELECT 
	job, 
	substr(job, 1, 2), 
	substr(job, 2, 3),
	substr(job, 5) 
FROM emp;

SELECT ename FROM EMP;
SELECT substr(ename, 2, 3) FROM EMP;
SELECT substr(ename, 2, 30) FROM EMP; -- 마지막 숫자가 크면 끝까지만 출력
SELECT substr(ename, 20, 3) FROM EMP; -- 실제 길이보다 범위를 넘어가면 NULL
SELECT substr(ename, -3, 2) FROM EMP; -- 뒤에서 부터 2글자 ex) CLERK 의 경우 앞에서 부터 -5 -4 -3 -2 -1
SELECT substr(ename, -30, 2) FROM EMP; -- 범위를 넘어간 경우 NULL 출력
SELECT substr(ename, LENGTH(ename)-2,2) FROM emp;  -- length를 활용한 방식도 가능
SELECT substr(ename, 2, -2) FROM EMP; -- NULL 출력

-- replace('대상', 바뀔문자, 바꿀문자)
-- '모든' 바뀔문자를 바꿀문자로 변경
SELECT 'a-b-c' AS replace_before,
	replace('a-b-c', '-', ' ') AS replace_1,
	replace('a-b-c', '-') AS replace_2
FROM dual;

-- 사원 이름의 A를 모두 '*'로 교체
SELECT ename,
	replace(ename, 'A', '*') AS REPLACE_name
FROM emp;

SELECT ename,
	lpad(ename, 10, '#') AS lpad_1,
	lpad(ename, 5, '#') AS lpad_1_1, -- 모자르면 채우고, 넘치면 자른다
	rpad(ename, 5, '#') AS rpad_1_1, -- 즉, 두번째 값의 길이로 만들어준다
	rpad(ename, 10, '*') AS rpad_2,
	lpad(ename, 10, '김') AS lpad_3,
	rpad(ename, 10, 'a') AS rpad_3
FROM emp;

-- 문제1 ename에서 앞의 두 글자만 출력 substr, lpad, replace

-- substr
SELECT ename, 
	substr(ename, 1, 2)
FROM emp;

-- lpad
SELECT ename,
	lpad(ename, 2, '*')
FROM emp;

-- replace
SELECT ename,
	substr(ename, 3),
	replace(ename, substr(ename, 3), '')
FROM emp;

-- 문제2 ename의 앞 두 글자만 원본으로 출력하고 나머지는 4개의 *로 출력
SELECT ename,
	substr(ename, 1, 2),
	rpad(substr(ename, 1, 2), 6, '*')
FROM emp;

-- 문제3 ename의 앞 두글자만 원본으로 출력하고 나머지는 *로 출력
-- 단, 전체 길이는 원래 이름의 길이만큼 출력
SELECT ename,
	substr(ename, 1, 2),
	rpad(substr(ename, 1, 2), LENGTH(ename), '*')
FROM emp;

-- 문제4 문제3에서 앞 두글자만 *로 출력
SELECT ename,
	substr(ename, 3),
	lpad(substr(ename, 3), LENGTH(ename), '*')
FROM emp;

SELECT 'ab' || 'cd' || 'efg' FROM dual; -- 문자열 더하기
SELECT empno || ':' || ename FROM emp;

SELECT 
	'[' || ' _ _oracle_ _ ' || ']',
	'[' || trim(' _ _oracle_ _ ') || ']' -- 공백 제거 외에는 거의 안씀
FROM dual;

SELECT 
	round(14.46), -- 소숫점 첫째 자리 반올림
	round(14.46, 0), -- 소숫점 첫째 자리 반올림
	round(14.46, 1), -- 소숫점 둘째 자리 반올림
	round(14.46, -1) -- 자연수 첫째 자리 반올림
FROM EMP;

SELECT 
	trunc(14.46), -- 소숫점 첫째 자리 버림
	trunc(14.46, 0), -- 소숫점 첫째 자리 버림
	trunc(14.46, 1), -- 소숫점 첫째 자리 버림
	trunc(14.46, -1), -- 자연수 첫째 자리 버림
	trunc(-14.46) -- 정수 -14.46의 소숫점 첫째 자리 버림
FROM emp;

SELECT 
	ceil(3.14), -- 지정된 숫자보다 큰 정수 중 가장 작은 정수 반환
	floor(3.14), -- 지정된 숫자보다 작은 정수 중 가장 큰 정수 반환
	ceil(-3.14), -- 음수의 경우
	floor(-3.14)
FROM emp;

SELECT 
	mod(15, 6), -- 15를 6으로 나눈 나머지
	mod(10, 2),
	mod(11, 2)
FROM dual;

SELECT 15/6, 15/0 FROM dual; -- 0으로 나누면 무한루프이기 때문에 에러가 나옴

SELECT 
	mod(15, 0)
FROM dual;

-- 숫자 가둬놓기
SELECT
	mod(6, 3),
	mod(7, 3), 
	mod(8, 3),
	mod(9, 3)
FROM dual;

-- 데이터 형 변환

-- 날짜 데이터
SELECT sysdate from dual;

SELECT 
	TO_char(sysdate, 'yyyy/mm/dd hh24:mi:ss') AS 현재날짜시간1,
	TO_char(sysdate, 'yyyy"년" mm"월" dd"일" hh24"시" mi"분" ss"초"') AS 현재날짜시간2
FROM dual;

SELECT *
	FROM EMP
WHERE hiredate > to_date('1981/06/01', 'yyyy/mm/dd')
ORDER BY hiredate;

-- null 처리 함수
SELECT sal, comm, 
	nvl(comm, 0),                     -- 첫번째 입력 데이터가 null이 아니면 그대로 반환
	sal+nvl(comm, 0),                 -- null이면 두번째 입력 데이터 지정값 반환
	sal+comm,
	nvl(to_char(comm), 'N/A')
FROM emp;

-- decode문 
SELECT job, sal,
	decode(job,
			'MANAGER', sal*1.1,       -- job이
			'SALESMAN', sal*1.05,     -- MANAGER라면
			'ANNALYST', sal,
			sal*1.03) AS upsal        -- 위 조건에 없다면
FROM emp
ORDER BY upsal;

-- case문

-- job과 비교
SELECT job, sal,
	CASE job                                 -- 가독성으로 인해 decode 보다 case문 사용을 권장
		WHEN 'MANAGER' THEN sal*1.1
		WHEN 'SALESMAN' THEN sal*1.05
		WHEN 'ANNALYST' THEN sal
		ELSE sal*1.03
	END AS upsal
FROM emp
ORDER BY  upsal;

-- 지정된 조건과 비교
SELECT empno, ename, comm,
	CASE
		WHEN comm IS NULL THEN '해당 사항 없음'
		WHEN comm = 0 THEN '수당 없음'
		WHEN comm > 0 THEN '수당 : ' || comm
	END AS comm_text                          -- else 사용 가능
FROM emp;

-- 되새김 문제
SELECT substr(ename, 1, 1) FROM emp;

-- 문제1
SELECT empno, rpad(substr(empno, 1, 2), length(empno), '*') AS masking_empno,
		ename, rpad(substr(ename, 1, 1), length(ename), '*') AS masking_ename
FROM EMP
WHERE 5 <= length(ename) AND LENGTH(ename) < 6;

-- 문제2
SELECT empno, ename, sal,
	trunc(sal/21.5, 2) AS day_pay,
	round(sal/21.5/8, 1) AS time_pay
FROM emp;

-- 문제4

-- 문제 4-1
SELECT empno, ename, mgr,
	CASE 
		WHEN mgr IS NULL THEN '0000'
		WHEN substr(mgr, 1, 2) = 75 THEN '5555'
		WHEN substr(mgr, 1, 2) = 76 THEN '6666'
		WHEN substr(mgr, 1, 2) = 77 THEN '7777'
		WHEN substr(mgr, 1, 2) = 78 THEN '8888'
		ELSE to_char(mgr)
		END AS chg_mgr
FROM emp;

-- 문제 4-2
SELECT empno, ename, mgr,
	CASE 
		WHEN mgr IS NULL THEN '0000'
		WHEN lpad(mgr, 2, '*') = 75 THEN '5555'
		WHEN lpad(mgr, 2, '*') = 76 THEN '6666'
		WHEN lpad(mgr, 2, '*') = 77 THEN '7777'
		WHEN lpad(mgr, 2, '*') = 78 THEN '8888'
		ELSE to_char(mgr)
		END AS chg_mgr
FROM emp;

-- 문제 4-3
SELECT empno, ename, mgr,
	CASE 
		WHEN mgr IS NULL THEN '0000'
		WHEN mgr LIKE '75%' THEN '5555'
		WHEN mgr LIKE '76%' THEN '6666'
		WHEN mgr LIKE '77%' THEN '7777'
		WHEN mgr LIKE '78%' THEN '8888'
		ELSE to_char(mgr)
		END AS chg_mgr
FROM emp;

SELECT sum(comm) FROM emp;

SELECT sum(sal) FROM emp;
--SELECT sum(sal), sal FROM emp;

SELECT count(sal) FROM emp;
SELECT count(comm) FROM emp;
SELECT count(*) FROM emp;

SELECT count(*) FROM emp
WHERE deptno = 30;

SELECT max(sal) FROM emp;
SELECT min(sal) FROM emp;

SELECT 
	max(sal), min(sal), min(hiredate), min(comm), 
	count(*), sum(sal)
FROM emp;

SELECT avg(sal) FROM emp;

-- 이름에 a가 들어가는 사람은 몇명?
-- 'a'
SELECT count(*) FROM emp
WHERE lower(ename) LIKE lower('%a%');

SELECT DISTINCT deptno FROM emp;

-----------------------
-- group by
/*
 *  제약 1. select에는 group by에 적은 컬럼 명만 가능하다
 *  제약 2. select에 집계함수는 가능하다
 */
SELECT deptno 
FROM emp
GROUP BY deptno;

SELECT deptno, count(*), sum(sal), avg(sal) 
FROM emp
GROUP BY deptno;

SELECT deptno, job
FROM emp
GROUP BY deptno, job;

SELECT deptno, job, count(*)
FROM emp
GROUP BY deptno, job;

/*
SELECT * FROM emp
WHERE avg(sal) < sal;
*/

SELECT deptno, job 
FROM emp
WHERE deptno = 10
GROUP BY deptno, job;

SELECT deptno, job 
FROM emp
--WHERE deptno = 10
GROUP BY deptno, job
HAVING deptno = 10;

SELECT deptno, job , avg(sal)
FROM emp
GROUP BY deptno, job
HAVING avg(sal) > 2000;

-- job 별로 3명 이상인 job과 count(*)를 출력
SELECT job, count(*)
FROM emp
GROUP BY job 
HAVING count(*) >= 3;

SELECT * FROM dept;

SELECT * FROM emp;

-- 모든 조합이 나온다 14 * 4 = 56가지
SELECT *
FROM emp, dept;

SELECT *
FROM emp, dept
ORDER BY empno;

SELECT deptno FROM emp 
WHERE ename = 'SMITH';

SELECT * FROM dept
WHERE deptno = 20;

SELECT *
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- 별칭을 주는 순간 별칭으로만 칭할 수 있다
SELECT *
FROM EMP e, DEPT d 
WHERE e.deptno = d.deptno;

SELECT emp.ename
FROM emp;

--SELECT ename, * FROM emp;
SELECT ename, emp.* FROM emp;
-- scheme

-- ambiguously 모호하다
SELECT ename, e.deptno, e.*
FROM EMP e, DEPT d 
--WHERE emp.deptno = deptno.deptno
WHERE e.deptno = d.deptno;

SELECT * FROM salgrade;

-- 800
SELECT sal FROM emp WHERE ename = 'SMITH';

SELECT ename, sal, grade, losal, hisal
FROM EMP e, SALGRADE s
WHERE e.sal >= s.losal AND e.sal <= s.hisal;

SELECT mgr FROM emp WHERE ename = 'SMITH';
SELECT * FROM emp WHERE empno = 7902;

-- KING은 mgr이 null이어서 결과에서 빠졌다
SELECT e1.empno, e1.ename, e1.mgr,
		e2.empno, e2.ename, e2.mgr
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;

SELECT *
FROM EMP e NATURAL JOIN DEPT d;

SELECT deptno
FROM EMP e NATURAL JOIN DEPT d;

SELECT deptno, e.empno, dname
FROM EMP e JOIN DEPT d USING(deptno);

SELECT d.deptno, d.*
FROM EMP e JOIN DEPT d on(e.deptno = d.deptno) -- table 간의 관계 조건
WHERE sal <= 2000;

SELECT *
FROM EMP e1 LEFT OUTER JOIN EMP e2 ON(e1.mgr = e2.empno);

SELECT *
FROM EMP e1 RIGHT OUTER JOIN EMP e2 ON(e1.mgr = e2.empno);

SELECT *
FROM EMP e1 FULL OUTER JOIN EMP e2 ON(e1.mgr = e2.empno);

-- 퀴즈
-- 각 부서별로
-- 가장 높은 급여, 
-- 가장 낮은 급여,
-- 급여 차액,
-- 부서번호
-- HINT: 결과는 총 3줄

SELECT max(sal), min(sal), max(sal) - min(sal), deptno
FROM emp
GROUP BY deptno;

-- 226p. 1~4번 문제 풀기

-- Q1
SELECT d.deptno, d.dname, e.empno, e.ename, e.sal
FROM EMP e LEFT OUTER JOIN DEPT d on(e.deptno = d.deptno)
WHERE e.sal > 2000;

-- Q2
SELECT d.deptno, d.dname, trunc(avg(e.sal), 0) avg_sal, 
	max(e.sal) max_sal, min(e.sal) min_sal, count(*) cnt
FROM EMP e LEFT OUTER JOIN DEPT d on(e.deptno = d.deptno)
GROUP BY d.deptno, d.dname;

-- Q3
SELECT d.deptno, d.dname, e.empno, e.ename, e.job, e.sal
FROM EMP e RIGHT OUTER JOIN DEPT d on(e.deptno = d.deptno)
ORDER BY d.deptno, e.ename;

-- Q4
SELECT 
    d.deptno, d.dname, 
    e1.empno, e1.ename, e1.mgr, e1.sal,
    s.losal, s.hisal, s.grade,
    e2.empno AS mgr_empno, e2.ename AS mgr_ename
FROM DEPT d
LEFT OUTER JOIN EMP e1 ON (d.deptno = e1.deptno)
LEFT OUTER JOIN SALGRADE s ON (e1.sal BETWEEN s.losal AND s.hisal)
LEFT OUTER JOIN EMP e2 ON (e1.mgr = e2.empno)
ORDER BY d.deptno, e1.empno;







































