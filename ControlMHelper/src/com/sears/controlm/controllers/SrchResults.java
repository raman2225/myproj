package com.sears.controlm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sears.controlm.common.ControlM;
import com.sears.controlm.common.JobDetails;
import com.sears.controlm.common.ReadXmlFile;

/**
 * Servlet implementation class SrchResults
 */
@WebServlet("/SrchResults")
public class SrchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SrchResults() {
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

		String srchCriteria=request.getParameter("srchCriteria");
		String txtSrch=request.getParameter("txtSrch");

		HttpSession session=request.getSession();  
		String selectedXmlfile=(String) session.getAttribute("XMLFILE");
		
		List<JobDetails> arrJobList=ReadXmlFile.getCompleteJobListFromXml(ControlM.ControlMXmlFilePath+selectedXmlfile, txtSrch, srchCriteria);

		if(arrJobList.size()>0) {

			for (int i = 0; i < arrJobList.size(); i++) {
				out.print("<tr>");
				out.print("<td>"+arrJobList.get(i).getAppName()+"</td>");
				out.print("<td>"+arrJobList.get(i).getSubApp()+"</td>");
				out.print("<td>"+arrJobList.get(i).getJobName()+"</td>");
				out.print("<td>"+arrJobList.get(i).getCmdLine()+"</td>");
				out.print("<td>"+arrJobList.get(i).getNODEID()+"</td>");
				out.print("<td>"+arrJobList.get(i).getTASKTYPE()+"</td>");
				out.print("<td>"+arrJobList.get(i).getRunAs()+"</td>");
				out.print("<td>"+arrJobList.get(i).getTimeFrom()+"</td>");
				out.print("<td>"+arrJobList.get(i).getTimeTo()+"</td>");
				out.print("</tr>");
			}
		}else {
			out.print("No results found");
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
