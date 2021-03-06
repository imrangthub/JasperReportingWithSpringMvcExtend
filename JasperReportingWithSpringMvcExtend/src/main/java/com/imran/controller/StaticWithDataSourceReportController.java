package com.imran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imran.model.Book;
import com.imran.service.BookService;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@Controller
@RequestMapping(value = "/staticReportWithDataSource")
public class StaticWithDataSourceReportController {
	
	 
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap map) {	
		return "report/staticReportWithDataSource";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save(ModelMap map, HttpServletResponse resp) throws JRException, IOException {
		
		List<Book> bookList =  bookService.bookList();	
	    JRDataSource jrDataSource = new JRBeanCollectionDataSource(bookList);
		
		   Map<String, Object> parameterMap = new HashMap<String, Object>();		   
	       parameterMap.put("title", "Book List");
	       parameterMap.put("reportFooter", "imranmadbar@gmail.com");
	       parameterMap.put("companyName", "CS ifo tech");
	       parameterMap.put("datasource", jrDataSource);
		
			JasperReport jasperReport = null;
			JasperPrint jasperPrint = null;
	
				
		    File initialFile = new File("G:\\IMRAN_PROJECT\\SpringJasperReporting\\JasperReportintgWithSpringMvcExtend\\src\\main\\webapp\\resources\\report\\staticReportWithDataSource.jrxml");
		    InputStream jasperStream = null;
				try {
					
					jasperStream = new FileInputStream(initialFile);
					jasperReport = JasperCompileManager.compileReport(jasperStream);
				    jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, jrDataSource);

					JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\IMRAN\\Desktop\\staticReportWithDataSource_outputfile.pdf");
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				return "redirect:/staticReportWithDataSource/";          
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<byte[]>  download(ModelMap map, HttpServletResponse resp) throws JRException, IOException {
		
		List<Book> bookList =  bookService.bookList();	
	    JRDataSource jrDataSource = new JRBeanCollectionDataSource(bookList);
		
		   Map<String, Object> parameterMap = new HashMap<String, Object>();		   
	       parameterMap.put("title", "Book List");
	       parameterMap.put("reportFooter", "imranmadbar@gmail.com");
	       parameterMap.put("companyName", "CS ifo tech");
	       parameterMap.put("datasource", jrDataSource);
		
			JasperReport jasperReport = null;
			JasperPrint jasperPrint = null;
		 	 HttpHeaders headers = null;				
			 byte[] bytes = null;	
				
		    File initialFile = new File("G:\\IMRAN_PROJECT\\SpringJasperReporting\\JasperReportintgWithSpringMvcExtend\\src\\main\\webapp\\resources\\report\\staticReportWithDataSource.jrxml");
		    InputStream jasperStream = null;
				try {
					
					jasperStream = new FileInputStream(initialFile);
					jasperReport = JasperCompileManager.compileReport(jasperStream);
				    jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, jrDataSource);
					bytes = JasperExportManager.exportReportToPdf(jasperPrint);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
		            headers = new HttpHeaders();
					headers.setContentType(MediaType.parseMediaType("application/pdf"));
					String filename = "staticReportWithDataSource.pdf";
					headers.setContentDispositionFormData(filename, filename);
				
				return new ResponseEntity<byte[]>(bytes,headers, HttpStatus.OK);          
	}
	
	@ResponseBody
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ResponseEntity<byte[]>  view(ModelMap map, HttpServletResponse resp) throws JRException, IOException {
		
		List<Book> bookList =  bookService.bookList();	
	    JRDataSource jrDataSource = new JRBeanCollectionDataSource(bookList);
		
		   Map<String, Object> parameterMap = new HashMap<String, Object>();		   
	       parameterMap.put("title", "Book List");
	       parameterMap.put("reportFooter", "imranmadbar@gmail.com");
	       parameterMap.put("companyName", "CS ifo tech");
	       parameterMap.put("datasource", jrDataSource);
		
			JasperReport jasperReport = null;
			JasperPrint jasperPrint = null;
		 	 HttpHeaders headers = null;				
			 byte[] bytes = null;	
				
		    File initialFile = new File("G:\\IMRAN_PROJECT\\SpringJasperReporting\\JasperReportintgWithSpringMvcExtend\\src\\main\\webapp\\resources\\report\\staticReportWithDataSource.jrxml");
		    InputStream jasperStream = null;
				try {
					
					jasperStream = new FileInputStream(initialFile);
					jasperReport = JasperCompileManager.compileReport(jasperStream);
				    jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, jrDataSource);
					bytes = JasperExportManager.exportReportToPdf(jasperPrint);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
		            headers = new HttpHeaders();
					headers.setContentType(MediaType.parseMediaType("application/pdf"));
					headers.set("Content-Disposition", "inline; filename=staticReportWithDataSourceView.pdf");
					headers.setContentLength(bytes.length);
				
				return new ResponseEntity<byte[]>(bytes,headers, HttpStatus.OK);          
	}


}
