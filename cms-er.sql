
/* Drop Tables */

DROP TABLE employee CASCADE CONSTRAINTS;
DROP TABLE DEPARTMENT CASCADE CONSTRAINTS;
DROP TABLE USER_ROLE CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE DEPARTMENT
(
	DEPT_CODE number NOT NULL,
	DEPT_NAME varchar2(45) UNIQUE,
	PRIMARY KEY (DEPT_CODE)
);


CREATE TABLE employee
(
	EMP_NO number NOT NULL,
	EMP_ID varchar2(45) NOT NULL UNIQUE,
	EMP_PWD varchar2(100) NOT NULL,
	EMP_NAME varchar2(45) NOT NULL,
	BIRTH date NOT NULL,
	GENDER varchar2(45) NOT NULL,
	PHONE varchar2(45),
	EMAIL varchar2(45),
	ADDRESS varchar2(45),
	JOIN_DATE timestamp,
	WITHDRAW_DATE timestamp,
	EMP_STATUS varchar2(0),
	DEPT_CODE number NOT NULL,
	PRIMARY KEY (EMP_NO)
);


CREATE TABLE USER_ROLE
(
	-- 회원가입시 입력받는 유저 아이디
	ID varchar2(100) NOT NULL,
	-- 유저 권한을 설정한다.
	ROLE_NAME varchar2(10) DEFAULT 'ROLE_GUEST' NOT NULL,
	PRIMARY KEY (ID)
);



/* Create Foreign Keys */

ALTER TABLE employee
	ADD FOREIGN KEY (DEPT_CODE)
	REFERENCES DEPARTMENT (DEPT_CODE)
;



/* Comments */

COMMENT ON COLUMN USER_ROLE.ID IS '회원가입시 입력받는 유저 아이디';
COMMENT ON COLUMN USER_ROLE.ROLE_NAME IS '유저 권한을 설정한다.';



