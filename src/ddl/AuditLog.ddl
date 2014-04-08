
--=====================================
--SCH_SCHEDULES 排程設定檔
--=====================================
--DROP TABLE AUDIT_LOG
CREATE TABLE AUDIT_LOG (
    id             VARCHAR(32) NOT NULL,
    user_id        VARCHAR(20),
    ip_address     VARCHAR(50),
    function_id    VARCHAR(20),
    action         VARCHAR(20),
    execute_date   DATETIME,
    remark         VARCHAR(50),
    CONSTRAINT P_AUDIT_LOG PRIMARY KEY (id)
);

COMMENT ON TABLE AUDIT_LOG IS '使用軌跡表格';

COMMENT ON AUDIT_LOG(
	user_id    		IS '使用者SSOID',
	ip_address         	IS 'IP 位址',
	function_id		IS '作業代號',
	action   		IS '新增/修改/刪除/查詢/匯出/匯入',
	execute_date 	IS '執行時間'	,
	remark		IS '備註/Key值'
);
