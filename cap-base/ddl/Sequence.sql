--==============================================================
-- Table: SEQUENCE 流水號
--==============================================================
--drop table SEQUENCE;
create table SEQUENCE (
   nodeName           VARCHAR(20) not null,
   nextSeq            int,
   rounds             int,
   lastModifyTime     TIMESTAMP,
   constraint P_SEQUENCE primary key (nodeName)
);

comment on table SEQUENCE is '流水號';
COMMENT ON SEQUENCE(
    oid IS 'oid'
    ,nodeName IS '流水號Node'
    ,nextSeq IS '下一個流水號'
    ,rounds IS '重覆次數'
    ,lastModifyTime IS '最後異動時間'
);
