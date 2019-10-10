/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 09 10:11:29 GMT 2019
 */

package eu.supersede.integration.api.datastore.fe.types;

import org.junit.Test;
import static org.junit.Assert.*;
import eu.supersede.integration.api.datastore.fe.types.Label;
import eu.supersede.integration.api.datastore.fe.types.LabelsCollection;
import java.util.List;
import java.util.Vector;

public class LabelsCollection_ESTest {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      LabelsCollection labelsCollection0 = new LabelsCollection();
      labelsCollection0.setLabels((List<Label>) null);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      LabelsCollection labelsCollection0 = new LabelsCollection();
      List<Label> list0 = labelsCollection0.getLabels();
      assertTrue(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Vector<Label> vector0 = new Vector<Label>();
      Label label0 = new Label();
      vector0.add(label0);
      LabelsCollection labelsCollection0 = new LabelsCollection(vector0);
      List<Label> list0 = labelsCollection0.getLabels();
      assertEquals(1, list0.size());
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      LabelsCollection labelsCollection0 = new LabelsCollection((List<Label>) null);
      List<Label> list0 = labelsCollection0.getLabels();
      assertNull(list0);
  }
}