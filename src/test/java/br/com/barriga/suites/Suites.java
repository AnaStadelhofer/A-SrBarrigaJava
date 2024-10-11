package br.com.barriga.suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static br.com.barriga.core.BaseTest.*;
import br.com.barriga.test.*;

@RunWith(Suite.class)
@SuiteClasses({
        Login.class,
        Movement.class,
        Account.class
})
public class Suites {

    @AfterClass
    public static void closeBrowserClass() {
        if (!closeBrowser) {
            quitBrowser();
        }
    }

}
