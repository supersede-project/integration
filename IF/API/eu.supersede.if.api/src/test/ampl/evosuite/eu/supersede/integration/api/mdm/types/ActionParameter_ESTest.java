/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 11:01:49 GMT 2019
 */

package eu.supersede.integration.api.mdm.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.mdm.types.ActionParameter;
import eu.supersede.integration.api.mdm.types.Event;

public class ActionParameter_ESTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ActionParameter actionParameter0 = new ActionParameter();
      Event event0 = new Event();
      actionParameter0.setEvent(event0);
      Event event1 = actionParameter0.getEvent();
      assertNull(event1.getGraph());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ActionParameter actionParameter0 = new ActionParameter();
      Event event0 = actionParameter0.getEvent();
      assertNull(event0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ActionParameter actionParameter0 = new ActionParameter();
      String string0 = actionParameter0.getAttribute();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ActionParameter actionParameter0 = new ActionParameter();
      actionParameter0.setAttribute("");
      String string0 = actionParameter0.getAttribute();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ActionParameter actionParameter0 = new ActionParameter();
      actionParameter0.setAttribute("]Uj#ecRE");
      String string0 = actionParameter0.getAttribute();
      assertEquals("]Uj#ecRE", string0);
  }
}
