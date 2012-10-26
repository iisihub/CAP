--==============================================================
-- Table: SEQUENCE 流水號
--==============================================================
--drop table SEQUENCE;
create table SEQUENCE (
   seqNode           VARCHAR(20) not null,
   nextSeq            int,
   rounds             int,
   lastModifyTime     TIMESTAMP,
   constraint P_SEQUENCE primary key (seqNode)
);

comment on table SEQUENCE is '流水號';
COMMENT ON SEQUENCE(
    ,seqNode IS '流水號Node'
    ,nextSeq IS '下一個流水號'
    ,rounds IS '重覆次數'
    ,lastModifyTime IS '最後異動時間'
);
