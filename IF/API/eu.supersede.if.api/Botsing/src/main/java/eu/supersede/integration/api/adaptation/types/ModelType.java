package eu.supersede.integration.api.adaptation.types;

public enum ModelType {
	AdaptabilityModel ("AdaptabilityModel", AdaptabilityModel.class, AdaptabilityModel[].class, ".aspect"),
	BaseModel ("BaseModel", BaseModel.class, BaseModel[].class, ".uml"),
	FeatureConfiguration ("FeatureConfiguration", FeatureConfiguration.class, FeatureConfiguration[].class, ".yafc"),
	FeatureModel ("FeatureModel", FeatureModel.class, FeatureModel[].class, ".yafm"),
	PatternModel ("PatternModel", PatternModel.class, PatternModel[].class, ".vql"),
	ProfileModel ("ProfileModel", ProfileModel.class, ProfileModel[].class, "uml"),
	VariantModel ("VariantModel", VariantModel.class, VariantModel[].class, "uml");
	
	String type;
	Class<?> typeClass;
	Class<?> typeArrayClass;
	String extension;
	
	<T> ModelType(String type, Class<T> typeClass, Class<T[]> typeArrayClass, String extension){
		this.type = type;
		this.typeClass = typeClass;
		this.typeArrayClass = typeArrayClass;
		this.extension = extension;
	}
	
	@Override
	public String toString(){
		return type;
	}
	
	public String getType(){
		return type;
	}
	
	public <T> Class<?> getTypeArrayClass(){
		return typeArrayClass;
	}
	
	public <T> Class<?> getTypeClass(){
		return typeClass;
	}
	
	public String getExtension(){
		return extension;
	}
}
