package eu.supersede.integration.api.adaptation.proxies.test;


import eu.supersede.integration.api.adaptation.proxies.AdaptationConfigurationProxy;
import eu.supersede.integration.api.adaptation.types.AdaptationMode;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;


public class AdaptationConfigurationProxyTest_Ampl2 {
    private static AdaptationConfigurationProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AdaptationConfigurationProxyTest_Ampl2.proxy = new AdaptationConfigurationProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testGetAdaptationConfigurationModenull783_failAssert0() throws Exception {
        try {
            AdaptationMode mode = AdaptationConfigurationProxyTest_Ampl2.proxy.getAdaptationConfigurationMode();
            Assert.notNull(null);
            org.junit.Assert.fail("testGetAdaptationConfigurationModenull783 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationConfigurationModenull783_failAssert0_add795_failAssert0() throws Exception {
        try {
            {
                AdaptationConfigurationProxyTest_Ampl2.proxy.getAdaptationConfigurationMode();
                AdaptationMode mode = AdaptationConfigurationProxyTest_Ampl2.proxy.getAdaptationConfigurationMode();
                Assert.notNull(null);
                org.junit.Assert.fail("testGetAdaptationConfigurationModenull783 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAdaptationConfigurationModenull783_failAssert0_add795 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
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
    public void testAdaptationMode_add1_literalMutationString96_failAssert0() throws Exception {
        try {
            AdaptationMode o_testAdaptationMode_add1__1 = AdaptationMode.valueOf("SUPERVISED");
            AdaptationMode mode = AdaptationMode.valueOf("S@Rl&{ha!&");
            org.junit.Assert.fail("testAdaptationMode_add1_literalMutationString96 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("No enum constant eu.supersede.integration.api.adaptation.types.AdaptationMode.S@Rl&{ha!&", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAdaptationMode_add1_add68_literalMutationString378_failAssert0() throws Exception {
        try {
            AdaptationMode o_testAdaptationMode_add1_add68__1 = AdaptationMode.valueOf("SUPERVISED");
            AdaptationMode o_testAdaptationMode_add1__1 = AdaptationMode.valueOf("SUPERVI?SED");
            AdaptationMode mode = AdaptationMode.valueOf("SUPERVISED");
            org.junit.Assert.fail("testAdaptationMode_add1_add68_literalMutationString378 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("No enum constant eu.supersede.integration.api.adaptation.types.AdaptationMode.SUPERVI?SED", expected.getMessage());
        }
    }
}

