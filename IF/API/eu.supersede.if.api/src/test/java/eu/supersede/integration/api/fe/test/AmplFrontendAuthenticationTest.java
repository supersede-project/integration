package eu.supersede.integration.api.fe.test;


import eu.supersede.integration.api.fe.FrontendAuthentication;
import eu.supersede.integration.api.fe.FrontendSession;
import org.junit.Assert;
import org.junit.Test;

import static org.springframework.util.Assert.notNull;


public class AmplFrontendAuthenticationTest {
    @Test(timeout = 120000)
    public void testLogin_add1() throws Exception {
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        FrontendSession o_testLogin_add1__3 = fea.login("wp_admin", "9jqUuNrZ", "atos");
        Assert.assertEquals("atos", ((eu.supersede.integration.api.fe.FrontendSession)o_testLogin_add1__3).getTenantId());
        notNull(fea.login("wp_admin", "9jqUuNrZ", "atos"));
    }

    @Test(timeout = 120000)
    public void testLogin_sd4() throws Exception {
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        notNull(fea.login("wp_admin", "9jqUuNrZ", "atos"));
        FrontendSession o_testLogin_sd4__9 = fea.login("y(q2 5[gpbL[{$QV5:Wz", "2[|+mr6#-VtX(r!Fs2l>", "UgIvC=TU&zgYc TM1`_8");
        Assert.assertNull(((eu.supersede.integration.api.fe.FrontendSession)o_testLogin_sd4__9).getXsfrToken());
        Assert.assertNull(((eu.supersede.integration.api.fe.FrontendSession)o_testLogin_sd4__9).getSession());
        Assert.assertEquals("UgIvC=TU&zgYc TM1`_8", ((eu.supersede.integration.api.fe.FrontendSession)o_testLogin_sd4__9).getTenantId());
    }

    @Test(timeout = 120000)
    public void testLogin_add1_add109() throws Exception {
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        FrontendSession o_testLogin_add1_add109__3 = fea.login("wp_admin", "9jqUuNrZ", "atos");
        Assert.assertEquals("atos", ((eu.supersede.integration.api.fe.FrontendSession)o_testLogin_add1_add109__3).getTenantId());
        FrontendSession o_testLogin_add1__3 = fea.login("wp_admin", "9jqUuNrZ", "atos");
        notNull(fea.login("wp_admin", "9jqUuNrZ", "atos"));
    }

    @Test(timeout = 120000)
    public void testLogin_add1_sd121() throws Exception {
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        notNull(fea.login("wp_admin", "9jqUuNrZ", "atos"));
        Assert.assertEquals("atos", fea.login("wp_admin", "9jqUuNrZ", "atos").getTenantId());
    }

    @Test(timeout = 120000)
    public void testLogin_add1_add109_add470() throws Exception {
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        FrontendSession o_testLogin_add1_add109_add470__3 = fea.login("wp_admin", "9jqUuNrZ", "atos");
        Assert.assertEquals("atos", ((eu.supersede.integration.api.fe.FrontendSession)o_testLogin_add1_add109_add470__3).getTenantId());
        FrontendSession o_testLogin_add1_add109__3 = fea.login("wp_admin", "9jqUuNrZ", "atos");
        FrontendSession o_testLogin_add1__3 = fea.login("wp_admin", "9jqUuNrZ", "atos");
        notNull(fea.login("wp_admin", "9jqUuNrZ", "atos"));
    }

    @Test(timeout = 120000)
    public void testLogin_add1_sd121_sd485() throws Exception {
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        FrontendSession o_testLogin_add1__3 = fea.login("wp_admin", "9jqUuNrZ", "atos");
        notNull(fea.login("wp_admin", "9jqUuNrZ", "atos"));
        String o_testLogin_add1_sd121__9 = o_testLogin_add1__3.getTenantId();
        Assert.assertEquals("atos", o_testLogin_add1_sd121__9);
        o_testLogin_add1__3.getXsfrToken();
    }

    @Test(timeout = 120000)
    public void testLogin_add1_sd121_literalMutationString512() throws Exception {
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        notNull(fea.login("wp_admin", "9jqUuNrZ", "atos"));
        Assert.assertEquals("atos", fea.login("", "9jqUuNrZ", "atos").getTenantId());
    }

    @Test(timeout = 120000)
    public void testLogin_add1_sd121_literalMutationString530() throws Exception {
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        notNull(fea.login("wp_admin", "9jqUuNrZ", "atos"));
        Assert.assertEquals("", fea.login("wp_admin", "9jqUuNrZ", "").getTenantId());
    }
}

