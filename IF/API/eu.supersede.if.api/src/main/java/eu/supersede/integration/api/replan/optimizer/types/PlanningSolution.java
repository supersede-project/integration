package eu.supersede.integration.api.replan.optimizer.types;

import java.util.ArrayList;
import java.util.List;

import eu.supersede.integration.api.replan.controller.types.Job;

public class PlanningSolution {
	private List<PlannedFeature> jobs;
	
	public List<PlannedFeature> getJobs() {
		if (jobs == null)
			jobs = new ArrayList<>();
		return jobs;
	}
	public void setJobs(List<PlannedFeature> jobs) {
		this.jobs = jobs;
	}
}
