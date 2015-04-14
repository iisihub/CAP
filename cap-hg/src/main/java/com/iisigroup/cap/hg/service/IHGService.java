package com.iisigroup.cap.hg.service;

import java.util.Map;

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
 *          <li>2013/1/15,rodeschen,add setHeader,remove CapException
 *          </ul>
 */
public interface IHGService {

    /**
     * set properties
     * 
     * @param property
     *            property
     * 
     */
    void setProperties(Map<String, Object> property);

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
     * @return <T>
     */
    <T> T getProperty(Object name);

    /**
     * initial connection
     * 
     */
    void initConnection();

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
     * set send data
     * 
     * @param data
     *            data
     */
    void setSendData(Object data);

    /**
     * 
     * @param data
     */
    void setHeader(Object data);

    /**
     * execute connect
     * 
     * @throws Exception
     */
    void execute() throws Exception;

    /**
     * get receive data
     * 
     * @param <T>
     *            stauts
     * @return <T>
     */
    <T> T getReceiveData();

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
