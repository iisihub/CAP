package com.iisigroup.cap.base.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.RemindDao;
import com.iisigroup.cap.base.model.Remind;
import com.iisigroup.cap.base.service.CalendarService;
import com.iisigroup.cap.operation.simple.SimpleContextHolder;
import com.iisigroup.cap.service.AbstractService;
import com.iisigroup.cap.utils.CapString;
import com.iisigroup.cap.utils.CapWebUtil;

@Service
public class CalendarServiceImpl extends AbstractService implements CalendarService {

    @Resource
    RemindDao remindDao;

    @Override
    public List<Remind> getCalendarData(String userId, String start, String end) {
        if (CapString.isEmpty(start) || CapString.isEmpty(end)) {
            return null;
        }
        return remindDao.getCalendarData(userId, new Timestamp(Long.parseLong(start)), new Timestamp(Long.parseLong(end)), SimpleContextHolder.get(CapWebUtil.localeKey).toString());
    }
}
