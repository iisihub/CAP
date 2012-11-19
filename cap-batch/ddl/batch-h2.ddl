
--=====================================
--SCH_SCHEDULES 排程設定檔
--=====================================
CREATE TABLE BATCH_SCHEDULE(
	schID			varchar(80)		not null,
	schDesc			varchar(300),
	jobId			varchar(100)  	not null,
	isEnabled		varchar(1),
	schType			varchar(1)		not null 	default 'C',
	cronExpression 	varchar(120),
	timeZoneId 		varchar(80)					default 'GMT',
	repeatCount 	bigint,
  	repeatInterval 	bigint,
  	priority 		integer						default 5,
  	exeHost			varchar(100),
	jobData 		blob(2000),
	isNotify		varchar(1),
	notifyStatus	varchar(50),
	notifyTo		varchar(200),
	updater    		varchar(10),
    updateTime 		timestamp,
	CONSTRAINT P_SCHEDULE PRIMARY KEY (schID)
);

COMMENT ON TABLE BATCH_SCHEDULE IS '排程設定檔';

COMMENT ON BATCH_SCHEDULE(
	schID			IS 'Schedule ID',
	schDesc    		IS '說明',
	jobID         	IS 'Job ID',
	isEnabled		IS '是否啟用(Y/N)',
	schType   		IS '類別 (C:Cron/T:Timer)',
	cronExpression 	IS '定時執行週期'	,
	timeZoneId		IS '時區代碼',
	repeatCount		IS '重覆次數',
	repeatInterval	IS '重覆時間區間',
	priority		IS '優先順序',
	exeHost			IS '執行主機',
	jobData			IS 'jobMapData參數',
	isNotify		IS '是否mail通知(Y/N)',
	notifyCode 		IS '執行狀態通知',
	notifyTo		IS 'mail收件人',
	updater			IS '修改人',
	updateTime		IS '修改時間'
);

--=====================================
--BATCH_JOB JOB資訊檔
--=====================================
CREATE TABLE BATCH_JOB (
    jobId			varchar(100)  	NOT NULL,
    jobDesc			varchar(300) 	NOT NULL,
    jobResource		varchar(200)  	NOT NULL,
    updater			varchar(10) ,
    updateTime			timestamp,
    CONSTRAINT P_BATCH_JOB PRIMARY KEY (JOBID)
);

COMMENT ON TABLE BATCH_JOB IS 'JOB資訊檔';

COMMENT ON BATCH_JOB(
	jobId       IS 'Job ID',
	jobDesc     IS 'Job說明',
	jobResource	IS 'Job設定檔路徑',
	updater   	IS '修改人',
	updateTime 	IS '修改時間'	
);

--=====================================
--Copy from spring-batch-core/org.springframework.batch.core/schema-xx.sql
--=====================================
CREATE TABLE BATCH_JOB_INSTANCE  (
	JOB_INSTANCE_ID BIGINT IDENTITY NOT NULL PRIMARY KEY ,  
	VERSION 		BIGINT ,  
	JOB_NAME 		VARCHAR(100) NOT NULL, 
	JOB_KEY 		VARCHAR(32) NOT NULL,
	constraint JOB_INST_UN unique (JOB_NAME, JOB_KEY)
) ;

CREATE TABLE BATCH_JOB_EXECUTION  (
	JOB_EXECUTION_ID BIGINT IDENTITY NOT NULL PRIMARY KEY ,
	VERSION 		 BIGINT  ,  
	JOB_INSTANCE_ID  BIGINT NOT NULL,
	CREATE_TIME 	 TIMESTAMP NOT NULL,
	START_TIME 		 TIMESTAMP DEFAULT NULL , 
	END_TIME 		 TIMESTAMP DEFAULT NULL ,
	STATUS 			 VARCHAR(10) ,
	EXIT_CODE 		 VARCHAR(100) ,
	EXIT_MESSAGE 	 VARCHAR(2500) ,
	LAST_UPDATED 	 TIMESTAMP,
	constraint JOB_INST_EXEC_FK foreign key (JOB_INSTANCE_ID)
	references BATCH_JOB_INSTANCE(JOB_INSTANCE_ID)
) ;
	
CREATE TABLE BATCH_JOB_PARAMS  (
	JOB_INSTANCE_ID BIGINT NOT NULL ,
	TYPE_CD 		VARCHAR(6) NOT NULL ,
	KEY_NAME 		VARCHAR(100) NOT NULL , 
	STRING_VAL 		VARCHAR(250) , 
	DATE_VAL 		TIMESTAMP DEFAULT NULL ,
	LONG_VAL 		BIGINT ,
	DOUBLE_VAL 		DOUBLE PRECISION ,
	constraint JOB_INST_PARAMS_FK foreign key (JOB_INSTANCE_ID)
	references BATCH_JOB_INSTANCE(JOB_INSTANCE_ID)
) ;
	
CREATE TABLE BATCH_STEP_EXECUTION  (
	STEP_EXECUTION_ID 	BIGINT IDENTITY NOT NULL PRIMARY KEY ,
	VERSION 		  	BIGINT NOT NULL,  
	STEP_NAME 		  	VARCHAR(100) NOT NULL,
	JOB_EXECUTION_ID  	BIGINT NOT NULL,
	START_TIME 		  	TIMESTAMP NOT NULL , 
	END_TIME 		  	TIMESTAMP DEFAULT NULL ,  
	STATUS 			  	VARCHAR(10) ,
	COMMIT_COUNT 		BIGINT , 
	READ_COUNT 			BIGINT ,
	FILTER_COUNT 		BIGINT ,
	WRITE_COUNT 		BIGINT ,
	READ_SKIP_COUNT 	BIGINT ,
	WRITE_SKIP_COUNT 	BIGINT ,
	PROCESS_SKIP_COUNT 	BIGINT ,
	ROLLBACK_COUNT 		BIGINT , 
	EXIT_CODE 			VARCHAR(100) ,
	EXIT_MESSAGE 		VARCHAR(2500) ,
	LAST_UPDATED 		TIMESTAMP,
	constraint JOB_EXEC_STEP_FK foreign key (JOB_EXECUTION_ID)
	references BATCH_JOB_EXECUTION(JOB_EXECUTION_ID)
) ;

CREATE TABLE BATCH_STEP_EXECUTION_CONTEXT  (
	STEP_EXECUTION_ID 	BIGINT NOT NULL PRIMARY KEY,
	SHORT_CONTEXT 		VARCHAR(2500) NOT NULL,
	SERIALIZED_CONTEXT 	LONGVARCHAR , 
	constraint STEP_EXEC_CTX_FK foreign key (STEP_EXECUTION_ID)
	references BATCH_STEP_EXECUTION(STEP_EXECUTION_ID)
) ;

CREATE TABLE BATCH_JOB_EXECUTION_CONTEXT  (
	JOB_EXECUTION_ID 	BIGINT NOT NULL PRIMARY KEY,
	SHORT_CONTEXT 		VARCHAR(2500) NOT NULL,
	SERIALIZED_CONTEXT 	LONGVARCHAR , 
	constraint JOB_EXEC_CTX_FK foreign key (JOB_EXECUTION_ID)
	references BATCH_JOB_EXECUTION(JOB_EXECUTION_ID)
) ;

CREATE SEQUENCE BATCH_STEP_EXECUTION_SEQ;
CREATE SEQUENCE BATCH_JOB_EXECUTION_SEQ;
CREATE SEQUENCE BATCH_JOB_SEQ;

alter table BATCH_JOB_EXECUTION add column executor varchar(10);
