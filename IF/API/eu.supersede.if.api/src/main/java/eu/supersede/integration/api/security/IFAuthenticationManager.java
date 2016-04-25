package eu.supersede.integration.api.security;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.wso2.carbon.user.core.Permission;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.claim.Claim;

import eu.supersede.integration.api.security.types.Role;
import eu.supersede.integration.api.security.types.User;

public class IFAuthenticationManager {
	private IFUserStoreManager usm = new IFUserStoreManager();
	
	//User Authentication
	public boolean authenticateUser(String userName, String credential) throws UserStoreException{
		return usm.authenticate(userName, credential);
	}
	
	//User CRUD operations
	
	public void addUser (User user, String credential, boolean requirePasswordChange) throws UserStoreException{
		Assert.assertNotNull(user.getUserName());
		Assert.assertNotNull(credential);
		Assert.assertTrue(!user.getUserName().isEmpty());
		Assert.assertTrue(!credential.isEmpty());
		String[] profiles = usm.getAllProfileNames();
		Assert.assertNotNull(profiles);
		Assert.assertTrue (profiles.length>0);
		String[] roleNames = new String[user.getRoles().size()];
		int i = 0;
		for (Role role: user.getRoles()){
			roleNames[i++] = role.getRoleName();
		}
		
		usm.addUser(user.getUserName(), credential, roleNames, user.getClaims(), profiles[0], requirePasswordChange);
	}
	
	public User getUser(String userName) throws UserStoreException, MalformedURLException{
		Assert.assertNotNull(userName);
		Assert.assertTrue(!userName.isEmpty());
		User user = new User();
		user.setUserName(userName);
		String[] profiles = usm.getAllProfileNames();
		Assert.assertNotNull(profiles);
		Assert.assertTrue (profiles.length>0);
		Claim[] claims = usm.getUserClaimValues(userName, profiles[0]);
		user.readClaims(claims);
		Set<Role> roles = getAllRolesOfUser(user);
		user.setRoles(roles);
		
		return user;
	}
	
	public List<User> getAllUsersForRole(Role role) throws UserStoreException, MalformedURLException{
		Assert.assertNotNull(role);
		Assert.assertNotNull(role.getRoleName());
		Assert.assertTrue(!role.getRoleName().isEmpty());
		String[] userNames = usm.getUserListOfRole(role.getRoleName());
		List<User> users = new ArrayList<User>();
		for (int i=0; i<userNames.length; i++){
			users.add (getUser(userNames[i]));
		}
		return users;
	}
	
	public void updateUserCredential(User user, String newCredential, String oldCredential) throws UserStoreException{
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getUserName());
		Assert.assertTrue(!user.getUserName().isEmpty());
		usm.updateCredential(user.getUserName(), newCredential, oldCredential);
	}
	
	public void updateUser(User user) throws UserStoreException, MalformedURLException{
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getUserName());
		Assert.assertTrue(!user.getUserName().isEmpty());
		User oldUser = getUser(user.getUserName());
		Assert.assertNotNull(oldUser);
		
		Set<Role> rolesInNewUser = user.getRoles();
		Set<Role> rolesInOldUser = oldUser.getRoles();
		
		Set<Role> rolesToAdd = new HashSet<> (rolesInNewUser); 
		rolesToAdd.removeAll(rolesInOldUser);
		Set<Role> rolesToRemove = new HashSet<> (rolesInOldUser);
		rolesToRemove.removeAll(rolesInNewUser);
		
		//updating roles
		usm.updateRoleListOfUser(user.getUserName(), Role.roleNames(rolesToRemove), Role.roleNames(rolesToAdd));
		
		//Updating user profile
		String[] profiles = usm.getProfileNames(user.getUserName());
		Assert.assertNotNull(profiles);
		Assert.assertTrue (profiles.length>0);
		usm.setUserClaimValues(user.getUserName(), user.getClaims(), profiles[0]);
	}
	
	public void deleteUser (User user) throws UserStoreException{
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getUserName());
		Assert.assertTrue(!user.getUserName().isEmpty());
		usm.deleteUser(user.getUserName());
	}
	
	//Role CRUD operations
	public Set<Role> getAllRoles() throws UserStoreException{
		String[] roleNames = usm.getRoleNames();
    	Assert.assertNotNull(roleNames);
    	return Role.roles(roleNames);
	}
	
	public Set<Role> getAllRolesOfUser(User user) throws UserStoreException{
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getUserName());
		Assert.assertTrue(!user.getUserName().isEmpty());
		String[] roleNames = usm.getRoleListOfUser(user.getUserName());
    	Assert.assertNotNull(roleNames);
    	return Role.roles(roleNames);
	}
	
	public void addRole (Role role) throws UserStoreException{
		Assert.assertNotNull(role);
		Assert.assertNotNull(role.getRoleName());
		Assert.assertTrue(!role.getRoleName().isEmpty());
    	String[] userList = User.userNames (role.getUsers());
		usm.addRole(role.getRoleName(), userList, role.getPermissions().toArray(new Permission[]{}));
	}
	
	public void updateRole (Role role, String oldRoleName) throws UserStoreException{
		Assert.assertNotNull(role);
		Assert.assertNotNull(role.getRoleName());
		Assert.assertTrue(!role.getRoleName().isEmpty());
		// Role name
		usm.updateRoleName(oldRoleName, role.getRoleName());
		
		Set<User> usersInNewRole = role.getUsers();
		Set<User> usersInOldRole = User.users(usm.getUserListOfRole(oldRoleName));
		
		Set<User> usersToAdd = new HashSet<> (usersInNewRole); 
		usersToAdd.removeAll(usersInOldRole);
		Set<User> usersToRemove = new HashSet<> (usersInOldRole);
		usersToRemove.removeAll(usersInNewRole);
		
		//Role Users
		usm.updateUserListOfRole(role.getRoleName(), User.userNames(usersToRemove), User.userNames(usersToAdd));
		
		//Role permissions
		//The stub does not allow to change permissions
	}
	
	public void deleteRole (Role role) throws UserStoreException{
		Assert.assertNotNull(role);
		Assert.assertNotNull(role.getRoleName());
		Assert.assertTrue(!role.getRoleName().isEmpty());
		usm.deleteRole(role.getRoleName());
	}
}
