var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":21,"id":3849,"methods":[{"el":8,"sc":2,"sl":6},{"el":12,"sc":2,"sl":10},{"el":16,"sc":2,"sl":14},{"el":20,"sc":2,"sl":18}],"name":"Feedback","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_67":{"methods":[{"sl":10},{"sl":14}],"name":"testRealtimeFeedbackClassification","pass":true,"statements":[{"sl":11},{"sl":15}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [67], [67], [], [], [67], [67], [], [], [], [], [], []]
