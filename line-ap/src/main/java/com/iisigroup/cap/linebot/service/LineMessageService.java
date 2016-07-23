package com.iisigroup.cap.linebot.service;

import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.linebot.model.LineContact;

public interface LineMessageService {
    void processRequest(byte[] req);

    Page<LineContact> findLineContactForPage(SearchSetting search);
}
