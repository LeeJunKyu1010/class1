select * from emp;
desc emp;

select * from dept;
desc dept;

select * from salgrade;
desc salgrade;

select empno, ename, deptno
from emp;

SELECT EMPNO, ENAME, SAL
FROM EMP;

select deptno
from emp;

SELECT
    distinct deptno
from emp;

SELECT
    DISTINCT job
from emp;SELECT
    DISTINCT job
from emp;



SELECT
ename as 사원이름, sal as 급여, sal*12+comm as "올해 연봉", comm as 보너스
from emp;

select * from emp
order by sal asc; /*asc(오름차순) 생략가능 (자주 사용하는 단어는 생략가능)*/

select * from emp
order by sal desc; /*desc(내림차순)는 생략 불가*/

select * from emp
order by job;

select * from emp
order by empno desc, job asc, sal asc;
--P.92
--Q2
select DISTINCT job
from emp;

--Q3
SELECT * from emp
order by deptno desc, ename asc;

select * from emp
WHERE DEPTNO = 30;

select * from emp
where empno = 7782;

select * from emp
where deptno = 30 or job = 'SALESMAN';

SELECT *
 from emp
 where empno = 7499 and deptno = 30;
 
 SELECT *
 from emp
 where deptno = 20 OR job = 'SALESMAN';
 
 select * from emp
 whereselect * from emp
 where
    ename = 'WARD'
    OR JOB = 'CLERK'
    OR deptno = 20
    ORDER by deptno;

select * from emp
 where
    ename = 'WARD'
    OR JOB = 'CLERK'
    OR deptno = 20;
ename = 'WARD'
    OR JOB = 'CLERK'
    OR deptno = 20;
    
select * from emp
 where
    ename = 'WARD'
    or JOB = 'CLERK'
    and deptno = 20;

select *
    from emp
    where sal > 3000;
    
select *
    from emp
    where sal <= 2000;

select *
    from emp
    where sal >=2500
    and job = 'ANALYST';


-- 봉급이 2000 이상이고 3000 미만인 사원 출력
select * 
    from emp
    where sal >= 2000 
    and sal < 3000;


-- 봉급이 3000이 아닌 사원 출력
select *
    from emp
    where sal != 3000;

select *
    from emp
    where sal <> 3000;


-- 문제1. 부서 번호가 20이 아닌 목록
select *
    from emp
    where deptno != 20
    order by deptno;

-- 문제2. 부서 번호가 20도 아니고 10도 아닌 목록
select *
    from emp
    where deptno != 20
    and deptno != 10;

-- 문제3. 부서번호가 30이면서 봉급 2000 이하
select empno 사원번호, ename 사원이름, job 직책, mgr "직속상관 사원번호", HIREDATE 입사일자, sal 봉급, comm 급여외, deptno 부서번호
    from emp
    where deptno = 30
    and sal <= 2000;

select empno 사원번호, ename 사원이름, job 직책, mgr "직속상관 사원번호", HIREDATE 입사일자, sal 봉급, comm 급여외, deptno 부서번호
    from emp
    where not sal = 3000
    order by deptno;

-- 봉급이 2000 미만 또는 3000 이상 출력
select *
    from emp
    where sal < 2000
    or sal >= 3000;

-- 봉급이 2000 이상 그리고 3000 미만이 아닌것
select *
    from emp
    where 
    not (sal >= 2000 and sal < 3000);

/* 직책 열이 MANAGER 또는 SALSEMAN 또는 CLERK 중 하나인 열을 출력
(여러개의 조건을 출력)*/
select *
    from emp
    where job in ('MANAGER', 'SALESMAN', 'CLERK');

-- 여러개의 조건을 반대로 출력
select *
    from emp
    where job not in ('MANAGER', 'SALESMAN', 'CLERK');


-- 10번 부서와 20부서만 출력
select *
    from emp
    where deptno  in (10,20)
    order by deptno asc;


 -- 10번 부서와 20부서만 아닌 사원만 출력   
select *
    from emp
    where deptno not in (10,20);


-- 급여가 2000 이상 3000 이하
select *
    from emp
    where sal between 2000 and 3000 -- sal >= 2000 and sal <= 3000
    order by sal;


-- 급여가 2000 이상 3000이하가 아닌것 
select *
    from emp
    where sal not between 2000 and 3000
    order by sal;


-- %는 길이에 관계 없이 아무거나를 뜻함
select *
    from emp
    where ename like 'S%';


-- 시작, 끝, 중간에 관계없이 A를 포함한 모든 것
select *
    from emp
    where ename like '%A%';


--  _ 는 어떤 글씨든 딱 한글자
select *
    from emp
    where ename like '_L%';


select *
    from emp
    where mgr like '_8%';

select *
    from emp
    where ename not like '%AM%';

-- null은 제외된다.
select *
    from emp
    where comm <= 400;

-- null은 조회가 안된다.
select *
    from emp
    where comm = null;

-- null만 조회한다.
select *
    from emp
    where comm is null;

-- null이 아닌것만 조회한다.
select *
    from emp
    where comm is not null;


select comm, comm + 10 from emp;

select comm, comm + 10 from emp
where comm is  null;

select comm, comm + 10 from emp
where comm is not null;

-- 직속 상관이 있는 사원만 출력
select *
    from emp
    where mgr is not null;

-- DEPTNO가 10인것만 조회
select *
    from emp
    where deptno = 10;

-- DEPTNO가 20인것만 조회
select *
    from emp
    where deptno = 20;

select *
    from emp
    where deptno = 10
union
select *
    from emp
    where deptno = 20;

-- 컬럼의 개수가 달라서 오류
select EMPNO, ENAME, SAL, DEPTNO
    from emp
    where deptno = 10
    union
select EMPNO, ENAME, SAL
    from emp
    where deptno = 20;

-- 컬럼의 개수가 동일
select EMPNO, ENAME, SAL, DEPTNO
    from emp
    where deptno = 10
    union
select EMPNO, ENAME, SAL, DEPTNO
    from emp
    where deptno = 20;


-- empno와 ename의 위치를 바꿈
-- 숫자, 문자
select ENAME, EMPNO, SAL, DEPTNO
    from emp
    where deptno = 10
    union
select EMPNO, ENAME, SAL, DEPTNO
    from emp
    where deptno = 20;


-- 타입이 같으면 OK
-- 컬럼의 의미는 신경쓰지 않는다.
select EMPNO, ENAME, SAL, DEPTNO
    from emp
    where deptno = 10
    union
select sal, ENAME, SAL, DEPTNO
    from emp
    where deptno = 20;

/* union */
-- 한줄의 모든 내용이 중복되는 경우가 있으면
-- 중복을 제거하고 출력
select EMPNO, ENAME, SAL, DEPTNO
    from emp
    where deptno = 10
    union
select EMPNO, ENAME, SAL, DEPTNO
    from emp
    where deptno = 10;

/* union all */
-- 중복의 관계 없이 모든 줄을 표시
select EMPNO, ENAME, SAL, DEPTNO
    from emp
    where deptno = 10
    union all
select EMPNO, ENAME, SAL, DEPTNO
    from emp
    where deptno = 10;


--P.125 문제들
-- 1번.
select *
    from emp
    where ename like ('%S');


-- 2번.
select EMPNO, ENAME, JOB, SAL, DEPTNO
    from emp
    where deptno = 30
    and job = 'SALESMAN';

-- 3번.
-- 3번. 집합 연산자 미사용
select EMPNO, ENAME, JOB, SAL, DEPTNO
    from emp
    where deptno in (20,30) 
    and sal >2000;
    
-- 3번. 집합 연산자 미사용
select EMPNO, ENAME, JOB, SAL, DEPTNO
    from emp
    where (deptno = 20 or deptno = 30) and sal > 2000; 
    
-- 3번. 집합 연산자 사용
select EMPNO, ENAME, JOB, SAL, DEPTNO
    from emp
    where deptno = 20
    and sal > 2000
    union all
select EMPNO, ENAME, JOB, SAL, DEPTNO
    from emp
    where deptno = 30
    and sal > 2000;
    
    
-- 4번.
select * from emp
    where
    not(2000<= sal and 3000 >= sal);

-- 5번.
select ENAME, EMPNO, SAL, DEPTNO
    from emp
    where ename like '%E%'
    and deptno = 30
    and sal not between 1000 and 2000;

-- 6번.
select *
    from emp
    where 
    comm is null 
    and mgr is not null
    and (JOB LIKE 'MANAGER'
    or JOB LIKE 'CLERK')
    and ename not like '_L%';
    
    select *
    from emp
    where 
    comm is null 
    and mgr is not null
    and job in ('MANAGER','CLERK')
    and ename not like '_L%';

select * from dual;

select upper('abc')
from dual;

select lower(ename) from emp;

select upper(ename) from emp;

select upper(lower(ename)) from emp;

-- 대소문자 구분 없이 검색
select * from emp
    where
    ename like '%A%' or ename like '%a%';

/* AB Ab aB ab */

select * from emp
    where
    lower(ename) like '%a%';

-- upper, lower는 대소문자 구분 없이 like 검색 할 때 좋다.
-- 첫번째 lower는 검색 결과를 뜻하고, 두번째 lower는 검색 할 내용을 뜻함
select * from emp
    where
    lower(ename) like lower('%mI%');


-- length : 문자 개수
select ename, length(ename) from emp;

select length('abc'),length('한글') from dual;

select ename, length(ename) from emp
where length(ename) >=5;


-- lengthb : 문자의 바이트 용량 (영어와 숫자는 1바이트, 한글은 3바이트)
select length ('한'), lengthb('한') from dual;



-- substr
-- substr ( 글씨, 시작 위치, 몇개)
-- substr ( 글씨, 시작 위치) : 시작 위치부터 끝까지
select '123456', substr('123456', 3, 2) from dual; -- 결과값 3,4
select '123456', substr('123456', 2, 3) from dual; -- 결과값 2,3,4


select job,
    substr(JOB, 1,2), --앞에 두 글자만 출력
    substr (job, 3,3), -- 3번째 글자부터 3글자 출력
    substr (job, 4), -- 4번째 글자부터 끝까지 출력
    substr (job, 4, 100), --4번째 글자부터 100까지 출력
    substr (job, 44, 100) -- 실제 길이보다 시작위치가 큰 경우 null
    from emp;

   
select job,
    substr (job, 4, 100),
    length (substr (job, 4, 100))
    from emp;

select job,
    substr(JOB, -3,2),
    substr(JOB, -3), -- 맨 뒤 3글자만 출력. 즉, 뒤에서 3번째에서 시작
    length (substr(JOB, 1,2))
    from emp;

select substr(1234, 2) from dual;

select '010-1234-5678' as replace_before,
    replace('010-1234-5678','-','') as replace_1,
    replace('010-1234-5678','-') as replace_2
    from dual;
    
select
    replace(ename, 'A', '*')
    from emp;


select
    --문제1. ename에서 앞 두글자만 출력
    substr(ename, 1, 2) as "1",  
    --문제2. ename에서 앞에 두글자만 **로 처리
    replace(ename,substr(ename,1,2),'**') as "2",
    -- 문제3-0. ename의 앞부터 반절에 해당하는 길이 출력
    length(ename)/2 as "3-0",
    -- 문제3-1. enam의 앞에 반절 모두 ** 처리
    replace (ename, substr(ename, 1, length(ename)/ 2),'*') as "3-1",
    -- 문제3-2. enam의 뒤에 반절 모두 ** 처리
    replace(ename, substr(ename, length(ename) /2+1),'*') as "3-2"
    from emp;
    
    /*변환해야 하니까 replace
       replace 첫번째 : ename
               두번째 : 절반에 해당하는 글씨 모두 확보
                    substr 써보자
                    첫번째 : ename
                    두번째 : (시작 위치) : 처음부터니까 1
                    세번째 : (자를 개수) : length(ename) /2
               세번째 : '*' */

select 'Oracle',
    lpad('Oracle', 10, '#'),
    rpad('Oracle', 10, '*'),
    lpad('Oracle', 10),
    rpad('Oracle', 10),
    rpad('Oracle', 5),
    lpad('Oracle', 5)
    from dual;


select
    rpad('971225-',14,'*'),
    rpad('010-1234-',13,'*')
    from dual;


select
    ename,
    -- 이름을 6자리로 만들고 빈 공간의 오른쪽을 *로 채운다.
    rpad(ename, 6,'*'),
    lpad(ename, length(ename)*2,'*')
    from emp;


select 
    '010-9182-0578' as "전화번호",
    length('010-9182-0578') as "자리수",
    substr('010-9182-0578',1,length('010-9182-0578')-4) as "잘린글씨",
    rpad(
    substr('010-9182-0578',1,length('010-9182-0578')-4),
    length('010-9182-0578'),'*') as "뒤 4자리 *"
    from dual;


-- 문제2 : 사원의 이름을 앞에 두글자만 보이게 하고 나머지 *로 표시. 단, replace 사용금지
-- rpad(두글자, 전체글자, '*')
select
    ename as "이름",
    length(ename),
    substr(ename,1 ,length(ename))as "이름",
    rpad(substr(ename,1,2),length(ename),'*') as "첫 두글자만 표시"
    from emp;

-- 문제3 : 사원 이름의 앞글자 하나만 *로 표시. 단, replace 사용금지
-- 앞글자 하나 : 두번째부터 끝까지의 글씨를 살린다.
-- lpad( 두번째부터 끝까지, 전체길이, '*')
select
    ename,
    substr(ename, 1),
    lpad(substr(ename, 2),length(ename),'*')
    from emp;

-- 심화1 : job을 대상으로 20자 크기의 공간에서 가운데 정렬
/*  가운데 정렬 : 앞과 뒤에 동일한 공간이 있는거
            ********************
            ********WARD********
            MARTIN
            20-6=14/2=7
            *******MARTIN#######
            lpad(
                JOB,
                (20-length(job)) / 2,
                '*'
            */
-- 첫번째 방법
select
    job,(20-length(job))/2,
    lpad(job,((20-length(job))/2)+length(job),'*'),
    rpad(lpad(job,((20-length(job))/2)+length(job),'*'),20,'*')
    from emp;
--2번째 방법 (글자를 반으로 나눠 10글자, 나눈 글자를 10글자로 해서 *을 추가)
select
rpad(lpad (substr(job, 0, length(job)/2), 10, '*')
, 20,
rpad(substr(job, length(job)/2+1), 10, '*'))
from emp;
    
-- 최대 2개만 합칠 수 있음
select
    empno, ename, concat(empno,ename)
    from emp;

-- concat 대신 사용 가능
select
    empno || ' : ' || ename from emp;

-- trim : 앞뒤 공백 문자 제거. 단, 글씨 사이의 공백은 제거하지않음
select
    '      a b c   ',
    trim('      a b cd          ')
    from dual;



select
    round(1234.5678), -- 0을 생략함
    round(1234.5678,0),
    round(1234.5678,1), -- 소수점 첫번째 자리 반올림
    round(1234.5678,2), -- 소수점 두번째 자리 반올림
    round(1234.5678,3), -- 소수점 세번째 자리 반올림
    round(1234.5678,-1),-- 자연수 첫번째 자리 반올림 
    round(1234.5678,-2) -- 자연수 두번째 자리 반올림 
    from dual;

select
    round(14.46),   -- 두번째 값이 없는 경우 소수점 첫째자리 반올림
    round(14.46,1), -- 두번째 값은 소수점 몇번째까지 표시할지
    round(14.46,-1) -- 두번째 값이 음수인 경우 정수로 거슬러 올라감
    from emp;

select
    trunc(14.46),   --  14까지만 표시
    trunc(14.46,1), --  소수점 첫번째 자리까지 표시
    trunc(14.46,-1),--  10결과값
    trunc(-14.46)   --  -이므로 -14결과값
    from dual;

select
    ceil(3.14),     -- 올림 
    floor(3.14),    -- 내림
    ceil(-3.14),    -- -이므로 -3
    floor(-3.14)    -- -이므로 -4
    from dual;


select
    mod(15,6)   -- 나누기 mod( 나누고 싶은 수, 몇으로 나눌지 정하는 수)
    from dual;


-- 지금 오라클이 설치된 pc의 시간이 나온다.
-- 설정에 따라 기본 출력값이 날짜의 일부만 나올 수도 있다.
-- 강사 pc의 오라클은 9시간 차이남
select
    sysdate as "오늘 날짜",
    sysdate + 1 as "내일 날짜",
    sysdate - 1 as "어제 날짜"
    from dual;

select
    hiredate,
    add_months(hiredate, 120)
    from emp;


-- 컬럼에 +를 적으면 모두 숫자로 변경해서 적용
select
    empno,
    empno+'500'
    from emp;
    
--||를 적으면 모두 문자로 변경해서 적용
select
    empno,
    empno||500
    from emp;
    
-- 숫자가 들어가야되는 칸에 문자가 들어가면 에러가 난다.
select
    empno,
    empno+'500ㅁ'
    from emp;

-- 날짜 표시
select to_char(sysdate,'yyyy"년" mm"월" dd"일" day hh24"시":mi"분":ss"초"') from dual;
select to_char(sysdate,'yy-mm-dd hh24:mi:ss') from dual;

-- 급여 출력하기
select sal, to_char(sal,'999,999') -- '999,999' 앞에 L을 넣으면 해당되는 국가의 단위를 표시
    from emp;

select
    to_date('2024-11-15','yyyy/mm/dd')
    from dual;

select
    to_char(
    to_date('2024-11-15','yyyy/mm/dd'),
    'yyyy-mm-dd hh24:mi:ss')    
    from dual;
    
select
    to_char(
    to_date('2024-11-15','yyyy/mm/dd'),
    'yyyy"년"mm"월"dd"일" hh24"시":mi"분":ss"초"')    
    from dual;
    
select
    to_date('2024/11/15','yyyy/mm/dd') - to_date('2024/11/16')
    from dual;
    
select
    to_date('2024/11/11','yyyy/mm/dd') - to_date('2024/11/15 16:04','yyyy/mm/dd hh24:mi:ss')
    from dual;
    
select *
    from emp
    where hiredate> to_date('1981/06/01','yyyy/mm/dd');

select
    to_date('2025/05/02','yyyy-mm-dd') - sysdate
    from dual;

select
    to_date('2025-05-02','yyyy-mm-dd')- to_date('2024-11-15','yyyy-mm-dd')
    from dual;


/*nvl은 첫번쨰 입력 데이터가 null이 아니면 드 데이터를 그대로 반환하고
null이라면 두번째입력 데이터에 지정한 값을 반환*/
select
    sal, comm, sal+comm,
    nvl(comm,0),
    nvl(comm,0)+sal
    from emp;

select
   comm,
    nvl2(comm,'널 아님','널')
    from emp;

select
    job, sal,
    decode(job,
    'MANAGER',SAL*1.1,
    'SALESMAN',SAL*1.05,
    'ANALYST',SAL,
    'CLERK',SAL*1.1,
    SAL*1.03)
    FROM EMP;


-- 이름, 봉급, 성과금, 봉급+추가수당(decode로
-- decode 함수
select
    ename as "이름", sal as "봉급", comm as "추가수당",
    decode(sal,
    sal,sal+comm) as "봉급+추가수당"
    from emp;

select
    ename, sal, comm,
    sal+comm,
    sal + nvl(comm,0),
    sal + decode(comm,null,0,comm)
    from emp;

-- case 함수
select
    JOB, SAL,
    case job
        when 'MANAGER' THEN SAL * 1.1
        WHEN 'SALESMAN' THEN SAL * 1.05
        WHEN 'ANALYST' THEN SAL
        ELSE SAL * 1.03
        end
        FROM EMP;

select
    case
        when comm is null then '해당사항 없음'
        when comm = 0 then '수당없음'
        when comm > 0 then '수당:'|| comm
        end
        from emp;


-- comm이 null 인 경우 'N/A' 출력
-- null이 아닌 경우 comm 출력
select
    case
        when comm is null then 'N/A'
        --when comm is not null then '*'||comm
        else '' || comm
        end
        from emp;


-- 174p. Q2
select
    empno, ename, sal,
    trunc (sal/21.5,2) as DAY_PAY,
    round ((sal/21.5/8),1) as TIME_PAY
    from emp;

-- 175p. Q4
select
    empno, ename,mgr,
    case
        when mgr is null then '0000'
        when substr(mgr,1,2) = 75 THEN '5555'
        when substr(mgr,1,2) = 76 THEN '6666'
        when substr(mgr,1,2) = 77 THEN '7777'
        when substr(mgr,1,2) = 78 THEN '8888'
        else ''||mgr --    ''||mgr 또는 to_char(mgr)
    end AS CHG_MGR1
-- like를 이용한 방법
    ,case
    when mgr is null then '0000'
        when mgr like '75%' then '5555'
        when mgr like '76%' then '6666'
        when mgr like '77%' then '7777'
        when mgr like '78%' then '8888'
        else ''||mgr
        end AS CHG_MGR2
    
-- 3번째 방법
    ,case substr(mgr,1,2)
        when '75' then '5555'
        when '76' then '6666'
        when '77' then '7777'
        when '78' then '8888'
            else nvl(to_char(mgr),'0000')
        end AS CHG_MGR3
    from emp;



-- 강사님께서 하신 방법들
select empno, ename, mgr,
    case
        when mgr is null then '0000'
        else
            case
                when substr(mgr, 1, 2) = '75' then '5555'
                when substr(mgr, 1, 2) = '76' then '6666'
                when substr(mgr, 1, 2) = '77' then '7777'
                when substr(mgr, 1, 2) = '78' then '8888'
--                else to_char(mgr)
                else '' || mgr
            end
    end chg_mgr1,
    /* in을 사용해서 간단하게 코딩 */
    /* 두번째 mgr이 5,6,7,8 일때 처리 */
    case
        when mgr is null then '0000'
        when substr(mgr, 2, 1) in ('5', '6', '7', '8')
--            then trim(lpad(' ', 5, substr(mgr, 2, 1)))
--            then lpad(substr(mgr, 2, 1), 4, substr(mgr, 2, 1))
            then lpad(substr(mgr, 2, 1), length(mgr), substr(mgr, 2, 1))
        else '' || mgr
    end chg_mgr2,
    case
        when mgr is null then '0000'
        when mgr like '75%' then '5555'
        when mgr like '76%' then '6666'
        when mgr like '77%' then '7777'
        when mgr like '78%' then '8888'
        else '' || mgr
    end chg_mgr3,
    case
        when mgr is null then '0000'
        else
            case substr(mgr, 1, 2)
                when '75' then '5555'
                when '76' then '6666'
                when '77' then '7777'
                when '78' then '8888'
                else '' || mgr
            end
    end chg_mgr4,
    case substr(mgr, 1, 2)
        when '75' then '5555'
        when '76' then '6666'
        when '77' then '7777'
        when '78' then '8888'
        else nvl(to_char(mgr), '0000')
    end chg_mgr5,
    case
        when mgr >= 7500 and mgr < 7600 then '5555'
    end chg_mgr6
from emp;


-- comm에 null이 있으므로 nvl를 사용하여 계산하자
select sum(comm) from emp;
select sum(sal) from emp;
select sum(sal + nvl(comm,0)) from emp;

-- count도 sum처럼 null을 제외함
-- count에는 *을 많이 씀
select count(*),count(sal),count(comm) from emp;

--다중행 함수는 다중행 함수끼리만 출력해야 한다.
select count(*),sum(sal), sal from emp;

--부서번호가 30인 직원수 구하기
select count(*) from emp
where deptno = 30
and comm is not null;

-- max 최대값, min 최소값 구하기
select max(sal), max(ename),min(sal),min(hiredate),min(comm) from emp;

-- 이름 중간에 A를 포함한 인원
Select count(*) from emp
where ename like '%A%';

-- 최대 연봉을 받는 사람의 모든 정보를 표시
select max(sal) from emp;
select * from emp;

/*
where 에는 다중행 함수(집계 함수)를 사용 할 수 없음
select * from emp
where sal = max(sal);

count(*) 등 집계함수는 where에서 사용 할 수 없다.
select max(sal)
from emp
where count(*) > 2
group by deptno;
*/


--AVG 평균값을 구하는 함수
select avg(sal) from emp;

select '10', sum(sal), avg(sal) from emp where deptno= 10
union all
select '20', sum(sal), avg(sal) from emp where deptno = 20
union all
select '30', sum(sal), avg(sal) from emp where deptno = 30;

select deptno, job, trunc(avg(sal)),sum(sal), count(*)
    from emp
    group by deptno, job
order by deptno, job;



select
    deptno, avg(sal),count(*)
from emp
    group by deptno
    having avg(sal) >= 2000
    order by deptno;


select
    deptno, job, avg(sal),sum(sal),count(*)
from emp
    group by deptno, job
    having avg(sal) >= 2000
    order by deptno,job;

select
    deptno, job, avg(sal),sum(sal),count(*)
from emp
    group by deptno, job
    having avg(sal) >= 2000
    order by deptno,job;

/*
having : group by 에서만 사용
where에서 표현할 수 있는건 가급적 where에서 사용하는게 좋다.
집계함수를 조건으로 주고 싶을대 사용한다.
*/

-- 작동순서
/* 5번 */select job, count(*) as cnt
/* 1번 */from emp
/* 2번 */where sal > 1000 /* and cnt > 3 <- 안됨 */
/* 3번 */group by job
/* 4번 */having count(*) >= 3
/* 6번 */order by cnt desc;


--194p. 복습문제
select deptno, job, avg(sal)
from emp
group by deptno, job
having avg(sal) >= 500
order by deptno, job;

--212p.Q1
select deptno, trunc(avg(sal)) avg_sal ,max(sal) max_sal ,min(sal) min_sal ,count(*) as CNT
from emp
group by deptno;

-- floor를 사용하는게 좋다.
select deptno, floor(avg(sal)) avg_sal ,max(sal) max_sal ,min(sal) min_sal ,count(*) as CNT
from emp
group by deptno;


--212P. Q2
select job, count(*)
from emp
group by job
having count(*) >= 3;

-- 1. 1981년에 입사한 사원중 급여가 가장 낮은 사원의 정보를 조회하세요
select min(sal)
    from emp
    where hiredate like '81%';

select min(sal) from emp
where hiredate >= to_date('1981-01-01','yyyy-mm-dd')
    and hiredate <= to_date('1981-12-31','yyyy-mm-dd');
      -- to_char(hiredate,'yyyy')= '1981'; <- 이렇게도 사용한다.

    

-- 2. 각 부서별로 급여가 가장 높은 사원과 가장 낲은 사원의 급여 차이를 조회하세요.
select deptno, min(sal),max(sal),max(sal) - min(sal)
    from emp
    group by deptno;



--emp 테이블과 dept 테이블 조회
select *
from emp,dept
order by empno;

-- emp 테이블과 dept 테이블 중 같은 deptno만 조회
-- emp.deptno = dept.deptno .을 붙이면 그 안에서 이거라고 하는거라는 뜻
select *
from emp,dept
where emp.deptno = dept.deptno
order by empno;

-- from(테이블)에 별칭을 정할 수 있다. as는 select에만 사용 가능, from에는 넣으면 안된다.
select *
from emp e,dept d
--where emp.deptno = dept.deptn
where e.deptno = d.deptno
order by empno;

-- 테이블 별칭을 정해준걸로 select에 입력해야된다.
select ename, e.deptno
from emp e,dept d
where e.deptno = d.deptno
order by empno;


-- select에 컬럼명과 *을 출력하려면 별칭을 반드시 적어야된다.
-- select에서 조회 할 때 from(테이블)에 동일한게 있을 경우 from(테이블) 명칭을 앞에 적어주고.을 해야된다.
select ename, e.deptno, e.*, d.*
from emp e,dept d 
where e.deptno = d.deptno
order by empno;


select e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal >= s.losal and e.sal <= s.hisal;

select * from emp;

--자체 조인 사용 (같은 테이블)
select * from emp e1, emp e2, emp e3;

-- 직속상관 조회
select e1.ename, e1.mgr, e2.ename, e2.empno
from emp e1, emp e2
where e1.mgr = e2. empno;

-- 직속상관의 직속상관 조회
select e1.ename, e1.mgr, e2.ename, e2.empno, e2.mgr, e3.ename, e3.empno
from emp e1, emp e2, emp e3
where e1.mgr = e2. empno
and e2.mgr = e3.empno;

-- 오라클 전용 외부 join
-- king이 조회가 안되어 e2.empno에 (+)를 추가하면 출력된다.
select e1.ename, e1.mgr, e2.ename, e2.empno, e2.mgr
from emp e1, emp e2
where e1.mgr = e2. empno(+);

select e1.ename, e1.mgr, e2.ename, e2.empno, e2.mgr
from emp e1, emp e2
where e1.mgr(+) = e2. empno;

-- using은 둘다 같은 컬럼명을 사용하는 경우만 사용가능하다.
select deptno, emp.ename
from emp join dept using(deptno);

-- 테이블 조인 조건을 on으로 분리시킨다.
select *
from emp e join dept d on(e.deptno = d. deptno)
where sal <= 3000;

select *
from emp e1 join emp e2 on(e1.mgr = e2.empno);


-- left outer join 왼쪽에 나오는것을 모두 보장해준다.
-- right outer join 오른쪽에 나오는것을 모두 보장해준다.
-- full outer join 양쪽 모두 보장해준다.
select *
from emp e1 
left outer join emp e2 on(e1.mgr = e2.empno);

-- from(테이블)이 3개 이상일때 쭉 이어서 사용한다.
select *
from emp e1 
left outer join emp e2 on(e1.mgr = e2.empno)
left outer join emp e3 on(e2.mgr = e3.empno);

select *
from dept;

-- 239p. Q1
-- SQL_99 이전방식
select e.deptno, d.dname, e.empno, e.ename, e.sal
from emp e, dept d
where e.deptno = d.deptno
and sal > 2000
order by deptno;
-- SQL_99 방식
select deptno, dname, e.empno, e.ename, e.sal
from emp e join dept using(deptno)
where sal > 2000
order by deptno;



-- 239p. Q2
select deptno, d.dname, floor(avg(sal)), max(sal), min(sal), count(*)
from emp e join dept d using(deptno)
group by deptno,d.dname;

select 
deptno,dname, floor(avg(e.sal)) AVG_SAL, max(e.sal) MAX_SAL, min(e.sal)MIN_SAL,count(*) CNT
from emp e join dept using(deptno)
group by deptno,dname
order by deptno;
-- 239p. Q3

select *
from dept d left outer join emp e on(d.deptno = e.deptno)
order by d.deptno;

select
deptno, dname, e.empno, e.ename, e.job, e.sal
from emp e right join dept using(deptno)
order by deptno, ename;

-- 추가문제1
-- 사원번호, 이름, 부서명, 급여등급 출력 : 14줄
select e.empno, e.ename, d.dname, s.grade
from emp e 
join dept d on e.deptno = d.deptno 
join salgrade s on e.sal>=s.losal and e.sal <= hisal;

select
    e.empno, e.ename, d.dname
from emp e, dept d, salgrade s
where e.deptno = d.deptno
and e.sal between s.losal and s.hisal;

-- 추가문제2
-- 상사 보다 월급이 높은 사원의 이름, 급여, 상사이름, 상사급여
select e1.ename, e1.sal, e2.ename, e2.sal
from emp e1
left outer join emp e2 on (e1.mgr = e2.empno)
where e1.sal > e2.sal;



select *
from dept d left outer join emp e on (d.deptno = e.deptno)
where e.deptno is null;


-- 서브쿼리 (242p)
select ename, sal
from emp
where sal > (select sal
                    from emp
                    where ename = 'JONES');



-- 서브쿼리사용 (247p)
-- 20번 부서에서 급여가 평균급여보다 높은 사원
select e.empno, e.ename, e.job, e.sal, d.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
and e.deptno = 20
and e.sal > (select avg(sal) from emp);


-- 연봉이 가장 높은 사원
select * 
from emp
where sal = (select max(sal) from emp);

-- 부서별 급여를 가장 많이 받는 사원(급여만 출력)
select max(sal) from emp
group by deptno;

-- 부서별 급여를 가장 많이 받는 사원 급여가 변경되면 수동으로 해야됨
select * from emp
where sal in (2850,3000,5000);
-- 부서별 급여를 가장 많이 받는 사원 (자동)
select * from emp
where sal in (select max(sal) from emp
group by deptno);


-- BLAKE보다 높은 연봉을 받는 사람들 출력
select *
from emp
where sal >= (select sal
                    from emp
                    where ename = 'BLAKE');

-- JONES랑 같은 JOB을 가지고 있는 사람들
select *
from emp
where JOB = (select JOB
                    from emp
                    where ename = 'JONES');

-- 251p
select *
from emp
where sal = any (select max(sal) from emp group by deptno);



select * from (
select empno, deptno, ename from emp
where deptno = 10);


-- 줄번호를 만들어주는 ROWNUM
select rownum, emp.* from emp;

select *
from(
select rownum, emp.* 
from emp)
where rownum = 3;

select rownum, emp.*
from emp
order by ename;


select rownum, a.*
from(
select *
from emp
order by ename)
a;

------------------

select job,count(*) cnt from emp
group by job
having count(*) >= 3;


select *
from (
select job,count(*) cnt from emp
group by job
)
where cnt >= 3;

--------------------------------------------------
-- 260p
with e10 as(
    select * from emp where deptno = 10
)
select * from e10;
--------------------------------------------------


--262P Q1 ------------------------------------
select job from emp
where ename = 'ALLEN'; -- 먼저 ALLEN의 직책을 알아보기

select job, empno, ename, sal, deptno, dname  -- join ~ using 을 사용
from emp join dept using (deptno)
where job = (select job from emp
where ename = 'ALLEN');
order by sal desc, ename;

select e.job, e.empno, e.ename, e.sal, e.deptno, d.dname -- join ~ on 을 사용
from emp e join dept d on (e.deptno = d.deptno)
where job = (select job from emp where ename = 'ALLEN')
order by sal desc, ename;


-- select에 서브쿼리가 있는 경우 한줄마다 조회하므로 비효율적일 수 있다.
select job, empno, ename, sal, deptno, 
(select dname from dept where e.deptno = dept.deptno) as DNAME ----중요
from emp e --- 중요
where job = (select job from emp where ename = 'ALLEN');


--262P Q2 ------------------------------------
-- 1. 전체 사원의 평균 급여 확보
-- 2. 그것보다 높은(초과) 사람들을 출력
select avg(sal) from emp; -- 급여 평균을 먼저 출력

select empno, ename, dname, hiredate, loc, sal, grade
from emp e, dept d, salgrade s
where
    e.deptno = d.deptno
    and e.sal >= s.losal and e.sal <= s.hisal
    and e.sal > (select avg(sal) from emp)
    order by sal desc, empno;


select empno, ename, dname, to_char(hiredate,'YYYY/MM/DD') AS HIREDATE, loc, sal, grade
from emp e 
join dept d on (e.deptno = d.deptno)
join salgrade s on e.sal >= s.losal and e.sal <= hisal
and e.sal > (select avg(sal) from emp)
order by sal desc, empno;


--262P Q3 ------------------------------------
/*
 10번 부서 사람중에서...
 30번 부서에 없는 직책...?
 30번 부서의 job들이 not in으로 10번 부서에 적용?
 */
select * from emp where deptno = 10
union all
select * from emp where deptno = 30; -- 먼저 10번 부서와 30번 부서 직책 알아보기

select empno, ename, job, e.deptno, dname, loc
from emp e
left outer join dept d on (e.deptno = d.deptno) -- 왼쪽 테이블을 모두 보장하는 left outer join 사용
where e.deptno = 10
and e.job not in ( select job from emp where deptno = 30);

--262P Q4 ------------------------------------
-- left outer join 사용
select empno, ename, sal, grade
from emp e
left outer join salgrade s
on (e.sal >= s.losal and e.sal <= s.hisal)
where e.sal > (select max(sal) from emp where job = 'SALESMAN');

-- join ~ on 사용
select e.empno, e.ename, e.sal, s.grade
from emp e join salgrade s on (e.sal >= s.losal and e.sal <= s.hisal)
where e.sal > (select max(sal) from emp where job = 'SALESMAN');

--------------------------------select end--------------------------------------










-------------------------------DDL--------START---------------------------------



/*
        CRUD         
    생성 Create C
    조회 Read   R
    수정 Update U
    삭제 Delete D
*/
desc emp;

-----------------------------------------------------  테이블 생성

-- create로 먼저 생성 한다.
create table emp_ddl (
empno number(4),    -- 숫자 4자리 제한
ename varchar2(10), -- 가변형 글씨 10바이트 제한
job varchar2(9),    -- 제한 보다 적은 글씨일때 글씨만큼의 공간으로 줄어든다.
mgr number(4),
hiredate date,      -- 날짜
sal number(7,2),    -- 소수점 둘째 자리까지 기록
comm number(7,2),
deptno number(2)
);

desc emp_ddl; -- create 생성한 테이블을 확인한다.

select * from emp_ddl; -- select로 생성한 테이블을 검색

----------------------------------------------------- 테이블 복사

-- 다른 테이블을 복사하여 테이블을 생성
create table dept_ddl
as select * from dept;

select * from dept_ddl; -- 복사한 테이블 검색

-----------------------------------------------------    테이블의 일부 복사 생성

-- 다른 테이블의 일부를 복사하여 테이블 생성
create table emp_ddl_30
    as select *
            from emp
            where deptno = 30;

select * from emp_ddl_30; -- 일부 복사한 테이블을 검색

-----------------------------------------------------   테이블의 열 구조만 복사 생성

-- 기존 테이블의 열 구조만 복사하여 새로운 테이블 생성하기
create table empdept_ddl
    as select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, 
              d.deptno, d.dname, d.loc
            from emp e, dept d
            where 1 <> 1;

select * from empdept_ddl;  -- 생성한 테이블 검색

-----------------------------------------------------   

-- emp 테이블을 복사하여 emp_alter 테이블 생성하기
create table emp_alter
    as select * from emp;

select * from emp_alter; -- 생성한 테이블 검색

desc emp_alter;

-----------------------------------------------------

-- 테이블에 열 추가하기
alter table emp_alter -- <--복사한 테이블
    add hp varchar(20);

select * from emp_alter; -- 테이블에 추가한 열 검색 해보자 (위에서 HP를 추가)

-----------------------------------------------------

-- 컬럼명 변경하기
alter table emp_alter
rename column hp to tel; -- 추가했던 컬럼명을 HP -> TEL로 변경

select * from emp_alter; -- 바뀐 컬럼명 검색

-----------------------------------------------------

-- 열 길이 변경하기 (modify는 크기가 커지는건 가능 하지만 줄어드는건 불가능하다)
alter table emp_alter
modify empno number(5); -- EMPNO 열을 5 변경하기

desc emp_alter; -- 변경 했던 열을 확인


-- 타입을 변경할때는 내용이 모두 null일때만 가능하다 
alter table emp_alter
modify mgr varchar2(4); -- 내용이 있으므로 안됨

-----------------------------------------------------

-- 열 삭제하기
alter table emp_alter
drop column tel;         -- tel 열을 삭제하기

select * from emp_alter; -- 삭제한 열 검색해보자

-----------------------------------------------------

-- 테이블명 변경하기
rename emp_alter to emp_rename; -- emp_alter 를 emp_rename 으로 변경하기

select * from emp_rename; -- emp_rename으로 변경 했으므로 emp_alter는 검색이 안된다.

-----------------------------------------------------

-- 테이블의 전체 데이터 삭제하기
truncate table emp_rename; -- emp_rename 테이블 내용을 삭제하기

select * from emp_rename;  -- 삭제한 테이블 검색해보자

-----------------------------------------------------

-- 테이블 삭제하기
drop table emp_rename; -- emp_rename 테이블 삭제하기

select * from emp_rename;  -- emp_rename 테이블 삭제한 것을 검색해보자

--------------------------------------------------------------------------------




-- 266P 10-1 장

-- 테이블 복사
create table dept_temp
as select * from dept;

select * from dept_temp;

-----------------------------------------------------

-- 복사한 dept_temp 테이블에 데이터 추가하기 
insert into dept_temp (deptno, dname,loc)   -- deptno, dname, loc에 추가하기
values (50,'DATABASE','SEOUL'); -- 부서명 50, 이름에 DATABASE, 지역에 SEOUL 추가

select * from dept_temp; -- 추가한 데이터 검색해보자

-----------------------------------------------------

desc dept_temp;
-- 테이블에 데이터를 추가 하기 위해 맞춰줘야한다.

insert into dept_temp (deptno, dname,loc) -- 테이블에 추가해야되는 내용을 맞춰줘야한다.
values ('a50','DATABASE');           -- 테이블에 추가해야되는 내용이 많거나 적으면 오류

insert into dept_temp (deptno, dname,loc) -- 숫자가 들어가야되는 칸에 문자가 들어가서 오류
values ('a50','DATABASE','SEOUL');        -- (타입이 다를때)

insert into dept_temp (deptno, dname,loc) -- 지정된 값을 초과 했을때 오류
values ('150','DATABASE','SEOUL');        -- (바이트 초과)

-----------------------------------------------------

insert into dept_temp           -- 열(컬럼명) 지정없이 데이터 추가 가능하다
values (60, 'NETWORK','BUSAN');

select * from dept_temp;        -- 추가한 데이터를 검색해보자

-----------------------------------------------------

insert into dept_temp (deptno, dname, loc) -- 테이블에 null 을 지정하여 입력 하기
values (70, 'WEB',NULL);                   -- null을 지정하여 사용 하도록 하자

insert into dept_temp (deptno, dname, loc) -- '' 을 사용하여 null 을 입력 할 수 있다.
values (70, 'WEB','');

select * from dept_temp;                    -- 추가한 데이터를 검색해보자

-------------

insert into dept_temp (deptno, loc) 
values (90, 'INCHEON');  --지정한 컬럼만 넣을 수 있고 제외된 컬럼은 null로 채워진다.

select * from dept_temp;            -- 추가한 데이터를 검색해보자

-----------------------------------------------------

create table emp_temp   -- 내용 없이 테이블 복사
as select *
    from emp
        where 1 <> 1;

select * from emp_temp; -- 추가한 데이터를 검색해보자

-----------------------------------------------------

-- to_date 함수를 사용하여 날짜 데이터 입력하기
insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
        values(2111,'이순신', 'MANAGER',9999,
            to_date ('07/01/2001', 'DD/MM/YYYY'),
            4000, NULL, 20);

-- sysdate를 사용하여 날짜 데이터 입력하기
insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
        values(3111,'춘향이', 'MANAGER',9999,
            sysdate,
            4000, NULL, 30);

select * from emp_temp; -- 추가한 데이터를 검색해보자

-----------------------------------------------------

insert into emp_temp        -- emp 테이블에서 deptno(부서)가 10번인 데이터 복사
select * from emp where deptno = 10;

select * from emp_temp;     -- 추가한 데이터를 검색해보자

-----------------------------(insert into)--end---------------------------------

create table dept_temp2     -- 테이블 복사하기
as select * from dept;

select * from dept_temp2;   -- 추가한 데이터를 검색해보자

-----------------------------------------------------

update dept_temp2       -- LOC가 전부 seoul로 변경된다.
set loc = 'seoul';      -- 조심해서 사용하자.

select * from dept_temp2;

-----------------------------------------------------

update dept_temp2           -- 40번 부서인 DNAME과 LOC를 변경
set dname = 'DATABASE',     -- where 중요★★★★★
    LOC = 'SEOUL'
where deptno = 40;

select * from dept_temp2    -- 변경하기 전에 where 를 먼저 사용하자.
where deptno = 40;

-----------------------------------------------------
-- 급여가 2500 이하인 사원만 추가 수당을 50으로 수정
select * from emp_temp
where sal <= 2500;

update emp_temp
set comm = 50
where sal <= 2500;

-----------------------------------------------------

-- 문제. 연봉이 1000 이하인 사원 연봉을 1.3% 인상
create table emp_temp2    -- 테이블 복사하기
as select * from emp;

select * from emp_temp2;  -- 복사한 테이블 검색

select * from emp_temp2   -- 연봉 1000 이하인 사원 확인
where sal <= 1000;

update emp_temp2  -- 연봉이 1000 이하인 사원 연봉을 1.3% 인상
--set sal = sal * (1+0.013)
set sal = sal + sal *0.013
where sal <= 1000;

---------------------------update--------end------------------------------------

select * from emp_temp2;     -- emp_temp2 모두 검색

select * from emp_temp2      -- emp_temp2 job 에서 MANAGER만 검색
where job = 'MANAGER';

delete from emp_temp3        -- emp_temp2 에서 MANAGER 삭제
where job = 'MANAGER';

-----------------------------------------------------

-- where 절에 서브쿼리를 사용하여 데이터 일부만 삭제하기
-- 부서가 30 중에 급여 등급이 3등급인 사원을 삭제
delete from emp_temp2
where empno in(select e.empno
                    from emp_temp2 e, salgrade s
                    where e.sal between s.losal and s.hisal
                    and s.grade = 3
                    and deptno = 30);

select * from emp_temp2;

-----------------------------------------------------
-- 자동커밋 DDL : create, alter, drop
commit; -- 트랜잭션을 영원히 반영하고 싶을때 commit (커밋) 하면 뒤로가기 안됨

-----------------------------------------------------

create table emp_temp3      -- emp_temp3 복사
as select * from emp;

delete from emp_temp3       -- emp_temp3에서 10번 부서 삭제
where deptno = 10;

select * from emp_temp3;    -- emp_temp3 검색하기

delete from emp_temp3;      -- emp_temp3 삭제하기

rollback;                   -- 되돌리기

-----------------------------------------------------

--COMMIT, ROLLBACK 기억하기

-----------------------------------------------------

-- table
select *
    from user_tables;

-- index 효율적인 검색
select *
    from user_indexes;

-----------------------------------------------------

-- emp 테이블의 sal열에 인덱스를 생성하기
create index idx_emp_sal
on emp(sal asc);

-----------------------------------------------------

select * from emp
order by sal asc;


-----------------------------------------------------

-- 계획설명(f10) 을 클릭해서 옵션 및 cost확인
-- 강제 힌트
select /*+ index(idx_emp_sal) */
    *
from emp
where sal = 3000
order by sal asc;


select --+ index(e)
    *
from emp e
where sal = 3000
order by sal asc;

------------------------index------ end-----------------------------------------

select * from emp_temp2;

-----------------------------------------------------

-- 문제
-- empno가 입사 순서대로 발행되는 번호라고 할때
-- 다음 입사자의 empno는?
-- '신입이'를 입사시키자

select max(empno) from emp_temp2;           -- 가장 큰 empno 조회

select max(empno)+1 from emp_temp2;         -- 가장 큰 empno에 +1 추가

insert into emp_temp2 (empno, ename)        -- +1 추가한 empno와 '신입이'를 추가
values (
     (select max(empno)+1 from emp_temp2),'신입이');

select * from emp_temp2;                    -- 추가한 '신입이'를 확인 해보자

-----------------------------------------------------   시퀀스 증가

-- 시퀀스 (카운트)

create sequence seq_empno   -- 시퀀스 생성
start with 8000             -- 시작 숫자 지정 (기본값 : 1)
increment by 10             -- 증감 숫자 ( 증가/감소 양 ) 감소 하려면 -로 하면된다.
;

select seq_empno.nextval from dual;     -- 다음 시퀀스 값 가져오기
select seq_empno.nextval from dual;

select seq_empno.currval from dual;-- 현재 시퀀스 값 보기
-- nextval을 한번도 사용하지 않은 경우 curravl을 사용 해보기


insert into emp_temp2 (empno, ename)    -- empno를 자동으로 증가시켜줌
values (seq_empno.nextval,'신입');

select * from emp_temp2;                -- 확인하기
-----------------------------------------------------  시퀀스 삭제

drop sequence seq_empno;

----------------------------sequence----end-------------------------------------









------------------------------14장-------제약------------------------------------  

create table table_notnull (
    login_id varchar2(20) not null,
    login_pwd varchar2(20) not null,
    tel varchar2(20)
);

insert into table_notnull (login_id, login_pwd, tel)  -- 추가
values ('test_id_01', '1234', null);        

select * from table_notnull;        -- 검색

alter table table_notnull           -- 제약조건 변경
modify (tel not null);

-- tel에 not null 제약을 주려고 했는데 이미 null이 들어가 있어서 못한다.
-- 그래서 tel이 null인 값들을 일괄적으로 0으로 수정 후 
-- 제약 조건 변경

update table_notnull        -- 업데이트를 통해 tel이 null인 것을 0으로 변경 
set tel = '0'
where tel is null;

alter table table_notnull           -- 제약조건 변경
modify (tel not null);

select * from table_notnull; -- 검색

desc table_notnull;

-----------------------------------------------------

-- constraints를 통해서 삭제 할 수도 있지만
-- modify로 해결 할 수 있다.

select * from user_constraints;

-----------------------------------------------------

select * from user_constraints;
select * from user_indexes;
desc table_pk;
-- primary key, pk, 주요키, 중요키, 기본키
-- not null + unique 조건
-- 생성과 동시에 index도 생성 해줌
-- create table에서 컬럼을 정의하면 
-- primary key를 지정하는 방식으로는 딱 하나만 지정 가능
-- 만약 두개 이상을 pk로 지정(복합키) 하는 경우 
-- alter나 primary key 방식을 이용

-----------------------------------------------------
create table table_pk
    (login_id varchar2(20) primary key,     -- id 컬럼명에 유니크 생성
     login_pwd varchar2(20) not null,       -- null과 동일한 이름이 들어갈수 없게한다
     tel varchar2(20)
    );

insert into table_pk(login_id, login_pwd, tel)      -- 생성
values ( 'TEST_ID_01','PWD01','010-1234-5678');

---------------------안되는것들---------------------------------------------------
insert into table_pk(login_id, login_pwd, tel)      -- 아이디가 중복 될 수 없다.
values ( 'TEST_ID_01','PWD01','010-1234-5678')

insert into table_pk(login_id, login_pwd, tel)      -- null이 들어 갈 수 없다.
values (null,null,null);

insert into table_pk(login_pwd, tel)     -- 테이블 수가 부족하여 에러가 난다.          
values ('123','123');
---------------------안되는것들---------------------------------------------------

select * from table_pk;  -- 검색

-----------------------------------------------------
drop table table_name   -- 테이블 삭제

create table table_name(                --테이블 생성
    col1 varchar2(20),
    col2 varchar2(20),
    col3 varchar2(20),
    
    primary  key (col1, col2)  -- 복합키
);

insert into table_name
values ('id1', 'pw1', null);            -- 추가

insert into table_name
values ('id1', 'pw2', null);            -- 추가

select * from table_name;

-----------------------------------------------------
drop table dept_pk; -- 삭제
create table dept_fk(                   -- dept_fk 테이블 생성
    deptno number(2) primary key,
    dname varchar2(14),
    loc varchar2(13)
    );

create table emp_fk(                    -- emp_fk 테이블 생성
    empno number(4),
    ename varchar2(10),
    deptno number(2) references dept_fk(deptno)
);

insert into dept_fk (deptno, dname, loc)  -- dept_fk 데이터 추가
values (1, 'aaaa','AAAA');


-- dept_fk에 deptno와 동일 하지 않으면 에러가 난다.
insert into emp_fk (empno, ename, deptno)
values (100, '이름',1);


-- dept_fk의 deptno를 references를 하였으므로 변경 할 수 없다.
update dept_fk
set deptno = 3
where deptno = 1;

select * from emp_fk;
select * from dept_fk;

/*
dept_fk 테이블에서 deptno(부서)가 1번과 2번이 있을때
emp_fk deptno(부서)가 1번으로 되어있을때
(dept_fk와 enp_fk의 deptno(부서)가 1번이 동일하므로 1번은 변경 안됨)
dept_fk deptno 2번은 변경 할 수 있다.
*/
-----------------------------------------------------

desc dept;

------------------------------------------------------
-- 1. 테이블의 사원번호(empno)와 사원명(ename)만 출력
select empno,ename from emp;

-- 2. 사원번호가 높은 숫자부터 낮은 숫자 순서로 출력
select empno,ename from emp
order by empno desc;

-- 3. 보안을 위해 앞 2자리는 그대로 출력하고 나머지는 * 기호로 표시 (출력 예시 : 73**)
select ename,
replace (empno,substr(empno,length(empno)/2+1),'**') from emp;
-----------------------------------------------------

-- 1. 사원번호(empno), 사원명(ename), 부서이름(dname), 부서위치(loc) 를 출력하세요
select empno, ename, dname, loc
from emp e join dept d  on (e.deptno = d.deptno);

-- 2. 부서이름 (dname) 기준으로 내림차순 정렬하세요
select empno, ename, dname, loc
from emp e join dept d  on (e.deptno = d.deptno)
order by d.dname desc;
-----------------------------------------------------

select * from emp2;

insert into emp2 (empno, ename, job, mgr, hiredate, sal, comm, deptno)
	values (222,222,'222',222,'2025-02-01',222,222,22);

delete emp2 where empno=1;
commit;

select max(empno), min(empno) from emp2;

create SEQUENCE seq_emp2
start with 8000;

select * from emp2
where upper(ename) like upper('%a%');


select rnum, ename from (
    select rownum rnum, ename from (
        select ename from emp2
        order by ename
    )
)
where rnum >=7 and rnum <=9;
;

insert into emp2
select * from emp2;

select * from emp2
order by ename;

commit;

truncate table emp2;

DECLARE
    v_seq NUMBER := 1;
BEGIN
    FOR i IN 1..100 LOOP
        INSERT INTO emp2 (empno, ename, job, mgr, hiredate, sal, comm, deptno)
        SELECT 
            empno - i, 
            TO_CHAR(i)||ename,
            job,
            mgr - i, 
            hiredate + MOD(i, 30),
            sal + (i * 10),
            comm,
            deptno
        FROM emp;
    END LOOP;
    COMMIT;
END;
/
;


-----------------------------------------------------