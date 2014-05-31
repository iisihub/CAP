--SET SCHEMA CAP;

-- ====================================
-- 單位檔
-- ====================================
--DROP TABLE DEF_DEP;
create table DEF_DEP (
   OID                  CHAR(32)               not null,
   CODE                 CHAR(4)                not null,
   NAME                 VARCHAR(30),
   LEVEL                CHAR(1),
   TEL                  VARCHAR(20),
   ZIP                  CHAR(5),
   ADDR                 VARCHAR(90),
   DIVISION             CHAR(4),
   MANAGER              VARCHAR(30),
   PROXY                VARCHAR(30),
   BIZGROUP             CHAR(4),
   COUNTRY              CHAR(2),
   TIMEZONE             CHAR(9),
   STATUS               CHAR(1),
   UPDATER              VARCHAR(10),
   UPDATETIME           TIMESTAMP              default CURRENT TIMESTAMP,
   DISCRIMINATOR		VARCHAR(31)            not null,
   constraint P_DEF_DEP primary key (OID)
);

CREATE UNIQUE INDEX XDEFBRN01
    ON DEF_DEP (CODE ASC);

COMMENT ON TABLE DEF_DEP IS '單位檔';

COMMENT ON DEF_DEP(
	OID		   is 'oid',
	CODE       is '分行代碼',
	NAME       is '分行名稱',
	LEVEL      is '分行層級',
	TEL        is '分行電話',
	ZIP        is '郵遞區號',
	ADDR       is '分行地址',
	DIVISION   is '單位預設分類',
	MANAGER    is '分行經理',
	PROXY      is '法務代理人',
	BIZGROUP   is '所屬區域中心',
	COUNTRY    is '國別',
	TIMEZONE   is '格式：GMT Sign Hours : Minutes 例：GMT-08:00',
	STATUS     is '停業註記',
	UPDATER    is '最後異動人員',
	UPDATETIME is '修改日期'
);

