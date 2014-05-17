package com.iisigroup.cap.auth.batch.processor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.iisigroup.cap.utils.CapDate;

@Component
public class PwdExpiredProcessor implements
        ItemProcessor<Map<String, Object>, Map<String, Object>> {

    @Override
    public Map<String, Object> process(Map<String, Object> item)
            throws Exception {
        String userCode = (String) item.get("code");
        Timestamp lastpwd = (Timestamp) item.get("pwdexpiredtime");
        if (CapDate.calculateDays(lastpwd, new Date()) < 0) {
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("userCode", userCode);
            return result;
        }
        return null;
    }

}
