/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 11:24:28 GMT 2019
 */

package eu.supersede.integration.api.replan.controller.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.replan.controller.types.FeatureStatus;

public class FeatureStatus_ESTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      FeatureStatus featureStatus0 = FeatureStatus.ANY;
      String string0 = featureStatus0.toString();
      assertEquals("any", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      FeatureStatus[] featureStatusArray0 = FeatureStatus.values();
      assertEquals(3, featureStatusArray0.length);
  }
}
