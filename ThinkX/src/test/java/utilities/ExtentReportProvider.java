package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testcases.BaseTest;

public class ExtentReportProvider implements ITestListener{
	public ExtentSparkReporter extentsparkrepo;
	public ExtentReports extentrepo;
	public ExtentTest extenttest;
	
	String reportName ;	
	
	public void onStart(ITestContext testcontext)
	{
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));
		reportName= "TestReport"+ timestamp + ".html";
	
		extentsparkrepo= new ExtentSparkReporter(".\\reports\\"+reportName);
		
		extentsparkrepo.config().setDocumentTitle("Automation testing");
		extentsparkrepo.config().setReportName("Automation Report");
		extentsparkrepo.config().setTheme(Theme.STANDARD);
		
		extentrepo = new ExtentReports();
		
		extentrepo.attachReporter(extentsparkrepo);
		extentrepo.setSystemInfo("Application","TE");
		extentrepo.setSystemInfo("Test", "IBT");
		extentrepo.setSystemInfo("portal","candidate");
		extentrepo.setSystemInfo("Username", System.getProperty("user.name"));
		extentrepo.setSystemInfo("Environment", "UAT");
		
		String os = testcontext.getCurrentXmlTest().getParameter("os");
		extentrepo.setSystemInfo("Operating System", os);
		
		String browser = testcontext.getCurrentXmlTest().getParameter("browser");
		extentrepo.setSystemInfo("Browser", browser);
		
		
		List<String> includedGroups = testcontext.getCurrentXmlTest().getIncludedGroups();   
		if(!includedGroups.isEmpty())
		{
			extentrepo.setSystemInfo("Groups",includedGroups.toString());
			
		}
		
	}
	
	 public void onTestStart(ITestResult result)
	{
		
	}
	 
	 
	 public void onTestSuccess(ITestResult result)
	    {
		 
		 extenttest= extentrepo.createTest(result.getTestClass().getName());
		 extenttest.assignCategory(result.getMethod().getGroups());
		 extenttest.log(Status.PASS, result.getName()+"run successfully ");
	       
	   
	    }
	
	 
	 public void onTestFailure(ITestResult result)
	    {
	        
		 extenttest= extentrepo.createTest(result.getTestClass().getName());
		 extenttest.assignCategory(result.getMethod().getGroups());
		 
		    extenttest.log(Status.FAIL, result.getName()+"got failed ");
	        extenttest.log(Status.INFO,result.getThrowable().getMessage());
	     
	        
	        String imgpath= new BaseTest().captureSC(result.getName());
			  extenttest.addScreenCaptureFromPath(imgpath);
	        }
	    
	 
	 
	 public void onTestSkipped(ITestResult result)
	    {
		 extenttest= extentrepo.createTest(result.getTestClass().getName());
		 extenttest.assignCategory(result.getMethod().getGroups());
		 
		    extenttest.log(Status.SKIP, result.getName()+"got skipped.");
		    extenttest.log(Status.INFO,result.getThrowable().getMessage());
		      
	 
	    }
	

	 public void onFinish(ITestContext testcontext)
	     {
	        	        extentrepo.flush();
	 /*              String pathofReport= System.getProperty("user.dir")+"\\reports"+reportName;
	               File extentReport= new File(pathofReport);

	               try
	               {
	            	  Desktop.getDesktop().browse(extentReport.toURI()); 
	               }
	               catch(IOException e) 
	               { e.printStackTrace();
	            	   
	               }
	               	   */   
	               // autoemailSEND work is pending 
	     }
	 
	 
	
	 
	 
}
