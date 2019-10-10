/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 11:13:20 GMT 2019
 */

package eu.supersede.integration.api.monitoring.manager.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.monitoring.manager.types.Instruction;

public class Instruction_ESTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Instruction instruction0 = new Instruction("", "");
      String string0 = instruction0.getInstruction();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Instruction instruction0 = new Instruction((String) null, ")7/HFM'2?DMAjlC");
      String string0 = instruction0.getLabel();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Instruction instruction0 = new Instruction("1azDi+}zfQDQ$}A}\"", (String) null);
      instruction0.setInstruction("r-v?4kB|Jveg}xxF{[t");
      String string0 = instruction0.getInstruction();
      assertNotNull(string0);
      assertEquals("r-v?4kB|Jveg}xxF{[t", string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Instruction instruction0 = new Instruction("1azDi+}zfQDQ$}A}\"", (String) null);
      String string0 = instruction0.getInstruction();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Instruction instruction0 = new Instruction("", "");
      String string0 = instruction0.getLabel();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Instruction instruction0 = new Instruction("", "&&n");
      assertEquals("", instruction0.getLabel());
      
      instruction0.setLabel("Et$3YvR3XVl!$y2");
      instruction0.getLabel();
      assertEquals("Et$3YvR3XVl!$y2", instruction0.getLabel());
  }
}