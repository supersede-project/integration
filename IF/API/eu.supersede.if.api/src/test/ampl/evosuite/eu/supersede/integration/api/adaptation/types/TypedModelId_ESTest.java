/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 10:08:36 GMT 2019
 */

package eu.supersede.integration.api.adaptation.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.adaptation.types.IModelId;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.TypedModelId;

public class TypedModelId_ESTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      TypedModelId typedModelId0 = new TypedModelId();
      int int0 = typedModelId0.compareTo((IModelId) typedModelId0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      TypedModelId typedModelId0 = new TypedModelId();
      typedModelId0.setNumber(".,NX(?r43U!");
      assertNull(typedModelId0.getModelType());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      TypedModelId typedModelId0 = new TypedModelId();
      typedModelId0.getModelType();
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      TypedModelId typedModelId0 = new TypedModelId();
      String string0 = typedModelId0.getNumber();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      TypedModelId typedModelId0 = new TypedModelId();
      ModelType modelType0 = ModelType.BaseModel;
      typedModelId0.setModelType(modelType0);
      ModelType modelType1 = typedModelId0.getModelType();
      assertEquals("BaseModel", modelType1.toString());
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ModelType modelType0 = ModelType.BaseModel;
      TypedModelId typedModelId0 = new TypedModelId(modelType0, "");
      String string0 = typedModelId0.getNumber();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ModelType modelType0 = ModelType.PatternModel;
      TypedModelId typedModelId0 = new TypedModelId(modelType0, "0L");
      String string0 = typedModelId0.getNumber();
      assertEquals("0L", string0);
  }
}