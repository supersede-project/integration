package eu.supersede.integration.api.adaptation.proxies.test;


import eu.supersede.integration.api.adaptation.proxies.ModelRepositoryProxy;
import eu.supersede.integration.api.adaptation.types.AdaptabilityModel;
import eu.supersede.integration.api.adaptation.types.BaseModel;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ITypedModelId;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;
import eu.supersede.integration.api.adaptation.types.Status;
import eu.supersede.integration.api.adaptation.types.TypedModelId;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import static org.junit.Assert.assertEquals;


public class AmplModelRepositoryProxyTest {
    private static ModelRepositoryProxy<?, ?> proxy;

    private static IModel baseModel;

    @BeforeClass
    public static void setup() throws Exception {
        AmplModelRepositoryProxyTest.proxy = new ModelRepositoryProxy<Object, Object>();
        List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, ModelSystem.Atos_HSK, null);
        Assert.notEmpty(result);
        AmplModelRepositoryProxyTest.baseModel = result.get(0);
        Assert.notNull(AmplModelRepositoryProxyTest.baseModel);
    }

    @Test(timeout = 240000)
    public void testGetAllAdaptationModelsnull1802_failAssert194() throws Exception {
        try {
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, ModelSystem.Atos_HSK, null);
            Assert.notNull(null);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testGetAllAdaptationModelsnull1802 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllFCModelsnull3889_failAssert767() throws Exception {
        try {
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.FeatureConfiguration, ModelSystem.Atos_HSK, null);
            Assert.notNull(null);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testGetAllFCModelsnull3889 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1809_failAssert195() throws Exception {
        try {
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("zavala").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModelslitString1809 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a zavala field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitNum1815_failAssert200() throws Exception {
        try {
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(-1).getValue("id").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModelslitNum1815 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1820_failAssert204() throws Exception {
        try {
            String __DSPOT_property_290 = "T7=5zOkK&a$)LIMmqw=M";
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model);
            model.getValue(__DSPOT_property_290);
            org.junit.Assert.fail("testGetAllBaseModels_mg1820 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a T7=5zOkK&a$)LIMmqw=M field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1821_failAssert205() throws Exception {
        try {
            Object __DSPOT_value_292 = new Object();
            String __DSPOT_property_291 = "a !VX)*-a  F#YgRr^w4";
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model);
            model.setValue(__DSPOT_property_291, __DSPOT_value_292);
            org.junit.Assert.fail("testGetAllBaseModels_mg1821 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a a !VX)*-a  F#YgRr^w4 field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsnull1822_failAssert206() throws Exception {
        try {
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(null);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModelsnull1822 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsnull1826_failAssert209() throws Exception {
        try {
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(null);
            org.junit.Assert.fail("testGetAllBaseModelsnull1826 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1809_failAssert195litNum1896_failAssert210() throws Exception {
        try {
            {
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(1).getValue("zavala").toString());
                Assert.notNull(model);
                org.junit.Assert.fail("testGetAllBaseModelslitString1809 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitString1809_failAssert195litNum1896 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a zavala field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1809_failAssert195litNum1900_failAssert211() throws Exception {
        try {
            {
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(-1).getValue("zavala").toString());
                Assert.notNull(model);
                org.junit.Assert.fail("testGetAllBaseModelslitString1809 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitString1809_failAssert195litNum1900 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitNum1815_failAssert200null1936_failAssert226() throws Exception {
        try {
            {
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(null);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(-1).getValue("id").toString());
                Assert.notNull(model);
                org.junit.Assert.fail("testGetAllBaseModelslitNum1815 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitNum1815_failAssert200null1936 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1820_failAssert204litString1869_failAssert230() throws Exception {
        try {
            {
                String __DSPOT_property_290 = "\n";
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model);
                model.getValue(__DSPOT_property_290);
                org.junit.Assert.fail("testGetAllBaseModels_mg1820 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert204litString1869 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a \n field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1820_failAssert204null1977_failAssert259() throws Exception {
        try {
            {
                String __DSPOT_property_290 = null;
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model);
                model.getValue(__DSPOT_property_290);
                org.junit.Assert.fail("testGetAllBaseModels_mg1820 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert204null1977 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1821_failAssert205litString1865_failAssert265() throws Exception {
        try {
            {
                Object __DSPOT_value_292 = new Object();
                String __DSPOT_property_291 = "";
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model);
                model.setValue(__DSPOT_property_291, __DSPOT_value_292);
                org.junit.Assert.fail("testGetAllBaseModels_mg1821 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1821_failAssert205litString1865 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a  field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1809_failAssert195litNum1896_failAssert210null2258_failAssert324() throws Exception {
        try {
            {
                {
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(1).getValue("zavala").toString());
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetAllBaseModelslitString1809 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelslitString1809_failAssert195litNum1896 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitString1809_failAssert195litNum1896_failAssert210null2258 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a zavala field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1809_failAssert195litNum1900_failAssert211null2262_failAssert325() throws Exception {
        try {
            {
                {
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(-1).getValue("zavala").toString());
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetAllBaseModelslitString1809 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelslitString1809_failAssert195litNum1900 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitString1809_failAssert195litNum1900_failAssert211null2262 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitNum1815_failAssert200null1936_failAssert226litString2228_failAssert326() throws Exception {
        try {
            {
                {
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(null);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(-1).getValue("googleplay_api_googleplay_tool").toString());
                    Assert.notNull(model);
                    org.junit.Assert.fail("testGetAllBaseModelslitNum1815 should have thrown ArrayIndexOutOfBoundsException");
                }
                org.junit.Assert.fail("testGetAllBaseModelslitNum1815_failAssert200null1936 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitNum1815_failAssert200null1936_failAssert226litString2228 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1820_failAssert204litString1869_failAssert230litNum2237_failAssert339() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_290 = "\n";
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(1).getValue("id").toString());
                    Assert.notNull(model);
                    model.getValue(__DSPOT_property_290);
                    org.junit.Assert.fail("testGetAllBaseModels_mg1820 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert204litString1869 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert204litString1869_failAssert230litNum2237 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a \n field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1820_failAssert204litString1869_failAssert230null2290_failAssert348() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_290 = "\n";
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(null);
                    model.getValue(__DSPOT_property_290);
                    org.junit.Assert.fail("testGetAllBaseModels_mg1820 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert204litString1869 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert204litString1869_failAssert230null2290 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1820_failAssert204null1977_failAssert259litString2222_failAssert350() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_290 = null;
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("relativePath").toString());
                    Assert.notNull(model);
                    model.getValue(__DSPOT_property_290);
                    org.junit.Assert.fail("testGetAllBaseModels_mg1820 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert204null1977 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert204null1977_failAssert259litString2222 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1821_failAssert205litString1865_failAssert265litNum2246_failAssert371() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_292 = new Object();
                    String __DSPOT_property_291 = "";
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(1).getValue("id").toString());
                    Assert.notNull(model);
                    model.setValue(__DSPOT_property_291, __DSPOT_value_292);
                    org.junit.Assert.fail("testGetAllBaseModels_mg1821 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModels_mg1821_failAssert205litString1865 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1821_failAssert205litString1865_failAssert265litNum2246 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a  field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2464_failAssert383() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("fileExtension"))));
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2464 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2465_failAssert384() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("auth7rId"))));
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2465 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a auth7rId field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2473_failAssert391() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("=").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2473 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a = field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2478_failAssert395() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("H"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2478 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a H field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404() throws Exception {
        try {
            Object __DSPOT_value_344 = new Object();
            String __DSPOT_property_343 = ";F#O7,e!<J!z&e#9R[n4";
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            model.setValue(__DSPOT_property_343, __DSPOT_value_344);
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a ;F#O7,e!<J!z&e#9R[n4 field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatanull2491_failAssert405() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue(null))));
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2491 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatanull2492_failAssert406() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2492 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid metadata", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatanull2493_failAssert407() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(null);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2493 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411() throws Exception {
        try {
            {
                Object __DSPOT_value_372 = new Object();
                String __DSPOT_property_371 = "Zw%-9j57v[dc=WO=QzF5";
                Object __DSPOT_value_344 = new Object();
                String __DSPOT_property_343 = ";F#O7,e!<J!z&e#9R[n4";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
                model.setValue(__DSPOT_property_371, __DSPOT_value_372);
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a ;F#O7,e!<J!z&e#9R[n4 field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2464_failAssert383_mg2708_failAssert414() throws Exception {
        try {
            {
                Object __DSPOT_value_368 = new Object();
                String __DSPOT_property_367 = "ev !-3SN*sw)`v}zN/0N";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("fileExtension"))));
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2464 should have thrown IllegalArgumentException");
                model.setValue(__DSPOT_property_367, __DSPOT_value_368);
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2464_failAssert383_mg2708 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatanull2493_failAssert407_mg2699_failAssert415() throws Exception {
        try {
            {
                Object __DSPOT_value_364 = new Object();
                String __DSPOT_property_363 = ")5f-JJZB2+%9x<5]|k5a";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(null);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2493 should have thrown IllegalArgumentException");
                model.setValue(__DSPOT_property_363, __DSPOT_value_364);
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2493_failAssert407_mg2699 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404litNum2707_failAssert416() throws Exception {
        try {
            {
                Object __DSPOT_value_344 = new Object();
                String __DSPOT_property_343 = ";F#O7,e!<J!z&e#9R[n4";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(Integer.MIN_VALUE).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404litNum2707 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404litString2683_failAssert419() throws Exception {
        try {
            {
                Object __DSPOT_value_344 = new Object();
                String __DSPOT_property_343 = ";F#O7,e!<J!z&e#9R[n4";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("GooglePlay"));
                model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404litString2683 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a GooglePlay field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404litString2664_failAssert421() throws Exception {
        try {
            {
                Object __DSPOT_value_344 = new Object();
                String __DSPOT_property_343 = ";F#O7,e!<J!z&e#9R[n4";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("authorId").toString());
                Assert.notNull(model.getValue("id"));
                model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404litString2664 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2465_failAssert384_mg2695_failAssert422() throws Exception {
        try {
            {
                Object __DSPOT_value_358 = new Object();
                String __DSPOT_property_357 = "pT%vt_F}Hln6O(.TI(`V";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("auth7rId"))));
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2465 should have thrown Exception");
                model.setValue(__DSPOT_property_357, __DSPOT_value_358);
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2465_failAssert384_mg2695 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a auth7rId field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatanull2492_failAssert406_mg2773_failAssert431() throws Exception {
        try {
            {
                Object __DSPOT_value_376 = new Object();
                String __DSPOT_property_375 = "7BI]Rw}{*r:hZ=ZTOAJL";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2492 should have thrown IllegalArgumentException");
                model.setValue(__DSPOT_property_375, __DSPOT_value_376);
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2492_failAssert406_mg2773 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid metadata", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404litString2570_failAssert432() throws Exception {
        try {
            {
                Object __DSPOT_value_344 = new Object();
                String __DSPOT_property_343 = "relativePath";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404litString2570 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Can not set java.lang.String field eu.supersede.integration.api.adaptation.types.GenericModel.relativePath to java.lang.Object", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatanull2491_failAssert405null2725_failAssert443() throws Exception {
        try {
            {
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue(null))));
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2491 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2491_failAssert405null2725 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatanull2492_failAssert406litString2703_failAssert539() throws Exception {
        try {
            {
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("dependencies"))));
                List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2492 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2492_failAssert406litString2703 should have thrown ClassCastException");
        } catch (ClassCastException expected) {
            assertEquals("java.util.ArrayList cannot be cast to java.lang.String", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatanull2491_failAssert405null2725_failAssert443null3502_failAssert606() throws Exception {
        try {
            {
                {
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue(null))));
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null);
                    Assert.notNull(null);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2491 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2491_failAssert405null2725 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2491_failAssert405null2725_failAssert443null3502 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatanull2492_failAssert406litString2703_failAssert539null3513_failAssert626() throws Exception {
        try {
            {
                {
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("dependencies"))));
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null);
                    Assert.notNull(null);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2492 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2492_failAssert406litString2703 should have thrown ClassCastException");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2492_failAssert406litString2703_failAssert539null3513 should have thrown ClassCastException");
        } catch (ClassCastException expected) {
            assertEquals("java.util.ArrayList cannot be cast to java.lang.String", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411litString3355_failAssert646() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_372 = new Object();
                    String __DSPOT_property_371 = "Zw%-9j57v[dc=WO=QzF5";
                    Object __DSPOT_value_344 = new Object();
                    String __DSPOT_property_343 = ";F#O7,e!<J!z&e#9R[n4";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("googleplay_api_googleplay_tool"));
                    model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
                    model.setValue(__DSPOT_property_371, __DSPOT_value_372);
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411litString3355 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a googleplay_api_googleplay_tool field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411litNum3396_failAssert647() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_372 = new Object();
                    String __DSPOT_property_371 = "Zw%-9j57v[dc=WO=QzF5";
                    Object __DSPOT_value_344 = new Object();
                    String __DSPOT_property_343 = ";F#O7,e!<J!z&e#9R[n4";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(Integer.MIN_VALUE).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
                    model.setValue(__DSPOT_property_371, __DSPOT_value_372);
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411litNum3396 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411litString3323_failAssert649() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_372 = new Object();
                    String __DSPOT_property_371 = "Zw%-9j57v[dc=WO=QzF5";
                    Object __DSPOT_value_344 = new Object();
                    String __DSPOT_property_343 = ";F#O7,e!<J!z&e#9R[n4";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("creationDate").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
                    model.setValue(__DSPOT_property_371, __DSPOT_value_372);
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411litString3323 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 77: http://supersede.es.atos.net:8280/modelrepositorymanager/models/BaseModel/Mon Nov 12 15:37:11 CET 2018", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411litString3260_failAssert650() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_372 = new Object();
                    String __DSPOT_property_371 = "Zw%-9j57v[dc=WO=QzF5";
                    Object __DSPOT_value_344 = new Object();
                    String __DSPOT_property_343 = "HnJBZ}O[]Ip/#WP}M8a6";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
                    model.setValue(__DSPOT_property_371, __DSPOT_value_372);
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411litString3260 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a HnJBZ}O[]Ip/#WP}M8a6 field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411litString3302_failAssert654() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_372 = new Object();
                    String __DSPOT_property_371 = "Zw%-9j57v[dc=WO=QzF5";
                    Object __DSPOT_value_344 = new Object();
                    String __DSPOT_property_343 = ";F#O7,e!<J!z&e#9R[n4";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("aLuthorId"))));
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
                    model.setValue(__DSPOT_property_371, __DSPOT_value_372);
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411litString3302 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a aLuthorId field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411null3468_failAssert679() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_372 = new Object();
                    String __DSPOT_property_371 = "Zw%-9j57v[dc=WO=QzF5";
                    Object __DSPOT_value_344 = new Object();
                    String __DSPOT_property_343 = ";F#O7,e!<J!z&e#9R[n4";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(null);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
                    model.setValue(__DSPOT_property_371, __DSPOT_value_372);
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411null3468 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411null3462_failAssert683() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_372 = new Object();
                    String __DSPOT_property_371 = "Zw%-9j57v[dc=WO=QzF5";
                    Object __DSPOT_value_344 = new Object();
                    String __DSPOT_property_343 = ";F#O7,e!<J!z&e#9R[n4";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
                    model.setValue(__DSPOT_property_371, __DSPOT_value_372);
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411null3462 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid metadata", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411litString3236_failAssert685() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_372 = new Object();
                    String __DSPOT_property_371 = "Zw%-9j57v[dc=WO=QzF5";
                    Object __DSPOT_value_344 = new Object();
                    String __DSPOT_property_343 = "id";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_343, __DSPOT_value_344);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490 should have thrown Exception");
                    model.setValue(__DSPOT_property_371, __DSPOT_value_372);
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2490_failAssert404_mg2738_failAssert411litString3236 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Can not set java.lang.String field eu.supersede.integration.api.adaptation.types.GenericModel.id to java.lang.Object", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2464_failAssert383_mg2708_failAssert414litNum3277_failAssert700() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_368 = new Object();
                    String __DSPOT_property_367 = "ev !-3SN*sw)`v}zN/0N";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (AmplModelRepositoryProxyTest.baseModel.getValue("fileExtension"))));
                    List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(Integer.MAX_VALUE).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2464 should have thrown IllegalArgumentException");
                    model.setValue(__DSPOT_property_367, __DSPOT_value_368);
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2464_failAssert383_mg2708 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2464_failAssert383_mg2708_failAssert414litNum3277 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetBaseModelsForSystemnull3896_failAssert768() throws Exception {
        try {
            List<IModel> result = AmplModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, ModelSystem.Atos_HSK, null);
            Assert.notNull(null);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testGetBaseModelsForSystemnull3896 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancelitString1_failAssert0() throws Exception {
        try {
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("GooglePlay_API"))));
            IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
            Assert.notNull(result);
            org.junit.Assert.fail("getModelInstancelitString1 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a GooglePlay_API field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancelitString6_failAssert5() throws Exception {
        try {
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
            IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("GooglePlay"))));
            Assert.notNull(result);
            org.junit.Assert.fail("getModelInstancelitString6 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a GooglePlay field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13() throws Exception {
        try {
            String __DSPOT_property_0 = ",y(q2 5[gpbL[{$QV5:W";
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
            IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
            Assert.notNull(result);
            result.getValue(__DSPOT_property_0);
            org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a ,y(q2 5[gpbL[{$QV5:W field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg15_failAssert14() throws Exception {
        try {
            Object __DSPOT_value_2 = new Object();
            String __DSPOT_property_1 = "z2[|+mr6#-VtX(r!Fs2l";
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
            IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
            Assert.notNull(result);
            result.setValue(__DSPOT_property_1, __DSPOT_value_2);
            org.junit.Assert.fail("getModelInstance_mg15 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a z2[|+mr6#-VtX(r!Fs2l field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancenull16_failAssert15() throws Exception {
        try {
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue(null))));
            IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
            Assert.notNull(result);
            org.junit.Assert.fail("getModelInstancenull16 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancenull17_failAssert16() throws Exception {
        try {
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
            IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue(null))));
            Assert.notNull(result);
            org.junit.Assert.fail("getModelInstancenull17 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancelitString1_failAssert0litString56_failAssert18() throws Exception {
        try {
            {
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("GooglePlay_API"))));
                IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("GooglePlay"))));
                Assert.notNull(result);
                org.junit.Assert.fail("getModelInstancelitString1 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstancelitString1_failAssert0litString56 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a GooglePlay_API field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancelitString6_failAssert5_mg93_failAssert30() throws Exception {
        try {
            {
                String __DSPOT_property_6 = "xHdm7#=ToX)D7x>[Bob5";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
                IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("GooglePlay"))));
                Assert.notNull(result);
                org.junit.Assert.fail("getModelInstancelitString6 should have thrown Exception");
                result.getValue(__DSPOT_property_6);
            }
            org.junit.Assert.fail("getModelInstancelitString6_failAssert5_mg93 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a GooglePlay field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13litString55_failAssert33() throws Exception {
        try {
            {
                String __DSPOT_property_0 = "path/to/model";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
                IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                Assert.notNull(result);
                result.getValue(__DSPOT_property_0);
                org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString55 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a path/to/model field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13litString88_failAssert41() throws Exception {
        try {
            {
                String __DSPOT_property_0 = ",y(q2 5[gpbL[{$QV5:W";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("lastModificationDate"))));
                IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                Assert.notNull(result);
                result.getValue(__DSPOT_property_0);
                org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString88 should have thrown ClassCastException");
        } catch (ClassCastException expected) {
            assertEquals("java.util.Date cannot be cast to java.lang.String", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13null147_failAssert66() throws Exception {
        try {
            {
                String __DSPOT_property_0 = ",y(q2 5[gpbL[{$QV5:W";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue(null))));
                IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                Assert.notNull(result);
                result.getValue(__DSPOT_property_0);
                org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13null147 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13null148_failAssert67() throws Exception {
        try {
            {
                String __DSPOT_property_0 = ",y(q2 5[gpbL[{$QV5:W";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
                IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue(null))));
                Assert.notNull(result);
                result.getValue(__DSPOT_property_0);
                org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13null148 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg15_failAssert14litString57_failAssert70() throws Exception {
        try {
            {
                Object __DSPOT_value_2 = new Object();
                String __DSPOT_property_1 = "modelContent";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
                IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                Assert.notNull(result);
                result.setValue(__DSPOT_property_1, __DSPOT_value_2);
                org.junit.Assert.fail("getModelInstance_mg15 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg15_failAssert14litString57 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Can not set java.lang.String field eu.supersede.integration.api.adaptation.types.GenericModel.modelContent to java.lang.Object", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg15_failAssert14litString60_failAssert71() throws Exception {
        try {
            {
                Object __DSPOT_value_2 = new Object();
                String __DSPOT_property_1 = "z2[|+mr6#&VtX(r!Fs2l";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
                IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                Assert.notNull(result);
                result.setValue(__DSPOT_property_1, __DSPOT_value_2);
                org.junit.Assert.fail("getModelInstance_mg15 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg15_failAssert14litString60 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a z2[|+mr6#&VtX(r!Fs2l field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancelitString1_failAssert0litString56_failAssert18null402_failAssert114() throws Exception {
        try {
            {
                {
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("GooglePlay_API"))));
                    IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("GooglePlay"))));
                    Assert.notNull(null);
                    org.junit.Assert.fail("getModelInstancelitString1 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstancelitString1_failAssert0litString56 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstancelitString1_failAssert0litString56_failAssert18null402 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a GooglePlay_API field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancelitString6_failAssert5_mg93_failAssert30null463_failAssert115() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_6 = "xHdm7#=ToX)D7x>[Bob5";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
                    IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("GooglePlay"))));
                    Assert.notNull(null);
                    org.junit.Assert.fail("getModelInstancelitString6 should have thrown Exception");
                    result.getValue(__DSPOT_property_6);
                }
                org.junit.Assert.fail("getModelInstancelitString6_failAssert5_mg93 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstancelitString6_failAssert5_mg93_failAssert30null463 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a GooglePlay field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13litString55_failAssert33litString367_failAssert122() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_0 = "path/to/model";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
                    IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                    Assert.notNull(result);
                    result.getValue(__DSPOT_property_0);
                    org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString55 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString55_failAssert33litString367 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a path/to/model field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13litString55_failAssert33null486_failAssert130() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_0 = "path/to/model";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue(null))));
                    IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                    Assert.notNull(result);
                    result.getValue(__DSPOT_property_0);
                    org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString55 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString55_failAssert33null486 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13litString55_failAssert33null487_failAssert131() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_0 = "path/to/model";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
                    IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue(null))));
                    Assert.notNull(result);
                    result.getValue(__DSPOT_property_0);
                    org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString55 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString55_failAssert33null487 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13litString88_failAssert41litString353_failAssert134() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_0 = ",y(q2 5[gpbL[{$QV5:W";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("lastModificationDate"))));
                    IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("googleplay_api_googleplay_tool"))));
                    Assert.notNull(result);
                    result.getValue(__DSPOT_property_0);
                    org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString88 should have thrown ClassCastException");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString88_failAssert41litString353 should have thrown ClassCastException");
        } catch (ClassCastException expected) {
            assertEquals("java.util.Date cannot be cast to java.lang.String", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg15_failAssert14litString60_failAssert71litString379_failAssert181() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_2 = new Object();
                    String __DSPOT_property_1 = "z2[|+mr6#&VtX(r!Fs2l";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
                    IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
                    Assert.notNull(result);
                    result.setValue(__DSPOT_property_1, __DSPOT_value_2);
                    org.junit.Assert.fail("getModelInstance_mg15 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstance_mg15_failAssert14litString60 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg15_failAssert14litString60_failAssert71litString379 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg15_failAssert14litString60_failAssert71null485_failAssert193() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_2 = new Object();
                    String __DSPOT_property_1 = "z2[|+mr6#&VtX(r!Fs2l";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("id"))));
                    IModel result = AmplModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (AmplModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                    Assert.notNull(result);
                    result.setValue(__DSPOT_property_1, null);
                    org.junit.Assert.fail("getModelInstance_mg15 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstance_mg15_failAssert14litString60 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg15_failAssert14litString60_failAssert71null485 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a z2[|+mr6#&VtX(r!Fs2l field", expected.getMessage());
        }
    }

    private ModelUpdateMetadata createModelupdateMetadata(AdaptabilityModel am) throws IllegalArgumentException {
        ModelUpdateMetadata mum = new ModelUpdateMetadata();
        mum.setSender("Adapter");
        mum.setTimeStamp(Calendar.getInstance().getTime());
        Map<String, Object> values = new HashMap<>();
        values.put("authorId", "marc");
        values.put("featureId", "GooglePlay_API");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        values.put("lastModificationDate", dateFormat.format(am.getLastModificationDate()));
        values.put("systemId", am.getSystemId().toString());
        values.put("fileExtension", am.getFileExtension());
        values.put("relativePath", am.getRelativePath());
        values.put("name", am.getName());
        values.put("id", am.getId());
        values.put("modelContent", am.getModelContent());
        values.put("creationDate", dateFormat.format(am.getCreationDate()));
        values.put("dependencies", am.getDependencies());
        mum.setValues(values);
        return mum;
    }

    private ModelMetadata createAdatabilityModelMetadata() throws IOException {
        ModelMetadata metadata = new ModelMetadata();
        metadata.setSender("Adapter");
        metadata.setTimeStamp(Calendar.getInstance().getTime());
        List<IModel> modelInstances = createAdaptabilityModelMetadataInstances();
        metadata.setModelInstances(modelInstances);
        return metadata;
    }

    private List<IModel> createAdaptabilityModelMetadataInstances() throws IOException {
        List<IModel> modelInstances = new ArrayList<>();
        AdaptabilityModel am = new AdaptabilityModel();
        modelInstances.add(am);
        am.setName("googleplay_api_googleplay_tool");
        am.setAuthorId("zavala");
        am.setCreationDate(Calendar.getInstance().getTime());
        am.setLastModificationDate(Calendar.getInstance().getTime());
        am.setFileExtension(ModelType.AdaptabilityModel.getExtension());
        am.setSystemId(ModelSystem.MonitoringReconfiguration);
        am.setFeatureId("GooglePlay");
        am.setRelativePath("path/to/model");
        am.setDependencies(new ArrayList<TypedModelId>());
        am.setModelContent(getAdaptabilityModelContent());
        return modelInstances;
    }

    private String getAdaptabilityModelContent() throws IOException {
        File f = new File("");
        List<String> lines = Files.readAllLines(Paths.get(((f.getAbsolutePath()) + "/src/test/resources/files/timeslot_twitter.aspect")), StandardCharsets.UTF_8);
        String content = "";
        for (String s : lines)
            content += s + "\n";

        return content;
    }

    private ModelMetadata createBaseModelMetadata() throws IOException {
        ModelMetadata metadata = new ModelMetadata();
        metadata.setSender("Adapter");
        metadata.setTimeStamp(Calendar.getInstance().getTime());
        List<IModel> modelInstances = createBaseModelMetadataInstances();
        metadata.setModelInstances(modelInstances);
        return metadata;
    }

    private List<IModel> createBaseModelMetadataInstances() throws IOException {
        List<IModel> modelInstances = new ArrayList<>();
        BaseModel am = new BaseModel();
        modelInstances.add(am);
        am.setName("ATOS Base Model");
        am.setAuthorId("yosu");
        am.setCreationDate(Calendar.getInstance().getTime());
        am.setLastModificationDate(Calendar.getInstance().getTime());
        am.setFileExtension(ModelType.BaseModel.getExtension());
        am.setSystemId(ModelSystem.Atos);
        am.setStatus(Status.Computed.toString());
        am.setModelContent(getBaseModelContent());
        am.setRelativePath("models/base");
        am.setDependencies(new ArrayList<TypedModelId>());
        return modelInstances;
    }

    private String getBaseModelContent() throws IOException {
        File f = new File("");
        List<String> lines = Files.readAllLines(Paths.get(((f.getAbsolutePath()) + "/src/test/resources/files/atos_base_model.uml")), StandardCharsets.UTF_8);
        String content = "";
        for (String s : lines)
            content += s + "\n";

        content = content.replace("\"", "'");
        return content;
    }
}

