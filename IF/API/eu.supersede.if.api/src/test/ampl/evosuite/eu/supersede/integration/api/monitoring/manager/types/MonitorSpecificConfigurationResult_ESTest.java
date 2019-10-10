/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 11:15:26 GMT 2019
 */

package eu.supersede.integration.api.monitoring.manager.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.monitoring.manager.types.MonitorSpecificConfigurationResult;

public class MonitorSpecificConfigurationResult_ESTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      MonitorSpecificConfigurationResult monitorSpecificConfigurationResult0 = new MonitorSpecificConfigurationResult();
      monitorSpecificConfigurationResult0.setMessage("");
      String string0 = monitorSpecificConfigurationResult0.getMessage();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      MonitorSpecificConfigurationResult monitorSpecificConfigurationResult0 = new MonitorSpecificConfigurationResult();
      Integer integer0 = monitorSpecificConfigurationResult0.getIdConf();
      assertNull(integer0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      MonitorSpecificConfigurationResult monitorSpecificConfigurationResult0 = new MonitorSpecificConfigurationResult();
      String string0 = monitorSpecificConfigurationResult0.getMessage();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      MonitorSpecificConfigurationResult monitorSpecificConfigurationResult0 = new MonitorSpecificConfigurationResult();
      String string0 = monitorSpecificConfigurationResult0.getStatus();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      MonitorSpecificConfigurationResult monitorSpecificConfigurationResult0 = new MonitorSpecificConfigurationResult();
      Integer integer0 = new Integer(1524);
      monitorSpecificConfigurationResult0.setIdConf(integer0);
      Integer integer1 = monitorSpecificConfigurationResult0.getIdConf();
      assertEquals(1524, (int)integer1);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      MonitorSpecificConfigurationResult monitorSpecificConfigurationResult0 = new MonitorSpecificConfigurationResult();
      Integer integer0 = Integer.valueOf((-1));
      monitorSpecificConfigurationResult0.setIdConf(integer0);
      Integer integer1 = monitorSpecificConfigurationResult0.getIdConf();
      assertEquals((-1), (int)integer1);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      MonitorSpecificConfigurationResult monitorSpecificConfigurationResult0 = new MonitorSpecificConfigurationResult();
      Integer integer0 = new Integer(0);
      monitorSpecificConfigurationResult0.setIdConf(integer0);
      Integer integer1 = monitorSpecificConfigurationResult0.getIdConf();
      assertEquals(0, (int)integer1);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      MonitorSpecificConfigurationResult monitorSpecificConfigurationResult0 = new MonitorSpecificConfigurationResult();
      monitorSpecificConfigurationResult0.setMessage("Syd#");
      String string0 = monitorSpecificConfigurationResult0.getMessage();
      assertEquals("Syd#", string0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      MonitorSpecificConfigurationResult monitorSpecificConfigurationResult0 = new MonitorSpecificConfigurationResult();
      monitorSpecificConfigurationResult0.status = "";
      String string0 = monitorSpecificConfigurationResult0.getStatus();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test9()  throws Throwable  {
      MonitorSpecificConfigurationResult monitorSpecificConfigurationResult0 = new MonitorSpecificConfigurationResult();
      monitorSpecificConfigurationResult0.setStatus("Syd#");
      String string0 = monitorSpecificConfigurationResult0.getStatus();
      assertEquals("Syd#", string0);
  }
}