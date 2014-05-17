--SET SCHEMA CAP;

-- ====================================
-- 使用者基本資料檔
-- ====================================
--DROP TABLE DEF_USER;
create table DEF_USER (
   OID                  VARCHAR(32)               not null,
   CODE                 VARCHAR(10)               not null,
   NAME                 VARCHAR(12),
   DEPCODE              VARCHAR(4),
   STATUSDESC           VARCHAR(30),
   UPDATER              VARCHAR(10),
   UPDATETIME           TIMESTAMP,
   PASSWORD				VARCHAR(100),
   EMAIL				VARCHAR(128),
   STATUS				VARCHAR(1),
   PRESTATUS			VARCHAR(1),
   CREATOR              VARCHAR(10),
   CREATETIME           TIMESTAMP,
   PWDEXPIREDTIME       TIMESTAMP,
   LASTLOGINTIME        TIMESTAMP,
   DISCRIMINATOR		VARCHAR(31)            not null,
   constraint P_DEF_USER primary key (OID)
);

CREATE UNIQUE INDEX XDEFUSER01
    ON DEF_USER (CODE ASC, DEPCODE ASC);

COMMENT ON TABLE DEF_USER IS '使用者基本資料檔';

COMMENT ON DEF_USER(
	OID      is 'oid',
	CODE   is '行員編號',
	NAME is '行員姓名',
	DEPCODE   is '分行代碼',
	STATUSDESC is '停用原因',
	UPDATER is '最後異動人員',
	UPDATETIME is '修改日期'
);

