package com.sears.controlm.controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sears.controlm.common.*;

/**
 * Servlet implementation class GetXmlFiles
 */
@WebServlet("/GetXmlFiles")
public class GetXmlFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetXmlFiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  

		File folder = new File(ControlM.ControlMXmlFilePath);
		File[] listOfFiles = folder.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
		 LocalDateTime now = LocalDateTime.now();  
		
		for (int i = 0; i < listOfFiles.length; i++) {
			
			if (listOfFiles[i].isFile()) {

				if(listOfFiles[i].getName().endsWith(".xml"))
				{
					if(sdf.format(listOfFiles[i].lastModified()).equals(dtf.format(now)))
					{
						out.write("<a style='cursor:pointer' id='"+listOfFiles[i].getName()+"' onclick='setxmlFile(this.id)'><div class='col s12 m6 l3  center-align'><div class='card-panel blue-grey lighten-5'>"
							+ "<span><i class='material-icons left'>insert_drive_file</i>"+listOfFiles[i].getName()+"</span>"
							+ "</div></div></a>");
					} 
					else {
						out.write("<a style='cursor:pointer' id='"+listOfFiles[i].getName()+"' onclick='setxmlFile(this.id)'><div class='col s12 m6 l3  center-align'><div class='card-panel blue-grey lighten-5'>"
								+ "<span><i class='material-icons left'>insert_drive_file</i>"+listOfFiles[i].getName()+"</span>"
								+ "</div></div></a>");
					}
				}
			}
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
