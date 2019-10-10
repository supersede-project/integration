/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 11:33:44 GMT 2019
 */

package eu.supersede.integration.api.replan.controller.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.replan.controller.types.Feature;
import eu.supersede.integration.api.replan.controller.types.FeatureWP3;
import eu.supersede.integration.api.replan.controller.types.Priority;
import eu.supersede.integration.api.replan.controller.types.SoftDependency;

public class ReplanIdentifiableObject_ESTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Feature feature0 = new Feature();
      Priority priority0 = Priority.TWO;
      Integer integer0 = priority0.getValue();
      feature0.setId(integer0);
      Integer integer1 = feature0.getId();
      assertEquals(2, (int)integer1);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Feature feature0 = new Feature();
      Integer integer0 = feature0.getId();
      assertNull(integer0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Integer integer0 = new Integer((-2332));
      SoftDependency softDependency0 = new SoftDependency();
      softDependency0.setId(integer0);
      Integer integer1 = softDependency0.getId();
      assertEquals((-2332), (int)integer1);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      FeatureWP3 featureWP3_0 = new FeatureWP3();
      Integer integer0 = new Integer(0);
      featureWP3_0.setId(integer0);
      Integer integer1 = featureWP3_0.getId();
      assertEquals(0, (int)integer1);
  }
}
