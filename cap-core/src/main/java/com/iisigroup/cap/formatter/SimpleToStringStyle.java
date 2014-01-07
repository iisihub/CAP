package com.iisigroup.cap.formatter;

import org.apache.commons.lang.builder.ToStringStyle;

/**
 * <pre>
 * 字串區隔符號 |
 * </pre>
 * @since  2012/2/10
 * @author UFOJ
 * @version <ul>
 *           <li>2012/2/10,UFOJ,new
 *          </ul>
 */
public class SimpleToStringStyle extends ToStringStyle {

    private static final long serialVersionUID = -1869523349887289312L;

    public SimpleToStringStyle() {
        super();
        this.setUseClassName(false);
        this.setUseIdentityHashCode(false);
        this.setUseFieldNames(false);
        this.setContentStart("");
        this.setContentEnd("");
        this.setFieldSeparator("|");
    }

}
