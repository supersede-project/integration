/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 11:06:56 GMT 2019
 */

package eu.supersede.integration.api.mdm.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.adaptation.types.Tenant;
import eu.supersede.integration.api.mdm.types.Attribute;
import eu.supersede.integration.api.mdm.types.Event;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Event_ESTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Event event0 = new Event();
      String string0 = event0.getEventID();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Event event0 = new Event();
      String string0 = event0.getDispatcherPath();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Event event0 = new Event();
      event0.getTenant();
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Event event0 = new Event();
      String string0 = event0.getGraph();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Event event0 = new Event();
      event0.setDispatcherStrategy("");
      String string0 = event0.getDispatcherStrategy();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Event event0 = new Event();
      String string0 = event0.getDispatch();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Event event0 = new Event();
      String string0 = event0.getType();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Event event0 = new Event();
      LinkedList<Attribute> linkedList0 = new LinkedList<Attribute>();
      event0.setAttributes(linkedList0);
      assertNull(event0.getDispatcherStrategy());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Event event0 = new Event();
      String string0 = event0.getJsonInstances();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Event event0 = new Event();
      event0.setDispatcherPath("eu.supersede.integration.api.mdm.types.Event");
      String string0 = event0.getDispatcherPath();
      assertEquals("eu.supersede.integration.api.mdm.types.Event", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Event event0 = new Event();
      String string0 = event0.getKafkaTopic();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Event event0 = new Event();
      Tenant tenant0 = Tenant.FBK;
      event0.setTenant(tenant0);
      Tenant tenant1 = event0.getTenant();
      assertEquals("fbk", tenant1.getId());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Event event0 = new Event();
      String string0 = event0.getDispatcherStrategy();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Event event0 = new Event();
      String string0 = event0.getEvent();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Event event0 = new Event();
      String string0 = event0.getPlatform();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Event event0 = new Event();
      event0.setJsonInstances("");
      String string0 = event0.getJsonInstances();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Event event0 = new Event();
      List<Attribute> list0 = event0.getAttributes();
      assertEquals(0, list0.size());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Event event0 = new Event();
      ArrayList<Attribute> arrayList0 = new ArrayList<Attribute>();
      Attribute attribute0 = new Attribute();
      arrayList0.add(attribute0);
      event0.attributes = (List<Attribute>) arrayList0;
      List<Attribute> list0 = event0.getAttributes();
      assertTrue(list0.contains(attribute0));
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Event event0 = new Event();
      event0.setDispatch("");
      String string0 = event0.getDispatch();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Event event0 = new Event();
      event0.setDispatch("com.google.common.base.Functions$FunctionComposition");
      String string0 = event0.getDispatch();
      assertEquals("com.google.common.base.Functions$FunctionComposition", string0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Event event0 = new Event();
      event0.setDispatcherPath("");
      String string0 = event0.getDispatcherPath();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Event event0 = new Event();
      event0.setDispatcherStrategy("W5xq0]H");
      String string0 = event0.getDispatcherStrategy();
      assertEquals("W5xq0]H", string0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Event event0 = new Event();
      event0.setEvent("");
      String string0 = event0.getEvent();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Event event0 = new Event();
      event0.setEvent("w;{");
      String string0 = event0.getEvent();
      assertEquals("w;{", string0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Event event0 = new Event();
      event0.setEventID("");
      String string0 = event0.getEventID();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Event event0 = new Event();
      event0.setEventID("7*SJduq_");
      String string0 = event0.getEventID();
      assertEquals("7*SJduq_", string0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Event event0 = new Event();
      event0.setGraph("");
      String string0 = event0.getGraph();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Event event0 = new Event();
      event0.setGraph("com.google.common.primitives.Ints$IntConverter");
      String string0 = event0.getGraph();
      assertEquals("com.google.common.primitives.Ints$IntConverter", string0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Event event0 = new Event();
      event0.setJsonInstances("com.google.common.hash.BloomFilter$1");
      String string0 = event0.getJsonInstances();
      assertEquals("com.google.common.hash.BloomFilter$1", string0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Event event0 = new Event();
      event0.setKafkaTopic("");
      String string0 = event0.getKafkaTopic();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Event event0 = new Event();
      event0.setKafkaTopic("uyol,\"");
      String string0 = event0.getKafkaTopic();
      assertEquals("uyol,\"", string0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Event event0 = new Event();
      event0.setPlatform("");
      String string0 = event0.getPlatform();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Event event0 = new Event();
      event0.setPlatform("nA&Wp>E^3c");
      String string0 = event0.getPlatform();
      assertEquals("nA&Wp>E^3c", string0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Event event0 = new Event();
      event0.setType("");
      String string0 = event0.getType();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Event event0 = new Event();
      event0.setType("(B\"se");
      String string0 = event0.getType();
      assertEquals("(B\"se", string0);
  }
}
