package eu.supersede.integration.api.analysis.proxies.test;


import eu.supersede.integration.api.analysis.proxies.DataProviderProxy;
import eu.supersede.integration.api.analysis.types.MonitoringData;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AmplDataProviderProxyTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static DataProviderProxy proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplDataProviderProxyTest.proxy = new DataProviderProxy();
    }

    private JSONObject createMonitoringDataListAsJson() {
        List<MonitoringData> dataList = createMonitoringDataList();
        String timeStamp = Calendar.getInstance().getTime().toString();
        int outputId = 2;
        int confId = 3;
        JSONArray items = new JSONArray();
        for (MonitoringData item : dataList) {
            JSONObject jsonItem = new JSONObject();
            jsonItem.put("idItem", item.getId());
            jsonItem.put("timeStamp", item.getTimeStamp());
            jsonItem.put("message", item.getMessage());
            jsonItem.put("author", item.getAuthor());
            jsonItem.put("link", item.getLink());
            items.put(jsonItem);
        }
        JSONObject mainInfo = new JSONObject();
        mainInfo.put("idOutput", String.valueOf(outputId));
        mainInfo.put("confId", String.valueOf(confId));
        mainInfo.put("searchTimeStamp", timeStamp);
        mainInfo.put("numDataItems", dataList.size());
        mainInfo.put("DataItems", items);
        JSONObject jsonData = new JSONObject();
        jsonData.put("SocialNetworksMonitoredData", mainInfo);
        return jsonData;
    }

    private List<MonitoringData> createMonitoringDataList() {
        List<MonitoringData> data = new ArrayList<>();
        int max_data = 10;
        int index = 0;
        while ((index++) < max_data) {
            data.add(createRandomMonitoringData());
        } 
        return data;
    }

    private MonitoringData createRandomMonitoringData() {
        Random random = new Random();
        String id = "id" + (random.nextInt(1000));
        String message = "monitoring message from monitor " + (random.nextInt(1000));
        Date date = Calendar.getInstance().getTime();
        String link = "https://twitter.com/" + (random.nextInt(1000));
        return new MonitoringData(id, date.toString(), message, "twitter_monitor", link);
    }

    @Test(timeout = 10000)
    public void testIngestData_add1_sd34_failAssert0() throws Exception {
        try {
            String __DSPOT_arg0_4 = "X(r!Fs2l>UgIvC=TU&zg";
            JSONObject __DSPOT_invoc_1 = createMonitoringDataListAsJson();
            JSONObject jsonData = createMonitoringDataListAsJson();
            String topic = "atos";
            AmplDataProviderProxyTest.proxy.ingestData(createMonitoringDataListAsJson().toString(), "atos");
            createMonitoringDataListAsJson().get("X(r!Fs2l>UgIvC=TU&zg");
            org.junit.Assert.fail("testIngestData_add1_sd34 should have thrown JSONException");
        } catch (JSONException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testIngestData_add1_sd52_failAssert10() throws Exception {
        try {
            BigDecimal __DSPOT_arg1_19 = new BigDecimal(new BigInteger(466163713, new byte[]{ 93, -37, -44 }));
            String __DSPOT_arg0_18 = "^1yAAF?5P&+YTN/#yO[*";
            JSONObject __DSPOT_invoc_1 = createMonitoringDataListAsJson();
            JSONObject jsonData = createMonitoringDataListAsJson();
            String topic = "atos";
            AmplDataProviderProxyTest.proxy.ingestData(createMonitoringDataListAsJson().toString(), "atos");
            createMonitoringDataListAsJson().optBigDecimal("^1yAAF?5P&+YTN/#yO[*", new BigDecimal(new BigInteger(466163713, new byte[]{ 93, -37, -44 })));
            org.junit.Assert.fail("testIngestData_add1_sd52 should have thrown NumberFormatException");
        } catch (NumberFormatException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testIngestData_add1_sd52_failAssert10_sd230_failAssert0() throws Exception {
        try {
            try {
                MathContext __DSPOT_arg0_64 = new MathContext("w9b>c1NAnIwcz&T&5+;N");
                BigDecimal __DSPOT_arg1_19 = new BigDecimal(new BigInteger(466163713, new byte[]{ 93, -37, -44 }));
                String __DSPOT_arg0_18 = "^1yAAF?5P&+YTN/#yO[*";
                JSONObject __DSPOT_invoc_1 = createMonitoringDataListAsJson();
                JSONObject jsonData = createMonitoringDataListAsJson();
                String topic = "atos";
                AmplDataProviderProxyTest.proxy.ingestData(createMonitoringDataListAsJson().toString(), "atos");
                BigDecimal __DSPOT_invoc_15 = createMonitoringDataListAsJson().optBigDecimal("^1yAAF?5P&+YTN/#yO[*", new BigDecimal(new BigInteger(466163713, new byte[]{ 93, -37, -44 })));
                org.junit.Assert.fail("testIngestData_add1_sd52 should have thrown NumberFormatException");
                createMonitoringDataListAsJson().optBigDecimal("^1yAAF?5P&+YTN/#yO[*", new BigDecimal(new BigInteger(466163713, new byte[]{ 93, -37, -44 }))).abs(new MathContext("w9b>c1NAnIwcz&T&5+;N"));
            } catch (NumberFormatException eee) {
            }
            org.junit.Assert.fail("testIngestData_add1_sd52_failAssert10_sd230 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testIngestDataSequence_add551_sd718_failAssert0() throws Exception {
        try {
            BigInteger __DSPOT_arg1_129 = new BigInteger(-125498828, new Random(-115836582L));
            String __DSPOT_arg0_128 = "1_)f(dMmVFwF=EcyHGP}";
            JSONObject __DSPOT_invoc_1 = createMonitoringDataListAsJson();
            JSONObject jsonData = createMonitoringDataListAsJson();
            String topic = "atos";
            Long startTime = System.currentTimeMillis();
            int iterations = 1000;
            for (int i = 0; 0 <= iterations; i++) {
                AmplDataProviderProxyTest.proxy.ingestData(createMonitoringDataListAsJson().toString(), "atos");
            }
            Long endTime = System.currentTimeMillis();
            log.debug((((("Sent " + iterations) + " Json messages to DataProvider in ") + ((System.currentTimeMillis()) - (System.currentTimeMillis()))) + " miliseconds"));
            createMonitoringDataListAsJson().optBigInteger("1_)f(dMmVFwF=EcyHGP}", new BigInteger(-125498828, new Random(-115836582L)));
            org.junit.Assert.fail("testIngestDataSequence_add551_sd718 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testIngestDataSequence_add551_sd718_failAssert0_sd1028_failAssert0() throws Exception {
        try {
            try {
                BigInteger __DSPOT_arg0_182 = new BigInteger(1822058543, -666023280, new Random(-807935175L));
                BigInteger __DSPOT_arg1_129 = new BigInteger(-125498828, new Random(-115836582L));
                String __DSPOT_arg0_128 = "1_)f(dMmVFwF=EcyHGP}";
                JSONObject __DSPOT_invoc_1 = createMonitoringDataListAsJson();
                JSONObject jsonData = createMonitoringDataListAsJson();
                String topic = "atos";
                Long startTime = System.currentTimeMillis();
                int iterations = 1000;
                for (int i = 0; 0 <= iterations; i++) {
                    AmplDataProviderProxyTest.proxy.ingestData(createMonitoringDataListAsJson().toString(), "atos");
                }
                Long endTime = System.currentTimeMillis();
                log.debug((((("Sent " + iterations) + " Json messages to DataProvider in ") + ((System.currentTimeMillis()) - (System.currentTimeMillis()))) + " miliseconds"));
                BigInteger __DSPOT_invoc_25 = createMonitoringDataListAsJson().optBigInteger("1_)f(dMmVFwF=EcyHGP}", new BigInteger(-125498828, new Random(-115836582L)));
                org.junit.Assert.fail("testIngestDataSequence_add551_sd718 should have thrown IllegalArgumentException");
                createMonitoringDataListAsJson().optBigInteger("1_)f(dMmVFwF=EcyHGP}", new BigInteger(-125498828, new Random(-115836582L))).mod(new BigInteger(1822058543, -666023280, new Random(-807935175L)));
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testIngestDataSequence_add551_sd718_failAssert0_sd1028 should have thrown ArithmeticException");
        } catch (ArithmeticException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testIngestJsonData_literalMutationString1306() throws Exception {
        String topic = "confId";
        Assert.assertEquals("confId", topic);
        AmplDataProviderProxyTest.proxy.ingestData(createMonitoringDataListAsJson(), topic);
        Assert.assertEquals("confId", topic);
    }

    @Test(timeout = 10000)
    public void testIngestJsonData_literalMutationString1306_add1329_sd1359_failAssert0() throws Exception {
        try {
            String __DSPOT_arg0_201 = "Vv>/f/5!<Y=dgY,;s4m>";
            JSONObject __DSPOT_invoc_1 = createMonitoringDataListAsJson();
            JSONObject jsonData = createMonitoringDataListAsJson();
            String topic = "confId";
            AmplDataProviderProxyTest.proxy.ingestData(createMonitoringDataListAsJson(), "confId");
            createMonitoringDataListAsJson().get("Vv>/f/5!<Y=dgY,;s4m>");
            org.junit.Assert.fail("testIngestJsonData_literalMutationString1306_add1329_sd1359 should have thrown JSONException");
        } catch (JSONException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testIngestJsonData_literalMutationString1306_add1329_sd1377_failAssert10() throws Exception {
        try {
            BigDecimal __DSPOT_arg1_216 = new BigDecimal("!M32Z7w;!lr:)EfUW+}=", new MathContext(-1514182617));
            String __DSPOT_arg0_215 = "SSUhwIbR]FMwAeMp&sZ9";
            JSONObject __DSPOT_invoc_1 = createMonitoringDataListAsJson();
            JSONObject jsonData = createMonitoringDataListAsJson();
            String topic = "confId";
            AmplDataProviderProxyTest.proxy.ingestData(createMonitoringDataListAsJson(), "confId");
            createMonitoringDataListAsJson().optBigDecimal("SSUhwIbR]FMwAeMp&sZ9", new BigDecimal("!M32Z7w;!lr:)EfUW+}=", new MathContext(-1514182617)));
            org.junit.Assert.fail("testIngestJsonData_literalMutationString1306_add1329_sd1377 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testIngestMonitoringData_add1526() throws Exception {
        List<MonitoringData> dataList = createMonitoringDataList();
        String timeStamp = Calendar.getInstance().getTime().toString();
        int outputId = 2;
        int confId = 3;
        String topic = "atos";
        Assert.assertEquals("atos", topic);
        AmplDataProviderProxyTest.proxy.ingestMonitoringData(dataList, timeStamp, outputId, confId, topic);
        AmplDataProviderProxyTest.proxy.ingestMonitoringData(dataList, timeStamp, outputId, confId, topic);
        Assert.assertEquals("atos", topic);
    }

    @Test(timeout = 10000)
    public void testIngestMonitoringData_add1526_literalMutationString1618() throws Exception {
        List<MonitoringData> dataList = createMonitoringDataList();
        String timeStamp = Calendar.getInstance().getTime().toString();
        int outputId = 2;
        int confId = 3;
        String topic = "aOtos";
        Assert.assertEquals("aOtos", topic);
        AmplDataProviderProxyTest.proxy.ingestMonitoringData(dataList, timeStamp, outputId, confId, topic);
        AmplDataProviderProxyTest.proxy.ingestMonitoringData(dataList, timeStamp, outputId, confId, topic);
        Assert.assertEquals("aOtos", topic);
    }

    @Test(timeout = 10000)
    public void testIngestMonitoringData_add1526_literalMutationString1618_add1666() throws Exception {
        List<MonitoringData> dataList = createMonitoringDataList();
        Date o_testIngestMonitoringData_add1526_literalMutationString1618_add1666__3 = Calendar.getInstance().getTime();
        Assert.assertEquals(118, ((int) (((java.util.Date)o_testIngestMonitoringData_add1526_literalMutationString1618_add1666__3).getYear())));
        Assert.assertEquals(-120, ((int) (((java.util.Date)o_testIngestMonitoringData_add1526_literalMutationString1618_add1666__3).getTimezoneOffset())));
        Assert.assertEquals(4, ((int) (((java.util.Date)o_testIngestMonitoringData_add1526_literalMutationString1618_add1666__3).getMonth())));
        Assert.assertEquals(4, ((int) (((java.util.Date)o_testIngestMonitoringData_add1526_literalMutationString1618_add1666__3).getDay())));
        Assert.assertEquals(12, ((int) (((java.util.Date)o_testIngestMonitoringData_add1526_literalMutationString1618_add1666__3).getHours())));
        Assert.assertEquals(4, ((int) (((java.util.Date)o_testIngestMonitoringData_add1526_literalMutationString1618_add1666__3).getMinutes())));
        Assert.assertEquals(10, ((int) (((java.util.Date)o_testIngestMonitoringData_add1526_literalMutationString1618_add1666__3).getDate())));
        String timeStamp = Calendar.getInstance().getTime().toString();
        int outputId = 2;
        int confId = 3;
        String topic = "aOtos";
        Assert.assertEquals("aOtos", topic);
        AmplDataProviderProxyTest.proxy.ingestMonitoringData(dataList, timeStamp, outputId, confId, topic);
        AmplDataProviderProxyTest.proxy.ingestMonitoringData(dataList, timeStamp, outputId, confId, topic);
        Assert.assertEquals("aOtos", topic);
    }
}

