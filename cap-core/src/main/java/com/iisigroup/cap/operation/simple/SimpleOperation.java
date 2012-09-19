/*
 * SimpleOperation.java
 *
 * Copyright (c) 2009-2011 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.operation.simple;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.handler.FormHandler;
import com.iisigroup.cap.operation.Operation;
import com.iisigroup.cap.operation.OperationStep;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.utils.CapString;

/**
 * <p>
 * SimpleOperation.
 * </p>
 * 
 * @author iristu
 * @version <ul>
 *          <li>2010/7/22,iristu,new
 *          </ul>
 */
public class SimpleOperation implements Operation {

	private static Logger logger = LoggerFactory
			.getLogger(SimpleOperation.class);

	String operName;
	Map<String, OperationStep> ruleMap;
	IResult result;

	/*
	 * (non-Javadoc)
	 * 
	 * @see tw.com.iisi.cap.flow.Operation#execute()
	 */
	public IResult execute(IRequest params, FormHandler handler)
			throws CapException {
		OperationStep step = getStartStep();
		IResult formResult = result;
		long startOperation = System.currentTimeMillis();
		try {
			SimpleContextHolder.resetContext();
			while (step != null) {
				String result = null;
				try {
					long startStep = System.currentTimeMillis();
					result = step.execute(params, handler, formResult);
					logger.debug(step.getName() + " cost : "
							+ (System.currentTimeMillis() - startStep));
				} catch (CapException e) {
					result = step.handleException(e);
					throw e;
				}
				if (!CapString.isEmpty(result)) {
					if (OperationStep.NEXT.equals(result)) {
						step = getNextStep(step.getName());
					} else if (OperationStep.RETURN.equals(result)
							|| OperationStep.ERROR.equals(result)) {
						step = null;
					} else {
						step = getStep(step.getRuleMap().get(result));
					}
				}
			}
			return formResult;
		} catch (CapException ce) {
			throw ce;
		} catch (Exception e) {
			throw new CapException(e, getClass());
		} finally {
			SimpleContextHolder.resetContext();
			logger.debug("Operation cost : "
					+ (System.currentTimeMillis() - startOperation));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tw.com.iisi.cap.flow.Operation#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.operName = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tw.com.iisi.cap.flow.Operation#getName()
	 */
	public String getName() {
		return operName;
	}

	public OperationStep getStartStep() {
		if (ruleMap != null && !ruleMap.isEmpty()) {
			Set<Entry<String, OperationStep>> steps = ruleMap.entrySet();
			for (Entry<String, OperationStep> entry : steps) {
				OperationStep step = entry.getValue();
				step.setName(entry.getKey());
				return step;
			}
		}
		return null;
	}

	public OperationStep getNextStep(String currentStepName) {
		if (ruleMap != null && !ruleMap.isEmpty()) {
			Set<Entry<String, OperationStep>> steps = ruleMap.entrySet();
			boolean b = false;
			for (Entry<String, OperationStep> entry : steps) {
				if (b) {
					OperationStep step = entry.getValue();
					step.setName(entry.getKey());
					return step;
				} else if (currentStepName.equals(entry.getKey())) {
					b = true;
				}
			}
		}
		return null;
	}

	public OperationStep getStep(String stepName) {
		if (ruleMap != null && ruleMap.containsKey(stepName)) {
			OperationStep step = ruleMap.get(stepName);
			step.setName(stepName);
			return step;
		}
		return null;
	}

	public Map<String, OperationStep> getRuleMap() {
		return this.ruleMap;
	}

	public void setRuleMap(final Map<String, OperationStep> ruleMap) {
		this.ruleMap = ruleMap;
	}

	public void setResult(IResult result) {
		this.result = result;
	}

}
