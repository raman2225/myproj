package com.sears.controlm.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXmlFile {

public static List<JobDetails> getCompleteJobListFromXml(String filePath,String filter,String srchCriteria){
		
		System.out.println("Parsing the ControlM Xml file : "+ filePath);
		System.out.println("Filter : " + filter);
		System.out.println("Search Criteria : " + srchCriteria);
		System.out.println("-------------------------------------");
		System.out.println("Searching! Please wait....");
		List<JobDetails> arrJobDetails = new ArrayList<JobDetails>();

		try {

			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("JOB");
			JobDetails j=null;
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				//System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					j=new JobDetails(
							eElement.getAttribute("APPLICATION"),
							eElement.getAttribute("SUB_APPLICATION"),
							eElement.getAttribute("JOBNAME"),
							eElement.getAttribute("CMDLINE"),
							eElement.getAttribute("NODEID"),
							eElement.getAttribute("TASKTYPE"),
							eElement.getAttribute("RUN_AS"),
							eElement.getAttribute("TIMEFROM"),
							eElement.getAttribute("TIMETO")
							);
					switch(srchCriteria) {
					case "app" :
						if(j.getAppName().toLowerCase().contains(filter.toLowerCase()))
							arrJobDetails.add(j);
						break;
					case "subapp" :
						if(j.getSubApp().toLowerCase().contains(filter.toLowerCase()))
							arrJobDetails.add(j);
						break;
					case "jobname" :
						if(j.getJobName().toLowerCase().contains(filter.toLowerCase()))
							arrJobDetails.add(j);
						break;
					case "cmdline" :
						if(j.getCmdLine().toLowerCase().contains(filter.toLowerCase()))
							arrJobDetails.add(j);
						break;
					case "tasktype" :
						if(j.getTASKTYPE().toLowerCase().contains(filter.toLowerCase()))
							arrJobDetails.add(j);
						break;
					case "nodeid" :
						if(j.getNODEID().toLowerCase().contains(filter.toLowerCase()))
							arrJobDetails.add(j);
						break;
					case "runas" :
						if(j.getRunAs().toLowerCase().contains(filter.toLowerCase()))
							arrJobDetails.add(j);
						break;
					default :
						break;
					}
					
				}
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(arrJobDetails);
		System.out.println("Done");
		return arrJobDetails;
	}


	
}
