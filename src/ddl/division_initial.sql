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
   FACTOREM             VARCHAR(200),
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

--====================CASE_INFO=================================
--==============================================================
-- Table: CASE_INFO
--==============================================================
create table CASE_INFO (
   "oid"                CHAR(32),
   "uid"                CHAR(32),
   "mainId"             CHAR(32),
   CPSCASNO             VARCHAR(20)            not null,
   "---案件資訊---"         CHAR(10),
   表單種類                 CHAR(1),
   CPTDDPBN             CHAR(10),
   docStatus          CHAR(3),
   "lcdStatus"          CHAR(3),
   "altStatus"          CHAR(3),
   "assStatus"          CHAR(3),
   "accStatus"          CHAR(3),
   CPTDDBHI             CHAR(4),
   CIRCIINM             VARCHAR(20),
   "---分案資訊---"         CHAR(10),
   DEPARTNO             CHAR(4),
   GRPUPPID             CHAR(4),
   CPSGRPID             CHAR(10),
   PROXYPID             CHAR(10),
   "---借款人資訊---"        CHAR(10),
   CPTDDCID             VARCHAR(10),
   CPTDDCNM             VARCHAR(120),
   CPTNSCBD             CHAR(10),
   CPTLNCPY             VARCHAR(120),
   CPTLNPOS             CHAR(10),
   CPTLNMAS             CHAR(1),
   CPTDDCRD             CHAR(1),
   CPTDDSAM             CHAR(1),
   擔保                   CHAR(1),
   保證人                  CHAR(1),
   展期註記                 CHAR(1),
   ETABSIND             CHAR(1),
   CPTNSCOM             CHAR(10),
   "---註記彙總---"         CHAR(10),
   CPTDDDCR             CHAR(4),
   CPTDDREV             CHAR(1),
   更生結案狀態碼              CHAR(2),
   CPTDDLIQ             CHAR(1),
   清算結案狀態碼              CHAR(2),
   CPTDDDEM             CHAR(1),
   CPTDDSPC             CHAR(10),
   CPTDDCRN             CHAR(1),
   CPTDDSOP1            CHAR(1),
   CPTDDSOP             CHAR(1),
   CPTDDSTS             CHAR(1),
   "---系統資訊---"         CHAR(10),
   DOCURL               VARCHAR(40),
   TXCODE               CHAR(6),
   BATCHDAT             DATE,
   CPTDDDAT             DATE,
   CREATOR              CHAR(6),
   CREATETIME           TIMESTAMP,
   UPDATER              CHAR(6),
   UPDATETIME           TIMESTAMP,
   APPROVER             CHAR(6),
   APPROVETIME          TIMESTAMP,
   ISCLOSED             CHAR(1),
   DELETEDTIME          TIMESTAMP,
   DATASCHEMA           VARCHAR(5),
   constraint "P_Key_CASE_INFO_1" primary key (CPSCASNO)
);

comment on table CASE_INFO is
'事後管理追蹤表
案件資訊 基本資料';

comment on column CASE_INFO."oid" is
'oid';

comment on column CASE_INFO."uid" is
'uid';

comment on column CASE_INFO."mainId" is
'mainId';

comment on column CASE_INFO.CPSCASNO is
'案件編號';

comment on column CASE_INFO."---案件資訊---" is
'---案件資訊---';

comment on column CASE_INFO.表單種類 is
'1.一般 2.KBB';

comment on column CASE_INFO.CPTDDPBN is
'批覆書編號';

comment on column CASE_INFO."docStatus" is
'案件狀態';

comment on column CASE_INFO."lcdStatus" is
'協商狀態';

comment on column CASE_INFO."altStatus" is
'特殊狀態';

comment on column CASE_INFO."assStatus" is
'協辦狀態';

comment on column CASE_INFO."accStatus" is
'帳務狀態';

comment on column CASE_INFO.CPTDDBHI is
'債權單位';

comment on column CASE_INFO.CIRCIINM is
'徵信經辦';

comment on column CASE_INFO."---分案資訊---" is
'---分案資訊---';

comment on column CASE_INFO.DEPARTNO is
'部門';

comment on column CASE_INFO.GRPUPPID is
'群組代碼';

comment on column CASE_INFO.CPSGRPID is
'催收經辦';

comment on column CASE_INFO.PROXYPID is
'職務代理';

comment on column CASE_INFO."---借款人資訊---" is
'---借款人資訊---';

comment on column CASE_INFO.CPTDDCID is
'統一編號';

comment on column CASE_INFO.CPTDDCNM is
'客戶名稱';

comment on column CASE_INFO.CPTNSCBD is
'出生年月日';

comment on column CASE_INFO.CPTLNCPY is
'公司名稱';

comment on column CASE_INFO.CPTLNPOS is
'職稱';

comment on column CASE_INFO.CPTLNMAS is
'1.已婚 2.未婚 3.其他';

comment on column CASE_INFO.CPTDDCRD is
'0.無 1.有效卡 2.流通卡 3.申請停用 4.強制停用 ';

comment on column CASE_INFO.CPTDDSAM is
'0.否 1.是';

comment on column CASE_INFO.擔保 is
'0.否 1.是';

comment on column CASE_INFO.保證人 is
'0.否 1.是';

comment on column CASE_INFO.展期註記 is
'0.否 1.是';

comment on column CASE_INFO.ETABSIND is
'0.否 1.是';

comment on column CASE_INFO.CPTNSCOM is
'特記事項';

comment on column CASE_INFO."---註記彙總---" is
'---註記彙總---';

comment on column CASE_INFO.CPTDDDCR is
'債務清理註記';

comment on column CASE_INFO.CPTDDREV is
'更生註記';

comment on column CASE_INFO.更生結案狀態碼 is
'更生結案狀態碼';

comment on column CASE_INFO.CPTDDLIQ is
'清算註記';

comment on column CASE_INFO.清算結案狀態碼 is
'清算結案狀態碼';

comment on column CASE_INFO.CPTDDDEM is
'債務展延';

comment on column CASE_INFO.CPTDDSPC is
'特殊案件註記';

comment on column CASE_INFO.CPTDDCRN is
'債務協商狀態';

comment on column CASE_INFO.CPTDDSOP1 is
'個別性一致協商';

comment on column CASE_INFO.CPTDDSOP is
'停扣註記';

comment on column CASE_INFO.CPTDDSTS is
'DD狀態';

comment on column CASE_INFO."---系統資訊---" is
'---系統資訊---';

comment on column CASE_INFO.DOCURL is
'文件URL';

comment on column CASE_INFO.TXCODE is
'交易代碼';

comment on column CASE_INFO.BATCHDAT is
'批次更新使用';

comment on column CASE_INFO.CPTDDDAT is
'資料更新使用';

comment on column CASE_INFO.CREATOR is
'建立人員號碼';

comment on column CASE_INFO.CREATETIME is
'建立日期';

comment on column CASE_INFO.UPDATER is
'最後異動人員';

comment on column CASE_INFO.UPDATETIME is
'修改日期';

comment on column CASE_INFO.APPROVER is
'結案核准人員';

comment on column CASE_INFO.APPROVETIME is
'核准日期';

comment on column CASE_INFO.ISCLOSED is
'Y: 已結案 N: 未結案 文件鎖定檢查時使用';

comment on column CASE_INFO.DELETEDTIME is
'編製中邏輯刪除使用';

comment on column CASE_INFO.DATASCHEMA is
'來源SCHEMA';
