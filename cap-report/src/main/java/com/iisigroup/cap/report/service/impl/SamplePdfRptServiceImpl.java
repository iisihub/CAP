package com.iisigroup.cap.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.report.AbstractReportPdfService;
import com.iisigroup.cap.report.enums.ReportParamEnum;
import com.iisigroup.cap.utils.CapDate;
import com.itextpdf.text.pdf.PdfWriter;

@Scope("request")
@Service("samplePdfService")
public class SamplePdfRptServiceImpl extends AbstractReportPdfService {

	@Override
	public Map<String, Object> excute(IRequest request) {
		Map<String, Object> reportData = new HashMap<String, Object>();
		/* 建立資料模型 */
		reportData.put("userId", "userId");
		reportData.put("dataRange", "2014/01/01~2014/02/02");
		reportData.put("printDate", CapDate.getCurrentDate("yyyy-MM-dd"));
		reportData.put("printer", "printer");
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		int count = 1;
		while (count <= 10) {
			count++;
			Map<String, String> map = new HashMap<String, String>();
			map.put("userId", "userId" + count);
			map.put("ipAddress", "ipAddress" + count);
			map.put("funcName", "funcName" + count);
			map.put("actionName", "actionName" + count);
			map.put("execDate", CapDate.convertTimestampToString(
					CapDate.getCurrentTimestamp(), "yyyy-MM-dd HH:mm:ss"));
			list.add(map);
		}
		int totalPageNo = 1;
		if (!CollectionUtils.isEmpty(list)) {
			if (list.size() > 30) {
				int totalCount = list.size();
				totalCount -= 30;
				totalPageNo = totalCount / 35 + 2;
			} else {

			}
		}
		reportData.put("totalPageNo", String.valueOf(totalPageNo));
		reportData.put("mapList", list);

		// 加密密碼
		reportData.put(ReportParamEnum.encrypt.toString(),
				request.get("password"));

		return reportData;
	}

	@Override
	public String getReportDefinition() {
		return "report/samplePDF";
	}

	@Override
	protected int[] getAllowedPrivileges() {
		return new int[] { PdfWriter.ALLOW_PRINTING };
	}
}
