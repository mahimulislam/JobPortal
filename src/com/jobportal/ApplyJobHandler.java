package com.jobportal;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.dao.LoginDaoEmployee;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/ApplyJobHandler") // at the place of ServletName  
public class ApplyJobHandler extends HttpServlet {
 private static final long serialVersionUID = 1 ;
 public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
 String file_name = null;
 String emailss = request.getParameter("email");
 String edob = request.getParameter("dob");
 String eaddress = request.getParameter("address");

 System.out.println(emailss);
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
 if (!isMultipartContent) {
 return;
 }
 FileItemFactory factory = new DiskFileItemFactory();
 ServletFileUpload upload = new ServletFileUpload(factory);
 try {
 List < FileItem > fields = upload.parseRequest(request);
 Iterator < FileItem > it = fields.iterator();
 if (!it.hasNext()) {
 return;
 }
 while (it.hasNext()) {
 FileItem fileItem = it.next();
 boolean isFormField = fileItem.isFormField();
 if (isFormField) {
 if (file_name == null) {
 if (fileItem.getFieldName().equals("file_name")) {
 file_name = fileItem.getString();
 }
 }
 } else {
 if (fileItem.getSize() > 0) {
File deleteFile = new File("/Users/mahimulislam/Desktop/GRE/"+emailss + "cv.pdf") ;
// check if the file is present or not
if( deleteFile.exists() )
deleteFile.delete() ;
 fileItem.write(new File("/Users/mahimulislam/Desktop/GRE/"+emailss + "cv.pdf"));
 }
 }
    String name=request.getParameter("name");
	String mobile=request.getParameter("mobile");
	RequestDispatcher rd=request.getRequestDispatcher("viewprofileemployee.jsp?enames="+name+"&edobs="+edob+"&eemail="+emailss+"&eaddresss="+eaddress+"&emobiles="+mobile);
	rd.forward(request, response);
 }
 } catch (Exception e) {
 e.printStackTrace();
 } 
 }
}