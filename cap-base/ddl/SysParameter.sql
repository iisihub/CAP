--SET SCHEMA CAP;

-- ====================================
-- 系統參數資料檔
-- ====================================
--DROP TABLE CFG_SYSPARAM;
CREATE TABLE CFG_SYSPARAM (
	 parmId          VARCHAR(30)  NOT NULL,
	 parmValue    	 VARCHAR(300)  NOT NULL,
	 parmDesc      	 VARCHAR(300)   ,
	 updater    VARCHAR(10)  ,
	 updateTime  TIMESTAMP,
	 CONSTRAINT P_SYSPARAM PRIMARY KEY (parmId)
);

COMMENT ON TABLE CFG_SYSPARAM IS '系統參數資料檔';

COMMENT ON CFG_SYSPARAM(
	parmId          IS '參數代碼',
	parmValue       IS '參數值',
	parmDesc        IS '參數說明',
	updater		    IS '最後修改人',
	updateTime		IS '最後修改時間'
);

