/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 10:39:08 GMT 2019
 */

package eu.supersede.integration.api.feedback.orchestrator.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.feedback.orchestrator.types.ApiUserPermission;
import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;
import eu.supersede.integration.api.feedback.orchestrator.types.User;
import eu.supersede.integration.api.feedback.orchestrator.types.UserGroup;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.evosuite.runtime.mock.java.time.MockInstant;
import org.evosuite.runtime.mock.java.util.MockDate;

public class User_ESTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      User user0 = new User();
      long long0 = user0.getId();
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      User user0 = new User();
      user0.setName("");
      String string0 = user0.getName();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Application application0 = new Application();
      UserGroup userGroup0 = new UserGroup();
      User user0 = new User("", "", application0, userGroup0);
      String string0 = user0.getUserIdentification();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      User user0 = new User();
      UserGroup userGroup0 = user0.getUserGroup();
      assertNull(userGroup0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      User user0 = new User();
      String string0 = user0.getName();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      User user0 = new User();
      Application application0 = user0.getApplication();
      assertNull(application0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      User user0 = new User();
      Application application0 = new Application();
      application0.setId((-1639L));
      user0.setApplication(application0);
      Application application1 = user0.getApplication();
      assertSame(application1, application0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      User user0 = new User();
      Application application0 = new Application();
      application0.setId(64L);
      user0.setApplication(application0);
      Application application1 = user0.getApplication();
      assertEquals(0, application1.getState());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Application application0 = new Application();
      Stack<User> stack0 = new Stack<User>();
      UserGroup userGroup0 = new UserGroup("_RD6/%V~{HYxRM)K ", stack0, application0);
      User user0 = new User("CharMatcher.is('", "g$5|z,<Y{o/A", application0, userGroup0);
      user0.getApplication();
      assertEquals("CharMatcher.is('", user0.getName());
      assertEquals("g$5|z,<Y{o/A", user0.getUserIdentification());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      User user0 = new User();
      Instant instant0 = MockInstant.ofEpochMilli((-1678L));
      Date date0 = Date.from(instant0);
      GeneralConfiguration generalConfiguration0 = new GeneralConfiguration();
      ArrayList<Configuration> arrayList0 = new ArrayList<Configuration>();
      LinkedList<UserGroup> linkedList0 = new LinkedList<UserGroup>();
      LinkedList<ApiUserPermission> linkedList1 = new LinkedList<ApiUserPermission>();
      Application application0 = new Application("Fv-3", (-1), date0, date0, generalConfiguration0, arrayList0, (List<User>) null, linkedList0, linkedList1);
      user0.setApplication(application0);
      Application application1 = user0.getApplication();
      assertEquals(0L, application1.getId());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      MockDate mockDate0 = new MockDate(1, 1, 1, 128, 128);
      GeneralConfiguration generalConfiguration0 = new GeneralConfiguration();
      LinkedList<Configuration> linkedList0 = new LinkedList<Configuration>();
      ArrayList<User> arrayList0 = new ArrayList<User>();
      Application application0 = new Application("", 1, mockDate0, mockDate0, generalConfiguration0, linkedList0, arrayList0);
      UserGroup userGroup0 = new UserGroup("", arrayList0, application0);
      User user0 = new User("", "", application0, userGroup0);
      Application application1 = user0.getApplication();
      assertEquals(1, application1.getState());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      User user0 = new User();
      user0.setId((-508L));
      long long0 = user0.getId();
      assertEquals((-508L), long0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Application application0 = new Application();
      Stack<User> stack0 = new Stack<User>();
      UserGroup userGroup0 = new UserGroup("_RD6/%V~{HYxRM)K ", stack0, application0);
      User user0 = new User("CharMatcher.is('", "g$5|z,<Y{o/A", application0, userGroup0);
      user0.setId(1L);
      long long0 = user0.getId();
      assertEquals(1L, long0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      User user0 = new User();
      user0.setName("eu.supersede.integration.api.feedback.orchestrator.types.User");
      String string0 = user0.getName();
      assertEquals("eu.supersede.integration.api.feedback.orchestrator.types.User", string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      MockDate mockDate0 = new MockDate(63, (-862048943), 63, 453, (-1));
      ArrayList<Configuration> arrayList0 = new ArrayList<Configuration>();
      Application application0 = new Application("~-DDo/ G}", (-1), mockDate0, mockDate0, arrayList0);
      UserGroup userGroup0 = new UserGroup();
      User user0 = new User("", "", application0, userGroup0);
      userGroup0.setId((-758L));
      UserGroup userGroup1 = user0.getUserGroup();
      assertFalse(userGroup1.isActive());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      User user0 = new User();
      UserGroup userGroup0 = new UserGroup();
      userGroup0.setId(674L);
      user0.setUserGroup(userGroup0);
      UserGroup userGroup1 = user0.getUserGroup();
      assertEquals(674L, userGroup1.getId());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Application application0 = new Application();
      Stack<User> stack0 = new Stack<User>();
      UserGroup userGroup0 = new UserGroup("_RD6/%V~{HYxRM)K ", stack0, application0);
      User user0 = new User("CharMatcher.is('", "g$5|z,<Y{o/A", application0, userGroup0);
      user0.getUserGroup();
      assertEquals("CharMatcher.is('", user0.getName());
      assertEquals("g$5|z,<Y{o/A", user0.getUserIdentification());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      User user0 = new User();
      UserGroup userGroup0 = new UserGroup();
      userGroup0.setActive(true);
      user0.setUserGroup(userGroup0);
      UserGroup userGroup1 = user0.getUserGroup();
      assertEquals(0L, userGroup1.getId());
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      User user0 = new User();
      user0.setUserIdentification("9v");
      String string0 = user0.getUserIdentification();
      assertEquals("9v", string0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      User user0 = new User();
      String string0 = user0.getUserIdentification();
      assertNull(string0);
  }
}