--SET SCHEMA CAP;

-- ====================================
-- 功能名稱定義檔
-- ====================================
--DROP TABLE DEF_PGM;
create table DEF_PGM (
   PGMCODE              DECIMAL(6,0)           not null,
   PGMTYPE              CHAR(1)                not null,
   SYSTYP               CHAR(1)                not null,
   PGMTYP               DECIMAL(6,0)           not null default 0,
   SEQ                  DECIMAL(5,0),
   PGMNAME              VARCHAR(162),
--   PGMAUTH              DECIMAL(1,0),
   PGMPATH              VARCHAR(40),
   PGMDESC              VARCHAR(108),
   DOCID                VARCHAR(15),
--   AUTOFLAG             CHAR(1)                default '1',
   INPUTFLG             CHAR(1)                not null default '1',
   UPDATER              CHAR(6),
   UPDTIME              TIMESTAMP              default CURRENT TIMESTAMP,
   DISCRIMINATOR		VARCHAR(31)            not null,
   constraint P_DEF_PGM primary key (PGMCODE)
);

CREATE INDEX XDEFPGM01
   ON DEF_PGM (PGMCODE ASC, PGMTYP ASC);

COMMENT ON TABLE DEF_PGM IS '功能名稱定義檔';

COMMENT ON DEF_PGM(
	PGMCODE is '隸屬系統別代號(1碼)+	第N層(1碼:即TYPE:1/2/3…)+	第1層的流水號1碼)+流水號(4碼)	系統別代號 9.後台',
	PGMTYPE is '1:功能導覽第一層(功能列) 	2:功能導覽第二層(大項)	3:功能導覽第三層(細項)',
	SYSTYP is	'對應功能代號第一碼 可轉換英文',
	PGMTYP is	'0表示第1層若為第2層則填入所屬第1層的代號若為第3層則填入所屬第2層代號',	
	SEQ is'1.指本程式所隸屬類別下排列順序如需更換位置則可改此欄值 2.若為1/2層且值為0則表示該項不需顯示',
	PGMNAME is'功能名稱',
--	PGMAUTH is'權限選項',
	PGMPATH is'URL路徑',
	PGMDESC is'備註說明',
	DOCID is'主文件編號',
--	AUTOFLAG is'0.否 1.是',
	INPUTFLG is'0.停用 1.啟用 ',
	UPDATER is'最後異動人員',
	UPDTIME is'修改日期'
);

