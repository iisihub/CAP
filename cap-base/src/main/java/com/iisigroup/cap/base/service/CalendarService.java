package com.iisigroup.cap.base.service;

import java.util.List;

import com.iisigroup.cap.base.model.Remind;

public interface CalendarService {

    public List<Remind> getCalendarData(String userId, String start, String end);
}
