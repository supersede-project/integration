package eu.supersede.integration.api.adaptation.types;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class IModel implements Comparable<IModel>{

	public void setValue(String property, Object value) throws Exception {
		
		Field f;
		try {
			f = this.getClass().getDeclaredField(property);
		} catch (NoSuchFieldException e1) {
			try {
				f = this.getClass().getSuperclass().getDeclaredField(property);
			} catch (NoSuchFieldException e2) {
				throw new Exception("This type of model does not have a " + property + " field");

			}
		} 
		f.setAccessible(true);
		f.set(this, value);

	}

	public Object getValue(String property) throws Exception {
		
		Field f;
		try {
			f = this.getClass().getDeclaredField(property);
		} catch (NoSuchFieldException e1) {
			try {
				f = this.getClass().getSuperclass().getDeclaredField(property);
			} catch (NoSuchFieldException e2) {
				throw new Exception("This type of model does not have a " + property + " field");

			}
		} 
		f.setAccessible(true);
		return f.get(this);
		
	}
	
	@Override
	public int compareTo (IModel m){
		//Comparing by lastModificationDate (inverse order)
		try{
			if (m.getValue("lastModificationDate")!=null && 
				this.getValue("lastModificationDate")!=null){
				//TODO Parse dates and compare them
				return ((Date)m.getValue("lastModificationDate"))
					.compareTo((Date)this.getValue("lastModificationDate"));
			}
		}catch (Exception e){
			//Ignored
		}
		
		//Otherwise by creationDate (inverse order)
		try{
			if (m.getValue("creationDate")!=null && 
					this.getValue("creationDate")!=null){
				return ((Date)m.getValue("creationDate"))
						.compareTo((Date)this.getValue("creationDate"));	
			}
		}catch (Exception e){
			//Ignored
		}
		
		//Otherwise by id (inverse order)
		try{
			if (m.getValue("id")!=null && 
					this.getValue("id")!=null){
				return (Integer.valueOf((String)m.getValue("id")))
						.compareTo(Integer.valueOf((String)this.getValue("id")));	
			}
		}catch (Exception e){
			//Ignored
		}
		return 0;
	}
	
	public List<Field> getFields() {
		
		Field[] fields1 = this.getClass().getDeclaredFields();
		Field[] fields2 = this.getClass().getSuperclass().getDeclaredFields();
		
		List<Field> fields = new ArrayList<>();
		
		for (Field f : fields1) fields.add(f);
		for (Field f : fields2) fields.add(f);
		
		return fields;
				
	}
}
