package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzer_Listener implements IRetryAnalyzer {

    /************************************GLOBAL_VARIABLES***************************************************/
    private final int max_Count = 2;
    private int retry_Count = 0;

    /********************************LISTENER_IMPLEMENTATIONS************************************************/
    @Override
    public boolean retry(ITestResult result) {
        if(result.getStatus()==2)
        {
            if(retry_Count<max_Count)
            {
                retry_Count++;
                return true;
            }
        }
        return false;
    }
}
