package eu.supersede.integration.api.datastore.fe.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NotificationsCollection implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Notification> notifications = new ArrayList<>();
	
	public NotificationsCollection (){
		
	}

	public NotificationsCollection (List<Notification> notifications){
		this.notifications = notifications;
	}
	
    /**
     * @return the users
     */
    public List<Notification> getNotifications() {
        return notifications;
    }

    /**
     * @param users the users to set
     */
    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
