var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":14,"id":363,"methods":[{"el":9,"sc":2,"sl":7},{"el":12,"sc":2,"sl":10}],"name":"AdaptabilityModel","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_115":{"methods":[{"sl":7},{"sl":10}],"name":"testCreateUpdateAndDeleteAdaptationModel","pass":true,"statements":[{"sl":8},{"sl":11}]},"test_15":{"methods":[{"sl":7},{"sl":10}],"name":"testCreateGetAndDeleteAdaptationModel","pass":true,"statements":[{"sl":8},{"sl":11}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [15, 115], [15, 115], [], [15, 115], [15, 115], [], [], []]
