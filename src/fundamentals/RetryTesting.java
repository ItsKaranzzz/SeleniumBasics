package fundamentals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTesting {
	
	@Test(retryAnalyzer=fundamentals.RetryLogic.class)
	public void test01() {
		System.out.println("Its gonna fail but after trying");
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test02() {
		System.out.println("Its gonna pass but without retrying");
		Assert.assertEquals(true, true);
	}

}
