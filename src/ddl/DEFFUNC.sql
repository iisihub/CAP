--SET SCHEMA CAP;

-- ====================================
-- 功能名稱定義檔
-- ====================================
--DROP TABLE DEF_FUNC;
create table DEF_FUNC (
   OID                  VARCHAR(32)               not null,
   CODE              DECIMAL(6,0)           not null,
   LEVEL             CHAR(1)                not null,
   SYSTYPE           CHAR(1)                not null,
   PARENT            DECIMAL(6,0)           not null default 0,
   SEQUENCE          DECIMAL(5,0),
   NAME              VARCHAR(162),
   PATH              VARCHAR(40),
   DESC              VARCHAR(108),
   STATUS            CHAR(1)                not null default '1',
   UPDATER           CHAR(6),
   UPDATETIME        TIMESTAMP              default CURRENT TIMESTAMP,
   DISCRIMINATOR	 VARCHAR(31)            not null,
   constraint P_DEF_FUNC primary key (OID)
);

CREATE INDEX XDEFFUNC01
   ON DEF_FUNC (CODE ASC, PARENT ASC);
