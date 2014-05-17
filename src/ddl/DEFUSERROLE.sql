--SET SCHEMA CAP;

-- ====================================
-- 人員角色設定檔
-- ====================================
--DROP TABLE DEF_USERROLE;
create table DEF_USERROLE (
   OID                  VARCHAR(32)               not null,
   USERCODE             CHAR(10)               not null,
   ROLECODE              CHAR(10)                not null,
   UPDATER              CHAR(6),
   UPDATETIME           TIMESTAMP,
   constraint DEF_USERROLE primary key (USERCODE, ROLECODE)
);
