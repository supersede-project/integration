package eu.supersede.integration.api.tenants.test;


import eu.supersede.integration.api.security.IFAccount;
import eu.supersede.integration.api.tenants.IFTenantsManager;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;
import org.wso2.carbon.tenant.mgt.stub.beans.xsd.TenantInfoBean;

import static org.junit.Assert.assertEquals;


public class IFTenantsManagerTest {
    static IFTenantsManager tm;

    @BeforeClass
    public static void setup() throws Exception {
        String admin = IFAccount.getUser();
        String password = IFAccount.getPassword();
        IFTenantsManagerTest.tm = new IFTenantsManager(admin, password);
    }

    @Test(timeout = 30000)
    public void getAllTenantsTest_add4() throws Exception {
        List<TenantInfoBean> tenants = IFTenantsManagerTest.tm.getAllTenants();
        Assert.notEmpty(tenants);
        int o_getAllTenantsTest_add4__4 = tenants.size();
        assertEquals(3, ((int) (o_getAllTenantsTest_add4__4)));
        System.out.println((("Located " + (tenants.size())) + " tenants"));
        assertEquals(3, ((int) (o_getAllTenantsTest_add4__4)));
    }
}

