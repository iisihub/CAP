package com.iisigroup.cap.auth.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iisigroup.cap.auth.dao.UserDao;
import com.iisigroup.cap.auth.service.PwdPolicyService;
import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.ICommonDao;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.SecConstants.PwdPloicyKeys;
import com.iisigroup.cap.service.AbstractService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapDate;

@Service
public class PwdPolicyServiceImpl extends AbstractService implements PwdPolicyService {

    @Resource
    ICommonDao commonDao;
    @Resource
    UserDao userDao;

    @Override
    public void updatePwdPolicy(IRequest request) {
        Map<String, Integer> policy = new HashMap<String, Integer>();
        for (PwdPloicyKeys value : PwdPloicyKeys.values()) {
            String key = value.toString().toLowerCase();
            String data = request.get(key.substring(4));
            policy.put(key, Integer.parseInt(data));
            SysParm parm = commonDao.findById(SysParm.class, key);
            if (parm == null) {
                parm = new SysParm();
            }
            parm.setParmId(key);
            parm.setParmValue(data);
            parm.setParmDesc(CapAppContext.getMessage("pwdpolicy." + key.substring(4)));
            parm.setUpdater(CapSecurityContext.getUserId());
            parm.setUpdateTime(CapDate.getCurrentTimestamp());
            commonDao.save(parm);
        }
        // 針對 pwd_expired_day, pwd_account_disable, pwd_account_delete 的處理
        userDao.processUserStatus(policy.get(PwdPloicyKeys.PWD_EXPIRED_DAY.toString().toLowerCase()), policy.get(PwdPloicyKeys.PWD_ACCOUNT_DISABLE.toString().toLowerCase()),
                policy.get(PwdPloicyKeys.PWD_ACCOUNT_DELETE.toString().toLowerCase()));
    }

}
