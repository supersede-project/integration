package eu.supersede.integration.api.replan.optimizer.types;

public class AlgorithmParameters {
	private AlgorithmType algorithmType;
	private Double crossoverProbability;
	private Double rateOfNotRandomSolution;
	private Integer numberOfIterations;
	private Integer populationSize;
	public AlgorithmType getAlgorithmType() {
		return algorithmType;
	}
	public void setAlgorithmType(AlgorithmType algorithmType) {
		this.algorithmType = algorithmType;
	}
	public Double getCrossoverProbability() {
		return crossoverProbability;
	}
	public void setCrossoverProbability(Double crossoverProbability) {
		this.crossoverProbability = crossoverProbability;
	}
	public Double getRateOfNotRandomSolution() {
		return rateOfNotRandomSolution;
	}
	public void setRateOfNotRandomSolution(Double rateOfNotRandomSolution) {
		this.rateOfNotRandomSolution = rateOfNotRandomSolution;
	}
	public Integer getNumberOfIterations() {
		return numberOfIterations;
	}
	public void setNumberOfIterations(Integer numberOfIterations) {
		this.numberOfIterations = numberOfIterations;
	}
	public Integer getPopulationSize() {
		return populationSize;
	}
	public void setPopulationSize(Integer populationSize) {
		this.populationSize = populationSize;
	}
	
}
