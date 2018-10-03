package fundamentals;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer{
 
	int count=0;
	int limit=2;
	
	public boolean retry(ITestResult result) {
		
		if(count<limit) {
			count++;
			return true;
		}
		else
			return false;
		
	}
}
