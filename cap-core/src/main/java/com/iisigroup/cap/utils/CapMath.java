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

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.iisigroup.cap.Constants;

/**
 * <p>
 * 數字格式處理.
 * </p>
 * 
 * @author iristu
 * 
 */
public class CapMath implements Constants {

    final static int[] DEFAULT_DIVIDE_ROUNDING_MODE = { BigDecimal.ROUND_HALF_UP, BigDecimal.ROUND_HALF_UP, BigDecimal.ROUND_HALF_UP };

    final static int DEFAULT_ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

    private static final Method toPlainString;
    static {
        Method m;
        try {
            m = BigDecimal.class.getMethod("toPlainString", (Class[]) null);
        } catch (NoSuchMethodException e) {
            m = null;
        }
        toPlainString = m;
    }

    /**
     * Set number's scale.
     * 
     * @param first
     *            the number
     * @param scale
     *            scale of the BigDecimal value to be returned.
     * @return the result data
     * @see java.math.BigDecimal#ROUND_HALF_UP
     */
    public static String setScale(String first, int scale) {
        return setScale(first, scale, DEFAULT_ROUNDING_MODE);
    }

    /**
     * Set number's scale.
     * 
     * @param first
     *            the number
     * @param scale
     *            scale of the BigDecimal value to be returned.
     * @param roundingMode
     *            The rounding mode to apply.
     * @return the result data
     * @see java.math.BigDecimal#ROUND_UP
     * @see java.math.BigDecimal#ROUND_DOWN
     * @see java.math.BigDecimal#ROUND_CEILING
     * @see java.math.BigDecimal#ROUND_FLOOR
     * @see java.math.BigDecimal#ROUND_HALF_UP
     * @see java.math.BigDecimal#ROUND_HALF_DOWN
     * @see java.math.BigDecimal#ROUND_HALF_EVEN
     * @see java.math.BigDecimal#ROUND_UNNECESSARY
     */
    public static String setScale(String first, int scale, int roundingMode) {
        first = first == null || first.length() == 0 ? S0 : first.trim();
        BigDecimal result = getBigDecimal(first).setScale(scale, roundingMode);
        return bigDecimalToString(result);
    }

    /**
     * add two Number. use ROUND_HALF_UP for rounding mode.
     * 
     * @param first
     *            the first number
     * @param second
     *            the second number
     * @return String the result number
     * @see java.math.BigDecimal#ROUND_HALF_UP
     */
    public static String add(String first, String second) {
        first = first == null || first.length() == 0 ? S0 : first.trim();
        second = second == null || second.length() == 0 ? S0 : second.trim();

        BigDecimal f = getBigDecimal(first);// new BigDecimal(first);
        BigDecimal s = getBigDecimal(second);// new BigDecimal(second);
        int fs = f.scale();
        int ss = s.scale();
        int max = fs > ss ? fs : ss;
        BigDecimal result = f.add(s).setScale(max, DEFAULT_ROUNDING_MODE);
        return bigDecimalToString(result);
    }

    /**
     * add two Number with scale. use ROUND_HALF_UP for rounding mode.
     * 
     * @param first
     *            the first number
     * @param second
     *            the second number
     * @param scale
     *            scale of the result value to be returned.
     * @return String the result number
     */
    public static String add(String first, String second, int scale) {
        first = first == null || first.length() == 0 ? S0 : first.trim();
        second = second == null || second.length() == 0 ? S0 : second.trim();

        BigDecimal f = getBigDecimal(first);// new BigDecimal(first);
        BigDecimal s = getBigDecimal(second);// new BigDecimal(second);
        BigDecimal result = f.add(s).setScale(scale, DEFAULT_ROUNDING_MODE);
        return bigDecimalToString(result);
    }

    /**
     * add more than one Number
     * 
     * @param numArray
     *            numArray
     * @return String
     */
    public static String add(String[] numArray) {
        String result = S0;
        for (int i = 0; i < numArray.length; i++) {
            result = add(result, numArray[i]);
        }
        return result;
    }

    /**
     * subtract two number.
     * 
     * @param first
     *            the first number
     * @param second
     *            the second number
     * @return String the result number
     */
    public static String subtract(String first, String second) {
        first = first == null || first.length() == 0 ? S0 : first.trim();
        second = second == null || second.length() == 0 ? S0 : second.trim();

        BigDecimal f = getBigDecimal(first);// new BigDecimal(first);
        BigDecimal s = getBigDecimal(second);// new BigDecimal(second);
        int fs = f.scale();
        int ss = s.scale();
        int max = fs > ss ? fs : ss;
        BigDecimal result = f.subtract(s).setScale(max, DEFAULT_ROUNDING_MODE);
        return bigDecimalToString(result);
    }

    /**
     * subtract two number with scale.
     * 
     * @param first
     *            the first number
     * @param second
     *            the second number
     * @param scale
     *            scale of the result value to be returned.
     * @return String the result number
     */
    public static String subtract(String first, String second, int scale) {
        first = first == null || first.length() == 0 ? S0 : first.trim();
        second = second == null || second.length() == 0 ? S0 : second.trim();

        BigDecimal f = getBigDecimal(first);// new BigDecimal(first);
        BigDecimal s = getBigDecimal(second);// new BigDecimal(second);
        BigDecimal result = f.subtract(s).setScale(scale, DEFAULT_ROUNDING_MODE);
        return bigDecimalToString(result);
    }

    /**
     * subtract more than one Number
     * 
     * @param numArray
     *            numArray
     * @return String
     */
    public static String subtract(String[] numArray) {
        String result = numArray[0];
        for (int i = 1; i < numArray.length; i++) {
            result = subtract(result, numArray[i]);
        }
        return result;
    }

    /**
     * multiply two number.
     * 
     * @param first
     *            the first number
     * @param second
     *            the second number
     * @return String the result number
     */
    public static String multiply(String first, String second) {
        first = first == null || first.length() == 0 ? S0 : first.trim();
        second = second == null || second.length() == 0 ? S0 : second.trim();

        BigDecimal f = getBigDecimal(first);// new BigDecimal(first);
        BigDecimal s = getBigDecimal(second);// new BigDecimal(second);
        int fs = f.scale();
        int ss = s.scale();
        int max = fs > ss ? fs : ss;
        BigDecimal result = f.multiply(s).setScale(max, DEFAULT_ROUNDING_MODE);
        return bigDecimalToString(result);
    }

    /**
     * multiply two number with scale.
     * 
     * @param first
     *            the first number
     * @param second
     *            the second number
     * @param scale
     *            scale of the result value to be returned.
     * @return String the result number
     */
    public static String multiply(String first, String second, int scale) {
        first = first == null || first.length() == 0 ? S0 : first.trim();
        second = second == null || second.length() == 0 ? S0 : second.trim();

        BigDecimal f = getBigDecimal(first);// new BigDecimal(first);
        BigDecimal s = getBigDecimal(second);// new BigDecimal(second);
        BigDecimal result = f.multiply(s).setScale(scale, DEFAULT_ROUNDING_MODE);
        return bigDecimalToString(result);
    }

    /**
     * divide two Number.
     * 
     * @param first
     *            the first number
     * @param second
     *            the second number
     * @return String the result number
     */
    public static String divide(String first, String second) {
        first = first == null || first.length() == 0 ? S0 : first.trim();
        second = second == null || second.length() == 0 ? S0 : second.trim();
        BigDecimal f = getBigDecimal(first);// new BigDecimal(first);
        BigDecimal s = getBigDecimal(second);// new BigDecimal(second);
        if (s.compareTo(B0) == 0)
            return "0";
        int fs = f.scale();
        int ss = s.scale();
        int max = fs > ss ? fs : ss;
        BigDecimal result = f.setScale(max, DEFAULT_DIVIDE_ROUNDING_MODE[0]).divide(s, DEFAULT_DIVIDE_ROUNDING_MODE[1]).setScale(max, DEFAULT_DIVIDE_ROUNDING_MODE[2]);

        return bigDecimalToString(result);
    }

    /**
     * divide two Number with scale.
     * 
     * @param first
     *            the first number
     * @param second
     *            the second number
     * @param scale
     *            scale of the result value to be returned.
     * @return String the result number
     */
    public static String divide(String first, String second, int scale) {
        first = first == null || first.length() == 0 ? S0 : first.trim();
        second = second == null || second.length() == 0 ? S0 : second.trim();

        BigDecimal f = getBigDecimal(first);// new BigDecimal(first);
        BigDecimal s = getBigDecimal(second);// new BigDecimal(second);
        BigDecimal result = f.setScale(scale, DEFAULT_DIVIDE_ROUNDING_MODE[0]).divide(s, DEFAULT_DIVIDE_ROUNDING_MODE[1]).setScale(scale, DEFAULT_DIVIDE_ROUNDING_MODE[2]);
        return bigDecimalToString(result);
    }

    /**
     * compare two Number
     * 
     * @param first
     *            the first number
     * @param second
     *            the second number
     * @return -1, 0 or 1 as this BigDecimal is numerically less than, equal to,
     *         or greater than <tt>val</tt>.
     */
    public static int compare(BigDecimal first, BigDecimal second) {
        return first.compareTo(second);
    }

    /**
     * compare two Number
     * 
     * @param first
     *            the first number
     * @param second
     *            the second number
     * @return -1, 0 or 1 as this BigDecimal is numerically less than, equal to,
     *         or greater than <tt>val</tt>.
     */
    public static int compare(BigDecimal first, String second) {
        second = second == null || second.length() == 0 ? S0 : second.trim();
        BigDecimal s = getBigDecimal(second);// new BigDecimal(second);
        return first.compareTo(s);
    }

    /**
     * compare two Number
     * 
     * @param first
     *            the first number
     * @param second
     *            the second number
     * @return -1, 0 or 1 as this BigDecimal is numerically less than, equal to,
     *         or greater than <tt>val</tt>.
     */
    public static int compare(String first, BigDecimal second) {
        first = first == null || first.length() == 0 ? S0 : first.trim();
        BigDecimal f = getBigDecimal(first);// new BigDecimal(first);
        return f.compareTo(second);
    }

    /**
     * compare two Number
     * 
     * @param first
     *            the first number
     * @param second
     *            the second number
     * @return -1, 0 or 1 as this BigDecimal is numerically less than, equal to,
     *         or greater than <tt>val</tt>.
     */
    public static int compare(String first, String second) {
        try {
            first = first == null || first.length() == 0 ? S0 : first.trim();
            second = second == null || second.length() == 0 ? S0 : second.trim();

            BigDecimal f = getBigDecimal(first);// new BigDecimal(first);
            BigDecimal s = getBigDecimal(second);// new BigDecimal(second);
            return f.compareTo(s);
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * round Number
     * 
     * @param num
     *            num
     * @param roundIndex
     *            roundIndex
     * @return String
     */
    public static String round(String num, int roundIndex) {
        String result = S0;
        String multiple = S1;
        if (roundIndex < 0) {
            for (int i = roundIndex; i < 0; i++) {
                multiple = multiple + S0;
            }
            String tempNum = divide(num, multiple);
            tempNum = setScale(tempNum, 0, BigDecimal.ROUND_HALF_UP);
            result = multiply(tempNum, multiple);
        } else {
            result = setScale(num, roundIndex, BigDecimal.ROUND_HALF_UP);
        }

        return result;
    }

    /**
     * toString.
     * 
     * @param b
     *            the BigDecimal
     * @return String
     */
    public static String bigDecimalToString(BigDecimal b) {
        String out = null;
        if (b != null) {
            if (toPlainString == null) {
                out = b.toString();
            } else {
                // jdk 1.5 (5.0) bigdecimal's toString() change
                try {
                    out = (String) toPlainString.invoke(b, (Object[]) null);
                } catch (Exception ex) {
                    return null;
                }
            }
        }
        return out;
    }

    /**
     * 將字串轉為BigDecimal格式
     * 
     * @param in
     *            the input
     * @return BigDecimal
     */
    public static BigDecimal getBigDecimal(String in) {
        BigDecimal out = B0;
        if (in != null) {
            try {
                out = new BigDecimal(in);
            } catch (Exception ex) {
                char[] ca = in.toCharArray();
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < ca.length; i++) {
                    switch (ca[i]) {
                    case '-':
                    case '+':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case '.':
                        sb.append(ca[i]);
                    }
                }
                try {
                    out = new BigDecimal(sb.toString());
                } catch (Exception ex2) {
                    return null;
                }
            }
        }
        return out;
    }

    /**
     * 取得 Normal(sampleMean, sampleSTD) 的值對應到 Normal(mean, std)的轉換值
     * 
     * @param sampleValue
     *            sampleValue
     * @param sampleMean
     *            sampleMean
     * @param sampleSTD
     *            sampleSTD
     * @param mean
     *            mean
     * @param std
     *            std
     * @param scale
     *            scale
     * @param rm
     *            rm
     * @return value
     */
    public static BigDecimal normalization(BigDecimal sampleValue, BigDecimal sampleMean, BigDecimal sampleSTD, BigDecimal mean, BigDecimal std, int scale, RoundingMode rm) {

        if (sampleValue == null || sampleMean == null || sampleSTD == null || mean == null || std == null) {
            return null;
        }
        BigDecimal tmpValue = sampleSTD.multiply(std).add(mean);
        if (tmpValue.compareTo(BigDecimal.ZERO) == 0) {
            return null;
        }
        tmpValue = sampleValue.subtract(sampleMean).divide(tmpValue, scale, rm);
        return tmpValue;
    }
}
