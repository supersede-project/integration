package eu.supersede.integration.api.security.test;


import eu.supersede.integration.api.security.IFUserStoreManager;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.wso2.carbon.user.core.UserStoreManager;


@Ignore
public class AmplIdentityManagerClientTest {
    private static UserStoreManager usm;

    public static final String CLAIM_FIRST_NAME_URI = "http://wso2.org/claims/givenname";

    public static final String CLAIM_LAST_NAME_URI = "http://wso2.org/claims/lastname";

    public static final String CLAIM_ORGANIZATION_URI = "http://wso2.org/claims/organization";

    public static final String CLAIM_ADDRESS_URI = "http://wso2.org/claims/streetaddress";

    public static final String CLAIM_COUNTRY_URI = "http://wso2.org/claims/country";

    public static final String CLAIM_EMAIL_URI = "http://wso2.org/claims/emailaddress";

    public static final String CLAIM_TELEPHONE_URI = "http://wso2.org/claims/telephone";

    public static final String CLAIM_MOBILE_URI = "http://wso2.org/claims/mobile";

    public static final String CLAIM_IM_URI = "http://wso2.org/claims/im";

    public static final String CLAIM_URL_URI = "http://wso2.org/claims/url";

    private static String admin;

    private static String password;

    @BeforeClass
    public static void setup() throws Exception {
        AmplIdentityManagerClientTest.admin = System.getProperty("is.admin.user");
        AmplIdentityManagerClientTest.password = System.getProperty("is.admin.passwd");
        AmplIdentityManagerClientTest.usm = new IFUserStoreManager(AmplIdentityManagerClientTest.admin, AmplIdentityManagerClientTest.password);
    }
}

