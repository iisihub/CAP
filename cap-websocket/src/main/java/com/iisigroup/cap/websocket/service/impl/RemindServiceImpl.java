package com.iisigroup.cap.websocket.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.iisigroup.cap.base.dao.RemindDao;
import com.iisigroup.cap.base.dao.RemindsDao;
import com.iisigroup.cap.base.model.Remind;
import com.iisigroup.cap.base.model.Reminds;
import com.iisigroup.cap.operation.simple.SimpleContextHolder;
import com.iisigroup.cap.security.dao.SecUserDao;
import com.iisigroup.cap.security.model.CapUserDetails;
import com.iisigroup.cap.security.model.User;
import com.iisigroup.cap.utils.CapString;
import com.iisigroup.cap.utils.CapSystemConfig;
import com.iisigroup.cap.utils.CapWebUtil;
import com.iisigroup.cap.websocket.service.RemindService;

@Service
public class RemindServiceImpl implements RemindService {

    @Resource
    private RemindDao remindDao;

    @Resource
    private RemindsDao remindsDao;

    // 當有security 由SessionRegistry取得所有session資料
    @Autowired
    @Qualifier("sessionRegistry")
    private SessionRegistry sessionRegistry;

    @Resource
    private SecUserDao<User> usrDao;

    @Resource
    private CapSystemConfig config;

    @Override
    public List<Reminds> getRemindItems(String[] styleTyp, String locale) {
        if (CapString.isEmpty(locale)) {
            locale = getLocale();
        }
        return remindsDao.findCurrentRemindItem(styleTyp, locale);
    }

    @Override
    public void saveReminds(Reminds remind) {
        remindsDao.merge(remind);
    }

    public String getLocale() {
        return SimpleContextHolder.get(CapWebUtil.localeKey) == null ? "zh_TW" : SimpleContextHolder.get(CapWebUtil.localeKey).toString();
    }

    @Override
    public HashMap<String, CapUserDetails> getCurrentUser() {
        HashMap<String, CapUserDetails> allPrincipal = new HashMap<String, CapUserDetails>();
        List<Object> principals = sessionRegistry.getAllPrincipals();
        if (!CollectionUtils.isEmpty(principals)) {
            for (Object principal : principals) {
                if (principal instanceof CapUserDetails) {
                    CapUserDetails userDetails = (CapUserDetails) principal;
                    allPrincipal.put(userDetails.getUserId(), userDetails);
                }
            }
        }
        return allPrincipal;
    }

    @Override
    public String getUsrEmail(String usrId) {
        User user = usrDao.getUserByLoginId(usrId, null);
        if (user != null) {
            return user.getEmail();
        }
        return "";
    }

    @Override
    public Remind findRemind(String pid) {
        return remindDao.findByPid(pid);
    }

}
