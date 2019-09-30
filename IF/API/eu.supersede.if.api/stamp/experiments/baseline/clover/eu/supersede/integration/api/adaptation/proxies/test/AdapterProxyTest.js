var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":235,"id":7565,"methods":[{"el":62,"sc":2,"sl":57},{"el":81,"sc":2,"sl":64},{"el":103,"sc":2,"sl":83},{"el":122,"sc":2,"sl":105},{"el":137,"sc":2,"sl":124},{"el":149,"sc":2,"sl":139},{"el":160,"sc":2,"sl":151},{"el":179,"sc":2,"sl":162},{"el":189,"sc":2,"sl":181},{"el":201,"sc":2,"sl":191},{"el":211,"sc":2,"sl":203},{"el":221,"sc":2,"sl":213},{"el":233,"sc":2,"sl":223}],"name":"AdapterProxyTest","sl":50}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_115":{"methods":[{"sl":124},{"sl":139},{"sl":151},{"sl":162},{"sl":181},{"sl":191},{"sl":203},{"sl":213}],"name":"testEnactAdaptationDecisionActionsForFC","pass":true,"statements":[{"sl":127},{"sl":130},{"sl":131},{"sl":132},{"sl":135},{"sl":136},{"sl":140},{"sl":142},{"sl":143},{"sl":144},{"sl":145},{"sl":146},{"sl":148},{"sl":152},{"sl":154},{"sl":155},{"sl":156},{"sl":157},{"sl":159},{"sl":163},{"sl":164},{"sl":165},{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":171},{"sl":172},{"sl":173},{"sl":174},{"sl":175},{"sl":176},{"sl":178},{"sl":182},{"sl":183},{"sl":186},{"sl":187},{"sl":188},{"sl":192},{"sl":193},{"sl":194},{"sl":195},{"sl":196},{"sl":197},{"sl":198},{"sl":199},{"sl":200},{"sl":204},{"sl":205},{"sl":206},{"sl":207},{"sl":208},{"sl":210},{"sl":214},{"sl":215},{"sl":216},{"sl":217},{"sl":218},{"sl":220}]},"test_22":{"methods":[{"sl":83},{"sl":139},{"sl":151},{"sl":162},{"sl":181},{"sl":191},{"sl":203},{"sl":213}],"name":"testEnactSelectedAdaptationDecisionsInFCGivenByString","pass":true,"statements":[{"sl":85},{"sl":88},{"sl":91},{"sl":92},{"sl":93},{"sl":96},{"sl":97},{"sl":98},{"sl":99},{"sl":100},{"sl":101},{"sl":102},{"sl":140},{"sl":142},{"sl":143},{"sl":144},{"sl":145},{"sl":146},{"sl":148},{"sl":152},{"sl":154},{"sl":155},{"sl":156},{"sl":157},{"sl":159},{"sl":163},{"sl":164},{"sl":165},{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":171},{"sl":172},{"sl":173},{"sl":174},{"sl":175},{"sl":176},{"sl":178},{"sl":182},{"sl":183},{"sl":186},{"sl":187},{"sl":188},{"sl":192},{"sl":193},{"sl":194},{"sl":195},{"sl":196},{"sl":197},{"sl":198},{"sl":199},{"sl":200},{"sl":204},{"sl":205},{"sl":206},{"sl":207},{"sl":208},{"sl":210},{"sl":214},{"sl":215},{"sl":216},{"sl":217},{"sl":218},{"sl":220}]},"test_66":{"methods":[{"sl":105},{"sl":139},{"sl":151},{"sl":162},{"sl":181},{"sl":191},{"sl":203},{"sl":213}],"name":"testEnactFCGivenByString","pass":true,"statements":[{"sl":107},{"sl":110},{"sl":113},{"sl":114},{"sl":115},{"sl":118},{"sl":119},{"sl":120},{"sl":121},{"sl":140},{"sl":142},{"sl":143},{"sl":144},{"sl":145},{"sl":146},{"sl":148},{"sl":152},{"sl":154},{"sl":155},{"sl":156},{"sl":157},{"sl":159},{"sl":163},{"sl":164},{"sl":165},{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":171},{"sl":172},{"sl":173},{"sl":174},{"sl":175},{"sl":176},{"sl":178},{"sl":182},{"sl":183},{"sl":186},{"sl":187},{"sl":188},{"sl":192},{"sl":193},{"sl":194},{"sl":195},{"sl":196},{"sl":197},{"sl":198},{"sl":199},{"sl":200},{"sl":204},{"sl":205},{"sl":206},{"sl":207},{"sl":208},{"sl":210},{"sl":214},{"sl":215},{"sl":216},{"sl":217},{"sl":218},{"sl":220}]},"test_69":{"methods":[{"sl":64},{"sl":139},{"sl":151},{"sl":162},{"sl":181},{"sl":191},{"sl":203},{"sl":213}],"name":"testEnactAdaptationDecisionActions","pass":true,"statements":[{"sl":66},{"sl":69},{"sl":72},{"sl":73},{"sl":74},{"sl":76},{"sl":77},{"sl":78},{"sl":79},{"sl":80},{"sl":140},{"sl":142},{"sl":143},{"sl":144},{"sl":145},{"sl":146},{"sl":148},{"sl":152},{"sl":154},{"sl":155},{"sl":156},{"sl":157},{"sl":159},{"sl":163},{"sl":164},{"sl":165},{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":171},{"sl":172},{"sl":173},{"sl":174},{"sl":175},{"sl":176},{"sl":178},{"sl":182},{"sl":183},{"sl":186},{"sl":187},{"sl":188},{"sl":192},{"sl":193},{"sl":194},{"sl":195},{"sl":196},{"sl":197},{"sl":198},{"sl":199},{"sl":200},{"sl":204},{"sl":205},{"sl":206},{"sl":207},{"sl":208},{"sl":210},{"sl":214},{"sl":215},{"sl":216},{"sl":217},{"sl":218},{"sl":220}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [69], [], [69], [], [], [69], [], [], [69], [69], [69], [], [69], [69], [69], [69], [69], [], [], [22], [], [22], [], [], [22], [], [], [22], [22], [22], [], [], [22], [22], [22], [22], [22], [22], [22], [], [], [66], [], [66], [], [], [66], [], [], [66], [66], [66], [], [], [66], [66], [66], [66], [], [], [115], [], [], [115], [], [], [115], [115], [115], [], [], [115], [115], [], [], [22, 115, 69, 66], [22, 115, 69, 66], [], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [], [22, 115, 69, 66], [], [], [22, 115, 69, 66], [22, 115, 69, 66], [], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [], [22, 115, 69, 66], [], [], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [], [22, 115, 69, 66], [], [], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [], [], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [], [], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [], [], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [], [22, 115, 69, 66], [], [], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [22, 115, 69, 66], [], [22, 115, 69, 66], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]