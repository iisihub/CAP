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

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * <p>
 * 日期格式處理.
 * </p>
 * 
 * @author iristu
 * @version $Revision: 513 $
 * @version <ul>
 *          <li>2010/9/16,sunkist,add method getFirstMinuteDate(String date,
 *          String dateFormat) getLastMinuteDate(String date, String dateFormat)
 *          for 取得日期的最大與最小的時分秒字串。
 *          <li>2011/6/17,RodesChen,add method formatDate(Date date, String
 *          dateFormat)
 *          <li>2011/8/15,BillWang,add method convertStringToTimestamp(String
 *          date)
 *          <li>2011/10/6, CP, add method convertTimestampToString(Timestamp,
 *          string)</li>
 *          <li>2013/3/26,rodeschen add
 *          convertStringToTimestamp,convertDateTimeFromF1ToF2
 *          </ul>
 */
public class CapDate {

	protected final static GregorianCalendar GC = new GregorianCalendar();

	public final static String[] MONTH = { "JAN", "FEB", "MAR", "APR", "MAY",
			"JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };

	protected final static int[] DAYS_OF_MONTH = { 31, 29, 31, 30, 31, 30, 31,
			31, 30, 31, 30, 31 };

	private static final String[] DAY_OF_WEEK = { "SUN", "MON", "TUE", "WED",
			"THU", "FRI", "SAT" };

	public final static long ONE_DAY_TIME_MILLIS = 1000 * 60 * 60 * 24;

	public final static String ZERO_DATE = "0001-01-01";

	public final static String DEFAULT_DATE_FORMAT = "yyyyMMdd";

	/**
	 * calculate between date1 and date2 by using default format: "yyyyMMdd"
	 * 
	 * @param date1
	 *            the first date
	 * @param date2
	 *            the second date
	 * 
	 * @return int the days between date1 and date2
	 */
	public static int calculateDays(String date1, String date2) {

		return calculateDays(date1, date2, DEFAULT_DATE_FORMAT);
	}

	/**
	 * calculate between date1 and date2.
	 * 
	 * @param date1
	 *            the first date
	 * @param date2
	 *            the second date
	 * @param dateFormat
	 *            both date1 and date2's format
	 * @return int the days between date1 and date2
	 */
	public static int calculateDays(String date1, String date2,
			String dateFormat) {

		return calculateDays(date1, date2, dateFormat, dateFormat);
	}

	/**
	 * calculate between date1 and date2.
	 * 
	 * @param date1
	 *            the first date
	 * @param date2
	 *            the second date
	 * @param dateFormat1
	 *            date1 format pattern
	 * @param dateFormat2
	 *            date2 format pattern
	 * 
	 * @return int the days between date1 and date2
	 */
	public static int calculateDays(String date1, String date2,
			String dateFormat1, String dateFormat2) {

		return calculateDays(getDate(date1, dateFormat1),
				getDate(date2, dateFormat2));
	}

	/**
	 * calculate between date1 and date2.
	 * 
	 * @param date1
	 *            the first date
	 * @param date2
	 *            the second date
	 * @return int the days between date1 and date2
	 */
	public static int calculateDays(Date date1, Date date2) {
		long between = date1.getTime() - date2.getTime();
		return (int) (between / ONE_DAY_TIME_MILLIS);
	}

	/**
	 * calculate between date1 and date2.
	 * 
	 * @param date1
	 *            the first date
	 * 
	 * @param date2
	 *            the second date
	 * @param dateFormat1
	 *            date1 format pattern
	 * @param dateFormat2
	 *            date2 format pattern
	 * @return int
	 */
	public static int calculateMonths(String date1, String date2,
			String dateFormat1, String dateFormat2) {

		date1 = formatDateFormatToyyyyMMdd(date1, dateFormat1);
		date2 = formatDateFormatToyyyyMMdd(date2, dateFormat2);
		if ((date1 == null) || (date2 == null)) {
			throw new IllegalArgumentException("DATE INPUT ERROR");
		}
		int y1 = Integer.parseInt(date1.substring(0, 4));
		int y2 = Integer.parseInt(date2.substring(0, 4));
		int m1 = Integer.parseInt(date1.substring(4, 6));
		int m2 = Integer.parseInt(date2.substring(4, 6));
		int d1 = Integer.parseInt(date1.substring(6, 8));
		int d2 = Integer.parseInt(date2.substring(6, 8));
		int end1 = getDayOfMonth(y1, m1);
		int end2 = getDayOfMonth(y2, m2);
		boolean b1 = d1 == end1;
		boolean b2 = d2 == end2;
		if (b1 || b2) {
			if (b1 && b2) {
				d1 = 31;
				d2 = d1;
			} else if (b1) {
				if (d2 >= d1) {
					d2 = d1;
				}
			} else if (b2) {
				if (d1 >= d2) {
					d1 = d2;
				}
			}
		}
		if (d1 > d2) {
			m1++;
		} else if (d2 > d1) {
			m2++;
		}
		return ((y1 - y2) * 12 + m1 - m2);
	}

	/**
	 * shift days from date.
	 * 
	 * @param date
	 *            the source date
	 * @param shiftdays
	 *            how many days shift
	 * @return Date the traget date
	 */
	public static Date shiftDays(Date date, int shiftdays) {
		if (date == null) {
			return null;
		}
		long shift = shiftdays * ONE_DAY_TIME_MILLIS;
		long targetDate = date.getTime() + shift;
		return new java.util.Date(targetDate);
	}

	/**
	 * shift days from date.
	 * 
	 * @param date
	 *            the source date
	 * @param dateFormat
	 *            date format pattern
	 * @param shiftdays
	 *            how many days shift
	 * @return Date-the traget date
	 */
	public static Date shiftDays(String date, String dateFormat, int shiftdays) {
		return shiftDays(getDate(date, dateFormat), shiftdays);
	}

	/**
	 * shift days from date.
	 * 
	 * @param date
	 *            the source date
	 * @param dateFormat
	 *            date format pattern
	 * @param shiftdays
	 *            how many days shift
	 * @return String-the traget date
	 */
	public static String shiftDaysString(String date, String dateFormat,
			int shiftdays) {
		Date d = shiftDays(getDate(date, dateFormat), shiftdays);
		return formatyyyyMMddToDateFormat(
				new SimpleDateFormat("yyyyMMdd").format(d), dateFormat);
	}

	/**
	 * convert String to date.
	 * 
	 * 
	 * @param date
	 *            the input date
	 * @param dateFormat
	 *            date format pattern
	 * @return Date the return date instance.
	 */
	public static Date getDate(String date, String dateFormat) {

		String date1 = formatDateFormatToyyyyMMdd(date, dateFormat);
		if (date1 == null) {
			throw new IllegalArgumentException("DATE (" + date
					+ ") AND DATEFORMAT (" + dateFormat + ") IS NOT SUPPORTED");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sdf.setLenient(false);
		ParsePosition pos = new ParsePosition(0);
		return sdf.parse(date1, pos);

	}

	/**
	 * get current date
	 * 
	 * @param dateFormat
	 *            date format pattern
	 * @return String
	 */
	public static String getCurrentDate(String dateFormat) {
		Date currentDate = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String theDate = df.format(currentDate);
		return CapDate.formatyyyyMMddToDateFormat(theDate, dateFormat);
	}

	/**
	 * get how many days of the month.
	 * 
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return int the days of month.
	 */
	public static int getDayOfMonth(int year, int month) {
		try {
			int maxDay = DAYS_OF_MONTH[month - 1];
			if (month == 2) {
				if (isLeapYear(year)) {
					maxDay = 29;
				} else {
					maxDay = 28;
				}
			}
			return maxDay;
		} catch (Exception e) {
			return 31;
		}
	}

	/**
	 * get how many days of the month.
	 * 
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return int the days of month.
	 */
	public static int getDayOfMonth(String year, String month) {
		try {
			return getDayOfMonth(Integer.parseInt(year),
					Integer.parseInt(month));
		} catch (Exception e) {
			return 31;
		}
	}

	/**
	 * getDayOfWeek
	 * 
	 * @param date
	 *            the date
	 * @param dateFormat
	 *            date format pattern
	 * @return String
	 */
	public static String getDayOfWeekString(String date, String dateFormat) {
		return DAY_OF_WEEK[getDayOfWeek(date, dateFormat) - 1];
	}

	/**
	 * getDayOfWeek
	 * 
	 * @param date
	 *            the date
	 * @param dateFormat
	 *            date format pattern
	 * @return int
	 */
	public static int getDayOfWeek(String date, String dateFormat) {
		try {
			int year = 1;
			int month = 1;
			int day = 1;

			date = formatDateFormatToyyyyMMdd(date, dateFormat);

			year = Integer.parseInt(date.substring(0, 4));
			month = Integer.parseInt(date.substring(4, 6));
			day = Integer.parseInt(date.substring(6));

			Calendar c = Calendar.getInstance();
			synchronized (c) {
				c.set(Calendar.YEAR, year);
				c.set(Calendar.MONTH, month - 1);
				c.set(Calendar.DATE, day);
				return c.get(Calendar.DAY_OF_WEEK);
			}

		} catch (Exception e) {
			throw new IllegalArgumentException(
					"THIS DATE (" + date + ") IS NOT SUPPORT"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * check the year is leap year.
	 * 
	 * @param year
	 *            the input year.
	 * @return boolean true, if leap year, otherwise is not.
	 */
	public static boolean isLeapYear(int year) {
		return GC.isLeapYear(year);
	}

	/**
	 * check date is valid or not
	 * 
	 * @param date
	 *            the date
	 * @param dateFormat
	 *            support 1.java.text.SimpleDateFormat(yyyyMMdd,ddMMyyyy...etc)
	 *            2. Chinese date for YYYMMDD and YYY/MM/DD
	 * 
	 * @return if valid return true.
	 */
	public static boolean validDate(String date, String dateFormat) {
		if (date == null)
			return false;
		int y, m, d;

		try {

			if (dateFormat != null
					&& Pattern.matches("YYY[/-]?MM[/-]?DD", dateFormat)) {
				String tmpDate = date.replaceAll("/", "").replaceAll("-", "");
				boolean hasMinus = false;
				if (date.startsWith("-")) {
					hasMinus = true;
					tmpDate = tmpDate.substring(1);
				}
				tmpDate = CapString.fillZeroHead(tmpDate, 7);
				y = Integer.parseInt((hasMinus ? "-" : "")
						+ tmpDate.substring(0, 3))
						+ 1911 + (hasMinus ? 1 : 0);
				m = Integer.parseInt(tmpDate.substring(3, 5));
				d = Integer.parseInt(tmpDate.substring(5));
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
				sdf.setLenient(false);
				ParsePosition pos = new ParsePosition(0);

				Date d1 = sdf.parse(date, pos);

				return (d1 == null) ? false : true;

			}
		} catch (Exception e) {
			return false;
		}

		return validDate(y, m, d);
	}

	/**
	 * check date is valid or not
	 * 
	 * @param y
	 *            the year
	 * @param m
	 *            the month
	 * @param d
	 *            the day
	 * @return if valid return true.
	 */
	public static boolean validDate(int y, int m, int d) {
		try {
			int maxDay = m == -1 ? 31 : DAYS_OF_MONTH[m - 1];

			if (y != -1 && m == 2) {
				if (GC.isLeapYear(y)) {
					maxDay = 29;
				} else {
					maxDay = 28;
				}
			}
			if (d == -1 || d > 0 && d <= maxDay) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Format date string from dateFormat to yyyyMMdd. <br>
	 * 
	 * @param date
	 *            input date
	 * @param dateFormat
	 *            support
	 *            1.java.text.SimpleDateFormat(yyyyMMdd,ddMMyyyy,dd-MMM-yy
	 *            hh:mm:ss...etc), you may set Locale as you need
	 *            (ex:Locale.setDefault(Locale.ENGLISH)) and 2. Chinese date for
	 *            YYYMMDD and YYY/MM/DD
	 * 
	 * @return fromatted date string, if any exception or date not valid, return
	 *         null
	 * 
	 */
	public static String formatDateFormatToyyyyMMdd(String date,
			String dateFormat) {
		if (!validDate(date, dateFormat))
			return null;
		String tempValue = "";

		if (Pattern.matches("YYY[/-]?MM[/-]?DD", dateFormat)) {
			String tmpDate = date.replaceAll("/", "").replaceAll("-", "");
			boolean hasMinus = false;
			if (date.startsWith("-")) {
				hasMinus = true;
				tmpDate = tmpDate.substring(1);
			}
			if (tmpDate.length() > 7 || tmpDate.length() < 5) {
				return date;
			}
			tmpDate = CapString.fillZeroHead(tmpDate, 7);
			tempValue = (Integer.parseInt((hasMinus ? "-" : "")
					+ tmpDate.substring(0, 3)) + 1911 + (hasMinus ? 1 : 0))
					+ tmpDate.substring(3, 5) + tmpDate.substring(5);
		} else {
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			Date d1;
			try {
				d1 = new SimpleDateFormat(dateFormat).parse(date);
				tempValue = df.format(d1);
			} catch (ParseException e) {
				return null;
			}
		}

		return tempValue;
	}

	/**
	 * Format date string from Date Object to dateFormat.
	 * 
	 * @param date
	 *            input date
	 * @param dateFormat
	 *            support
	 *            1.java.text.SimpleDateFormat(yyyyMMdd,ddMMyyyy,dd-MMM-yy
	 *            hh:mm:ss...etc), you may set Locale as you need
	 *            (ex:Locale.setDefault(Locale.ENGLISH)) and 2. Chinese date for
	 *            YYYMMDD and YYY/MM/DD
	 * 
	 * @return fromatted date string, if any exception or date not valid, return
	 *         null
	 */
	public static String formatDate(Date date, String dateFormat) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String theDate = df.format(date);
		return CapDate.formatyyyyMMddToDateFormat(theDate, dateFormat);
	}

	/**
	 * Format date string from yyyyMMdd to dateFormat.
	 * 
	 * @param date
	 *            input date
	 * @param dateFormat
	 *            support
	 *            1.java.text.SimpleDateFormat(yyyyMMdd,ddMMyyyy,dd-MMM-yy
	 *            hh:mm:ss...etc), you may set Locale as you need
	 *            (ex:Locale.setDefault(Locale.ENGLISH)) and 2. Chinese date for
	 *            YYYMMDD and YYY/MM/DD
	 * 
	 * @return fromatted date string, if any exception or date not valid, return
	 *         null
	 */
	public static String formatyyyyMMddToDateFormat(String date,
			String dateFormat) {
		if (!validDate(date, "yyyyMMdd"))
			return null;
		String tempValue = "";
		try {
			if ("YYYMMDD".equals(dateFormat)) {
				tempValue = CapString.fillZeroHead(
						convertDateToTaiwanYear(date.substring(0, 4)) + "", 3)
						+ date.substring(4, 6) + date.substring(6);
			} else if ("YYY/MM/DD".equals(dateFormat)) {
				tempValue = convertDateToTaiwanYear(date.substring(0, 4)) + "/"
						+ date.substring(4, 6) + "/" + date.substring(6);
			} else {
				DateFormat df = new SimpleDateFormat(dateFormat);
				Date d1 = new SimpleDateFormat("yyyyMMdd").parse(date);
				tempValue = df.format(d1);
			}
		} catch (Exception e) {
			return null;
		}

		return tempValue;
	}

	/**
	 * <pre>
	 * 修正民國元年前問題
	 * </pre>
	 * 
	 * @param year
	 *            西元年
	 * @return String
	 */
	public static String convertDateToTaiwanYear(String year) {
		int fixYear = Integer.parseInt(year) - 1911;
		return CapString.fillZeroHead(
				String.valueOf((fixYear < 1) ? fixYear - 1 : fixYear), 3);
	}

	/**
	 * Format date string from dateFormat1 to dateFormat2.
	 * 
	 * @param date
	 *            input date
	 * @param fromDateFormat
	 *            support
	 *            1.java.text.SimpleDateFormat(yyyyMMdd,ddMMyyyy,dd-MMM-yy
	 *            hh:mm:ss...etc), you may set Locale as you need
	 *            (ex:Locale.setDefault(Locale.ENGLISH)) and 2. Chinese date for
	 *            YYYMMDD and YYY/MM/DD
	 * @param toDateFormat
	 *            support
	 *            1.java.text.SimpleDateFormat(yyyyMMdd,ddMMyyyy,dd-MMM-yy
	 *            hh:mm:ss...etc), you may set Locale as you need
	 *            (ex:Locale.setDefault(Locale.ENGLISH)) and 2. Chinese date for
	 *            YYYMMDD and YYY/MM/DD
	 * @return fromatted date string, if any exception or date not valid, return
	 *         null
	 * 
	 */
	public static String formatDateFromF1ToF2(String date,
			String fromDateFormat, String toDateFormat) {

		return formatyyyyMMddToDateFormat(
				formatDateFormatToyyyyMMdd(date, fromDateFormat), toDateFormat);
	}

	/**
	 * <pre>
	 * 傳入的日期是否符合格式&lt;param&gt;pattern&lt;/param&gt;。
	 * </pre>
	 * 
	 * @param value
	 *            日期字串
	 * @param pattern
	 *            date format pattern
	 * @return boolean
	 */
	public static boolean isMatchPattern(String value, String pattern) {
		try {
			SimpleDateFormat fomrat = new SimpleDateFormat(pattern);

			Date date = fomrat.parse(value);
			String formatDateStr = fomrat.format(date);

			return (date != null && value.equals(formatDateStr));

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * <pre>
	 * 將字串中西元年轉換為民國年
	 * 9999年亦轉為999年
	 * 支援格式 XX/XX/YYYY,XX/XX/YY (需為20xx年)
	 *         YYYY/XX/XX,YY/XX/XX(需為20xx年)
	 *         YYYYXXXX,YYXXXX    (需為20xx年)
	 *         XXXXYYYY,XXXXYY    (需為20xx年)
	 * </pre>
	 * 
	 * @param str
	 * @param type
	 * @return
	 */
	public static String yy = "[0-9]{2}";
	public static String yyyy = "[0-9]{4}";
	public static String ddmm = "(((0[1-9]|[12][0-9]|3[0-1]))(0[13578]|1[02])|((0[1-9]|[12][0-9]|30)(0[469]|11))|((0[1-9]|[12][0-9])02))";
	public static String mmdd = "(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[0-1]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[12][0-9])))";
	public static String dd_mm = "(((0[1-9]|[12][0-9]|3[0-1]))/(0[13578]|1[02])|((0[1-9]|[12][0-9]|30)/(0[469]|11))|((0[1-9]|[12]/[0-9])02))";
	public static String mm_dd = "(((0[13578]|1[02])/(0[1-9]|[12][0-9]|3[0-1]))|((0[469]|11)/(0[1-9]|[12][0-9]|30))|(02/(0[1-9]|[12][0-9])))";
	public static String DIVISION_SIGN = "/";
	public static String EMPTY_STRING = "";

	/**
	 * 將西元年日期字串轉為民國年日期字串格式
	 * 
	 * @param str
	 *            西元年日期字串
	 * @param type
	 *            傳入的西元年日期字串的日期格式
	 * @return String
	 */
	public static String replaceStrDateToTwDate(String str, String type) {
		type = type.toUpperCase();
		if (!type
				.matches("((YY|YYYY)(MMDD|/MM/DD|DDMM|/DD/MM)|(MMDD|MM/DD/|DDMM|DD/MM/)(YY|YYYY))")) {
			return str;
		}
		StringBuffer bRegEx = new StringBuffer();
		boolean hasSign = (type.indexOf("/") != -1);
		boolean isYYYY = CapString.checkRegularMatch(type, "YYYY");
		boolean yyFirst = CapString.checkRegularMatch(type, "^Y");
		boolean mmFirst = CapString.checkRegularMatch(type, "MM/?DD");

		if (mmFirst) {
			bRegEx.append(hasSign ? mm_dd : mmdd);
		} else {
			bRegEx.append(hasSign ? dd_mm : ddmm);
		}
		if (yyFirst) {
			bRegEx.insert(0, hasSign ? DIVISION_SIGN : EMPTY_STRING).insert(0,
					isYYYY ? yyyy : yy);
		} else {
			bRegEx.append((hasSign ? DIVISION_SIGN : EMPTY_STRING)).append(
					isYYYY ? yyyy : yy);
		}

		if (!isYYYY && yyFirst) {
			type = "yy" + type;
		} else if (!isYYYY && !yyFirst) {
			type = type + "yy";
		}

		type = type.replaceAll("Y", "y").replaceAll("m", "M")
				.replaceAll("D", "d");
		String regEx = bRegEx.toString();
		regEx = new StringBuffer("(^").append(regEx).append("$| ")
				.append(regEx).append("|^").append(regEx).append(" | ")
				.append(regEx).append("$)").toString();

		String match = CapString.getRegularMatch(str, regEx);
		// 因確保不會找錯所以每次都重找一次
		while (!CapString.isEmpty(match)) {
			StringBuffer date = new StringBuffer(match.trim());
			StringBuffer twDate = new StringBuffer();
			int year;
			if (!isYYYY && yyFirst) {
				year = Integer.valueOf(date.substring(0, 2));
				date.insert(0, (year < 50) ? "20" : "19");
			} else if (!isYYYY && !yyFirst) {
				year = Integer.valueOf(date.substring(date.length() - 2,
						date.length()));
				date.insert(date.length() - 2, (year < 50) ? "20" : "19");
			}
			twDate.append(CapString.checkRegularMatch(match, "^ ") ? " " : "");
			twDate.append(CapDate.formatyyyyMMddToDateFormat(CapDate
					.formatDateFromF1ToF2(date.toString(), type, "yyyyMMdd"),
					"YYY/MM/DD"));
			twDate.append(CapString.checkRegularMatch(match, " $") ? " " : "");
			if (CapString.checkRegularMatch(twDate.toString(), "^8088")) {
				twDate.replace(0, 4, "999");
			} else if (CapString.checkRegularMatch(twDate.toString(), "^ 8088")) {
				twDate.replace(0, 5, " 999");
			}
			boolean hasMinus = (twDate.charAt(0) == '-');
			str = str.replace(
					match,
					(hasMinus ? "-" : "")
							+ CapString.fillZeroHead(
									twDate.substring((hasMinus) ? 1 : 0), 9));
			match = CapString.getRegularMatch(str, regEx);
		}

		return str;
	}

	/**
	 * 增加 or 減少月份 (傳入格式 20081212 ) &#064;param oldyyyymmdd 原日期 &#064;param i
	 * 正數表示增加，負數表示減少 &#064;return 增減後的日期
	 * 
	 * @param oldyyyymmdd
	 *            date
	 * @param i
	 *            role date
	 * @return String
	 */
	public static String addMonth(String oldyyyymmdd, int i) {
		String val = null;

		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(oldyyyymmdd.substring(0, 4)),
				Integer.parseInt(oldyyyymmdd.substring(4, 6)) - 1, // 一月為0，十二月為11
				Integer.parseInt(oldyyyymmdd.substring(6, 8)));

		c.add(Calendar.MONTH, i);// 往前後 i 個月

		String sYYYY = String.valueOf(c.get(Calendar.YEAR));
		int iMM = c.get(Calendar.MONTH) + 1;
		int iDD = c.get(Calendar.DAY_OF_MONTH);

		String sMM = (iMM < 10) ? String.valueOf("0" + iMM) : String
				.valueOf(iMM);
		String sDD = (iDD < 10) ? String.valueOf("0" + iDD) : String
				.valueOf(iDD);

		val = sYYYY + sMM + sDD;

		return val;
	}// end function

	private final static SimpleDateFormat sdateTimef = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * fomat data time yyyy-MM-dd HH:mm:ss
	 * 
	 * @param time
	 *            Timestamp
	 * @return String
	 */
	public static String getDateTimeFormat(Timestamp time) {
		return sdateTimef.format(new Date(time.getTime()));
	}

	/**
	 * 轉換字串成日期後，將時分秒調整為00:00:00。
	 * 
	 * @param date
	 *            String of date
	 * @param dateFormat
	 *            String of dateFormat
	 * @return a Date with firstMinute
	 * @see com.CapDate.cap.utils.CapDate#getDate
	 */
	public static Date getFirstMinuteDate(String date, String dateFormat) {

		Date date1 = getDate(date, dateFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(date1);
		Calendar rtnC = Calendar.getInstance();
		rtnC.clear();
		rtnC.set(Calendar.YEAR, c.get(Calendar.YEAR));
		rtnC.set(Calendar.MONTH, c.get(Calendar.MONTH));
		rtnC.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
		return rtnC.getTime();
	}

	/**
	 * 轉換字串成日期後，將時分秒調整為23:59:59。
	 * 
	 * @param date
	 *            String of date
	 * @param dateFormat
	 *            String of dateFormat
	 * @return a Date with lastMinute
	 * @see com.CapDate.cap.utils.CapDate#getDate
	 */
	public static Date getLastMinuteDate(String date, String dateFormat) {

		Date date1 = getDate(date, dateFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(date1);
		Calendar rtnC = Calendar.getInstance();
		rtnC.clear();
		rtnC.set(Calendar.YEAR, c.get(Calendar.YEAR));
		rtnC.set(Calendar.MONTH, c.get(Calendar.MONTH));
		rtnC.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
		rtnC.set(Calendar.SECOND, -1);
		return rtnC.getTime();
	}

	/**
	 * <pre>
	 * 取得現在時間
	 * </pre>
	 * 
	 * @return Timestamp
	 */
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 將日期的字串格式(yyyy-MM-dd |　yyyy/MM/dd | yyyyMMdd)轉換成java.util.Date形態
	 * 
	 * @param date
	 *            string
	 * @return Date
	 */
	public static Date parseDate(String date) {
		Date result = null;
		if (!"".equals(CapString.trimNull(date))) {
			if (validDate(date, "yyyy-MM-dd")) {
				result = getDate(date, "yyyy-MM-dd");
			} else if (validDate(date, "yyyy/MM/dd")) {
				result = getDate(date, "yyyy/MM/dd");
			} else if (validDate(date, "yyyyMMdd")) {
				result = getDate(date, "yyyyMMdd");
			}
		}
		return result;
	}

	/**
	 * get current sql date
	 * 
	 * @return SQL DATE
	 */
	public static java.sql.Date getCurrentSqlDate() {
		return parseSQLDate(new Date());
	}

	/**
	 * 將日期的字串格式(yyyy-MM-dd |　yyyy/MM/dd | yyyyMMdd)轉換成java.sql.Date形態
	 * 
	 * @param date
	 *            date
	 * @return java.sql.Date
	 */
	public static java.sql.Date parseSQLDate(String date) {
		return new java.sql.Date(parseDate(date).getTime());
	}

	/**
	 * 將java.util.Date轉換成java.sql.Date形態
	 * 
	 * @param date
	 *            java.util.Date
	 * @return java.sql.Date
	 */
	public static java.sql.Date parseSQLDate(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}

	private static SimpleDateFormat _tdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 將Timestamp 轉換為 String yyyy-MM-dd HH:mm:ss
	 * 
	 * @param time
	 *            time
	 * @return String
	 */
	public static String parseToString(Timestamp time) {
		return _tdf.format(time);
	}

	/**
	 * <pre>
	 * 日期字串轉換為Timestamp
	 * </pre>
	 * 
	 * @param date
	 *            日期字串 格式：yyyy-MM-dd HH:mm:ss
	 * @return Timestamp
	 */
	public static Timestamp convertStringToTimestamp1(String date) {
		return convertStringToTimestamp(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * <pre>
	 * 日期字串轉換為Timestamp
	 * </pre>
	 * 
	 * @param date
	 *            日期字串 格式：yyyyMMddHHmmss
	 * @return Timestamp
	 */
	public static Timestamp convertStringToTimestamp2(String date) {
		return convertStringToTimestamp(date, "yyyyMMddHHmmss");
	}

	/**
	 * 日期處理(String+Format=Timestamp)
	 * 
	 * @param date
	 * @return Timestamp
	 */
	public static Timestamp convertStringToTimestamp(String date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		df.setLenient(false);
		return new Timestamp(df.parse(date, new ParsePosition(0)).getTime());
	}

	/**
	 * 日期字串轉換(datetime)
	 * 
	 * @param time
	 * @param format1
	 * @param format2
	 * @return
	 */
	public static String convertDateTimeFromF1ToF2(String time, String format1,
			String format2) {
		Timestamp tp = convertStringToTimestamp(time, format1);
		return convertTimestampToString(tp, format2);
	}

	/**
	 * 傳換Timestamp
	 * 
	 * @param tp
	 *            Timestamp 日期
	 * @param dataFormat
	 *            String 格式 ex:"yyyy-MM-dd.HH.mm.ss.000000"
	 * @return String
	 */
	public static String convertTimestampToString(Timestamp tp,
			String dataFormat) {
		String rtnStr = null;
		SimpleDateFormat sdf = new SimpleDateFormat(dataFormat);
		rtnStr = sdf.format(tp);
		return rtnStr;
	}

	/**
	 * 獲得指定日期的後一天
	 * 
	 * @param specifiedDay
	 *            指定日期
	 * @return String
	 */
	public static String getSpecifiedDayAfter(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			return null;
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
				.format(c.getTime());
		return dayAfter;
	}
}//
