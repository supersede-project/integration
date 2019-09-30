var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":45,"id":438,"methods":[{"el":7,"sc":2,"sl":5},{"el":11,"sc":2,"sl":9},{"el":15,"sc":2,"sl":13},{"el":19,"sc":2,"sl":17},{"el":23,"sc":2,"sl":21},{"el":27,"sc":2,"sl":25},{"el":33,"sc":2,"sl":33},{"el":43,"sc":2,"sl":35}],"name":"Condition","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_56":{"methods":[{"sl":5},{"sl":13},{"sl":21},{"sl":35}],"name":"testOptimize","pass":true,"statements":[{"sl":6},{"sl":14},{"sl":22},{"sl":39},{"sl":40},{"sl":41},{"sl":42}]},"test_80":{"methods":[{"sl":5},{"sl":9},{"sl":13},{"sl":17},{"sl":21},{"sl":25},{"sl":33},{"sl":35}],"name":"testPublishAdaptionAlertMessage","pass":true,"statements":[{"sl":6},{"sl":10},{"sl":14},{"sl":18},{"sl":22},{"sl":26},{"sl":39},{"sl":40},{"sl":41},{"sl":42}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [56, 80], [56, 80], [], [], [80], [80], [], [], [56, 80], [56, 80], [], [], [80], [80], [], [], [56, 80], [56, 80], [], [], [80], [80], [], [], [], [], [], [], [80], [], [56, 80], [], [], [], [56, 80], [56, 80], [56, 80], [56, 80], [], [], []]
