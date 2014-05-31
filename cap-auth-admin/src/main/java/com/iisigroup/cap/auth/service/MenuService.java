package com.iisigroup.cap.auth.service;

import java.util.Set;

import com.iisigroup.cap.auth.service.impl.MenuServiceImpl.MenuItem;

public interface MenuService {

    MenuItem getMenuByRoles(Set<String> roles);

}