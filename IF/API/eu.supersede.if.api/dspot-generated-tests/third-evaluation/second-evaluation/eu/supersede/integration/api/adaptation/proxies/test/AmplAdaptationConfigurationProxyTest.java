package eu.supersede.integration.api.adaptation.proxies.test;


import eu.supersede.integration.api.adaptation.proxies.AdaptationConfigurationProxy;
import eu.supersede.integration.api.adaptation.types.AdaptationMode;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.springframework.util.Assert.notNull;


public class AmplAdaptationConfigurationProxyTest {
    private static AdaptationConfigurationProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplAdaptationConfigurationProxyTest.proxy = new AdaptationConfigurationProxy<Object, Object>();
    }

    @Test(timeout = 10000)
    public void testAdaptationMode_add1() throws Exception {
        AdaptationMode o_testAdaptationMode_add1__1 = AdaptationMode.valueOf("SUPERVISED");
        Assert.assertEquals("SUPERVISED", ((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testAdaptationMode_add1__1).name());
        Assert.assertEquals("supervised", ((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testAdaptationMode_add1__1).getMode());
        Assert.assertEquals(0, ((int) (((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testAdaptationMode_add1__1).ordinal())));
        AdaptationMode mode = AdaptationMode.valueOf("SUPERVISED");
    }

    @Test(timeout = 10000)
    public void testAdaptationMode_literalMutationString3_failAssert0() throws Exception {
        try {
            AdaptationMode mode = AdaptationMode.valueOf("");
            org.junit.Assert.fail("testAdaptationMode_literalMutationString3 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAdaptationMode_literalMutationString4_failAssert1() throws Exception {
        try {
            AdaptationMode mode = AdaptationMode.valueOf("googleplay_api_googleplay_tool");
            org.junit.Assert.fail("testAdaptationMode_literalMutationString4 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAdaptationMode_add1_add28() throws Exception {
        AdaptationMode o_testAdaptationMode_add1_add28__1 = AdaptationMode.valueOf("SUPERVISED");
        Assert.assertEquals("supervised", ((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testAdaptationMode_add1_add28__1).getMode());
        Assert.assertEquals(0, ((int) (((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testAdaptationMode_add1_add28__1).ordinal())));
        Assert.assertEquals("SUPERVISED", ((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testAdaptationMode_add1_add28__1).name());
        AdaptationMode o_testAdaptationMode_add1__1 = AdaptationMode.valueOf("SUPERVISED");
        AdaptationMode mode = AdaptationMode.valueOf("SUPERVISED");
    }

    @Test(timeout = 10000)
    public void testAdaptationMode_add1_literalMutationString43_failAssert0() throws Exception {
        try {
            AdaptationMode o_testAdaptationMode_add1__1 = AdaptationMode.valueOf("");
            AdaptationMode mode = AdaptationMode.valueOf("SUPERVISED");
            org.junit.Assert.fail("testAdaptationMode_add1_literalMutationString43 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAdaptationMode_add1_literalMutationString54_failAssert11() throws Exception {
        try {
            AdaptationMode o_testAdaptationMode_add1__1 = AdaptationMode.valueOf("SUPERVISED");
            AdaptationMode mode = AdaptationMode.valueOf("SUUPERVISED");
            org.junit.Assert.fail("testAdaptationMode_add1_literalMutationString54 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAdaptationMode_add1_add28_add130() throws Exception {
        AdaptationMode o_testAdaptationMode_add1_add28_add130__1 = AdaptationMode.valueOf("SUPERVISED");
        Assert.assertEquals(0, ((int) (((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testAdaptationMode_add1_add28_add130__1).ordinal())));
        Assert.assertEquals("supervised", ((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testAdaptationMode_add1_add28_add130__1).getMode());
        Assert.assertEquals("SUPERVISED", ((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testAdaptationMode_add1_add28_add130__1).name());
        AdaptationMode o_testAdaptationMode_add1_add28__1 = AdaptationMode.valueOf("SUPERVISED");
        AdaptationMode o_testAdaptationMode_add1__1 = AdaptationMode.valueOf("SUPERVISED");
        AdaptationMode mode = AdaptationMode.valueOf("SUPERVISED");
    }

    @Test(timeout = 10000)
    public void testAdaptationMode_add1_add28_literalMutationString164_failAssert0() throws Exception {
        try {
            AdaptationMode o_testAdaptationMode_add1_add28__1 = AdaptationMode.valueOf("");
            AdaptationMode o_testAdaptationMode_add1__1 = AdaptationMode.valueOf("SUPERVISED");
            AdaptationMode mode = AdaptationMode.valueOf("SUPERVISED");
            org.junit.Assert.fail("testAdaptationMode_add1_add28_literalMutationString164 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAdaptationMode_add1_add28_literalMutationString179_failAssert15() throws Exception {
        try {
            AdaptationMode o_testAdaptationMode_add1_add28__1 = AdaptationMode.valueOf("SUPERVISED");
            AdaptationMode o_testAdaptationMode_add1__1 = AdaptationMode.valueOf("SUPERVISED");
            AdaptationMode mode = AdaptationMode.valueOf("SPERVISED");
            org.junit.Assert.fail("testAdaptationMode_add1_add28_literalMutationString179 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetAdaptationConfigurationMode_add323() throws Exception {
        AdaptationMode o_testGetAdaptationConfigurationMode_add323__1 = AmplAdaptationConfigurationProxyTest.proxy.getAdaptationConfigurationMode();
        Assert.assertEquals("supervised", ((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testGetAdaptationConfigurationMode_add323__1).getMode());
        Assert.assertEquals(0, ((int) (((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testGetAdaptationConfigurationMode_add323__1).ordinal())));
        Assert.assertEquals("SUPERVISED", ((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testGetAdaptationConfigurationMode_add323__1).name());
        notNull(AmplAdaptationConfigurationProxyTest.proxy.getAdaptationConfigurationMode());
    }

    @Test(timeout = 10000)
    public void testGetAdaptationConfigurationMode_sd325() throws Exception {
        AdaptationMode mode = AmplAdaptationConfigurationProxyTest.proxy.getAdaptationConfigurationMode();
        notNull(mode);
        Assert.assertEquals("supervised", mode.getMode());
    }

    @Test(timeout = 10000)
    public void testGetAdaptationConfigurationMode_add323_add336() throws Exception {
        AdaptationMode o_testGetAdaptationConfigurationMode_add323_add336__1 = AmplAdaptationConfigurationProxyTest.proxy.getAdaptationConfigurationMode();
        Assert.assertEquals("SUPERVISED", ((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testGetAdaptationConfigurationMode_add323_add336__1).name());
        Assert.assertEquals("supervised", ((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testGetAdaptationConfigurationMode_add323_add336__1).getMode());
        Assert.assertEquals(0, ((int) (((eu.supersede.integration.api.adaptation.types.AdaptationMode)o_testGetAdaptationConfigurationMode_add323_add336__1).ordinal())));
        AdaptationMode o_testGetAdaptationConfigurationMode_add323__1 = AmplAdaptationConfigurationProxyTest.proxy.getAdaptationConfigurationMode();
        notNull(AmplAdaptationConfigurationProxyTest.proxy.getAdaptationConfigurationMode());
    }

    @Test(timeout = 10000)
    public void testGetAdaptationConfigurationMode_sd325_sd341() throws Exception {
        AdaptationMode mode = AmplAdaptationConfigurationProxyTest.proxy.getAdaptationConfigurationMode();
        notNull(mode);
        String o_testGetAdaptationConfigurationMode_sd325__4 = mode.getMode();
        Assert.assertEquals("supervised", o_testGetAdaptationConfigurationMode_sd325__4);
        Assert.assertEquals("supervised", mode.getMode());
    }
}

