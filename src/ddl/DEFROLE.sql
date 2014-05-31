--SET SCHEMA CAP;

-- ====================================
-- 角色資料檔
-- ====================================
--DROP TABLE DEF_ROLE;
create table DEF_ROLE (
   OID                  VARCHAR(32)               not null,
   CODE              VARCHAR(10)            not null,
   SYSTYPE               CHAR(1),
   STATUS                  CHAR(1),
   NAME              VARCHAR(48),
   DESC                 VARCHAR(60),
   UPDATER              VARCHAR(10),
   UPDATETIME              TIMESTAMP              default CURRENT TIMESTAMP,
   DISCRIMINATOR		VARCHAR(31)            not null,
   constraint P_DEF_ROLE primary key (OID)
);
