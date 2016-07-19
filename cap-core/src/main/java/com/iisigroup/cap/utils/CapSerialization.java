/*
 * Copyright (c) 2009-2012 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System, Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.io.IOUtils;

/**
 * <pre>
 * Object seriaization utilities
 * </pre>
 * 
 * @since 2003/5/20
 * @author Malo Jwo
 * @version
 *          <ul>
 *          <li>2011/6/27,iristu,copy from gaia
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public class CapSerialization {

    private boolean compress = false;

    CapSerialization(boolean compress) {
        this.compress = compress;
    }

    private static CapSerialization inst = new CapSerialization(false);
    private static CapSerialization compressInst = new CapSerialization(true);

    public static CapSerialization newInstance() {
        return inst;
    }

    public static CapSerialization newCompressInstance() {
        return compressInst;
    }

    public boolean isCompress() {
        return compress;

    }

    public void setCompress(boolean b) {
        compress = b;
    }

    /**
     * compress byte array data with GZIP.
     * 
     * @param input
     *            the input data
     * @return the compressed data
     * @throws java.io.IOException
     */
    public byte[] compress(byte[] input) throws java.io.IOException {
        byte[] result = null;
        java.io.ByteArrayOutputStream baout = null;
        GZIPOutputStream gzipout = null;
        try {
            baout = new java.io.ByteArrayOutputStream();
            gzipout = new GZIPOutputStream(baout);
            gzipout.write(input);
            gzipout.finish();
            result = baout.toByteArray();
            return result;
        } finally {
            IOUtils.closeQuietly(baout);
            IOUtils.closeQuietly(gzipout);
        }
    }

    /**
     * decompress byte array data with GZIP.
     * 
     * @param input
     *            the input compressed data
     * @return the decompress data
     * @throws java.io.IOException
     */
    public byte[] decompress(byte[] input) throws java.io.IOException {

        byte[] buf = new byte[2048];
        byte[] result = null;
        java.io.ByteArrayInputStream bain = null;
        ByteArrayOutputStream baout = null;
        GZIPInputStream gzipin = null;
        try {
            bain = new java.io.ByteArrayInputStream(input);
            gzipin = new GZIPInputStream(bain);
            baout = new ByteArrayOutputStream();
            int size;
            while ((size = gzipin.read(buf)) != -1) {
                baout.write(buf, 0, size);
            }
            result = baout.toByteArray();
            return result;
        } finally {
            IOUtils.closeQuietly(bain);
            IOUtils.closeQuietly(baout);
            IOUtils.closeQuietly(gzipin);
        }

    }

    /**
     * Load data from savedData string
     * 
     * @param in
     *            the saved string
     * @return the original data
     */
    public Object loadData(String in) {
        return loadDataFromByteArray(CapString.hexStrToByteArray(in), compress);
    }

    public Object loadDataFromByteArray(byte[] in, boolean compress) {
        if (in == null) {
            return null;
        }
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            bais = compress ? new ByteArrayInputStream(decompress(in)) : new ByteArrayInputStream(in);

            ois = new ObjectInputStream(bais);
            Object o = ois.readObject();
            return o;
        } catch (Exception e) {
            e.getMessage();
        } finally {
            IOUtils.closeQuietly(ois);
            IOUtils.closeQuietly(bais);
        }
        return null;
    }

    /**
     * Serializate the object to string
     * 
     * @param o
     *            the input object
     * @return the object's serialized string
     */
    public String saveData(Object o) {
        return CapString.byteArrayToHexString(saveDataToByteArray(o, compress));
    }

    public byte[] saveDataToByteArray(Object o, boolean compress) {
        if (o == null) {
            return null;
        }
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            byte[] out = baos.toByteArray();
            return compress ? compress(out) : out;
        } catch (Exception e) {
            e.getMessage();
        } finally {
            IOUtils.closeQuietly(oos);
            IOUtils.closeQuietly(baos);
        }
        return null;
    }

    // public String stringToBase64(String s) throws IOException {
    // return stringToBase64(s, compress);
    // }
    //
    // public String stringToBase64(String s, boolean compress) throws
    // IOException {
    // byte[] ba = s.getBytes("8859_1");
    // if (compress) {
    // ba = compress(ba);
    // }
    // return new BASE64Encoder().encode(ba);
    // }
    //
    // public String base64ToString(String s) throws IOException {
    // return base64ToString(s, compress);
    // }
    //
    // public String base64ToString(String s, boolean compress) throws
    // IOException {
    // byte[] ba = new BASE64Decoder().decodeBuffer(s);
    // if (compress) {
    // ba = decompress(ba);
    // }
    // return new String(ba,"8859_1");
    // }

}
