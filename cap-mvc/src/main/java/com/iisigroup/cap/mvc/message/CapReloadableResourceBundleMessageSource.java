/* 
 * CapReloadableResourceBundleMessageSource.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.mvc.message;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.iisigroup.cap.utils.StringUtil;

/**
 * <pre>
 * ReloadableResourceBundleMessageSource
 * </pre>
 * 
 * @since 2011/12/23
 * @author rodeschen
 * @version <ul>
 *          <li>2011/12/23,rodeschen,new
 *          <li>2011/12/29,rodeschen,fix windows reg
 *          </ul>
 */
public class CapReloadableResourceBundleMessageSource extends org.springframework.context.support.ReloadableResourceBundleMessageSource {

	private final String i18nFileREG = "(_zh_CN|_en|_zh_TW).properties$";
	private final String i18nPath = "/i18n";

	public CapReloadableResourceBundleMessageSource() {
		//Resource[] rs = null;
		Set<String> l = new HashSet<String>();
		try {
			List<File> files = getResource(new File(getClass().getResource(i18nPath).getFile()));
			//rs = AppContext.getApplicationContext().getResources(i18nPath);
			for (File f : files) {
				//File f = r.getFile();
				if (f.isFile()) {
					String path = f.getAbsolutePath();
					if (StringUtil.checkRegularMatch(path, i18nFileREG)) {
						path = path.replaceAll(i18nFileREG, "").replaceAll(".*/i18n/", "classpath:/i18n/")
						// for windows
								.replaceAll(".*\\\\i18n\\\\", "classpath:\\\\i18n\\\\").replaceAll("\\\\", "/");
						l.add(path);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.setBasenames(l.toArray(new String[l.size()]));
	}

	private List<File> getResource(File file) {
		ArrayList<File> fs = new ArrayList<File>();
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				if (f.isDirectory()) {
					fs.addAll(getResource(f));
				} else {
					fs.add(f);
				}
			}
		} else {
			fs.add(file);
		}
		return fs;
	}
}
