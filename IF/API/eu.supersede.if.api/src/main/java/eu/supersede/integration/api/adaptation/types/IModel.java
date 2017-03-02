package eu.supersede.integration.api.adaptation.types;

import java.lang.reflect.Field;

public abstract class IModel implements Comparable<IModel>{

	public void setValue(String property, Object value) throws Exception {
		
		Field f;
		try {
			f = this.getClass().getDeclaredField(property);
		} catch (NoSuchFieldException e1) {
			throw new Exception("This type of model does not have a " + property + " field");
		} 
		f.setAccessible(true);
		f.set(this, value);

	}

	public Object getValue(String property) throws Exception {
		
		Field f;
		try {
			f = this.getClass().getDeclaredField(property);
		} catch (NoSuchFieldException e1) {
			throw new Exception("This type of model does not have a " + property + " field");
		} 
		f.setAccessible(true);
		return (String) f.get(this);
		
	}
	
	@Override
	public int compareTo (IModel m){
		//Comparing by lastModificationDate (inverse order)
		try{
			if (m.getValue("lastModificationDate")!=null && 
				this.getValue("lastModificationDate")!=null){
				//TODO Parse dates and compare them
				return ((String)m.getValue("lastModificationDate"))
					.compareTo((String)this.getValue("lastModificationDate"));
			}
		}catch (Exception e){
			//Ignored
		}
		
		//Otherwise by creationDate (inverse order)
		try{
			if (m.getValue("creationDate")!=null && 
					this.getValue("creationDate")!=null){
				return ((String)m.getValue("lastModificationDate"))
						.compareTo((String)this.getValue("lastModificationDate"));	
			}
		}catch (Exception e){
			//Ignored
		}
		
		//Otherwise by id (inverse order)
		try{
			if (m.getValue("id")!=null && 
					this.getValue("id")!=null){
				return ((String)m.getValue("lastModificationDate"))
						.compareTo((String)this.getValue("lastModificationDate"));	
			}
		}catch (Exception e){
			//Ignored
		}
		return 0;
	}
}
