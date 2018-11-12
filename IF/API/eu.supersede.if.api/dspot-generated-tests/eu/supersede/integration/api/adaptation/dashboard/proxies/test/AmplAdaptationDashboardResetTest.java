package eu.supersede.integration.api.adaptation.dashboard.proxies.test;


import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;


public class AmplAdaptationDashboardResetTest {
    private static AdaptationDashboardProxy<Object, Object> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AdaptationDashboardResetTest.proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg1_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Adaptation __DSPOT_a_0 = new Adaptation();
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                adaptation.compareTo(__DSPOT_a_0);
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboard_mg1 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 67: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/K(}", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg9_failAssert8() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Date __DSPOT_enactment_request_timestamp_8 = new Date();
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_8);
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboard_mg9 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 67: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/K(}", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg19_failAssert18() throws Exception {
        try {
            Date __DSPOT_enactment_completion_time_18 = new Date("&bk*201yCi*OdwpauR%h");
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_18);
            org.junit.Assert.fail("testResetDashboard_mg19 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg1_failAssert0_mg97_failAssert32() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Adaptation __DSPOT_a_22 = new Adaptation();
                    Adaptation __DSPOT_a_0 = new Adaptation();
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.compareTo(__DSPOT_a_0);
                    adaptation.compareTo(__DSPOT_a_22);
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboard_mg1 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testResetDashboard_mg1_failAssert0_mg97 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 67: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/K(}", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg1_failAssert0_mg141_failAssert46() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Date __DSPOT_enactment_request_timestamp_56 = new Date("uy}s#6CE3#^t lGvSzxk");
                    Adaptation __DSPOT_a_0 = new Adaptation();
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.compareTo(__DSPOT_a_0);
                    enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_56);
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboard_mg1 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testResetDashboard_mg1_failAssert0_mg141 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg1_failAssert0_mg170_failAssert56() throws Exception {
        try {
            {
                Date __DSPOT_enactment_completion_time_86 = new Date("&0xT!&b-W-(y_V1a;?h(");
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Adaptation __DSPOT_a_0 = new Adaptation();
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.compareTo(__DSPOT_a_0);
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboard_mg1 should have thrown URISyntaxException");
                enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_86);
            }
            org.junit.Assert.fail("testResetDashboard_mg1_failAssert0_mg170 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg9_failAssert8_rv230_failAssert110() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Date __DSPOT_enactment_request_timestamp_8 = new Date();
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    HttpStatus __DSPOT_invoc_18 = AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_8);
                    __DSPOT_invoc_18.value();
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                org.junit.Assert.fail("testResetDashboard_mg9 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testResetDashboard_mg9_failAssert8_rv230 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 67: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/K(}", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg19_failAssert18_mg148_failAssert141() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_64 = new Adaptation();
                Date __DSPOT_enactment_completion_time_18 = new Date("&bk*201yCi*OdwpauR%h");
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_18);
                org.junit.Assert.fail("testResetDashboard_mg19 should have thrown IllegalArgumentException");
                adaptation.compareTo(__DSPOT_a_64);
            }
            org.junit.Assert.fail("testResetDashboard_mg19_failAssert18_mg148 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg1_failAssert0_mg97_failAssert32_mg584_failAssert172() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        List<Action> __DSPOT_actions_95 = Collections.singletonList(new Action());
                        Adaptation __DSPOT_a_22 = new Adaptation();
                        Adaptation __DSPOT_a_0 = new Adaptation();
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.compareTo(__DSPOT_a_0);
                        adaptation.compareTo(__DSPOT_a_22);
                        adaptation.setActions(__DSPOT_actions_95);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testResetDashboard_mg1 should have thrown URISyntaxException");
                }
                org.junit.Assert.fail("testResetDashboard_mg1_failAssert0_mg97 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testResetDashboard_mg1_failAssert0_mg97_failAssert32_mg584 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 67: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/K(}", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg19_failAssert18_mg148_failAssert141_mg636_failAssert194() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_a_64 = new Adaptation();
                    Date __DSPOT_enactment_completion_time_18 = new Date("&bk*201yCi*OdwpauR%h");
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        List<Action> __DSPOT_actions_131 = Collections.singletonList(new Action());
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.setActions(__DSPOT_actions_131);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_18);
                    org.junit.Assert.fail("testResetDashboard_mg19 should have thrown IllegalArgumentException");
                    adaptation.compareTo(__DSPOT_a_64);
                }
                org.junit.Assert.fail("testResetDashboard_mg19_failAssert18_mg148 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testResetDashboard_mg19_failAssert18_mg148_failAssert141_mg636 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg1_failAssert0_mg141_failAssert46_mg613_failAssert195() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        List<Action> __DSPOT_actions_110 = Collections.singletonList(new Action());
                        Date __DSPOT_enactment_request_timestamp_56 = new Date("uy}s#6CE3#^t lGvSzxk");
                        Adaptation __DSPOT_a_0 = new Adaptation();
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.compareTo(__DSPOT_a_0);
                        enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_56);
                        adaptation.setActions(__DSPOT_actions_110);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testResetDashboard_mg1 should have thrown URISyntaxException");
                }
                org.junit.Assert.fail("testResetDashboard_mg1_failAssert0_mg141 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testResetDashboard_mg1_failAssert0_mg141_failAssert46_mg613 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg1_failAssert0_mg170_failAssert56null879_failAssert196() throws Exception {
        try {
            {
                {
                    Date __DSPOT_enactment_completion_time_86 = new Date("&0xT!&b-W-(y_V1a;?h(");
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Adaptation __DSPOT_a_0 = new Adaptation();
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.compareTo(__DSPOT_a_0);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testResetDashboard_mg1 should have thrown URISyntaxException");
                    enactment.setEnactment_completion_time(null);
                }
                org.junit.Assert.fail("testResetDashboard_mg1_failAssert0_mg170 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testResetDashboard_mg1_failAssert0_mg170_failAssert56null879 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg9_failAssert8_rv230_failAssert110_mg585_failAssert255() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        List<Action> __DSPOT_actions_96 = Collections.singletonList(new Action());
                        Date __DSPOT_enactment_request_timestamp_8 = new Date();
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        HttpStatus __DSPOT_invoc_18 = AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_8);
                        __DSPOT_invoc_18.value();
                        adaptation.setActions(__DSPOT_actions_96);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testResetDashboard_mg9 should have thrown URISyntaxException");
                }
                org.junit.Assert.fail("testResetDashboard_mg9_failAssert8_rv230 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testResetDashboard_mg9_failAssert8_rv230_failAssert110_mg585 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 67: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/K(}", expected.getMessage());
        }
    }

    private Adaptation createAtosAdaptation() {
        Adaptation adaptation = new Adaptation();
        String id = "1241";
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

    private Adaptation createSiemensAdaptation() {
        Adaptation adaptation = new Adaptation();
        String id = "1238";
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

