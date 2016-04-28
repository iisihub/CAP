/*
 * IDataObject.java
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
package com.iisigroup.cap.model;

import java.io.Serializable;

/**
 * <p>
 * interface IDataObject.
 * </p>
 * 
 * @author iristu
 * @version
 *          <ul>
 *          <li>2010/7/7,iristu,new
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public interface DataObject extends Serializable {

    /**
     * Gets the oid.
     * 
     * @return the oid
     */
    String getOid();

    /**
     * Sets the oid.
     * 
     * @param oid
     *            the new oid
     */
    void setOid(String oid);

}
