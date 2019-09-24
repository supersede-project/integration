package eu.supersede.integration.api.fe.test;


import eu.supersede.integration.api.fe.FrontendAuthentication;
import eu.supersede.integration.api.fe.FrontendSession;
import org.junit.Assert;
import org.junit.Test;

import static org.springframework.util.Assert.notNull;


public class FrontendAuthenticationTest {
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
    public void testLogin_mg23null742_failAssert0() throws Exception {
        try {
            String __DSPOT_tenant_4 = "KS@Rl&{ha!&Bcvg[?i!r";
            String __DSPOT_password_3 = "TM1`_8;0L`A=SO/woO!O";
            String __DSPOT_user_2 = "=Fs2l>UgIvC=TU&zgYc ";
            FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
            FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
            notNull(frontEndSession);
            FrontendSession o_testLogin_mg23__9 = fea.login(__DSPOT_user_2, null, __DSPOT_tenant_4);
            org.junit.Assert.fail("testLogin_mg23null742 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid password", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull75_failAssert0_mg406_failAssert0() throws Exception {
        try {
            {
                FrontendSession __DSPOT_session_15 = new FrontendSession();
                String __DSPOT_requirement_13 = "]QM-k,I]-r8//GGUV@1w";
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession frontEndSession = fea.login(null, "9jqUuNrZ", "atos");
                notNull(frontEndSession);
                org.junit.Assert.fail("testLoginnull75 should have thrown IllegalArgumentException");
                fea.addRequirement(__DSPOT_requirement_13, __DSPOT_session_15);
            }
            org.junit.Assert.fail("testLoginnull75_failAssert0_mg406 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull78_failAssert0litString665_failAssert0() throws Exception {
        try {
            {
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "5t1&");
                notNull(null);
                org.junit.Assert.fail("testLoginnull78 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLoginnull78_failAssert0litString665 should have thrown IllegalArgumentException");
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
    public void testLogin_add1_mg474_add1367() throws Exception {
        String __DSPOT_tenant_47 = "L360:}[gYFUICnc)SU7E";
        String __DSPOT_password_46 = "oY.>c^U!$Cz2lvLY3Pe#";
        String __DSPOT_user_45 = "SysP>6W.t0C-?9AC*$S ";
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        FrontendSession o_testLogin_add1__3 = fea.login("wp_admin", "9jqUuNrZ", "atos");
        FrontendSession o_testLogin_add1_mg474_add1367__9 = fea.login("wp_admin", "9jqUuNrZ", "atos");
        Assert.assertEquals("atos", ((FrontendSession) (o_testLogin_add1_mg474_add1367__9)).getTenantId());
        FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
        notNull(frontEndSession);
        FrontendSession o_testLogin_add1_mg474__12 = fea.login(__DSPOT_user_45, __DSPOT_password_46, __DSPOT_tenant_47);
        Assert.assertEquals("atos", ((FrontendSession) (o_testLogin_add1_mg474_add1367__9)).getTenantId());
    }

    @Test(timeout = 30000)
    public void testLogin_add1null790_failAssert0litString1725_failAssert0() throws Exception {
        try {
            {
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession o_testLogin_add1__3 = fea.login("wp_admin", "9jqUuNrZ", "atos");
                FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "ttos");
                notNull(null);
                org.junit.Assert.fail("testLogin_add1null790 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLogin_add1null790_failAssert0litString1725 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull75_failAssert0_mg406_failAssert0null1894_failAssert0() throws Exception {
        try {
            {
                {
                    FrontendSession __DSPOT_session_15 = new FrontendSession();
                    String __DSPOT_requirement_13 = null;
                    FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                    FrontendSession frontEndSession = fea.login(null, "9jqUuNrZ", "atos");
                    notNull(frontEndSession);
                    org.junit.Assert.fail("testLoginnull75 should have thrown IllegalArgumentException");
                    fea.addRequirement(__DSPOT_requirement_13, __DSPOT_session_15);
                }
                org.junit.Assert.fail("testLoginnull75_failAssert0_mg406 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLoginnull75_failAssert0_mg406_failAssert0null1894 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid user", expected.getMessage());
        }
    }
}

