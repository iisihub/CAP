--SET SCHEMA CAP;

-- ====================================
-- 系統參數資料檔
-- ====================================
--DROP TABLE BSYSPARAM;
CREATE TABLE SYSPARAM (
	 OID            CHAR(32)   NOT NULL,
	 PARAM          VARCHAR(30)  NOT NULL,
	 PARAMVALUE     VARCHAR(1000)  NOT NULL,
	 PARAMDESC      VARCHAR(300)   ,
	 LASTMODIFYBY   VARCHAR(6)  ,
	 LASTMODIFYTIME TIMESTAMP,
	 CONSTRAINT P_SYSPARAM PRIMARY KEY (oid)
);

CREATE UNIQUE INDEX XSYSPARAM01 ON SYSPARAM (
	PARAM ASC
);

COMMENT ON TABLE SYSPARAM IS '系統參數資料檔';

COMMENT ON SYSPARAM(
	OID            IS 'Object ID',
	PARAM          IS '參數代碼',
	PARAMVALUE     IS '參數值',
	PARAMDESC      IS '參數說明',
	LASTMODIFYBY   IS '最後修改人',
	LASTMODIFYTIME IS '最後修改時間'
);

