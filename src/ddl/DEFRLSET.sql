--SET SCHEMA CAP;

-- ====================================
-- 人員角色設定檔
-- ====================================
--DROP TABLE DEF_RLSET;
create table DEF_RLSET (
   STAFFPID             CHAR(10)               not null,
   ROLCODE              CHAR(10)                not null,
   UPDATER              CHAR(6),
   UPDATETIME           TIMESTAMP,
   DISCRIMINATOR		VARCHAR(31),
   constraint P_DEF_RLSET primary key (STAFFPID, ROLCODE)
);

COMMENT ON TABLE DEF_RLSET IS '人員角色設定檔';

COMMENT ON DEF_RLSET(
	STAFFPID is '行員編號',
	ROLCODE is '角色代碼',
	UPDATER is '最後異動人員',
	UPDATETIME is '修改日期'
);

