/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 11:46:55 GMT 2019
 */

package eu.supersede.integration.api.replan.optimizer_v2.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.replan.optimizer_v2.types.Feature;
import eu.supersede.integration.api.replan.optimizer_v2.types.PlannedFeature;
import eu.supersede.integration.api.replan.optimizer_v2.types.Resource;

public class PlannedFeature_ESTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Double double0 = plannedFeature0.getBeginHour();
      assertNull(double0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Resource resource0 = new Resource();
      plannedFeature0.setResource(resource0);
      Resource resource1 = plannedFeature0.getResource();
      assertSame(resource1, resource0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Boolean boolean0 = plannedFeature0.getFrozen();
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Double double0 = plannedFeature0.getEndHour();
      assertNull(double0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Feature feature0 = new Feature();
      plannedFeature0.setFeature(feature0);
      Feature feature1 = plannedFeature0.getFeature();
      assertSame(feature1, feature0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Feature feature0 = plannedFeature0.getFeature();
      assertNull(feature0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Resource resource0 = plannedFeature0.getResource();
      assertNull(resource0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Boolean boolean0 = new Boolean("");
      plannedFeature0.setFrozen(boolean0);
      Boolean boolean1 = plannedFeature0.getFrozen();
      assertFalse(boolean1);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Double double0 = new Double(0.0);
      plannedFeature0.setBeginHour(double0);
      Double double1 = plannedFeature0.getBeginHour();
      assertEquals(0.0, (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Double double0 = new Double(0.0);
      plannedFeature0.setEndHour(double0);
      Double double1 = plannedFeature0.getEndHour();
      assertEquals(0.0, (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Double double0 = new Double((-1196.4545453771));
      plannedFeature0.setBeginHour(double0);
      Double double1 = plannedFeature0.getBeginHour();
      assertEquals((-1196.4545453771), (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Double double0 = new Double(1.0);
      plannedFeature0.setBeginHour(double0);
      Double double1 = plannedFeature0.getBeginHour();
      assertEquals(1.0, (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Double double0 = new Double((-1073.0));
      plannedFeature0.setEndHour(double0);
      Double double1 = plannedFeature0.getEndHour();
      assertEquals((-1073.0), (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Double double0 = new Double(1.0);
      plannedFeature0.setEndHour(double0);
      Double double1 = plannedFeature0.getEndHour();
      assertEquals(1.0, (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      PlannedFeature plannedFeature0 = new PlannedFeature();
      Boolean boolean0 = Boolean.valueOf(true);
      plannedFeature0.setFrozen(boolean0);
      Boolean boolean1 = plannedFeature0.getFrozen();
      assertTrue(boolean1);
  }
}