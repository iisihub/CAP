
--=====================================
--代碼檔
--=====================================
CREATE TABLE DEF_I18N (
    OID            VARCHAR(32) NOT NULL,
    LOCALE         VARCHAR(5)  NOT NULL,
    CodeType       VARCHAR(32) NOT NULL,
    CODEVALUE      VARCHAR(32) NOT NULL,
    CODEDESC       VARCHAR(300) ,
    CODEORDER      INTEGER,
    UPDATER   VARCHAR(10) ,
    UPDATETIME TIMESTAMP ,
   constraint P_DEF_I18N primary key (OID)
);

CREATE UNIQUE INDEX XDEFI18N01 ON DEF_I18N (
	LOCALE ASC, 
	CodeType ASC, 
	CODEVALUE ASC
);
