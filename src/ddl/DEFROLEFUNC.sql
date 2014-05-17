--SET SCHEMA CAP;

-- ====================================
-- 角色與功能項目關連資料檔
-- ====================================
--DROP TABLE DEF_ROLEFUNC;
create table DEF_ROLEFUNC (
   OID                  VARCHAR(32)               not null,
   ROLECODE              VARCHAR(10)            not null,
   FUNCCODE              DECIMAL(6,0)           not null,
   UPDATER              VARCHAR(10),
   UPDATETIME              TIMESTAMP              default CURRENT TIMESTAMP,
   constraint P_DEF_ROLEFUNC primary key (ROLECODE, FUNCCODE)
);

