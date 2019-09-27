var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":18,"id":3992,"methods":[{"el":14,"sc":2,"sl":12},{"el":17,"sc":2,"sl":15}],"name":"AppStoreMonitorConfiguration","sl":9}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_2":{"methods":[{"sl":12},{"sl":15}],"name":"testCreateAndDeleteMonitorConfiguration","pass":true,"statements":[{"sl":13},{"sl":16}]},"test_81":{"methods":[{"sl":12},{"sl":15}],"name":"testUpdateMonitorConfiguration","pass":true,"statements":[{"sl":13},{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [81, 2], [81, 2], [], [81, 2], [81, 2], [], []]
