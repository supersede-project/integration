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
