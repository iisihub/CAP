/* 
 * AbstractReportPdfService.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.report;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.pdf.PDFEncryption;
import org.xhtmlrenderer.resource.XMLResource;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.report.enums.FontTypeEnum;
import com.iisigroup.cap.report.enums.ReportParamEnum;
import com.iisigroup.cap.report.factory.ItextFontFactory;
import com.iisigroup.cap.service.AbstractService;
import com.iisigroup.cap.utils.CapString;
import com.iisigroup.cap.utils.CapSystemConfig;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import freemarker.template.Template;

/**
 * <pre>
 * Base Page of Report.
 * from freemark to pdf
 * </pre>
 * 
 * @since 2013/10/24
 * @author Sunkist Wang
 * @version <ul>
 *          <li>2013/10/24,Sunkist Wang,new
 *          </ul>
 */
public abstract class AbstractReportPdfService extends AbstractService
		implements IFreeMarkerReport, IReportService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public static final String fileUrlPrefix = "file:///";

	public final static String REPORT_SUFFIX = ".ftl";

	final String DEFAULT_ENCORDING = "utf-8";

	@Resource
	private ServletContext servletContext;

	public ByteArrayOutputStream generateReport(IRequest request)
			throws CapException {
		ByteArrayOutputStream templateOut = null;
		ByteArrayOutputStream out = null;
		Writer writer = null;
		OutputStreamWriter wr = null;
		try {
			Template t = getFmConfg().getConfiguration().getTemplate(
					getReportDefinition() + REPORT_SUFFIX);
			Map<String, Object> reportData = excute(request);

			templateOut = new ByteArrayOutputStream();
			wr = new OutputStreamWriter(templateOut, getSysConfig()
					.getProperty(ReportParamEnum.defaultEncoding.toString(),
							DEFAULT_ENCORDING));
			writer = new BufferedWriter(wr);
			t.process(reportData, writer);

			/**
			 * 1.FOR 非使用 JDK 1.7 避免找不到TransformerFactoryImpl
			 * 所以指定org.apache.xalanz裡的實作 2.當使用
			 * org.apache.xalan.processor.TransformerFactoryImpl
			 * 會發生org.w3c.dom.DOMException: NAMESPACE_ERR:
			 */
			System.setProperty("javax.xml.transform.TransformerFactory",
					"org.apache.xalan.xsltc.trax.TransformerFactoryImpl");

			// process core-render
			Document document = XMLResource.load(
					new ByteArrayInputStream(templateOut.toByteArray()))
					.getDocument();

			ITextRenderer iTextRenderer = new ITextRenderer();
			out = new ByteArrayOutputStream();

			// 設定字型
			ITextFontResolver fontResolver = iTextRenderer.getFontResolver();
			fontResolver.addFont(getFontPath(), BaseFont.IDENTITY_H,
					BaseFont.NOT_EMBEDDED);

			PDFEncryption pdfEncryption = new PDFEncryption();
			// 設定加密
			if (reportData.containsKey(ReportParamEnum.encrypt.toString())) {
				String password = (String) reportData
						.get(ReportParamEnum.encrypt.toString());
				if (!CapString.isEmpty(password)) {
					pdfEncryption.setUserPassword(password.getBytes());
				}
			}
			// 設定權限
			if (getAllowedPrivileges() != null) {
				for (int privilege : getAllowedPrivileges()) {
					pdfEncryption.setAllowedPrivileges(privilege);
				}
			}
			iTextRenderer.setPDFEncryption(pdfEncryption);

			iTextRenderer.setDocument(document, fileUrlPrefix
					+ servletContext.getRealPath("").replace("\\", "/") + "/");

			iTextRenderer.layout();
			iTextRenderer.createPDF(out);

		} catch (Exception e) {
			if (e.getCause() != null) {
				throw new CapException(e.getCause(), e.getClass());
			} else {
				throw new CapException(e, e.getClass());
			}
		} finally {
			if (templateOut != null) {
				try {
					templateOut.close();
				} catch (IOException e) {
					if (logger.isErrorEnabled()) {
						logger.error(e.getMessage());
					}
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					if (logger.isErrorEnabled()) {
						logger.error(e.getMessage());
					}
				}
			}
		}
		return out;
	}

	@Resource
	private FreeMarkerConfigurer fmConfg;
	@Resource
	private CapSystemConfig sysConfig;
	@Resource
	private ItextFontFactory fontFactory;

	public FreeMarkerConfigurer getFmConfg() {
		return fmConfg;
	}

	public CapSystemConfig getSysConfig() {
		return sysConfig;
	}

	public ItextFontFactory getFontFactory() {
		return fontFactory;
	}

	// 設定PDF權限
	protected int[] getAllowedPrivileges() {
		return new int[] { PdfWriter.ALLOW_SCREENREADERS };
	}

	// 設定PDF權限
	protected String getFontPath() throws IOException {
		return getFontFactory().getFontPath(FontTypeEnum.微軟正黑體.toString(), "");
	}

	@Override
	public boolean isWriteToFile() {
		return false; // PDF預設不寫檔
	}

}
