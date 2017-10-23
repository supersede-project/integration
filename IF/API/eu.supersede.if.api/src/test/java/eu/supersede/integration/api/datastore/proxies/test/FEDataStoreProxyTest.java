/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.integration.api.datastore.proxies.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.datastore.fe.types.Notification;
import eu.supersede.integration.api.datastore.fe.types.Profile;
import eu.supersede.integration.api.datastore.fe.types.User;
import eu.supersede.integration.api.datastore.proxies.FEDataStoreProxy;
import eu.supersede.integration.api.security.IFAuthenticationManager;
import eu.supersede.integration.api.security.types.AuthorizationToken;


public class FEDataStoreProxyTest {
	private static final Logger log = LoggerFactory.getLogger(FEDataStoreProxyTest.class);
	private static FEDataStoreProxy<Object, Object> proxy;
	private static IFAuthenticationManager am;
	private static AuthorizationToken token;
	
    @BeforeClass
    public static void setup() throws Exception {
        proxy = new FEDataStoreProxy<Object, Object> ();
        String admin = System.getProperty("is.admin.user");
		String password = System.getProperty("is.admin.passwd");
        am = new IFAuthenticationManager(admin, password);
        token = am.getAuthorizationToken(admin, password, "");
    }

    @Test
    public void testGetUsersLazy() throws Exception{
    	String tenandId = "atos";
    	List<User> users = proxy.getUsers(tenandId, true, token);
    	Assert.notEmpty(users);
    }
    
    @Test
    public void testGetUsers() throws Exception{
    	String tenandId = "atos";
    	List<User> users = proxy.getUsers(tenandId, false, token);
    	Assert.notEmpty(users);
    }
    
    @Test
    public void testGetUserLazy() throws Exception{
    	String tenandId = "atos";
    	int userId = -1;
    	User user = proxy.getUser(tenandId, userId, true, token);
    	Assert.notNull(user);
    }
    
    @Test
    public void testGetUser() throws Exception{
    	String tenandId = "atos";
    	int userId = -1;
    	User user = proxy.getUser(tenandId, userId, false, token);
    	Assert.notNull(user);
    }
    
    @Test
    public void testGetNotifications() throws Exception{
    	String tenandId = "atos";
    	List<Notification> notifications = proxy.getNotifications(tenandId, token);
//    	Assert.notEmpty(notifications);
    }
    
    @Test
    public void testGetNotification() throws Exception{
    	String tenandId = "atos";
    	int notificationId = 3342;
    	Notification notification = proxy.getNotification(tenandId, notificationId, token);
//    	Assert.notNull(notification);
    }
    
    @Test
    public void testGetProfiles() throws Exception{
    	String tenandId = "atos";
    	List<Profile> profiles = proxy.getProfiles(tenandId, token);
    	Assert.notEmpty(profiles);
    }
    
    @Test
    public void testGetProfile() throws Exception{
    	String tenandId = "atos";
    	int profileId = 0;
    	Profile profile = proxy.getProfile(tenandId, profileId, token);
    	Assert.notNull(profile);
    }
    
//    @Test
//    public void testDMGameIssue() throws Exception{
//    	token = am.getAuthorizationToken("test_game", "test_game", "atos");
//    	User user = proxy.getUser("atos", 3368, false, token);
//    	Assert.notNull(user);
//    }
}
