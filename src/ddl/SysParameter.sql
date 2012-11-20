--SET SCHEMA CAP;

-- ====================================
-- 系統參數資料檔
-- ====================================
--DROP TABLE CFG_SYSPARM;
CREATE TABLE CFG_SYSPARM (
	 parmId          VARCHAR(30)  NOT NULL,
	 parmValue    	 VARCHAR(300)  NOT NULL,
	 parmDesc      	 VARCHAR(300)   ,
	 updater    VARCHAR(10)  ,
	 updateTime  TIMESTAMP,
	 CONSTRAINT P_SYSPARM PRIMARY KEY (parmId)
);

COMMENT ON TABLE CFG_SYSPARM IS '系統參數資料檔';

COMMENT ON CFG_SYSPARM(
	parmId          IS '參數代碼',
	parmValue       IS '參數值',
	parmDesc        IS '參數說明',
	updater		    IS '最後修改人',
	updateTime		IS '最後修改時間'
);

