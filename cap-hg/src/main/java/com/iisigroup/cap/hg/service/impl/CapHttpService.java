package com.iisigroup.cap.hg.service.impl;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.Constants;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.hg.enums.ConnStatusEnum;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * HTTP UTIL
 * </pre>
 * 
 * @since 2011/11/10
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/10,rodeschen,new
 *          <li>2013/1/15,rodeschen,add setHeader,remove CapException
 *          </ul>
 */
public class CapHttpService extends AbstractHGservice {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private DefaultHttpClient httpClient;
	private HttpPost httpPost;
	// private HttpResponse httpResponse;
	private int httpStatus;
	private String responseData;
	/** default Connection Timeout **/
	// private int defaultConnectTimeout = 3000;
	/** default socket Timeout **/
	// private int defaultSocketTimeout = 55000;
	/** default encode **/
	private String defaultEncode = HTTP.UTF_8;
	/** connection status **/
	private ConnStatusEnum status;
	/** async **/
	private boolean isAsync;

	private Object sendData;

	private Map<String, String> header;

	/**
	 * @param Map
	 *            <String,Object> CapConstants.HOST_URL host url
	 *            CapConstants.CONNECTION_TIMEOUT default 3000
	 *            CapConstants.SOCKET_TIMEOUT default 55000
	 *            CapConstants.TRANSFER_ENCODING default UTF-8
	 *            CapConstants.ASYNC default false
	 * 
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisi.cap.hg.service.IHGService#getStatus()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ConnStatusEnum getStatus() {
		return status;
	}

	@Override
	public void setStatus(ConnStatusEnum status) {
		this.status = status;
	}

	/**
	 * get http status
	 * 
	 * @return int
	 */
	public int getHttpStatus() {
		return httpStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisi.cap.hg.service.IHGService#getMessage()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String getReceiveData() {
		return responseData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisigroup.cap.hg.service.IHGService#setHeader(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setHeader(Object data) {
		this.header = (Map<String, String>) data;

	}

	public void addHeader(String key, String value) {
		if (this.header == null) {
			this.header = new HashMap<String, String>();
		}
		this.header.put(key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisi.cap.hg.service.IHGService#setSendMessage(java.lang.Object)
	 */
	@Override
	public void setSendData(Object data) {
		this.sendData = data;
	}

	/**
	 * get send Data
	 * 
	 * @return sendData
	 */
	public Object getSendData() {
		return this.sendData;
	}

	/**
	 * set http request body
	 * 
	 * @param body
	 *            string
	 * @throws UnsupportedEncodingException
	 */
	public void setRequestBody(String body) throws UnsupportedEncodingException {
		httpPost.setEntity(new StringEntity(body, defaultEncode));
	}

	/**
	 * set http request key-value data
	 * 
	 * @param map
	 *            parameter
	 * @throws UnsupportedEncodingException
	 */
	public void setRequestParams(Map<String, String> map) throws UnsupportedEncodingException {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (String key : map.keySet()) {
			nvps.add(new BasicNameValuePair(key, map.get(key)));
		}
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, defaultEncode));

	}

	public void setRequestHeader(Map<String, String> map) {
		for (String key : map.keySet()) {
			httpPost.addHeader(key, map.get(key));
		}
	}

	private void excuteHttp() throws Exception {

		httpPost.setURI(new URI((String) getProperty(Constants.HOST_URL)));
		long st = System.currentTimeMillis();
		HttpResponse httpResponse = httpClient.execute(httpPost);
		httpStatus = httpResponse.getStatusLine().getStatusCode();

		HttpEntity entity = httpResponse.getEntity();

		if (entity != null) {
			InputStream instream = entity.getContent();
			try {
				responseData = StringUtils.join(IOUtils.readLines(instream, defaultEncode)
						.toArray());

			} catch (RuntimeException ex) {
				httpPost.abort();
				throw ex;
			} finally {
				instream.close();
			}

			httpClient.getConnectionManager().shutdown();
		}
		// httpClient.setHttpRequestRetryHandler(new HttpRequestRetryHandler() {
		// @Override
		// public boolean retryRequest(IOException exception, int count,
		// HttpContext context) {
		// return !(count > 3);
		// }
		// });
		logger.debug("host response:" + responseData);
		logger.debug("Send Host spand time: " + (System.currentTimeMillis() - st) + "ms");
		setStatus(ConnStatusEnum.COMPLETE);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisi.cap.hg.service.IHGService#execute()
	 */
	@Override
	public void execute() throws Exception {
		if (!ConnStatusEnum.INIT.equals(status)) {
			throw new CapException("init error", getClass());
		}
		setStatus(ConnStatusEnum.RUNNING);
		if (isAsync) {
			new Async().start();
		} else {
			excuteHttp();
		}

	}

	/**
	 * <pre>
	 * Async HTTP Connect
	 * </pre>
	 * 
	 * @since 2011/12/5
	 * @author rodeschen
	 * @version <ul>
	 *          <li>2011/12/5,rodeschen,new
	 *          </ul>
	 */
	private class Async extends Thread {
		@Override
		public void run() {
			try {
				excuteHttp();
			} catch (Exception e) {
				responseData = errorHandle(e);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisi.cap.hg.service.IHGService#initConnection()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void initConnection() {
		httpPost = new HttpPost();
		if (this.header instanceof Map) {
			setRequestHeader((Map<String, String>) this.header);
		}
		try {
			if (this.sendData instanceof Map) {
				setRequestParams((Map<String, String>) this.sendData);
			} else if (this.sendData instanceof String
					&& !CapString.isEmpty((String) this.sendData)) {
				setRequestBody((String) this.sendData);
			}
		} catch (UnsupportedEncodingException e) {
			throw new CapException(e, getClass());
		}
		httpClient = new DefaultHttpClient();
		int ct = Integer.valueOf((String) getProperty(Constants.CONNECTION_TIMEOUT));
		int st = Integer.valueOf((String) getProperty(Constants.CONNECTION_TIMEOUT));

		String encode = defaultEncode;
		String async = getProperty(Constants.ASYNC);

		httpClient.getParams().setParameter(HttpConnectionParams.CONNECTION_TIMEOUT, ct);
		httpClient.getParams().setParameter(HttpConnectionParams.SO_TIMEOUT, st);
		defaultEncode = encode != null ? encode : defaultEncode;
		isAsync = (async != null ? Boolean.valueOf(async) : false);
		setStatus(ConnStatusEnum.INIT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iisi.cap.hg.service.IHGService#errorHandle(java.lang.Exception)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String errorHandle(Exception e) {
		logger.error(e.getMessage(), e);
		if (e instanceof HttpHostConnectException) {
			setStatus(ConnStatusEnum.CONNECT_ERROR);
			return "{rc:'" + ConnStatusEnum.CONNECT_ERROR + "',msg:'connect error'}";
		} else if (e instanceof SocketTimeoutException) {
			setStatus(ConnStatusEnum.TIMEOUT);
			return "{rc:'" + ConnStatusEnum.TIMEOUT + "',msg:'connect timeout'}";
		} else {
			setStatus(ConnStatusEnum.ERROR);
			return "{rc:'" + ConnStatusEnum.ERROR + "',msg:'" + e.getMessage() + "'}";
		}
	}

}
