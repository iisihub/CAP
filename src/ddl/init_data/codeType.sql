--語系
insert into CFG_CODETYPE(OID,LOCALE,CodeType,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) values('lang0000000000000000000000000001','zh_TW','lang','zh_TW','zh_TW',1,'System',current timestamp);
insert into CFG_CODETYPE(OID,LOCALE,CodeType,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) values('lang0000000000000000000000000002','zh_TW','lang','zh_CN','zh_CN',2,'System',current timestamp);
insert into CFG_CODETYPE(OID,LOCALE,CodeType,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) values('lang0000000000000000000000000003','zh_TW','lang','en','en',3,'System',current timestamp);

insert into CFG_CODETYPE(OID,LOCALE,CodeType,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) values('subsystem00000000000000000000001','zh_TW','subsystem','ADM','ADM',1,'System',current timestamp);

INSERT INTO CFG_CODETYPE (OID,LOCALE,CODETYPE,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) VALUES ('6f2766b7393f4f47af98b91615b8c172','zh_TW','userStatus','0','正常',1,'System',current timestamp);
INSERT INTO CFG_CODETYPE (OID,LOCALE,CODETYPE,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) VALUES ('33f733ea9b4e41fda25f3a67af2d6dee','zh_TW','userStatus','1','初始',2,'System',current timestamp);
INSERT INTO CFG_CODETYPE (OID,LOCALE,CODETYPE,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) VALUES ('72ab6b4de0b4462695715ed92c70c2a0','zh_TW','userStatus','2','禁用',3,'System',current timestamp);
INSERT INTO CFG_CODETYPE (OID,LOCALE,CODETYPE,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) VALUES ('8493942681944d12a4b188630406b317','zh_TW','userStatus','3','密碼過期',4,'System',current timestamp);
INSERT INTO CFG_CODETYPE (OID,LOCALE,CODETYPE,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) VALUES ('f8eed05c0d79420fbd3d03260f92ab24','zh_TW','userStatus','9','刪除',5,'System',current timestamp);

INSERT INTO CFG_CODETYPE (OID,LOCALE,CODETYPE,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) VALUES ('3507d9a5a3eb4beea25430e248be6154','zh_TW','pwdrule','0','不檢核',1,'System',current timestamp);
INSERT INTO CFG_CODETYPE (OID,LOCALE,CODETYPE,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) VALUES ('3d28353c152147a1b56dfb44ee621d9b','zh_TW','pwdrule','1','英數字',2,'System',current timestamp);
INSERT INTO CFG_CODETYPE (OID,LOCALE,CODETYPE,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) VALUES ('793ee8dbe2fb456d8e514a837190fc13','zh_TW','pwdrule','2','英數字+符號',3,'System',current timestamp);
INSERT INTO CFG_CODETYPE (OID,LOCALE,CODETYPE,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) VALUES ('1007b741d4ce41c4a1b473ba30766c90','zh_TW','pwdrule','3','大小寫英數字',4,'System',current timestamp);
INSERT INTO CFG_CODETYPE (OID,LOCALE,CODETYPE,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) VALUES ('da0b90844ee944a890296aeea925dba8','zh_TW','pwdrule','4','大小寫英數字+符號',5,'System',current timestamp);
INSERT INTO CFG_CODETYPE (OID,LOCALE,CODETYPE,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) VALUES ('7903cba2cbaa4f7ab4c05fa4021297fc','zh_TW','pwdforcechangepwd','1','是',1,'System',current timestamp);
INSERT INTO CFG_CODETYPE (OID,LOCALE,CODETYPE,CODEVALUE,CODEDESC,CODEORDER,UPDATER,UPDATETIME) VALUES ('61586e943e2f43799ad4d9697d6b6603','zh_TW','pwdforcechangepwd','2','否',2,'System',current timestamp);

insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('unitMins000000000000000000000001','unitMins','60','分鐘',1,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('unitMins000000000000000000000002','unitMins','3600','小時',2,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('unitMins000000000000000000000003','unitMins','86400','天',3,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('unitMins000000000000000000000004','unitMins','604800','週',4,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('scopeTyp000000000000000000000001','scopeTyp','0','個人',1,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('scopeTyp000000000000000000000002','scopeTyp','1','組別(業務)',2,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('scopeTyp000000000000000000000003','scopeTyp','2','群組',3,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('scopeTyp000000000000000000000004','scopeTyp','3','部門',4,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('scopeTyp000000000000000000000005','scopeTyp','9','全體',5,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('scopeTyp000000000000000000000006','styleTyp','0','文字',1,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('scopeTyp000000000000000000000007','styleTyp','1','彈出對話框',2,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('scopeTyp000000000000000000000008','styleTyp','2','電子郵件',3,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('status00000000000000000000000001','status','0','啟用',1,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('status00000000000000000000000002','status','1','停用',2,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('level000000000000000000000000001','level','0','置頂',1,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('level000000000000000000000000002','level','1','重要',2,'zh_TW','system',current timestamp);
insert into cfg_CodeType(oid,codeType,codeValue,CodeDesc,codeOrder,locale,updater,updateTime) values('level000000000000000000000000003','level','2','普通',3,'zh_TW','system',current timestamp);
