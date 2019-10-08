package eu.supersede.integration.api.datastore.proxies.test;


import eu.supersede.integration.api.datastore.fe.types.Label;
import eu.supersede.integration.api.datastore.fe.types.Notification;
import eu.supersede.integration.api.datastore.fe.types.Profile;
import eu.supersede.integration.api.datastore.fe.types.User;
import eu.supersede.integration.api.datastore.proxies.FEDataStoreProxy;
import eu.supersede.integration.api.security.IFAccount;
import eu.supersede.integration.api.security.IFAuthenticationManager;
import eu.supersede.integration.api.security.types.AuthorizationToken;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class FEDataStoreProxyTest_Ampl4 {
    private static final Logger log = LoggerFactory.getLogger(FEDataStoreProxyTest_Ampl4.class);

    private static FEDataStoreProxy<Object, Object> proxy;

    private static IFAuthenticationManager am;

    private static AuthorizationToken token;

    @BeforeClass
    public static void setup() throws Exception {
        FEDataStoreProxyTest_Ampl4.proxy = new FEDataStoreProxy<Object, Object>();
        String admin = IFAccount.getUser();
        String password = IFAccount.getPassword();
        FEDataStoreProxyTest_Ampl4.am = new IFAuthenticationManager(admin, password);
        FEDataStoreProxyTest_Ampl4.token = FEDataStoreProxyTest_Ampl4.am.getAuthorizationToken(admin, password, "");
    }

    @Test(timeout = 30000)
    public void testGetUsersLazylitString16516_failAssert0() throws Exception {
        try {
            String tenandId = "aos";
            List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, true, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(users);
            org.junit.Assert.fail("testGetUsersLazylitString16516 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUsersLazylitBool16512_add16609() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<User> o_testGetUsersLazylitBool16512_add16609__2 = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
        assertFalse(o_testGetUsersLazylitBool16512_add16609__2.isEmpty());
        List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notEmpty(users);
        assertEquals("atos", tenandId);
        assertFalse(o_testGetUsersLazylitBool16512_add16609__2.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetUsers_add15030() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<User> o_testGetUsers_add15030__2 = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
        assertFalse(o_testGetUsers_add15030__2.isEmpty());
        List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notEmpty(users);
        assertEquals("atos", tenandId);
        assertFalse(o_testGetUsers_add15030__2.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetUsers_add15031() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notEmpty(users);
        Assert.notEmpty(users);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsers_literalMutationBoolean15039() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notEmpty(users);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserslitBool15047() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notEmpty(users);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsers_literalMutationString15033_failAssert0() throws Exception {
        try {
            String tenandId = "";
            List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(users);
            org.junit.Assert.fail("testGetUsers_literalMutationString15033 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Tenant id cannot be unasigned", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUsers_literalMutationString15034_failAssert0() throws Exception {
        try {
            String tenandId = "supersede.es.atos.net:5676";
            List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(users);
            org.junit.Assert.fail("testGetUsers_literalMutationString15034 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUsers_literalMutationString15035_failAssert0() throws Exception {
        try {
            String tenandId = "ats";
            List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(users);
            org.junit.Assert.fail("testGetUsers_literalMutationString15035 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUsers_literalMutationString15038_failAssert0() throws Exception {
        try {
            String tenandId = "a<tos";
            List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(users);
            org.junit.Assert.fail("testGetUsers_literalMutationString15038 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetUsersnull15057_failAssert0() throws Exception {
        try {
            String tenandId = null;
            List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(users);
            org.junit.Assert.fail("testGetUsersnull15057 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUsers_add15030litBool15357() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<User> o_testGetUsers_add15030__2 = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, true, FEDataStoreProxyTest_Ampl4.token);
        List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notEmpty(users);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsers_literalMutationBoolean15039litString15229_failAssert0() throws Exception {
        try {
            String tenandId = "\n";
            List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, true, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(users);
            org.junit.Assert.fail("testGetUsers_literalMutationBoolean15039litString15229 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 54: http://supersede.es.atos.net:8280/supersede/fe/tenant/\n/users_lazy", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUsers_literalMutationString15035_failAssert0_literalMutationBoolean15202_failAssert0() throws Exception {
        try {
            {
                String tenandId = "ats";
                List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, true, FEDataStoreProxyTest_Ampl4.token);
                Assert.notEmpty(users);
                org.junit.Assert.fail("testGetUsers_literalMutationString15035 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetUsers_literalMutationString15035_failAssert0_literalMutationBoolean15202 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUsers_literalMutationString15035_failAssert0litString15242_failAssert0() throws Exception {
        try {
            {
                String tenandId = "ayts";
                List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
                Assert.notEmpty(users);
                org.junit.Assert.fail("testGetUsers_literalMutationString15035 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetUsers_literalMutationString15035_failAssert0litString15242 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUserslitBool15047null15338_failAssert0() throws Exception {
        try {
            String tenandId = null;
            List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, true, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(users);
            org.junit.Assert.fail("testGetUserslitBool15047null15338 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUserslitBool15047litString15220_failAssert0() throws Exception {
        try {
            String tenandId = "@gA&";
            List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, true, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(users);
            org.junit.Assert.fail("testGetUserslitBool15047litString15220 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUsers_add15030litBool15357null16069() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<User> o_testGetUsers_add15030__2 = FEDataStoreProxyTest_Ampl4.proxy.getUsers(null, true, FEDataStoreProxyTest_Ampl4.token);
        List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notEmpty(users);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsers_add15030null15372_literalMutationString15846_failAssert0() throws Exception {
        try {
            String tenandId = "";
            List<User> o_testGetUsers_add15030__2 = FEDataStoreProxyTest_Ampl4.proxy.getUsers(null, false, FEDataStoreProxyTest_Ampl4.token);
            List<User> users = FEDataStoreProxyTest_Ampl4.proxy.getUsers(tenandId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(users);
            org.junit.Assert.fail("testGetUsers_add15030null15372_literalMutationString15846 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Tenant id cannot be unasigned", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        assertEquals(-1, ((int) (((User) (o_testGetUserLazy_add11555__4)).getUser_id())));
        assertEquals("WP", ((User) (o_testGetUserLazy_add11555__4)).getFirst_name());
        assertEquals("Admin", ((User) (o_testGetUserLazy_add11555__4)).getLast_name());
        assertEquals("wp_admin@supersede.eu", ((User) (o_testGetUserLazy_add11555__4)).getEmail());
        assertEquals("es", ((User) (o_testGetUserLazy_add11555__4)).getLocale());
        assertNull(((User) (o_testGetUserLazy_add11555__4)).getNotifications());
        assertNull(((User) (o_testGetUserLazy_add11555__4)).getProfiles());
        assertEquals("wp_admin", ((User) (o_testGetUserLazy_add11555__4)).getUsername());
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("atos", tenandId);
        assertEquals(-1, ((int) (((User) (o_testGetUserLazy_add11555__4)).getUser_id())));
        assertEquals("WP", ((User) (o_testGetUserLazy_add11555__4)).getFirst_name());
        assertEquals("Admin", ((User) (o_testGetUserLazy_add11555__4)).getLast_name());
        assertEquals("wp_admin@supersede.eu", ((User) (o_testGetUserLazy_add11555__4)).getEmail());
        assertEquals("es", ((User) (o_testGetUserLazy_add11555__4)).getLocale());
        assertNull(((User) (o_testGetUserLazy_add11555__4)).getNotifications());
        assertNull(((User) (o_testGetUserLazy_add11555__4)).getProfiles());
        assertEquals("wp_admin", ((User) (o_testGetUserLazy_add11555__4)).getUsername());
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11573() throws Exception {
        List<Notification> __DSPOT_notifications_868 = Collections.<Notification>emptyList();
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_868);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11574() throws Exception {
        List<Profile> __DSPOT_profiles_869 = Collections.<Profile>emptyList();
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setProfiles(__DSPOT_profiles_869);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazylitString11598_failAssert0() throws Exception {
        try {
            String tenandId = ":";
            int userId = -1;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            org.junit.Assert.fail("testGetUserLazylitString11598 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add11915() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        o_testGetUserLazy_add11555__4.getNotifications();
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add12031() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUserLazy_add11555__4.getUsername();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11574_mg11933() throws Exception {
        List<Profile> __DSPOT_profiles_918 = Collections.singletonList(new Profile());
        List<Profile> __DSPOT_profiles_869 = Collections.<Profile>emptyList();
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setProfiles(__DSPOT_profiles_869);
        user.setProfiles(__DSPOT_profiles_918);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555litBool12278() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11574_literalMutationString11831() throws Exception {
        List<Profile> __DSPOT_profiles_869 = Collections.<Profile>emptyList();
        String tenandId = "ahtos";
        assertEquals("ahtos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setProfiles(__DSPOT_profiles_869);
        assertEquals("ahtos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11573_mg11927() throws Exception {
        List<Profile> __DSPOT_profiles_912 = Collections.<Profile>emptyList();
        List<Notification> __DSPOT_notifications_868 = Collections.<Notification>emptyList();
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_868);
        user.setProfiles(__DSPOT_profiles_912);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_mg12203() throws Exception {
        List<Notification> __DSPOT_notifications_951 = Collections.singletonList(new Notification());
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUserLazy_add11555__4.setNotifications(__DSPOT_notifications_951);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add11879() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        o_testGetUserLazy_add11555__4.getLast_name();
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11573null12205() throws Exception {
        List<Notification> __DSPOT_notifications_868 = Collections.<Notification>emptyList();
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_868);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11573_literalMutationNumber11850() throws Exception {
        List<Notification> __DSPOT_notifications_868 = Collections.<Notification>emptyList();
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = 0;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_868);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11574_add11749() throws Exception {
        List<Profile> __DSPOT_profiles_869 = Collections.<Profile>emptyList();
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_mg11574_add11749__6 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        assertEquals(-1, ((int) (((User) (o_testGetUserLazy_mg11574_add11749__6)).getUser_id())));
        assertEquals("WP", ((User) (o_testGetUserLazy_mg11574_add11749__6)).getFirst_name());
        assertEquals("es", ((User) (o_testGetUserLazy_mg11574_add11749__6)).getLocale());
        assertNull(((User) (o_testGetUserLazy_mg11574_add11749__6)).getNotifications());
        assertEquals("Admin", ((User) (o_testGetUserLazy_mg11574_add11749__6)).getLast_name());
        assertEquals("wp_admin@supersede.eu", ((User) (o_testGetUserLazy_mg11574_add11749__6)).getEmail());
        assertEquals("wp_admin", ((User) (o_testGetUserLazy_mg11574_add11749__6)).getUsername());
        assertNull(((User) (o_testGetUserLazy_mg11574_add11749__6)).getProfiles());
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setProfiles(__DSPOT_profiles_869);
        assertEquals("atos", tenandId);
        assertEquals(-1, ((int) (((User) (o_testGetUserLazy_mg11574_add11749__6)).getUser_id())));
        assertEquals("WP", ((User) (o_testGetUserLazy_mg11574_add11749__6)).getFirst_name());
        assertEquals("es", ((User) (o_testGetUserLazy_mg11574_add11749__6)).getLocale());
        assertNull(((User) (o_testGetUserLazy_mg11574_add11749__6)).getNotifications());
        assertEquals("Admin", ((User) (o_testGetUserLazy_mg11574_add11749__6)).getLast_name());
        assertEquals("wp_admin@supersede.eu", ((User) (o_testGetUserLazy_mg11574_add11749__6)).getEmail());
        assertEquals("wp_admin", ((User) (o_testGetUserLazy_mg11574_add11749__6)).getUsername());
        assertNull(((User) (o_testGetUserLazy_mg11574_add11749__6)).getProfiles());
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add11991() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUserLazy_add11555__4.getEmail();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add11879null14503() throws Exception {
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        o_testGetUserLazy_add11555__4.getLast_name();
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add12031litString14387() throws Exception {
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUserLazy_add11555__4.getUsername();
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11556_add11744_add13256() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11556_add11744__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        Assert.notNull(user);
        o_testGetUserLazy_add11556_add11744__4.getUser_id();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11573_mg11927_literalMutationString14101() throws Exception {
        List<Profile> __DSPOT_profiles_912 = Collections.<Profile>emptyList();
        List<Notification> __DSPOT_notifications_868 = Collections.<Notification>emptyList();
        String tenandId = "atTos";
        assertEquals("atTos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_868);
        user.setProfiles(__DSPOT_profiles_912);
        assertEquals("atTos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11573null12205litBool13537() throws Exception {
        List<Notification> __DSPOT_notifications_868 = Collections.<Notification>emptyList();
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_868);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11573null12205_mg13049() throws Exception {
        String __DSPOT_name_992 = "FA#>?M^UK4{)N+I+fnw?";
        List<Notification> __DSPOT_notifications_868 = Collections.<Notification>emptyList();
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_868);
        user.setUsername(__DSPOT_name_992);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_mg12203litBool14118() throws Exception {
        List<Notification> __DSPOT_notifications_951 = Collections.singletonList(new Notification());
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUserLazy_add11555__4.setNotifications(__DSPOT_notifications_951);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add11879_mg14218() throws Exception {
        List<Profile> __DSPOT_profiles_1244 = Collections.<Profile>emptyList();
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        o_testGetUserLazy_add11555__4.getLast_name();
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUserLazy_add11555__4.setProfiles(__DSPOT_profiles_1244);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add11915litNum13880() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -0;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        o_testGetUserLazy_add11555__4.getNotifications();
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11556_add11744_literalMutationBoolean13624() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11556_add11744__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        Assert.notNull(user);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add11991_literalMutationNumber12949() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = 0;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUserLazy_add11555__4.getEmail();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11556litNum12166_add13707() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -0;
        User o_testGetUserLazy_add11556litNum12166_add13707__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getFirst_name());
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getLocale());
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getNotifications());
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getLast_name());
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getUsername());
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getEmail());
        assertEquals(0, ((int) (((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getUser_id())));
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getProfiles());
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        Assert.notNull(user);
        assertEquals("atos", tenandId);
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getFirst_name());
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getLocale());
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getNotifications());
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getLast_name());
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getUsername());
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getEmail());
        assertEquals(0, ((int) (((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getUser_id())));
        assertNull(((User) (o_testGetUserLazy_add11556litNum12166_add13707__4)).getProfiles());
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11574_literalMutationString11831litBool13654() throws Exception {
        List<Profile> __DSPOT_profiles_869 = Collections.<Profile>emptyList();
        String tenandId = "ahtos";
        assertEquals("ahtos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setProfiles(__DSPOT_profiles_869);
        assertEquals("ahtos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add11991_literalMutationString12887() throws Exception {
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUserLazy_add11555__4.getEmail();
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11574_literalMutationString11831_mg13018() throws Exception {
        String __DSPOT_name_983 = "S[5pwY9M2`(m&/v)K66%";
        List<Profile> __DSPOT_profiles_869 = Collections.<Profile>emptyList();
        String tenandId = "ahtos";
        assertEquals("ahtos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setProfiles(__DSPOT_profiles_869);
        user.setLast_name(__DSPOT_name_983);
        assertEquals("ahtos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11556litNum12166_mg13823() throws Exception {
        List<Notification> __DSPOT_notifications_1189 = Collections.singletonList(new Notification());
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -0;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_1189);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11574_add11749_add13460() throws Exception {
        List<Profile> __DSPOT_profiles_869 = Collections.<Profile>emptyList();
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_mg11574_add11749__6 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setProfiles(__DSPOT_profiles_869);
        o_testGetUserLazy_mg11574_add11749__6.getUsername();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add12031litBool14489() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUserLazy_add11555__4.getUsername();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11574_mg11933null13999() throws Exception {
        List<Profile> __DSPOT_profiles_918 = Collections.singletonList(new Profile());
        List<Profile> __DSPOT_profiles_869 = Collections.<Profile>emptyList();
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setProfiles(__DSPOT_profiles_869);
        user.setProfiles(__DSPOT_profiles_918);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_literalMutationString11560litBool12210_mg13961() throws Exception {
        int __DSPOT_user_id_1210 = 1243177885;
        String tenandId = "atGos";
        assertEquals("atGos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setUser_id(__DSPOT_user_id_1210);
        assertEquals("atGos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazynull11605null12170_mg13201() throws Exception {
        String __DSPOT_name_1048 = ":ki6/}>RCYRe2/tT{-Y;";
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(null, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setFirst_name(__DSPOT_name_1048);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add11879litString14353() throws Exception {
        String tenandId = "a9tos";
        assertEquals("a9tos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        o_testGetUserLazy_add11555__4.getLast_name();
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("a9tos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11573_literalMutationNumber11850_mg13263() throws Exception {
        int __DSPOT_user_id_1068 = 2128546363;
        List<Notification> __DSPOT_notifications_868 = Collections.<Notification>emptyList();
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = 0;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_868);
        user.setUser_id(__DSPOT_user_id_1068);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_mg12203_literalMutationBoolean13031() throws Exception {
        List<Notification> __DSPOT_notifications_951 = Collections.singletonList(new Notification());
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUserLazy_add11555__4.setNotifications(__DSPOT_notifications_951);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_add11879litBool14493() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        o_testGetUserLazy_add11555__4.getLast_name();
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11573null12205_mg12976() throws Exception {
        String __DSPOT_locale_971 = "hpjQ{IK2kTm71M*snl2-";
        List<Notification> __DSPOT_notifications_868 = Collections.<Notification>emptyList();
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_868);
        user.setLocale(__DSPOT_locale_971);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11574_mg11933litString13605_failAssert0() throws Exception {
        try {
            List<Profile> __DSPOT_profiles_918 = Collections.singletonList(new Profile());
            List<Profile> __DSPOT_profiles_869 = Collections.<Profile>emptyList();
            String tenandId = "D(,g";
            int userId = -1;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            user.setProfiles(__DSPOT_profiles_869);
            user.setProfiles(__DSPOT_profiles_918);
            org.junit.Assert.fail("testGetUserLazy_mg11574_mg11933litString13605 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_mg11574_mg11933litString13613_failAssert0() throws Exception {
        try {
            List<Profile> __DSPOT_profiles_918 = Collections.singletonList(new Profile());
            List<Profile> __DSPOT_profiles_869 = Collections.<Profile>emptyList();
            String tenandId = "\n";
            int userId = -1;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            user.setProfiles(__DSPOT_profiles_869);
            user.setProfiles(__DSPOT_profiles_918);
            org.junit.Assert.fail("testGetUserLazy_mg11574_mg11933litString13613 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUserLazy_add11555_mg12203litString13870_failAssert0() throws Exception {
        try {
            List<Notification> __DSPOT_notifications_951 = Collections.singletonList(new Notification());
            String tenandId = "PF{S";
            int userId = -1;
            User o_testGetUserLazy_add11555__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            o_testGetUserLazy_add11555__4.setNotifications(__DSPOT_notifications_951);
            org.junit.Assert.fail("testGetUserLazy_add11555_mg12203litString13870 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_add8795() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User o_testGetUser_add8795__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        assertEquals(-1, ((int) (((User) (o_testGetUser_add8795__4)).getUser_id())));
        assertEquals("WP", ((User) (o_testGetUser_add8795__4)).getFirst_name());
        assertEquals("Admin", ((User) (o_testGetUser_add8795__4)).getLast_name());
        assertEquals("wp_admin@supersede.eu", ((User) (o_testGetUser_add8795__4)).getEmail());
        assertEquals("es", ((User) (o_testGetUser_add8795__4)).getLocale());
        assertNull(((User) (o_testGetUser_add8795__4)).getNotifications());
        assertFalse(((Collection) (((User) (o_testGetUser_add8795__4)).getProfiles())).isEmpty());
        assertEquals("wp_admin", ((User) (o_testGetUser_add8795__4)).getUsername());
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("atos", tenandId);
        assertEquals(-1, ((int) (((User) (o_testGetUser_add8795__4)).getUser_id())));
        assertEquals("WP", ((User) (o_testGetUser_add8795__4)).getFirst_name());
        assertEquals("Admin", ((User) (o_testGetUser_add8795__4)).getLast_name());
        assertEquals("wp_admin@supersede.eu", ((User) (o_testGetUser_add8795__4)).getEmail());
        assertEquals("es", ((User) (o_testGetUser_add8795__4)).getLocale());
        assertNull(((User) (o_testGetUser_add8795__4)).getNotifications());
        assertFalse(((Collection) (((User) (o_testGetUser_add8795__4)).getProfiles())).isEmpty());
        assertEquals("wp_admin", ((User) (o_testGetUser_add8795__4)).getUsername());
    }

    @Test(timeout = 30000)
    public void testGetUser_add8796() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        Assert.notNull(user);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_remove8797() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800() throws Exception {
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationBoolean8808() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_mg8813() throws Exception {
        List<Notification> __DSPOT_notifications_540 = Collections.singletonList(new Notification());
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_540);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUserlitString8817() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845() throws Exception {
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8798_failAssert0() throws Exception {
        try {
            String tenandId = "";
            int userId = -1;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            org.junit.Assert.fail("testGetUser_literalMutationString8798 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8799_failAssert0() throws Exception {
        try {
            String tenandId = "supersede.es.atos.net:5676";
            int userId = -1;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            org.junit.Assert.fail("testGetUser_literalMutationString8799 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8801_failAssert0() throws Exception {
        try {
            String tenandId = "}!2X";
            int userId = -1;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            org.junit.Assert.fail("testGetUser_literalMutationString8801 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUserlitNum8825_failAssert0() throws Exception {
        try {
            String tenandId = "atos";
            int userId = -2;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            org.junit.Assert.fail("testGetUserlitNum8825 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationBoolean8808litString9200() throws Exception {
        String tenandId = ".N.z";
        assertEquals(".N.z", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals(".N.z", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845_add9020() throws Exception {
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User o_testGetUsernull8845_add9020__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getFirst_name());
        assertEquals(0, ((int) (((User) (o_testGetUsernull8845_add9020__4)).getUser_id())));
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getLocale());
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getEmail());
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getUsername());
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getLast_name());
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getNotifications());
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getProfiles());
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertNull(tenandId);
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getFirst_name());
        assertEquals(0, ((int) (((User) (o_testGetUsernull8845_add9020__4)).getUser_id())));
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getLocale());
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getEmail());
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getUsername());
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getLast_name());
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getNotifications());
        assertNull(((User) (o_testGetUsernull8845_add9020__4)).getProfiles());
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845_mg9173() throws Exception {
        String __DSPOT_name_594 = "A>b:IzfJy 0=.[DO+]7<";
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setLast_name(__DSPOT_name_594);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800_mg9117() throws Exception {
        String __DSPOT_name_562 = "_<cBEu#P/,w[il`jzs}>";
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setLast_name(__DSPOT_name_562);
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_mg8813litString9274() throws Exception {
        List<Notification> __DSPOT_notifications_540 = Collections.singletonList(new Notification());
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_540);
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845_mg9180() throws Exception {
        String __DSPOT_locale_603 = "v=i9Y@v)kZowV3*r!]2^";
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setLocale(__DSPOT_locale_603);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845litBool9483() throws Exception {
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800_mg9142() throws Exception {
        List<Profile> __DSPOT_profiles_578 = Collections.singletonList(new Profile());
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setProfiles(__DSPOT_profiles_578);
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_mg8813litNum9425_failAssert0() throws Exception {
        try {
            List<Notification> __DSPOT_notifications_540 = Collections.singletonList(new Notification());
            String tenandId = "atos";
            int userId = -(Integer.MIN_VALUE);
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            user.setNotifications(__DSPOT_notifications_540);
            org.junit.Assert.fail("testGetUser_mg8813litNum9425 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845litNum9403_failAssert0() throws Exception {
        try {
            String tenandId = null;
            int userId = -(Integer.MAX_VALUE);
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            org.junit.Assert.fail("testGetUsernull8845litNum9403 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8798_failAssert0_mg9150_failAssert0() throws Exception {
        try {
            {
                List<Profile> __DSPOT_profiles_582 = Collections.singletonList(new Profile());
                String tenandId = "";
                int userId = -1;
                User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
                Assert.notNull(user);
                org.junit.Assert.fail("testGetUser_literalMutationString8798 should have thrown IllegalArgumentException");
                user.setProfiles(__DSPOT_profiles_582);
            }
            org.junit.Assert.fail("testGetUser_literalMutationString8798_failAssert0_mg9150 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationBoolean8808litString9210_failAssert0() throws Exception {
        try {
            String tenandId = ":";
            int userId = -1;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            org.junit.Assert.fail("testGetUser_literalMutationBoolean8808litString9210 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationBoolean8808litString9331_failAssert0() throws Exception {
        try {
            String tenandId = "n%c{";
            int userId = -1;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            org.junit.Assert.fail("testGetUser_literalMutationBoolean8808litString9331 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_mg8813litString9407_failAssert0() throws Exception {
        try {
            List<Notification> __DSPOT_notifications_540 = Collections.singletonList(new Notification());
            String tenandId = "\n";
            int userId = -1;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            user.setNotifications(__DSPOT_notifications_540);
            org.junit.Assert.fail("testGetUser_mg8813litString9407 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_mg8813litString9284_failAssert0() throws Exception {
        try {
            List<Notification> __DSPOT_notifications_540 = Collections.singletonList(new Notification());
            String tenandId = ":";
            int userId = -1;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            user.setNotifications(__DSPOT_notifications_540);
            org.junit.Assert.fail("testGetUser_mg8813litString9284 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_mg8813litString9405_failAssert0() throws Exception {
        try {
            List<Notification> __DSPOT_notifications_540 = Collections.singletonList(new Notification());
            String tenandId = "";
            int userId = -1;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            user.setNotifications(__DSPOT_notifications_540);
            org.junit.Assert.fail("testGetUser_mg8813litString9405 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_add8796null9439_failAssert0() throws Exception {
        try {
            String tenandId = "atos";
            int userId = -1;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(null);
            Assert.notNull(user);
            org.junit.Assert.fail("testGetUser_add8796null9439 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_add8795_literalMutationString9426_failAssert0() throws Exception {
        try {
            String tenandId = "supersede.es.atos.net:5676";
            int userId = -1;
            User o_testGetUser_add8795__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            org.junit.Assert.fail("testGetUser_add8795_literalMutationString9426 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationBoolean8808litString9200_mg10407() throws Exception {
        String __DSPOT_name_743 = "VK:+S:`c-k7@*Kd]Y;od";
        String tenandId = ".N.z";
        assertEquals(".N.z", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setUsername(__DSPOT_name_743);
        assertEquals(".N.z", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800_mg9142_mg10392() throws Exception {
        String __DSPOT_name_733 = "/rHE0YV;yXN`hMWO=xm:";
        List<Profile> __DSPOT_profiles_578 = Collections.singletonList(new Profile());
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setProfiles(__DSPOT_profiles_578);
        user.setUsername(__DSPOT_name_733);
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845_add9020_mg10763() throws Exception {
        String __DSPOT_email_840 = "J4w@19CgInh.}]I:/[B:";
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User o_testGetUsernull8845_add9020__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUsernull8845_add9020__4.setEmail(__DSPOT_email_840);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800_literalMutationNumber9055_mg10396() throws Exception {
        String __DSPOT_email_734 = "39*RU(4Ci|&C!/KA@(P(";
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = 0;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setEmail(__DSPOT_email_734);
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800_mg9142null10985() throws Exception {
        List<Profile> __DSPOT_profiles_578 = Collections.singletonList(new Profile());
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(null, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setProfiles(__DSPOT_profiles_578);
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800_mg9117_literalMutationBoolean10393() throws Exception {
        String __DSPOT_name_562 = "_<cBEu#P/,w[il`jzs}>";
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setLast_name(__DSPOT_name_562);
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845_add9020_add10635() throws Exception {
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User o_testGetUsernull8845_add9020__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUsernull8845_add9020__4.getProfiles();
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800_literalMutationNumber9055_literalMutationString10311() throws Exception {
        String tenandId = "Cts";
        assertEquals("Cts", tenandId);
        int userId = 0;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("Cts", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845litBool9483_mg10362() throws Exception {
        int __DSPOT_user_id_715 = -698022659;
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setUser_id(__DSPOT_user_id_715);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845_mg9180_add10051() throws Exception {
        String __DSPOT_locale_603 = "v=i9Y@v)kZowV3*r!]2^";
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User o_testGetUsernull8845_mg9180_add10051__5 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        assertEquals(0, ((int) (((User) (o_testGetUsernull8845_mg9180_add10051__5)).getUser_id())));
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getFirst_name());
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getLast_name());
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getEmail());
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getLocale());
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getProfiles());
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getNotifications());
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getUsername());
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setLocale(__DSPOT_locale_603);
        assertNull(tenandId);
        assertEquals(0, ((int) (((User) (o_testGetUsernull8845_mg9180_add10051__5)).getUser_id())));
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getFirst_name());
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getLast_name());
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getEmail());
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getLocale());
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getProfiles());
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getNotifications());
        assertNull(((User) (o_testGetUsernull8845_mg9180_add10051__5)).getUsername());
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800_mg9142litBool10682() throws Exception {
        List<Profile> __DSPOT_profiles_578 = Collections.singletonList(new Profile());
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setProfiles(__DSPOT_profiles_578);
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845_add9020_mg10773() throws Exception {
        String __DSPOT_name_841 = "=ZaQ/U0[/CHafia_[wGs";
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User o_testGetUsernull8845_add9020__4 = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        o_testGetUsernull8845_add9020__4.setFirst_name(__DSPOT_name_841);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationBoolean8808litString9200_mg10206() throws Exception {
        String __DSPOT_email_650 = "wH&s&#%ae|.*yUM_cS5a";
        String tenandId = ".N.z";
        assertEquals(".N.z", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setEmail(__DSPOT_email_650);
        assertEquals(".N.z", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845_mg9180_mg10390() throws Exception {
        String __DSPOT_name_731 = "d0|x(qm*=]Rs@TQeQ<=7";
        String __DSPOT_locale_603 = "v=i9Y@v)kZowV3*r!]2^";
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setLocale(__DSPOT_locale_603);
        user.setFirst_name(__DSPOT_name_731);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800_mg9117_mg10428() throws Exception {
        String __DSPOT_locale_759 = "obP XVsZ* ol$g:g6:`C";
        String __DSPOT_name_562 = "_<cBEu#P/,w[il`jzs}>";
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setLast_name(__DSPOT_name_562);
        user.setLocale(__DSPOT_locale_759);
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845litBool9483_mg10162() throws Exception {
        String __DSPOT_name_646 = "p_MjnEt$Y7L^j(%?$[,`";
        String tenandId = null;
        assertNull(tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, true, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setLast_name(__DSPOT_name_646);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800_literalMutationNumber9055_mg10426() throws Exception {
        List<Notification> __DSPOT_notifications_758 = Collections.<Notification>emptyList();
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = 0;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setNotifications(__DSPOT_notifications_758);
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUsernull8845_literalMutationNumber9070_mg10907() throws Exception {
        String __DSPOT_name_858 = "QH;%4NU2HnO;cC2M hH+";
        String tenandId = null;
        assertNull(tenandId);
        int userId = 2;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        user.setUsername(__DSPOT_name_858);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800_mg9142_remove10065() throws Exception {
        List<Profile> __DSPOT_profiles_578 = Collections.singletonList(new Profile());
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int userId = -1;
        User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(user);
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetUser_mg8813litString9407_failAssert0_mg10446_failAssert0() throws Exception {
        try {
            {
                List<Profile> __DSPOT_profiles_770 = Collections.singletonList(new Profile());
                List<Notification> __DSPOT_notifications_540 = Collections.singletonList(new Notification());
                String tenandId = "\n";
                int userId = -1;
                User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
                Assert.notNull(user);
                user.setNotifications(__DSPOT_notifications_540);
                org.junit.Assert.fail("testGetUser_mg8813litString9407 should have thrown IllegalArgumentException");
                user.setProfiles(__DSPOT_profiles_770);
            }
            org.junit.Assert.fail("testGetUser_mg8813litString9407_failAssert0_mg10446 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_mg8813litString9284_failAssert0_mg10453_failAssert0() throws Exception {
        try {
            {
                List<Profile> __DSPOT_profiles_774 = Collections.singletonList(new Profile());
                List<Notification> __DSPOT_notifications_540 = Collections.singletonList(new Notification());
                String tenandId = ":";
                int userId = -1;
                User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
                Assert.notNull(user);
                user.setNotifications(__DSPOT_notifications_540);
                org.junit.Assert.fail("testGetUser_mg8813litString9284 should have thrown IllegalArgumentException");
                user.setProfiles(__DSPOT_profiles_774);
            }
            org.junit.Assert.fail("testGetUser_mg8813litString9284_failAssert0_mg10453 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_mg8813litNum9425_failAssert0null11033_failAssert0() throws Exception {
        try {
            {
                List<Notification> __DSPOT_notifications_540 = Collections.singletonList(new Notification());
                String tenandId = "atos";
                int userId = -(Integer.MIN_VALUE);
                User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(null, userId, false, FEDataStoreProxyTest_Ampl4.token);
                Assert.notNull(user);
                user.setNotifications(__DSPOT_notifications_540);
                org.junit.Assert.fail("testGetUser_mg8813litNum9425 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetUser_mg8813litNum9425_failAssert0null11033 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUser_literalMutationString8800_mg9142litNum10640_failAssert0() throws Exception {
        try {
            List<Profile> __DSPOT_profiles_578 = Collections.singletonList(new Profile());
            String tenandId = "ats";
            int userId = -2;
            User user = FEDataStoreProxyTest_Ampl4.proxy.getUser(tenandId, userId, false, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(user);
            user.setProfiles(__DSPOT_profiles_578);
            org.junit.Assert.fail("testGetUser_literalMutationString8800_mg9142litNum10640 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotifications_add4616() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<Notification> o_testGetNotifications_add4616__2 = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
        assertTrue(o_testGetNotifications_add4616__2.isEmpty());
        List<Notification> notifications = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notifications);
        assertEquals("atos", tenandId);
        assertTrue(o_testGetNotifications_add4616__2.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetNotificationsnull4641() throws Exception {
        String tenandId = null;
        assertNull(tenandId);
        List<Notification> notifications = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notifications);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotificationsnull4642() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<Notification> notifications = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(null, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notifications);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotifications_literalMutationString4619_failAssert0() throws Exception {
        try {
            String tenandId = "";
            List<Notification> notifications = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(notifications);
            org.junit.Assert.fail("testGetNotifications_literalMutationString4619 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotifications_literalMutationString4620_failAssert0() throws Exception {
        try {
            String tenandId = "supersede.es.atos.net:5676";
            List<Notification> notifications = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(notifications);
            org.junit.Assert.fail("testGetNotifications_literalMutationString4620 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotifications_literalMutationString4623_failAssert0() throws Exception {
        try {
            String tenandId = "0ev ";
            List<Notification> notifications = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(notifications);
            org.junit.Assert.fail("testGetNotifications_literalMutationString4623 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotifications_add4616_add4755_add5136() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<Notification> o_testGetNotifications_add4616_add4755_add5136__2 = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
        assertTrue(o_testGetNotifications_add4616_add4755_add5136__2.isEmpty());
        List<Notification> o_testGetNotifications_add4616_add4755__2 = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
        List<Notification> o_testGetNotifications_add4616__2 = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
        List<Notification> notifications = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notifications);
        assertEquals("atos", tenandId);
        assertTrue(o_testGetNotifications_add4616_add4755_add5136__2.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetNotifications_add4616_add4755null5219() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<Notification> o_testGetNotifications_add4616_add4755__2 = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(null, FEDataStoreProxyTest_Ampl4.token);
        List<Notification> o_testGetNotifications_add4616__2 = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
        List<Notification> notifications = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notifications);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotifications_add4616_literalMutationString4792_failAssert0null5204_failAssert0() throws Exception {
        try {
            {
                String tenandId = "";
                List<Notification> o_testGetNotifications_add4616__2 = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(null, FEDataStoreProxyTest_Ampl4.token);
                List<Notification> notifications = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
                Assert.notNull(notifications);
                org.junit.Assert.fail("testGetNotifications_add4616_literalMutationString4792 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetNotifications_add4616_literalMutationString4792_failAssert0null5204 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotifications_add4616_literalMutationString4797_failAssert0null5215_failAssert0() throws Exception {
        try {
            {
                String tenandId = "supersede.es.atos.net:5676";
                List<Notification> o_testGetNotifications_add4616__2 = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(null, FEDataStoreProxyTest_Ampl4.token);
                List<Notification> notifications = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
                Assert.notNull(notifications);
                org.junit.Assert.fail("testGetNotifications_add4616_literalMutationString4797 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetNotifications_add4616_literalMutationString4797_failAssert0null5215 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotifications_add4616litString4820_failAssert0null5179_failAssert0() throws Exception {
        try {
            {
                String tenandId = "\n";
                List<Notification> o_testGetNotifications_add4616__2 = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(null, FEDataStoreProxyTest_Ampl4.token);
                List<Notification> notifications = FEDataStoreProxyTest_Ampl4.proxy.getNotifications(tenandId, FEDataStoreProxyTest_Ampl4.token);
                Assert.notNull(notifications);
                org.junit.Assert.fail("testGetNotifications_add4616litString4820 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetNotifications_add4616litString4820_failAssert0null5179 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotification_add1() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_add1__3 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        assertFalse(((Notification) (o_testGetNotification_add1__3)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotification_add1__3)).isRead());
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_add1__3)).getUser_id())));
        assertNull(((Notification) (o_testGetNotification_add1__3)).getLink());
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_add1__3)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_add1__3)).getMessage());
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        assertEquals("atos", tenandId);
        assertFalse(((Notification) (o_testGetNotification_add1__3)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotification_add1__3)).isRead());
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_add1__3)).getUser_id())));
        assertNull(((Notification) (o_testGetNotification_add1__3)).getLink());
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_add1__3)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_add1__3)).getMessage());
    }

    @Test(timeout = 30000)
    public void testGetNotification_add2() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        Assert.notNull(notification);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg15() throws Exception {
        Date __DSPOT_creation_time_0 = new Date(-1780117107, -1918579922, -582027917, -2113184556, -1848848534, -1904675524);
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setCreation_time(__DSPOT_creation_time_0);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg16() throws Exception {
        boolean __DSPOT_email_sent_1 = true;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setEmail_sent(__DSPOT_email_sent_1);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg17() throws Exception {
        String __DSPOT_link_2 = "zH_,y(q2 5[gpbL[{$QV";
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setLink(__DSPOT_link_2);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg18() throws Exception {
        String __DSPOT_message_3 = "5:Wz2[|+mr6#-VtX(r!F";
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setMessage(__DSPOT_message_3);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg19() throws Exception {
        int __DSPOT_notification_id_4 = -1733830533;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setNotification_id(__DSPOT_notification_id_4);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg20() throws Exception {
        boolean __DSPOT_read_5 = true;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setRead(__DSPOT_read_5);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg21() throws Exception {
        int __DSPOT_user_id_6 = -1237778071;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setUser_id(__DSPOT_user_id_6);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotificationnull50() throws Exception {
        String tenandId = null;
        assertNull(tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_literalMutationString4_failAssert0() throws Exception {
        try {
            String tenandId = "";
            int notificationId = 3342;
            Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(notification);
            org.junit.Assert.fail("testGetNotification_literalMutationString4 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotification_literalMutationString5_failAssert0() throws Exception {
        try {
            String tenandId = "supersede.es.atos.net:5676";
            int notificationId = 3342;
            Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(notification);
            org.junit.Assert.fail("testGetNotification_literalMutationString5 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotification_literalMutationString9_failAssert0() throws Exception {
        try {
            String tenandId = "a}tos";
            int notificationId = 3342;
            Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(notification);
            org.junit.Assert.fail("testGetNotification_literalMutationString9 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotificationlitNum33_failAssert0() throws Exception {
        try {
            String tenandId = "atos";
            int notificationId = Integer.MIN_VALUE;
            Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(notification);
            org.junit.Assert.fail("testGetNotificationlitNum33 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotificationlitString43_failAssert0() throws Exception {
        try {
            String tenandId = ":";
            int notificationId = 3342;
            Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(notification);
            org.junit.Assert.fail("testGetNotificationlitString43 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg16null892() throws Exception {
        boolean __DSPOT_email_sent_1 = true;
        String tenandId = null;
        assertNull(tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setEmail_sent(__DSPOT_email_sent_1);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_add1_add816() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_add1__3 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        o_testGetNotification_add1__3.getNotification_id();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg15_mg815() throws Exception {
        boolean __DSPOT_email_sent_94 = false;
        Date __DSPOT_creation_time_0 = new Date(-1780117107, -1918579922, -582027917, -2113184556, -1848848534, -1904675524);
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setCreation_time(__DSPOT_creation_time_0);
        notification.setEmail_sent(__DSPOT_email_sent_94);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg21_mg462() throws Exception {
        boolean __DSPOT_email_sent_52 = true;
        int __DSPOT_user_id_6 = -1237778071;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setUser_id(__DSPOT_user_id_6);
        notification.setEmail_sent(__DSPOT_email_sent_52);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg20null898() throws Exception {
        boolean __DSPOT_read_5 = true;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(null, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setRead(__DSPOT_read_5);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg17null1020() throws Exception {
        String __DSPOT_link_2 = "zH_,y(q2 5[gpbL[{$QV";
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(null, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setLink(__DSPOT_link_2);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_add1_add450() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_add1__3 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        o_testGetNotification_add1__3.isRead();
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg17_mg609() throws Exception {
        int __DSPOT_user_id_92 = 800627653;
        String __DSPOT_link_2 = "zH_,y(q2 5[gpbL[{$QV";
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setLink(__DSPOT_link_2);
        notification.setUser_id(__DSPOT_user_id_92);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg15_add243() throws Exception {
        Date __DSPOT_creation_time_0 = new Date(-1780117107, -1918579922, -582027917, -2113184556, -1848848534, -1904675524);
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_mg15_add243__5 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        assertFalse(((Notification) (o_testGetNotification_mg15_add243__5)).isEmail_sent());
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg15_add243__5)).getUser_id())));
        assertFalse(((Notification) (o_testGetNotification_mg15_add243__5)).isRead());
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg15_add243__5)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg15_add243__5)).getLink());
        assertNull(((Notification) (o_testGetNotification_mg15_add243__5)).getMessage());
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setCreation_time(__DSPOT_creation_time_0);
        assertEquals("atos", tenandId);
        assertFalse(((Notification) (o_testGetNotification_mg15_add243__5)).isEmail_sent());
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg15_add243__5)).getUser_id())));
        assertFalse(((Notification) (o_testGetNotification_mg15_add243__5)).isRead());
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg15_add243__5)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg15_add243__5)).getLink());
        assertNull(((Notification) (o_testGetNotification_mg15_add243__5)).getMessage());
    }

    @Test(timeout = 30000)
    public void testGetNotification_add1_add792() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_add1__3 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        o_testGetNotification_add1__3.getLink();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg21_mg502() throws Exception {
        int __DSPOT_notification_id_63 = -1916813367;
        int __DSPOT_user_id_6 = -1237778071;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setUser_id(__DSPOT_user_id_6);
        notification.setNotification_id(__DSPOT_notification_id_63);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg20_mg524() throws Exception {
        int __DSPOT_user_id_71 = 99366260;
        boolean __DSPOT_read_5 = true;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setRead(__DSPOT_read_5);
        notification.setUser_id(__DSPOT_user_id_71);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotificationnull50_mg314() throws Exception {
        String __DSPOT_message_10 = "}t>?]?7gchsEp#5_w)+K";
        String tenandId = null;
        assertNull(tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setMessage(__DSPOT_message_10);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_add1_add836() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_add1__3 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        o_testGetNotification_add1__3.getMessage();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg16_mg389() throws Exception {
        String __DSPOT_link_24 = "O[*WW4JN-$nw<}7EGpwm";
        boolean __DSPOT_email_sent_1 = true;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setEmail_sent(__DSPOT_email_sent_1);
        notification.setLink(__DSPOT_link_24);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg16_mg435() throws Exception {
        boolean __DSPOT_read_39 = false;
        boolean __DSPOT_email_sent_1 = true;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setEmail_sent(__DSPOT_email_sent_1);
        notification.setRead(__DSPOT_read_39);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg21null940() throws Exception {
        int __DSPOT_user_id_6 = -1237778071;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(null, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setUser_id(__DSPOT_user_id_6);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg18_add221() throws Exception {
        String __DSPOT_message_3 = "5:Wz2[|+mr6#-VtX(r!F";
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_mg18_add221__4 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        assertFalse(((Notification) (o_testGetNotification_mg18_add221__4)).isEmail_sent());
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg18_add221__4)).getUser_id())));
        assertFalse(((Notification) (o_testGetNotification_mg18_add221__4)).isRead());
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg18_add221__4)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg18_add221__4)).getLink());
        assertNull(((Notification) (o_testGetNotification_mg18_add221__4)).getMessage());
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setMessage(__DSPOT_message_3);
        assertEquals("atos", tenandId);
        assertFalse(((Notification) (o_testGetNotification_mg18_add221__4)).isEmail_sent());
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg18_add221__4)).getUser_id())));
        assertFalse(((Notification) (o_testGetNotification_mg18_add221__4)).isRead());
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg18_add221__4)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg18_add221__4)).getLink());
        assertNull(((Notification) (o_testGetNotification_mg18_add221__4)).getMessage());
    }

    @Test(timeout = 30000)
    public void testGetNotificationlitNum33_failAssert0null800_failAssert0() throws Exception {
        try {
            {
                String tenandId = "atos";
                int notificationId = Integer.MIN_VALUE;
                Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(null, notificationId, FEDataStoreProxyTest_Ampl4.token);
                Assert.notNull(notification);
                org.junit.Assert.fail("testGetNotificationlitNum33 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetNotificationlitNum33_failAssert0null800 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg15_mg815_mg2441() throws Exception {
        String __DSPOT_link_240 = "lSSUhwIbR]FMwAeMp&sZ";
        boolean __DSPOT_email_sent_94 = false;
        Date __DSPOT_creation_time_0 = new Date(-1780117107, -1918579922, -582027917, -2113184556, -1848848534, -1904675524);
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setCreation_time(__DSPOT_creation_time_0);
        notification.setEmail_sent(__DSPOT_email_sent_94);
        notification.setLink(__DSPOT_link_240);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg20_literalMutationString354_mg1777() throws Exception {
        Date __DSPOT_creation_time_114 = new Date(1756234953, -1046351086, 2037508841, -771485774, 773695503, 948657429);
        boolean __DSPOT_read_5 = true;
        String tenandId = "a7tos";
        assertEquals("a7tos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setRead(__DSPOT_read_5);
        notification.setCreation_time(__DSPOT_creation_time_114);
        assertEquals("a7tos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg16_mg389null3491() throws Exception {
        String __DSPOT_link_24 = "O[*WW4JN-$nw<}7EGpwm";
        boolean __DSPOT_email_sent_1 = true;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(null, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setEmail_sent(__DSPOT_email_sent_1);
        notification.setLink(__DSPOT_link_24);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg20null898_mg3454() throws Exception {
        int __DSPOT_user_id_370 = -318506384;
        boolean __DSPOT_read_5 = true;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(null, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setRead(__DSPOT_read_5);
        notification.setUser_id(__DSPOT_user_id_370);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg15_mg815_add1684() throws Exception {
        boolean __DSPOT_email_sent_94 = false;
        Date __DSPOT_creation_time_0 = new Date(-1780117107, -1918579922, -582027917, -2113184556, -1848848534, -1904675524);
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_mg15_mg815_add1684__6 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg15_mg815_add1684__6)).getUser_id())));
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg15_mg815_add1684__6)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg15_mg815_add1684__6)).getLink());
        assertFalse(((Notification) (o_testGetNotification_mg15_mg815_add1684__6)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotification_mg15_mg815_add1684__6)).isRead());
        assertNull(((Notification) (o_testGetNotification_mg15_mg815_add1684__6)).getMessage());
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setCreation_time(__DSPOT_creation_time_0);
        notification.setEmail_sent(__DSPOT_email_sent_94);
        assertEquals("atos", tenandId);
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg15_mg815_add1684__6)).getUser_id())));
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg15_mg815_add1684__6)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg15_mg815_add1684__6)).getLink());
        assertFalse(((Notification) (o_testGetNotification_mg15_mg815_add1684__6)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotification_mg15_mg815_add1684__6)).isRead());
        assertNull(((Notification) (o_testGetNotification_mg15_mg815_add1684__6)).getMessage());
    }

    @Test(timeout = 30000)
    public void testGetNotification_add1_add816_mg2521() throws Exception {
        Date __DSPOT_creation_time_267 = new Date();
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_add1__3 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        o_testGetNotification_add1__3.getNotification_id();
        notification.setCreation_time(__DSPOT_creation_time_267);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_add1_add836_mg2616() throws Exception {
        String __DSPOT_message_271 = "JsW!Y].@Jb;/G&QEu:@H";
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_add1__3 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        o_testGetNotification_add1__3.getMessage();
        notification.setMessage(__DSPOT_message_271);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg17_mg609_add2708() throws Exception {
        int __DSPOT_user_id_92 = 800627653;
        String __DSPOT_link_2 = "zH_,y(q2 5[gpbL[{$QV";
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_mg17_mg609_add2708__5 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg17_mg609_add2708__5)).getUser_id())));
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg17_mg609_add2708__5)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg17_mg609_add2708__5)).getLink());
        assertFalse(((Notification) (o_testGetNotification_mg17_mg609_add2708__5)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotification_mg17_mg609_add2708__5)).isRead());
        assertNull(((Notification) (o_testGetNotification_mg17_mg609_add2708__5)).getMessage());
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setLink(__DSPOT_link_2);
        notification.setUser_id(__DSPOT_user_id_92);
        assertEquals("atos", tenandId);
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg17_mg609_add2708__5)).getUser_id())));
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg17_mg609_add2708__5)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg17_mg609_add2708__5)).getLink());
        assertFalse(((Notification) (o_testGetNotification_mg17_mg609_add2708__5)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotification_mg17_mg609_add2708__5)).isRead());
        assertNull(((Notification) (o_testGetNotification_mg17_mg609_add2708__5)).getMessage());
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg15_add243_add2147() throws Exception {
        Date __DSPOT_creation_time_0 = new Date(-1780117107, -1918579922, -582027917, -2113184556, -1848848534, -1904675524);
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_mg15_add243__5 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setCreation_time(__DSPOT_creation_time_0);
        o_testGetNotification_mg15_add243__5.isEmail_sent();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_add1_add836_mg2372() throws Exception {
        int __DSPOT_notification_id_213 = -1487943462;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_add1__3 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        o_testGetNotification_add1__3.getMessage();
        o_testGetNotification_add1__3.setNotification_id(__DSPOT_notification_id_213);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotificationnull50_literalMutationNumber217_add1711() throws Exception {
        String tenandId = null;
        assertNull(tenandId);
        int notificationId = 3343;
        Notification o_testGetNotificationnull50_literalMutationNumber217_add1711__4 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        assertEquals(0, ((int) (((Notification) (o_testGetNotificationnull50_literalMutationNumber217_add1711__4)).getUser_id())));
        assertEquals(0, ((int) (((Notification) (o_testGetNotificationnull50_literalMutationNumber217_add1711__4)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotificationnull50_literalMutationNumber217_add1711__4)).getLink());
        assertFalse(((Notification) (o_testGetNotificationnull50_literalMutationNumber217_add1711__4)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotificationnull50_literalMutationNumber217_add1711__4)).isRead());
        assertNull(((Notification) (o_testGetNotificationnull50_literalMutationNumber217_add1711__4)).getMessage());
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        assertNull(tenandId);
        assertEquals(0, ((int) (((Notification) (o_testGetNotificationnull50_literalMutationNumber217_add1711__4)).getUser_id())));
        assertEquals(0, ((int) (((Notification) (o_testGetNotificationnull50_literalMutationNumber217_add1711__4)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotificationnull50_literalMutationNumber217_add1711__4)).getLink());
        assertFalse(((Notification) (o_testGetNotificationnull50_literalMutationNumber217_add1711__4)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotificationnull50_literalMutationNumber217_add1711__4)).isRead());
        assertNull(((Notification) (o_testGetNotificationnull50_literalMutationNumber217_add1711__4)).getMessage());
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg17null1020_add1724() throws Exception {
        String __DSPOT_link_2 = "zH_,y(q2 5[gpbL[{$QV";
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_mg17null1020_add1724__4 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(null, notificationId, FEDataStoreProxyTest_Ampl4.token);
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg17null1020_add1724__4)).getUser_id())));
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg17null1020_add1724__4)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg17null1020_add1724__4)).getLink());
        assertFalse(((Notification) (o_testGetNotification_mg17null1020_add1724__4)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotification_mg17null1020_add1724__4)).isRead());
        assertNull(((Notification) (o_testGetNotification_mg17null1020_add1724__4)).getMessage());
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(null, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setLink(__DSPOT_link_2);
        assertEquals("atos", tenandId);
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg17null1020_add1724__4)).getUser_id())));
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg17null1020_add1724__4)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg17null1020_add1724__4)).getLink());
        assertFalse(((Notification) (o_testGetNotification_mg17null1020_add1724__4)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotification_mg17null1020_add1724__4)).isRead());
        assertNull(((Notification) (o_testGetNotification_mg17null1020_add1724__4)).getMessage());
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg16_mg435_add2545() throws Exception {
        boolean __DSPOT_read_39 = false;
        boolean __DSPOT_email_sent_1 = true;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_mg16_mg435_add2545__5 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg16_mg435_add2545__5)).getUser_id())));
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg16_mg435_add2545__5)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg16_mg435_add2545__5)).getLink());
        assertFalse(((Notification) (o_testGetNotification_mg16_mg435_add2545__5)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotification_mg16_mg435_add2545__5)).isRead());
        assertNull(((Notification) (o_testGetNotification_mg16_mg435_add2545__5)).getMessage());
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setEmail_sent(__DSPOT_email_sent_1);
        notification.setRead(__DSPOT_read_39);
        assertEquals("atos", tenandId);
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg16_mg435_add2545__5)).getUser_id())));
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg16_mg435_add2545__5)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg16_mg435_add2545__5)).getLink());
        assertFalse(((Notification) (o_testGetNotification_mg16_mg435_add2545__5)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotification_mg16_mg435_add2545__5)).isRead());
        assertNull(((Notification) (o_testGetNotification_mg16_mg435_add2545__5)).getMessage());
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg19litNum919_add1663() throws Exception {
        int __DSPOT_notification_id_4 = 2058659172;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_mg19litNum919_add1663__4 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg19litNum919_add1663__4)).getUser_id())));
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg19litNum919_add1663__4)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg19litNum919_add1663__4)).getLink());
        assertFalse(((Notification) (o_testGetNotification_mg19litNum919_add1663__4)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotification_mg19litNum919_add1663__4)).isRead());
        assertNull(((Notification) (o_testGetNotification_mg19litNum919_add1663__4)).getMessage());
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setNotification_id(__DSPOT_notification_id_4);
        assertEquals("atos", tenandId);
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg19litNum919_add1663__4)).getUser_id())));
        assertEquals(0, ((int) (((Notification) (o_testGetNotification_mg19litNum919_add1663__4)).getNotification_id())));
        assertNull(((Notification) (o_testGetNotification_mg19litNum919_add1663__4)).getLink());
        assertFalse(((Notification) (o_testGetNotification_mg19litNum919_add1663__4)).isEmail_sent());
        assertFalse(((Notification) (o_testGetNotification_mg19litNum919_add1663__4)).isRead());
        assertNull(((Notification) (o_testGetNotification_mg19litNum919_add1663__4)).getMessage());
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg15litNum978litNum3418() throws Exception {
        Date __DSPOT_creation_time_0 = new Date(-1780117107, 1839626791, Integer.MAX_VALUE, -2113184556, -1848848534, -1904675524);
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setCreation_time(__DSPOT_creation_time_0);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg18_add221_mg3310() throws Exception {
        int __DSPOT_user_id_350 = -1400890106;
        String __DSPOT_message_3 = "5:Wz2[|+mr6#-VtX(r!F";
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_mg18_add221__4 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setMessage(__DSPOT_message_3);
        notification.setUser_id(__DSPOT_user_id_350);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg16null892_mg1938() throws Exception {
        String __DSPOT_message_140 = "*#qYoA($d%nuEff!%1UO";
        boolean __DSPOT_email_sent_1 = true;
        String tenandId = null;
        assertNull(tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setEmail_sent(__DSPOT_email_sent_1);
        notification.setMessage(__DSPOT_message_140);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_add1_add792_mg2090() throws Exception {
        Date __DSPOT_creation_time_167 = new Date(36448589, -2116977430, 310636155);
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_add1__3 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        o_testGetNotification_add1__3.getLink();
        o_testGetNotification_add1__3.setCreation_time(__DSPOT_creation_time_167);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg21_mg502null3287() throws Exception {
        int __DSPOT_notification_id_63 = -1916813367;
        int __DSPOT_user_id_6 = -1237778071;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(null, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setUser_id(__DSPOT_user_id_6);
        notification.setNotification_id(__DSPOT_notification_id_63);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_mg17_mg609_mg3117() throws Exception {
        Date __DSPOT_creation_time_318 = new Date();
        int __DSPOT_user_id_92 = 800627653;
        String __DSPOT_link_2 = "zH_,y(q2 5[gpbL[{$QV";
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        notification.setLink(__DSPOT_link_2);
        notification.setUser_id(__DSPOT_user_id_92);
        notification.setCreation_time(__DSPOT_creation_time_318);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetNotification_add1_add816_mg2394() throws Exception {
        boolean __DSPOT_read_223 = true;
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int notificationId = 3342;
        Notification o_testGetNotification_add1__3 = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Notification notification = FEDataStoreProxyTest_Ampl4.proxy.getNotification(tenandId, notificationId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(notification);
        o_testGetNotification_add1__3.getNotification_id();
        o_testGetNotification_add1__3.setRead(__DSPOT_read_223);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfiles_add7886() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<Profile> o_testGetProfiles_add7886__2 = FEDataStoreProxyTest_Ampl4.proxy.getProfiles(tenandId, FEDataStoreProxyTest_Ampl4.token);
        assertFalse(o_testGetProfiles_add7886__2.isEmpty());
        List<Profile> profiles = FEDataStoreProxyTest_Ampl4.proxy.getProfiles(tenandId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notEmpty(profiles);
        assertEquals("atos", tenandId);
        assertFalse(o_testGetProfiles_add7886__2.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetProfiles_literalMutationString7889_failAssert0() throws Exception {
        try {
            String tenandId = "";
            List<Profile> profiles = FEDataStoreProxyTest_Ampl4.proxy.getProfiles(tenandId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(profiles);
            org.junit.Assert.fail("testGetProfiles_literalMutationString7889 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfiles_literalMutationString7890_failAssert0() throws Exception {
        try {
            String tenandId = "supersede.es.atos.net:5676";
            List<Profile> profiles = FEDataStoreProxyTest_Ampl4.proxy.getProfiles(tenandId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(profiles);
            org.junit.Assert.fail("testGetProfiles_literalMutationString7890 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfiles_literalMutationString7891_failAssert0() throws Exception {
        try {
            String tenandId = "&[&$";
            List<Profile> profiles = FEDataStoreProxyTest_Ampl4.proxy.getProfiles(tenandId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(profiles);
            org.junit.Assert.fail("testGetProfiles_literalMutationString7891 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfileslitString7904_failAssert0() throws Exception {
        try {
            String tenandId = "abos";
            List<Profile> profiles = FEDataStoreProxyTest_Ampl4.proxy.getProfiles(tenandId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(profiles);
            org.junit.Assert.fail("testGetProfileslitString7904 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfilesnull7911_failAssert0() throws Exception {
        try {
            String tenandId = null;
            List<Profile> profiles = FEDataStoreProxyTest_Ampl4.proxy.getProfiles(tenandId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(profiles);
            org.junit.Assert.fail("testGetProfilesnull7911 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfiles_add7886null8093() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        List<Profile> o_testGetProfiles_add7886__2 = FEDataStoreProxyTest_Ampl4.proxy.getProfiles(null, FEDataStoreProxyTest_Ampl4.token);
        List<Profile> profiles = FEDataStoreProxyTest_Ampl4.proxy.getProfiles(tenandId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notEmpty(profiles);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfiles_add7886null8093_literalMutationString8388_failAssert0() throws Exception {
        try {
            String tenandId = "";
            List<Profile> o_testGetProfiles_add7886__2 = FEDataStoreProxyTest_Ampl4.proxy.getProfiles(null, FEDataStoreProxyTest_Ampl4.token);
            List<Profile> profiles = FEDataStoreProxyTest_Ampl4.proxy.getProfiles(tenandId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notEmpty(profiles);
            org.junit.Assert.fail("testGetProfiles_add7886null8093_literalMutationString8388 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfile_add5467() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = 0;
        Profile o_testGetProfile_add5467__3 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        assertEquals(0, ((int) (((Profile) (o_testGetProfile_add5467__3)).getProfile_id())));
        assertNull(((Profile) (o_testGetProfile_add5467__3)).getLabels());
        assertEquals("ADMIN", ((Profile) (o_testGetProfile_add5467__3)).getName());
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        assertEquals("atos", tenandId);
        assertEquals(0, ((int) (((Profile) (o_testGetProfile_add5467__3)).getProfile_id())));
        assertNull(((Profile) (o_testGetProfile_add5467__3)).getLabels());
        assertEquals("ADMIN", ((Profile) (o_testGetProfile_add5467__3)).getName());
    }

    @Test(timeout = 30000)
    public void testGetProfile_add5468() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = 0;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        Assert.notNull(profile);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_literalMutationString5470() throws Exception {
        String tenandId = "atKos";
        assertEquals("atKos", tenandId);
        int profileId = 0;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        assertEquals("atKos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480() throws Exception {
        List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = 0;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        profile.setLabels(__DSPOT_labels_413);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfilenull5511() throws Exception {
        String tenandId = null;
        assertNull(tenandId);
        int profileId = 0;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_literalMutationString5471_failAssert0() throws Exception {
        try {
            String tenandId = "";
            int profileId = 0;
            Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(profile);
            org.junit.Assert.fail("testGetProfile_literalMutationString5471 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfile_literalMutationString5472_failAssert0() throws Exception {
        try {
            String tenandId = "supersede.es.atos.net:5676";
            int profileId = 0;
            Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(profile);
            org.junit.Assert.fail("testGetProfile_literalMutationString5472 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfile_literalMutationString5474_failAssert0() throws Exception {
        try {
            String tenandId = "|tos";
            int profileId = 0;
            Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(profile);
            org.junit.Assert.fail("testGetProfile_literalMutationString5474 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfilelitNum5494_failAssert0() throws Exception {
        try {
            String tenandId = "atos";
            int profileId = Integer.MIN_VALUE;
            Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(profile);
            org.junit.Assert.fail("testGetProfilelitNum5494 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480_literalMutationNumber5735() throws Exception {
        List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = -1;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        profile.setLabels(__DSPOT_labels_413);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_add5468litString5776() throws Exception {
        String tenandId = "awos";
        assertEquals("awos", tenandId);
        int profileId = 0;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        Assert.notNull(profile);
        assertEquals("awos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480null5987() throws Exception {
        List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
        String tenandId = null;
        assertNull(tenandId);
        int profileId = 0;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        profile.setLabels(__DSPOT_labels_413);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_add5467_add5726() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = 0;
        Profile o_testGetProfile_add5467__3 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        o_testGetProfile_add5467__3.getLabels();
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_add5467_add5786() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = 0;
        Profile o_testGetProfile_add5467__3 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        o_testGetProfile_add5467__3.getName();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_add5467_add5762() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = 0;
        Profile o_testGetProfile_add5467__3 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        o_testGetProfile_add5467__3.getProfile_id();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480_add5648() throws Exception {
        List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = 0;
        Profile o_testGetProfile_mg5480_add5648__6 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        assertNull(((Profile) (o_testGetProfile_mg5480_add5648__6)).getLabels());
        assertEquals(0, ((int) (((Profile) (o_testGetProfile_mg5480_add5648__6)).getProfile_id())));
        assertEquals("ADMIN", ((Profile) (o_testGetProfile_mg5480_add5648__6)).getName());
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        profile.setLabels(__DSPOT_labels_413);
        assertEquals("atos", tenandId);
        assertNull(((Profile) (o_testGetProfile_mg5480_add5648__6)).getLabels());
        assertEquals(0, ((int) (((Profile) (o_testGetProfile_mg5480_add5648__6)).getProfile_id())));
        assertEquals("ADMIN", ((Profile) (o_testGetProfile_mg5480_add5648__6)).getName());
    }

    @Test(timeout = 30000)
    public void testGetProfile_add5467_add5745() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = 0;
        Profile o_testGetProfile_add5467__3 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Profile o_testGetProfile_add5467_add5745__6 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        assertNull(((Profile) (o_testGetProfile_add5467_add5745__6)).getLabels());
        assertEquals(0, ((int) (((Profile) (o_testGetProfile_add5467_add5745__6)).getProfile_id())));
        assertEquals("ADMIN", ((Profile) (o_testGetProfile_add5467_add5745__6)).getName());
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        assertEquals("atos", tenandId);
        assertNull(((Profile) (o_testGetProfile_add5467_add5745__6)).getLabels());
        assertEquals(0, ((int) (((Profile) (o_testGetProfile_add5467_add5745__6)).getProfile_id())));
        assertEquals("ADMIN", ((Profile) (o_testGetProfile_add5467_add5745__6)).getName());
    }

    @Test(timeout = 30000)
    public void testGetProfile_literalMutationString5470_add5642() throws Exception {
        String tenandId = "atKos";
        assertEquals("atKos", tenandId);
        int profileId = 0;
        Profile o_testGetProfile_literalMutationString5470_add5642__3 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        assertNull(((Profile) (o_testGetProfile_literalMutationString5470_add5642__3)).getLabels());
        assertEquals(0, ((int) (((Profile) (o_testGetProfile_literalMutationString5470_add5642__3)).getProfile_id())));
        assertNull(((Profile) (o_testGetProfile_literalMutationString5470_add5642__3)).getName());
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        assertEquals("atKos", tenandId);
        assertNull(((Profile) (o_testGetProfile_literalMutationString5470_add5642__3)).getLabels());
        assertEquals(0, ((int) (((Profile) (o_testGetProfile_literalMutationString5470_add5642__3)).getProfile_id())));
        assertNull(((Profile) (o_testGetProfile_literalMutationString5470_add5642__3)).getName());
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480_literalMutationString5719_failAssert0() throws Exception {
        try {
            List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
            String tenandId = "L?9&";
            int profileId = 0;
            Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(profile);
            profile.setLabels(__DSPOT_labels_413);
            org.junit.Assert.fail("testGetProfile_mg5480_literalMutationString5719 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480litString5938_failAssert0() throws Exception {
        try {
            List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
            String tenandId = "\n";
            int profileId = 0;
            Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(profile);
            profile.setLabels(__DSPOT_labels_413);
            org.junit.Assert.fail("testGetProfile_mg5480litString5938 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfilelitNum5494_failAssert0null5974_failAssert0() throws Exception {
        try {
            {
                String tenandId = "atos";
                int profileId = Integer.MIN_VALUE;
                Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(null, profileId, FEDataStoreProxyTest_Ampl4.token);
                Assert.notNull(profile);
                org.junit.Assert.fail("testGetProfilelitNum5494 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetProfilelitNum5494_failAssert0null5974 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480litString5846_failAssert0() throws Exception {
        try {
            List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
            String tenandId = "";
            int profileId = 0;
            Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(profile);
            profile.setLabels(__DSPOT_labels_413);
            org.junit.Assert.fail("testGetProfile_mg5480litString5846 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfile_add5467_add5726litNum7082() throws Exception {
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = Integer.MAX_VALUE;
        Profile o_testGetProfile_add5467__3 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        o_testGetProfile_add5467__3.getLabels();
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_add5467_add5762_literalMutationString6834() throws Exception {
        String tenandId = "ats";
        assertEquals("ats", tenandId);
        int profileId = 0;
        Profile o_testGetProfile_add5467__3 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        o_testGetProfile_add5467__3.getProfile_id();
        assertEquals("ats", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_add5467_add5786litString7075() throws Exception {
        String tenandId = "aos";
        assertEquals("aos", tenandId);
        int profileId = 0;
        Profile o_testGetProfile_add5467__3 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        o_testGetProfile_add5467__3.getName();
        assertEquals("aos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_literalMutationString5470_add5642_mg6663() throws Exception {
        List<Label> __DSPOT_labels_455 = Collections.<Label>emptyList();
        String tenandId = "atKos";
        assertEquals("atKos", tenandId);
        int profileId = 0;
        Profile o_testGetProfile_literalMutationString5470_add5642__3 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        o_testGetProfile_literalMutationString5470_add5642__3.setLabels(__DSPOT_labels_455);
        assertEquals("atKos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480_literalMutationNumber5735null7308() throws Exception {
        List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = -1;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        profile.setLabels(null);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480null5987_mg6792() throws Exception {
        int __DSPOT_profile_id_473 = -1234883504;
        List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
        String tenandId = null;
        assertNull(tenandId);
        int profileId = 0;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        profile.setLabels(__DSPOT_labels_413);
        profile.setProfile_id(__DSPOT_profile_id_473);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_add5468litString5776_mg7006() throws Exception {
        int __DSPOT_profile_id_510 = 496155448;
        String tenandId = "awos";
        assertEquals("awos", tenandId);
        int profileId = 0;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        Assert.notNull(profile);
        profile.setProfile_id(__DSPOT_profile_id_510);
        assertEquals("awos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480_literalMutationNumber5735_mg6994() throws Exception {
        int __DSPOT_profile_id_508 = -922397316;
        List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = -1;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        profile.setLabels(__DSPOT_labels_413);
        profile.setProfile_id(__DSPOT_profile_id_508);
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480_literalMutationNumber5735_add6706() throws Exception {
        List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = -1;
        Profile o_testGetProfile_mg5480_literalMutationNumber5735_add6706__7 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        assertNull(((Profile) (o_testGetProfile_mg5480_literalMutationNumber5735_add6706__7)).getLabels());
        assertEquals(0, ((int) (((Profile) (o_testGetProfile_mg5480_literalMutationNumber5735_add6706__7)).getProfile_id())));
        assertNull(((Profile) (o_testGetProfile_mg5480_literalMutationNumber5735_add6706__7)).getName());
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        profile.setLabels(__DSPOT_labels_413);
        assertEquals("atos", tenandId);
        assertNull(((Profile) (o_testGetProfile_mg5480_literalMutationNumber5735_add6706__7)).getLabels());
        assertEquals(0, ((int) (((Profile) (o_testGetProfile_mg5480_literalMutationNumber5735_add6706__7)).getProfile_id())));
        assertNull(((Profile) (o_testGetProfile_mg5480_literalMutationNumber5735_add6706__7)).getName());
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480_add5648_add7018() throws Exception {
        List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
        String tenandId = "atos";
        assertEquals("atos", tenandId);
        int profileId = 0;
        Profile o_testGetProfile_mg5480_add5648__6 = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        profile.setLabels(__DSPOT_labels_413);
        o_testGetProfile_mg5480_add5648__6.getName();
        assertEquals("atos", tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480null5987_remove6646() throws Exception {
        List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
        String tenandId = null;
        assertNull(tenandId);
        int profileId = 0;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480null5987_mg6768() throws Exception {
        String __DSPOT_name_471 = "-(&+WU``^# ckr:U[5Z_";
        List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
        String tenandId = null;
        assertNull(tenandId);
        int profileId = 0;
        Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
        Assert.notNull(profile);
        profile.setLabels(__DSPOT_labels_413);
        profile.setName(__DSPOT_name_471);
        assertNull(tenandId);
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480null5987litNum6928_failAssert0() throws Exception {
        try {
            List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
            String tenandId = null;
            int profileId = Integer.MIN_VALUE;
            Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
            Assert.notNull(profile);
            profile.setLabels(__DSPOT_labels_413);
            org.junit.Assert.fail("testGetProfile_mg5480null5987litNum6928 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProfile_mg5480_literalMutationString5719_failAssert0litNum6668_failAssert0() throws Exception {
        try {
            {
                List<Label> __DSPOT_labels_413 = Collections.singletonList(new Label());
                String tenandId = "L?9&";
                int profileId = Integer.MIN_VALUE;
                Profile profile = FEDataStoreProxyTest_Ampl4.proxy.getProfile(tenandId, profileId, FEDataStoreProxyTest_Ampl4.token);
                Assert.notNull(profile);
                profile.setLabels(__DSPOT_labels_413);
                org.junit.Assert.fail("testGetProfile_mg5480_literalMutationString5719 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetProfile_mg5480_literalMutationString5719_failAssert0litNum6668 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }
}

