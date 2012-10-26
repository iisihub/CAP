--SET SCHEMA CAP;

-- ====================================
-- 系統參數資料檔
-- ====================================
--DROP TABLE BSYSPARAM;
CREATE TABLE SYSPARAM (
	 parmId          VARCHAR(30)  NOT NULL,
	 parmValue    	 VARCHAR(300)  NOT NULL,
	 parmDesc      	 VARCHAR(300)   ,
	 lastModifyBy    VARCHAR(10)  ,
	 lastModifyTime  TIMESTAMP,
	 CONSTRAINT P_SYSPARAM PRIMARY KEY (parmId)
);

COMMENT ON TABLE SYSPARAM IS '系統參數資料檔';

COMMENT ON SYSPARAM(
	parmId          IS '參數代碼',
	parmValue       IS '參數值',
	parmDesc        IS '參數說明',
	lastModifyBy    IS '最後修改人',
	lastModifyTime  IS '最後修改時間'
);

