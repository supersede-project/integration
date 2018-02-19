package eu.supersede.integration.api.mdm.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by snadal on 26/01/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CER_Rule implements Serializable{
	
	
    private String cer_ruleID;
	private int windowTime;
	private int windowSize;
	private ActionTypes actionType;
    private String ruleName;
    
    @JsonProperty ("pattern")
    private List<Event> patterns;
    private List<Filter> filters;
    private List<ActionParameter> actionParameters;
    

    public String getCer_ruleID() {
        return cer_ruleID;
    }

    public void setCer_ruleID(String cer_ruleID) {
        this.cer_ruleID = cer_ruleID;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }


    public int getWindowTime() {
        return windowTime;
    }

    public void setWindowTime(int windowTime) {
        this.windowTime = windowTime;
    }

    public int getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(int windowSize) {
        this.windowSize = windowSize;
    }

    public ActionTypes getAction() {
        return actionType;
    }

    public void setAction(ActionTypes actionType) {
        this.actionType = actionType;
    }

	public List<Event> getPatterns() {
		if (this.patterns == null){
			this.patterns = new ArrayList<>();
		}
		return patterns;
	}

	public void setPatterns(List<Event> patterns) {
		this.patterns = patterns;
	}


	public List<Filter> getFilters() {
		if (this.filters == null){
			this.filters = new ArrayList<>();
		}
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	
	public List<ActionParameter> getActionParameters() {
		if (this.actionParameters == null){
			this.actionParameters = new ArrayList<>();
		}
		return actionParameters;
	}

	public void setActionParameters(List<ActionParameter> actionParameters) {
		this.actionParameters = actionParameters;
	}
	
}
