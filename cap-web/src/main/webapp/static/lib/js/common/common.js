;
$.holdReady(true);
(function(_jQuery, window) {
    _jQuery.browser.msie7 = !!(_jQuery.browser.msie && parseInt(_jQuery.browser.version, 10) < 8);
    _jQuery.ajaxSettings.traditional = true;
    _jQuery.ajaxSetup({
        jsonp : null,
        jsonpCallback : null,
        cache : false,
        dataType : 'json',
        type : "POST",
        data : {
            _isAjax : true
        },
        timeout : Properties.ajaxTimeOut
    });

    _jQuery.datepicker.setDefaults({
        dateFormat : 'yy-mm-dd',
        buttonImageOnly : true,
        showButtonPanel : true,
        changeMonth : true,
        changeYear : true,
        buttonImage : baseUrl + '/images/icon_date.png',
        showOn : 'both'
    });

    $.extend(window, {
        router : {
            set : function(settings) {
                if (settings) {
                    Backbone.history && Backbone.history.stop();
                    var AppRouter = Backbone.Router.extend(settings);
                    window._router = new AppRouter;
                    window._router.on('all', function() {
                        router.params = {};
                        if (router._params) {
                            router.params = router._params;
                        }
                        router._params = {};
                    });
                    Backbone.history.start();
                }
            },
            to : function(path, params) {
                router._params = params;
                if (path && window._router)
                    window._router.navigate(path, {
                        trigger : true
                    });
                else
                    throw "no router";
        },
            params : {}
        },

        url : function(path) {
            return Properties.contextName + path;
        }
    });
    // i18n plugin
    (function($) {
        var s = {
            url : url("i18njs")
        };
        window['i18n'] = {
            keys : [],
            load : function(f, st) {
                return $.ajax($.extend({
                    async : st && st.async || false,
                    cache : false,
                    dataType : 'json',
                    data : {
                        f : f,
                        _ : Math.random()
                    },
                    success : function(res) {
                        i18n.set(f.match("\\w+$")[0], res);
                        // i18n.set(f, res);
                    }
                }, s));
            },
            set : function(key, jsonValue) {
                $.extend(window['i18n'][key] = (function(value) {
                    return function(key, values) {
                        var msg = value[key];
                        msg && values && $.each(values, function(i, v) {
                            msg = msg.replace(new RegExp("\\{" + i + "\\}", "g"), v);
                        });
                        return msg;
                    };
                })(jsonValue), jsonValue);
                i18n.keys.push(key);
            },

            setup : function(settings) {
                s = $.extend(true, s, settings);
            }
        };
        // load default i18n Data
    })(_jQuery);

    // 所有動作均等待i18n 完成後再動作
    window.i18n.load("def").done(function() {
        // common js 初始化開始
        (function($) {
            // global function
            $.extend(window, {
                // logger
                logDebug : function() {
                    if (window.console) {
                        console.log(arguments);
                    }
                },

                // windows close confirm
                closeConfirm : Properties.window.closeConfirm,
                closeWindowMsg : Properties.window.closeWindowMsg,
                pageChangeMsg : false,
                setCloseWindowMsg : function(msg) {
                    this.closeWindowMsg = msg;
                },
                setCloseConfirm : function(f) {
                    window.closeConfirm = f;
                },
                getCloseConfirm : function() {
                    return window.closeConfirm;
                },
                onbeforeunload : function() {
                    if (getCloseConfirm())
                        return this.closeWindowMsg;
                },
                // 關閉視窗或重新整理後的動作
                onunload : Properties.window.onunload,
                realclosefunc : window.close,
                close : function() {
                    window.closeConfirm = false;
                    if ($.browser.msie) {
                        var win = window.open("", "_top", "", "true");
                        win.opener = true;
                        win.realclosefunc();
                    }
                    window.realclosefunc();
                },
                setPageChangeMsg : function(message) {
                    window.pageChangeMsg = message;
                },
                getPageChangeMsg : function() {
                    return window.pageChangeMsg;
                },

                // error function
                checkFormErrorAndRequired : function(form) {
                    if (form.find(".data-error,.item-data-error").size()) {
                        return false;
                    }
                    if (!form.valid()) {
                        return false;
                    }
                    return true;
                },
                errorCheck : (function() {
                    var _errorCheck = function(xhr, action) {
                        var json, res = true;
                        try {
                            json = JSON.parse(xhr.responseText);
                        } catch (e) {
                            // logDebug("ajaxError",
                            // e);
                            json = {};
                        }
                        // ilog.debug(json);
                        for (var rule in errorCheck.rule) {
                            res && json[rule] && ( res = errorCheck.rule[rule](xhr, action, json));
                        }

                        if (res && xhr.status && xhr.status != '200' || xhr.status == 0) {
                            // ilog.server("http
                            // error code: 「" +
                            // xhr.status +
                            // "」");
                            return false;
                        }
                        return res;
                    };

                    _errorCheck.rule = {
                        AJAX_CLOSE_PAGE_HANDLER_EXCEPTION : function(xhr, action, json) {
                            // ilog.debug(json.AJAX_CLOSE_PAGE_HANDLER_EXCEPTION);
                            // ilog.debug(encodeURIComponent(json.AJAX_CLOSE_PAGE_HANDLER_EXCEPTION));
                            API.showErrorMessage(json.AJAX_CLOSE_PAGE_HANDLER_EXCEPTION, function() {
                                window.location = window.location.href.replace(/#$/, '');
                                window.close();
                            });
                            // API.loadPage("../error/errormsg?errorMsg="
                            // +
                            // encodeURIComponent(encodeURIComponent(json.AJAX_CLOSE_PAGE_HANDLER_EXCEPTION)),
                            // $("#" +
                            // Properties.innerPageFrameId));
                            return false;
                        },
                        AJAX_MESSAGE_HANDLER_EXCEPTION : function(xhr, action, json) {
                            // ilog.debug(json.AJAX_MESSAGE_HANDLER_EXCEPTION);
                            // CommonAPI.showPopMessage(json.AJAX_MESSAGE_HANDLER_EXCEPTION,
                            // action
                            // || undefined);
                            API.showErrorMessage(json.AJAX_MESSAGE_HANDLER_EXCEPTION);
                            return false;
                        },
                        AJAX_HANDLER_EXCEPTION : function(xhr, action, json) {
                            try {
                                ilog.debug(xhr.status + " : " + xhr.statusText + ", " + json.AJAX_HANDLER_EXCEPTION);
                            } catch (e) {
                            }
                            API.showErrorMessage(xhr.status + " : " + xhr.statusText + ", " + json.AJAX_HANDLER_EXCEPTION);
                            // ilog.server(json.AJAX_HANDLER_EXCEPTION);
                            return false;
                        },
                        AJAX_HANDLER_TIMEOUT : function(xhr, action, json) {
                            // ilog.server(json.AJAX_HANDLER_TIMEOUT);
                            window.setCloseConfirm(false);
                            alert(i18n.def.sessionTimeout);
                            window.location = window.location.href.replace(/#$/, '');
                            return false;
                        },
                        AJAX_SESSION_EXPIRE_EXCEPTION : function(xhr, action, json) {
                            window.setCloseConfirm(false);
                            API.showErrorMessage(json.AJAX_SESSION_EXPIRE_EXCEPTION, function() {
                                window.location = window.location.href.replace(/#$/, '');
                            });
                            return false;
                        }
                    };

                    return _errorCheck;
                })(),

                getErrorMessage : function(xhr) {
                    var json;
                    try {
                        json = JSON.parse(xhr.responseText);
                    } catch (e) {
                        logDebug("ajaxError", e);
                        json = {};
                    }
                    // ilog.debug(json);
                    for (var rule in errorCheck.rule) {
                        if (json[rule]) {
                            return json[rule];
                        }
                    }

                    if (res && xhr.status && xhr.status != '200') {
                        // ilog.server("http
                        // error code: 「" +
                        // xhr.status + "」");
                        return "connect error";
                    }
                    return "";
                },

                CommonAPI : {
                    /**
                     * 判斷是否為 JSON Object
                     */
                    isJSON : function(obj) {
                        return typeof obj == "object" && obj.constructor == Object;
                    },
                    /**
                     * 產生對話框
                     *
                     * @param {Object}
                     *            settings
                     * @param {String}
                     *            action
                     */
                    _showConfirmMessage : function(settings, action) {
                        settings = settings || {};
                        var dialogId = settings.id || "iConfirmDialog";
                        if (action && action === 'close') {
                            $("#" + settings).dialog('close');
                        } else if (settings === 'close') {
                            $('#' + dialogId).dialog('close');
                        } else {
                            var s = $.extend({
                                title : i18n.def.confirmTitle,
                                closeName : i18n.def.cancel,
                                closeBtnAction : null

                            }, settings);
                            var cDialog = $('#' + s.id);
                            cDialog = ((cDialog.size()) ? cDialog : $("<div style='iConfirmDialog' id='" + dialogId + "' title='" + s.title + "'><span id='" + dialogId + "Message' style='max-width:600px;display:block'>" + s.message + "</span></div>").appendTo("body"));
                            var defaultButton = {};
                            defaultButton[s.closeName] = function() {
                                cDialog.dialog('close');
                            };
                            var tmpClose = s.close || $.noop;
                            delete s['close'];
                            cDialog.dialog($.extend({
                                bgiframe : false,
                                autoOpen : false,
                                modal : true,
                                maxWidth : $.browser.msie7 ? 600 : null
                            }, $.extend(s, {
                                close : function() {
                                    tmpClose();
                                    cDialog.dialog('destroy');
                                }
                            }), {
                                buttons : $.extend(s.buttons, s.noClose === true && {} || defaultButton)
                            }));
                            cDialog.dialog('open');
                            $.browser.msie7 && cDialog.dialog('option', 'width', cDialog.find('#' + dialogId + 'Message').width());
                            cDialog.dialog("option", "position", 'center');
                            return cDialog;
                        }
                    },
                    showConfirmMessage : function(title, message, action, cls) {
                        var randomID = "sysCMessage" + parseInt(Math.random() * 1000, 10);
                        action = $.isFunction(message) ? message : action;
                        var closeBtn = {};
                        var dfd = $.Deferred();
                        dfd.done(function() {
                            $("#" + randomID).remove();
                        });
                        action && dfd.done(action);
                        closeBtn[i18n && i18n.def && i18n.def.sure || "Yes"] = function() {
                            dfd.resolve(true);
                        };
                        closeBtn[i18n && i18n.def && i18n.def.cancel || "cancel"] = function() {
                            dfd.resolve(false);
                        };

                        return CommonAPI._showConfirmMessage({
                            dialogClass : cls || 'defDialogCss',
                            id : randomID,
                            closeName : i18n.def.close,
                            title : message && !$.isFunction(message) ? title : i18n.def.confirmTitle,
                            message : message && !$.isFunction(message) ? message : title,
                            // buttons:
                            // closeBtn,
                            buttons : closeBtn,
                            noClose : true
                        });

                    },
                    /**
                     * 產生提示對話框
                     *
                     * @param {String}
                     *            title title
                     * @param {Object}
                     *            message
                     *            message
                     * @param {Object}
                     *            action
                     *            關閉對話框後動作
                     */
                    showPopMessage : function(title, message, action, cls) {
                        var randomID = "sysMessage" + parseInt(Math.random() * 1000, 10);
                        // var closeBtn = {};
                        // closeBtn[i18n.def.close]
                        // = function(){
                        // CommonAPI.iConfirmDialog(randomID,
                        // 'close');
                        // };

                        return CommonAPI._showConfirmMessage({
                            dialogClass : cls || 'defDialogCss',
                            id : randomID,
                            closeName : i18n.def.close,
                            title : message && !$.isFunction(message) ? title : i18n.def.confirmTitle,
                            message : message && !$.isFunction(message) ? message : title,
                            // buttons:
                            // closeBtn,
                            close : function() {
                                $("#" + randomID).remove();
                                action && action();
                                $.isFunction(message || "") && message();
                            }
                        });
                    },

                    /**
                     * 產生提示對話框(預設與showPopMessage同
                     * 提供給予各專案replace使用)
                     *
                     * @param {String}
                     *            title title
                     * @param {Object}
                     *            message
                     *            message
                     * @param {Object}
                     *            action
                     *            關閉對話框後動作
                     */
                    showMessage : function(title, message, action) {
                        return API.showPopMessage(title, message, action);
                    },

                    /**
                     * 產生提示對話框(預設與showPopMessage同
                     * 提供給予各專案replace使用)
                     *
                     * @param {String}
                     *            title title
                     * @param {Object}
                     *            message
                     *            message
                     * @param {Object}
                     *            action
                     *            關閉對話框後動作
                     */
                    showErrorMessage : function(title, message, action) {
                        return API.showPopMessage(title, message, action, "xxxxxxx");
                    },

                    /**
                     * get Today(yyyy-MM-dd)
                     */
                    getToday : function() {
                        var tDate = new Date();
                        return tDate.getFullYear() + "-" + (tDate.getMonth() < 9 ? "0" : "") + (tDate.getMonth() + 1) + "-" + (tDate.getDate() < 10 ? "0" : "") + tDate.getDate();

                    },

                    /**
                     * ajax
                     * 動作完成後錯誤訊息顯示方式(預設與showPopMessage同
                     * 提供給予各專案replace使用)
                     *
                     * @param {String}
                     *            msg
                     */
                    ajaxErrorMessage : function(msg) {
                        CommonAPI.showPopMessage(msg);
                    },

                    /**
                     * ajax
                     * 動作完成後通知訊息顯示方式(預設與showPopMessage同
                     * 提供給予各專案replace使用)
                     *
                     * @param {String}
                     *            msg
                     */
                    ajaxNotifyMessage : function(msg) {
                        CommonAPI.showPopMessage(msg);
                    },

                    /**
                     * 清除訊息
                     */
                    clearMessage : function() {

                    },

                    /**
                     * 補滿字串
                     *
                     * @param {string}
                     *            data 轉入資料
                     * @param {integer}
                     *            length 長度
                     * @param {boolean}
                     *            rightAlign
                     *            是否補字串後方
                     * @param {char}
                     *            ch 補足字元
                     */
                    fillString : function(data, length, rightAlign, ch) {
                        var inlength = data.length;
                        if (inlength >= length)
                            return data;
                        for (var i = 0; i < (length - inlength); i++) {
                            data = (!!rightAlign ? (data + ch || "0") : ((ch || "0") + data));
                        }
                        return data;
                    },
                    /**
                     *
                     * @param {String}
                     *            id
                     * @param {String}
                     *            action
                     */
                    triggerOpener : function(id, action) {
                        id = id || 'gridview';
                        action = action || 'reloadGrid';
                        try {
                            window.opener.$("#" + id).trigger(action);
                        } catch (e) {
                            // ilog.debug(e);
                        }
                    },
                    /**
                     * 建立i18n or key為變數之 JSON
                     *
                     * @param {Object}
                     *            array
                     */
                    createJSON : function(array) {
                        var json = {};
                        for (var data in array) {
                            json[array[data].key] = array[data].value;
                        }
                        return json;
                    },
                    loadPage : function(href, fn) {
                        $.blockUI.showBG = true;
                        $.startBlockUI && $.startBlockUI();
                        var section = $("article");
                        section.animate({
                            opacity : 0.01
                        }, 500, (function(loadHref) {
                            return function() {
                                section.html("404");
                                section.load(loadHref, function() {
                                    section.animate({
                                        opacity : 1
                                    }, 800);
                                    fn && fn();
                                });
                                $.blockUI.showBG = false;
                            };
                        })(href));
                    },
                    formSubmit : function(settings) {
                        settings = $.extend(true, {
                            data : {},
                            type : 'POST',
                            url : "",
                            target : "_self"
                        }, settings || {});
                        var obj = $('<form />');
                        $('body').append(obj);
                        obj.attr({
                            css : {
                                display : "none"
                            },
                            action : settings.url,
                            target : settings.target,
                            method : settings.type
                        });
                        for (var key in settings.data) {
                            if (settings.data[key]) {
                                if (settings.data[key].constructor == Array) {
                                    for (var key2 in settings.data[key]) {
                                        obj.append('<input type="text" class="hide" name="' + key + '" value=\'' + settings.data[key][key2] + '\' />');
                                    }
                                } else {
                                    obj.append('<input type="text" class="hide" name="' + key + '" value=\'' + settings.data[key] + '\' />');
                                }
                            }
                        }
                        $('body').append(obj);
                        obj.submit();
                        obj.empty().remove();
                    },
                    /**
                     * 於後端取得下拉選單資料
                     *
                     * @param {Array ||
                     *            String}
                     *            updatekeys
                     *            reutrn {JSON}
                     *            comboList
                     */
                    loadCombos : function(updateKeys, comboaction) {
                        if (updateKeys === "")
                            return {};
                        var nkeys = ( typeof updateKeys === 'string') ? [updateKeys] : updateKeys, ukeys = [];
                        for (var key in nkeys) {
                            if (!icombos[nkeys[key]])
                                ukeys.push(nkeys[key]);
                        }
                        (ukeys.length || (comboaction && comboaction.length)) && (function() {
                            $.ajax({
                                type : 'post',
                                async : false,
                                url : Properties.ComboBoxHandler,
                                data : {
                                    keys : ukeys || [],
                                    akeys : comboaction || []
                                },
                                success : function(json) {
                                    $.extend(icombos, json);
                                }
                            });
                        })();

                        return icombos;
                    }
                }
            });

            // add String method
            $.extend(String.prototype, {
                // 計算有幾個全型字、中文字... 或英數字混雜
                countLength : function(type) {
                    var c = this.match(/[^ -~]/g);
                    if (type == 'B') {// big5
                        // +2
                        return this.length + ( c ? c.length : 0);
                    } else {// 預設UTF-8 +3
                        return this.length + ( c ? c.length * 2 : 0);
                    }
                },

                /* 半型字符範圍：33-126;全型字符範圍：65281-65374:對應關係是相差：65248;全型空格：12288;半型空格：32* */
                // 轉全型
                toFull : function() {
                    var result = "";
                    var str = String.trim(this);
                    for (var i = 0; i < str.length; i++) {
                        var tmp;
                        var c = str.charCodeAt(i);
                        tmp = (c <= 126 && c >= 33) && c + 65248 || (c == 32) && 12288 || c;
                        result += String.fromCharCode(tmp);
                    }
                    return result;
                },
                // 轉半型
                toHalf : function() {
                    var result = "";
                    var str = String.trim(this);
                    for (var i = 0; i < str.length; i++) {
                        var tmp;
                        var c = str.charCodeAt(i);
                        tmp = (c <= 65374 && c >= 65281) && c - 65248 || (c == 12288) && 32 || c;
                        result += String.fromCharCode(tmp);
                    }
                    return result;
                }
            });

            // add jQuery static method
            $.extend({
                emptyFunction : function() {
                    return true;
                },
                emptyJSON : {},
                __ajax : $.ajax,
                ajax : function(s) {
                    s = $.extend({
                        handler : "",
                        action : "",
                        formId : "",
                        noHide : false,
                        target : null
                    }, s);

                    if (s.formId) {
                        var form = $("#" + s.formId);
                        // for cbcl start
                        if (!checkFormErrorAndRequired(form)) {
                            return false;
                        } else
                            $.extend(s.data, form.serializeData(s.noHide), s.data);
                    }
                    if (s.url.match("^webroot")) {
                        s.url = s.url.replace("webroot/", Properties.contextName);
                    }
                    // ---------------------------------------------------------------------------------
                    // 移除page 以防server side 無法抓取正確值
                    // if(window.responseJSON) delete
                    // responseJSON.page;
                    return $.__ajax($.extend({
                        dataType : "json",
                        cache : false,
                        type : 'post'
                    }, s, {
                        success : function(data, status) {
                            // 如有錯誤通知訊息則顯示於畫面上
                            // ilog.debug(data);
                            if (data.ERROR_NOTIFY_MESSAGE) {
                                API.ajaxErrorMessage(data.ERROR_NOTIFY_MESSAGE);
                            }
                            // 如有通知訊息則顯示於畫面上
                            else if (data.NOTIFY_MESSAGE) {
                                API.ajaxNotifyMessage(data.NOTIFY_MESSAGE);
                            }
                            s.success && s.success(data, status);
                            data.ERROR_NOTIFY_MESSAGE && s.successError && s.successError(data, status);
                        },
                        error : function(xhr, status, e) {
                            s.error && s.error(xhr, status, e);

                            var statusText = "";
                            try {
                                statusText = xhr.statusText;
                            } catch (e) {
                            }
                            if (statusText == 'timeout') {
                                // request
                                // timeout
                                API.showErrorMessage(i18n.def.timeout);
                            } else if (!xhr.status && statusText) {
                                API.showErrorMessage(i18n.def.connectError + "-「" + statusText + "」");
                            } else if (xhr.responseText) {
                                errorCheck(xhr);
                            } else if (xhr.status == 0 || xhr.status && xhr.status != '200') {
                                API.showErrorMessage("http error code: 「" + xhr.status + "」");
                            }
                        },
                        data : $.extend({}, window.responseJSON ? responseJSON : {}, {
                            _pa : s.handler || '',
                            formAction : s.action || ''
                        }, s.data)
                    }));
                },

                // 檔案下載動作
                capFileDownload : function(s) {
                    CommonAPI.formSubmit({
                        url : s.url,
                        type : 'post',
                        target : "_blank",
                        encode : true,
                        data : s.data || {}
                    });
                }
            });

            // 設定blockUI
            if ($.blockUI) {
                $.blockUI.showBG = true;
                $.extend({
                    startBlockUI : function(event, xhr) {
                        $.blockUI({
                            fadeIn : 0,
                            fadeOut : 0,
                            message : i18n.def.loading + '   <img src="' + url("static/images/ajax-loader.gif") + '" style="width: 16px;hight:11px;"/>',
                            css : {
                                'z-index' : 10010,
                                top : '0',
                                left : '40%',
                                backgroundColor : '#E0ECFF',
                                border : '#000 1px solid',
                                '-webkit-border-radius' : '5px',
                                '-moz-border-radius' : '5px',
                                // opacity: .85,
                                'font-size' : '0.8em',
                                padding : '2px',
                                fontWeight : 'bolder',
                                height : '18px',
                                width : '20%',
                                color : '#000',
                                cursor : 'default'
                            },
                            overlayCSS : {
                                'z-index' : 10010,
                                backgroundColor : '#CCC',
                                opacity : $.blockUI.showBG ? 0.3 : 0,
                                cursor : 'default'
                            }
                        });
                    }
                });
                $(document).bind("ajaxStart", $.startBlockUI);
                $(document).bind("ajaxStop", $.unblockUI);
            }

            // 檔案上傳動作
            if ($.ajaxFileUpload) {
                $.extend({
                    capFileUpload : function(setting) {
                        var s = $.extend({
                            uploadMsg : i18n.def.fileUploading,
                            successMsg : i18n.def.fileUploadSuccess
                        }, setting, {
                            url : setting.url + (/[?]/.test(setting.url) ? "&" : "?") + ("limitSize=" + (setting.limitSize || 3145728)) + (setting.fileEncoding && ("&fileEncoding=" + setting.fileEncoding) || "")
                        });
                        var telm = $("#" + s.fileElementId), val = telm.val();

                        if (!val.length) {
                            CommonAPI.showErrorMessage(i18n.def.fileSelect);
                            return;
                        }
                        // 檢核副檔名
                        if (s.fileCheck) {
                            var regs = "";
                            $(s.fileCheck).each(function(index, value) {
                                regs += (value + "|");
                            });

                            regs = regs.replace(/\|$/, "");
                            if (!((new RegExp("(" + regs + ")$", "i")).test(val))) {
                                CommonAPI.showErrorMessage(i18n.def.fileSelError + "  (" + regs + ")");
                                return;
                            }
                        }
                        var uploadMsg = CommonAPI.showMessage(s.uploadMsg);
                        $.ajaxFileUpload($.extend({}, s, {
                            secureuri : false,
                            complete : function(xhr, status) {
                                uploadMsg.dialog('close');
                                try {
                                    var json = JSON.parse(xhr.responseText);
                                } catch (e) {
                                    logDebug("ajaxError", e);
                                    json = {};
                                }
                                errorCheck(xhr) && (function() {
                                    s.successMsg && CommonAPI.showMessage(s.successMsg);
                                    // 如有通知訊息則顯示於畫面上
                                    json.NOTIFY_MESSAGE && API.showMessage(json.NOTIFY_MESSAGE);
                                    s.success && s.success(json);
                                    json.ERROR_NOTIFY_MESSAGE && s.successError && s.successError(json, status);
                                    return true;
                                })() || s.error && s.error(xhr, status, json);
                                s.complete && s.complete(xhr, status, json);
                                $.post(Properties.fileUploadSuccessHandler);

                            },
                            error : function(data, status, e) {
                                $.isFunction(uploadMsg) && uploadMsg.dialog('close');
                                CommonAPI.showErrorMessage(i18n.def.fileUploadError);
                            },
                            data : $.extend(s.data || {}, {
                                iframe : true
                                // ie
                                // error
                                // access
                                // denied
                            })
                        }));

                    }
                });
            }

            // add jQuery prototype method
            $.fn.extend({
                // 增加val 行為
                __val : jQuery.fn.val,
                val : function(value) {
                    var res = (this.data("maskRule") && this.data("realValue")) ? this.data("realValue") : (this.is("span,div") ? this.text() : this.__val());
                    if (value != undefined) {
                        this.data("realValue", value)[(this
                        .is("span,div") ? "text"
                        : "__val")](value);
                        if (this.data("maskRule") && this.data("isChange") !== true) {
                            this.data("isChange", true).trigger("change").data("isChange", false).trigger("mask");
                        }
                        ;
                        res = this;
                    }
                    return res;
                },
                ____load : $.fn.load,
                load : function(url, params, callback) {
                    if ( typeof url !== "string" && this.___load) {
                        return this.___load.apply(this, arguments);
                    }

                    // Don't do a request if no elements
                    // are being requested
                    if (!this.length) {
                        return this;
                    }
                    if ($.isFunction(url)) {
                        return this;
                    }
                    var selector, type, response, self = this, off = url.indexOf(" ");

                    if (off >= 0) {
                        selector = url.slice(off, url.length);
                        url = url.slice(0, off);
                    }

                    // If it's a function
                    if ($.isFunction(params)) {

                        // We assume that it's the
                        // callback
                        callback = params;
                        params = undefined;

                        // Otherwise, build a param
                        // string
                    } else if (params && typeof params === "object") {
                        type = "POST";
                    }
                    var self = this;
                    // Request the remote document
                    $.ajax({
                        url : url,

                        // if "type"
                        // variable is
                        // undefined,
                        // then "GET"
                        // method will
                        // be used
                        type : type,
                        dataType : "html",
                        data : params,
                        context : self,
                        converters : {
                            "text html" : function(s) {
                                var t = s.match(/<title>(?!<>)(.*)<\/title>/);
                                t && t[1] && (document.title = Properties.title + ' - ' + t[1]);
                                return "<script type=\"text/javascript\">$(document).ready(function(){loadPageInit.call($(\"#" + self.attr("id") + "\"), true);})</script>" + s;
                            }
                        },
                        complete : function(jqXHR, status) {
                            if (callback) {
                                self.each(callback, response || [jqXHR.responseText, status, jqXHR]);
                            }
                        }
                    }).done(function(responseText) {

                        // Save response
                        // for use in
                        // complete
                        // callback
                        response = arguments;

                        // See if a
                        // selector was
                        // specified
                        self.html( selector ? // Create
                        // a
                        // dummy
                        // div
                        // to
                        // hold
                        // the
                        // results
                        $("<div>")
                        // inject
                        // the
                        // contents
                        // of
                        // the
                        // document
                        // in,
                        // removing
                        // the
                        // scripts
                        // to
                        // avoid
                        // any
                        // 'Permission
                        // Denied'
                        // errors
                        // in
                        // IE
                        .append(responseText.replace(rscript, ""))
                        // Locate
                        // the
                        // specified
                        // elements
                        .find(selector) : // If
                        // not,
                        // just
                        // inject
                        // the
                        // full
                        // result
                        responseText);

                    });

                    return this;
                },

                __dialog : $.fn.dialog,
                dialog : function(arg1, arg2, arg3) {
                    if ( typeof arg1 !== "string") {
                        var $this = this;
                        $this.find('form').each(function() {
                            // $(this).validate();
                            $(this).validationEngine('validate');
                        });
                        var _o = arg1 && arg1.open;
                        arg1 = $.extend({
                            dialogClass : this.attr("id") + "_-dialog",
                            bgiframe : true,
                            autoOpen : false,
                            modal : true,
                            maxWidth : 600,
                            // width:
                            // 'auto',
                            minWidth : 350
                            // minWidth: 350
                        }, arg1, {
                            open : function() {
                                _o && _o.apply(this, arguments);
                            }
                        });
                        var ndialog = this.__dialog(arg1, arg2, arg3);
                        var dialogs;
                        ( dialogs = $("." + this.attr("id") + "_-dialog")).each(function(index, element) {
                            ((dialogs.size() - 1) == index) ? ( ndialog = $(element)) : ($(element).empty().remove());
                        });
                        $("div[id='" + this.attr("id") + "'],span[id='" + this.attr("id") + "']").each(function() {
                            $(this).is(".ui-dialog-content") || $(this).empty().remove();
                        });
                        return ndialog.find('.ui-dialog-content');
                    }
                    return this.__dialog(arg1, arg2, arg3);
                },
                /**
                 * form reset
                 */
                reset : function() {
                    $(this).find("input:text,.field").filter(".field").val("").end().end().each(function() {
                        this.reset();
                    });
                    return this;
                },
                /**
                 * 將JSON內值放入 selector
                 * 所選之subitem(input,radio,checkbox,textarea,div,span)
                 *
                 * @param {JSON}
                 *            json
                 */
                injectData : function(rjson) {
                    var json = $.extend({}, rjson);
                    var obj = $(this);
                    $(["input", "select", "textarea", "span[id]", "div[id]"]).each(function(i, v) {
                        var _f = obj.find(v);
                        _f.each(function() {
                            var item = $(this);
                            var jid = item.attr("id");
                            if (json[jid]) {
                                try {
                                    var value = json[jid];
                                    value = (value == null ? "" : value);
                                    switch ((item
                                    .attr("type") || "")
                                    .toLowerCase()) {
                                        case "text":
                                        case "hidden":
                                        case "password":
                                            item.val(value).data("realData", value);
                                            break;
                                        case "radio":
                                            obj.find("input[name='" + jid + "']").attr('checked', false).filter("[value='" + json[jid] + "']").trigger('click').attr("checked", true);
                                            break;

                                        case "checkbox":
                                            if ($.isArray(json[jid])) {
                                                var _cbs = obj.find("input[name='" + jid + "']").attr('checked', false);
                                                for (var _i in json[jid]) {
                                                    _cbs.filter("[value='" + json[jid][_i] + "']").attr("checked", true).trigger('click').attr("checked", true);
                                                }
                                            } else {
                                                obj.find("input[name='" + jid + "']").attr('checked', false).filter("[value='" + json[jid] + "']").attr("checked", true).trigger('click').attr("checked", true);
                                            }
                                            break;
                                        default:
                                            var iTagName = item[0].nodeName.toLowerCase();
                                            if (iTagName == 'select') {
                                                if (item.attr('addNew') == 'true' && value) {
                                                    item.setOptions((function() {
                                                        var b = {};
                                                        b[value] = value;
                                                        return b;
                                                    })(), true);
                                                }
                                                if (item.attr('submitbytext') == 'true') {
                                                    item.find("option[showvalue='" + value + "']").attr("selected", true);
                                                } else {
                                                    item.val(value);
                                                }
                                            } else {
                                                if (iTagName.toLowerCase() == "form") {
                                                    item.setData(value);
                                                } else {
                                                    item[(iTagName
                                                    .match(/(textarea|div|span)/)) ? 'val'
                                                    : 'html'](value);
                                                }
                                            }
                                    }
                                } catch (e) {
                                    // ilog.debug(e);
                                }
                                delete json[jid];
                            }
                        });
                    });
                    for (var jid in json) {
                        var value = json[jid];
                        // 當整個html上無此欄位時,才自動產生隱藏欄位
                        try {
                            var hItem = $("#" + jid);
                            if (!hItem.size()) {
                                obj.append($("<input type='hidden' id='" + jid + "'" + " name='" + jid + "'" + " value='" + value + "'" + " />"));
                            } else {
                                switch ((hItem
                                .attr("type") || "")
                                .toLowerCase()) {
                                    case "text":
                                    case "hidden":
                                    case "password":
                                        hItem.val(value).data("realData", value);
                                        break;
                                    case "radio":
                                    case "checkbox":
                                        break;
                                    default:
                                        var iTagName = hItem[0].nodeName.toLowerCase();
                                        hItem[(iTagName
                                        .match(/(textarea|div|span|select)/)) ? 'val'
                                        : 'html'](value);
                                }
                            }
                        } catch (e2) {
                            // ilog.debug(e2);
                        }
                    }
                    return obj;
                },

                /**
                 * 將dom內之輸入欄位轉成Json
                 *
                 * @param {boolean}
                 *            noHide 無需Hidden 欄位 預設為
                 *            false (全取)
                 */
                serializeData : function(noHide) {
                    var result = {}, self = $(this);
                    $(["input", "select", "textarea", "span.field"]).each(function(i, v) {
                        self.find(v).filter(function() {
                            return !!!noHide || !$(this).is(":hidden");
                        }).each(function() {
                            var $this = $(this);
                            $this.each(function() {
                                switch (this.nodeName
                                .toLowerCase()) {
                                    case 'input':
                                        switch (this.type
                                        .toLowerCase()) {
                                            case "text":
                                            case "hidden":
                                            case "password":
                                                seValue(this.name, $this.val());
                                                break;
                                            case "radio":
                                            case "checkbox":
                                                !result[this.name] && (result[this.name] = "");
                                                this.checked && seValue(this.name, $this.val());
                                                break;
                                        }
                                        break;
                                    case 'textarea':
                                        var value = "";
                                        try {
                                            value = $this.val();
                                        } catch (e) {
                                            try {
                                                value = $this.html();
                                            } catch (e1) {
                                                $.log(e1);
                                            }
                                        }
                                        seValue(this.name, value);
                                        break;
                                    case 'select':
                                        var sThis = $(this);
                                        if (sThis.attr("submitByText") == 'true') {
                                            seValue(this.name, (sThis.find("option[value='" + $this.val() + "']").attr("showValue")) || "");
                                        } else {
                                            seValue(this.name, $this.val());
                                        }
                                        break;
                                    case "span":
                                        seValue($this.attr("id"), $.trim($this.val()));
                                }
                            });
                        });
                    });
                    return result;

                    function seValue(name, value) {
                        if (name) {
                            result[name] ? (result[name].constructor == Array ? result[name].push(value) : (function() {
                                var tmp = result[name];
                                result[name] = new Array();
                                result[name].push(tmp);
                                result[name].push(value);
                            })()) : result[name] = value;
                        }

                    }

                },
                /**
                 * 設定 Selector's subitem readonly 狀態
                 *
                 * @param {boolean}
                 *            b 預設為 true (readOnly)
                 * @param {String}
                 *            jquerySelector
                 */
                readOnlyChilds : function(b, excludeSelector) {
                    b = (b == undefined) ? true : b;
                    $(this).find("input,select,textarea,button").not(excludeSelector || "").each(function() {
                        $(this).readOnly(b);
                    });
                    return $(this);
                },
                /**
                 * 設定欄位Readonly 狀態
                 *
                 * @param {boolean}
                 *            f 預設為 true (readOnly)
                 */
                readOnly : function(b) {
                    b = (b == undefined) ? true : b;
                    var $this = $(this);
                    $this.each(function() {
                        switch (this.nodeName
                        .toLowerCase()) {
                            case 'input':
                                switch (this.type
                                .toLowerCase()) {
                                    case 'text':
                                        ($(this).is('.date') || $(this).is('.date2')) && ( b ? $(this).datepicker('destroy') : $(this).datepicker());
                                        this.readOnly = b;
                                        break;
                                    default:
                                        this.disabled = b;
                                }
                                break;
                            case 'textarea':
                                this.readOnly = b;
                                break;
                            case 'select':
                                this.disabled = b;
                        }
                        this.tabIndex = b ? -1 : "";
                    });
                    return this;
                },
                /**
                 * 動態新增Select 選單
                 *
                 * @param {JSON}
                 *            options
                 * @param {boolean}
                 *            append
                 */
                setOptions : function(options, append) {
                    return !this[0] ? $(this) : this[0].nodeName.toLowerCase() != 'select' ? $(this) : (function(o, a) {
                        var okey = "";
                        if ( typeof o === "string") {
                            okey = o;
                            o = CommonAPI
                            .loadCombos(o)[o];
                        }
                        var to = {}, s = $(this), defalutValue = s.attr("defaultValue") || "", ops = ""/*
                         * (s.attr("space") ==
                         * "true" &&
                         * (!s.find('option').size() ||
                         * !append)) ? "<option
                         * value=''></option>" : ""
                         */, type = s.attr("comboType");
                        if (append) {
                            o = $.extend(s.data('realOptions') || {}, o);
                            options && (
                            delete options[i18n.def.newData]);
                        } else {
                            s.empty();
                        }
                        for (var key in o || {}) {
                            ops += ("<option key='" + key + "' value='" + (type == '3' ? o[key] : key) + "' showValue='" + o[key] + "'>" + (function(k, v, t) {

                                switch (t) {
                                    case '1':
                                        to[k] = k;
                                        return k;
                                    case '2':
                                        to[k] = v;
                                        return v;
                                    case '3':
                                        to[v] = v;
                                        return v;
                                    default:
                                        to[k] = k + ' - ' + v;
                                        return k + ' - ' + v;
                                }
                            })(key, o[key], type) + "</option>");
                        }
                        if (s.attr("addNew") == 'true') {
                            !ops.match("'>" + i18n.def.newData + "</option>") && (ops += ("<option value='" + i18n.def.newData + "'>" + i18n.def.newData + "</option>"));
                            if (!s.data('bindChanged'))
                                s.bind('change', function() {
                                    var value = $(this).val();
                                    if (value == i18n.def.newData) {
                                        CommonAPI.includeID({
                                            needCancel : true,
                                            checkType : s.attr("addCheckType") || "",
                                            title : i18n.def.newData + (s.attr("addTitle") || i18n.def.selectOption),
                                            subtitle : s.attr("addTitle") || i18n.def.selectOption,
                                            buttonName : i18n.def.sure,
                                            buttonAction : function() {
                                                if ($("#searchForm").valid()) {
                                                    var options = s.data("viewOptions") || {};
                                                    options[$("#sseid").val()] = $("#sseid").val();
                                                    delete options[i18n.def.newData];
                                                    options[i18n.def.newData] = i18n.def.newData;
                                                    s.data("viewOptions", options).setOptions(options).val($("#sseid").val());
                                                    CommonAPI.includeID('close');
                                                }
                                            }
                                        });
                                    }
                                }).data('bindChanged', true);
                        }
                        return s.html( ops = ((s.attr("space") != undefined && s.attr("space") != 'false' ? ("<option value=''>" + (s.attr("space") == "true" ? i18n.def.comboSpace : s.attr("space")) + "</option>") : "") + ops)).val(defalutValue).data('realOptions', o || {}).data('viewOptions', to || {}).attr("list", okey || s.attr("list"));
                    }).call(this, options, append);
                },

                /**
                 * 移除options (多個 or 單一 選項)
                 *
                 * @param {Array ||
                 *            string} options
                 */
                removeOptions : function(options) {
                    return !this[0] ? $(this) : this[0].nodeName.toLowerCase() != 'select' ? $(this) : (function(o) {
                        if ( typeof o === "string") {
                            o = [o];
                        }
                        var $this = $(this);
                        var opts = $this.data('realOptions') || {};
                        $.each(o, function(i, e) {
                            delete opts[e];
                        });
                        $this.setOptions(opts, false);
                    }).call(this, options);
                },
                // ajax queue
                _ajaxQueueContent : [],
                _ajaxQueueStatus : false,
                ajaxQueue : function(s) {
                    if (s.constructor == Array) {
                        (function(tses) {
                            (function ajaxStart(ts) {
                                if (ts) {
                                    $.ajax($.extend({}, ts, {
                                        success : function(data, textStatus, XMLHttpRequest) {
                                            ts.success && ts.success(data, textStatus, XMLHttpRequest);
                                            ajaxStart(tses.shift());
                                        }
                                    }));
                                }
                            })(tses.shift());
                        })(s);
                    } else {
                        $._ajaxQueueContent.push(s);
                        if (!$._ajaxQueueStatus) {
                            (function ajaxStart(ts) {
                                if (ts) {
                                    $._ajaxQueueStatus = true;
                                    $.ajax($.extend({}, ts, {
                                        complete : function(xhr, status) {
                                            ts.complete && ts.complete(xhr, status);
                                            ajaxStart($._ajaxQueueContent.shift());
                                        }
                                    }));
                                } else {
                                    $._ajaxQueueStatus = false;
                                }
                            })($._ajaxQueueContent.shift());
                        }
                    }
                }
            });

            $.extend(window, {
                // 下拉選單暫存變數
                icombos : {},
                // 畫面初始化method
                loadPageInit : function(isSubPage) {
                    var $_this = $(this);
                    $_this.find("[commonitem],input[padding]").filter("[commonitem]").each(function() {
                        var $cthis = $(this), common = Properties.commonItem && Properties.commonItem[$cthis.attr("commonitem")];
                        if (!common)
                            return;
                        else {
                            if (common.valid) {
                                $cthis.bind("blur.comm", common.valid);
                            }
                            for (var attr in common) {
                                switch (attr) {
                                    case "class":
                                        $cthis.attr("class", $cthis.attr("class") + " " + common[attr]);
                                        break;
                                    case "css":
                                        $cthis.css(common[attr]);
                                        break;
                                    case "maxlength":
                                        $cthis.attr(attr) != -1 && $cthis.attr(attr, common[attr]);
                                        break;
                                    case "size":
                                        $cthis.attr(attr, common[attr]);
                                    case "valid":
                                        break;
                                    default:
                                        $cthis.attr(attr, $cthis.attr(attr) || common[attr]);
                                        break;
                                }
                            }
                        }
                        // 放入padding
                        // 功能
                    }).end().filter("input[padding]").each(function() {
                        $(this).bind("blur.fill", function() {
                            var $fthis = $(this);
                            if ($fthis.val().length) {
                                $fthis.val(API.fillString($fthis.val(), parseInt($fthis.attr("padding"), 10), $fthis.attr("paddingright") == "true", $fthis.attr("paddinchar") || "0"));
                            }
                        });
                    });

                    if (!isSubPage) {
                        if (/(home)$/i.test(location.pathname)) {
                            // 如為主頁面將window name
                            // 設為mainPage
                            window.name = "mainPage";
                        }

                        $(document).bind("ajaxStop", function() {
                            // $.unblockUI();
                        }).bind("ajaxComplete", function(event, xhr, settings) {
                        }).bind("ajaxSuccess", function(event, xhr) {
                        }).bind("ajaxError", function(event, xhr, ajaxOptions, thrownError) {
                        });
                    }
                    $_this.find(".tabs").tabs();
                    // 設定可輸欄位才可選日期
                    $_this.find(".date").filter(function() {
                        return !$(this).attr('readonly');
                    }).datepicker();
                    $_this.find("button").not(".def_btn").addClass("btn1").button();

                    $_this.find("form").each(function() {
                        $(this).validationEngine({
                            validationEventTrigger : 'blur',
                            scroll : false
                        });
                    });
                    var combos, combokeys = [], comboaction = [];
                    ( combos = $_this.find('select[comboKey],select[comboaction]')).each(function() {
                        var key = null;
                        ( key = $(this).attr("comboKey")) && combokeys.push(key);
                        ( key = $(this).attr("comboaction")) && comboaction.push(key);
                    });
                    API.loadCombos(combokeys, comboaction);
                    combos.each(function() {
                        var $cthis = $(this);
                        $cthis.setOptions(icombos[$cthis.attr("comboKey") || $cthis.attr("comboaction")], false);
                    });
                    combos = combokeys = null;
                }
            });
            /** valid */
            $.extend(window, {
                contCodeCheck : function(field, rules, i, options) {
                    field.val((field.val() || "").toUpperCase());
                    if (!/^UCN[0-9]{11}$/.test(field.val())) {
                        return i18n.def['valid.contcCodeNbr'];
                    }
                },
                betweenDate : function(field, rules, i, options) {
                    var st = $("#" + rules[i + 2]), et = $("#" + rules[i + 3]);
                    if (st.val() && et.val()) {
                        if (rules[i + 4] === '0' && !(et.val() >= st.val())) {
                            return i18n.def['valid.dateBetweenEq'];
                        } else if (rules[i + 4] === '1' && !(et.val() > st.val())) {
                            return i18n.def['valid.dateBetween'];
                        }
                    }
                },
                betweenAge : function(field, rules, i, options) {
                    var bd = $("#" + rules[i + 2]), sd = $("#" + rules[i + 3]);
                    if (bd.val() && sd.val()) {
                        if (sd.val() > bd.val()) {
                            return i18n.def['valid.age'];
                        }
                    }
                },
                chlNbr : function(field, rules, i, options) {
                    if (!/^[0-9]{6}$/.test(field.val())) {
                        return i18n.def['valid.chlNbr'];
                    }
                },
                sceneNbr : function(field, rules, i, options) {
                    if (!/^[0-9]{4}$/.test(field.val())) {
                        return i18n.def['valid.sceneNbr'];
                    }
                },
                maxUTF8 : function(field, rules, i, options) {
                    var val = field.val();
                    if (val) {
                        if (val.countLength() > parseInt(rules[i + 2], 10)) {
                            return i18n && i18n.def && i18n.def("valid.maxUTF8", [parseInt(rules[i + 2] / 3, 10), rules[i + 2]]);
                        }
                    }
                }
            });
            // APIS
            window.API = window.CommonAPI;

            // init
            $(document).ready(function() {
                loadPageInit.call(document);
                $("body").on("click", "a", function(e) {
                    if ($(this).attr('href').match("^#")) {
                        e.preventDefault();
                    }
                });
            });
            $.holdReady(false);
        })(_jQuery);
    });
})(jQuery, window);
