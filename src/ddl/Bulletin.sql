-- *********************************
-- 公告欄
-- *********************************

CREATE TABLE CFG_BULLETIN(
   OID         CHARACTER (32) NOT NULL,
   TITLE       VARCHAR (300),
   CONTENT     VARCHAR (2000),
   LEVEL       INTEGER,
   STARTDATE   DATE,
   ENDDATE     DATE,
   CRTIME      TIMESTAMP DEFAULT CURRENT TIMESTAMP,
   STATUS      CHARACTER (1),
   LOCALE      CHARACTER (5),
   UPDATER     CHARACTER (10),
   UPDTIME     TIMESTAMP,
   CONSTRAINT P_BULLETIN PRIMARY KEY (OID)
)

COMMENT ON TABLE  CFG_BULLETIN IS '公告欄' ;

COMMENT ON  CFG_BULLETIN(
   OID         IS 'Object ID',
   TITLE       IS '標題',
   CONTENT     IS '內文',
   LEVEL       IS '等級: 0=置頂,1=重要,2=普通',
   STARTDATE   IS '開始時間',
   ENDDATE     IS '結束時間',
   CRTIME      IS '建立時間',
   STATUS      IS '狀態: 0:啟用, 1:不啟用',
   LOCALE      IS '語系: zh_TW,zh_CN,en',
   UPDATER     IS '更新人員',
   UPDTIME     IS '更新時間'
);
