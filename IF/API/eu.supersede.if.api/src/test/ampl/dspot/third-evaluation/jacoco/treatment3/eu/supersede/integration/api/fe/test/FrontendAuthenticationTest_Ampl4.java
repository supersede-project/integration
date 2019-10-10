package eu.supersede.integration.api.fe.test;


import eu.supersede.integration.api.fe.FrontendAuthentication;
import eu.supersede.integration.api.fe.FrontendSession;
import org.junit.Assert;
import org.junit.Test;

import static org.springframework.util.Assert.notNull;


public class FrontendAuthenticationTest_Ampl4 {
    @Test(timeout = 30000)
    public void testLogin_add1() throws Exception {
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        FrontendSession o_testLogin_add1__3 = fea.login("wp_admin", "9jqUuNrZ", "atos");
        Assert.assertEquals("atos", ((FrontendSession) (o_testLogin_add1__3)).getTenantId());
        FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
        notNull(frontEndSession);
        Assert.assertEquals("atos", ((FrontendSession) (o_testLogin_add1__3)).getTenantId());
    }

    @Test(timeout = 30000)
    public void testLogin_mg23() throws Exception {
        String __DSPOT_tenant_4 = "KS@Rl&{ha!&Bcvg[?i!r";
        String __DSPOT_password_3 = "TM1`_8;0L`A=SO/woO!O";
        String __DSPOT_user_2 = "=Fs2l>UgIvC=TU&zgYc ";
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
        notNull(frontEndSession);
        FrontendSession o_testLogin_mg23__9 = fea.login(__DSPOT_user_2, __DSPOT_password_3, __DSPOT_tenant_4);
        Assert.assertNull(((FrontendSession) (o_testLogin_mg23__9)).getXsfrToken());
        Assert.assertNull(((FrontendSession) (o_testLogin_mg23__9)).getSession());
        Assert.assertEquals("KS@Rl&{ha!&Bcvg[?i!r", ((FrontendSession) (o_testLogin_mg23__9)).getTenantId());
    }

    @Test(timeout = 30000)
    public void testLoginnull75_failAssert0() throws Exception {
        try {
            FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
            FrontendSession frontEndSession = fea.login(null, "9jqUuNrZ", "atos");
            notNull(frontEndSession);
            org.junit.Assert.fail("testLoginnull75 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull76_failAssert0() throws Exception {
        try {
            FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
            FrontendSession frontEndSession = fea.login("wp_admin", null, "atos");
            notNull(frontEndSession);
            org.junit.Assert.fail("testLoginnull76 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid password", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull78_failAssert0() throws Exception {
        try {
            FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
            FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
            notNull(null);
            org.junit.Assert.fail("testLoginnull78 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull78_failAssert0_add316_failAssert0() throws Exception {
        try {
            {
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
                notNull(null);
                notNull(null);
                org.junit.Assert.fail("testLoginnull78 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLoginnull78_failAssert0_add316 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull78_failAssert0litString497_failAssert0() throws Exception {
        try {
            {
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "9jqUuNrZ");
                notNull(null);
                org.junit.Assert.fail("testLoginnull78 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLoginnull78_failAssert0litString497 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull78_failAssert0litString667_failAssert0() throws Exception {
        try {
            {
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "\n");
                notNull(null);
                org.junit.Assert.fail("testLoginnull78 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLoginnull78_failAssert0litString667 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLogin_add1null790_failAssert0litString1709_failAssert0() throws Exception {
        try {
            {
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession o_testLogin_add1__3 = fea.login("wp_admin", "9jqUuNrZ", ":");
                FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
                notNull(null);
                org.junit.Assert.fail("testLogin_add1null790 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLogin_add1null790_failAssert0litString1709 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }
}

