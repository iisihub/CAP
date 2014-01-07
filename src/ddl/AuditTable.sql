
--drop TABLE DEF_AUDITLOG;
CREATE TABLE DEF_AUDITLOG(
	sno         	VARCHAR(30)     NOT NULL,
	mainId       	CHARACTER(32)   ,
	docOid       	CHARACTER(32)   ,
	txId        	VARCHAR(20)     ,
	custId			VARCHAR(10)		,
	dupNo			CHAR(1)			,
	sysId       	CHARACTER(3)    NOT NULL,
	serverName      VARCHAR(20)     NOT NULL,
 	userId    		CHARACTER(6)   	NOT NULL,
 	invokerIp    	CHARACTER(15)   NOT NULL,
  	invokeResult 	CHAR(1),
  	invokeSource 	VARCHAR(128),
 	invokeTarget 	VARCHAR(128),
 	invokeAction   	VARCHAR(50),
 	invokeMemo   	VARCHAR(100),
 	startTime       TIMESTAMP  NOT NULL,
 	endTime         TIMESTAMP,
 	cost            DECIMAL(10,0),
 	constraint P_AUDITLOG PRIMARY KEY (sno)
);

CREATE INDEX XAUDITLOG01
   ON AUDITLOG (startTime ASC,userId ASC);

comment on table DEF_AUDITLOG is '使用者操作記錄';

COMMENT ON DEF_AUDITLOG(
	sno          IS '流水序號',
	mainId        IS '案件編號(mainId)',
	docOid        IS '文件的Oid',
	txId         IS '交易代碼',
	custId       IS '客戶統編',
	dupNo        IS '重覆序號',
	sysId        IS '子系統代碼',
	serverName   IS '服務主機名稱',
	userId    	 IS '使用者',
	invokerIp    IS '用戶端位址',
	invokeResult IS '執行結果碼',
	invokeSource IS '呼叫端名稱',
	invokeTarget IS 'Handler名稱',
	invokeAction IS '執行的METHOD',
	invokeMemo   IS '執行結果備註',
	startTime IS '開始時間',
	endTime IS '結束時間',
	cost IS '執行時間'
);

--drop TABLE DEF_AUDITDATA;
CREATE TABLE DEF_AUDITDATA(
	sno         	VARCHAR(30)   NOT NULL,
	logSno       	VARCHAR(30)   NOT NULL,
	flag        	VARCHAR(1)     ,
 	data      		VARCHAR(10240),
 	constraint P_AUDITDATA PRIMARY KEY (sno)
);

CREATE INDEX XAUDITDATA01
   ON AUDITDATA (logSno ASC);

comment on table DEF_AUDITDATA is '使用者操作記錄明細';

COMMENT ON DEF_AUDITDATA(
	sno          IS 'sno',
	logSno       IS 'LOG的sno',
	flag         IS '資料類型(I:Input,O:Output)',
	data         IS '資料內容'
);

-- UFO@2012-12-20
CREATE INDEX XAUDITLOG03 ON DEF_AUDITLOG (STARTTIME ASC, SNO DESC);
CREATE INDEX XAUDITLOG04 ON DEF_AUDITLOG (ENDTIME ASC, STARTTIME DESC);
CREATE OR REPLACE TRIGGER TRIG_DEL_AUDITLOG AFTER DELETE ON DEF_AUDITLOG REFERENCING OLD AS OLDROW FOR EACH ROW MODE DB2SQL DELETE FROM DEF_AUDITDATA WHERE LOGSNO = OLDROW.SNO;
