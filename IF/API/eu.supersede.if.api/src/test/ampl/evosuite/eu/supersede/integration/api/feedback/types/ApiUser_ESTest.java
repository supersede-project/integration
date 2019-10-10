/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 11:00:08 GMT 2019
 */

package eu.supersede.integration.api.feedback.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.feedback.types.ApiUser;
import eu.supersede.integration.api.feedback.types.ApiUserPermission;
import eu.supersede.integration.api.feedback.types.UserRole;
import java.util.List;
import java.util.Vector;

public class ApiUser_ESTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      Integer integer0 = apiUser0.getId();
      assertNull(integer0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      apiUser0.getRole();
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      String string0 = apiUser0.getPassword();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      UserRole userRole0 = UserRole.ADMIN;
      apiUser0.setRole(userRole0);
      UserRole userRole1 = apiUser0.getRole();
      assertEquals(UserRole.ADMIN, userRole1);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      apiUser0.setName("");
      String string0 = apiUser0.getName();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      String string0 = apiUser0.getName();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      List<ApiUserPermission> list0 = apiUser0.getPermissions();
      List<ApiUserPermission> list1 = apiUser0.getPermissions();
      assertSame(list1, list0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      Integer integer0 = new Integer((-1));
      apiUser0.setId(integer0);
      Integer integer1 = apiUser0.getId();
      assertEquals((-1), (int)integer1);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      Integer integer0 = new Integer(8);
      apiUser0.setId(integer0);
      Integer integer1 = apiUser0.getId();
      assertEquals(8, (int)integer1);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      Integer integer0 = new Integer(0);
      apiUser0.setId(integer0);
      Integer integer1 = apiUser0.getId();
      assertEquals(0, (int)integer1);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      apiUser0.setName("#Rdb&4B");
      String string0 = apiUser0.getName();
      assertEquals("#Rdb&4B", string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      apiUser0.setPassword("");
      String string0 = apiUser0.getPassword();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      apiUser0.setPassword("eu.supersede.integration.api.feedback.types.ApiUserPermission");
      String string0 = apiUser0.getPassword();
      assertEquals("eu.supersede.integration.api.feedback.types.ApiUserPermission", string0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      ApiUser apiUser0 = new ApiUser();
      Vector<ApiUserPermission> vector0 = new Vector<ApiUserPermission>();
      ApiUserPermission apiUserPermission0 = new ApiUserPermission();
      vector0.add(apiUserPermission0);
      apiUser0.setPermissions(vector0);
      List<ApiUserPermission> list0 = apiUser0.getPermissions();
      assertTrue(list0.contains(apiUserPermission0));
  }
}