--SET SCHEMA CAP;

-- ====================================
-- 密碼歷史資訊
-- ====================================
--DROP TABLE DEF_PWDLOG;
create table DEF_PWDLOG (
   OID                  CHAR(32)               not null,
   USERCODE                 CHAR(4)                not null,
   PASSWORD                 VARCHAR(100),
   UPDATETIME           TIMESTAMP              default CURRENT TIMESTAMP,
   DISCRIMINATOR		VARCHAR(31)            not null,
   constraint P_DEF_PWDLOG primary key (OID)
);

CREATE UNIQUE INDEX XDEFPWLG01
    ON DEF_PWDLOG (OID ASC);

COMMENT ON TABLE DEF_DEP IS '密碼歷史資訊';

COMMENT ON DEF_DEP(
	OID		   is 'oid',
	USERCODE       is '使用者代號',
	PASSWORD       is '密碼',
	UPDATETIME is '修改日期'
);

