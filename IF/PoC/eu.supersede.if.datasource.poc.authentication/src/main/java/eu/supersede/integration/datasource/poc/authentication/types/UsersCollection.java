package eu.supersede.integration.datasource.poc.authentication.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsersCollection implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users = new ArrayList<>();
	
	public UsersCollection (){
		
	}

	public UsersCollection (List<User> users){
		this.users = users;
	}
	
    /**
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
