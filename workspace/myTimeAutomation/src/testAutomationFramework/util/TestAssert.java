package testAutomationFramework.util;

import org.testng.Assert;

public class TestAssert {
	
	public boolean assertTrue(boolean Condition, String LogMsg) {
		try {
			Assert.assertTrue(Condition);
			System.out.println("[PASSED] " + LogMsg);
			return true;
		} catch (java.lang.AssertionError | Exception e) {
			System.out.println("[FAILED] " + LogMsg);
			return false;
		}
	}
		
}
