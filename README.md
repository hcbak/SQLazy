## SQLazy
어쩌다가 세상에 나온 혁명적으로 게으른 DBMS

![image](https://github.com/user-attachments/assets/82281ee5-c026-46e7-82c7-3230e45b6d48)
샘플 데이터 출처: [IBM Supply Chain Intelligence Suite](https://www.ibm.com/docs/ko/scis?topic=samples-sample-csv-files)

### 게으른 개발자
- [hcbak](https://github.com/hcbak)
- [JIYOUNG-22](https://github.com/JIYOUNG-22)

## 목표
관계형 데이터베이스 관리 시스템을 Java로 구현합니다.

Lazy하게 개발합니다.
> 개발 속도도 Lazy, 실행 속도도 Lazy, 모든 것이 toooooo lazy

### 데이터베이스 구조
먼 미래에 User 권한을 만들기 전 까지는 Plain Data로 관리합니다.

#### 데이터베이스
폴더를 데이터베이스로 칭합니다.

#### 테이블
폴더 안의 csv 파일을 테이블로 칭합니다.

## 현황

### 지원 명령어
- [X] **USE** dbname
- [X] **SHOW** **DATABASES**
- [X] **SHOW** **TABLES**
- [X] **CREATE** **DATABASE** dbname
- [X] **CREATE** **TABLE** tbname column1 column2 column3
- [X] **INSERT** **INTO** tbname **VALUES** value1 value2 value3
- [X] **SELECT** column1 column2 **FROM** tbname
