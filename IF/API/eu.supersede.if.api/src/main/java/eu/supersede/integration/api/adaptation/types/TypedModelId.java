package eu.supersede.integration.api.adaptation.types;


public class TypedModelId implements ITypedModelId {
	
	private String number;
	private ModelType modelType;
	
	public TypedModelId(){
		
	}
	
	public TypedModelId(ModelType modelType, String number) {
		this.number = number;
		this.modelType = modelType;
	}

	@Override
	public int compareTo(IModelId  modelId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNumber() {
		return number;
	}

	@Override
	public ModelType getModelType() {
		return modelType;
	}
		
	public void setNumber(String number) {
		this.number = number;
	}

	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}
}
