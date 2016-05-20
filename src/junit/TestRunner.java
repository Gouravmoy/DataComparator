package junit;

import org.apache.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	static Logger logger = Logger.getLogger(TestRunner.class);

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(DatabaseDAOTest.class);
		for (Failure failure : result.getFailures()) {
			logger.error(failure.toString());
		}
		logger.info("Overall Result - " + result.wasSuccessful());
	}
}