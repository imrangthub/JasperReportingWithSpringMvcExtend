package com.imran.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imran.model.Book;
import com.imran.model.BookReportManager;

@Service
public class BookReportManagerService {
	
	@Autowired
	DataSource dataSource;
	private Statement stmt;
	
	public BookReportManager bookReportManagerObj(){
		List<BookReportManager> bookReportManagerList = new ArrayList<BookReportManager>();
		
		String getAllDataQuery = "SELECT * FROM book_report_manager ORDER BY ID"; 
		BookReportManager bookReportManagerObj = new BookReportManager();
//		   System.out.println(getAllDataQuery);
		try {
			this.stmt = dataSource.getConnection().createStatement();
			ResultSet tempResult = stmt.executeQuery(getAllDataQuery);
			while(tempResult.next()){
				
				bookReportManagerObj.setId(Long.parseLong(tempResult.getString("id")));
				bookReportManagerObj.setIsAuthorShow(true);
				bookReportManagerObj.setIsAuthorTableShow(false);
				bookReportManagerObj.setIsIdShow(true);
				bookReportManagerObj.setIsNameShow(true);
				bookReportManagerObj.setIsTypeShow(true);

			}
			stmt.close();
			dataSource.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookReportManagerObj;		
	}
	
//	public List<BookReportManager> bookReportManagerList(){
//		List<BookReportManager> bookReportManagerList = new ArrayList<BookReportManager>();
//		
//		String getAllDataQuery = "SELECT * FROM book_report_manager ORDER BY ID"; 
////		   System.out.println(getAllDataQuery);
//		try {
//			this.stmt = dataSource.getConnection().createStatement();
//			ResultSet tempResult = stmt.executeQuery(getAllDataQuery);
//			while(tempResult.next()){
//				BookReportManager bookReportManagerObj = new BookReportManager();
////				bookReportManagerObj.setId(Long.parseLong(tempResult.getString("id")));
////				bookReportManagerObj.setIsAuthorShow(Boolean.valueOf(tempResult.getString("isAuthorShow")));
////				bookReportManagerObj.setIsAuthorTableShow(Boolean.valueOf(tempResult.getString("isAuthorTableShow")));
////				bookReportManagerObj.setIsIdShow(Boolean.valueOf(tempResult.getString("isIdShow")));
////				bookReportManagerObj.setIsNameShow(Boolean.valueOf(tempResult.getString("isNameShow")));
////				bookReportManagerObj.setIsTypeShow(Boolean.valueOf(tempResult.getString("isTypeShow")));
//				
//				bookReportManagerObj.setId(Long.parseLong(tempResult.getString("id")));
//				bookReportManagerObj.setIsAuthorShow(true);
//				bookReportManagerObj.setIsAuthorTableShow(false);
//				bookReportManagerObj.setIsIdShow(true);
//				bookReportManagerObj.setIsNameShow(true);
//				bookReportManagerObj.setIsTypeShow(true);
//				
//				bookReportManagerList.add(bookReportManagerObj);
//			}
//			stmt.close();
//			dataSource.getConnection().close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return bookReportManagerList;		
//	}
	
	
	

}
