CREATE TABLE member
(
    `mem_idx`                 INT             NOT NULL    AUTO_INCREMENT COMMENT 'PK(고유번호)',
    `mem_type`                INT             NULL  default 0      COMMENT '회원타입(0:일반 / 1:메이커 / 2: 관리자 / 3: 탈퇴요청 / 4:naver회원)', 
    `mem_email`               VARCHAR(45)     NULL        COMMENT '회원 이메일 겸 아이디', 
    `mem_password`            VARCHAR(150)    NULL        COMMENT '회원 패스워드', 
    `mem_name`                VARCHAR(45)     NULL        COMMENT '회원 이름(회원이름추가-현재)', 
    `mem_phone`               VARCHAR(45)     NULL        COMMENT '전화번호', 
    `mem_birth`               INT             NULL        COMMENT '생년월일', 
    `mem_sex`                 INT             NULL        COMMENT '성별(남: 1,3,5,7/ 여:2,4,6,8)', 
    `mem_lastlogin_datetime`  DATETIME        NULL   default now()     COMMENT '최종 로그인 시간', 
    `mem_register_datetime`   DATETIME        NULL	 default now()     COMMENT '회원 등록일', 
    `mem_email_cert`          TINYINT         NULL   default 0     COMMENT '이메일 인증을 받았는지 여부(0:미인증,1:인증완료)', 
    
    `mem_zipcode`             INT             NULL        COMMENT '우편번호 -다음 우편번호 api', 
    `mem_address1`            VARCHAR(45)     NULL        COMMENT '집주소1 - 도로명 주소 (결제 할때 넣어줌)', 
    `mem_address2`            VARCHAR(45)     NULL        COMMENT '집주소2 - 지번주소', 
    `mem_address3`            VARCHAR(45)     NULL        COMMENT '집주소3 - 상세주소', 
    `mem_address4`            VARCHAR(45)     NULL        COMMENT '집주소4 - 참고항목', 
    `mem_photo`               VARCHAR(45)     NULL        COMMENT '회원 이미지 경로', 
    
    `session_key`             VARCHAR(50)     NULL   default 'none'     COMMENT 'session 아이디 보관', 
    `session_limit`           DATETIME       NULL        COMMENT '자동로그인 유효시간 기록', 
    
    'naver_idx'				  VARCHAR(50)     NULL        COMMENT '네이버로그인을 위한 idx'
    PRIMARY KEY (mem_idx)
);

desc member;
select * from member;
drop table member;

alter table member add naver_idx varchar(50) null COMMENT '네이버로그인을 위한 idx';


CREATE TABLE maker
(
    `maker_idx`       INT            NOT NULL    AUTO_INCREMENT COMMENT '메이커 id', 
    `maker_name`      VARCHAR(45)    NULL        COMMENT '이름', 
    `maker_phone`     VARCHAR(45)    NULL        COMMENT '전화번호', 
    `maker_zipcode`   INT    		 NULL        COMMENT '우편번호', 
    `maker_address1`  VARCHAR(45)    NULL        COMMENT '도로명주소', 
    `maker_address2`  VARCHAR(45)    NULL        COMMENT '지번주소', 
    `maker_address3`  VARCHAR(45)    NULL        COMMENT '상세주소', 
    `maker_address4`  VARCHAR(45)    NULL        COMMENT '참고항목', 
    `maker_intro`     VARCHAR(45)    NULL        COMMENT '메이커 소개', 
    `maker_photo`     VARCHAR(45)    NULL        COMMENT '메이커 이미지 경로', 
    `mem_idx`         INT            NULL        COMMENT '메이커의 개인정보 pk', 
    PRIMARY KEY (maker_idx)
);

drop table maker;
delete from maker;


ALTER TABLE maker
    ADD CONSTRAINT FK_Maker_mem_idx_member_mem_idx FOREIGN KEY (mem_idx)
        REFERENCES member (mem_idx) ON DELETE RESTRICT ON UPDATE RESTRICT;

        
        
drop table member_auth;
CREATE TABLE member_auth
(
    `email_idx`   INT            NOT NULL    AUTO_INCREMENT COMMENT 'PK', 
    `mem_email`   VARCHAR(45)    NULL        COMMENT '이메일 인증이 필요한 회원 아이디겸이메일', 
    `email_key`   VARCHAR(150)    NULL        COMMENT '이메일 인증키', 
    `email_type`  TINYINT        NULL        COMMENT '인증종류 1: 회원가입, 2: 이메일변경, 3: 패스워드 재설정', 
    PRIMARY KEY (email_idx)
);

ALTER TABLE member_auth COMMENT '회원 가입시, 또는 패스워드 분실 시 이메일로 인증키를 발송합니다.';

ALTER TABLE member_auth
    ADD CONSTRAINT FK_member_auth_mem_email_member_mem_email FOREIGN KEY (mem_email)
        REFERENCES member (mem_email) ON DELETE RESTRICT ON UPDATE RESTRICT;