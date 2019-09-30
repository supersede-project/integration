var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":32,"id":456,"methods":[{"el":7,"sc":2,"sl":5},{"el":10,"sc":2,"sl":8},{"el":13,"sc":2,"sl":11},{"el":16,"sc":2,"sl":14},{"el":22,"sc":2,"sl":22},{"el":30,"sc":2,"sl":24}],"name":"DataID","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_56":{"methods":[{"sl":5},{"sl":8},{"sl":11},{"sl":14},{"sl":22}],"name":"testOptimize","pass":true,"statements":[{"sl":6},{"sl":9},{"sl":12},{"sl":15}]},"test_80":{"methods":[{"sl":5},{"sl":8},{"sl":11},{"sl":14},{"sl":22}],"name":"testPublishAdaptionAlertMessage","pass":true,"statements":[{"sl":6},{"sl":9},{"sl":12},{"sl":15}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [56, 80], [56, 80], [], [56, 80], [56, 80], [], [56, 80], [56, 80], [], [56, 80], [56, 80], [], [], [], [], [], [], [56, 80], [], [], [], [], [], [], [], [], [], []]
