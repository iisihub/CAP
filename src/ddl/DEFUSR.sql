--SET SCHEMA CAP;

-- ====================================
-- 使用者基本資料檔
-- ====================================
--DROP TABLE DEF_USR;
create table DEF_USR (
   OID                  CHAR(32)               not null,
   STAFFPID             CHAR(10)               not null,
   STAFFPNM             CHAR(12),
   DEPARTNO             CHAR(4),
   STAFFTEL             VARCHAR(20),
   STAFFEML             VARCHAR(50),
   APPLYYNF             CHAR(1)                default '1',
   APPLYREM             VARCHAR(30),
   WEIGHTS              DECIMAL(5, 2),
   UPDATER              CHAR(6),
   UPDATETIME           TIMESTAMP,
   constraint P_DEF_USR primary key (OID)
);

CREATE UNIQUE INDEX XDEFUSR01
    ON DEF_USR (STAFFPID ASC, DEPARTNO ASC);

COMMENT ON TABLE DEF_USR IS '使用者基本資料檔';

COMMENT ON DEF_USR(
	OID      is 'oid',
	STAFFPID   is '行員編號',
	STAFFPNM is '行員姓名',
	DEPARTNO   is '分行代碼',
	STAFFTEL   is '連絡電話',
    STAFFEML   is '連絡電郵',
	APPLYYNF is '0.停用 1.啟用',
	APPLYREM is '停用原因',
	WEIGHTS is 'Weights',
	UPDATER is '最後異動人員',
	UPDATETIME is '修改日期'
);

