--SET SCHEMA CAP;

-- ====================================
-- 角色與功能項目關連資料檔
-- ====================================
--DROP TABLE DEF_RLF;
create table DEF_RLF (
   ROLCODE              VARCHAR(10)            not null,
   PGMCODE              DECIMAL(6,0)           not null,
--   PGMAUTH              DECIMAL(1,0),
--   PGMDEPT              VARCHAR(80),
--   AUTOFLAG             CHAR(1),
   UPDATER              VARCHAR(10),
   UPDTIME              TIMESTAMP              default CURRENT TIMESTAMP,
   constraint P_DEF_RLF primary key (ROLCODE, PGMCODE)
);

COMMENT ON TABLE DEF_RLF IS '角色與功能項目關連資料檔';

COMMENT ON DEF_RLF(
	ROLCODE is '角色代號',
	PGMCODE is '功能代碼',
--	PGMAUTH is '權限選項',
--	PGMDEPT is '登入單位代號清單',
--	AUTOFLAG is '0.否 1.是 是否子功能新增時自動在角色內加入該子功能',
	UPDATER is '最後異動人員',
	UPDTIME is '修改日期'
);

