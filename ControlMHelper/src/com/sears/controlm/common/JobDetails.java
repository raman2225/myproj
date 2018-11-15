package com.sears.controlm.common;

public class JobDetails {

	public String AppName;
	public String SubApp;
	public String JobName;
	public String CmdLine;
	public String NODEID;
	public String TASKTYPE;
	public String RunAs;
	public String TimeFrom;
	public String TimeTo;
	
	public String getRunAs() {
		return RunAs;
	}
	public void setRunAs(String runAs) {
		RunAs = runAs;
	}
	public String getAppName() {
		return AppName;
	}
	public String getTimeFrom() {
		return TimeFrom;
	}
	public void setTimeFrom(String timeFrom) {
		TimeFrom = timeFrom;
	}
	public String getTimeTo() {
		return TimeTo;
	}
	public void setTimeTo(String timeTo) {
		TimeTo = timeTo;
	}
	public void setAppName(String appName) {
		AppName = appName;
	}
	public String getSubApp() {
		return SubApp;
	}
	public void setSubApp(String subApp) {
		SubApp = subApp;
	}
	public String getJobName() {
		return JobName;
	}
	public void setJobName(String jobName) {
		JobName = jobName;
	}
	public String getCmdLine() {
		return CmdLine;
	}
	public void setCmdLine(String cmdLine) {
		CmdLine = cmdLine;
	}
	public String getNODEID() {
		return NODEID;
	}
	public void setNODEID(String nODEID) {
		NODEID = nODEID;
	}
	public String getTASKTYPE() {
		return TASKTYPE;
	}
	public void setTASKTYPE(String tASKTYPE) {
		TASKTYPE = tASKTYPE;
	}
	@Override
	public String toString() {
		return "JobDetails [AppName=" + AppName + ", SubApp=" + SubApp + ", JobName=" + JobName + ", CmdLine=" + CmdLine
				+ ", NODEID=" + NODEID + ", TASKTYPE=" + TASKTYPE + ", RunAs=" + RunAs + ", TimeFrom=" + TimeFrom
				+ ", TimeTo=" + TimeTo + "]";
	}
	public JobDetails(String appName, String subApp, String jobName, String cmdLine, String nODEID, String tASKTYPE,
			String runAs, String timeFrom, String timeTo) {
		super();
		AppName = appName;
		SubApp = subApp;
		JobName = jobName;
		CmdLine = cmdLine;
		NODEID = nODEID;
		TASKTYPE = tASKTYPE;
		RunAs = runAs;
		TimeFrom = timeFrom;
		TimeTo = timeTo;
	}
	


}
