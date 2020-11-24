-- 게시판 테이블 생성
CREATE TABLE TB_BOARD (
    BNO     		NUMBER          NOT NULL,
    TITLE   		VARCHAR2(100)   NOT NULL,
    CONTENT 		VARCHAR2(250)   NOT NULL,
    AUTHOR  		VARCHAR2(100)   NOT NULL,
    WRITE_DATE    	DATE            DEFAULT SYSDATE
);

-- 테스트 값
INSERT INTO tb_board VALUES(1, '1번글', '1번글 내용', '문상후', SYSDATE);
INSERT INTO tb_board VALUES(2, '2번글', '2번글 내용', '커머스', SYSDATE);
INSERT INTO tb_board VALUES(3, '3번글', '3번글 내용', '텀블러', SYSDATE);