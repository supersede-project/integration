/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 09:57:26 GMT 2019
 */

package eu.supersede.integration.api.adaptation.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.adaptation.types.BaseModel;

public class BaseModel_ESTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      BaseModel baseModel0 = new BaseModel();
      String string0 = baseModel0.getStatus();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      BaseModel baseModel0 = new BaseModel();
      baseModel0.setStatus("");
      String string0 = baseModel0.getStatus();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      BaseModel baseModel0 = new BaseModel();
      baseModel0.setStatus("?Aa%y=qRD 0ZIHc");
      String string0 = baseModel0.getStatus();
      assertEquals("?Aa%y=qRD 0ZIHc", string0);
  }
}