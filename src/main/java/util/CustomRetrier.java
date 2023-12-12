package util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static org.testng.ITestResult.FAILURE;
import static org.testng.ITestResult.SUCCESS;
import static util.readers.PropertiesReader.getProperty;

public class CustomRetrier implements IRetryAnalyzer {

    private static final int MAX_TRY = Integer.parseInt(getProperty("retrycount"));
    private int count = 0;

    @Override
    public boolean retry(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            if (count < MAX_TRY) {
                count++;
                testResult.setStatus(FAILURE);

                return true;
            } else {
                testResult.setStatus(FAILURE);
            }
        } else {
            testResult.setStatus(SUCCESS);
        }
        return false;
    }
}
