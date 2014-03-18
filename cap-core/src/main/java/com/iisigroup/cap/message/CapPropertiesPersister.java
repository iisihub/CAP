package com.iisigroup.cap.message;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.util.DefaultPropertiesPersister;

public class CapPropertiesPersister extends DefaultPropertiesPersister {
	protected String unescape(String str) {
		return StringEscapeUtils.unescapeJava(str);
	}
}
