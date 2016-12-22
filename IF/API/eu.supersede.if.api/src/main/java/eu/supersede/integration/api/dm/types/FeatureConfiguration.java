package eu.supersede.integration.api.dm.types;

public class FeatureConfiguration {
	private String optimalConfig;
	
	public FeatureConfiguration(){
	}
	
	public FeatureConfiguration(String optimalConfig){
		this.optimalConfig = optimalConfig;
	}

	public String getOptimalConfig() {
		return optimalConfig;
	}

	public void setOptimalConfig(String optimalConfig) {
		this.optimalConfig = optimalConfig;
	}
	
}
