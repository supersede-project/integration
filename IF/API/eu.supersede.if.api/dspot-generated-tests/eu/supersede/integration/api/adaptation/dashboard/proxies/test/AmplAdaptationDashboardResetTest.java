package eu.supersede.integration.api.adaptation.dashboard.proxies.test;


import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;


public class AmplAdaptationDashboardResetTest {
    private static AdaptationDashboardProxy<Object, Object> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplAdaptationDashboardResetTest.proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
    }

    @Test(timeout = 240000)
    public void testResetDashboard_mg23() throws Exception {
        Adaptation __DSPOT_a_397 = new Adaptation();
        List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation(1);
        adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        adaptation = createSiemensAdaptation(2);
        adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        int o_testResetDashboard_mg23__40 = adaptation.compareTo(__DSPOT_a_397);
        assertEquals(0, ((int) (o_testResetDashboard_mg23__40)));
    }

    @Test(timeout = 240000)
    public void testResetDashboardlitNum1_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(2);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboardlitNum1 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull34_failAssert2() throws Exception {
        try {
            List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(null);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboardnull34 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull35_failAssert3() throws Exception {
        try {
            List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboardnull35 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull36_failAssert4() throws Exception {
        try {
            List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboardnull36 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull37_failAssert5() throws Exception {
        try {
            List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(null);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboardnull37 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull38_failAssert6() throws Exception {
        try {
            List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(null);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboardnull38 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull39_failAssert7() throws Exception {
        try {
            List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(null);
            adaptation = createSiemensAdaptation(2);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboardnull39 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8() throws Exception {
        try {
            List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation(null);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull41_failAssert9() throws Exception {
        try {
            List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboardnull41 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull43_failAssert11() throws Exception {
        try {
            List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(null);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboardnull43 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull44_failAssert12() throws Exception {
        try {
            List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(null);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboardnull44 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull34_failAssert2_mg288_failAssert14() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    List<Action> __DSPOT_actions_419 = Collections.singletonList(new Action());
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.setActions(__DSPOT_actions_419);
                }
                Adaptation adaptation = createAtosAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull34 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull34_failAssert2_mg288 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8_mg231_failAssert15() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    List<Action> __DSPOT_actions_409 = Collections.singletonList(new Action());
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.setActions(__DSPOT_actions_409);
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8_mg231 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8_mg285_failAssert19() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Adaptation __DSPOT_adaptation_417 = new Adaptation();
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    enactment.setAdaptation(__DSPOT_adaptation_417);
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8_mg285 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull34_failAssert2_mg279_failAssert23() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Adaptation __DSPOT_a_414 = new Adaptation();
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.compareTo(__DSPOT_a_414);
                }
                Adaptation adaptation = createAtosAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull34 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull34_failAssert2_mg279 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8_mg214_failAssert24() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Adaptation __DSPOT_a_408 = new Adaptation();
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.compareTo(__DSPOT_a_408);
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8_mg214 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull34_failAssert2_mg374_failAssert26() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_503 = new Adaptation();
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull34 should have thrown HttpMessageNotWritableException");
                adaptation.compareTo(__DSPOT_a_503);
            }
            org.junit.Assert.fail("testResetDashboardnull34_failAssert2_mg374 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8_mg250_failAssert32() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Date __DSPOT_computation_timestamp_410 = new Date("v)|C5[:S!JtD+ D$[[io");
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_410);
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8_mg250 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull34_failAssert2_mg428_failAssert33() throws Exception {
        try {
            {
                Date __DSPOT_enactment_request_timestamp_558 = new Date(241178108L);
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull34 should have thrown HttpMessageNotWritableException");
                enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_558);
            }
            org.junit.Assert.fail("testResetDashboardnull34_failAssert2_mg428 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8_rv578_failAssert40() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    HttpStatus __DSPOT_invoc_16 = AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    __DSPOT_invoc_16.is1xxInformational();
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8_rv578 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8_rv613_failAssert47() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    HttpStatus __DSPOT_invoc_16 = AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    __DSPOT_invoc_16.is4xxClientError();
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8_rv613 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8null739_failAssert88() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(null);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8null739 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8null747_failAssert89() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(null);
                adaptation = createSiemensAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8null747 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull34_failAssert2null669_failAssert92() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(null);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull34 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull34_failAssert2null669 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8null732_failAssert101() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(null);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8null732 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8null721_failAssert103() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(null);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(null);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8null721 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardlitNum1_failAssert0null827_failAssert104() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(null);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardlitNum1 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testResetDashboardlitNum1_failAssert0null827 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardlitNum1_failAssert0null837_failAssert106() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(null);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardlitNum1 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testResetDashboardlitNum1_failAssert0null837 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardlitNum1_failAssert0null888_failAssert109() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(null);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardlitNum1 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testResetDashboardlitNum1_failAssert0null888 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardlitNum1_failAssert0null860_failAssert110() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(null);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardlitNum1 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testResetDashboardlitNum1_failAssert0null860 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardlitNum1_failAssert0null852_failAssert111() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(null);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardlitNum1 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testResetDashboardlitNum1_failAssert0null852 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardlitNum1_failAssert0null899_failAssert113() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(null);
                org.junit.Assert.fail("testResetDashboardlitNum1 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testResetDashboardlitNum1_failAssert0null899 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull35_failAssert3null803_failAssert114() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(null);
                Assert.notNull(null);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull35 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull35_failAssert3null803 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull37_failAssert5null881_failAssert125() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(null);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(null);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull37 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull37_failAssert5null881 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull43_failAssert11null883_failAssert132() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(null);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(null);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull43 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull43_failAssert11null883 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull38_failAssert6null868_failAssert149() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(null);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(null);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboardnull38 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull38_failAssert6null868 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8_mg231_failAssert15_mg1557_failAssert193() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        List<Action> __DSPOT_actions_814 = Collections.singletonList(new Action());
                        List<Action> __DSPOT_actions_409 = Collections.singletonList(new Action());
                        Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.setActions(__DSPOT_actions_409);
                        adaptation.setActions(__DSPOT_actions_814);
                    }
                    Adaptation adaptation = createAtosAdaptation(1);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation(null);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
                }
                org.junit.Assert.fail("testResetDashboardnull40_failAssert8_mg231 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8_mg231_failAssert15_mg1557 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull34_failAssert2_mg288_failAssert14_mg1444_failAssert194() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        List<Action> __DSPOT_actions_711 = Collections.<Action>emptyList();
                        List<Action> __DSPOT_actions_419 = Collections.singletonList(new Action());
                        Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.setActions(__DSPOT_actions_419);
                        adaptation.setActions(__DSPOT_actions_711);
                    }
                    Adaptation adaptation = createAtosAdaptation(null);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation(2);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testResetDashboardnull34 should have thrown HttpMessageNotWritableException");
                }
                org.junit.Assert.fail("testResetDashboardnull34_failAssert2_mg288 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull34_failAssert2_mg288_failAssert14_mg1444 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8_mg285_failAssert19_mg1398_failAssert196() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        List<Action> __DSPOT_actions_684 = Collections.singletonList(new Action());
                        Adaptation __DSPOT_adaptation_417 = new Adaptation();
                        Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        enactment.setAdaptation(__DSPOT_adaptation_417);
                        adaptation.setActions(__DSPOT_actions_684);
                    }
                    Adaptation adaptation = createAtosAdaptation(1);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation(null);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
                }
                org.junit.Assert.fail("testResetDashboardnull40_failAssert8_mg285 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8_mg285_failAssert19_mg1398 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull34_failAssert2_mg288_failAssert14_mg1565_failAssert197() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Adaptation __DSPOT_adaptation_821 = new Adaptation();
                        List<Action> __DSPOT_actions_419 = Collections.singletonList(new Action());
                        Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.setActions(__DSPOT_actions_419);
                        enactment.setAdaptation(__DSPOT_adaptation_821);
                    }
                    Adaptation adaptation = createAtosAdaptation(null);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation(2);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testResetDashboardnull34 should have thrown HttpMessageNotWritableException");
                }
                org.junit.Assert.fail("testResetDashboardnull34_failAssert2_mg288 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull34_failAssert2_mg288_failAssert14_mg1565 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull34_failAssert2_mg279_failAssert23_mg1497_failAssert204() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        List<Action> __DSPOT_actions_754 = Collections.singletonList(new Action());
                        Adaptation __DSPOT_a_414 = new Adaptation();
                        Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.compareTo(__DSPOT_a_414);
                        adaptation.setActions(__DSPOT_actions_754);
                    }
                    Adaptation adaptation = createAtosAdaptation(null);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation(2);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testResetDashboardnull34 should have thrown HttpMessageNotWritableException");
                }
                org.junit.Assert.fail("testResetDashboardnull34_failAssert2_mg279 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull34_failAssert2_mg279_failAssert23_mg1497 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8_mg231_failAssert15_mg1469_failAssert205() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Adaptation __DSPOT_a_730 = new Adaptation();
                        List<Action> __DSPOT_actions_409 = Collections.singletonList(new Action());
                        Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.setActions(__DSPOT_actions_409);
                        adaptation.compareTo(__DSPOT_a_730);
                    }
                    Adaptation adaptation = createAtosAdaptation(1);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation(null);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
                }
                org.junit.Assert.fail("testResetDashboardnull40_failAssert8_mg231 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8_mg231_failAssert15_mg1469 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull40_failAssert8_rv613_failAssert47_mg1437_failAssert261() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        List<Action> __DSPOT_actions_708 = Collections.<Action>emptyList();
                        Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        HttpStatus __DSPOT_invoc_16 = AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        __DSPOT_invoc_16.is4xxClientError();
                        adaptation.setActions(__DSPOT_actions_708);
                    }
                    Adaptation adaptation = createAtosAdaptation(1);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation(null);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testResetDashboardnull40 should have thrown HttpMessageNotWritableException");
                }
                org.junit.Assert.fail("testResetDashboardnull40_failAssert8_rv613 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull40_failAssert8_rv613_failAssert47_mg1437 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testResetDashboardnull34_failAssert2_mg428_failAssert33_mg1549_failAssert272() throws Exception {
        try {
            {
                {
                    Date __DSPOT_enactment_request_timestamp_558 = new Date(241178108L);
                    List<Adaptation> adaptations = AmplAdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Date __DSPOT_enactment_request_timestamp_806 = new Date();
                        Enactment enactment = AmplAdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AmplAdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AmplAdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_806);
                    }
                    Adaptation adaptation = createAtosAdaptation(null);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation(2);
                    adaptation = AmplAdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AmplAdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testResetDashboardnull34 should have thrown HttpMessageNotWritableException");
                    enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_558);
                }
                org.junit.Assert.fail("testResetDashboardnull34_failAssert2_mg428 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull34_failAssert2_mg428_failAssert33_mg1549 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    private Adaptation createAtosAdaptation(Integer id) {
        Adaptation adaptation = new Adaptation();
        adaptation.setFc_id(id);
        Calendar computation = Calendar.getInstance();
        adaptation.setComputation_timestamp(computation.getTime());
        adaptation.setModel_system(ModelSystem.Atos_HSK);
        adaptation.setName((((ModelSystem.Atos_HSK) + " ") + id));
        adaptation.setRank(1.0);
        adaptation.getActions().add(createLowLoadAction());
        adaptation.getActions().add(createHSKAction());
        adaptation.getActions().add(createCREAction());
        return adaptation;
    }

    private Action createCREAction() {
        Action action = new Action();
        action.setAction_id("cre_8739");
        action.setDescription("Content Searching Index Engine in single VM");
        action.setName("CRE");
        action.setEnabled(true);
        return action;
    }

    private Action createHSKAction() {
        Action action = new Action();
        action.setAction_id("hsk_8273");
        action.setDescription("Players - Smart platform Handshake service in single VM");
        action.setName("HSK");
        action.setEnabled(true);
        return action;
    }

    private Action createLowLoadAction() {
        Action action = new Action();
        action.setAction_id("lowloadconfigurationinvm2_a");
        action.setDescription("Low load configuration for HSK service in single VM");
        action.setName("LowLoadConfigurationinVM2_A");
        action.setEnabled(true);
        return action;
    }

    private Enactment createAtosEnactment(Adaptation adaptation) {
        Enactment enactment = new Enactment();
        enactment.setFc_id(adaptation.getFc_id());
        Calendar completion_time = Calendar.getInstance();
        Calendar request_time = Calendar.getInstance();
        request_time.add(Calendar.MINUTE, 5);
        completion_time.setTimeInMillis(60000);
        enactment.setEnactment_completion_time(completion_time.getTime());
        enactment.setEnactment_request_time(request_time.getTime());
        enactment.setResult(true);
        return enactment;
    }

    private Adaptation createSiemensAdaptation(Integer id) {
        Adaptation adaptation = new Adaptation();
        adaptation.setFc_id(id);
        Calendar computation = Calendar.getInstance();
        computation.add(Calendar.MINUTE, 10);
        adaptation.setComputation_timestamp(computation.getTime());
        adaptation.setModel_system(ModelSystem.Siemens);
        adaptation.setName((((ModelSystem.Siemens) + " ") + id));
        adaptation.setRank(1.0);
        adaptation.getActions().add(createSiemensAction());
        return adaptation;
    }

    private Action createSiemensAction() {
        Action action = new Action();
        action.setAction_id("c1");
        action.setDescription("GetMetheorologicalData composition for 90% availability");
        action.setName("SC1");
        action.setEnabled(true);
        return action;
    }

    private Enactment createSiemensEnactment(Adaptation adaptation) {
        Enactment enactment = new Enactment();
        enactment.setFc_id(adaptation.getFc_id());
        Calendar completion_time = Calendar.getInstance();
        Calendar request_time = Calendar.getInstance();
        request_time.add(Calendar.MINUTE, 6);
        completion_time.setTimeInMillis(30000);
        enactment.setEnactment_completion_time(completion_time.getTime());
        enactment.setEnactment_request_time(request_time.getTime());
        enactment.setResult(true);
        return enactment;
    }
}

