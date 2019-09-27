var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":23,"id":605,"methods":[{"el":11,"sc":2,"sl":9},{"el":17,"sc":2,"sl":13},{"el":21,"sc":2,"sl":19}],"name":"Tenant","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_34":{"methods":[{"sl":9},{"sl":13}],"name":"testGelAllEvents","pass":true,"statements":[{"sl":10},{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [34], [34], [], [], [34], [], [], [34], [], [], [], [], [], [], []]
