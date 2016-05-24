/* 
 * UserMapper.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.batch.sample;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2012/10/30
 * @author iristu
 * @version
 *          <ul>
 *          <li>2012/10/30,iristu,new
 *          </ul>
 */
public class UserMapper implements FieldSetMapper<User> {

    @Override
    public User mapFieldSet(FieldSet fieldSet) throws BindException {
        User user = new User();
        user.setName(fieldSet.readString(0));
        user.setAge(fieldSet.readInt(1));
        return user;
    }

}
