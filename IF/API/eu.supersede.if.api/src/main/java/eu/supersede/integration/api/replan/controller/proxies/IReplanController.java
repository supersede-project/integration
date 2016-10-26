package eu.supersede.integration.api.replan.controller.proxies;

import java.util.List;

import eu.supersede.integration.api.replan.controller.types.AddFeaturesForProjectPayload;
import eu.supersede.integration.api.replan.controller.types.Feature;
import eu.supersede.integration.api.replan.controller.types.FeatureStatus;
import eu.supersede.integration.api.replan.controller.types.Plan;
import eu.supersede.integration.api.replan.controller.types.Project;
import eu.supersede.integration.api.replan.controller.types.Release;
import eu.supersede.integration.api.replan.controller.types.Resource;
import eu.supersede.integration.api.replan.controller.types.Skill;

public interface IReplanController {
	Project getProjectById(int projectId) throws Exception;
	List<Feature> getFeaturesOfProjectById (int projectId) throws Exception;
	List<Feature> getFeaturesOfProjectById (int projectId, FeatureStatus status) throws Exception;
	Feature getFeatureByIdOfProjectById(int featureId, int projectId) throws Exception;
	List<Release> getReleasesOfProjectById(int projectId) throws Exception;
	List<Feature> getFeaturesOfReleaseByIdOfProjectById(int featureId, int projectId) throws Exception;
	Plan getPlanOfReleaseByIdOfProjectById(int featureId, int projectId) throws Exception;
	List<Skill> getSkillsOfProjectById(int projectId) throws Exception;
	List<Resource> getResourcesOfProjectById(int projectId) throws Exception;
	Project updateProject(Project project) throws Exception;
	Feature updateFeatureOfProjectById(Feature feature, int projectId) throws Exception;
	Release updateReleaseOfProjectById(Release release, int projectId) throws Exception;
	Skill updateSkillOfProjectById(Skill skill, int projectId) throws Exception;
	Resource updateResourceOfProjectById(Resource resource, int projectId) throws Exception;
	Feature addSkillsOfFeatureByIdOfProjectById(List<Skill> skills, int featureId, int projectId) throws Exception;
	Feature addDependenciesOfFeatureByIdOfProjectById(List<Feature> features, int featureId, int projectId)
			throws Exception;
	boolean addReleaseOfProjectById(Release release, int projectId) throws Exception;
	Release addResourcesOfReleaseByIdOfProjectById(List<Resource> resources, int releaseId, int projectId)
			throws Exception;
	boolean addFeaturesOfReleaseByIdOfProjectById(List<Feature> features, int releaseId, int projectId)
			throws Exception;
	Skill addSkillOfProjectById(Skill skill, int projectId) throws Exception;
	Resource addResourceOfProjectById(Resource resource, int projectId) throws Exception;
	Resource addSkillOfResourceByIdOfProjectById(List<Skill> skills, int resourceId, int projectId) throws Exception;
	Feature deleteSkillsOfFeatureByIdOfProjectById(List<Skill> skills, int featureId, int projectId) throws Exception;
	Feature deleteDependenciesOfFeatureByIdOfProjectById(List<Feature> features, int featureId, int projectId)
			throws Exception;
	boolean deleteReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception;
	Release deleteResourcesOfReleaseByIdOfProjectById(List<Resource> resources, int releaseId, int projectId)
			throws Exception;
	boolean deleteFeaturesOfReleaseByIdOfProjectById(List<Feature> features, int releaseId, int projectId)
			throws Exception;
	boolean cancelLastPlanOfReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception;
	boolean deleteSkillByIdOfProjectById(int skillId, int projectId) throws Exception;
	boolean deleteResourceByIdOfProjectById(int resourceId, int projectId) throws Exception;
	Resource deleteSkillsOfResourceByIdOfProjectById(List<Skill> skills, int resourceId, int projectId) throws Exception;
	boolean addFeaturesToProjectById(AddFeaturesForProjectPayload payload, int projectId) throws Exception;
}

