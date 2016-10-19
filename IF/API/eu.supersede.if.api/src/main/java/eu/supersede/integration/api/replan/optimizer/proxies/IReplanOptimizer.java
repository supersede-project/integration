package eu.supersede.integration.api.replan.optimizer.proxies;

import eu.supersede.integration.api.replan.optimizer.types.NextReleaseProblem;
import eu.supersede.integration.api.replan.optimizer.types.PlanningSolution;

public interface IReplanOptimizer {
	PlanningSolution optimizePlan (NextReleaseProblem nrProblem) throws Exception;
}
