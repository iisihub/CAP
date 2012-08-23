package com.iisigroup.cap.base.handler;

import java.util.Locale;
import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.utils.AppContext;

/**
 * <pre>
 * base Handler
 * </pre>
 * 
 * @since 2011/11/28
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/28,rodeschen,new
 *          </ul>
 */
@Scope("request")
@Controller("basehandler")
public class BaseHandler extends MFormHandler {

	/**
	 * <pre>
	 * 檔案作業完成後以防IE status bar 不停止
	 * </pre>
	 * 
	 * @param params
	 *            PageParameters
	 * @return IResult
	 * @throws CapException
	 */
	public IResult fileSuccess(IRequest params) throws CapException {
		return new AjaxFormResult();
	}

	@HandlerType(HandlerTypeEnum.FORM)
	public IResult queryJsI18N(IRequest request) throws CapException {
		Properties prop = new Properties();
		AjaxFormResult result = new AjaxFormResult();
		Locale locale = null;
		try {
			locale = CapSecurityContext.getLocale();
		} catch (Exception e) {
			locale = Locale.getDefault();
		}
		String i18nFile = null;
		try {
			i18nFile = new StringBuffer("classpath:/i18n/").append(request.get("f").replaceAll("/?webroot/page", "")).append("_").append(locale.toString()).append(".properties").toString();
			prop.load(AppContext.getApplicationContext().getResource(i18nFile).getInputStream());
			for (Entry<Object, Object> entry : prop.entrySet()) {
				result.set((String) entry.getKey(), (String) entry.getValue());
			}
		} catch (Exception e) {
			logger.error("can't load " + i18nFile, e);
			// throw new CapException(e, getClass());
		}
		return result;
	}
	
	@HandlerType(HandlerTypeEnum.FORM)
	public IResult changeLogLevel(IRequest request) throws CapException {
//		String level = request.getString("l", "INFO");
//		LogManager.getLogger("com.iisi").setLevel(Level.toLevel(level));
//		LogManager.getLogger("com.bqd.mci").setLevel(Level.toLevel(level));
		AjaxFormResult result = new AjaxFormResult();
		return result;
	}
	
	@HandlerType(HandlerTypeEnum.FORM)
	public IResult queryMenu(IRequest request) throws CapException {
//		BQDUserDetails user = CapSecurityContext.getSecurityContext().getUser();
//		if (user != null) {
//			JSONArray JsonArray = user.getMenu();
//			if (JsonArray == null) {
//				JsonArray = queryLoginMenuById(user.getUserId());
//				user.setMenu(JsonArray);
//			}
//			return new CapAjaxFormResult().set("menu", JsonArray.toString());
//		}
//		return new CapAjaxFormResult().set("menu", "");
		 return new AjaxFormResult()
		 .set("menu","[{name: \"營銷策略\",    url: 'xxx/xxx/xx',    child: [{name: \"商品新增\",url: \"system/MCI020401C01\"},{name: \"商品維護\",  url: \"system/MCI020401U01\"}, {name: \"策略新增\",url: \"system/MCI020402C02\"},{name: \"策略複製\",url: \"system/MCI020402C03\"},{name: \"策略維護\",url: \"system/MCI020402U02\"},{name: \"策略啓用\",url: \"system/MCI020402U03\"},{name:\"策略停用\",url:\"system/MCI020402U10\"}]}, { name: \"客戶總覽\",    url: 'xxx/xxx/xx',    child: [{        name: \"客戶查詢\",        url: \"xxx/xx/xx\"    }, {        name: \"客戶合約\",        url: \"xxx/xx/xx\"    }]}, {    name: \"統一簽約\",    url: 'xxx/xxx/xx',    child: [{name:\"合約查詢\",url:\"system/MCI030611Q20\"},{name:\"合約維護\",url: \"system/MCI030511S15\"}]}, {    name: \"應辦提醒\",    url: 'xxx/xxx/xx',    child: [{name: \"短信/Email通知報表\",url: \"system/MCI051114R10\"},{name: \"提醒查詢\",url: \"xxx/xx/xx\"}, {name: \"提醒新增\",url: \"xxx/xx/xx\"}, ]}, {name: \"互動通知\",url: 'xxx/xxx/xx',child: [{name: \"渠道間通知報表\",url: \"system/MCI041112R09\"},{name: \"互動查詢\",url: \"xxx/xx/xx\"}, {        name: \"互動新增\",        url: \"xxx/xx/xx\"    }]},{ name: \"營銷報表\", url: 'xxx/xxx/xx', child: [{  name: \"綜合營銷力度報表\", url: \"system/MCI020802Q10\" },{ name: \"渠道營銷力度報表\", url: \"system/MCI020802Q11\" },{ name: \"商品營銷力度報表\", url: \"system/MCI020802Q12\" },{ name: \"營銷策略力度報表\", url: \"system/MCI020802Q13\" },{ name: \"渠道營銷機會報表\", url: \"system/MCI020805Q15\" },{ name: \"策略營銷機會報表\", url: \"system/MCI020805Q17\" },{ name: \"商品營銷機會報表\", url: \"system/MCI020805Q16\" },{ name: \"營銷機會追蹤明細報表\", url: \"system/MCI020805Q14\" }]},{    name: \"系統管理\",    url: 'xxx/xxx/xx',    child: [{ name: \"選單維護\", url: \"system/codetype\"},{name:\"渠道新增\",url: \"system/MCI061227S18\"},{name:\"渠道維護\",url: \"system/MCI061227S17\"},{name:\"場景新增\",url: \"system/MCI061227S22\"},{name:\"場景維護\",url: \"system/MCI061227S20\"},{name:\"用戶新增\",url: \"system/MCI061227S19\"},{name:\"用戶維護\",url: \"system/MCI061227S21\"},{name:\"角色管理\",url: \"system/MCI061219S04\"},{name:\"日誌管理\",url: \"system/MCI061517C07\"},{name:\"功能權限設定\",url: \"system/MCI061219S06\"},{name:\"系統參數設定\",url: \"system/MCI061225S07\"},{name:\"系統功能管理\",url: \"system/MCI061219S05\"},{name:\"批次作業管理\",url: \"system/MCI061321S11\"}]}]"
		 );
	}

	
}
