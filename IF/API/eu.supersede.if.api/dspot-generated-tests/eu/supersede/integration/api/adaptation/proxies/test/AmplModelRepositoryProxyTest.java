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

import static org.junit.Assert.assertEquals;


public class AmplModelRepositoryProxyTest {
    private static ModelRepositoryProxy<?, ?> proxy;

    private static IModel baseModel;

    @BeforeClass
    public static void setup() throws Exception {
        ModelRepositoryProxyTest.proxy = new ModelRepositoryProxy<Object, Object>();
        List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, ModelSystem.Atos_HSK, null);
        Assert.notEmpty(result);
        ModelRepositoryProxyTest.baseModel = result.get(0);
        Assert.notNull(ModelRepositoryProxyTest.baseModel);
    }

    @Test(timeout = 240000)
    public void testGetAllAdaptationModelsnull1802_failAssert180() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, ModelSystem.Atos_HSK, null);
            Assert.notNull(null);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testGetAllAdaptationModelsnull1802 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllFCModelsnull3743_failAssert753() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.FeatureConfiguration, ModelSystem.Atos_HSK, null);
            Assert.notNull(null);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testGetAllFCModelsnull3743 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1809_failAssert181() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("dependencies").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModelslitString1809 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 74: http://supersede.es.atos.net:8280/modelrepositorymanager/models/BaseModel/[]", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1810_failAssert182() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("b").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModelslitString1810 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a b field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitNum1815_failAssert186() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(-1).getValue("id").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModelslitNum1815 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1820_failAssert190() throws Exception {
        try {
            String __DSPOT_property_275 = "5oB,I[.-yo_g9<Hkeqn{";
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model);
            model.getValue(__DSPOT_property_275);
            org.junit.Assert.fail("testGetAllBaseModels_mg1820 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a 5oB,I[.-yo_g9<Hkeqn{ field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1821_failAssert191() throws Exception {
        try {
            Object __DSPOT_value_277 = new Object();
            String __DSPOT_property_276 = "p}9EZwwCv!G#hyz2/ut ";
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model);
            model.setValue(__DSPOT_property_276, __DSPOT_value_277);
            org.junit.Assert.fail("testGetAllBaseModels_mg1821 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a p}9EZwwCv!G#hyz2/ut  field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsnull1822_failAssert192() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(null);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModelsnull1822 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsnull1826_failAssert195() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(null);
            org.junit.Assert.fail("testGetAllBaseModelsnull1826 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1809_failAssert181litNum1900_failAssert196() throws Exception {
        try {
            {
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(1).getValue("dependencies").toString());
                Assert.notNull(model);
                org.junit.Assert.fail("testGetAllBaseModelslitString1809 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitString1809_failAssert181litNum1900 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 74: http://supersede.es.atos.net:8280/modelrepositorymanager/models/BaseModel/[]", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1809_failAssert181litNum1904_failAssert197() throws Exception {
        try {
            {
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(-1).getValue("dependencies").toString());
                Assert.notNull(model);
                org.junit.Assert.fail("testGetAllBaseModelslitString1809 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitString1809_failAssert181litNum1904 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1810_failAssert182litNum1887_failAssert205() throws Exception {
        try {
            {
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(1).getValue("b").toString());
                Assert.notNull(model);
                org.junit.Assert.fail("testGetAllBaseModelslitString1810 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitString1810_failAssert182litNum1887 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a b field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitNum1815_failAssert186null1938_failAssert221() throws Exception {
        try {
            {
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(null);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(-1).getValue("id").toString());
                Assert.notNull(model);
                org.junit.Assert.fail("testGetAllBaseModelslitNum1815 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitNum1815_failAssert186null1938 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1820_failAssert190litString1866_failAssert225() throws Exception {
        try {
            {
                String __DSPOT_property_275 = "ATOS Base Model";
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model);
                model.getValue(__DSPOT_property_275);
                org.junit.Assert.fail("testGetAllBaseModels_mg1820 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert190litString1866 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a ATOS Base Model field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1820_failAssert190null1976_failAssert254() throws Exception {
        try {
            {
                String __DSPOT_property_275 = null;
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model);
                model.getValue(__DSPOT_property_275);
                org.junit.Assert.fail("testGetAllBaseModels_mg1820 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert190null1976 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1821_failAssert191litString1877_failAssert260() throws Exception {
        try {
            {
                Object __DSPOT_value_277 = new Object();
                String __DSPOT_property_276 = "\n";
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model);
                model.setValue(__DSPOT_property_276, __DSPOT_value_277);
                org.junit.Assert.fail("testGetAllBaseModels_mg1821 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1821_failAssert191litString1877 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a \n field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1809_failAssert181litNum1900_failAssert196null2284_failAssert319() throws Exception {
        try {
            {
                {
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(1).getValue("dependencies").toString());
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetAllBaseModelslitString1809 should have thrown URISyntaxException");
                }
                org.junit.Assert.fail("testGetAllBaseModelslitString1809_failAssert181litNum1900 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitString1809_failAssert181litNum1900_failAssert196null2284 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 74: http://supersede.es.atos.net:8280/modelrepositorymanager/models/BaseModel/[]", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1809_failAssert181litNum1904_failAssert197null2300_failAssert320() throws Exception {
        try {
            {
                {
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(-1).getValue("dependencies").toString());
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetAllBaseModelslitString1809 should have thrown URISyntaxException");
                }
                org.junit.Assert.fail("testGetAllBaseModelslitString1809_failAssert181litNum1904 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitString1809_failAssert181litNum1904_failAssert197null2300 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitString1810_failAssert182litNum1887_failAssert205null2303_failAssert321() throws Exception {
        try {
            {
                {
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(1).getValue("b").toString());
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetAllBaseModelslitString1810 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelslitString1810_failAssert182litNum1887 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitString1810_failAssert182litNum1887_failAssert205null2303 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a b field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelslitNum1815_failAssert186null1938_failAssert221litString2247_failAssert322() throws Exception {
        try {
            {
                {
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(null);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(-1).getValue("creationDate").toString());
                    Assert.notNull(model);
                    org.junit.Assert.fail("testGetAllBaseModelslitNum1815 should have thrown ArrayIndexOutOfBoundsException");
                }
                org.junit.Assert.fail("testGetAllBaseModelslitNum1815_failAssert186null1938 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAllBaseModelslitNum1815_failAssert186null1938_failAssert221litString2247 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1820_failAssert190litString1866_failAssert225litNum2268_failAssert335() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_275 = "ATOS Base Model";
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(1).getValue("id").toString());
                    Assert.notNull(model);
                    model.getValue(__DSPOT_property_275);
                    org.junit.Assert.fail("testGetAllBaseModels_mg1820 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert190litString1866 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert190litString1866_failAssert225litNum2268 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a ATOS Base Model field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1820_failAssert190litString1866_failAssert225null2340_failAssert344() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_275 = "ATOS Base Model";
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(null);
                    model.getValue(__DSPOT_property_275);
                    org.junit.Assert.fail("testGetAllBaseModels_mg1820 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert190litString1866 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1820_failAssert190litString1866_failAssert225null2340 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModels_mg1821_failAssert191litString1877_failAssert260litString2244_failAssert362() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_277 = new Object();
                    String __DSPOT_property_276 = "\n";
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model);
                    model.setValue(__DSPOT_property_276, __DSPOT_value_277);
                    org.junit.Assert.fail("testGetAllBaseModels_mg1821 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModels_mg1821_failAssert191litString1877 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg1821_failAssert191litString1877_failAssert260litString2244 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a \n field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2498_failAssert379() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("Adapter"))));
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2498 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a Adapter field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2506_failAssert387() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2506 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a  field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2511_failAssert391() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("<"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2511 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a < field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400() throws Exception {
        try {
            Object __DSPOT_value_335 = new Object();
            String __DSPOT_property_334 = "Ci2@sxS($<9$T4bXzesi";
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            model.setValue(__DSPOT_property_334, __DSPOT_value_335);
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a Ci2@sxS($<9$T4bXzesi field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatanull2524_failAssert401() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue(null))));
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2524 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatanull2525_failAssert402() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2525 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid metadata", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatanull2526_failAssert403() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(null);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull2526 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2498_failAssert379litString2600_failAssert407() throws Exception {
        try {
            {
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("Adapter"))));
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("").toString());
                Assert.notNull(model.getValue("id"));
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2498 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2498_failAssert379litString2600 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a Adapter field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2506_failAssert387litString2608_failAssert430() throws Exception {
        try {
            {
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("").toString());
                Assert.notNull(model.getValue("id"));
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2506 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2506_failAssert387litString2608 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a  field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2511_failAssert391litNum2631_failAssert445() throws Exception {
        try {
            {
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(1).getValue("id").toString());
                Assert.notNull(model.getValue("<"));
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2511 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2511_failAssert391litNum2631 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a < field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454() throws Exception {
        try {
            {
                Object __DSPOT_value_335 = new Object();
                String __DSPOT_property_334 = "authorId";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Can not set java.lang.String field eu.supersede.integration.api.adaptation.types.GenericModel.authorId to java.lang.Object", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2604_failAssert455() throws Exception {
        try {
            {
                Object __DSPOT_value_335 = new Object();
                String __DSPOT_property_334 = "Ci2NsxS($<9$T4bXzesi";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2604 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a Ci2NsxS($<9$T4bXzesi field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2668_failAssert470() throws Exception {
        try {
            {
                Object __DSPOT_value_335 = new Object();
                String __DSPOT_property_334 = "Ci2@sxS($<9$T4bXzesi";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("relativePath").toString());
                Assert.notNull(model.getValue("id"));
                model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2668 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400null2754_failAssert490() throws Exception {
        try {
            {
                Object __DSPOT_value_335 = new Object();
                String __DSPOT_property_334 = "Ci2@sxS($<9$T4bXzesi";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue(null))));
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400null2754 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400null2755_failAssert491() throws Exception {
        try {
            {
                Object __DSPOT_value_335 = new Object();
                String __DSPOT_property_334 = "Ci2@sxS($<9$T4bXzesi";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400null2755 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid metadata", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400null2756_failAssert492() throws Exception {
        try {
            {
                Object __DSPOT_value_335 = new Object();
                String __DSPOT_property_334 = "Ci2@sxS($<9$T4bXzesi";
                BaseModel metadata = new BaseModel();
                metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                Assert.notNull(null);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model.getValue("id"));
                model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400null2756 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2506_failAssert387litString2608_failAssert430litNum3186_failAssert586() throws Exception {
        try {
            {
                {
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("").toString());
                    Assert.notNull(model.getValue("id"));
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2506 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2506_failAssert387litString2608 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2506_failAssert387litString2608_failAssert430litNum3186 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a  field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadatalitString2498_failAssert379litString2600_failAssert407null3298_failAssert590() throws Exception {
        try {
            {
                {
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("Adapter"))));
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("").toString());
                    Assert.notNull(model.getValue(null));
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2498 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2498_failAssert379litString2600 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString2498_failAssert379litString2600_failAssert407null3298 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a Adapter field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454litString3215_failAssert606() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_335 = new Object();
                    String __DSPOT_property_334 = "authorId";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("fileExtension"));
                    model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454litString3215 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Can not set java.lang.String field eu.supersede.integration.api.adaptation.types.GenericModel.authorId to java.lang.Object", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454litString3147_failAssert610() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_335 = new Object();
                    String __DSPOT_property_334 = "authorId";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("systemId"))));
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454litString3147 should have thrown ClassCastException");
        } catch (ClassCastException expected) {
            assertEquals("eu.supersede.integration.api.adaptation.types.ModelSystem cannot be cast to java.lang.String", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454litString3229_failAssert611() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_335 = new Object();
                    String __DSPOT_property_334 = "authorId";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("\n"));
                    model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454litString3229 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a \n field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454null3324_failAssert628() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_335 = new Object();
                    String __DSPOT_property_334 = "authorId";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(null);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454null3324 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454null3321_failAssert632() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_335 = new Object();
                    String __DSPOT_property_334 = "authorId";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, null);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454null3321 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid metadata", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454null3318_failAssert633() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_335 = new Object();
                    String __DSPOT_property_334 = "authorId";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue(null))));
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2601_failAssert454null3318 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2604_failAssert455null3351_failAssert708() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_335 = new Object();
                    String __DSPOT_property_334 = "Ci2NsxS($<9$T4bXzesi";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_334, null);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2604 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2604_failAssert455null3351 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a Ci2NsxS($<9$T4bXzesi field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2668_failAssert470litString3164_failAssert723() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_335 = new Object();
                    String __DSPOT_property_334 = "Ci2@sxS($<9$T4bXzesi";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("relativePath").toString());
                    Assert.notNull(model.getValue("\n"));
                    model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2668 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2668_failAssert470litString3164 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2604_failAssert455litString3153_failAssert749() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_335 = new Object();
                    String __DSPOT_property_334 = "Ci2NsxS($<9$T4bXzesi";
                    BaseModel metadata = new BaseModel();
                    metadata.setAuthorId(((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
                    List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, metadata);
                    Assert.notNull(result);
                    Assert.notEmpty(result);
                    Collections.sort(result);
                    IModel model = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                    Assert.notNull(model.getValue("id"));
                    model.setValue(__DSPOT_property_334, __DSPOT_value_335);
                    org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523 should have thrown Exception");
                }
                org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2604 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg2523_failAssert400litString2604_failAssert455litString3153 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetBaseModelsForSystemnull3750_failAssert754() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest.proxy.getModelInstances(ModelType.BaseModel, ModelSystem.Atos_HSK, null);
            Assert.notNull(null);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testGetBaseModelsForSystemnull3750 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancelitString1_failAssert0() throws Exception {
        try {
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("GooglePlay_API"))));
            IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
            Assert.notNull(result);
            org.junit.Assert.fail("getModelInstancelitString1 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a GooglePlay_API field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancelitString6_failAssert5() throws Exception {
        try {
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
            IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("GooglePlay"))));
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
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
            IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
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
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
            IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
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
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue(null))));
            IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
            Assert.notNull(result);
            org.junit.Assert.fail("getModelInstancenull16 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancenull17_failAssert16() throws Exception {
        try {
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
            IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue(null))));
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
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("GooglePlay_API"))));
                IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                Assert.notNull(result);
                org.junit.Assert.fail("getModelInstancelitString1 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstancelitString1_failAssert0litString56 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a GooglePlay_API field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancelitString6_failAssert5_mg91_failAssert30() throws Exception {
        try {
            {
                String __DSPOT_property_6 = "b5_83OI`-k-a8(J8Bp[$";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
                IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("GooglePlay"))));
                Assert.notNull(result);
                org.junit.Assert.fail("getModelInstancelitString6 should have thrown Exception");
                result.getValue(__DSPOT_property_6);
            }
            org.junit.Assert.fail("getModelInstancelitString6_failAssert5_mg91 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a GooglePlay field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13litString58_failAssert33() throws Exception {
        try {
            {
                String __DSPOT_property_0 = "";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
                IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                Assert.notNull(result);
                result.getValue(__DSPOT_property_0);
                org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString58 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a  field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13litString96_failAssert45() throws Exception {
        try {
            {
                String __DSPOT_property_0 = ",y(q2 5[gpbL[{$QV5:W";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
                IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                Assert.notNull(result);
                result.getValue(__DSPOT_property_0);
                org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString96 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13null143_failAssert65() throws Exception {
        try {
            {
                String __DSPOT_property_0 = ",y(q2 5[gpbL[{$QV5:W";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue(null))));
                IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                Assert.notNull(result);
                result.getValue(__DSPOT_property_0);
                org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13null143 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13null145_failAssert66() throws Exception {
        try {
            {
                String __DSPOT_property_0 = ",y(q2 5[gpbL[{$QV5:W";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
                IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue(null))));
                Assert.notNull(result);
                result.getValue(__DSPOT_property_0);
                org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13null145 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg15_failAssert14litString57_failAssert69() throws Exception {
        try {
            {
                Object __DSPOT_value_2 = new Object();
                String __DSPOT_property_1 = "path/to/model";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
                IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                Assert.notNull(result);
                result.setValue(__DSPOT_property_1, __DSPOT_value_2);
                org.junit.Assert.fail("getModelInstance_mg15 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg15_failAssert14litString57 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a path/to/model field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg15_failAssert14litString97_failAssert77() throws Exception {
        try {
            {
                Object __DSPOT_value_2 = new Object();
                String __DSPOT_property_1 = "z2[|+mr6#-VtX(r!Fs2l";
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("dependencies"))));
                IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                Assert.notNull(result);
                result.setValue(__DSPOT_property_1, __DSPOT_value_2);
                org.junit.Assert.fail("getModelInstance_mg15 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg15_failAssert14litString97 should have thrown ClassCastException");
        } catch (ClassCastException expected) {
            assertEquals("java.util.ArrayList cannot be cast to java.lang.String", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancelitString1_failAssert0litString56_failAssert18null393_failAssert113() throws Exception {
        try {
            {
                {
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("GooglePlay_API"))));
                    IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("authorId"))));
                    Assert.notNull(null);
                    org.junit.Assert.fail("getModelInstancelitString1 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstancelitString1_failAssert0litString56 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstancelitString1_failAssert0litString56_failAssert18null393 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a GooglePlay_API field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstancelitString6_failAssert5_mg91_failAssert30null433_failAssert114() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_6 = "b5_83OI`-k-a8(J8Bp[$";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
                    IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("GooglePlay"))));
                    Assert.notNull(null);
                    org.junit.Assert.fail("getModelInstancelitString6 should have thrown Exception");
                    result.getValue(__DSPOT_property_6);
                }
                org.junit.Assert.fail("getModelInstancelitString6_failAssert5_mg91 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstancelitString6_failAssert5_mg91_failAssert30null433 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a GooglePlay field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13litString58_failAssert33litString361_failAssert120() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_0 = "";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
                    IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
                    Assert.notNull(result);
                    result.getValue(__DSPOT_property_0);
                    org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString58 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString58_failAssert33litString361 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13litString58_failAssert33null470_failAssert128() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_0 = "";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue(null))));
                    IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                    Assert.notNull(result);
                    result.getValue(__DSPOT_property_0);
                    org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString58 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString58_failAssert33null470 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13litString58_failAssert33null471_failAssert129() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_0 = "";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
                    IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue(null))));
                    Assert.notNull(result);
                    result.getValue(__DSPOT_property_0);
                    org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString58 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString58_failAssert33null471 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg14_failAssert13litString58_failAssert33null472_failAssert130() throws Exception {
        try {
            {
                {
                    String __DSPOT_property_0 = "";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
                    IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                    Assert.notNull(null);
                    result.getValue(__DSPOT_property_0);
                    org.junit.Assert.fail("getModelInstance_mg14 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString58 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg14_failAssert13litString58_failAssert33null472 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg15_failAssert14litString57_failAssert69null461_failAssert167() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_2 = new Object();
                    String __DSPOT_property_1 = "path/to/model";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("id"))));
                    IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("relativePath"))));
                    Assert.notNull(result);
                    result.setValue(__DSPOT_property_1, null);
                    org.junit.Assert.fail("getModelInstance_mg15 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstance_mg15_failAssert14litString57 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_mg15_failAssert14litString57_failAssert69null461 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a path/to/model field", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void getModelInstance_mg15_failAssert14litString97_failAssert77litString342_failAssert168() throws Exception {
        try {
            {
                {
                    Object __DSPOT_value_2 = new Object();
                    String __DSPOT_property_1 = "z2[|+mr6#-VtX(r!Fs2l";
                    ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest.baseModel.getValue("dependencies"))));
                    IModel result = ModelRepositoryProxyTest.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest.baseModel.getValue("models/base"))));
                    Assert.notNull(result);
                    result.setValue(__DSPOT_property_1, __DSPOT_value_2);
                    org.junit.Assert.fail("getModelInstance_mg15 should have thrown Exception");
                }
                org.junit.Assert.fail("getModelInstance_mg15_failAssert14litString97 should have thrown ClassCastException");
            }
            org.junit.Assert.fail("getModelInstance_mg15_failAssert14litString97_failAssert77litString342 should have thrown ClassCastException");
        } catch (ClassCastException expected) {
            assertEquals("java.util.ArrayList cannot be cast to java.lang.String", expected.getMessage());
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

