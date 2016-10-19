package eu.supersede.integration.api.replan.optimizer.proxies;

import java.net.URI;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.api.replan.optimizer.types.NextReleaseProblem;
import eu.supersede.integration.api.replan.optimizer.types.PlanningSolution;
import eu.supersede.integration.properties.IntegrationProperty;
import org.springframework.http.HttpStatus;


public class ReplanOptimizerProxy <T,S> extends IFServiceProxy<T,S> implements IReplanOptimizer{
	private final static String SUPERSEDE_REPLAN_OPTIMIZER_ENDPOINT = 
			IntegrationProperty.getProperty("replan_optimizer.endpoint");
	
	public PlanningSolution optimizePlan (NextReleaseProblem nrProblem) throws Exception{
		URI uri = new URI(SUPERSEDE_REPLAN_OPTIMIZER_ENDPOINT + "replan");		
		return insertJSONObjectAndReturnAnotherType(nrProblem, PlanningSolution.class, uri, HttpStatus.OK);
	}

}
