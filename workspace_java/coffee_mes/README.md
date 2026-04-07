# Coffee MES Mockup

원두를 활용한 커피 제품 생산을 가정한 MES 목업 프로젝트입니다.

## 기술 기준
- Front: HTML, CSS, JavaScript
- Back: Java 11, Servlet, JSP
- WAS: Tomcat 9
- DB: Oracle (목업 단계라 SQL 스키마만 포함)

## 포함 화면
- 로그인
- 관리자 대시보드
- 작업자 대시보드
- 기준정보
- 자재관리
- 작업관리
- 생산관리
- 생산리포팅

## 데모 계정
- 관리자: `admin / admin1234`
- 작업자: `worker / worker1234`

## 실행 방법(일반적인 Dynamic Web Project 기준)
1. Eclipse Dynamic Web Project 또는 IntelliJ + Tomcat 환경에 프로젝트를 가져옵니다.
2. `src` 폴더의 Java 소스를 컴파일 경로에 포함합니다.
3. `WebContent`를 웹 루트로 설정합니다.
4. Tomcat 9에 배포 후 `/login`으로 접속합니다.

## 목업 범위
- UI/UX 목업 + 간단한 세션 로그인/권한 분기
- 데이터는 화면 표시용 예시 데이터 위주
- Oracle 연동용 샘플 스키마 포함 (`db/schema.sql`)
- 실제 CRUD / DAO / JDBC 연결은 최소 뼈대만 포함

## 추천 발표 포인트
- 관리자와 작업자 권한 분리
- 원자재 → 작업지시 → 생산 → 검사/실적 → 리포팅 흐름
- 커피 제조 공정에 맞는 메뉴 구성
