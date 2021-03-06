-- 테이블 삭제
DROP TABLE TB_BOARD;

-- 게시판 테이블 생성
CREATE TABLE TB_BOARD (
    BNO     		NUMBER          NOT NULL,
    TITLE   		VARCHAR2(100)   NOT NULL,
    CONTENT 		VARCHAR2(250)   NOT NULL,
    AUTHOR  		VARCHAR2(100)   NOT NULL,
    WRITE_DATE    	DATE            DEFAULT SYSDATE,
    GROUP_ID        NUMBER          NOT NULL,           -- 그룹의 아이디
    DEPTH           NUMBER          NOT NULL,           -- 계층(깊이)
    G_LEVEL         NUMBER          NOT NULL            -- 그룹 내 순서
);

-- 테스트 값
INSERT INTO tb_board VALUES(1, '1번글', '1번글 내용', '문상후', SYSDATE, 1, 0, 1);
INSERT INTO tb_board VALUES(2, '2번글', '2번글 내용', '커머스', SYSDATE, 2, 0 ,1);
INSERT INTO tb_board VALUES(3, '3번글', '3번글 내용', '텀블러', SYSDATE, 3, 0, 1);

-- 2번글에 답글 달기
INSERT INTO tb_board VALUES(4, '2번글 답글', '답글 내용', '답글러', SYSDATE, 2, 1, 2);
INSERT INTO tb_board VALUES(5, '2번글 답글[2]', '답글 내용[2]', '관리자', SYSDATE, 2, 1, 3);