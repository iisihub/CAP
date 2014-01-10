/*
 * Copyright (c) 2009-2011 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.base.response;

import java.util.Locale;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.response.ErrorResult;
import com.iisigroup.cap.utils.CapAppContext;

/**
 * <pre>
 * 錯誤訊息回應
 * </pre>
 * 
 * @since 2014/1/10
 * @author tammy
 * @version <ul>
 *          <li>tammy,2014/1/10,new
 *          </ul>
 */
@SuppressWarnings("serial")
public class CapErrorResult extends ErrorResult {

	public CapErrorResult() {
	}

	public CapErrorResult(IRequest request, Exception e) {
		super.putError(request, e);
	}

	@Override
	protected String formatMessage(IRequest request, String msgKey,
			Object extraInfo) {
		Locale locale = getLocale(request);
		if (msgKey.startsWith("EFD")) {
			return RespMsgHelper.getMessage(request, msgKey,
					(Object[]) extraInfo);
		}
		if (extraInfo != null) {
			return CapAppContext.getMessage(msgKey, (Object[]) extraInfo,
					locale);
		} else {
			return CapAppContext.getMessage(msgKey, locale);
		}
	}
}
