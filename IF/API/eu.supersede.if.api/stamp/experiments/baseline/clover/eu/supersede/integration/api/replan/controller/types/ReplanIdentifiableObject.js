var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":31,"id":6114,"methods":[{"el":27,"sc":2,"sl":25},{"el":30,"sc":2,"sl":28}],"name":"ReplanIdentifiableObject","sl":22}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":25},{"sl":28}],"name":"testDeleteFeaturesOfReleaseByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_10":{"methods":[{"sl":28}],"name":"testGetProjectById","pass":true,"statements":[{"sl":29}]},"test_100":{"methods":[{"sl":25},{"sl":28}],"name":"testDeleteResourcesOfReleaseByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_101":{"methods":[{"sl":25},{"sl":28}],"name":"testUpdateReleasesOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_103":{"methods":[{"sl":25},{"sl":28}],"name":"testDeleteSkillsOfFeatureByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_107":{"methods":[{"sl":25},{"sl":28}],"name":"testDeleteSkillOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_114":{"methods":[{"sl":28}],"name":"testGetFeaturesOfProjectById","pass":true,"statements":[{"sl":29}]},"test_117":{"methods":[{"sl":25},{"sl":28}],"name":"testAddDeleteSkillOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_123":{"methods":[{"sl":28}],"name":"testGetReleasesOfProjectById","pass":true,"statements":[{"sl":29}]},"test_124":{"methods":[{"sl":25},{"sl":28}],"name":"testAddDeleteDependenciesOfFeatureByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_127":{"methods":[{"sl":25},{"sl":28}],"name":"testAddDeleteFeaturesOfReleaseByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_131":{"methods":[{"sl":25},{"sl":28}],"name":"testGetFeaturesOfReleaseByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_133":{"methods":[{"sl":25},{"sl":28}],"name":"testGetReleaseByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_137":{"methods":[{"sl":25},{"sl":28}],"name":"testAddDeleteResourceOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_138":{"methods":[{"sl":25},{"sl":28}],"name":"testDelecteSkillsOfResourceByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_142":{"methods":[{"sl":25},{"sl":28}],"name":"tesDeleteResourceOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_144":{"methods":[{"sl":25},{"sl":28}],"name":"testUpdateResourceOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_16":{"methods":[{"sl":25}],"name":"testOptimizePlan","pass":true,"statements":[{"sl":26}]},"test_26":{"methods":[{"sl":25},{"sl":28}],"name":"testUpdateProject","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_3":{"methods":[{"sl":25},{"sl":28}],"name":"testGetPlanOfReleaseByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_42":{"methods":[{"sl":25},{"sl":28}],"name":"testAddDeleteResourcesOfReleaseByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_52":{"methods":[{"sl":25},{"sl":28}],"name":"testUpdateSkillsOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_57":{"methods":[{"sl":25},{"sl":28}],"name":"testAddDeleteSkillsOfResourceByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_59":{"methods":[{"sl":25},{"sl":28}],"name":"testCreateAndDeleteFeatureForProject","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_63":{"methods":[{"sl":25}],"name":"testOptimizePlan","pass":true,"statements":[{"sl":26}]},"test_79":{"methods":[{"sl":28}],"name":"testGetAllProjects","pass":true,"statements":[{"sl":29}]},"test_82":{"methods":[{"sl":25},{"sl":28}],"name":"testCreateAndDeleteProject","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_83":{"methods":[{"sl":28}],"name":"testGetSkillsOfProjectById","pass":true,"statements":[{"sl":29}]},"test_85":{"methods":[{"sl":28}],"name":"testGetResourcesOfProjectById","pass":true,"statements":[{"sl":29}]},"test_87":{"methods":[{"sl":25},{"sl":28}],"name":"testGetFeatureByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_90":{"methods":[{"sl":25},{"sl":28}],"name":"testAddDeleteSkillsOfFeatureByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]},"test_96":{"methods":[{"sl":25},{"sl":28}],"name":"testDeleteDependenciesOfFeatureByIdOfProjectById","pass":true,"statements":[{"sl":26},{"sl":29}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [59, 127, 131, 1, 142, 138, 52, 101, 107, 100, 87, 137, 16, 82, 96, 3, 90, 26, 144, 63, 124, 57, 133, 42, 103, 117], [59, 127, 131, 1, 142, 138, 52, 101, 107, 100, 87, 137, 16, 82, 96, 3, 90, 26, 144, 63, 124, 57, 133, 42, 103, 117], [], [123, 10, 59, 127, 131, 1, 142, 138, 52, 101, 85, 107, 100, 87, 114, 137, 83, 82, 96, 3, 90, 26, 144, 79, 124, 57, 133, 42, 103, 117], [123, 10, 59, 127, 131, 1, 142, 138, 52, 101, 85, 107, 100, 87, 114, 137, 83, 82, 96, 3, 90, 26, 144, 79, 124, 57, 133, 42, 103, 117], [], []]
