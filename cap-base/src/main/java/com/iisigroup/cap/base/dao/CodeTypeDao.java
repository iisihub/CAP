/*_
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

package com.iisigroup.cap.base.dao;

import java.util.List;

import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.dao.IGenericDao;

/**
 * <pre>
 * 代碼表IDao
 * </pre>
 * 
 * @since 2010/12/15
 * @author eugene
 * @version <ul>
 *          <li>2010/12/15,eugene,new
 *          </ul>
 */
public interface CodeTypeDao extends IGenericDao<CodeType> {


	/**
	 * <pre>
	 * 使用codeType及codeValue取得CBCLCODE
	 * </pre>
	 * 
	 * @param codeType
	 *            key
	 * @param codeValue
	 *            value
	 * @return CodeType
	 * @throws Exception
	 */
	public CodeType getByCodeTypeAndValue(String codeType, String codeValue);


	/**
	 * <pre>
	 * 使用codeType取得CBCLCODE
	 * </pre>
	 * 
	 * @param codeType
	 *            codeType
	 * @return list
	 */
     List<CodeType> findByCodeType(String codeType);
     
     /**
 	 * <pre>
 	 * 使用codeType取得CBCLCODE
 	 * </pre>
 	 * 
 	 * @param codeType
 	 *            codeType
 	 * @return list
 	 * @throws Exception
 	 */
 	public List<CodeType> findByCodeType(String[] codeType);
 	
 	/**
 	 * <pre>
 	 * 使用codeval查询codetype的讯息
 	 * </pre>
 	 * @param codeVal
 	 *        codeVal
 	 * @return
 	 *        CodeType
 	 */
 	public CodeType findByCodeVal(String codeVal);
}
