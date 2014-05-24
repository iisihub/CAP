package com.iisigroup.cap.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * Handler Type
 * </pre>
 * 
 * @since 2011/11/30
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/30,rodeschen,new
 *          </ul>
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface GridQueryMapping {

	TableMapping[] value();

	public @interface TableMapping {
		public String from();

		public String to();
	}

}
