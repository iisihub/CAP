--SET SCHEMA CAP;

-- ====================================
-- 使用者基本資料檔
-- ====================================
--DROP TABLE DEF_USER;
create table DEF_USER (
   OID                  CHAR(32)               not null,
   STAFFPID               CHAR(10)               not null,
   STAFFPNM             CHAR(12),
--   STAFFTEL             VARCHAR(20),
--   STAFFEML             VARCHAR(50),
   DEPARTNO               CHAR(4),
--   電催主管                 CHAR(10),
--   法催主管                 CHAR(10),
--   部主註記                 CHAR(10),
--   報管註記                 CHAR(10),
--   系管註記                 CHAR(10),
   APPLYYNF             CHAR(1)                default '1',
   APPLYREM             VARCHAR(30),
   WEIGHTS              DECIMAL(7, 2),
   UPDATER              CHAR(6),
   UPDATETIME           TIMESTAMP,
   constraint P_DEF_USER primary key (OID)
);

CREATE UNIQUE INDEX XDEFUSER01
    ON DEF_USER (UserID ASC, UnitNo ASC);

COMMENT ON TABLE DEF_USER IS '使用者基本資料檔';

COMMENT ON DEF_USER(
	OID      is 'oid',
	UserID   is '行員編號',
	UserName is '行員姓名',
--	STAFFTEL is '連絡電話',
--	STAFFEML is '連絡電郵',
	UnitNo   is '分行代碼',
--	電催主管 is '電催主管',
--	法催主管 is '法催主管',
--	部主註記 is '行政角色',
--	報管註記 is '行政角色',
--	系管註記 is '行政角色',
	APPLYYNF is '0.停用 1.啟用',
	APPLYREM is '停用原因',
	WEIGHTS is 'Weights',
	UPDATER is '最後異動人員',
	UPDATETIME is '修改日期'
);

