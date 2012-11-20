--==============================================================
-- Table: SEQUENCE 流水號
--==============================================================
--drop table CFG_SEQUENCE;
create table CFG_SEQUENCE (
   seqNode           VARCHAR(20) not null,
   nextSeq            int,
   rounds             int,
   updateTime     TIMESTAMP,
   constraint P_SEQUENCE primary key (seqNode)
);

comment on table CFG_SEQUENCE is '流水號';
COMMENT ON CFG_SEQUENCE(
    ,seqNode IS '流水號Node'
    ,nextSeq IS '下一個流水號'
    ,rounds IS '重覆次數'
    ,updateTime IS '最後異動時間'
);
