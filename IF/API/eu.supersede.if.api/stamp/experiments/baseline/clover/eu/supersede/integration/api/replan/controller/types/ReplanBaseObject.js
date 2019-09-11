var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":43,"id":6106,"methods":[{"el":33,"sc":2,"sl":31},{"el":36,"sc":2,"sl":34},{"el":39,"sc":2,"sl":37},{"el":42,"sc":2,"sl":40}],"name":"ReplanBaseObject","sl":27}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":34},{"sl":40}],"name":"testDeleteFeaturesOfReleaseByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_10":{"methods":[{"sl":34},{"sl":40}],"name":"testGetProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_100":{"methods":[{"sl":34},{"sl":40}],"name":"testDeleteResourcesOfReleaseByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_101":{"methods":[{"sl":31},{"sl":34},{"sl":37},{"sl":40}],"name":"testUpdateReleasesOfProjectById","pass":true,"statements":[{"sl":32},{"sl":35},{"sl":38},{"sl":41}]},"test_103":{"methods":[{"sl":34},{"sl":40}],"name":"testDeleteSkillsOfFeatureByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_107":{"methods":[{"sl":31},{"sl":34},{"sl":37},{"sl":40}],"name":"testDeleteSkillOfProjectById","pass":true,"statements":[{"sl":32},{"sl":35},{"sl":38},{"sl":41}]},"test_114":{"methods":[{"sl":34},{"sl":40}],"name":"testGetFeaturesOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_117":{"methods":[{"sl":31},{"sl":34},{"sl":37},{"sl":40}],"name":"testAddDeleteSkillOfProjectById","pass":true,"statements":[{"sl":32},{"sl":35},{"sl":38},{"sl":41}]},"test_123":{"methods":[{"sl":34},{"sl":40}],"name":"testGetReleasesOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_124":{"methods":[{"sl":34},{"sl":40}],"name":"testAddDeleteDependenciesOfFeatureByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_127":{"methods":[{"sl":34},{"sl":40}],"name":"testAddDeleteFeaturesOfReleaseByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_131":{"methods":[{"sl":34},{"sl":40}],"name":"testGetFeaturesOfReleaseByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_133":{"methods":[{"sl":34},{"sl":40}],"name":"testGetReleaseByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_137":{"methods":[{"sl":31},{"sl":34},{"sl":37},{"sl":40}],"name":"testAddDeleteResourceOfProjectById","pass":true,"statements":[{"sl":32},{"sl":35},{"sl":38},{"sl":41}]},"test_138":{"methods":[{"sl":34},{"sl":40}],"name":"testDelecteSkillsOfResourceByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_142":{"methods":[{"sl":31},{"sl":34},{"sl":37},{"sl":40}],"name":"tesDeleteResourceOfProjectById","pass":true,"statements":[{"sl":32},{"sl":35},{"sl":38},{"sl":41}]},"test_144":{"methods":[{"sl":31},{"sl":34},{"sl":37},{"sl":40}],"name":"testUpdateResourceOfProjectById","pass":true,"statements":[{"sl":32},{"sl":35},{"sl":38},{"sl":41}]},"test_16":{"methods":[{"sl":37}],"name":"testOptimizePlan","pass":true,"statements":[{"sl":38}]},"test_26":{"methods":[{"sl":31},{"sl":34},{"sl":37},{"sl":40}],"name":"testUpdateProject","pass":true,"statements":[{"sl":32},{"sl":35},{"sl":38},{"sl":41}]},"test_3":{"methods":[{"sl":34},{"sl":40}],"name":"testGetPlanOfReleaseByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_42":{"methods":[{"sl":34},{"sl":40}],"name":"testAddDeleteResourcesOfReleaseByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_52":{"methods":[{"sl":31},{"sl":34},{"sl":37},{"sl":40}],"name":"testUpdateSkillsOfProjectById","pass":true,"statements":[{"sl":32},{"sl":35},{"sl":38},{"sl":41}]},"test_57":{"methods":[{"sl":34},{"sl":40}],"name":"testAddDeleteSkillsOfResourceByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_59":{"methods":[{"sl":31},{"sl":34},{"sl":37},{"sl":40}],"name":"testCreateAndDeleteFeatureForProject","pass":true,"statements":[{"sl":32},{"sl":35},{"sl":38},{"sl":41}]},"test_63":{"methods":[{"sl":37}],"name":"testOptimizePlan","pass":true,"statements":[{"sl":38}]},"test_79":{"methods":[{"sl":34},{"sl":40}],"name":"testGetAllProjects","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_82":{"methods":[{"sl":31},{"sl":34},{"sl":37},{"sl":40}],"name":"testCreateAndDeleteProject","pass":true,"statements":[{"sl":32},{"sl":35},{"sl":38},{"sl":41}]},"test_83":{"methods":[{"sl":34},{"sl":40}],"name":"testGetSkillsOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_85":{"methods":[{"sl":34},{"sl":40}],"name":"testGetResourcesOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_87":{"methods":[{"sl":34},{"sl":40}],"name":"testGetFeatureByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_90":{"methods":[{"sl":34},{"sl":40}],"name":"testAddDeleteSkillsOfFeatureByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]},"test_96":{"methods":[{"sl":34},{"sl":40}],"name":"testDeleteDependenciesOfFeatureByIdOfProjectById","pass":true,"statements":[{"sl":35},{"sl":41}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [59, 142, 52, 101, 107, 137, 82, 26, 144, 117], [59, 142, 52, 101, 107, 137, 82, 26, 144, 117], [], [123, 10, 59, 127, 131, 1, 142, 138, 52, 101, 85, 107, 100, 87, 114, 137, 83, 82, 96, 3, 90, 26, 144, 79, 124, 57, 133, 42, 103, 117], [123, 10, 59, 127, 131, 1, 142, 138, 52, 101, 85, 107, 100, 87, 114, 137, 83, 82, 96, 3, 90, 26, 144, 79, 124, 57, 133, 42, 103, 117], [], [59, 142, 52, 101, 107, 137, 16, 82, 26, 144, 63, 117], [59, 142, 52, 101, 107, 137, 16, 82, 26, 144, 63, 117], [], [123, 10, 59, 127, 131, 1, 142, 138, 52, 101, 85, 107, 100, 87, 114, 137, 83, 82, 96, 3, 90, 26, 144, 79, 124, 57, 133, 42, 103, 117], [123, 10, 59, 127, 131, 1, 142, 138, 52, 101, 85, 107, 100, 87, 114, 137, 83, 82, 96, 3, 90, 26, 144, 79, 124, 57, 133, 42, 103, 117], [], []]
