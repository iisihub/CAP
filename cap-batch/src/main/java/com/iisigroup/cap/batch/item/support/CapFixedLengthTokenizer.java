/* 
 * CapFixedLengthTokenizer.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.batch.item.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.file.transform.FixedLengthTokenizer;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2012/11/19
 * @author iristu
 * @version <ul>
 *          <li>2012/11/19,iristu,new
 *          </ul>
 */
public class CapFixedLengthTokenizer extends FixedLengthTokenizer {

	private String encoding = "utf-8";

	private int[] columns;

	public void setColumns(int[] ranges) {
		this.columns = ranges;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	@Override
	protected List<String> doTokenize(String line) {
		List<String> tokens = new ArrayList<String>(columns.length);
		int lineLength;
		String token;

		try {
			byte[] b = line.getBytes(encoding);
			lineLength = b.length;
			int startPos = 0;
			for (int i = 0; i < columns.length; i++) {
				int endPos = columns[i];
				try {
					if (lineLength >= endPos) {
						token = new String(b, startPos, endPos, encoding)
								.trim();
						startPos += endPos;
					} else if (lineLength >= startPos) {
						token = new String(b, startPos, lineLength - startPos,
								encoding).trim();
					} else {
						token = "";
					}
				} catch (StringIndexOutOfBoundsException e) {
					token = new String(line.getBytes(), startPos,
							line.getBytes().length - startPos).trim();
				}
				tokens.add(token);
			}
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}

		return tokens;
	}
}
