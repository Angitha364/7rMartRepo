package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {

	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");// Create object
																										// on the method
																										// createExtentReports()
		reporter.config().setReportName("SevenrMartSuperMarkets");// it will show title on html folder at the top
		extentReports.attachReporter(reporter);// attach the report
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "Angitha");// it will show name on html folder at the end
		extentReports.setSystemInfo("Name", "Aleena");
		extentReports.setSystemInfo("Name", "Parvathy");
		extentReports.setSystemInfo("Name", "Nila");
		extentReports.setSystemInfo("Name", "Jinsha");
		extentReports.setSystemInfo("Name", "Gopika");
		return extentReports;// particular method is returning a report,it is customized report
	}
}
