--SET SCHEMA CAP;

-- ====================================
-- 使用者基本資料檔
-- ====================================
--DROP TABLE DEF_USR;
create table DEF_USR (
   OID                  VARCHAR(32)               not null,
   STAFFPID               VARCHAR(10)               not null,
   STAFFPNM             VARCHAR(12),
   DEPARTNO               VARCHAR(4),
   APPLYNF              VARCHAR(1)                default '1',
   APPLYREM             VARCHAR(30),
   WEIGHTS              DECIMAL(5, 2),
   UPDATER              VARCHAR(6),
   UPDATETIME           TIMESTAMP,
   PASSWORD				VARCHAR(64),
   EMAIL				VARCHAR(128),
   STATUS				VARCHAR(1),
   PRESTATUS			VARCHAR(1),
   CREATOR              VARCHAR(6),
   CREATETIME           TIMESTAMP,
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
	APPLYYNF is '0.停用 1.啟用',
	APPLYREM is '停用原因',
	WEIGHTS is 'Weights',
	UPDATER is '最後異動人員',
	UPDATETIME is '修改日期'
);

