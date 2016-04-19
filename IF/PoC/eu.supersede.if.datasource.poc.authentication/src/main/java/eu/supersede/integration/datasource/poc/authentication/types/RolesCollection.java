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
