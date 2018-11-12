package eu.supersede.integration.api.fe.test;


import eu.supersede.integration.api.fe.FrontendAuthentication;
import eu.supersede.integration.api.fe.FrontendSession;
import org.junit.Test;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class AmplFrontendAuthenticationTest {
    @Test(timeout = 30000)
    public void testLogin_mg26() throws Exception {
        String __DSPOT_tenant_4 = "l&{ha!&Bcvg[?i!rb0/|";
        String __DSPOT_password_3 = "_8;0L`A=SO/woO!OKS@R";
        String __DSPOT_user_2 = "l>UgIvC=TU&zgYc TM1`";
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
        Assert.notNull(frontEndSession);
        FrontendSession o_testLogin_mg26__9 = fea.login(__DSPOT_user_2, __DSPOT_password_3, __DSPOT_tenant_4);
        assertNull(((FrontendSession) (o_testLogin_mg26__9)).getXsfrToken());
        assertNull(((FrontendSession) (o_testLogin_mg26__9)).getSession());
        assertEquals("l&{ha!&Bcvg[?i!rb0/|", ((FrontendSession) (o_testLogin_mg26__9)).getTenantId());
    }

    @Test(timeout = 30000)
    public void testLoginnull30_failAssert0() throws Exception {
        try {
            FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
            FrontendSession frontEndSession = fea.login(null, "9jqUuNrZ", "atos");
            Assert.notNull(frontEndSession);
            org.junit.Assert.fail("testLoginnull30 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull31_failAssert1() throws Exception {
        try {
            FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
            FrontendSession frontEndSession = fea.login("wp_admin", null, "atos");
            Assert.notNull(frontEndSession);
            org.junit.Assert.fail("testLoginnull31 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid password", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull33_failAssert2() throws Exception {
        try {
            FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
            FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
            Assert.notNull(null);
            org.junit.Assert.fail("testLoginnull33 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLogin_mg26_mg240() throws Exception {
        String __DSPOT_tenant_28 = ")A6fdF&0xT!&b-W-(y_V";
        String __DSPOT_password_27 = "]]s%=])JWOM_4gdsL9rC";
        String __DSPOT_user_26 = ";&FZRy/=u eShD9P/&h4";
        String __DSPOT_tenant_4 = "l&{ha!&Bcvg[?i!rb0/|";
        String __DSPOT_password_3 = "_8;0L`A=SO/woO!OKS@R";
        String __DSPOT_user_2 = "l>UgIvC=TU&zgYc TM1`";
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
        Assert.notNull(frontEndSession);
        FrontendSession o_testLogin_mg26__9 = fea.login(__DSPOT_user_2, __DSPOT_password_3, __DSPOT_tenant_4);
        FrontendSession o_testLogin_mg26_mg240__15 = fea.login(__DSPOT_user_26, __DSPOT_password_27, __DSPOT_tenant_28);
        assertNull(((FrontendSession) (o_testLogin_mg26_mg240__15)).getXsfrToken());
        assertNull(((FrontendSession) (o_testLogin_mg26_mg240__15)).getSession());
        assertEquals(")A6fdF&0xT!&b-W-(y_V", ((FrontendSession) (o_testLogin_mg26_mg240__15)).getTenantId());
    }

    @Test(timeout = 30000)
    public void testLogin_mg26null256_failAssert3() throws Exception {
        try {
            String __DSPOT_tenant_4 = "l&{ha!&Bcvg[?i!rb0/|";
            String __DSPOT_password_3 = null;
            String __DSPOT_user_2 = "l>UgIvC=TU&zgYc TM1`";
            FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
            FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
            Assert.notNull(frontEndSession);
            FrontendSession o_testLogin_mg26__9 = fea.login(__DSPOT_user_2, __DSPOT_password_3, __DSPOT_tenant_4);
            org.junit.Assert.fail("testLogin_mg26null256 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid password", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLogin_mg26null258_failAssert5() throws Exception {
        try {
            String __DSPOT_tenant_4 = "l&{ha!&Bcvg[?i!rb0/|";
            String __DSPOT_password_3 = "_8;0L`A=SO/woO!OKS@R";
            String __DSPOT_user_2 = "l>UgIvC=TU&zgYc TM1`";
            FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
            FrontendSession frontEndSession = fea.login(null, "9jqUuNrZ", "atos");
            Assert.notNull(frontEndSession);
            FrontendSession o_testLogin_mg26__9 = fea.login(__DSPOT_user_2, __DSPOT_password_3, __DSPOT_tenant_4);
            org.junit.Assert.fail("testLogin_mg26null258 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLogin_mg26null259_failAssert6() throws Exception {
        try {
            String __DSPOT_tenant_4 = "l&{ha!&Bcvg[?i!rb0/|";
            String __DSPOT_password_3 = "_8;0L`A=SO/woO!OKS@R";
            String __DSPOT_user_2 = "l>UgIvC=TU&zgYc TM1`";
            FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
            FrontendSession frontEndSession = fea.login("wp_admin", null, "atos");
            Assert.notNull(frontEndSession);
            FrontendSession o_testLogin_mg26__9 = fea.login(__DSPOT_user_2, __DSPOT_password_3, __DSPOT_tenant_4);
            org.junit.Assert.fail("testLogin_mg26null259 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid password", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull30_failAssert0_mg234_failAssert26() throws Exception {
        try {
            {
                FrontendSession __DSPOT_session_17 = new FrontendSession();
                String __DSPOT_requirement_16 = "_1JVt2Y][1u)p]QM-k,I";
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession frontEndSession = fea.login(null, "9jqUuNrZ", "atos");
                Assert.notNull(frontEndSession);
                org.junit.Assert.fail("testLoginnull30 should have thrown IllegalArgumentException");
                fea.addRequirement(__DSPOT_requirement_16, __DSPOT_session_17);
            }
            org.junit.Assert.fail("testLoginnull30_failAssert0_mg234 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull30_failAssert0null250_failAssert31() throws Exception {
        try {
            {
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession frontEndSession = fea.login(null, null, "atos");
                Assert.notNull(frontEndSession);
                org.junit.Assert.fail("testLoginnull30 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLoginnull30_failAssert0null250 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull31_failAssert1_mg226_failAssert42() throws Exception {
        try {
            {
                FrontendSession __DSPOT_session_9 = new FrontendSession();
                String __DSPOT_requirement_8 = "Gpwmm(EQndBdj-qEHp!#";
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession frontEndSession = fea.login("wp_admin", null, "atos");
                Assert.notNull(frontEndSession);
                org.junit.Assert.fail("testLoginnull31 should have thrown IllegalArgumentException");
                fea.addRequirement(__DSPOT_requirement_8, __DSPOT_session_9);
            }
            org.junit.Assert.fail("testLoginnull31_failAssert1_mg226 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid password", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull33_failAssert2litString218_failAssert66() throws Exception {
        try {
            {
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "wp_admin");
                Assert.notNull(null);
                org.junit.Assert.fail("testLoginnull33 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLoginnull33_failAssert2litString218 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull33_failAssert2litString224_failAssert72() throws Exception {
        try {
            {
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "\n");
                Assert.notNull(null);
                org.junit.Assert.fail("testLoginnull33 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLoginnull33_failAssert2litString224 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLogin_mg26_mg240_mg869() throws Exception {
        String __DSPOT_tenant_126 = "=C]SG#JnI[]y <3bSwN_";
        String __DSPOT_password_125 = "A(ki&%rufmpg#7]{pw/y";
        String __DSPOT_user_124 = "A;>)ztoxnh`PM&G]>@aW";
        String __DSPOT_tenant_28 = ")A6fdF&0xT!&b-W-(y_V";
        String __DSPOT_password_27 = "]]s%=])JWOM_4gdsL9rC";
        String __DSPOT_user_26 = ";&FZRy/=u eShD9P/&h4";
        String __DSPOT_tenant_4 = "l&{ha!&Bcvg[?i!rb0/|";
        String __DSPOT_password_3 = "_8;0L`A=SO/woO!OKS@R";
        String __DSPOT_user_2 = "l>UgIvC=TU&zgYc TM1`";
        FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
        FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
        Assert.notNull(frontEndSession);
        FrontendSession o_testLogin_mg26__9 = fea.login(__DSPOT_user_2, __DSPOT_password_3, __DSPOT_tenant_4);
        FrontendSession o_testLogin_mg26_mg240__15 = fea.login(__DSPOT_user_26, __DSPOT_password_27, __DSPOT_tenant_28);
        FrontendSession o_testLogin_mg26_mg240_mg869__21 = fea.login(__DSPOT_user_124, __DSPOT_password_125, __DSPOT_tenant_126);
        assertNull(((FrontendSession) (o_testLogin_mg26_mg240_mg869__21)).getXsfrToken());
        assertNull(((FrontendSession) (o_testLogin_mg26_mg240_mg869__21)).getSession());
        assertEquals("=C]SG#JnI[]y <3bSwN_", ((FrontendSession) (o_testLogin_mg26_mg240_mg869__21)).getTenantId());
    }

    @Test(timeout = 30000)
    public void testLoginnull30_failAssert0null250_failAssert31null806_failAssert82() throws Exception {
        try {
            {
                {
                    FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                    FrontendSession frontEndSession = fea.login(null, null, "atos");
                    Assert.notNull(null);
                    org.junit.Assert.fail("testLoginnull30 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testLoginnull30_failAssert0null250 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLoginnull30_failAssert0null250_failAssert31null806 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull33_failAssert2litString218_failAssert66null820_failAssert92() throws Exception {
        try {
            {
                {
                    FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                    FrontendSession frontEndSession = fea.login("wp_admin", null, "wp_admin");
                    Assert.notNull(null);
                    org.junit.Assert.fail("testLoginnull33 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testLoginnull33_failAssert2litString218 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLoginnull33_failAssert2litString218_failAssert66null820 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid password", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLoginnull33_failAssert2litString218_failAssert66litString692_failAssert93() throws Exception {
        try {
            {
                {
                    FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                    FrontendSession frontEndSession = fea.login("wp_admin", "", "wp_admin");
                    Assert.notNull(null);
                    org.junit.Assert.fail("testLoginnull33 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testLoginnull33_failAssert2litString218 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLoginnull33_failAssert2litString218_failAssert66litString692 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLogin_mg26_mg240null889_failAssert103() throws Exception {
        try {
            String __DSPOT_tenant_28 = ")A6fdF&0xT!&b-W-(y_V";
            String __DSPOT_password_27 = "]]s%=])JWOM_4gdsL9rC";
            String __DSPOT_user_26 = ";&FZRy/=u eShD9P/&h4";
            String __DSPOT_tenant_4 = "l&{ha!&Bcvg[?i!rb0/|";
            String __DSPOT_password_3 = "_8;0L`A=SO/woO!OKS@R";
            String __DSPOT_user_2 = "l>UgIvC=TU&zgYc TM1`";
            FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
            FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
            Assert.notNull(frontEndSession);
            FrontendSession o_testLogin_mg26__9 = fea.login(null, __DSPOT_password_3, __DSPOT_tenant_4);
            FrontendSession o_testLogin_mg26_mg240__15 = fea.login(__DSPOT_user_26, __DSPOT_password_27, __DSPOT_tenant_28);
            org.junit.Assert.fail("testLogin_mg26_mg240null889 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLogin_mg26_mg240null892_failAssert104() throws Exception {
        try {
            String __DSPOT_tenant_28 = ")A6fdF&0xT!&b-W-(y_V";
            String __DSPOT_password_27 = "]]s%=])JWOM_4gdsL9rC";
            String __DSPOT_user_26 = ";&FZRy/=u eShD9P/&h4";
            String __DSPOT_tenant_4 = "l&{ha!&Bcvg[?i!rb0/|";
            String __DSPOT_password_3 = "_8;0L`A=SO/woO!OKS@R";
            String __DSPOT_user_2 = "l>UgIvC=TU&zgYc TM1`";
            FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
            FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
            Assert.notNull(frontEndSession);
            FrontendSession o_testLogin_mg26__9 = fea.login(__DSPOT_user_2, __DSPOT_password_3, __DSPOT_tenant_4);
            FrontendSession o_testLogin_mg26_mg240__15 = fea.login(null, __DSPOT_password_27, __DSPOT_tenant_28);
            org.junit.Assert.fail("testLogin_mg26_mg240null892 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLogin_mg26null256_failAssert3litString705_failAssert154() throws Exception {
        try {
            {
                String __DSPOT_tenant_4 = "l&{ha!&Bcvg[?i!rb0/|";
                String __DSPOT_password_3 = null;
                String __DSPOT_user_2 = "l>UgIvC=TU&zgYc TM1`";
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "\n");
                Assert.notNull(frontEndSession);
                FrontendSession o_testLogin_mg26__9 = fea.login(__DSPOT_user_2, __DSPOT_password_3, __DSPOT_tenant_4);
                org.junit.Assert.fail("testLogin_mg26null256 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLogin_mg26null256_failAssert3litString705 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid password", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testLogin_mg26null258_failAssert5litString685_failAssert157() throws Exception {
        try {
            {
                String __DSPOT_tenant_4 = "l&{ha!&Bcvg[?i!rb0/|";
                String __DSPOT_password_3 = "_8;0L`A=SO/woO!OKS@R";
                String __DSPOT_user_2 = "l>UgIvC=TU&zgYc TM1`";
                FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
                FrontendSession frontEndSession = fea.login(null, "9jqUuNrZ", ":");
                Assert.notNull(frontEndSession);
                FrontendSession o_testLogin_mg26__9 = fea.login(__DSPOT_user_2, __DSPOT_password_3, __DSPOT_tenant_4);
                org.junit.Assert.fail("testLogin_mg26null258 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testLogin_mg26null258_failAssert5litString685 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }
}

