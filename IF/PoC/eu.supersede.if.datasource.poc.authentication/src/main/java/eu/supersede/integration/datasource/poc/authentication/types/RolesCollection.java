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
package eu.supersede.integration.datasource.poc.authentication.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RolesCollection implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Role> roles = new ArrayList<>();
	
	public RolesCollection (){
		
	}

	public RolesCollection (List<Role> roles){
		this.roles = roles;
	}
	
    /**
     * @return the roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * @param persons the roles to set
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
