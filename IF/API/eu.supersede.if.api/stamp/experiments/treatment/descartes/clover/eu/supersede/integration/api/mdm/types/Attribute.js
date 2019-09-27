var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":20,"id":3657,"methods":[{"el":10,"sc":2,"sl":8},{"el":13,"sc":2,"sl":11},{"el":16,"sc":2,"sl":14},{"el":19,"sc":2,"sl":17}],"name":"Attribute","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_34":{"methods":[{"sl":11},{"sl":17}],"name":"testGelAllEvents","pass":true,"statements":[{"sl":12},{"sl":18}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [34], [34], [], [], [], [], [34], [34], [], []]
