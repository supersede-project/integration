package eu.supersede.integration.api.security.types;

import java.util.HashSet;
import java.util.Set;

import org.wso2.carbon.user.core.Permission;

public class Role {
	String roleName;
	Set<User> users = new HashSet<User>();
	Set<Permission> permissions = new HashSet<Permission>();
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	public void setUsers(Set<User> userList) {
		this.users = userList;
	}
	
	public Set<Permission> getPermissions() {
		return permissions;
	}
	
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public void setPermissions(Permission[] permissions) {
		this.permissions.clear();
		for (int i=0;  i<permissions.length; i++){
			this.permissions.add(permissions[i]);
		}
	}

	public static String[] roleNames(Set<Role> roles) {
		String[] roleNames = new String[roles.size()];
		int i = 0;
		for (Role role: roles){
			roleNames[i++] = role.getRoleName();
		}
		return roleNames;
	}	
	
	public static Set<Role> roles(String[] roleNames) {
		Set<Role> roles = new HashSet<Role>(); 
    	for (int i=0; i<roleNames.length; i++){
    		if (roleNames[i].contains("Internal/everyone")) continue; //ignoring internal WSO2 role
    		Role role = new Role();
    		role.setRoleName(roleNames[i]);
    		roles.add(role);
    	}
    	return roles;
	}
	
	@Override
	public boolean equals (Object o){
		if (o instanceof Role){
			return this.roleName.equals(((Role)o).getRoleName());
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return roleName.hashCode();
	}
	
}
