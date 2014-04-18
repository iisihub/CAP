package com.iisigroup.cap.base.service;

import java.util.List;
import java.util.Set;

import com.iisigroup.cap.base.model.CodeItem;
import com.iisigroup.cap.base.service.impl.MenuServiceImpl.MenuItem;

public interface MenuService {
	
	MenuItem getMenuByRoles(Set<String> roles);

	MenuItem toMenu(List<CodeItem> list);

}