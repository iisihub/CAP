/* 
 * CapByteDownloadResult.java
 * 
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.response;

import com.iisigroup.cap.component.IRequest;

/**
 * <pre>
 * 資料下載
 * </pre>
 * 
 * @since 2011/11/15
 * @author iristu
 * @version <ul>
 *          <li>2011/11/15,iristu,new
 *          <li>2012/2/3,rodeschen,copy from cap
 *          </ul>
 */
@SuppressWarnings("serial")
public class ByteArrayDownloadResult extends FileDownloadResult {

	private byte[] _byteArray = null;
	private String _outputName;
	private String _contentType;

	public ByteArrayDownloadResult() {
	}// ;

	public ByteArrayDownloadResult(IRequest request, byte[] byteArray, String contentType, String outputName) {
		this._request = request;
		this._byteArray = byteArray;
		this._contentType = contentType;
		this._outputName = encodeFileName(outputName);
	}// ;
	
	public ByteArrayDownloadResult(IRequest request, byte[] byteArray, String contentType) {
		this._request = request;
		this._byteArray = byteArray;
		this._contentType = contentType;
		//this._outputName = encodeFileName(outputName);
	}// ;

	@Override
	public String getLogMessage() {
		return new StringBuffer("Download file:").append(_outputName).toString();
	}


	public byte[] getByteArray() {
		return _byteArray;
	}

	public String getOutputName() {
		return _outputName;
	}

	public String getContentType() {
		return _contentType;
	}

	@Override
	public void add(IResult result) {
		if (result instanceof ByteArrayDownloadResult) {
			ByteArrayDownloadResult r = (ByteArrayDownloadResult) result;
			this._request = r._request;
			this._contentType = r._contentType;
			this._byteArray = r._byteArray;
			this._outputName = encodeFileName(r._outputName);
		}
	}// ;

}// ~
