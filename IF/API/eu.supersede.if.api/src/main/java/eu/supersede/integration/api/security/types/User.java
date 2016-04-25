package eu.supersede.integration.api.security.types;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.wso2.carbon.user.core.claim.Claim;

public class User {
	private static final String CLAIM_FIRST_NAME_URI = "http://wso2.org/claims/givenname";
	private static final String CLAIM_LAST_NAME_URI = "http://wso2.org/claims/lastname";
	private static final String CLAIM_ORGANIZATION_URI = "http://wso2.org/claims/organization";
	private static final String CLAIM_ADDRESS_URI = "http://wso2.org/claims/streetaddress";
	private static final String CLAIM_COUNTRY_URI = "http://wso2.org/claims/country";
	private static final String CLAIM_EMAIL_URI = "http://wso2.org/claims/emailaddress";
	private static final String CLAIM_TELEPHONE_URI = "http://wso2.org/claims/telephone";
	private static final String CLAIM_MOBILE_URI = "http://wso2.org/claims/mobile";
	private static final String CLAIM_IM_URI = "http://wso2.org/claims/im";
	private static final String CLAIM_URL_URI = "http://wso2.org/claims/url";
	
	//Claims are use to add user metadata
	private Map<String, String> claims = new HashMap<String, String>();

	private Set<Role> roles = new HashSet<Role>();
	private String userName;
	
	public Map<String, String> getClaims() {
		return claims;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getFirstname() {
		return claims.get(CLAIM_FIRST_NAME_URI);
	}
	
	public void setFirstname(String firstname) {
		claims.put(CLAIM_FIRST_NAME_URI, firstname);
	}
	
	public String getLastname() {
		return claims.get(CLAIM_LAST_NAME_URI);
	}
	
	public void setLastname(String lastname) {
		claims.put(CLAIM_LAST_NAME_URI, lastname);
	}
	
	public String getOrganization() {
		return claims.get(CLAIM_ORGANIZATION_URI);
	}
	
	public void setOrganization(String organization) {
		claims.put(CLAIM_ORGANIZATION_URI, organization);
	}
	
	public String getAddress() {
		return claims.get(CLAIM_ADDRESS_URI);
	}
	
	public void setAddress(String address) {
		claims.put(CLAIM_ADDRESS_URI, address);
	}
	
	public String getCountry() {
		return claims.get(CLAIM_COUNTRY_URI);
	}
	
	public void setCountry(String country) {
		claims.put(CLAIM_COUNTRY_URI, country);
	}
	
	public String getEmail() {
		return claims.get(CLAIM_EMAIL_URI);
	}
	public void setEmail(String email) {
		claims.put(CLAIM_EMAIL_URI, email);
	}
	
	public String getTelephone() {
		return claims.get(CLAIM_TELEPHONE_URI);
	}
	
	public void setTelephone(String telephone) {
		claims.put(CLAIM_TELEPHONE_URI, telephone);
	}
	
	public String getMobile() {
		return claims.get(CLAIM_MOBILE_URI);
	}
	
	public void setMobile(String mobile) {
		claims.put(CLAIM_MOBILE_URI, mobile);
	}
	
	public String getIm() {
		return claims.get(CLAIM_IM_URI);
	}
	
	public void setIm(String im) {
		claims.put(CLAIM_IM_URI, im);
	}
	
	public URL getUrl() {
		URL url = null;
		try {
			url = new URL (claims.get(CLAIM_URL_URI));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	public void setUrl(URL url) {
		claims.put(CLAIM_URL_URI, url.toString());
	}

	public void readClaims(Claim[] _claims) throws MalformedURLException {
		claims = new HashMap<String, String>();
		for (int i=0; i<_claims.length; i++){
			System.out.println("URI: " + _claims[i].getClaimUri());
			System.out.println("VALUE: " + _claims[i].getValue());
			switch (_claims[i].getClaimUri()){
			case "phone_number":
			case "http://wso2.org/claims/telephone":
				setTelephone(_claims[i].getValue());
				break;
			case "urn:scim:schemas:core:1.0:ims":
			case "http://wso2.org/claims/im":
				setIm(_claims[i].getValue());
				break;
			case "http://wso2.org/claims/mobile":
			case "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/mobile":
			case "urn:scim:schemas:core:1.0:phoneNumbers.mobile":
				setMobile(_claims[i].getValue());
				break;
			case "http://axschema.org/contact/country/home":
			case "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/country":
			case "country":
			case "http://wso2.org/claims/country":
			case "urn:scim:schemas:core:1.0:addresses.country":
				setCountry(_claims[i].getValue());
				break;
			case "http://wso2.org/claims/streetaddress":
			case "urn:scim:schemas:core:1.0:addresses.streetAddress":
			case "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/streetaddress":
				setAddress(_claims[i].getValue());
				break;
			case "family_name":
			case "urn:scim:schemas:core:1.0:name.familyName":
			case "http://axschema.org/namePerson/last":
			case "http://wso2.org/claims/lastname":
			case "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/surname":
				setLastname(_claims[i].getValue());
				break;
			case "http://wso2.org/claims/url":
			case "urn:scim:schemas:core:1.0:profileUrl":
			case "website":
			case "profile":
				setUrl(new URL(_claims[i].getValue()));
				break;
			case "http://wso2.org/claims/givenname":
			case "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/givenname":
			case "urn:scim:schemas:core:1.0:name.givenName":
				setFirstname(_claims[i].getValue());
				break;
			case "urn:scim:schemas:core:1.0:emails":
			case "email":
			case "http://axschema.org/contact/email":
			case "http://wso2.org/claims/emailaddress":
			case "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/emailaddress":
				setEmail(_claims[i].getValue());
				break;
			case "http://wso2.org/claims/organization":
				setOrganization(_claims[i].getValue());
				break;
				
			}
//			claims.put(_claims[i].getClaimUri(), _claims[i].getValue());
		}
	}

	public static String[] userNames(Set<User> users) {
		String[] userNames = new String[users.size()];
		int i = 0;
		for (User user: users){
			userNames[i++] = user.getUserName();
		}
		return userNames;
	}

	public static Set<User> users(String[] userNames) {
		Set<User> users = new HashSet<User>(); 
		if (userNames != null){
			for (int i=0; i<userNames.length; i++){
				User user = new User();
				user.setUserName(userNames[i]);
				users.add(user);
			}
		}
    	return users;
	}
	
	@Override
	public boolean equals (Object o){
		if (o instanceof User){
			return this.userName.equals(((User)o).getUserName());
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return userName.hashCode();
	}

}
