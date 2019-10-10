/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 10:16:30 GMT 2019
 */

package eu.supersede.integration.api.datastore.integration.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.datastore.integration.types.SupersedePlatform;

public class SupersedePlatform_ESTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      String string0 = supersedePlatform0.getMb_password();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      String string0 = supersedePlatform0.getMb_user();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      String string0 = supersedePlatform0.getMb_url();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      String string0 = supersedePlatform0.getPlatform();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      supersedePlatform0.setMb_User("J3P$Z5v");
      assertNull(supersedePlatform0.getMb_url());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      supersedePlatform0.mb_password = "oRFyg$";
      supersedePlatform0.mb_password = "";
      String string0 = supersedePlatform0.getMb_password();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      supersedePlatform0.mb_password = "oRFyg$";
      String string0 = supersedePlatform0.getMb_password();
      assertEquals("oRFyg$", string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      supersedePlatform0.mb_url = "";
      String string0 = supersedePlatform0.getMb_url();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      supersedePlatform0.setMb_url(", mb_password: ");
      String string0 = supersedePlatform0.getMb_url();
      assertEquals(", mb_password: ", string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      supersedePlatform0.mb_user = "";
      String string0 = supersedePlatform0.getMb_user();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      supersedePlatform0.mb_user = "SupersedePlatform[platform: ";
      String string0 = supersedePlatform0.getMb_user();
      assertEquals("SupersedePlatform[platform: ", string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      supersedePlatform0.setPlatform("");
      String string0 = supersedePlatform0.getPlatform();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      supersedePlatform0.platform = "Ri?Pqp-QBy)";
      String string0 = supersedePlatform0.getPlatform();
      assertEquals("Ri?Pqp-QBy)", string0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      supersedePlatform0.platform = "";
      String string0 = supersedePlatform0.toString();
      assertEquals("SupersedePlatform[platform: , mb_user: null, mb_password: null, mb_url: null]", string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      SupersedePlatform supersedePlatform0 = new SupersedePlatform();
      supersedePlatform0.setMb_password("SupersedePlatform[platform: ");
      String string0 = supersedePlatform0.toString();
      assertEquals("SupersedePlatform[platform: null, mb_user: null, mb_password: SupersedePlatform[platform: , mb_url: null]", string0);
  }
}
