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
import eu.supersede.integration.api.adaptation.types.Tenant;
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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpServerErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class ModelRepositoryProxyTest_Ampl2 {
    private static ModelRepositoryProxy<?, ?> proxy;

    private static IModel baseModel;

    @BeforeClass
    public static void setup() throws Exception {
        ModelRepositoryProxyTest_Ampl2.proxy = new ModelRepositoryProxy<Object, Object>();
        List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, ModelSystem.Atos_HSK, null);
        Assert.notEmpty(result);
        ModelRepositoryProxyTest_Ampl2.baseModel = result.get(0);
        Assert.notNull(ModelRepositoryProxyTest_Ampl2.baseModel);
    }

    @Test(timeout = 30000)
    public void testGetAllAdaptationModels_add4339() throws Exception {
        List<IModel> o_testGetAllAdaptationModels_add4339__1 = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, ModelSystem.Atos_HSK, null);
        assertFalse(o_testGetAllAdaptationModels_add4339__1.isEmpty());
        List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, ModelSystem.Atos_HSK, null);
        Assert.notNull(result);
        Assert.notEmpty(result);
        assertFalse(o_testGetAllAdaptationModels_add4339__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetAllFCModels_add10117() throws Exception {
        List<IModel> o_testGetAllFCModels_add10117__1 = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.FeatureConfiguration, ModelSystem.Atos_HSK, null);
        assertFalse(o_testGetAllFCModels_add10117__1.isEmpty());
        List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.FeatureConfiguration, ModelSystem.Atos_HSK, null);
        Assert.notNull(result);
        Assert.notEmpty(result);
        assertFalse(o_testGetAllFCModels_add10117__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetAllFCModelsnull10122_failAssert0() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.FeatureConfiguration, ModelSystem.Atos_HSK, null);
            Assert.notNull(null);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testGetAllFCModelsnull10122 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModels_add4442() throws Exception {
        List<IModel> o_testGetAllBaseModels_add4442__1 = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
        assertFalse(o_testGetAllBaseModels_add4442__1.isEmpty());
        List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
        Assert.notNull(result);
        Assert.notEmpty(result);
        Collections.sort(result);
        IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
        Assert.notNull(model);
        assertFalse(o_testGetAllBaseModels_add4442__1.isEmpty());
    }

    @Test(timeout = 30000) @Ignore
    public void testGetAllBaseModels_add4446() throws Exception {
        List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
        Assert.notNull(result);
        Assert.notEmpty(result);
        Collections.sort(result);
        IModel o_testGetAllBaseModels_add4446__6 = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
        assertEquals("Computed", ((BaseModel) (o_testGetAllBaseModels_add4446__6)).getStatus());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4446__6)).getSystemId())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4446__6)).getSystemId())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4446__6)).getSystemId())).toString());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4446__6)).getSystemId())).getId());
        assertEquals(".uml", ((BaseModel) (o_testGetAllBaseModels_add4446__6)).getFileExtension());
        assertTrue(((Collection) (((BaseModel) (o_testGetAllBaseModels_add4446__6)).getDependencies())).isEmpty());
        assertEquals("yosu", ((BaseModel) (o_testGetAllBaseModels_add4446__6)).getAuthorId());
        assertEquals("ATOS Base Model", ((BaseModel) (o_testGetAllBaseModels_add4446__6)).getName());
        assertEquals("3270", ((BaseModel) (o_testGetAllBaseModels_add4446__6)).getId());
        assertFalse(((Collection) (((BaseModel) (o_testGetAllBaseModels_add4446__6)).getFields())).isEmpty());
        IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
        Assert.notNull(model);
        assertEquals("Computed", ((BaseModel) (o_testGetAllBaseModels_add4446__6)).getStatus());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4446__6)).getSystemId())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4446__6)).getSystemId())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4446__6)).getSystemId())).toString());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4446__6)).getSystemId())).getId());
        assertEquals(".uml", ((BaseModel) (o_testGetAllBaseModels_add4446__6)).getFileExtension());
        assertTrue(((Collection) (((BaseModel) (o_testGetAllBaseModels_add4446__6)).getDependencies())).isEmpty());
        assertEquals("yosu", ((BaseModel) (o_testGetAllBaseModels_add4446__6)).getAuthorId());
        assertEquals("ATOS Base Model", ((BaseModel) (o_testGetAllBaseModels_add4446__6)).getName());
        assertEquals("3270", ((BaseModel) (o_testGetAllBaseModels_add4446__6)).getId());
        assertFalse(((Collection) (((BaseModel) (o_testGetAllBaseModels_add4446__6)).getFields())).isEmpty());
    }

    @Test(timeout = 30000) @Ignore
    public void testGetAllBaseModels_add4449() throws Exception {
        List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
        Assert.notNull(result);
        Assert.notEmpty(result);
        Collections.sort(result);
        IModel o_testGetAllBaseModels_add4449__6 = result.get(0);
        assertEquals("Computed", ((BaseModel) (o_testGetAllBaseModels_add4449__6)).getStatus());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4449__6)).getSystemId())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4449__6)).getSystemId())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4449__6)).getSystemId())).toString());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4449__6)).getSystemId())).getId());
        assertEquals(".uml", ((BaseModel) (o_testGetAllBaseModels_add4449__6)).getFileExtension());
        assertNull(((BaseModel) (o_testGetAllBaseModels_add4449__6)).getModelContent());
        assertTrue(((Collection) (((BaseModel) (o_testGetAllBaseModels_add4449__6)).getDependencies())).isEmpty());
        assertEquals("yosu", ((BaseModel) (o_testGetAllBaseModels_add4449__6)).getAuthorId());
        assertEquals("ATOS Base Model", ((BaseModel) (o_testGetAllBaseModels_add4449__6)).getName());
        assertEquals("3270", ((BaseModel) (o_testGetAllBaseModels_add4449__6)).getId());
        assertFalse(((Collection) (((BaseModel) (o_testGetAllBaseModels_add4449__6)).getFields())).isEmpty());
        IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
        Assert.notNull(model);
        assertEquals("Computed", ((BaseModel) (o_testGetAllBaseModels_add4449__6)).getStatus());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4449__6)).getSystemId())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4449__6)).getSystemId())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4449__6)).getSystemId())).toString());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModels_add4449__6)).getSystemId())).getId());
        assertEquals(".uml", ((BaseModel) (o_testGetAllBaseModels_add4449__6)).getFileExtension());
        assertNull(((BaseModel) (o_testGetAllBaseModels_add4449__6)).getModelContent());
        assertTrue(((Collection) (((BaseModel) (o_testGetAllBaseModels_add4449__6)).getDependencies())).isEmpty());
        assertEquals("yosu", ((BaseModel) (o_testGetAllBaseModels_add4449__6)).getAuthorId());
        assertEquals("ATOS Base Model", ((BaseModel) (o_testGetAllBaseModels_add4449__6)).getName());
        assertEquals("3270", ((BaseModel) (o_testGetAllBaseModels_add4449__6)).getId());
        assertFalse(((Collection) (((BaseModel) (o_testGetAllBaseModels_add4449__6)).getFields())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModels_literalMutationNumber4456_failAssert0() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(-1).getValue("id").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModels_literalMutationNumber4456 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModels_literalMutationString4459_failAssert0() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModels_literalMutationString4459 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a  field", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModels_mg4462_failAssert0() throws Exception {
        try {
            String __DSPOT_property_349 = "QO0c5a.U(&bzLSgsM<P2";
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model);
            model.getValue(__DSPOT_property_349);
            org.junit.Assert.fail("testGetAllBaseModels_mg4462 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a QO0c5a.U(&bzLSgsM<P2 field", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModels_mg4463_failAssert0() throws Exception {
        try {
            Object __DSPOT_value_351 = new Object();
            String __DSPOT_property_350 = "/c-44h!,y)$>(xx8O:>9";
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model);
            model.setValue(__DSPOT_property_350, __DSPOT_value_351);
            org.junit.Assert.fail("testGetAllBaseModels_mg4463 should have thrown Exception");
        } catch (Exception expected) {
        }
    }

    @Test(timeout = 30000) @Ignore
    public void testGetAllBaseModelslitString4464_failAssert0() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("authorId").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModelslitString4464 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModelslitString4475_failAssert0() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("lastModificationDate").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModelslitString4475 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModelsnull4486_failAssert0() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(null);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModelsnull4486 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModels_mg4463_failAssert0litString4997_failAssert0() throws Exception {
        try {
            {
                Object __DSPOT_value_351 = new Object();
                String __DSPOT_property_350 = "creationDate";
                List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
                Assert.notNull(result);
                Assert.notEmpty(result);
                Collections.sort(result);
                IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
                Assert.notNull(model);
                model.setValue(__DSPOT_property_350, __DSPOT_value_351);
                org.junit.Assert.fail("testGetAllBaseModels_mg4463 should have thrown Exception");
            }
            org.junit.Assert.fail("testGetAllBaseModels_mg4463_failAssert0litString4997 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Can not set java.util.Date field eu.supersede.integration.api.adaptation.types.GenericModel.creationDate to java.lang.Object", expected.getMessage());
        }
    }

    @Test(timeout = 30000) @Ignore
    public void testGetAllBaseModels_add4446_add4944litString6246_failAssert0() throws Exception {
        try {
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel o_testGetAllBaseModels_add4446__6 = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("systemId").toString());
            IModel o_testGetAllBaseModels_add4446_add4944__12 = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model);
            org.junit.Assert.fail("testGetAllBaseModels_add4446_add4944litString6246 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModelsWithQueryMetadata_add6765() throws Exception {
        BaseModel metadata = new BaseModel();
        Object o_testGetAllBaseModelsWithQueryMetadata_add6765__3 = ModelRepositoryProxyTest_Ampl2.baseModel.getValue("authorId");
        assertEquals("Yosu", o_testGetAllBaseModelsWithQueryMetadata_add6765__3);
        metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("authorId"))));
        List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, metadata);
        Assert.notNull(result);
        Assert.notEmpty(result);
        Collections.sort(result);
        IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
        Assert.notNull(model.getValue("id"));
        assertEquals("Yosu", o_testGetAllBaseModelsWithQueryMetadata_add6765__3);
    }

    @Test(timeout = 30000) @Ignore
    public void testGetAllBaseModelsWithQueryMetadata_add6770() throws Exception {
        BaseModel metadata = new BaseModel();
        metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("authorId"))));
        List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, metadata);
        Assert.notNull(result);
        Assert.notEmpty(result);
        Collections.sort(result);
        IModel o_testGetAllBaseModelsWithQueryMetadata_add6770__10 = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
        assertEquals("Computed", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getStatus());
        assertEquals("yosu", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getAuthorId());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getSystemId())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getSystemId())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getSystemId())).toString());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getSystemId())).getId());
        assertEquals(".uml", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getFileExtension());
        assertTrue(((Collection) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getDependencies())).isEmpty());
        assertEquals("ATOS Base Model", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getName());
        assertEquals("3270", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getId());
        assertFalse(((Collection) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getFields())).isEmpty());
        IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
        Assert.notNull(model.getValue("id"));
        assertEquals("Computed", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getStatus());
        assertEquals("yosu", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getAuthorId());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getSystemId())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getSystemId())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getSystemId())).toString());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getSystemId())).getId());
        assertEquals(".uml", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getFileExtension());
        assertTrue(((Collection) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getDependencies())).isEmpty());
        assertEquals("ATOS Base Model", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getName());
        assertEquals("3270", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getId());
        assertFalse(((Collection) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6770__10)).getFields())).isEmpty());
    }

    @Test(timeout = 30000) @Ignore
    public void testGetAllBaseModelsWithQueryMetadata_add6773() throws Exception {
        BaseModel metadata = new BaseModel();
        metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("authorId"))));
        List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, metadata);
        Assert.notNull(result);
        Assert.notEmpty(result);
        Collections.sort(result);
        IModel o_testGetAllBaseModelsWithQueryMetadata_add6773__10 = result.get(0);
        assertEquals("Computed", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getStatus());
        assertEquals("yosu", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getAuthorId());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getSystemId())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getSystemId())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getSystemId())).toString());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getSystemId())).getId());
        assertEquals(".uml", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getFileExtension());
        assertNull(((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getModelContent());
        assertTrue(((Collection) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getDependencies())).isEmpty());
        assertEquals("ATOS Base Model", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getName());
        assertEquals("3270", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getId());
        assertFalse(((Collection) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getFields())).isEmpty());
        IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
        Assert.notNull(model.getValue("id"));
        assertEquals("Computed", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getStatus());
        assertEquals("yosu", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getAuthorId());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getSystemId())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getSystemId())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getSystemId())).toString());
        assertEquals("Atos", ((ModelSystem) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getSystemId())).getId());
        assertEquals(".uml", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getFileExtension());
        assertNull(((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getModelContent());
        assertTrue(((Collection) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getDependencies())).isEmpty());
        assertEquals("ATOS Base Model", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getName());
        assertEquals("3270", ((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getId());
        assertFalse(((Collection) (((BaseModel) (o_testGetAllBaseModelsWithQueryMetadata_add6773__10)).getFields())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModelsWithQueryMetadata_literalMutationString6781_failAssert0() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue(""))));
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_literalMutationString6781 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a  field", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModelsWithQueryMetadata_literalMutationNumber6788_failAssert0() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("authorId"))));
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(-1).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_literalMutationNumber6788 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModelsWithQueryMetadata_mg6799_failAssert0() throws Exception {
        try {
            Object __DSPOT_value_444 = new Object();
            String __DSPOT_property_443 = "YY_$,#0(-lw#n(}k<Pl)";
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("authorId"))));
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            model.setValue(__DSPOT_property_443, __DSPOT_value_444);
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_mg6799 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a YY_$,#0(-lw#n(}k<Pl) field", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModelsWithQueryMetadatalitString6824_failAssert0() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("id"))));
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString6824 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000) @Ignore
    public void testGetAllBaseModelsWithQueryMetadatalitString6832_failAssert0() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("authorId"))));
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("systemId").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatalitString6832 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModelsWithQueryMetadatanull6848_failAssert0() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue(null))));
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull6848 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModelsWithQueryMetadatanull6849_failAssert0() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("authorId"))));
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, null);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull6849 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid metadata", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModelsWithQueryMetadatanull6850_failAssert0() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("authorId"))));
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(null);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadatanull6850 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModelsWithQueryMetadata_add6765litString7534_failAssert0() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            Object o_testGetAllBaseModelsWithQueryMetadata_add6765__3 = ModelRepositoryProxyTest_Ampl2.baseModel.getValue("authorId");
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("bfoKDYEJ"))));
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_add6765litString7534 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a bfoKDYEJ field", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllBaseModelsWithQueryMetadata_add6765null7936_failAssert0() throws Exception {
        try {
            BaseModel metadata = new BaseModel();
            Object o_testGetAllBaseModelsWithQueryMetadata_add6765__3 = ModelRepositoryProxyTest_Ampl2.baseModel.getValue("authorId");
            metadata.setAuthorId(((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue(null))));
            List<IModel> result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstances(ModelType.BaseModel, metadata);
            Assert.notNull(result);
            Assert.notEmpty(result);
            Collections.sort(result);
            IModel model = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
            Assert.notNull(model.getValue("id"));
            org.junit.Assert.fail("testGetAllBaseModelsWithQueryMetadata_add6765null7936 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void getModelInstance_add1() throws Exception {
        Object o_getModelInstance_add1__1 = ModelRepositoryProxyTest_Ampl2.baseModel.getValue("id");
        assertEquals("2191", o_getModelInstance_add1__1);
        ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("id"))));
        IModel result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("relativePath"))));
        Assert.notNull(result);
        assertEquals("2191", o_getModelInstance_add1__1);
    }

    @Test(timeout = 30000)
    public void getModelInstance_add2() throws Exception {
        ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("id"))));
        IModel o_getModelInstance_add2__4 = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("relativePath"))));
        assertEquals("Enacted", ((BaseModel) (o_getModelInstance_add2__4)).getStatus());
        assertEquals("siemens", ((Tenant) (((ModelSystem) (((BaseModel) (o_getModelInstance_add2__4)).getSystemId())).getTenant())).toString());
        assertEquals("siemens", ((Tenant) (((ModelSystem) (((BaseModel) (o_getModelInstance_add2__4)).getSystemId())).getTenant())).getId());
        assertEquals("Siemens", ((ModelSystem) (((BaseModel) (o_getModelInstance_add2__4)).getSystemId())).toString());
        assertEquals("Siemens", ((ModelSystem) (((BaseModel) (o_getModelInstance_add2__4)).getSystemId())).getId());
        assertEquals(".uml", ((BaseModel) (o_getModelInstance_add2__4)).getFileExtension());
        assertNull(((BaseModel) (o_getModelInstance_add2__4)).getModelContent());
        assertTrue(((Collection) (((BaseModel) (o_getModelInstance_add2__4)).getDependencies())).isEmpty());
        assertEquals("Srdjan", ((BaseModel) (o_getModelInstance_add2__4)).getAuthorId());
        assertEquals("BaseModel-S2.uml", ((BaseModel) (o_getModelInstance_add2__4)).getName());
        assertEquals("2185", ((BaseModel) (o_getModelInstance_add2__4)).getId());
        assertFalse(((Collection) (((BaseModel) (o_getModelInstance_add2__4)).getFields())).isEmpty());
        IModel result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("relativePath"))));
        Assert.notNull(result);
        assertEquals("Enacted", ((BaseModel) (o_getModelInstance_add2__4)).getStatus());
        assertEquals("siemens", ((Tenant) (((ModelSystem) (((BaseModel) (o_getModelInstance_add2__4)).getSystemId())).getTenant())).toString());
        assertEquals("siemens", ((Tenant) (((ModelSystem) (((BaseModel) (o_getModelInstance_add2__4)).getSystemId())).getTenant())).getId());
        assertEquals("Siemens", ((ModelSystem) (((BaseModel) (o_getModelInstance_add2__4)).getSystemId())).toString());
        assertEquals("Siemens", ((ModelSystem) (((BaseModel) (o_getModelInstance_add2__4)).getSystemId())).getId());
        assertEquals(".uml", ((BaseModel) (o_getModelInstance_add2__4)).getFileExtension());
        assertNull(((BaseModel) (o_getModelInstance_add2__4)).getModelContent());
        assertTrue(((Collection) (((BaseModel) (o_getModelInstance_add2__4)).getDependencies())).isEmpty());
        assertEquals("Srdjan", ((BaseModel) (o_getModelInstance_add2__4)).getAuthorId());
        assertEquals("BaseModel-S2.uml", ((BaseModel) (o_getModelInstance_add2__4)).getName());
        assertEquals("2185", ((BaseModel) (o_getModelInstance_add2__4)).getId());
        assertFalse(((Collection) (((BaseModel) (o_getModelInstance_add2__4)).getFields())).isEmpty());
    }

    @Test(timeout = 30000)
    public void getModelInstance_literalMutationString6_failAssert0() throws Exception {
        try {
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue(""))));
            IModel result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("relativePath"))));
            Assert.notNull(result);
            org.junit.Assert.fail("getModelInstance_literalMutationString6 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a  field", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void getModelInstance_literalMutationString9_failAssert0() throws Exception {
        try {
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("id"))));
            IModel result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue(""))));
            Assert.notNull(result);
            org.junit.Assert.fail("getModelInstance_literalMutationString9 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a  field", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void getModelInstance_mg16_failAssert0() throws Exception {
        try {
            Object __DSPOT_value_2 = new Object();
            String __DSPOT_property_1 = ":Wz2[|+mr6#-VtX(r!Fs";
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("id"))));
            IModel result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("relativePath"))));
            Assert.notNull(result);
            result.setValue(__DSPOT_property_1, __DSPOT_value_2);
            org.junit.Assert.fail("getModelInstance_mg16 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a :Wz2[|+mr6#-VtX(r!Fs field", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void getModelInstancenull42_failAssert0() throws Exception {
        try {
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue(null))));
            IModel result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("relativePath"))));
            Assert.notNull(result);
            org.junit.Assert.fail("getModelInstancenull42 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void getModelInstancenull43_failAssert0() throws Exception {
        try {
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("id"))));
            IModel result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue(null))));
            Assert.notNull(result);
            org.junit.Assert.fail("getModelInstancenull43 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void getModelInstance_add1litString417_failAssert0() throws Exception {
        try {
            Object o_getModelInstance_add1__1 = ModelRepositoryProxyTest_Ampl2.baseModel.getValue("id");
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue(":"))));
            IModel result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("relativePath"))));
            Assert.notNull(result);
            org.junit.Assert.fail("getModelInstance_add1litString417 should have thrown Exception");
        } catch (Exception expected) {
            assertEquals("This type of model does not have a : field", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void getModelInstance_literalMutationString9_failAssert0litString368_failAssert0() throws Exception {
        try {
            {
                ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("id"))));
                IModel result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("id"))));
                Assert.notNull(result);
                org.junit.Assert.fail("getModelInstance_literalMutationString9 should have thrown Exception");
            }
            org.junit.Assert.fail("getModelInstance_literalMutationString9_failAssert0litString368 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void getModelInstance_add1_add155litString1145_failAssert0() throws Exception {
        try {
            Object o_getModelInstance_add1_add155__1 = ModelRepositoryProxyTest_Ampl2.baseModel.getValue("id");
            Object o_getModelInstance_add1__1 = ModelRepositoryProxyTest_Ampl2.baseModel.getValue("id");
            ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("systemId"))));
            IModel result = ModelRepositoryProxyTest_Ampl2.proxy.getModelInstance(ModelType.BaseModel, ModelSystem.Atos_HSK, ((String) (ModelRepositoryProxyTest_Ampl2.baseModel.getValue("relativePath"))));
            Assert.notNull(result);
            org.junit.Assert.fail("getModelInstance_add1_add155litString1145 should have thrown ClassCastException");
        } catch (ClassCastException expected) {
            assertEquals("eu.supersede.integration.api.adaptation.types.ModelSystem cannot be cast to java.lang.String", expected.getMessage());
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
        for (String s : lines) {
            content += s + "\n";
        }
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
        for (String s : lines) {
            content += s + "\n";
        }
        content = content.replace("\"", "'");
        return content;
    }
}

