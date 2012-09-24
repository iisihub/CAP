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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.utils.CapWebUtil;

/**
 * <pre>
 * 資料下載
 * 當outputName有值時，browser會以檔案下載的方式呈現
 * 當outputName無值時，browser則會先以直接開始檔案的方式呈現
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

	public ByteArrayDownloadResult(IRequest request, byte[] byteArray,
			String contentType, String outputName) {
		this._request = request;
		this._byteArray = byteArray;
		this._contentType = contentType;
		this._outputName = CapWebUtil.encodeFileName(_request, outputName);
	}// ;

	public ByteArrayDownloadResult(IRequest request, byte[] byteArray,
			String contentType) {
		this._request = request;
		this._byteArray = byteArray;
		this._contentType = contentType;
	}// ;

	@Override
	public String getLogMessage() {
		if (_outputName == null) {
			return _contentType + " byteArrayDownload complete!!";
		} else {
			return new StringBuffer("Download file:").append(_outputName)
					.toString();
		}
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
			this._outputName = CapWebUtil.encodeFileName(_request,
					r._outputName);
		}
	}// ;

	@Override
	public void respondResult(ServletResponse response) {
		int length = -1;
		InputStream in = null;
		try {
			if (getOutputName() != null
					&& response instanceof HttpServletResponse) {
				((HttpServletResponse) response).setHeader(
						"Content-Disposition", "attachment;filename=\""
								+ getOutputName() + "\"");
			}
			OutputStream output = response.getOutputStream();

			// Stream to the requester.
			byte[] bbuf = new byte[1024 * 1024];

			in = new ByteArrayInputStream(_byteArray);
			while ((in != null) && ((length = in.read(bbuf)) != -1)) {
				output.write(bbuf, 0, length);
			}
			output.flush();
		} catch (IOException e) {
			e.getMessage();
		} finally {
			try {
				in.close();
				// output.close();
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}// ;
}// ~
