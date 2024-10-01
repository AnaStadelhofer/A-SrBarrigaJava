package br.com.barriga.suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static br.com.barriga.core.BaseDriver.*;
import br.com.barriga.test.*;

@RunWith(Suite.class)
@SuiteClasses({
        Login.class
        //cadastradoUsuario.class,
        //campoTreinamentoDSL.class,
        //primeFaces.class
})
public class Suites {

    @AfterClass
    public static void closeBrowserClass() {
        if (!closeBrowser) {
            quitBrowser();
        }
    }

}
