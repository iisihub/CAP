--==============================================================
-- Table: REMIND 提醒通知
--==============================================================
--drop table CFG_REMIND;
create table CFG_REMIND (
   OID                  CHAR(32)               not null,
   CONTENT              VARCHAR(2000),
   SCOPETYP             CHAR(1),
   SCOPEPID             VARCHAR(10),
   STARTDATE            TIMESTAMP,
   ENDDATE              TIMESTAMP,
   CRTIME               TIMESTAMP              default CURRENT TIMESTAMP,
   LOCALE               CHAR(5),
   UPDATER              VARCHAR(10),
   UPDTIME              TIMESTAMP              default CURRENT TIMESTAMP,
   constraint P_REMIND primary key (OID)
);

comment on table CFG_REMIND is '提醒通知';
COMMENT ON CFG_REMIND(
    OID is 'OID',
	CONTENT is '內文',
	SCOPETYP is '0.個人 1.組別(業務) 2.群組 3.部門 9.全體',
	SCOPEPID is '對象號碼',
	STARTDATE is '資料有效期間',
	ENDDATE is '資料有效期間',
	CRTIME is '建立時間',
	LOCALE is '語系',
	UPDATER is '最後異動人員',
	UPDTIME is '修改日期'
);

--==============================================================
-- Table: REMINDS 通知方式
--==============================================================
--drop table CFG_REMINDS;
create table CFG_REMINDS (
   OID                  CHAR(32)               not null,
   PID                  CHAR(32)               not null,
   SCOPEPID             VARCHAR(10),
   STYLETYP             CHAR(1),
   STYLECLR             CHAR(1),
   STYLE                DECIMAL(5,0),
   UNIT                 INTEGER,
   YNFLAG               CHAR(1)                default '0',
   constraint P_REMINDS primary key (OID)
);

comment on table CFG_REMINDS is '通知方式';
COMMENT ON CFG_REMINDS(
    OID is 'OID',
	PID is 'PID',
	SCOPEPID is '對象號碼',
	STYLETYP is '提醒方式',
	STYLECLR is '顏色',
	STYLE is '數值',
	UNIT is '單位',
	YNFLAG is '是否完成'
);
