--SET SCHEMA CAP;

-- ====================================
-- 代理人檔
-- ====================================
--DROP TABLE DEF_PROXY;
create table DEF_PROXY (
   oid                  CHAR(32)               not null,
   STAFFPID             CHAR(10)               not null,
   PROXYPID             CHAR(10)               not null,
   PROXYBEG             DATE,
   PROXYEND             DATE,
   PROXYFLG             CHAR(1)                default '1',
   UPDATER              CHAR(6),
   UPDATETIME           TIMESTAMP,
   constraint P_DEF_PROXY primary key (oid)
);

COMMENT ON TABLE DEF_PROXY IS '代理人檔';

COMMENT ON DEF_PROXY(
	oid is 'oid',
	STAFFPID is '行員編號',
	PROXYPID is '職務代理',
	PROXYBEG is '代理起日',
	PROXYEND is '代理迄日',
	PROXYFLG is '0.停用 1.啟用',
	UPDATER is '最後異動人員',
	UPDATETIME is '修改日期'
);

