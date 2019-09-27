var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":42,"id":3455,"methods":[{"el":39,"sc":2,"sl":33}],"name":"EnactmentCompletionTimeJsonSerializer","sl":31}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_107":{"methods":[{"sl":33}],"name":"testResetDashboard","pass":true,"statements":[{"sl":36},{"sl":37},{"sl":38}]},"test_3":{"methods":[{"sl":33}],"name":"testAddEnactment","pass":true,"statements":[{"sl":36},{"sl":37},{"sl":38}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [107, 3], [], [], [107, 3], [107, 3], [107, 3], [], [], [], []]
