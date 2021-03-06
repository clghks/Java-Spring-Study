package com.clghks.helloservlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class MultiUpload extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/Users/chihwan/Documents/java_spring_study/upload";
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		factory.setSizeThreshold(1024);
		upload.setSizeMax(-1);
		upload.setHeaderEncoding("euc-kr");
		
		String fName = "";
		String extension = "";
		
		try {
			List<FileItem> items = upload.parseRequest(req);
			for (FileItem fileItem : items) {
				if (fileItem.isFormField()){
					fName = fileItem.getString("euc-kr");
				}else{
					if (fileItem.getName() != null && !"".equals(fileItem.getName())){
						String fileName = (new File(fileItem.getName())).getName();
						extension = FilenameUtils.getExtension(fileName);
						fileItem.write(new File(path + "/" + fName + "." + extension));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("multi.html");
	}
}
