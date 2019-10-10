/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 11:11:48 GMT 2019
 */

package eu.supersede.integration.api.monitoring.manager.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.monitoring.manager.types.GooglePlayMonitorConfiguration;

public class GooglePlayMonitorConfiguration_ESTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      GooglePlayMonitorConfiguration googlePlayMonitorConfiguration0 = new GooglePlayMonitorConfiguration();
      String string0 = googlePlayMonitorConfiguration0.getPackageName();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      GooglePlayMonitorConfiguration googlePlayMonitorConfiguration0 = new GooglePlayMonitorConfiguration();
      googlePlayMonitorConfiguration0.setPackageName("");
      String string0 = googlePlayMonitorConfiguration0.getPackageName();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      GooglePlayMonitorConfiguration googlePlayMonitorConfiguration0 = new GooglePlayMonitorConfiguration();
      googlePlayMonitorConfiguration0.packageName = "k7-L/";
      String string0 = googlePlayMonitorConfiguration0.getPackageName();
      assertEquals("k7-L/", string0);
  }
}
