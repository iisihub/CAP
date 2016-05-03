package com.iisigroup.cap.base.handler;

import org.springframework.stereotype.Controller;

import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.component.Result;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.mvc.i18n.MessageBundleScriptCreator;

/**
 * <pre>
 * base Handler
 * </pre>
 * 
 * @since 2011/11/28
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2011/11/28,rodeschen,new
 *          <li>2012/8/23,RodesChen,add default locale
 *          </ul>
 */
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
    public Result fileSuccess(Request params) {
        return new AjaxFormResult();
    }

    @HandlerType(HandlerTypeEnum.FORM)
    public Result queryJsI18N(Request request) {
        String result = MessageBundleScriptCreator.generateJson(request.get("f").replaceAll("/?webroot/page", ""));
        return new AjaxFormResult(result);
    }

}
