/*
 * CapHibernateSessionFactoryBean.java
 *
 * Copyright (c) 2009-2011 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.contants;

/**
 * <p>
 * Search Mode.
 * 
 * <pre>
 * <code>
 * List<SearchModeParameter> ors = new ArrayList<SearchModeParameter>(); 
 * for (String u : unitIds) { 
 * 	ors.add(new SearchModeParameter(SearchMode.LIKE, "branchNo", u + "%")); 
 * }
 * search.addSearchModeParameters(SearchMode.OR, SearchMode.OR, ors);
 * 
 * -->  where xxxx=? and (branchNo like ? or branchNo like ? or branchNo like ?)
 * </code>
 * </pre>
 * </p>
 * 
 * @author iristu
 * @version
 *          <ul>
 *          <li>2010/7/9,iristu,new
 *          <li>2010/10/05,sunkistwang,update SearchMode.OR, SearchMode.AND
 *          </ul>
 */
public enum SearchMode {
    /** in */
    IN("in"),
    /** not in */
    NOT_IN("in"),
    /** = */
    EQUALS("eq"),
    /** != */
    NOT_EQUALS("ne"),
    /** like */
    LIKE("like"),
    /** not like */
    NOT_LIKE("notLike"),
    /** > */
    GREATER_THAN("gt"),
    /** >= */
    GREATER_EQUALS("ge"),
    /** < */
    LESS_THAN("lt"),
    /** <= */
    LESS_EQUALS("le"),
    /** is null */
    IS_NULL("isNull"),
    /** is null */
    IS_NOT_NULL("isNotNull"),
    /** between and */
    BETWEEN("between"),
    /** or */
    OR("or"),
    /** and */
    AND("and");

    private String code;

    SearchMode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static final SearchMode convert(String code) {
        for (SearchMode searchMode : SearchMode.values()) {
            if (searchMode.getCode().equals(code)) {
                return searchMode;
            }
        }
        return EQUALS; // default
    }

    @Override
    public String toString() {
        return code;
    }

}
