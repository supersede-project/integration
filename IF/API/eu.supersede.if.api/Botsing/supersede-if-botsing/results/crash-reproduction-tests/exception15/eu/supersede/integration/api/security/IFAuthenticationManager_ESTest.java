/*
 * This file was automatically generated by EvoSuite
 * Mon Nov 04 15:35:49 GMT 2019
 */

package eu.supersede.integration.api.security;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import eu.supersede.integration.api.security.IFAuthenticationManager;
import eu.supersede.integration.api.security.types.User;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import org.wso2.carbon.user.core.UserStoreException;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class IFAuthenticationManager_ESTest extends IFAuthenticationManager_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      IFAuthenticationManager iFAuthenticationManager0 = new IFAuthenticationManager();
      User user0 = new User();
      user0.setUserName("IqY!(V+kXy");
      try { 
        iFAuthenticationManager0.updateUserCredential(user0, "", "`Z&fIv/0Fi5a");
        fail("Expecting exception: UserStoreException");
      
      } catch(UserStoreException e) {
         //
         // Old credential does not match with the existing credentials.
         //
         verifyException("eu.supersede.integration.api.security.IFUserStoreManager", e);
      }
  }
}
