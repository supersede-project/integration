package eu.supersede.integration.poc.dynadapt.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="collection")
public class CollectionOfDecisions implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<AdaptationDecision> collection = new ArrayList<>();
	
	public CollectionOfDecisions(){
		
	}
	
	public CollectionOfDecisions(Collection<AdaptationDecision> collection){
		this.collection = collection;
	}

	@XmlElement (name="decision")
	public Collection<AdaptationDecision> getCollection() {
		return collection;
	}
}

//@XmlRootElement (name="collection")
//public class CollectionOfDecisions<T>{
//	/**
//	 * 
//	 */
//	private Collection<T> collection = new ArrayList<>();
//	
//	public CollectionOfDecisions(){
//		
//	}
//	
//	public CollectionOfDecisions(Collection<T> collection){
//		this.collection = collection;
//	}
//
//	@XmlAnyElement
//	public Collection<T> getCollection() {
//		return collection;
//	}
//
//}
