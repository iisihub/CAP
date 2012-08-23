package com.iisigroup.cap.hg.service;

import java.util.Map;

import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.hg.enums.ConnStatusEnum;

/**
 * <pre>
 * host gateway service interface
 * </pre>
 * 
 * @since 2011/12/5
 * @author rodeschen
 * @version <ul>
 *          <li>2011/12/5,rodeschen,new
 *          </ul>
 */
public interface IHGService {

	/**
	 * set properties
	 * 
	 * @param property
	 *            property
	 * 
	 * @throws CapException
	 */
	void setProperties(Map<String, Object> property) throws CapException;

	/**
	 * set property
	 * 
	 * @param name
	 *            name
	 * @param value
	 *            value
	 */
	public void setProperty(String name, Object value);

	/**
	 * get property
	 * 
	 * @param <T>
	 *            <T>
	 * @param name
	 *            name
	 * 
	 * @throws CapException
	 * @return <T>
	 */
	<T> T getProperty(Object name) throws CapException;

	/**
	 * initial connection
	 * 
	 * @throws CapException
	 */
	void initConnection() throws CapException;

	/**
	 * get hg status
	 * 
	 * @param <T>
	 *            stauts
	 * @return <T>
	 */
	<T> T getStatus();

	/**
	 * set hg status
	 * 
	 * @param status
	 *            stauts
	 */
	void setStatus(ConnStatusEnum status);

	/**
	 * get receive data
	 * 
	 * @param <T>
	 *            stauts
	 * @return <T>
	 */
	<T> T getReceiveData() throws CapException;

	/**
	 * set send data
	 * 
	 * @param data
	 *            data
	 * @throws CapException
	 */
	void setSendData(Object data) throws CapException;

	/**
	 * execute connect
	 * 
	 * @throws Exception
	 */
	void execute() throws Exception;

	/**
	 * error handle
	 * 
	 * @param <T>
	 *            T
	 * @param e
	 *            exception
	 * @return T
	 */
	<T> T errorHandle(Exception e);

}
