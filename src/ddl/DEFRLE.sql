--SET SCHEMA CAP;

-- ====================================
-- 角色資料檔
-- ====================================
--DROP TABLE DEF_RLE;
create table DEF_RLE (
   ROLCODE              VARCHAR(10)            not null,
   SYSTYP               CHAR(1),
   UNIT                 CHAR(1),
   STU                  CHAR(1),
   ROLNAME              VARCHAR(48),
   NOTE                 VARCHAR(60),
   UPDATER              VARCHAR(10),
   UPDTIME              TIMESTAMP              default CURRENT TIMESTAMP,
   APPRID               VARCHAR(10),
   APPRTIME             TIMESTAMP,
   constraint P_DEF_RLE primary key (ROLCODE)
);

COMMENT ON TABLE DEF_RLE IS '角色資料檔';

COMMENT ON DEF_RLE(
	ROLCODE is '系統別(1) + 單位類別(1) + SSO角色(4) ',
	SYSTYP is '角色第一碼',
	UNIT is '角色第二碼',
	STU is '0.可使用',
	ROLNAME is '角色名稱',
	NOTE is '說明',
	UPDATER is '最後異動人員',
	UPDTIME is '修改日期',
	APPRID is '核定主管',
	APPRTIME is '核定主管時間'
);

