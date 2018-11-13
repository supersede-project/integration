package eu.supersede.integration.api.adaptation.dashboard.proxies.test;


import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AmplAdaptationDashboardProxyTest {
    private static AdaptationDashboardProxy<Object, Object> proxy;

    private static String adaptationId;

    private static String enactmentId;

    @BeforeClass
    public static void setup() throws Exception {
        AmplAdaptationDashboardProxyTest.proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
        List<Adaptation> adaptations = AmplAdaptationDashboardProxyTest.proxy.getAllAdaptations();
        Assert.notEmpty(adaptations);
        AmplAdaptationDashboardProxyTest.adaptationId = adaptations.get(0).getFc_id();
        Assert.notNull(AmplAdaptationDashboardProxyTest.adaptationId);





    }

    @Test(timeout = 240000)
    public void testGetAdaptationlitNum1495() throws Exception {
        Adaptation adaptation = createAdaptation(4);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptationlitNum1495__10 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", ((HttpStatus) (o_testGetAdaptationlitNum1495__10)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testGetAdaptationlitNum1495__10)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testGetAdaptationlitNum1495__10)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testGetAdaptationlitNum1495__10)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testGetAdaptationlitNum1495__10)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testGetAdaptationlitNum1495__10)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testGetAdaptationlitNum1495__10)).toString());
    }

    @Test(timeout = 240000)
    public void testGetAdaptation_mg1501() throws Exception {
        Adaptation __DSPOT_a_238 = new Adaptation();
        Adaptation adaptation = createAdaptation(3);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptation_mg1501__12 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", ((HttpStatus) (o_testGetAdaptation_mg1501__12)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testGetAdaptation_mg1501__12)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testGetAdaptation_mg1501__12)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testGetAdaptation_mg1501__12)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testGetAdaptation_mg1501__12)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testGetAdaptation_mg1501__12)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testGetAdaptation_mg1501__12)).toString());
        int o_testGetAdaptation_mg1501__14 = adaptation.compareTo(__DSPOT_a_238);
        assertEquals(0, ((int) (o_testGetAdaptation_mg1501__14)));
        assertEquals("OK", ((HttpStatus) (o_testGetAdaptation_mg1501__12)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testGetAdaptation_mg1501__12)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testGetAdaptation_mg1501__12)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testGetAdaptation_mg1501__12)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testGetAdaptation_mg1501__12)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testGetAdaptation_mg1501__12)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testGetAdaptation_mg1501__12)).toString());
    }

    @Test(timeout = 240000)
    public void testGetAdaptationnull1507_failAssert339() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(null);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationnull1507 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptationnull1508_failAssert340() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(3);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationnull1508 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptationnull1509_failAssert341() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(3);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationnull1509 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptationnull1510_failAssert342() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(3);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(null);
            AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationnull1510 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptationlitNum1495_mg1579() throws Exception {
        Adaptation __DSPOT_a_246 = new Adaptation();
        Adaptation adaptation = createAdaptation(4);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptationlitNum1495__10 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testGetAdaptationlitNum1495_mg1579__16 = adaptation.compareTo(__DSPOT_a_246);
        assertEquals(0, ((int) (o_testGetAdaptationlitNum1495_mg1579__16)));
    }

    @Test(timeout = 240000)
    public void testGetAdaptationlitNum1495null1613_failAssert343() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(4);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptationlitNum1495__10 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationlitNum1495null1613 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptationlitNum1495null1618_failAssert344() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(4);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptationlitNum1495__10 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationlitNum1495null1618 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptationlitNum1495null1620_failAssert345() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(4);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(null);
            HttpStatus o_testGetAdaptationlitNum1495__10 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationlitNum1495null1620 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptation_mg1501null1676_failAssert346() throws Exception {
        try {
            Adaptation __DSPOT_a_238 = new Adaptation();
            Adaptation adaptation = createAdaptation(null);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptation_mg1501__12 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptation_mg1501__14 = adaptation.compareTo(__DSPOT_a_238);
            org.junit.Assert.fail("testGetAdaptation_mg1501null1676 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptationnull1510_failAssert342_mg1587_failAssert422() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_252 = new Adaptation();
                Adaptation adaptation = createAdaptation(3);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(null);
                AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testGetAdaptationnull1510 should have thrown IllegalArgumentException");
                adaptation.compareTo(__DSPOT_a_252);
            }
            org.junit.Assert.fail("testGetAdaptationnull1510_failAssert342_mg1587 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptationlitNum1495_mg1579_mg1954() throws Exception {
        Adaptation __DSPOT_a_286 = new Adaptation();
        Adaptation __DSPOT_a_246 = new Adaptation();
        Adaptation adaptation = createAdaptation(4);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
        Assert.notNull(adaptation);
        HttpStatus o_testGetAdaptationlitNum1495__10 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testGetAdaptationlitNum1495_mg1579__16 = adaptation.compareTo(__DSPOT_a_246);
        int o_testGetAdaptationlitNum1495_mg1579_mg1954__21 = __DSPOT_a_246.compareTo(__DSPOT_a_286);
        assertEquals(0, ((int) (o_testGetAdaptationlitNum1495_mg1579_mg1954__21)));
    }

    @Test(timeout = 240000)
    public void testGetAdaptationlitNum1495_mg1579null2025_failAssert440() throws Exception {
        try {
            Adaptation __DSPOT_a_246 = new Adaptation();
            Adaptation adaptation = createAdaptation(4);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptationlitNum1495__10 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptationlitNum1495_mg1579__16 = adaptation.compareTo(__DSPOT_a_246);
            org.junit.Assert.fail("testGetAdaptationlitNum1495_mg1579null2025 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptationlitNum1495_mg1579null2026_failAssert441() throws Exception {
        try {
            Adaptation __DSPOT_a_246 = new Adaptation();
            Adaptation adaptation = createAdaptation(4);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(adaptation);
            HttpStatus o_testGetAdaptationlitNum1495__10 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptationlitNum1495_mg1579__16 = adaptation.compareTo(__DSPOT_a_246);
            org.junit.Assert.fail("testGetAdaptationlitNum1495_mg1579null2026 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptationlitNum1495_mg1579null2028_failAssert442() throws Exception {
        try {
            Adaptation __DSPOT_a_246 = new Adaptation();
            Adaptation adaptation = createAdaptation(4);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
            Assert.notNull(null);
            HttpStatus o_testGetAdaptationlitNum1495__10 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testGetAdaptationlitNum1495_mg1579__16 = adaptation.compareTo(__DSPOT_a_246);
            org.junit.Assert.fail("testGetAdaptationlitNum1495_mg1579null2028 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptation_mg1501null1676_failAssert346_mg1958_failAssert467() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_288 = new Adaptation();
                Adaptation __DSPOT_a_238 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                HttpStatus o_testGetAdaptation_mg1501__12 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testGetAdaptation_mg1501__14 = adaptation.compareTo(__DSPOT_a_238);
                org.junit.Assert.fail("testGetAdaptation_mg1501null1676 should have thrown HttpMessageNotWritableException");
                __DSPOT_a_238.compareTo(__DSPOT_a_288);
            }
            org.junit.Assert.fail("testGetAdaptation_mg1501null1676_failAssert346_mg1958 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptation_mg1501null1676_failAssert346_mg1972_failAssert469() throws Exception {
        try {
            {
                Date __DSPOT_computation_timestamp_302 = new Date(" IF%j!9gwX1[[en#R7RX");
                Adaptation __DSPOT_a_238 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(adaptation);
                HttpStatus o_testGetAdaptation_mg1501__12 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testGetAdaptation_mg1501__14 = adaptation.compareTo(__DSPOT_a_238);
                org.junit.Assert.fail("testGetAdaptation_mg1501null1676 should have thrown HttpMessageNotWritableException");
                __DSPOT_a_238.setComputation_timestamp(__DSPOT_computation_timestamp_302);
            }
            org.junit.Assert.fail("testGetAdaptation_mg1501null1676_failAssert346_mg1972 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAdaptation_mg1501null1676_failAssert346null2021_failAssert481() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_238 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.getAdaptation(adaptation.getFc_id());
                Assert.notNull(null);
                HttpStatus o_testGetAdaptation_mg1501__12 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testGetAdaptation_mg1501__14 = adaptation.compareTo(__DSPOT_a_238);
                org.junit.Assert.fail("testGetAdaptation_mg1501null1676 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testGetAdaptation_mg1501null1676_failAssert346null2021 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddAdaptationlitNum1() throws Exception {
        Adaptation adaptation = createAdaptation(5);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitNum1__6 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", ((HttpStatus) (o_testAddAdaptationlitNum1__6)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddAdaptationlitNum1__6)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddAdaptationlitNum1__6)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddAdaptationlitNum1__6)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddAdaptationlitNum1__6)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddAdaptationlitNum1__6)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddAdaptationlitNum1__6)).toString());
    }

    @Test(timeout = 240000)
    public void testAddAdaptation_mg7() throws Exception {
        Adaptation __DSPOT_a_0 = new Adaptation();
        Adaptation adaptation = createAdaptation(4);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptation_mg7__8 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", ((HttpStatus) (o_testAddAdaptation_mg7__8)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddAdaptation_mg7__8)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddAdaptation_mg7__8)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddAdaptation_mg7__8)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddAdaptation_mg7__8)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddAdaptation_mg7__8)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddAdaptation_mg7__8)).toString());
        int o_testAddAdaptation_mg7__10 = adaptation.compareTo(__DSPOT_a_0);
        assertEquals(0, ((int) (o_testAddAdaptation_mg7__10)));
        assertEquals("OK", ((HttpStatus) (o_testAddAdaptation_mg7__8)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddAdaptation_mg7__8)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddAdaptation_mg7__8)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddAdaptation_mg7__8)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddAdaptation_mg7__8)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddAdaptation_mg7__8)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddAdaptation_mg7__8)).toString());
    }

    @Test(timeout = 240000)
    public void testAddAdaptationnull13_failAssert0() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(null);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationnull13 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddAdaptationnull14_failAssert1() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(4);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationnull14 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddAdaptationnull15_failAssert2() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(4);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationnull15 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddAdaptationlitNum1_mg70() throws Exception {
        Adaptation __DSPOT_a_8 = new Adaptation();
        Adaptation adaptation = createAdaptation(5);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitNum1__6 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptationlitNum1_mg70__12 = adaptation.compareTo(__DSPOT_a_8);
        assertEquals(0, ((int) (o_testAddAdaptationlitNum1_mg70__12)));
    }

    @Test(timeout = 240000)
    public void testAddAdaptationlitNum1null108_failAssert3() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(5);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptationlitNum1__6 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationlitNum1null108 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddAdaptationlitNum1null112_failAssert4() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(5);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            HttpStatus o_testAddAdaptationlitNum1__6 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationlitNum1null112 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddAdaptation_mg7null150_failAssert5() throws Exception {
        try {
            Adaptation __DSPOT_a_0 = new Adaptation();
            Adaptation adaptation = createAdaptation(null);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptation_mg7__8 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptation_mg7__10 = adaptation.compareTo(__DSPOT_a_0);
            org.junit.Assert.fail("testAddAdaptation_mg7null150 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddAdaptationnull15_failAssert2litNum62_failAssert49() throws Exception {
        try {
            {
                Adaptation adaptation = createAdaptation(3);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(null);
                AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddAdaptationnull15 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddAdaptationnull15_failAssert2litNum62 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddAdaptationlitNum1_mg70_mg367() throws Exception {
        Adaptation __DSPOT_a_43 = new Adaptation();
        Adaptation __DSPOT_a_8 = new Adaptation();
        Adaptation adaptation = createAdaptation(5);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testAddAdaptationlitNum1__6 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptationlitNum1_mg70__12 = adaptation.compareTo(__DSPOT_a_8);
        int o_testAddAdaptationlitNum1_mg70_mg367__17 = __DSPOT_a_8.compareTo(__DSPOT_a_43);
        assertEquals(0, ((int) (o_testAddAdaptationlitNum1_mg70_mg367__17)));
    }

    @Test(timeout = 240000)
    public void testAddAdaptationlitNum1_mg70_mg394_failAssert71() throws Exception {
        try {
            Date __DSPOT_computation_timestamp_78 = new Date("w#I]LDWP=,y4JV)d4}^w");
            Adaptation __DSPOT_a_8 = new Adaptation();
            Adaptation adaptation = createAdaptation(5);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptationlitNum1__6 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptationlitNum1_mg70__12 = adaptation.compareTo(__DSPOT_a_8);
            adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_78);
            org.junit.Assert.fail("testAddAdaptationlitNum1_mg70_mg394 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddAdaptationlitNum1_mg70null416_failAssert72() throws Exception {
        try {
            Adaptation __DSPOT_a_8 = new Adaptation();
            Adaptation adaptation = createAdaptation(5);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            HttpStatus o_testAddAdaptationlitNum1__6 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptationlitNum1_mg70__12 = adaptation.compareTo(__DSPOT_a_8);
            org.junit.Assert.fail("testAddAdaptationlitNum1_mg70null416 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddAdaptationlitNum1_mg70null417_failAssert73() throws Exception {
        try {
            Adaptation __DSPOT_a_8 = new Adaptation();
            Adaptation adaptation = createAdaptation(5);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            HttpStatus o_testAddAdaptationlitNum1__6 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptationlitNum1_mg70__12 = adaptation.compareTo(__DSPOT_a_8);
            org.junit.Assert.fail("testAddAdaptationlitNum1_mg70null417 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddAdaptation_mg7null150_failAssert5_mg366_failAssert88() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_42 = new Adaptation();
                Adaptation __DSPOT_a_0 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                HttpStatus o_testAddAdaptation_mg7__8 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testAddAdaptation_mg7__10 = adaptation.compareTo(__DSPOT_a_0);
                org.junit.Assert.fail("testAddAdaptation_mg7null150 should have thrown HttpMessageNotWritableException");
                __DSPOT_a_0.compareTo(__DSPOT_a_42);
            }
            org.junit.Assert.fail("testAddAdaptation_mg7null150_failAssert5_mg366 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddAdaptation_mg7null150_failAssert5null405_failAssert102() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_0 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                HttpStatus o_testAddAdaptation_mg7__8 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                int o_testAddAdaptation_mg7__10 = adaptation.compareTo(null);
                org.junit.Assert.fail("testAddAdaptation_mg7null150 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testAddAdaptation_mg7null150_failAssert5null405 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    private Adaptation createAdaptation(Integer fc_id) {
        Adaptation adaptation = new Adaptation();
        adaptation.setFc_id(fc_id);
        adaptation.setComputation_timestamp(Calendar.getInstance().getTime());
        adaptation.setModel_system(ModelSystem.Atos_HSK);
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

    @Test(timeout = 240000)
    public void testGetAllEnactmentsnull2206_failAssert493() throws Exception {
        try {
            List<Enactment> enactments = AmplAdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(null);
            org.junit.Assert.fail("testGetAllEnactmentsnull2206 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetEnactmentlitNum2210_failAssert494() throws Exception {
        try {
            List<Enactment> enactments = AmplAdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AmplAdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(-1).getFc_id());
            Assert.notNull(enactment);
            org.junit.Assert.fail("testGetEnactmentlitNum2210 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetEnactmentlitNum2212_failAssert496() throws Exception {
        try {
            List<Enactment> enactments = AmplAdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AmplAdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(Integer.MIN_VALUE).getFc_id());
            Assert.notNull(enactment);
            org.junit.Assert.fail("testGetEnactmentlitNum2212 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetEnactmentnull2221_failAssert499() throws Exception {
        try {
            List<Enactment> enactments = AmplAdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AmplAdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
            Assert.notNull(null);
            org.junit.Assert.fail("testGetEnactmentnull2221 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetEnactmentlitNum2210_failAssert494_mg2255_failAssert500() throws Exception {
        try {
            {
                Adaptation __DSPOT_adaptation_345 = new Adaptation();
                List<Enactment> enactments = AmplAdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AmplAdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(-1).getFc_id());
                Assert.notNull(enactment);
                org.junit.Assert.fail("testGetEnactmentlitNum2210 should have thrown ArrayIndexOutOfBoundsException");
                enactment.setAdaptation(__DSPOT_adaptation_345);
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2210_failAssert494_mg2255 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetEnactmentlitNum2210_failAssert494_mg2262_failAssert501() throws Exception {
        try {
            {
                Date __DSPOT_enactment_completion_time_348 = new Date(-1505141380, -847803688, -1090819783);
                List<Enactment> enactments = AmplAdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AmplAdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(-1).getFc_id());
                Assert.notNull(enactment);
                org.junit.Assert.fail("testGetEnactmentlitNum2210 should have thrown ArrayIndexOutOfBoundsException");
                enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_348);
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2210_failAssert494_mg2262 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetEnactmentlitNum2212_failAssert496_mg2260_failAssert508() throws Exception {
        try {
            {
                Date __DSPOT_enactment_completion_time_347 = new Date("`39dL#}_3(,uc,zul%aS");
                List<Enactment> enactments = AmplAdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AmplAdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(Integer.MIN_VALUE).getFc_id());
                Assert.notNull(enactment);
                org.junit.Assert.fail("testGetEnactmentlitNum2212 should have thrown ArrayIndexOutOfBoundsException");
                enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_347);
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2212_failAssert496_mg2260 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetEnactmentnull2221_failAssert499litNum2257_failAssert514() throws Exception {
        try {
            {
                List<Enactment> enactments = AmplAdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AmplAdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(1).getFc_id());
                Assert.notNull(null);
                org.junit.Assert.fail("testGetEnactmentnull2221 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetEnactmentnull2221_failAssert499litNum2257 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetEnactmentlitNum2210_failAssert494_mg2255_failAssert500null2374_failAssert526() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_adaptation_345 = new Adaptation();
                    List<Enactment> enactments = AmplAdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(null);
                    Enactment enactment = AmplAdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(-1).getFc_id());
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testGetEnactmentlitNum2210 should have thrown ArrayIndexOutOfBoundsException");
                    enactment.setAdaptation(__DSPOT_adaptation_345);
                }
                org.junit.Assert.fail("testGetEnactmentlitNum2210_failAssert494_mg2255 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2210_failAssert494_mg2255_failAssert500null2374 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetEnactmentlitNum2210_failAssert494_mg2262_failAssert501null2366_failAssert529() throws Exception {
        try {
            {
                {
                    Date __DSPOT_enactment_completion_time_348 = new Date(-1505141380, -847803688, -1090819783);
                    List<Enactment> enactments = AmplAdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(null);
                    Enactment enactment = AmplAdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(-1).getFc_id());
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testGetEnactmentlitNum2210 should have thrown ArrayIndexOutOfBoundsException");
                    enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_348);
                }
                org.junit.Assert.fail("testGetEnactmentlitNum2210_failAssert494_mg2262 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2210_failAssert494_mg2262_failAssert501null2366 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetEnactmentlitNum2212_failAssert496_mg2260_failAssert508litString2333_failAssert532() throws Exception {
        try {
            {
                {
                    Date __DSPOT_enactment_completion_time_347 = new Date("adaptation");
                    List<Enactment> enactments = AmplAdaptationDashboardProxyTest.proxy.getAllEnactments();
                    Assert.notNull(enactments);
                    Enactment enactment = AmplAdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(Integer.MIN_VALUE).getFc_id());
                    Assert.notNull(enactment);
                    org.junit.Assert.fail("testGetEnactmentlitNum2212 should have thrown ArrayIndexOutOfBoundsException");
                    enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_347);
                }
                org.junit.Assert.fail("testGetEnactmentlitNum2212_failAssert496_mg2260 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetEnactmentlitNum2212_failAssert496_mg2260_failAssert508litString2333 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentlitNum543() throws Exception {
        Adaptation adaptation = createAdaptation(6);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Enactment enactment = createEnactment(adaptation.getFc_id());
        enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        HttpStatus o_testAddEnactmentlitNum543__11 = AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
        assertEquals("OK", ((HttpStatus) (o_testAddEnactmentlitNum543__11)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum543__11)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddEnactmentlitNum543__11)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum543__11)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum543__11)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum543__11)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitNum543__11)).toString());
        HttpStatus o_testAddEnactmentlitNum543__13 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", ((HttpStatus) (o_testAddEnactmentlitNum543__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum543__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddEnactmentlitNum543__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum543__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum543__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum543__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitNum543__13)).toString());
        assertEquals("OK", ((HttpStatus) (o_testAddEnactmentlitNum543__11)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum543__11)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddEnactmentlitNum543__11)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum543__11)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum543__11)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum543__11)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitNum543__11)).toString());
    }

    @Test(timeout = 240000)
    public void testAddEnactmentlitNum544() throws Exception {
        Adaptation adaptation = createAdaptation(4);
        adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
        Enactment enactment = createEnactment(adaptation.getFc_id());
        enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        HttpStatus o_testAddEnactmentlitNum544__11 = AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
        assertEquals("OK", ((HttpStatus) (o_testAddEnactmentlitNum544__11)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum544__11)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddEnactmentlitNum544__11)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum544__11)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum544__11)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum544__11)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitNum544__11)).toString());
        HttpStatus o_testAddEnactmentlitNum544__13 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("OK", ((HttpStatus) (o_testAddEnactmentlitNum544__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum544__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddEnactmentlitNum544__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum544__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum544__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum544__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitNum544__13)).toString());
        assertEquals("OK", ((HttpStatus) (o_testAddEnactmentlitNum544__11)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum544__11)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddEnactmentlitNum544__11)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum544__11)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum544__11)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddEnactmentlitNum544__11)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddEnactmentlitNum544__11)).toString());
    }

    @Test(timeout = 240000)
    public void testAddEnactmentnull560_failAssert104() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(null);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentnull560 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentnull561_failAssert105() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(5);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentnull561 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentnull562_failAssert106() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(5);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(null);
            Assert.notNull(enactment);
            AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentnull562 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentlitNum543_mg644_failAssert108() throws Exception {
        try {
            Adaptation __DSPOT_a_103 = new Adaptation();
            Adaptation adaptation = createAdaptation(6);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            HttpStatus o_testAddEnactmentlitNum543__11 = AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            HttpStatus o_testAddEnactmentlitNum543__13 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            adaptation.compareTo(__DSPOT_a_103);
            org.junit.Assert.fail("testAddEnactmentlitNum543_mg644 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentlitNum543_mg676_failAssert112() throws Exception {
        try {
            String __DSPOT_name_130 = "D9P/&h4]]s%=])JWOM_4";
            Adaptation adaptation = createAdaptation(6);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            HttpStatus o_testAddEnactmentlitNum543__11 = AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            HttpStatus o_testAddEnactmentlitNum543__13 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            adaptation.setName(__DSPOT_name_130);
            org.junit.Assert.fail("testAddEnactmentlitNum543_mg676 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentlitNum543null729_failAssert119() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(6);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            HttpStatus o_testAddEnactmentlitNum543__11 = AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            HttpStatus o_testAddEnactmentlitNum543__13 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentlitNum543null729 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentlitNum543null732_failAssert120() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(6);
            adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(null);
            Assert.notNull(enactment);
            HttpStatus o_testAddEnactmentlitNum543__11 = AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            HttpStatus o_testAddEnactmentlitNum543__13 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentlitNum543null732 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentnull560_failAssert104_mg623_failAssert136() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_94 = new Adaptation();
                Adaptation adaptation = createAdaptation(null);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactmentnull560 should have thrown HttpMessageNotWritableException");
                adaptation.compareTo(__DSPOT_a_94);
            }
            org.junit.Assert.fail("testAddEnactmentnull560_failAssert104_mg623 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentnull560_failAssert104_mg653_failAssert144() throws Exception {
        try {
            {
                Date __DSPOT_enactment_request_timestamp_112 = new Date("Va&1`i[aMe!@y;s?/OCD");
                Adaptation adaptation = createAdaptation(null);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactmentnull560 should have thrown HttpMessageNotWritableException");
                enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_112);
            }
            org.junit.Assert.fail("testAddEnactmentnull560_failAssert104_mg653 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentnull562_failAssert106_rv744_failAssert236() throws Exception {
        try {
            {
                Adaptation adaptation = createAdaptation(5);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(null);
                Assert.notNull(enactment);
                AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                HttpStatus __DSPOT_invoc_15 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactmentnull562 should have thrown NullPointerException");
                __DSPOT_invoc_15.is4xxClientError();
            }
            org.junit.Assert.fail("testAddEnactmentnull562_failAssert106_rv744 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentlitNum543_mg644_failAssert108_mg1050_failAssert244() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_151 = new Adaptation();
                Adaptation __DSPOT_a_103 = new Adaptation();
                Adaptation adaptation = createAdaptation(6);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                HttpStatus o_testAddEnactmentlitNum543__11 = AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                HttpStatus o_testAddEnactmentlitNum543__13 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                adaptation.compareTo(__DSPOT_a_103);
                org.junit.Assert.fail("testAddEnactmentlitNum543_mg644 should have thrown HttpMessageNotReadableException");
                __DSPOT_a_103.compareTo(__DSPOT_a_151);
            }
            org.junit.Assert.fail("testAddEnactmentlitNum543_mg644_failAssert108_mg1050 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentlitNum543_mg644_failAssert108_mg1064_failAssert246() throws Exception {
        try {
            {
                Date __DSPOT_computation_timestamp_160 = new Date("&5+;N4Sb)kE+#PmjF|_k");
                Adaptation __DSPOT_a_103 = new Adaptation();
                Adaptation adaptation = createAdaptation(6);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                HttpStatus o_testAddEnactmentlitNum543__11 = AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                HttpStatus o_testAddEnactmentlitNum543__13 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                adaptation.compareTo(__DSPOT_a_103);
                org.junit.Assert.fail("testAddEnactmentlitNum543_mg644 should have thrown HttpMessageNotReadableException");
                __DSPOT_a_103.setComputation_timestamp(__DSPOT_computation_timestamp_160);
            }
            org.junit.Assert.fail("testAddEnactmentlitNum543_mg644_failAssert108_mg1064 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentlitNum543_mg644_failAssert108null1165_failAssert261() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_103 = new Adaptation();
                Adaptation adaptation = createAdaptation(6);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(null);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                HttpStatus o_testAddEnactmentlitNum543__11 = AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                HttpStatus o_testAddEnactmentlitNum543__13 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                adaptation.compareTo(__DSPOT_a_103);
                org.junit.Assert.fail("testAddEnactmentlitNum543_mg644 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testAddEnactmentlitNum543_mg644_failAssert108null1165 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentlitNum543_mg644_failAssert108null1169_failAssert262() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_103 = new Adaptation();
                Adaptation adaptation = createAdaptation(6);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(null);
                Assert.notNull(enactment);
                HttpStatus o_testAddEnactmentlitNum543__11 = AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                HttpStatus o_testAddEnactmentlitNum543__13 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                adaptation.compareTo(__DSPOT_a_103);
                org.junit.Assert.fail("testAddEnactmentlitNum543_mg644 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testAddEnactmentlitNum543_mg644_failAssert108null1169 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentlitNum543_mg676_failAssert112_mg1189_failAssert281() throws Exception {
        try {
            {
                Date __DSPOT_enactment_request_timestamp_235 = new Date();
                String __DSPOT_name_130 = "D9P/&h4]]s%=])JWOM_4";
                Adaptation adaptation = createAdaptation(6);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                HttpStatus o_testAddEnactmentlitNum543__11 = AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                HttpStatus o_testAddEnactmentlitNum543__13 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                adaptation.setName(__DSPOT_name_130);
                org.junit.Assert.fail("testAddEnactmentlitNum543_mg676 should have thrown HttpMessageNotReadableException");
                enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_235);
            }
            org.junit.Assert.fail("testAddEnactmentlitNum543_mg676_failAssert112_mg1189 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentlitNum543null732_failAssert120_mg1053_failAssert301() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_153 = new Adaptation();
                Adaptation adaptation = createAdaptation(6);
                adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = createEnactment(adaptation.getFc_id());
                enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(null);
                Assert.notNull(enactment);
                HttpStatus o_testAddEnactmentlitNum543__11 = AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                HttpStatus o_testAddEnactmentlitNum543__13 = AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactmentlitNum543null732 should have thrown NullPointerException");
                adaptation.compareTo(__DSPOT_a_153);
            }
            org.junit.Assert.fail("testAddEnactmentlitNum543null732_failAssert120_mg1053 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAddEnactmentnull560_failAssert104_mg623_failAssert136null1218_failAssert315() throws Exception {
        try {
            {
                {
                    Adaptation __DSPOT_a_94 = new Adaptation();
                    Adaptation adaptation = createAdaptation(null);
                    adaptation = AmplAdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                    Enactment enactment = createEnactment(adaptation.getFc_id());
                    enactment = AmplAdaptationDashboardProxyTest.proxy.addEnactment(null);
                    Assert.notNull(enactment);
                    AmplAdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                    AmplAdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    org.junit.Assert.fail("testAddEnactmentnull560 should have thrown HttpMessageNotWritableException");
                    adaptation.compareTo(__DSPOT_a_94);
                }
                org.junit.Assert.fail("testAddEnactmentnull560_failAssert104_mg623 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testAddEnactmentnull560_failAssert104_mg623_failAssert136null1218 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
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

