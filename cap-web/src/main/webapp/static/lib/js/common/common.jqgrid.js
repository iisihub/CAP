/**
 * override grid
 */
(function($) {

  $.extend($.fn, {
    /**
     * 取得目前所選取資料行資料
     */
    getSelRowDatas : function(col) {
      var tGrid = $(this);
      if (tGrid.jqGrid('getGridParam', 'multiselect')) {
        var sels = tGrid.jqGrid('getGridParam', 'selarrrow');
        var res = [];
        for (var i = 0; i < sels.length; i++) {
          col ? res.push(tGrid.getCell(sels[i], col)) : res.push(tGrid.getRowData(sels[i]));
        }
        return res.length ? res : undefined;
      } else {
        var selrow = tGrid.jqGrid('getGridParam', 'selrow');
        return selrow ? tGrid.getRowData(selrow) : undefined;
      }
    },
    /**
     * 將GridData轉換為Array<JSON>值
     * @param {boolean} stringify
     */
    serializeGridData : function(stringify) {
      var data = [];
      if ($(this).attr('role') == 'grid') {
        var tGrid = $(this);
        tGrid.find('tr[id]').each(function() {
          data.push($.extend(tGrid.getRowData($(this).attr('id')), {
            rowId : $(this).attr('id')
          }));
        });
      }
      return stringify ? JSON.stringify(data) : data;
    },
    /**
     * add data to grid by Array[json,json,....] or Array[array,array,....]
     * @param {Object} datas
     */
    addGridData : function(datas) {
      var $this = $(this), ids = $this.jqGrid("getGridParam", "colIds");

      function _convertJson(d) {
        var td = {};
        for ( var i in ids) {
          td[ids[i]] = d[i++];
        }
        return td;
      }

      if (datas instanceof Array) {
        for ( var data in datas) {
          var _data = (datas[data] instanceof Array) ? _convertJson(datas[data]) : datas[data], rowId = _data[$this[0].p.colKey];
          var _new = !$this[0].rows.namedItem(rowId);
          $this[_new ? "addRowData" : "setRowData"](rowId, _data);
        }
      }
      return this;

    },
    /**
     * 刪除所選 row data
     */
    removeSelected : function() {
      return this.removeGridData(this.jqGrid('getGridParam', 'multiselect') ? this.jqGrid('getGridParam', 'selarrrow') : this.jqGrid('getGridParam', 'selrow'));
    },

    /**
     * 刪除row data by Array[id1,id2] or id
     * @param {Object} array or string - ids
     */
    removeGridData : function(ids) {
      ids = (typeof ids === 'string') ? [ ids ] : [].concat(ids);
      for (i in ids) {
        this.delRowData(ids[i]);
      }
      return this;
    },
    /**
     * 自動設定寬度
     * @param {integer} maxWidth 寬度
     * @param {boolean} fitColumn 是否自動調整欄寬
     */
    iGridFitSize : function(maxWidth, fitColumn) {
      var self = this.closest(".ui-jqgrid"), $this = $(this);
      if (!$this.is(":visible"))
        return;
      if (typeof maxWidth == 'boolean') {
        maxWidth = 0;
        // fitColumn = maxWidth;
      }
      //fitColumn = !!fitColumn;
      $this.each(function() {
        if (this.p.autowidth) {
          maxWidth = maxWidth || self.parent().width();
          maxWidth = (maxWidth > 960) ? 960 : maxWidth;
        } else {
          maxWidth = maxWidth || this.p.freezeWidth;
        }
        $this.setGridWidth((maxWidth * 98) / 100, fitColumn == undefined ? this.p.forceFit : fitColumn);
        // ? this.p.forceFit : !(self.width() > maxWidth)); //);
      });
    },
    /**
     * Grid hide (extend jQuery hide)
     * @param {integer} speed
     * @param {function} callback
     */
    iGridHide : function(speed, callback) {
      $("#gbox_" + $(this).attr("id")).hide(speed, callback);
      return $(this);
    },
    /**
     * Gird show (extend jQuery show)
     * @param {integer} speed
     * @param {function} callback
     */
    iGridShow : function(speed, callback) {
      $("#gbox_" + $(this).attr("id")).show(speed, callback);
      return $(this);
    }
  });

  //    $.extend($.jgrid.defaults, {
  //        rowNum: 50,
  //        //	scroll: 1,
  //        hidegrid: false,
  //        datatype: "",
  //        height: 100,
  //        rownumbers: true,
  //        mtype: 'POST',
  //        autowidth: true,
  //        forceFit: true
  //    });
  var _jqGrid = $.fn.jqGrid;
  $.fn.jqGrid = function() {
    if (!arguments.length) {
      alert("grid argument error");
      return this;
    }

    if ((this.is("div") || !this.is("[role=grid]")) && typeof arguments[0] === 'object') {
      var url = arguments[0].url;
      //default settings
      var needPager = !(arguments[0].pager === false);
      var s = $.extend({}, {
        ajaxGridOptions : {// ajax option
          global : false
        },
        forceFit : true,
        url : '',
        mtype : 'POST',
        rowNum : (needPager == false) ? 1000 : Properties.Grid.rowNum,
        rowList : Properties.Grid.rowList,
        multiselect : false,
        viewrecords : true,
        pgbuttons : needPager,
        pginput : needPager,
        loadonce : false,
        autowidth : true,
        localFirst : false,
        gridview : true
      }, arguments[0]);
      //  console.debug(s);
      var id = this.attr("id");
      this.append($("<table />", {
        id : id
      })).addClass("r-grid").removeAttr("id");
      // add pager
      // arguments[0].pager &&
      this.append($("<div />", {
        id : id + "-pager"
      }));
      $.extend(s, {
        pager : id + "-pager",
        hidegrid : false,
        datatype : (!s.localFirst && url) ? 'json' : 'local',
        url : (!s.localFirst && url) ? url : ''
      });

      //add header
      var _colNames = s.colNames || [];
      s.colNames = [];
      s.colIds = [];
      //bind colKey
      s.colKey = undefined;
      for ( var col in s.colModel) {
        s.colNames.push(_colNames[col] || s.colModel[col].header || s.colModel[col].name);
        s.colIds.push(s.colModel[col].name);
        (s.colModel[col].key == true) && !s.colKey && (s.colKey = (s.colModel[col].id || s.colModel[col].name));

      }
      // add columns info
      s = $.extend({}, s, {
        postData : $.extend(s.postData || {}, {
          _columnParam : JSON.stringify(s.colModel, null),
          groupCloumn : JSON.stringify(s.groupingView && s.groupingView.groupField || [], null),
          mtype : "post"
        })
      });

      //            console.debug(s)
      var resGrid = _jqGrid.call(this.is("table") ? this : this.find("table"), s);
      resGrid.navGrid("#" + id + "-pager", {
        del : false,
        add : false,
        edit : false,
        search : false
      });

      // add click action
      resGrid.delegate("a[role=gridcellclick]", 'click', function(event) {
        var $this = $(this), id = $(this).attr("idname");
        var parms = s.colModel;
        for ( var op in parms) {
          if (parms[op].name == id) {
            parms[op].onclick && parms[op].onclick.call(this, $(this).attr("cellvalue"), parms[op], resGrid.jqGrid("getRowData", $(this).attr("rowid")), event);
          }
        }
      }).delegate("a[role=gridcelldownload]", 'click', function(event) {
        var $this = $(this);
        CommonAPI.formSubmit({
          url : 'file',
          data : {
            id : $(this).attr("cellvalue")
          },
          target : "_blank"
        });
      });

      s.localFirst && resGrid.setGridParam({
        datatype : url ? 'json' : 'local',
        url : url
      });

      //set cust properties
      resGrid.each(function() {
        this.p.colIds = s.colIds;
      });

      return resGrid;
    }
    //
    return _jqGrid.apply(this.is("table") ? $(this) : $(this.find("table")), arguments);
  };
  $.extend($.fn.jqGrid, _jqGrid);

  //add jqGrid foramter
  $.extend($.fn.fmatter, {
    click : (function() {
      var _click = function(cellvalue, options, rowdata) {
        return "<a href=\"#\" role=\"gridcellclick\" cellvalue=\"" + cellvalue + "\" idname=\"" + options.colModel.name + "\" rowid=\"" + options.rowId + "\">" + cellvalue + "</a>";
      };

      _click.unformat = function(cellvalue, options) {
        return cellvalue;
      };
      return _click;
    })(),

    fileDownload : (function() {
      var _download = function(cellvalue, options, rowdata) {
        return "<a href=\"#\" role=\"gridcelldownload\" cellvalue=\"" + cellvalue + "\" idname=\"" + options.colModel.name + "\" rowid=\"" + options.rowId + "\">"
            + (i18n && i18n.def.download || "下載") + "</a>";
      };

      _download.unformat = function(cellvalue, options) {
        return cellvalue;
      };
      return _download;
    })()
  });
})(jQuery);
