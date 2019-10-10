/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 11:49:27 GMT 2019
 */

package eu.supersede.integration.api.replan.optimizer_v2.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.replan.optimizer_v2.types.Resource;
import eu.supersede.integration.api.replan.optimizer_v2.types.Skill;
import java.util.List;
import java.util.Vector;

public class Resource_ESTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Resource resource0 = new Resource();
      Double double0 = resource0.getAvailability();
      assertNull(double0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Resource resource0 = new Resource();
      String string0 = resource0.getName();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Resource resource0 = new Resource();
      resource0.setSkills((List<Skill>) null);
      List<Skill> list0 = resource0.getSkills();
      assertTrue(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Resource resource0 = new Resource();
      Double double0 = new Double((-876.814157645185));
      resource0.setAvailability(double0);
      Double double1 = resource0.getAvailability();
      assertEquals((-876.814157645185), (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Resource resource0 = new Resource();
      Double double0 = new Double(1279.79602);
      resource0.setAvailability(double0);
      Double double1 = resource0.getAvailability();
      assertEquals(1279.79602, (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Resource resource0 = new Resource();
      Double double0 = new Double(0.0);
      resource0.setAvailability(double0);
      Double double1 = resource0.getAvailability();
      assertEquals(0.0, (double)double1, 0.01);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      Resource resource0 = new Resource();
      resource0.setName("");
      String string0 = resource0.getName();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      Resource resource0 = new Resource();
      resource0.setName("@<6Bny");
      String string0 = resource0.getName();
      assertEquals("@<6Bny", string0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      Resource resource0 = new Resource();
      Vector<Skill> vector0 = new Vector<Skill>();
      Skill skill0 = new Skill();
      vector0.add(skill0);
      resource0.setSkills(vector0);
      List<Skill> list0 = resource0.getSkills();
      assertTrue(list0.contains(skill0));
  }
}