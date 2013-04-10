/*_
 * Copyright (c) 2009-2011 International Integrated System, Inc. 
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

package com.iisigroup.cap.handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import com.iisigroup.cap.action.IAction;
import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.context.CapParameter;
import com.iisigroup.cap.dao.utils.AbstractSearchSetting;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.enums.IGridEnum;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.operation.OpStepContext;
import com.iisigroup.cap.operation.Operation;
import com.iisigroup.cap.operation.OperationStep;
import com.iisigroup.cap.plugin.HandlerPlugin;
import com.iisigroup.cap.response.GridResult;
import com.iisigroup.cap.response.IGridResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapCommonUtil;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 直接以method name來執行(formAction傳入method name)
 * 若未指定method時，預設執行doWork()
 * </pre>
 * 
 * @since 2010/12/8
 * @author iristu
 * @version <ul>
 *          <li>2010/12/8,iristu,new
 *          <li>2011/11/1,rodeschen,from cap marge from and grid
 *          <li>2012/3/8,rodeschen,add column marge index and name
 *          <li>2012/9/20,iristu,改由HandlerType來判斷取得Operation
 *          </ul>
 */
public abstract class MFormHandler extends HandlerPlugin {

	@Resource(name = "handlerOpMapping")
	private CapParameter handlerOp;

	/**
	 * <pre>
	 * 直接以method name來執行
	 * </pre>
	 * 
	 * @param formAction
	 *            action
	 * @return IAction
	 */
	@Override
	public IAction getAction(String formAction) {
		return new MethodExecuteAction(this);
	}

	/**
	 * <pre>
	 * MethodExecuteAction
	 * </pre>
	 */
	private class MethodExecuteAction implements IAction {

		MFormHandler executeHandler;

		public MethodExecuteAction(MFormHandler executeObj) {
			this.executeHandler = executeObj;
		}

		@Override
		public IResult doWork(IRequest params) {
			IResult rtn = null;
			String methodId = params.get(FORM_ACTION);
			if (CapString.isEmpty(methodId)) {
				methodId = "doWork";
			}
			boolean hasMethod = false;
			try {
				Method method = CapCommonUtil.findMethod(
						executeHandler.getClass(), methodId, (Class<?>) null);
				if (method != null) {
					HandlerType type = method.getAnnotation(HandlerType.class);
					if (type != null
							&& HandlerTypeEnum.GRID.equals(type.value())) {
						rtn = getGridData(method, params);
					} else {
						rtn = (IResult) method.invoke(executeHandler, params);
					}
					hasMethod = true;
				}
				// for (Method method : ReflectionUtils
				// .getAllDeclaredMethods(executeHandler.getClass())) {
				// if (methodId.equals(method.getName())) {
				// HandlerType type = method
				// .getAnnotation(HandlerType.class);
				// if (type == null
				// || HandlerTypeEnum.FORM.equals(type.value())) {
				// rtn = (IResult) method.invoke(executeHandler,
				// params);
				// } else if (HandlerTypeEnum.GRID.equals(type.value())) {
				// rtn = execute(method, params);
				// }
				// hasMethod = true;
				// break;
				// }
				// }

			} catch (InvocationTargetException e) {
				if (e.getCause() instanceof CapMessageException) {
					throw (CapMessageException) e.getCause();
				} else if (e.getCause() instanceof CapException) {
					throw (CapException) e.getCause();
				} else {
					throw new CapException(e.getCause(),
							executeHandler.getClass());
				}
			} catch (Throwable t) {
				throw new CapException(t, executeHandler.getClass());
			}
			if (!hasMethod) {
				throw new CapMessageException("action not found", getClass());
			}
			return rtn;
		}

	}// ;

	@SuppressWarnings({ "rawtypes" })
	private IResult getGridData(Method method, IRequest params) {
		ISearch search = createSearchTemplete();
		boolean pages = params.containsParamsKey(IGridEnum.PAGE.getCode());
		int page = 0, pageRows = 0, startRow = 0;
		if (pages) {
			page = params.getParamsAsInteger(IGridEnum.PAGE.getCode());
			pageRows = params.getParamsAsInteger(IGridEnum.PAGEROWS.getCode());
			startRow = (page - 1) * pageRows;
			search.setFirstResult(startRow).setMaxResults(pageRows);
		}
		boolean sort = params.containsParamsKey(IGridEnum.SORTCOLUMN.getCode())
				&& !CapString
						.isEmpty(params.get(IGridEnum.SORTCOLUMN.getCode()));
		if (sort) {
			String[] sortBy = params.get(IGridEnum.SORTCOLUMN.getCode()).split(
					"\\|");
			String[] isAscAry = params.get(IGridEnum.SORTTYPE.getCode(), "asc")
					.split("\\|");
			for (int i = 0; i < sortBy.length; i++) {
				String isAsc = (i < isAscAry.length) ? isAscAry[i] : "asc";
				search.addOrderBy(sortBy[i], !IGridEnum.SORTASC.getCode()
						.equals(isAsc));
			}
		}
		IGridResult result = null;
		try {
			result = (IGridResult) method.invoke(this, search, params);
			result.setColumns(getColumns(params.get(IGridEnum.COL_PARAM
					.getCode())));
			result.setPage(page);
			result.setPageCount(result.getRecords(), pageRows);
		} catch (InvocationTargetException e) {
			if (e.getCause() instanceof CapMessageException) {
				throw (CapMessageException) e.getCause();
			} else if (e.getCause() instanceof CapException) {
				throw (CapException) e.getCause();
			} else {
				throw new CapException(e.getCause(), this.getClass());
			}
		} catch (Throwable t) {
			throw new CapException(t, this.getClass());
		}
		return result;
	}// ;

	/**
	 * 取得iGrid中的Column Name
	 * 
	 * @param params
	 *            String
	 * @return String string[]
	 */
	@SuppressWarnings("unchecked")
	protected String[] getColumns(String params) {
		JSONArray arr = JSONArray.fromObject(params);
		String[] colNames = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			Map<String, String> m = (Map<String, String>) arr.get(i);
			if (m.containsKey(IGridEnum.COL_INDEX.getCode())) {
				colNames[i] = new StringBuffer()
						.append(m.get(IGridEnum.COL_NAME.getCode()))
						.append("|")
						.append(m.get(IGridEnum.COL_INDEX.getCode()))
						.toString();
			} else {
				colNames[i] = m.get(IGridEnum.COL_NAME.getCode());
			}
		}
		return colNames;
	};

	/**
	 * <pre>
	 * 若未傳送formAction值，則default執行此method
	 * </pre>
	 * 
	 * @param params
	 *            PageParameters
	 * @return IResult
	 */
	public IResult doWork(IRequest params) {
		return null;
	}

	@Override
	public IResult execute(IRequest params) {
		Operation oper = getOperation(params);
		if (oper != null) {
			OpStepContext ctx = new OpStepContext(OperationStep.NEXT);
			oper.execute(ctx, params, this);
			return ctx.getResult();
		}
		return null;
	}// ;

	protected String getOperationName(IRequest params) {
		String methodId = params.get(FORM_ACTION);
		Method method = CapCommonUtil.findMethod(this.getClass(), methodId,
				(Class<?>) null);
		if (method != null) {
			HandlerType type = method.getAnnotation(HandlerType.class);
			if (type != null) {
				return handlerOp
						.getValue(type.value().name(), SIMPLE_OPERATION);
			}
		}
		return SIMPLE_OPERATION;
	}// ;

	protected Operation getOperation(IRequest params) {
		return (Operation) CapAppContext.getApplicationContext().getBean(
				getOperationName(params));
	}// ;

	private ISearch createSearchTemplete() {
		return new GridSearch();
	}

	/**
	 * <pre>
	 * GridSearch extends AbstractSearchSetting
	 * </pre>
	 */
	private class GridSearch extends AbstractSearchSetting {

		private static final long serialVersionUID = 1L;

	}

	@Override
	public String getHandlerName() {
		return getPluginName();
	}

}// ~
