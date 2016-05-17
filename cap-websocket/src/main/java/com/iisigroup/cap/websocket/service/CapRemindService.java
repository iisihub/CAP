package com.iisigroup.cap.websocket.service;

import java.util.HashMap;
import java.util.List;

import com.iisigroup.cap.base.model.Remind;
import com.iisigroup.cap.base.model.Reminds;
import com.iisigroup.cap.security.model.CapUserDetails;

public interface CapRemindService {

    public List<Reminds> getRemindItems(String[] styleTyp, String locale);

    public void saveReminds(Reminds remind);

    public HashMap<String, CapUserDetails> getCurrentUser();

    public String getUsrEmail(String usrId);

    public Remind findRemind(String pid);

}
