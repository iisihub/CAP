package com.iisigroup.websocket.service;

import java.util.List;

import com.iisigroup.cap.base.model.Remind;

public interface CapCalendarService {

	public List<Remind> getCalendarData(String userId, String start, String end);
}
