var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":33,"id":367,"methods":[{"el":16,"sc":5,"sl":14},{"el":26,"sc":5,"sl":18},{"el":32,"sc":5,"sl":29}],"name":"AdaptationMode","sl":9}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_116":{"methods":[{"sl":14}],"name":"testAdaptationMode","pass":true,"statements":[{"sl":15}]},"test_23":{"methods":[{"sl":18}],"name":"testGetAdaptationConfigurationMode","pass":true,"statements":[{"sl":20},{"sl":23},{"sl":25}]},"test_61":{"methods":[{"sl":29}],"name":"testSetAdaptationConfigurationMode","pass":true,"statements":[{"sl":31}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [116], [116], [], [], [23], [], [23], [], [], [23], [], [23], [], [], [], [61], [], [61], [], []]
