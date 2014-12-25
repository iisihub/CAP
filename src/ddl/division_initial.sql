--==================DIVFTITM 分案因子項目=========================
alter table DIVCTDTL
   drop foreign key "CTDTL_Refere_FTITM";

alter table DIVFTDTL
   drop foreign key "FTDTL_Refere_FTITM";

drop index XDEFCOURT13;

drop table DIVFTITM;

--==============================================================
-- Table: DIVFTITM
--==============================================================
create table DIVFTITM (
   OID                  CHAR(32),
   FACTORNO             CHAR(10)               not null,
   FACTORNM             VARCHAR(60),
   TABLENM              VARCHAR(20),
   COLUMNNM             VARCHAR(20),
   DATATYPE             CHAR(1),
   FACTORREM            VARCHAR(200),
   FACTJSON             VARCHAR(1000),
   INPUTFLG             CHAR(1)                not null default '1',
   UPDATER              CHAR(6),
   UPDATETIME           TIMESTAMP,
   constraint "P_Key_FT_1" primary key (FACTORNO)
);

comment on table DIVFTITM is
'選單產生';

comment on column DIVFTITM.OID is
'OID';

comment on column DIVFTITM.FACTORNO is
'因子項目代碼';

comment on column DIVFTITM.FACTORNM is
'因子項目名稱';

comment on column DIVFTITM.TABLENM is
'DB資料表';

comment on column DIVFTITM.COLUMNNM is
'DB欄位';

comment on column DIVFTITM.DATATYPE is
'屬性';

comment on column DIVFTITM.FACTOREM is
'摘要';

comment on column DIVFTITM.FACTJSON is
'條件式';

comment on column DIVFTITM.INPUTFLG is
'0.停用 1.啟用 ';

comment on column DIVFTITM.UPDATER is
'最後異動人員';

comment on column DIVFTITM.UPDATETIME is
'修改日期';

--==============================================================
-- Index: XDEFCOURT13
--==============================================================
create unique index XDEFCOURT13 on DIVFTITM (

);

--=======================DIVCTITM 分案條件維護====================
alter table DIVCTDTL
   drop foreign key "CTDTL_Refere_CTITM";

alter table DIVRLDTL
   drop foreign key "RLDTL_Refere_CTITM";

drop index XDEFCOURT10;

drop table DIVCTITM;

--==============================================================
-- Table: DIVCTITM
--==============================================================
create table DIVCTITM (
   OID                  CHAR(32),
   DIVCTNO              CHAR(10)               not null,
   DIVCTNM              CHAR(60),
   INPUTFLG             CHAR(1)                not null default '1',
   UPDATER              CHAR(6),
   UPDATETIME           TIMESTAMP,
   DIVCTACTION			VARCHAR(30),
   DIVCTSETTING			VARCHAR(30),
   constraint "P_Key_CT_1" primary key (OID)
);

comment on table DIVCTITM is
'分案條件維護
天數 金額 順序 權數
DIVFTITM 分案因子項目';

comment on column DIVCTITM.OID is
'OID';

comment on column DIVCTITM.DIVCTNO is
'條件代碼';

comment on column DIVCTITM.DIVCTNM is
'條件名稱';

comment on column DIVCTITM.INPUTFLG is
'0.停用 1.啟用 ';

comment on column DIVCTITM.UPDATER is
'最後異動人員';

comment on column DIVCTITM.UPDATETIME is
'修改日期';

--==============================================================
-- Index: XDEFCOURT10
--==============================================================
create unique index XDEFCOURT10 on DIVCTITM (

);

--======================DIVRLITM 分案規則維護=====================
alter table DIVRLDTL
   drop foreign key "RLDTL_Refere_RLITM";

drop index XDEFCOURT16;

drop table DIVRLITM;

--==============================================================
-- Table: DIVRLITM
--==============================================================
create table DIVRLITM (
   OID                  CHAR(32),
   DIVRLNO              CHAR(10)               not null,
   DIVRLNM              CHAR(60),
   DITRLTYP             CHAR(1),
   INPUTFLG             CHAR(1)                not null default '1',
   UPDATER              CHAR(6),
   UPDATETIME           TIMESTAMP,
   constraint "P_Key_RL_1" primary key (DIVRLNO)
);

comment on table DIVRLITM is
'分案規則維護
';

comment on column DIVRLITM.OID is
'OID';

comment on column DIVRLITM.DIVRLNO is
'規則代碼';

comment on column DIVRLITM.DIVRLNM is
'規則名稱';

comment on column DIVRLITM.DITRLTYP is
'均分量化方式';

comment on column DIVRLITM.INPUTFLG is
'0.停用 1.啟用 ';

comment on column DIVRLITM.UPDATER is
'最後異動人員';

comment on column DIVRLITM.UPDATETIME is
'修改日期';

--==============================================================
-- Index: XDEFCOURT16
--==============================================================
create unique index XDEFCOURT16 on DIVRLITM (

);

--========================DIVFTDTL 分案因子項目明細================
alter table DIVFTDTL
   drop foreign key "FTDTL_Refere_FTITM";

drop index XDEFCOURT14;

drop table DIVFTDTL;

--==============================================================
-- Table: DIVFTDTL
--==============================================================
create table DIVFTDTL (
   OID                  CHAR(32)               not null,
   FACTORNO             CHAR(10)               not null,
   RANGENO              CHAR(10),
   RANGENM              CHAR(60),
   RANGE1               VARCHAR(100),
   RANGE2               VARCHAR(100),
   RANGESOR             DECIMAL(2),
   constraint "P_Key_FTDTL_1" primary key (OID)
);

comment on table DIVFTDTL is
'分案因子項目明細';

comment on column DIVFTDTL.OID is
'OID';

comment on column DIVFTDTL.FACTORNO is
'因子代碼';

comment on column DIVFTDTL.RANGENO is
'因子值域明細';

comment on column DIVFTDTL.RANGENM is
'因子值域註解';

comment on column DIVFTDTL.RANGE1 is
'值域一';

comment on column DIVFTDTL.RANGE2 is
'值域二';

comment on column DIVFTDTL.RANGESOR is
'順序';

--==============================================================
-- Index: XDEFCOURT14
--==============================================================
create unique index XDEFCOURT14 on DIVFTDTL (

);

alter table DIVFTDTL
   add constraint "FTDTL_Refere_FTITM" foreign key (FACTORNO)
      references DIVFTITM (FACTORNO)
      on delete restrict;

--======================DIVCTDTL 分案條件明細====================
alter table DIVCTDTL
   drop foreign key "CTDTL_Refere_CTITM";

alter table DIVCTDTL
   drop foreign key "CTDTL_Refere_FTDTL";

drop index XDEFCOURT15;

drop table DIVCTDTL;

--==============================================================
-- Table: DIVCTDTL
--==============================================================
create table DIVCTDTL (
   OID                  CHAR(32),
   DIVCTNO              CHAR(10)               not null,
   DIVRLNO				VARCHAR(10),
   FACTORNO             CHAR(10),
   DIVCTJSON            VARCHAR(5000),
   DIVCTSOR             INT(3),
   constraint "P_Key_CTDTL_1" primary key (OID)
);

comment on table DIVCTDTL is
'分案條件明細

天數 金額 順序 權數';

comment on column DIVCTDTL.OID is
'OID';

comment on column DIVCTDTL.DIVCTNO is
'條件代碼';

comment on column DIVCTDTL.FACTORNO is
'因子項目代碼';

comment on column DIVCTDTL.DIVCTJSON is
'條件值域摘要內容值';

comment on column DIVCTDTL.DIVCTSOR is
'排序';

--==============================================================
-- Index: XDEFCOURT15
--==============================================================
create unique index XDEFCOURT15 on DIVCTDTL (

);

alter table DIVCTDTL
   add constraint "CTDTL_Refere_CTITM" foreign key (DIVCTNO)
      references DIVCTITM (DIVCTNO)
      on delete restrict;

alter table DIVCTDTL
   add constraint "CTDTL_Refere_FTDTL" foreign key (FACTORNO)
      references DIVFTDTL (FACTORNO)
      on delete restrict;

--===============================DIVRLDTL 分案規則明細======================
alter table DIVRLDTL
   drop foreign key "RLDTL_Refere_CTITM";

alter table DIVRLDTL
   drop foreign key "RLDTL_Refere_RLITM";

drop index XDEFCOURT17;

drop table DIVRLDTL;

--==============================================================
-- Table: DIVRLDTL
--==============================================================
create table DIVRLDTL (
   OID                  CHAR(32),
   DIVRLNO              CHAR(10)               not null,
   DIVCTNO              CHAR(10)               not null,
   DIVRLJSON            VARCHAR(5000),
   DIVRLSOR             INT(3),
   constraint "P_Key_RLDTL1" primary key (OID)
);

comment on table DIVRLDTL is
'分案規則明細';

comment on column DIVRLDTL.OID is
'OID';

comment on column DIVRLDTL.DIVRLNO is
'規則代碼';

comment on column DIVRLDTL.DIVCTNO is
'條件代碼';

comment on column DIVRLDTL.DIVRLJSON is
'規則值域摘要內容值';

comment on column DIVRLDTL.DIVRLSOR is
'排序';

--==============================================================
-- Index: XDEFCOURT17
--==============================================================
create unique index XDEFCOURT17 on DIVRLDTL (

);

alter table DIVRLDTL
   add constraint "RLDTL_Refere_CTDTL" foreign key (DIVCTNO)
      references DIVCTDTL (DIVCTNO)
      on delete restrict;

alter table DIVRLDTL
   add constraint "RLDTL_Refere_RLITM" foreign key (DIVRLNO)
      references DIVRLITM (DIVRLNO)
      on delete restrict;

--====================CASEINFO=================================
--==============================================================
-- Table: CASEINFO
--==============================================================
CREATE TABLE PUBLIC.CASEINFO (
	OID 		VARCHAR(32) NOT NULL,
	AMOUNT 		DECIMAL(12,3),
	CASNO 		VARCHAR(20) NOT NULL,
	CPSGRPID 	VARCHAR(20),
	CREATETIME 	TIMESTAMP,
	CREATOR 	VARCHAR(6),
	DELETEDTIME TIMESTAMP,
	DEPARTNO 	VARCHAR(20),
	DOCSTATUS 	VARCHAR(20),
	GRPUPPID 	VARCHAR(20),
	ISCLOSED 	VARCHAR(1),
	OVERDUEDAY 	INTEGER,
	UPDATETIME 	TIMESTAMP,
	UPDATER 	VARCHAR(6),
	PRIMARY 	KEY (OID)
);