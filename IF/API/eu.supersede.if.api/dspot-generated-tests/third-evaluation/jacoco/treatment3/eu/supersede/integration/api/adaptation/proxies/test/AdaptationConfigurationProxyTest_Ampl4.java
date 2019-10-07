package eu.supersede.integration.api.adaptation.proxies.test;


import eu.supersede.integration.api.adaptation.proxies.AdaptationConfigurationProxy;
import eu.supersede.integration.api.adaptation.types.AdaptationMode;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AdaptationConfigurationProxyTest {
    private static AdaptationConfigurationProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AdaptationConfigurationProxyTest.proxy = new AdaptationConfigurationProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testGetAdaptationConfigurationModenull801_failAssert0() throws Exception {
        try {
            AdaptationMode mode = AdaptationConfigurationProxyTest.proxy.getAdaptationConfigurationMode();
            Assert.notNull(null);
            org.junit.Assert.fail("testGetAdaptationConfigurationModenull801 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationConfigurationModenull801_failAssert0_add813_failAssert0() throws Exception {
        try {
            {
                AdaptationConfigurationProxyTest.proxy.getAdaptationConfigurationMode();
                AdaptationMode mode = AdaptationConfigurationProxyTest.proxy.getAdaptationConfigurationMode();
                Assert.notNull(null);
                org.junit.Assert.fail("testGetAdaptationConfigurationModenull801 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAdaptationConfigurationModenull801_failAssert0_add813 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testSetAdaptationConfigurationMode() throws Exception {
        HttpStatus o_testSetAdaptationConfigurationMode__1 = AdaptationConfigurationProxyTest.proxy.setAdaptationConfigurationMode(AdaptationMode.SUPERVISED);
        assertEquals("OK", ((HttpStatus) (o_testSetAdaptationConfigurationMode__1)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testSetAdaptationConfigurationMode__1)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testSetAdaptationConfigurationMode__1)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testSetAdaptationConfigurationMode__1)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testSetAdaptationConfigurationMode__1)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testSetAdaptationConfigurationMode__1)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testSetAdaptationConfigurationMode__1)).toString());
    }

    @Test(timeout = 30000)
    public void testSetAdaptationConfigurationMode_add846_add858() throws Exception {
        HttpStatus o_testSetAdaptationConfigurationMode_add846__1 = AdaptationConfigurationProxyTest.proxy.setAdaptationConfigurationMode(AdaptationMode.SUPERVISED);
        HttpStatus o_testSetAdaptationConfigurationMode_add846_add858__4 = AdaptationConfigurationProxyTest.proxy.setAdaptationConfigurationMode(AdaptationMode.SUPERVISED);
        assertEquals("OK", ((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).toString());
        HttpStatus o_testSetAdaptationConfigurationMode_add846__2 = AdaptationConfigurationProxyTest.proxy.setAdaptationConfigurationMode(AdaptationMode.SUPERVISED);
        assertEquals("OK", ((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testSetAdaptationConfigurationMode_add846_add858__4)).toString());
    }

    @Test(timeout = 30000)
    public void testAdaptationMode_add1() throws Exception {
        AdaptationMode o_testAdaptationMode_add1__1 = AdaptationMode.valueOf("SUPERVISED");
        assertEquals("supervised", ((AdaptationMode) (o_testAdaptationMode_add1__1)).getMode());
        AdaptationMode mode = AdaptationMode.valueOf("SUPERVISED");
        assertEquals("supervised", ((AdaptationMode) (o_testAdaptationMode_add1__1)).getMode());
    }

    @Test(timeout = 30000)
    public void testAdaptationMode_literalMutationString2_failAssert0() throws Exception {
        try {
            AdaptationMode mode = AdaptationMode.valueOf("");
            org.junit.Assert.fail("testAdaptationMode_literalMutationString2 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("No enum constant eu.supersede.integration.api.adaptation.types.AdaptationMode.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAdaptationMode_literalMutationString4_failAssert0() throws Exception {
        try {
            AdaptationMode mode = AdaptationMode.valueOf("SUPER*ISED");
            org.junit.Assert.fail("testAdaptationMode_literalMutationString4 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("No enum constant eu.supersede.integration.api.adaptation.types.AdaptationMode.SUPER*ISED", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAdaptationMode_add1_literalMutationString99_failAssert0() throws Exception {
        try {
            AdaptationMode o_testAdaptationMode_add1__1 = AdaptationMode.valueOf("SUPERVISED");
            AdaptationMode mode = AdaptationMode.valueOf("Rl&{ha!&Bc");
            org.junit.Assert.fail("testAdaptationMode_add1_literalMutationString99 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("No enum constant eu.supersede.integration.api.adaptation.types.AdaptationMode.Rl&{ha!&Bc", expected.getMessage());
        }
    }
}

