package eu.supersede.integration.api.adaptation.dashboard.proxies.test;


import ModelSystem.Atos_HSK;
import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class AmplAdaptationDashboardProxyTest {
    private static AdaptationDashboardProxy<Object, Object> proxy;

    private static String adaptationId;

    private static String enactmentId;

    @BeforeClass
    public static void setup() throws Exception {
        AdaptationDashboardProxyTest.proxy = new AdaptationDashboardProxy("adaptation", "adaptation", "atos");
        List<Adaptation> adaptations = AdaptationDashboardProxyTest.proxy.getAllAdaptations();
        Assert.notEmpty(adaptations);
        AdaptationDashboardProxyTest.adaptationId = adaptations.get(0).getFc_id();
        Assert.notNull(AdaptationDashboardProxyTest.adaptationId);
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg2056() throws Exception {
        Adaptation __DSPOT_a_297 = new Adaptation();
        Adaptation adaptation = createAdaptation("905");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptation_mg2056__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        org.junit.Assert.assertEquals("OK", ((HttpStatus) (o_testGetAdaptation_mg2056__12)).getReasonPhrase());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testGetAdaptation_mg2056__12)).is1xxInformational());
        org.junit.Assert.assertTrue(((HttpStatus) (o_testGetAdaptation_mg2056__12)).is2xxSuccessful());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testGetAdaptation_mg2056__12)).is3xxRedirection());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testGetAdaptation_mg2056__12)).is4xxClientError());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testGetAdaptation_mg2056__12)).is5xxServerError());
        org.junit.Assert.assertEquals("200", ((HttpStatus) (o_testGetAdaptation_mg2056__12)).toString());
        int o_testGetAdaptation_mg2056__14 = adaptation.compareTo(__DSPOT_a_297);
        org.junit.Assert.assertEquals(0, ((int) (o_testGetAdaptation_mg2056__14)));
        org.junit.Assert.assertEquals("OK", ((HttpStatus) (o_testGetAdaptation_mg2056__12)).getReasonPhrase());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testGetAdaptation_mg2056__12)).is1xxInformational());
        org.junit.Assert.assertTrue(((HttpStatus) (o_testGetAdaptation_mg2056__12)).is2xxSuccessful());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testGetAdaptation_mg2056__12)).is3xxRedirection());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testGetAdaptation_mg2056__12)).is4xxClientError());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testGetAdaptation_mg2056__12)).is5xxServerError());
        org.junit.Assert.assertEquals("200", ((HttpStatus) (o_testGetAdaptation_mg2056__12)).toString());
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg2056litString2146_failAssert416() throws Exception {
        try {
            Adaptation __DSPOT_a_297 = new Adaptation();
            Adaptation adaptation = createAdaptation("");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptation_mg2056__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptation_mg2056__14 = adaptation.compareTo(__DSPOT_a_297);
            org.junit.Assert.fail("testGetAdaptation_mg2056litString2146 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg2056litString2146_failAssert416_mg2562_failAssert555() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_355 = new Adaptation();
                Adaptation __DSPOT_a_297 = new Adaptation();
                Adaptation adaptation = createAdaptation("");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                HttpStatus o_testGetAdaptation_mg2056__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testGetAdaptation_mg2056__14 = adaptation.compareTo(__DSPOT_a_297);
                org.junit.Assert.fail("testGetAdaptation_mg2056litString2146 should have thrown HttpMessageNotReadableException");
                __DSPOT_a_297.compareTo(__DSPOT_a_355);
            }
            org.junit.Assert.fail("testGetAdaptation_mg2056litString2146_failAssert416_mg2562 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg2056null2253_failAssert418() throws Exception {
        try {
            Adaptation __DSPOT_a_297 = new Adaptation();
            Adaptation adaptation = createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptation_mg2056__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptation_mg2056__14 = adaptation.compareTo(__DSPOT_a_297);
            org.junit.Assert.fail("testGetAdaptation_mg2056null2253 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg2056null2253_failAssert418_mg2562_failAssert571() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_352 = new Adaptation();
                Adaptation __DSPOT_a_297 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                HttpStatus o_testGetAdaptation_mg2056__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testGetAdaptation_mg2056__14 = adaptation.compareTo(__DSPOT_a_297);
                org.junit.Assert.fail("testGetAdaptation_mg2056null2253 should have thrown HttpMessageNotReadableException");
                __DSPOT_a_297.compareTo(__DSPOT_a_352);
            }
            org.junit.Assert.fail("testGetAdaptation_mg2056null2253_failAssert418_mg2562 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg2056null2253_failAssert418_mg2571_failAssert573() throws Exception {
        try {
            {
                Date __DSPOT_computation_timestamp_361 = new Date("gIevY]dkqSht.80@MCF3");
                Adaptation __DSPOT_a_297 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                HttpStatus o_testGetAdaptation_mg2056__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testGetAdaptation_mg2056__14 = adaptation.compareTo(__DSPOT_a_297);
                org.junit.Assert.fail("testGetAdaptation_mg2056null2253 should have thrown HttpMessageNotReadableException");
                __DSPOT_a_297.setComputation_timestamp(__DSPOT_computation_timestamp_361);
            }
            org.junit.Assert.fail("testGetAdaptation_mg2056null2253_failAssert418_mg2571 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg2056null2253_failAssert418_mg2592_failAssert577() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_382 = new Adaptation();
                Adaptation __DSPOT_a_297 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                HttpStatus o_testGetAdaptation_mg2056__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testGetAdaptation_mg2056__14 = adaptation.compareTo(__DSPOT_a_297);
                org.junit.Assert.fail("testGetAdaptation_mg2056null2253 should have thrown HttpMessageNotReadableException");
                adaptation.compareTo(__DSPOT_a_382);
            }
            org.junit.Assert.fail("testGetAdaptation_mg2056null2253_failAssert418_mg2592 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2048_failAssert405() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("Medium load configuration for HSK service");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationlitString2048 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            org.junit.Assert.assertEquals("Illegal character in path at index 72: http://supersede.es.atos.net:8080/adaptation-dashboard/adaptation/Medium load configuration for HSK service", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2048_failAssert405_mg2147_failAssert424() throws Exception {
        try {
            {
                Date __DSPOT_computation_timestamp_315 = new Date("P]M{.a6Z;:gn%A;>)zto");
                Adaptation adaptation = createAdaptation("Medium load configuration for HSK service");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testGetAdaptationlitString2048 should have thrown URISyntaxException");
                adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_315);
            }
            org.junit.Assert.fail("testGetAdaptationlitString2048_failAssert405_mg2147 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2049() throws Exception {
        Adaptation adaptation = createAdaptation("j05");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptationlitString2049__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        org.junit.Assert.assertEquals("OK", ((HttpStatus) (o_testGetAdaptationlitString2049__10)).getReasonPhrase());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testGetAdaptationlitString2049__10)).is1xxInformational());
        org.junit.Assert.assertTrue(((HttpStatus) (o_testGetAdaptationlitString2049__10)).is2xxSuccessful());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testGetAdaptationlitString2049__10)).is3xxRedirection());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testGetAdaptationlitString2049__10)).is4xxClientError());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testGetAdaptationlitString2049__10)).is5xxServerError());
        org.junit.Assert.assertEquals("200", ((HttpStatus) (o_testGetAdaptationlitString2049__10)).toString());
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2049_mg2133() throws Exception {
        Adaptation __DSPOT_a_306 = new Adaptation();
        Adaptation adaptation = createAdaptation("j05");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptationlitString2049__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testGetAdaptationlitString2049_mg2133__16 = adaptation.compareTo(__DSPOT_a_306);
        org.junit.Assert.assertEquals(0, ((int) (o_testGetAdaptationlitString2049_mg2133__16)));
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2049_mg2133_mg2567() throws Exception {
        Adaptation __DSPOT_a_357 = new Adaptation();
        Adaptation __DSPOT_a_306 = new Adaptation();
        Adaptation adaptation = createAdaptation("j05");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptationlitString2049__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testGetAdaptationlitString2049_mg2133__16 = adaptation.compareTo(__DSPOT_a_306);
        int o_testGetAdaptationlitString2049_mg2133_mg2567__21 = __DSPOT_a_306.compareTo(__DSPOT_a_357);
        org.junit.Assert.assertEquals(0, ((int) (o_testGetAdaptationlitString2049_mg2133_mg2567__21)));
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2049_mg2133null2645_failAssert528() throws Exception {
        try {
            Adaptation __DSPOT_a_306 = new Adaptation();
            Adaptation adaptation = createAdaptation("j05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptationlitString2049__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptationlitString2049_mg2133__16 = adaptation.compareTo(__DSPOT_a_306);
            org.junit.Assert.fail("testGetAdaptationlitString2049_mg2133null2645 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2049_mg2133null2647_failAssert529() throws Exception {
        try {
            Adaptation __DSPOT_a_306 = new Adaptation();
            Adaptation adaptation = createAdaptation("j05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptationlitString2049__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptationlitString2049_mg2133__16 = adaptation.compareTo(__DSPOT_a_306);
            org.junit.Assert.fail("testGetAdaptationlitString2049_mg2133null2647 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2049_mg2133null2649_failAssert530() throws Exception {
        try {
            Adaptation __DSPOT_a_306 = new Adaptation();
            Adaptation adaptation = createAdaptation("j05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(null);
            HttpStatus o_testGetAdaptationlitString2049__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptationlitString2049_mg2133__16 = adaptation.compareTo(__DSPOT_a_306);
            org.junit.Assert.fail("testGetAdaptationlitString2049_mg2133null2649 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2049null2185_failAssert412() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("j05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptationlitString2049__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationlitString2049null2185 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2049null2190_failAssert413() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("j05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptationlitString2049__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationlitString2049null2190 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2049null2194_failAssert414() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("j05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(null);
            HttpStatus o_testGetAdaptationlitString2049__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationlitString2049null2194 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2053_failAssert406() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationlitString2053 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString2053_failAssert406_rv2156_failAssert447() throws Exception {
        try {
            {
                Adaptation adaptation = createAdaptation("");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                HttpStatus __DSPOT_invoc_12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testGetAdaptationlitString2053 should have thrown HttpMessageNotReadableException");
                __DSPOT_invoc_12.is1xxInformational();
            }
            org.junit.Assert.fail("testGetAdaptationlitString2053_failAssert406_rv2156 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationnull2062_failAssert408() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationnull2062 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationnull2063_failAssert409() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationnull2063 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationnull2065_failAssert411() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(null);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationnull2065 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg1769() throws Exception {
        Adaptation __DSPOT_a_271 = new Adaptation();
        Adaptation adaptation = createAdaptation("905");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptation_mg1769__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testGetAdaptation_mg1769__12)).toString());
        int o_testGetAdaptation_mg1769__14 = adaptation.compareTo(__DSPOT_a_271);
        org.junit.Assert.assertEquals(0, ((int) (o_testGetAdaptation_mg1769__14)));
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testGetAdaptation_mg1769__12)).toString());
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg9_mg151_failAssert11() throws Exception {
        try {
            Date __DSPOT_computation_timestamp_44 = new Date("p!#I]LDWP=,y4JV)d4}^");
            Adaptation __DSPOT_a_0 = new Adaptation();
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptation_mg9__8 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptation_mg9__10 = adaptation.compareTo(__DSPOT_a_0);
            adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_44);
            org.junit.Assert.fail("testAddAdaptation_mg9_mg151 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg9_mg151_failAssert11_mg468_failAssert109() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_101 = new Adaptation();
                Date __DSPOT_computation_timestamp_44 = new Date("p!#I]LDWP=,y4JV)d4}^");
                Adaptation __DSPOT_a_0 = new Adaptation();
                Adaptation adaptation = createAdaptation("905");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                HttpStatus o_testAddAdaptation_mg9__8 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testAddAdaptation_mg9__10 = adaptation.compareTo(__DSPOT_a_0);
                adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_44);
                org.junit.Assert.fail("testAddAdaptation_mg9_mg151 should have thrown IllegalArgumentException");
                __DSPOT_a_0.compareTo(__DSPOT_a_101);
            }
            org.junit.Assert.fail("testAddAdaptation_mg9_mg151_failAssert11_mg468 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg9_mg151_failAssert11_mg493_failAssert116() throws Exception {
        try {
            {
                List<Action> __DSPOT_actions_113 = Collections.singletonList(new Action());
                Date __DSPOT_computation_timestamp_44 = new Date("p!#I]LDWP=,y4JV)d4}^");
                Adaptation __DSPOT_a_0 = new Adaptation();
                Adaptation adaptation = createAdaptation("905");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                HttpStatus o_testAddAdaptation_mg9__8 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testAddAdaptation_mg9__10 = adaptation.compareTo(__DSPOT_a_0);
                adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_44);
                org.junit.Assert.fail("testAddAdaptation_mg9_mg151 should have thrown IllegalArgumentException");
                adaptation.setActions(__DSPOT_actions_113);
            }
            org.junit.Assert.fail("testAddAdaptation_mg9_mg151_failAssert11_mg493 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg9null162_failAssert12() throws Exception {
        try {
            Adaptation __DSPOT_a_0 = new Adaptation();
            Adaptation adaptation = createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptation_mg9__8 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptation_mg9__10 = adaptation.compareTo(__DSPOT_a_0);
            org.junit.Assert.fail("testAddAdaptation_mg9null162 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg9null162_failAssert12_mg403_failAssert126() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_54 = new Adaptation();
                Adaptation __DSPOT_a_0 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                HttpStatus o_testAddAdaptation_mg9__8 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testAddAdaptation_mg9__10 = adaptation.compareTo(__DSPOT_a_0);
                org.junit.Assert.fail("testAddAdaptation_mg9null162 should have thrown HttpMessageNotReadableException");
                __DSPOT_a_0.compareTo(__DSPOT_a_54);
            }
            org.junit.Assert.fail("testAddAdaptation_mg9null162_failAssert12_mg403 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2_mg75() throws Exception {
        Adaptation __DSPOT_a_8 = new Adaptation();
        Adaptation adaptation = createAdaptation("k05");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptationlitString2_mg75__12 = adaptation.compareTo(__DSPOT_a_8);
        org.junit.Assert.assertEquals(0, ((int) (o_testAddAdaptationlitString2_mg75__12)));
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2_mg75_mg400() throws Exception {
        Adaptation __DSPOT_a_51 = new Adaptation();
        Adaptation __DSPOT_a_8 = new Adaptation();
        Adaptation adaptation = createAdaptation("k05");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptationlitString2_mg75__12 = adaptation.compareTo(__DSPOT_a_8);
        int o_testAddAdaptationlitString2_mg75_mg400__17 = __DSPOT_a_8.compareTo(__DSPOT_a_51);
        org.junit.Assert.assertEquals(0, ((int) (o_testAddAdaptationlitString2_mg75_mg400__17)));
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2_mg75_mg439() throws Exception {
        Adaptation __DSPOT_a_80 = new Adaptation();
        Adaptation __DSPOT_a_8 = new Adaptation();
        Adaptation adaptation = createAdaptation("k05");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptationlitString2_mg75__12 = adaptation.compareTo(__DSPOT_a_8);
        int o_testAddAdaptationlitString2_mg75_mg439__17 = adaptation.compareTo(__DSPOT_a_80);
        org.junit.Assert.assertEquals(0, ((int) (o_testAddAdaptationlitString2_mg75_mg439__17)));
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2_mg75null479_failAssert74() throws Exception {
        try {
            Adaptation __DSPOT_a_8 = new Adaptation();
            Adaptation adaptation = createAdaptation("k05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptationlitString2_mg75__12 = adaptation.compareTo(__DSPOT_a_8);
            org.junit.Assert.fail("testAddAdaptationlitString2_mg75null479 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2_mg75null483_failAssert75() throws Exception {
        try {
            Adaptation __DSPOT_a_8 = new Adaptation();
            Adaptation adaptation = createAdaptation("k05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptationlitString2_mg75__12 = adaptation.compareTo(__DSPOT_a_8);
            org.junit.Assert.fail("testAddAdaptationlitString2_mg75null483 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2null116_failAssert5() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("k05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationlitString2null116 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2null119_failAssert6() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("k05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationlitString2null119 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString6_mg74() throws Exception {
        Adaptation __DSPOT_a_7 = new Adaptation();
        Adaptation adaptation = createAdaptation("");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitString6__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptationlitString6_mg74__12 = adaptation.compareTo(__DSPOT_a_7);
        org.junit.Assert.assertEquals(0, ((int) (o_testAddAdaptationlitString6_mg74__12)));
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString6_mg74_mg398() throws Exception {
        Adaptation __DSPOT_a_48 = new Adaptation();
        Adaptation __DSPOT_a_7 = new Adaptation();
        Adaptation adaptation = createAdaptation("");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitString6__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptationlitString6_mg74__12 = adaptation.compareTo(__DSPOT_a_7);
        int o_testAddAdaptationlitString6_mg74_mg398__17 = __DSPOT_a_7.compareTo(__DSPOT_a_48);
        org.junit.Assert.assertEquals(0, ((int) (o_testAddAdaptationlitString6_mg74_mg398__17)));
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString6_mg74_mg410_failAssert76() throws Exception {
        try {
            Date __DSPOT_computation_timestamp_58 = new Date("yc.L`HJ*J8r}4@(!YL#Z");
            Adaptation __DSPOT_a_7 = new Adaptation();
            Adaptation adaptation = createAdaptation("");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptationlitString6__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptationlitString6_mg74__12 = adaptation.compareTo(__DSPOT_a_7);
            __DSPOT_a_7.setComputation_timestamp(__DSPOT_computation_timestamp_58);
            org.junit.Assert.fail("testAddAdaptationlitString6_mg74_mg410 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationnull15_failAssert2_mg73_failAssert32() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_6 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddAdaptationnull15 should have thrown HttpMessageNotReadableException");
                adaptation.compareTo(__DSPOT_a_6);
            }
            org.junit.Assert.fail("testAddAdaptationnull15_failAssert2_mg73 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAllEnactmentsnull2856_failAssert594() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(null);
            org.junit.Assert.fail("testGetAllEnactmentsnull2856 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2859_failAssert595() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
            Assert.notNull(enactment);
            org.junit.Assert.fail("testGetEnactmentlitNum2859 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2859_failAssert595_mg2899_failAssert608() throws Exception {
        try {
            {
                Adaptation __DSPOT_adaptation_423 = new Adaptation();
                List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                Assert.notNull(enactment);
                org.junit.Assert.fail("testGetEnactmentlitNum2859 should have thrown HttpMessageNotReadableException");
                enactment.setAdaptation(__DSPOT_adaptation_423);
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2859_failAssert595_mg2899 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2859_failAssert595_mg2899_failAssert608null3034_failAssert636() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_adaptation_423 = new Adaptation();
                    List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(null);
                    Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testGetEnactmentlitNum2859 should have thrown HttpMessageNotReadableException");
                    enactment.setAdaptation(__DSPOT_adaptation_423);
                }
                org.junit.Assert.fail("testGetEnactmentlitNum2859_failAssert595_mg2899 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2859_failAssert595_mg2899_failAssert608null3034 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2859_failAssert595_mg2899_failAssert608null3036_failAssert637() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_adaptation_423 = new Adaptation();
                    List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(enactments);
                    Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetEnactmentlitNum2859 should have thrown HttpMessageNotReadableException");
                    enactment.setAdaptation(__DSPOT_adaptation_423);
                }
                org.junit.Assert.fail("testGetEnactmentlitNum2859_failAssert595_mg2899 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2859_failAssert595_mg2899_failAssert608null3036 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2859_failAssert595_mg2899_failAssert608null3038_failAssert638() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_adaptation_423 = new Adaptation();
                    List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(enactments);
                    Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testGetEnactmentlitNum2859 should have thrown HttpMessageNotReadableException");
                    enactment.setAdaptation(null);
                }
                org.junit.Assert.fail("testGetEnactmentlitNum2859_failAssert595_mg2899 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2859_failAssert595_mg2899_failAssert608null3038 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2859_failAssert595_mg2905_failAssert609() throws Exception {
        try {
            {
                Date __DSPOT_enactment_completion_time_427 = new Date(1988081927, 465676655, -280315724, 429569602, 252700099);
                List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                Assert.notNull(enactment);
                org.junit.Assert.fail("testGetEnactmentlitNum2859 should have thrown HttpMessageNotReadableException");
                enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_427);
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2859_failAssert595_mg2905 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2859_failAssert595null2920_failAssert613() throws Exception {
        try {
            {
                List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(null);
                Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                Assert.notNull(enactment);
                org.junit.Assert.fail("testGetEnactmentlitNum2859 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2859_failAssert595null2920 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2860_failAssert596() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(-1).getFc_id());
            Assert.notNull(enactment);
            org.junit.Assert.fail("testGetEnactmentlitNum2860 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            org.junit.Assert.assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2861_failAssert597() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(Integer.MAX_VALUE).getFc_id());
            Assert.notNull(enactment);
            org.junit.Assert.fail("testGetEnactmentlitNum2861 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            org.junit.Assert.assertEquals("2147483647", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2863_failAssert599() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
            Assert.notNull(enactment);
            org.junit.Assert.fail("testGetEnactmentlitNum2863 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            org.junit.Assert.assertEquals("Illegal character in path at index 66: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/9>05", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2863_failAssert599_mg2900_failAssert629() throws Exception {
        try {
            {
                Adaptation __DSPOT_adaptation_424 = new Adaptation();
                List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
                Assert.notNull(enactment);
                org.junit.Assert.fail("testGetEnactmentlitNum2863 should have thrown URISyntaxException");
                enactment.setAdaptation(__DSPOT_adaptation_424);
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2863_failAssert599_mg2900 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            org.junit.Assert.assertEquals("Illegal character in path at index 66: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/9>05", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2863_failAssert599_mg2900_failAssert629null3037_failAssert644() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_adaptation_424 = new Adaptation();
                    List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(enactments);
                    Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetEnactmentlitNum2863 should have thrown URISyntaxException");
                    enactment.setAdaptation(__DSPOT_adaptation_424);
                }
                org.junit.Assert.fail("testGetEnactmentlitNum2863_failAssert599_mg2900 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2863_failAssert599_mg2900_failAssert629null3037 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            org.junit.Assert.assertEquals("Illegal character in path at index 66: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/9>05", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2863_failAssert599_mg2904_failAssert630() throws Exception {
        try {
            {
                Date __DSPOT_enactment_completion_time_428 = new Date("h3?+w?h+LZ(B%Q=,R: .");
                List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
                Assert.notNull(enactment);
                org.junit.Assert.fail("testGetEnactmentlitNum2863 should have thrown URISyntaxException");
                enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_428);
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2863_failAssert599_mg2904 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2863_failAssert599_mg2904_failAssert630litString2982_failAssert646() throws Exception {
        try {
            {
                {
                    Date __DSPOT_enactment_completion_time_428 = new Date("adaptation");
                    List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(enactments);
                    Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testGetEnactmentlitNum2863 should have thrown URISyntaxException");
                    enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_428);
                }
                org.junit.Assert.fail("testGetEnactmentlitNum2863_failAssert599_mg2904 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2863_failAssert599_mg2904_failAssert630litString2982 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_mg763_failAssert146() throws Exception {
        try {
            Date __DSPOT_enactment_request_timestamp_126 = new Date("#)/AY^(qL7}kh?A:jNYy");
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_126);
            org.junit.Assert.fail("testAddEnactment_mg763 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_mg763_failAssert146_mg898_failAssert300() throws Exception {
        try {
            {
                List<Action> __DSPOT_actions_161 = Collections.singletonList(new Action());
                Date __DSPOT_enactment_request_timestamp_126 = new Date("#)/AY^(qL7}kh?A:jNYy");
                Adaptation adaptation = createAdaptation("905");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_126);
                org.junit.Assert.fail("testAddEnactment_mg763 should have thrown IllegalArgumentException");
                adaptation.setActions(__DSPOT_actions_161);
            }
            org.junit.Assert.fail("testAddEnactment_mg763_failAssert146_mg898 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_mg763_failAssert146_mg898_failAssert300litString1528_failAssert350() throws Exception {
        try {
            {
                {
                    List<Action> __DSPOT_actions_161 = Collections.singletonList(new Action());
                    Date __DSPOT_enactment_request_timestamp_126 = new Date("#)/AY^(qL7}kh?A:jNYy");
                    Adaptation adaptation = createAdaptation("VM2_B_HighConfiguration");
                    adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                    Enactment enactment = createEnactment(adaptation.getFc_id());
                    enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                    AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_126);
                    org.junit.Assert.fail("testAddEnactment_mg763 should have thrown IllegalArgumentException");
                    adaptation.setActions(__DSPOT_actions_161);
                }
                org.junit.Assert.fail("testAddEnactment_mg763_failAssert146_mg898 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddEnactment_mg763_failAssert146_mg898_failAssert300litString1528 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_mg763_failAssert146_mg926_failAssert304() throws Exception {
        try {
            {
                Adaptation __DSPOT_adaptation_185 = new Adaptation();
                Date __DSPOT_enactment_request_timestamp_126 = new Date("#)/AY^(qL7}kh?A:jNYy");
                Adaptation adaptation = createAdaptation("905");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_126);
                org.junit.Assert.fail("testAddEnactment_mg763 should have thrown IllegalArgumentException");
                enactment.setAdaptation(__DSPOT_adaptation_185);
            }
            org.junit.Assert.fail("testAddEnactment_mg763_failAssert146_mg926 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_mg763_failAssert146_mg926_failAssert304litString1521_failAssert378() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_adaptation_185 = new Adaptation();
                    Date __DSPOT_enactment_request_timestamp_126 = new Date("#)/AY^(qL7}kh?A:jNYy");
                    Adaptation adaptation = createAdaptation("VM2_B_HighConfiguration");
                    adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                    Enactment enactment = createEnactment(adaptation.getFc_id());
                    enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                    AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_126);
                    org.junit.Assert.fail("testAddEnactment_mg763 should have thrown IllegalArgumentException");
                    enactment.setAdaptation(__DSPOT_adaptation_185);
                }
                org.junit.Assert.fail("testAddEnactment_mg763_failAssert146_mg926 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddEnactment_mg763_failAssert146_mg926_failAssert304litString1521 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_mg763_failAssert146null1079_failAssert305() throws Exception {
        try {
            {
                Date __DSPOT_enactment_request_timestamp_126 = new Date("#)/AY^(qL7}kh?A:jNYy");
                Adaptation adaptation = createAdaptation("905");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                enactment.setEnactment_request_time(null);
                org.junit.Assert.fail("testAddEnactment_mg763 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddEnactment_mg763_failAssert146null1079 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_mg763_failAssert146null1079_failAssert305litString1516_failAssert382() throws Exception {
        try {
            {
                {
                    Date __DSPOT_enactment_request_timestamp_126 = new Date("");
                    Adaptation adaptation = createAdaptation("905");
                    adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                    Enactment enactment = createEnactment(adaptation.getFc_id());
                    enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                    Assert.notNull(enactment);
                    AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                    AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    enactment.setEnactment_request_time(null);
                    org.junit.Assert.fail("testAddEnactment_mg763 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testAddEnactment_mg763_failAssert146null1079 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddEnactment_mg763_failAssert146null1079_failAssert305litString1516 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString747() throws Exception {
        Adaptation adaptation = createAdaptation("adaptation");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Enactment enactment = createEnactment(adaptation.getFc_id());
        enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        HttpStatus o_testAddEnactmentlitString747__11 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
        org.junit.Assert.assertEquals("OK", ((HttpStatus) (o_testAddEnactmentlitString747__11)).getReasonPhrase());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testAddEnactmentlitString747__11)).is1xxInformational());
        org.junit.Assert.assertTrue(((HttpStatus) (o_testAddEnactmentlitString747__11)).is2xxSuccessful());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testAddEnactmentlitString747__11)).is3xxRedirection());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testAddEnactmentlitString747__11)).is4xxClientError());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testAddEnactmentlitString747__11)).is5xxServerError());
        org.junit.Assert.assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitString747__11)).toString());
        HttpStatus o_testAddEnactmentlitString747__13 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        org.junit.Assert.assertEquals("OK", ((HttpStatus) (o_testAddEnactmentlitString747__13)).getReasonPhrase());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testAddEnactmentlitString747__13)).is1xxInformational());
        org.junit.Assert.assertTrue(((HttpStatus) (o_testAddEnactmentlitString747__13)).is2xxSuccessful());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testAddEnactmentlitString747__13)).is3xxRedirection());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testAddEnactmentlitString747__13)).is4xxClientError());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testAddEnactmentlitString747__13)).is5xxServerError());
        org.junit.Assert.assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitString747__13)).toString());
        org.junit.Assert.assertEquals("OK", ((HttpStatus) (o_testAddEnactmentlitString747__11)).getReasonPhrase());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testAddEnactmentlitString747__11)).is1xxInformational());
        org.junit.Assert.assertTrue(((HttpStatus) (o_testAddEnactmentlitString747__11)).is2xxSuccessful());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testAddEnactmentlitString747__11)).is3xxRedirection());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testAddEnactmentlitString747__11)).is4xxClientError());
        org.junit.Assert.assertFalse(((HttpStatus) (o_testAddEnactmentlitString747__11)).is5xxServerError());
        org.junit.Assert.assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitString747__11)).toString());
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString747null964_failAssert153() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("adaptation");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            HttpStatus o_testAddEnactmentlitString747__11 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            HttpStatus o_testAddEnactmentlitString747__13 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentlitString747null964 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString747null971_failAssert152() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("adaptation");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
            Assert.notNull(enactment);
            HttpStatus o_testAddEnactmentlitString747__11 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            HttpStatus o_testAddEnactmentlitString747__13 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentlitString747null971 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString747null971_failAssert152_mg1565_failAssert371() throws Exception {
        try {
            {
                String __DSPOT_fc_id_229 = "c{vs!b(f2kvd|>op3F[U";
                Adaptation adaptation = createAdaptation("adaptation");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
                Assert.notNull(enactment);
                HttpStatus o_testAddEnactmentlitString747__11 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                HttpStatus o_testAddEnactmentlitString747__13 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactmentlitString747null971 should have thrown NullPointerException");
                adaptation.setFc_id(__DSPOT_fc_id_229);
            }
            org.junit.Assert.fail("testAddEnactmentlitString747null971_failAssert152_mg1565 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString752_failAssert144() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentlitString752 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString752_failAssert144null1077_failAssert163() throws Exception {
        try {
            {
                Adaptation adaptation = createAdaptation("");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(null);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactmentlitString752 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testAddEnactmentlitString752_failAssert144null1077 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString752_failAssert144null1077_failAssert163null1746_failAssert343() throws Exception {
        try {
            {
                {
                    Adaptation adaptation = createAdaptation("");
                    adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                    Enactment enactment = createEnactment(adaptation.getFc_id());
                    enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
                    Assert.notNull(null);
                    AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                    AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    org.junit.Assert.fail("testAddEnactmentlitString752 should have thrown HttpMessageNotReadableException");
                }
                org.junit.Assert.fail("testAddEnactmentlitString752_failAssert144null1077 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testAddEnactmentlitString752_failAssert144null1077_failAssert163null1746 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString753_failAssert145() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("\n");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentlitString753 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString753_failAssert145null1025_failAssert166() throws Exception {
        try {
            {
                Adaptation adaptation = createAdaptation("\n");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(null);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactmentlitString753 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testAddEnactmentlitString753_failAssert145null1025 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull766_failAssert147() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentnull766 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull766_failAssert147null1053_failAssert155() throws Exception {
        try {
            {
                Adaptation adaptation = createAdaptation(null);
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
                Assert.notNull(enactment);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactmentnull766 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testAddEnactmentnull766_failAssert147null1053 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull766_failAssert147null1053_failAssert155null1740_failAssert340() throws Exception {
        try {
            {
                {
                    Adaptation adaptation = createAdaptation(null);
                    adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
                    Enactment enactment = createEnactment(adaptation.getFc_id());
                    enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
                    Assert.notNull(enactment);
                    AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                    AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    org.junit.Assert.fail("testAddEnactmentnull766 should have thrown HttpMessageNotReadableException");
                }
                org.junit.Assert.fail("testAddEnactmentnull766_failAssert147null1053 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testAddEnactmentnull766_failAssert147null1053_failAssert155null1740 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull766_failAssert147null1053_failAssert155null1744_failAssert341() throws Exception {
        try {
            {
                {
                    Adaptation adaptation = createAdaptation(null);
                    adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                    Enactment enactment = createEnactment(adaptation.getFc_id());
                    enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
                    Assert.notNull(null);
                    AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                    AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    org.junit.Assert.fail("testAddEnactmentnull766 should have thrown HttpMessageNotReadableException");
                }
                org.junit.Assert.fail("testAddEnactmentnull766_failAssert147null1053 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testAddEnactmentnull766_failAssert147null1053_failAssert155null1744 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull767_failAssert148() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentnull767 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull768_failAssert149() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentnull768 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            org.junit.Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg1769_mg1958_failAssert369() throws Exception {
        try {
            Date __DSPOT_computation_timestamp_327 = new Date("P]M{.a6Z;:gn%A;>)zto");
            Adaptation __DSPOT_a_271 = new Adaptation();
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptation_mg1769__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptation_mg1769__14 = adaptation.compareTo(__DSPOT_a_271);
            adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_327);
            fail("testGetAdaptation_mg1769_mg1958 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg1769_mg1958_failAssert369_mg2426_failAssert557() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_390 = new Adaptation();
                Date __DSPOT_computation_timestamp_327 = new Date("P]M{.a6Z;:gn%A;>)zto");
                Adaptation __DSPOT_a_271 = new Adaptation();
                Adaptation adaptation = createAdaptation("905");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                HttpStatus o_testGetAdaptation_mg1769__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testGetAdaptation_mg1769__14 = adaptation.compareTo(__DSPOT_a_271);
                adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_327);
                fail("testGetAdaptation_mg1769_mg1958 should have thrown IllegalArgumentException");
                __DSPOT_a_271.compareTo(__DSPOT_a_390);
            }
            fail("testGetAdaptation_mg1769_mg1958_failAssert369_mg2426 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg1769_mg1958_failAssert369_mg2427_failAssert558() throws Exception {
        try {
            {
                List<Action> __DSPOT_actions_391 = Collections.singletonList(new Action());
                Date __DSPOT_computation_timestamp_327 = new Date("P]M{.a6Z;:gn%A;>)zto");
                Adaptation __DSPOT_a_271 = new Adaptation();
                Adaptation adaptation = createAdaptation("905");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                HttpStatus o_testGetAdaptation_mg1769__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testGetAdaptation_mg1769__14 = adaptation.compareTo(__DSPOT_a_271);
                adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_327);
                fail("testGetAdaptation_mg1769_mg1958 should have thrown IllegalArgumentException");
                __DSPOT_a_271.setActions(__DSPOT_actions_391);
            }
            fail("testGetAdaptation_mg1769_mg1958_failAssert369_mg2427 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg1769litString1862_failAssert367() throws Exception {
        try {
            Adaptation __DSPOT_a_271 = new Adaptation();
            Adaptation adaptation = createAdaptation("");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptation_mg1769__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptation_mg1769__14 = adaptation.compareTo(__DSPOT_a_271);
            fail("testGetAdaptation_mg1769litString1862 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg1769litString1862_failAssert367_mg2332_failAssert525() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_332 = new Adaptation();
                Adaptation __DSPOT_a_271 = new Adaptation();
                Adaptation adaptation = createAdaptation("");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                HttpStatus o_testGetAdaptation_mg1769__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testGetAdaptation_mg1769__14 = adaptation.compareTo(__DSPOT_a_271);
                fail("testGetAdaptation_mg1769litString1862 should have thrown HttpMessageNotReadableException");
                __DSPOT_a_271.compareTo(__DSPOT_a_332);
            }
            fail("testGetAdaptation_mg1769litString1862_failAssert367_mg2332 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg1769null1984_failAssert370() throws Exception {
        try {
            Adaptation __DSPOT_a_271 = new Adaptation();
            Adaptation adaptation = createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptation_mg1769__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptation_mg1769__14 = adaptation.compareTo(__DSPOT_a_271);
            fail("testGetAdaptation_mg1769null1984 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg1769null1984_failAssert370_mg2332_failAssert575() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_333 = new Adaptation();
                Adaptation __DSPOT_a_271 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                HttpStatus o_testGetAdaptation_mg1769__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testGetAdaptation_mg1769__14 = adaptation.compareTo(__DSPOT_a_271);
                fail("testGetAdaptation_mg1769null1984 should have thrown HttpMessageNotReadableException");
                __DSPOT_a_271.compareTo(__DSPOT_a_333);
            }
            fail("testGetAdaptation_mg1769null1984_failAssert370_mg2332 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1761() throws Exception {
        Adaptation adaptation = createAdaptation("vm2_b_high");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptationlitString1761__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testGetAdaptationlitString1761__10)).toString());
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1761_mg1844() throws Exception {
        Adaptation __DSPOT_a_281 = new Adaptation();
        Adaptation adaptation = createAdaptation("vm2_b_high");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptationlitString1761__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testGetAdaptationlitString1761_mg1844__16 = adaptation.compareTo(__DSPOT_a_281);
        org.junit.Assert.assertEquals(0, ((int) (o_testGetAdaptationlitString1761_mg1844__16)));
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1761_mg1844_mg2335() throws Exception {
        Adaptation __DSPOT_a_334 = new Adaptation();
        Adaptation __DSPOT_a_281 = new Adaptation();
        Adaptation adaptation = createAdaptation("vm2_b_high");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptationlitString1761__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testGetAdaptationlitString1761_mg1844__16 = adaptation.compareTo(__DSPOT_a_281);
        int o_testGetAdaptationlitString1761_mg1844_mg2335__21 = __DSPOT_a_281.compareTo(__DSPOT_a_334);
        org.junit.Assert.assertEquals(0, ((int) (o_testGetAdaptationlitString1761_mg1844_mg2335__21)));
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1761_mg1844_mg2368() throws Exception {
        Adaptation __DSPOT_a_357 = new Adaptation();
        Adaptation __DSPOT_a_281 = new Adaptation();
        Adaptation adaptation = createAdaptation("vm2_b_high");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptationlitString1761__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testGetAdaptationlitString1761_mg1844__16 = adaptation.compareTo(__DSPOT_a_281);
        int o_testGetAdaptationlitString1761_mg1844_mg2368__21 = adaptation.compareTo(__DSPOT_a_357);
        org.junit.Assert.assertEquals(0, ((int) (o_testGetAdaptationlitString1761_mg1844_mg2368__21)));
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1761_mg1844null2413_failAssert498() throws Exception {
        try {
            Adaptation __DSPOT_a_281 = new Adaptation();
            Adaptation adaptation = createAdaptation("vm2_b_high");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptationlitString1761__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptationlitString1761_mg1844__16 = adaptation.compareTo(__DSPOT_a_281);
            fail("testGetAdaptationlitString1761_mg1844null2413 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1761_mg1844null2417_failAssert499() throws Exception {
        try {
            Adaptation __DSPOT_a_281 = new Adaptation();
            Adaptation adaptation = createAdaptation("vm2_b_high");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptationlitString1761__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptationlitString1761_mg1844__16 = adaptation.compareTo(__DSPOT_a_281);
            fail("testGetAdaptationlitString1761_mg1844null2417 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1761_mg1844null2420_failAssert500() throws Exception {
        try {
            Adaptation __DSPOT_a_281 = new Adaptation();
            Adaptation adaptation = createAdaptation("vm2_b_high");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(null);
            HttpStatus o_testGetAdaptationlitString1761__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptationlitString1761_mg1844__16 = adaptation.compareTo(__DSPOT_a_281);
            fail("testGetAdaptationlitString1761_mg1844null2420 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1761null1907_failAssert364() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("vm2_b_high");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptationlitString1761__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationlitString1761null1907 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1761null1915_failAssert365() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("vm2_b_high");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptationlitString1761__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationlitString1761null1915 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1761null1923_failAssert366() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("vm2_b_high");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(null);
            HttpStatus o_testGetAdaptationlitString1761__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationlitString1761null1923 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1761null1923_failAssert366_mg2356_failAssert519() throws Exception {
        try {
            {
                Date __DSPOT_computation_timestamp_350 = new Date("sv>Bx*R0oQx`#S=-MZ,L");
                Adaptation adaptation = createAdaptation("vm2_b_high");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(null);
                HttpStatus o_testGetAdaptationlitString1761__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                fail("testGetAdaptationlitString1761null1923 should have thrown IllegalArgumentException");
                adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_350);
            }
            fail("testGetAdaptationlitString1761null1923_failAssert366_mg2356 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1762_failAssert356() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("|05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationlitString1762 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 66: http://supersede.es.atos.net:8080/adaptation-dashboard/adaptation/|05", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1762_failAssert356_rv1939_failAssert387() throws Exception {
        try {
            {
                Adaptation adaptation = createAdaptation("|05");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                HttpStatus __DSPOT_invoc_12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                fail("testGetAdaptationlitString1762 should have thrown URISyntaxException");
                __DSPOT_invoc_12.toString();
            }
            fail("testGetAdaptationlitString1762_failAssert356_rv1939 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 66: http://supersede.es.atos.net:8080/adaptation-dashboard/adaptation/|05", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1765_failAssert357() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("b]U");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationlitString1765 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 67: http://supersede.es.atos.net:8080/adaptation-dashboard/adaptation/b]U", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString1766_failAssert358() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationlitString1766 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationnull1775_failAssert360() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationnull1775 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationnull1776_failAssert361() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationnull1776 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationnull1778_failAssert363() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(null);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationnull1778 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString139() throws Exception {
        Adaptation adaptation = createAdaptation("905");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptationlitString139__10 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testGetAdaptationlitString139__10)).toString());
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg9null161_failAssert12() throws Exception {
        try {
            Adaptation __DSPOT_a_0 = new Adaptation();
            Adaptation adaptation = createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptation_mg9__8 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptation_mg9__10 = adaptation.compareTo(__DSPOT_a_0);
            fail("testAddAdaptation_mg9null161 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg9null161_failAssert12_mg401_failAssert109() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_56 = new Adaptation();
                Adaptation __DSPOT_a_0 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                HttpStatus o_testAddAdaptation_mg9__8 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testAddAdaptation_mg9__10 = adaptation.compareTo(__DSPOT_a_0);
                fail("testAddAdaptation_mg9null161 should have thrown HttpMessageNotReadableException");
                __DSPOT_a_0.compareTo(__DSPOT_a_56);
            }
            fail("testAddAdaptation_mg9null161_failAssert12_mg401 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg9null161_failAssert12_mg431_failAssert112() throws Exception {
        try {
            {
                String __DSPOT_fc_id_85 = "JWOM_4gdsL9rC)A6fdF&";
                Adaptation __DSPOT_a_0 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                HttpStatus o_testAddAdaptation_mg9__8 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testAddAdaptation_mg9__10 = adaptation.compareTo(__DSPOT_a_0);
                fail("testAddAdaptation_mg9null161 should have thrown HttpMessageNotReadableException");
                __DSPOT_a_0.setFc_id(__DSPOT_fc_id_85);
            }
            fail("testAddAdaptation_mg9null161_failAssert12_mg431 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2_mg84() throws Exception {
        Adaptation __DSPOT_a_13 = new Adaptation();
        Adaptation adaptation = createAdaptation("k05");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptationlitString2_mg84__12 = adaptation.compareTo(__DSPOT_a_13);
        org.junit.Assert.assertEquals(0, ((int) (o_testAddAdaptationlitString2_mg84__12)));
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2_mg84_mg393() throws Exception {
        Adaptation __DSPOT_a_48 = new Adaptation();
        Adaptation __DSPOT_a_13 = new Adaptation();
        Adaptation adaptation = createAdaptation("k05");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptationlitString2_mg84__12 = adaptation.compareTo(__DSPOT_a_13);
        int o_testAddAdaptationlitString2_mg84_mg393__17 = __DSPOT_a_13.compareTo(__DSPOT_a_48);
        org.junit.Assert.assertEquals(0, ((int) (o_testAddAdaptationlitString2_mg84_mg393__17)));
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2_mg84null454_failAssert74() throws Exception {
        try {
            Adaptation __DSPOT_a_13 = new Adaptation();
            Adaptation adaptation = createAdaptation("k05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptationlitString2_mg84__12 = adaptation.compareTo(__DSPOT_a_13);
            fail("testAddAdaptationlitString2_mg84null454 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2_mg84null457_failAssert75() throws Exception {
        try {
            Adaptation __DSPOT_a_13 = new Adaptation();
            Adaptation adaptation = createAdaptation("k05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptationlitString2_mg84__12 = adaptation.compareTo(__DSPOT_a_13);
            fail("testAddAdaptationlitString2_mg84null457 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2_mg94_failAssert5() throws Exception {
        try {
            Date __DSPOT_computation_timestamp_21 = new Date("vnj|}8wu]&8(Dgh`l V!");
            Adaptation adaptation = createAdaptation("k05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_21);
            fail("testAddAdaptationlitString2_mg94 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2_mg94_failAssert5_mg397_failAssert79() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_54 = new Adaptation();
                Date __DSPOT_computation_timestamp_21 = new Date("vnj|}8wu]&8(Dgh`l V!");
                Adaptation adaptation = createAdaptation("k05");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_21);
                fail("testAddAdaptationlitString2_mg94 should have thrown IllegalArgumentException");
                adaptation.compareTo(__DSPOT_a_54);
            }
            fail("testAddAdaptationlitString2_mg94_failAssert5_mg397 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2null125_failAssert6() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("k05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddAdaptationlitString2null125 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2null128_failAssert7() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("k05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddAdaptationlitString2null128 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString6_mg76() throws Exception {
        Adaptation __DSPOT_a_8 = new Adaptation();
        Adaptation adaptation = createAdaptation("");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitString6__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptationlitString6_mg76__12 = adaptation.compareTo(__DSPOT_a_8);
        org.junit.Assert.assertEquals(0, ((int) (o_testAddAdaptationlitString6_mg76__12)));
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString6_mg76_mg393() throws Exception {
        Adaptation __DSPOT_a_49 = new Adaptation();
        Adaptation __DSPOT_a_8 = new Adaptation();
        Adaptation adaptation = createAdaptation("");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitString6__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptationlitString6_mg76__12 = adaptation.compareTo(__DSPOT_a_8);
        int o_testAddAdaptationlitString6_mg76_mg393__17 = __DSPOT_a_8.compareTo(__DSPOT_a_49);
        org.junit.Assert.assertEquals(0, ((int) (o_testAddAdaptationlitString6_mg76_mg393__17)));
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString6_mg76_mg404_failAssert76() throws Exception {
        try {
            Date __DSPOT_computation_timestamp_59 = new Date("y}!3^ GSx?wy.`JJ}@!Y");
            Adaptation __DSPOT_a_8 = new Adaptation();
            Adaptation adaptation = createAdaptation("");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptationlitString6__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptationlitString6_mg76__12 = adaptation.compareTo(__DSPOT_a_8);
            __DSPOT_a_8.setComputation_timestamp(__DSPOT_computation_timestamp_59);
            fail("testAddAdaptationlitString6_mg76_mg404 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString6null120_failAssert9() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            HttpStatus o_testAddAdaptationlitString6__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddAdaptationlitString6null120 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg147() throws Exception {
        Adaptation __DSPOT_a_17 = new Adaptation();
        Adaptation adaptation = createAdaptation("905");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptation_mg147__12 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testGetAdaptation_mg147__12)).toString());
        int o_testGetAdaptation_mg147__14 = adaptation.compareTo(__DSPOT_a_17);
        org.junit.Assert.assertEquals(0, ((int) (o_testGetAdaptation_mg147__14)));
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testGetAdaptation_mg147__12)).toString());
    }

    @Test(timeout = 30000)
    public void testGetAllEnactmentsnull2683_failAssert594() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(null);
            fail("testGetAllEnactmentsnull2683 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactment_mg2694_failAssert603() throws Exception {
        try {
            Date __DSPOT_enactment_request_timestamp_404 = new Date("t@)l]!qOeddHWm8&1a$R");
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
            Assert.notNull(enactment);
            enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_404);
            fail("testGetEnactment_mg2694 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactment_mg2694_failAssert603_mg2772_failAssert643() throws Exception {
        try {
            {
                Adaptation __DSPOT_adaptation_427 = new Adaptation();
                Date __DSPOT_enactment_request_timestamp_404 = new Date("t@)l]!qOeddHWm8&1a$R");
                List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
                Assert.notNull(enactment);
                enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_404);
                fail("testGetEnactment_mg2694 should have thrown IllegalArgumentException");
                enactment.setAdaptation(__DSPOT_adaptation_427);
            }
            fail("testGetEnactment_mg2694_failAssert603_mg2772 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactment_mg2694_failAssert603_mg2772_failAssert643litString2894_failAssert682() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_adaptation_427 = new Adaptation();
                    Date __DSPOT_enactment_request_timestamp_404 = new Date("vm2_b_high");
                    List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(enactments);
                    Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
                    Assert.notNull(enactment);
                    enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_404);
                    fail("testGetEnactment_mg2694 should have thrown IllegalArgumentException");
                    enactment.setAdaptation(__DSPOT_adaptation_427);
                }
                fail("testGetEnactment_mg2694_failAssert603_mg2772 should have thrown IllegalArgumentException");
            }
            fail("testGetEnactment_mg2694_failAssert603_mg2772_failAssert643litString2894 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2686_failAssert595() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
            Assert.notNull(enactment);
            fail("testGetEnactmentlitNum2686 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2686_failAssert595_mg2734_failAssert608() throws Exception {
        try {
            {
                Adaptation __DSPOT_adaptation_412 = new Adaptation();
                List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                Assert.notNull(enactment);
                fail("testGetEnactmentlitNum2686 should have thrown HttpMessageNotReadableException");
                enactment.setAdaptation(__DSPOT_adaptation_412);
            }
            fail("testGetEnactmentlitNum2686_failAssert595_mg2734 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2686_failAssert595_mg2734_failAssert608null2959_failAssert663() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_adaptation_412 = new Adaptation();
                    List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(null);
                    Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                    Assert.notNull(enactment);
                    fail("testGetEnactmentlitNum2686 should have thrown HttpMessageNotReadableException");
                    enactment.setAdaptation(__DSPOT_adaptation_412);
                }
                fail("testGetEnactmentlitNum2686_failAssert595_mg2734 should have thrown HttpMessageNotReadableException");
            }
            fail("testGetEnactmentlitNum2686_failAssert595_mg2734_failAssert608null2959 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2686_failAssert595_mg2734_failAssert608null2962_failAssert664() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_adaptation_412 = new Adaptation();
                    List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(enactments);
                    Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                    Assert.notNull(null);
                    fail("testGetEnactmentlitNum2686 should have thrown HttpMessageNotReadableException");
                    enactment.setAdaptation(__DSPOT_adaptation_412);
                }
                fail("testGetEnactmentlitNum2686_failAssert595_mg2734 should have thrown HttpMessageNotReadableException");
            }
            fail("testGetEnactmentlitNum2686_failAssert595_mg2734_failAssert608null2962 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2686_failAssert595_mg2756_failAssert610() throws Exception {
        try {
            {
                Date __DSPOT_enactment_request_timestamp_423 = new Date("T.nK7w|,dxKcm5[*Td[$");
                List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                Assert.notNull(enactment);
                fail("testGetEnactmentlitNum2686 should have thrown HttpMessageNotReadableException");
                enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_423);
            }
            fail("testGetEnactmentlitNum2686_failAssert595_mg2756 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2686_failAssert595_mg2756_failAssert610litString2895_failAssert666() throws Exception {
        try {
            {
                {
                    Date __DSPOT_enactment_request_timestamp_423 = new Date("adaptation");
                    List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(enactments);
                    Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                    Assert.notNull(enactment);
                    fail("testGetEnactmentlitNum2686 should have thrown HttpMessageNotReadableException");
                    enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_423);
                }
                fail("testGetEnactmentlitNum2686_failAssert595_mg2756 should have thrown IllegalArgumentException");
            }
            fail("testGetEnactmentlitNum2686_failAssert595_mg2756_failAssert610litString2895 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2686_failAssert595null2765_failAssert613() throws Exception {
        try {
            {
                List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(null);
                Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                Assert.notNull(enactment);
                fail("testGetEnactmentlitNum2686 should have thrown HttpMessageNotReadableException");
            }
            fail("testGetEnactmentlitNum2686_failAssert595null2765 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2686_failAssert595null2765_failAssert613null2934_failAssert677() throws Exception {
        try {
            {
                {
                    List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(null);
                    Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                    Assert.notNull(null);
                    fail("testGetEnactmentlitNum2686 should have thrown HttpMessageNotReadableException");
                }
                fail("testGetEnactmentlitNum2686_failAssert595null2765 should have thrown IllegalArgumentException");
            }
            fail("testGetEnactmentlitNum2686_failAssert595null2765_failAssert613null2934 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2687_failAssert596() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get((-1)).getFc_id());
            Assert.notNull(enactment);
            fail("testGetEnactmentlitNum2687 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2687_failAssert596null2753_failAssert621() throws Exception {
        try {
            {
                List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get((-1)).getFc_id());
                Assert.notNull(null);
                fail("testGetEnactmentlitNum2687 should have thrown ArrayIndexOutOfBoundsException");
            }
            fail("testGetEnactmentlitNum2687_failAssert596null2753 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2690_failAssert599() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
            Assert.notNull(enactment);
            fail("testGetEnactmentlitNum2690 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 66: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/9>05", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2690_failAssert599_mg2725_failAssert622() throws Exception {
        try {
            {
                Adaptation __DSPOT_adaptation_407 = new Adaptation();
                List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
                Assert.notNull(enactment);
                fail("testGetEnactmentlitNum2690 should have thrown URISyntaxException");
                enactment.setAdaptation(__DSPOT_adaptation_407);
            }
            fail("testGetEnactmentlitNum2690_failAssert599_mg2725 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 66: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/9>05", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum2690_failAssert599_mg2725_failAssert622null2963_failAssert680() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_adaptation_407 = new Adaptation();
                    List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(enactments);
                    Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
                    Assert.notNull(null);
                    fail("testGetEnactmentlitNum2690 should have thrown URISyntaxException");
                    enactment.setAdaptation(__DSPOT_adaptation_407);
                }
                fail("testGetEnactmentlitNum2690_failAssert599_mg2725 should have thrown URISyntaxException");
            }
            fail("testGetEnactmentlitNum2690_failAssert599_mg2725_failAssert622null2963 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 66: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/9>05", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentnull2698_failAssert607() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
            Assert.notNull(null);
            fail("testGetEnactmentnull2698 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 66: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/9>05", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString644() throws Exception {
        Adaptation adaptation = createAdaptation("_05");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Enactment enactment = createEnactment(adaptation.getFc_id());
        enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        HttpStatus o_testAddEnactmentlitString644__11 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitString644__11)).toString());
        HttpStatus o_testAddEnactmentlitString644__13 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitString644__13)).toString());
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitString644__11)).toString());
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString644null879_failAssert132() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("_05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            HttpStatus o_testAddEnactmentlitString644__11 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            HttpStatus o_testAddEnactmentlitString644__13 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddEnactmentlitString644null879 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString644null879_failAssert132_mg1342_failAssert311() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_206 = new Adaptation();
                Adaptation adaptation = createAdaptation("_05");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                HttpStatus o_testAddEnactmentlitString644__11 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                HttpStatus o_testAddEnactmentlitString644__13 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                fail("testAddEnactmentlitString644null879 should have thrown NullPointerException");
                adaptation.compareTo(__DSPOT_a_206);
            }
            fail("testAddEnactmentlitString644null879_failAssert132_mg1342 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString644null886_failAssert133() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("_05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
            Assert.notNull(enactment);
            HttpStatus o_testAddEnactmentlitString644__11 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            HttpStatus o_testAddEnactmentlitString644__13 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddEnactmentlitString644null886 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString644null886_failAssert133_mg1327_failAssert324() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_191 = new Adaptation();
                Adaptation adaptation = createAdaptation("_05");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
                Assert.notNull(enactment);
                HttpStatus o_testAddEnactmentlitString644__11 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                HttpStatus o_testAddEnactmentlitString644__13 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                fail("testAddEnactmentlitString644null886 should have thrown NullPointerException");
                adaptation.compareTo(__DSPOT_a_191);
            }
            fail("testAddEnactmentlitString644null886_failAssert133_mg1327 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString644null886_failAssert133_mg1370_failAssert332() throws Exception {
        try {
            {
                Date __DSPOT_enactment_request_timestamp_234 = new Date("ZG5qmr`1s$.raz`39dL#");
                Adaptation adaptation = createAdaptation("_05");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
                Assert.notNull(enactment);
                HttpStatus o_testAddEnactmentlitString644__11 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                HttpStatus o_testAddEnactmentlitString644__13 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                fail("testAddEnactmentlitString644null886 should have thrown NullPointerException");
                enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_234);
            }
            fail("testAddEnactmentlitString644null886_failAssert133_mg1370 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString644null886_failAssert133_mg1375_failAssert333() throws Exception {
        try {
            {
                String __DSPOT_fc_id_239 = "DLf,#+w{NUw]t2`oJKXQ";
                Adaptation adaptation = createAdaptation("_05");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
                Assert.notNull(enactment);
                HttpStatus o_testAddEnactmentlitString644__11 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                HttpStatus o_testAddEnactmentlitString644__13 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                fail("testAddEnactmentlitString644null886 should have thrown NullPointerException");
                enactment.setFc_id(__DSPOT_fc_id_239);
            }
            fail("testAddEnactmentlitString644null886_failAssert133_mg1375 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString645_failAssert125() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("9>05");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddEnactmentlitString645 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString645_failAssert125_mg733_failAssert135() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_119 = new Adaptation();
                Adaptation adaptation = createAdaptation("9>05");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                fail("testAddEnactmentlitString645 should have thrown HttpMessageNotReadableException");
                adaptation.compareTo(__DSPOT_a_119);
            }
            fail("testAddEnactmentlitString645_failAssert125_mg733 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString645_failAssert125_mg733_failAssert135null1520_failAssert339() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_a_119 = new Adaptation();
                    Adaptation adaptation = createAdaptation("9>05");
                    adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                    Enactment enactment = createEnactment(adaptation.getFc_id());
                    enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                    Assert.notNull(null);
                    AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                    AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    fail("testAddEnactmentlitString645 should have thrown HttpMessageNotReadableException");
                    adaptation.compareTo(__DSPOT_a_119);
                }
                fail("testAddEnactmentlitString645_failAssert125_mg733 should have thrown HttpMessageNotReadableException");
            }
            fail("testAddEnactmentlitString645_failAssert125_mg733_failAssert135null1520 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString645_failAssert125_mg752_failAssert137() throws Exception {
        try {
            {
                Date __DSPOT_computation_timestamp_126 = new Date("@l%MFZw!EI)uhDiCMs-N");
                Adaptation adaptation = createAdaptation("9>05");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                fail("testAddEnactmentlitString645 should have thrown HttpMessageNotReadableException");
                adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_126);
            }
            fail("testAddEnactmentlitString645_failAssert125_mg752 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString645_failAssert125_rv823_failAssert152() throws Exception {
        try {
            {
                Adaptation adaptation = createAdaptation("9>05");
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                HttpStatus __DSPOT_invoc_13 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                fail("testAddEnactmentlitString645 should have thrown HttpMessageNotReadableException");
                __DSPOT_invoc_13.series();
            }
            fail("testAddEnactmentlitString645_failAssert125_rv823 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString645_failAssert125_rv823_failAssert152null1476_failAssert347() throws Exception {
        try {
            {
                {
                    Adaptation adaptation = createAdaptation("9>05");
                    adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                    Enactment enactment = createEnactment(adaptation.getFc_id());
                    enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                    Assert.notNull(null);
                    HttpStatus __DSPOT_invoc_13 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                    AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    fail("testAddEnactmentlitString645 should have thrown HttpMessageNotReadableException");
                    __DSPOT_invoc_13.series();
                }
                fail("testAddEnactmentlitString645_failAssert125_rv823 should have thrown HttpMessageNotReadableException");
            }
            fail("testAddEnactmentlitString645_failAssert125_rv823_failAssert152null1476 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString648_failAssert126() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddEnactmentlitString648 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull662_failAssert128() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddEnactmentnull662 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull662_failAssert128_mg735_failAssert199() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_120 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                fail("testAddEnactmentnull662 should have thrown HttpMessageNotReadableException");
                adaptation.compareTo(__DSPOT_a_120);
            }
            fail("testAddEnactmentnull662_failAssert128_mg735 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull662_failAssert128_mg735_failAssert199null1504_failAssert349() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_a_120 = new Adaptation();
                    Adaptation adaptation = createAdaptation(null);
                    adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                    Enactment enactment = createEnactment(adaptation.getFc_id());
                    enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
                    Assert.notNull(enactment);
                    AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                    AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    fail("testAddEnactmentnull662 should have thrown HttpMessageNotReadableException");
                    adaptation.compareTo(__DSPOT_a_120);
                }
                fail("testAddEnactmentnull662_failAssert128_mg735 should have thrown HttpMessageNotReadableException");
            }
            fail("testAddEnactmentnull662_failAssert128_mg735_failAssert199null1504 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull662_failAssert128_mg742_failAssert200() throws Exception {
        try {
            {
                List<Action> __DSPOT_actions_121 = Collections.<Action>emptyList();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                fail("testAddEnactmentnull662 should have thrown HttpMessageNotReadableException");
                adaptation.setActions(__DSPOT_actions_121);
            }
            fail("testAddEnactmentnull662_failAssert128_mg742 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull663_failAssert129() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddEnactmentnull663 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull664_failAssert130() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddEnactmentnull664 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString144_failAssert22() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationlitString144 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString145_failAssert23() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("\n");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationlitString145 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 66: http://supersede.es.atos.net:8080/adaptation-dashboard/adaptation/\n", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg149_failAssert24() throws Exception {
        try {
            Date __DSPOT_computation_timestamp_19 = new Date("nj|}8wu]&8(Dgh`l V!3");
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_19);
            fail("testGetAdaptation_mg149 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationnull153_failAssert25() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationnull153 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationnull154_failAssert26() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationnull154 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationnull156_failAssert28() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(null);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testGetAdaptationnull156 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString2() throws Exception {
        Adaptation adaptation = createAdaptation("k05");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitString2__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddAdaptationlitString2__6)).toString());
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString6() throws Exception {
        Adaptation adaptation = createAdaptation("");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitString6__6 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("Method Not Allowed", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertFalse(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertTrue(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("405", ((HttpStatus) (o_testAddAdaptationlitString6__6)).toString());
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg9() throws Exception {
        Adaptation __DSPOT_a_0 = new Adaptation();
        Adaptation adaptation = createAdaptation("905");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptation_mg9__8 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddAdaptation_mg9__8)).toString());
        int o_testAddAdaptation_mg9__10 = adaptation.compareTo(__DSPOT_a_0);
        org.junit.Assert.assertEquals(0, ((int) (o_testAddAdaptation_mg9__10)));
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddAdaptation_mg9__8)).toString());
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString1_failAssert0() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("Medium load configuration for HSK service");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddAdaptationlitString1 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 72: http://supersede.es.atos.net:8080/adaptation-dashboard/adaptation/Medium load configuration for HSK service", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationnull15_failAssert2() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddAdaptationnull15 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationnull16_failAssert3() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddAdaptationnull16 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    private Adaptation createAdaptation(String fc_id) {
        Adaptation adaptation = new Adaptation();
        adaptation.setFc_id(fc_id);
        adaptation.setComputation_timestamp(Calendar.getInstance().getTime());
        adaptation.setModel_system(Atos_HSK);
        adaptation.setName("Medium load configuration for HSK service");
        adaptation.setRank(1.0);
        adaptation.getActions().add(createAction());
        return adaptation;
    }

    private Action createAction() {
        Action action = new Action();
        action.setAction_id("vm2_b_high");
        action.setDescription("Medium load configuration for HSK service");
        action.setName("VM2_B_HighConfiguration");
        action.setEnabled(true);
        return action;
    }

    @Test(timeout = 30000)
    public void testGetAllEnactmentsnull206_failAssert29() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(null);
            fail("testGetAllEnactmentsnull206 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum209_failAssert30() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
            Assert.notNull(enactment);
            fail("testGetEnactmentlitNum209 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum210_failAssert31() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get((-1)).getFc_id());
            Assert.notNull(enactment);
            fail("testGetEnactmentlitNum210 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum211_failAssert32() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(Integer.MAX_VALUE).getFc_id());
            Assert.notNull(enactment);
            fail("testGetEnactmentlitNum211 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("2147483647", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactmentlitNum213_failAssert34() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
            Assert.notNull(enactment);
            fail("testGetEnactmentlitNum213 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 66: http://supersede.es.atos.net:8080/adaptation-dashboard/enactment/9>05", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactment_mg217_failAssert38() throws Exception {
        try {
            Date __DSPOT_enactment_request_timestamp_25 = new Date("(J8Bp[$XdYQ7-#sa<}t>");
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
            Assert.notNull(enactment);
            enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_25);
            fail("testGetEnactment_mg217 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString64() throws Exception {
        Adaptation adaptation = createAdaptation("adaptation");
        adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Enactment enactment = createEnactment(adaptation.getFc_id());
        enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        HttpStatus o_testAddEnactmentlitString64__11 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitString64__11)).toString());
        HttpStatus o_testAddEnactmentlitString64__13 = AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitString64__13)).toString());
        assertEquals("OK", getReasonPhrase());
        assertFalse(is1xxInformational());
        assertTrue(is2xxSuccessful());
        assertFalse(is3xxRedirection());
        assertFalse(is4xxClientError());
        assertFalse(is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitString64__11)).toString());
    }

    @Test(timeout = 30000)
    public void testAddEnactment_mg72_failAssert7() throws Exception {
        try {
            Adaptation __DSPOT_a_6 = new Adaptation();
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            adaptation.compareTo(__DSPOT_a_6);
            fail("testAddEnactment_mg72 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_mg75_failAssert10() throws Exception {
        try {
            String __DSPOT_fc_id_9 = "U&zgYc TM1`_8;0L`A=S";
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            adaptation.setFc_id(__DSPOT_fc_id_9);
            fail("testAddEnactment_mg75 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull83_failAssert18() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddEnactmentnull83 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull84_failAssert19() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddEnactmentnull84 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull85_failAssert20() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            fail("testAddEnactmentnull85 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    private Enactment createEnactment(String fc_id) {
        Enactment enactment = new Enactment();
        enactment.setFc_id(fc_id);
        enactment.setEnactment_completion_time(Calendar.getInstance().getTime());
        enactment.setEnactment_request_time(Calendar.getInstance().getTime());
        enactment.setResult(true);
        return enactment;
    }
}

