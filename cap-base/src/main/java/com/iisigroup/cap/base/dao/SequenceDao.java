package com.iisigroup.cap.base.dao;

import java.util.Map;

import com.iisigroup.cap.base.model.Sequence;
import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.model.Page;

public interface SequenceDao extends IGenericDao<Sequence> {
    Page<Map<String, Object>> listAllForPaging(int start, int fetch);

    void createFromMap(Map<String, Object> map);

    int updateByNodeAndNextSeqFromMap(Map<String, Object> map);

    Sequence findBySeqNode(String seqNode);
}
