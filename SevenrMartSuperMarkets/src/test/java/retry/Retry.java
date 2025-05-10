package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	//to re execute the failed test cases
	//retry parameter using in @Test annotation in test class
	int counter = 0;
	int retryLimit = 2;
	
	public boolean retry(ITestResult result) 
	{

		if(counter < retryLimit)
		{
			counter++;//it will 2 times re-execute for failed test case
			return true;
		}
		return false;
	}
}
