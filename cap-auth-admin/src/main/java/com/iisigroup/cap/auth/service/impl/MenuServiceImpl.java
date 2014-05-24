package com.iisigroup.cap.auth.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.auth.dao.FunctionDao;
import com.iisigroup.cap.auth.model.Function;
import com.iisigroup.cap.auth.service.MenuService;
import com.iisigroup.cap.base.dao.I18nDao;
import com.iisigroup.cap.base.model.I18n;
import com.iisigroup.cap.operation.simple.SimpleContextHolder;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapSystemConfig;
import com.iisigroup.cap.utils.CapWebUtil;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    FunctionDao codeItemDao;

    @Resource
    private CapSystemConfig config;

    @Resource
    I18nDao i18nDao;

    public MenuItem getMenuByRoles(Set<String> roles) {
        Map<String, I18n> menuI18n = i18nDao.findAsMapByCodeType("menu",
                SimpleContextHolder.get(CapWebUtil.localeKey).toString());
        Map<Integer, MenuItem> menuMap = new HashMap<Integer, MenuItem>();
        MenuItem root = new MenuItem();
        List<Function> list = codeItemDao.findMenuDataByRoles(roles,
                config.getProperty("systemType"));
        for (Function code : list) {
            MenuItem item = new MenuItem();
            item.setCode(code.getCode());
            // 改為從 i18n table 取得字串
            I18n i18n = menuI18n.get("menu." + code.getCode());
            item.setName(i18n == null ? CapAppContext.getMessage("menu."
                    + code.getCode()) : i18n.getCodeDesc());
            item.setUrl(code.getPath());
            menuMap.put(item.getCode(), item);

            MenuItem pItem = menuMap.get(code.getParent());
            if (pItem == null) {
                pItem = root;
            }
            pItem.getChild().add(item);
        }
        return root;
    }// ;

    public static class MenuItem implements Serializable {

        private static final long serialVersionUID = 7329433370534984288L;

        int code;

        String name;

        String url;

        List<MenuItem> child = new LinkedList<MenuItem>();

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<MenuItem> getChild() {
            return child;
        }

        public void setChild(List<MenuItem> child) {
            this.child = child;
        }

        public String toString() {
            return ReflectionToStringBuilder.toString(this,
                    ToStringStyle.SHORT_PREFIX_STYLE, false, false);
        }
    }
}
