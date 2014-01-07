package com.iisigroup.cap.base.service.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.model.CodeItem;
import com.iisigroup.cap.base.service.CodeItemService;
import com.iisigroup.cap.base.service.MenuService;
import com.iisigroup.cap.service.AbstractService;
import com.iisigroup.cap.utils.CapAppContext;

@Service
public class MenuServiceImpl extends AbstractService implements MenuService {

	@Resource
	CodeItemService cis;

	public MenuItem getMenuByRoles(Set<String> roles) {
		MenuItem root = toMenu(cis.findByStep( roles, 1));
		for (MenuItem menu : root.getChild()) {
			menu.setChild(getSubMenuByParent(roles, menu));
		}
		return root;
	}// ;

	private List<MenuItem> getSubMenuByParent(Set<String> roles, MenuItem parent) {
		List<CodeItem> codeList = cis.findByParent(roles, parent.getCode());
		if (codeList != null) {
			List<MenuItem> subMenuList = toMenu(codeList).getChild();
			for (MenuItem item : subMenuList) {
				item.setChild(getSubMenuByParent(roles, item));
			}
			return subMenuList;
		}
		return null;
	}// ;

	public MenuItem toMenu(List<CodeItem> list) {
		// private MenuItem toMenu(List<CodeItem> list) {
		Map<Integer, MenuItem> menuMap = new HashMap<Integer, MenuItem>();
		MenuItem root = new MenuItem();

		Collections.sort(list, new Comparator<CodeItem>() {
			public int compare(CodeItem code1, CodeItem code2) {
				return (code1.getStep() - code2.getStep()) * 100000
						+ (code1.getParent() - code2.getParent()) * 10000
						+ (code1.getSeq() - code2.getSeq());
			}
		});
		for (CodeItem code : list) {
			MenuItem item = new MenuItem();
			item.setCode(code.getCode());
			item.setName(CapAppContext.getMessage("menu."+code.getCode()));
			item.setUrl(code.getPath());
			menuMap.put(item.getCode(), item);

			MenuItem pItem = menuMap.get(code.getParent());
			if (pItem == null) {
				pItem = root;
			}
			pItem.getChild().add(item);
		}
		return root;
	}

	public static class MenuItem implements Serializable {

		private static final long serialVersionUID = 7329433370534984288L;

		int code;

		String name;

		String url;

//		String path;

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

		// public String getPath() {
		// return path;
		// }
		//
		// public void setPath(String path) {
		// this.path = path;
		// }
	}
}
