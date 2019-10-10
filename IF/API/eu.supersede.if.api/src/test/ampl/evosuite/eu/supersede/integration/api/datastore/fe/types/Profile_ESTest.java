/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 10:14:08 GMT 2019
 */

package eu.supersede.integration.api.datastore.fe.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.datastore.fe.types.Label;
import eu.supersede.integration.api.datastore.fe.types.Profile;
import java.util.ArrayList;
import java.util.List;

public class Profile_ESTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Profile profile0 = new Profile();
      int int0 = profile0.getProfile_id();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Profile profile0 = new Profile();
      String string0 = profile0.getName();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Profile profile0 = new Profile();
      List<Label> list0 = profile0.getLabels();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Profile profile0 = new Profile();
      ArrayList<Label> arrayList0 = new ArrayList<Label>();
      arrayList0.add((Label) null);
      profile0.setLabels(arrayList0);
      List<Label> list0 = profile0.getLabels();
      assertFalse(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Profile profile0 = new Profile();
      ArrayList<Label> arrayList0 = new ArrayList<Label>();
      profile0.setLabels(arrayList0);
      List<Label> list0 = profile0.getLabels();
      assertTrue(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Profile profile0 = new Profile();
      profile0.name = "";
      String string0 = profile0.getName();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      Profile profile0 = new Profile();
      profile0.name = "2?M>";
      String string0 = profile0.getName();
      assertEquals("2?M>", string0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      Profile profile0 = new Profile();
      profile0.profile_id = (-1817);
      int int0 = profile0.getProfile_id();
      assertEquals((-1817), int0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      Profile profile0 = new Profile();
      profile0.setProfile_id(1);
      int int0 = profile0.getProfile_id();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test9()  throws Throwable  {
      Profile profile0 = new Profile();
      profile0.setName("");
      assertEquals("", profile0.getName());
  }
}