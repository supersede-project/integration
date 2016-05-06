package eu.supersede.integration.api.datastore.fe.types;

import java.util.ArrayList;
import java.util.List;

public class LabelsCollection {
	private static final long serialVersionUID = 1L;
	private List<Label> labels = new ArrayList<>();
	
	public LabelsCollection (){
		
	}

	public LabelsCollection (List<Label> labels){
		this.labels = labels;
	}
	
    /**
     * @return the users
     */
    public List<Label> getLabels() {
        return labels;
    }

    /**
     * @param users the users to set
     */
    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
