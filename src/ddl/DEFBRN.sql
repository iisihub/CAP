--SET SCHEMA CAP;

-- ====================================
-- 單位檔
-- ====================================
--DROP TABLE DEF_BRN;
create table DEF_BRN (
   OID                  CHAR(32)               not null,
   DEPARTNO             CHAR(4)                not null,
   DEPARTNM             VARCHAR(30),
   DEPLEVEL             CHAR(1),
   DEPARTEL             VARCHAR(20),
   DEPARZIP             CHAR(5),
   DEPARADD             VARCHAR(90),
   DEPARTYP             CHAR(1),
   DEPMANAG             VARCHAR(30),
   DEPPROXY             VARCHAR(30),
   DEPARGRP             CHAR(4),
   COUNTTYP             CHAR(2),
   TIMEZONE             CHAR(9),
   ABREKFLG             CHAR(1),
   UPDATER              VARCHAR(10),
   UPDTIME              TIMESTAMP              default CURRENT TIMESTAMP,
   DISCRIMINATOR		VARCHAR(31),
   constraint P_DEF_BRN primary key (DEPARTNO)
);

CREATE UNIQUE INDEX XDEFBRN01
    ON DEF_BRN (DEPARTNO ASC);

COMMENT ON TABLE DEF_BRN IS '單位檔';

COMMENT ON DEF_BRN(
	OID		 is 'oid',
	DEPARTNO is '分行代碼',
	DEPARTNM is '分行名稱',
	DEPLEVEL is '分行層級',
	DEPARTEL is '分行電話',
	DEPARZIP is '郵遞區號',
	DEPARADD is '分行地址',
	DEPARTYP is '單位預設分類',
	DEPMANAG is '分行經理',
	DEPPROXY is '法務代理人',
	DEPARGRP is '所屬區域中心',
	COUNTTYP is '國別',
	TIMEZONE is '格式：GMT Sign Hours : Minutes 例：GMT-08:00',
	ABREKFLG is '停業註記',
	UPDATER is '最後異動人員',
	UPDTIME is '修改日期'
);

