package eu.supersede.integration.api.pubsub.test;


import eu.supersede.integration.api.pubsub.evolution.EvolutionAlertMessageListener;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import org.junit.Assert;
import org.junit.Test;
import org.mockejb.jms.TextMessageImpl;


public class EvolutionAlertMessageListenerTest {
    @Test(timeout = 30000)
    public void testParsingAlerts_add1() throws IOException, JMSException {
        EvolutionAlertMessageListener listener = new EvolutionAlertMessageListener();
        FileSystems.getDefault().getPath("src/test/resources/json", "alert1.json");
        Path path = FileSystems.getDefault().getPath("src/test/resources/json", "alert1.json");
        String json = new String(Files.readAllBytes(path));
        Assert.assertEquals("{\n\t\"id\": \"3a3ec253-95cb-470a-8fe1-8363beb96b4a\",\n\t\"applicationId\": \"Senercon Energy Management\",\n\t\"timestamp\": 1523477656657,\n\t\"tenant\": \"senercon\",\n\t\"conditions\": [\n\t\t{\n\t\t\t\"idMonitoredData\": \"UNSPECIFIED\",\n\t\t\t\"operator\": \"EQ\",\n\t\t\t\"value\": 1.0\n\t\t}\n\t],\n\t\"requests\": [\n\t\t{\n\t\t\t\"id\": \"89218b1d-7583-448e-8ba2-922e88ac4a07\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[DiagramFeedback, DiagramAction, Diagram, Navigation, Mobility, Tooltip, Visualization, Selection, Splitting] -  Hallo,im Diagramm Mobilit\u00e4t wird beim umstellen von Liter auf kWh trotzdem Liter angezeigt!\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t},\n\t\t{\n\t\t\t\"id\": \"7d17e402-a3fe-4c9b-80aa-013392f5dfb7\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[LogIn] -  Nach dem Login geht es leider nicht weiter!\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t},\n\t\t{\n\t\t\t\"id\": \"5d676362-4a6b-4f5d-bafc-6b1c8afe1975\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[DataAction, Restore, Delete, Edit, Data, Add, ClickMonitorData, Enter, Lose, Create] -  ES wird aus den Daten keine Grafik erzeugt.\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t}\n\t]\n}\n", json);
        TextMessage message = new TextMessageImpl(json);
        listener.onMessage(message);
        listener.onMessage(message);
        path = FileSystems.getDefault().getPath("src/test/resources/json", "alert2.json");
        json = new String(Files.readAllBytes(path));
        message = new TextMessageImpl(json);
    }

    @Test(timeout = 30000)
    public void testParsingAlerts_mg35() throws IOException, JMSException {
        EvolutionAlertMessageListener listener = new EvolutionAlertMessageListener();
        Path path = FileSystems.getDefault().getPath("src/test/resources/json", "alert1.json");
        String json = new String(Files.readAllBytes(path));
        Assert.assertEquals("{\n\t\"id\": \"3a3ec253-95cb-470a-8fe1-8363beb96b4a\",\n\t\"applicationId\": \"Senercon Energy Management\",\n\t\"timestamp\": 1523477656657,\n\t\"tenant\": \"senercon\",\n\t\"conditions\": [\n\t\t{\n\t\t\t\"idMonitoredData\": \"UNSPECIFIED\",\n\t\t\t\"operator\": \"EQ\",\n\t\t\t\"value\": 1.0\n\t\t}\n\t],\n\t\"requests\": [\n\t\t{\n\t\t\t\"id\": \"89218b1d-7583-448e-8ba2-922e88ac4a07\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[DiagramFeedback, DiagramAction, Diagram, Navigation, Mobility, Tooltip, Visualization, Selection, Splitting] -  Hallo,im Diagramm Mobilit\u00e4t wird beim umstellen von Liter auf kWh trotzdem Liter angezeigt!\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t},\n\t\t{\n\t\t\t\"id\": \"7d17e402-a3fe-4c9b-80aa-013392f5dfb7\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[LogIn] -  Nach dem Login geht es leider nicht weiter!\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t},\n\t\t{\n\t\t\t\"id\": \"5d676362-4a6b-4f5d-bafc-6b1c8afe1975\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[DataAction, Restore, Delete, Edit, Data, Add, ClickMonitorData, Enter, Lose, Create] -  ES wird aus den Daten keine Grafik erzeugt.\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t}\n\t]\n}\n", json);
        TextMessage message = new TextMessageImpl(json);
        listener.onMessage(message);
        listener.onMessage(message);
        path = FileSystems.getDefault().getPath("src/test/resources/json", "alert2.json");
        json = new String(Files.readAllBytes(path));
        message = new TextMessageImpl(json);
        boolean o_testParsingAlerts_mg35__23 = listener.areMessageReceived();
        Assert.assertTrue(o_testParsingAlerts_mg35__23);
    }

    @Test(timeout = 30000)
    public void testParsingAlertsnull102() throws IOException, JMSException {
        EvolutionAlertMessageListener listener = new EvolutionAlertMessageListener();
        Path path = FileSystems.getDefault().getPath("src/test/resources/json", "alert1.json");
        String json = new String(Files.readAllBytes(path));
        Assert.assertEquals("{\n\t\"id\": \"3a3ec253-95cb-470a-8fe1-8363beb96b4a\",\n\t\"applicationId\": \"Senercon Energy Management\",\n\t\"timestamp\": 1523477656657,\n\t\"tenant\": \"senercon\",\n\t\"conditions\": [\n\t\t{\n\t\t\t\"idMonitoredData\": \"UNSPECIFIED\",\n\t\t\t\"operator\": \"EQ\",\n\t\t\t\"value\": 1.0\n\t\t}\n\t],\n\t\"requests\": [\n\t\t{\n\t\t\t\"id\": \"89218b1d-7583-448e-8ba2-922e88ac4a07\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[DiagramFeedback, DiagramAction, Diagram, Navigation, Mobility, Tooltip, Visualization, Selection, Splitting] -  Hallo,im Diagramm Mobilit\u00e4t wird beim umstellen von Liter auf kWh trotzdem Liter angezeigt!\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t},\n\t\t{\n\t\t\t\"id\": \"7d17e402-a3fe-4c9b-80aa-013392f5dfb7\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[LogIn] -  Nach dem Login geht es leider nicht weiter!\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t},\n\t\t{\n\t\t\t\"id\": \"5d676362-4a6b-4f5d-bafc-6b1c8afe1975\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[DataAction, Restore, Delete, Edit, Data, Add, ClickMonitorData, Enter, Lose, Create] -  ES wird aus den Daten keine Grafik erzeugt.\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t}\n\t]\n}\n", json);
        TextMessage message = new TextMessageImpl(json);
        listener.onMessage(null);
        listener.onMessage(message);
        path = FileSystems.getDefault().getPath("src/test/resources/json", "alert2.json");
        json = new String(Files.readAllBytes(path));
        message = new TextMessageImpl(json);
    }

    @Test(timeout = 30000)
    public void testParsingAlerts_literalMutationString11_failAssert0() throws IOException, JMSException {
        try {
            EvolutionAlertMessageListener listener = new EvolutionAlertMessageListener();
            Path path = FileSystems.getDefault().getPath("", "alert1.json");
            String json = new String(Files.readAllBytes(path));
            TextMessage message = new TextMessageImpl(json);
            listener.onMessage(message);
            listener.onMessage(message);
            path = FileSystems.getDefault().getPath("src/test/resources/json", "alert2.json");
            json = new String(Files.readAllBytes(path));
            message = new TextMessageImpl(json);
            org.junit.Assert.fail("testParsingAlerts_literalMutationString11 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            Assert.assertEquals("alert1.json", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testParsingAlertslitString88_failAssert0() throws IOException, JMSException {
        try {
            EvolutionAlertMessageListener listener = new EvolutionAlertMessageListener();
            Path path = FileSystems.getDefault().getPath("src/test/resources/json", "alert1.json");
            String json = new String(Files.readAllBytes(path));
            TextMessage message = new TextMessageImpl(json);
            listener.onMessage(message);
            listener.onMessage(message);
            path = FileSystems.getDefault().getPath("p[$XdYQ7-#sa<}t>?]?7gch", "alert2.json");
            json = new String(Files.readAllBytes(path));
            message = new TextMessageImpl(json);
            org.junit.Assert.fail("testParsingAlertslitString88 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testParsingAlertsnull102_mg587() throws IOException, JMSException {
        EvolutionAlertMessageListener listener = new EvolutionAlertMessageListener();
        Path path = FileSystems.getDefault().getPath("src/test/resources/json", "alert1.json");
        String json = new String(Files.readAllBytes(path));
        Assert.assertEquals("{\n\t\"id\": \"3a3ec253-95cb-470a-8fe1-8363beb96b4a\",\n\t\"applicationId\": \"Senercon Energy Management\",\n\t\"timestamp\": 1523477656657,\n\t\"tenant\": \"senercon\",\n\t\"conditions\": [\n\t\t{\n\t\t\t\"idMonitoredData\": \"UNSPECIFIED\",\n\t\t\t\"operator\": \"EQ\",\n\t\t\t\"value\": 1.0\n\t\t}\n\t],\n\t\"requests\": [\n\t\t{\n\t\t\t\"id\": \"89218b1d-7583-448e-8ba2-922e88ac4a07\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[DiagramFeedback, DiagramAction, Diagram, Navigation, Mobility, Tooltip, Visualization, Selection, Splitting] -  Hallo,im Diagramm Mobilit\u00e4t wird beim umstellen von Liter auf kWh trotzdem Liter angezeigt!\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t},\n\t\t{\n\t\t\t\"id\": \"7d17e402-a3fe-4c9b-80aa-013392f5dfb7\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[LogIn] -  Nach dem Login geht es leider nicht weiter!\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t},\n\t\t{\n\t\t\t\"id\": \"5d676362-4a6b-4f5d-bafc-6b1c8afe1975\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[DataAction, Restore, Delete, Edit, Data, Add, ClickMonitorData, Enter, Lose, Create] -  ES wird aus den Daten keine Grafik erzeugt.\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t}\n\t]\n}\n", json);
        TextMessage message = new TextMessageImpl(json);
        listener.onMessage(null);
        listener.onMessage(message);
        path = FileSystems.getDefault().getPath("src/test/resources/json", "alert2.json");
        json = new String(Files.readAllBytes(path));
        message = new TextMessageImpl(json);
        boolean o_testParsingAlertsnull102_mg587__23 = listener.areMessageReceived();
        Assert.assertTrue(o_testParsingAlertsnull102_mg587__23);
    }

    @Test(timeout = 30000)
    public void testParsingAlertsnull102_add345_remove1324() throws IOException, JMSException {
        EvolutionAlertMessageListener listener = new EvolutionAlertMessageListener();
        FileSystems.getDefault().getPath("src/test/resources/json", "alert1.json");
        Path path = FileSystems.getDefault().getPath("src/test/resources/json", "alert1.json");
        String json = new String(Files.readAllBytes(path));
        Assert.assertEquals("{\n\t\"id\": \"3a3ec253-95cb-470a-8fe1-8363beb96b4a\",\n\t\"applicationId\": \"Senercon Energy Management\",\n\t\"timestamp\": 1523477656657,\n\t\"tenant\": \"senercon\",\n\t\"conditions\": [\n\t\t{\n\t\t\t\"idMonitoredData\": \"UNSPECIFIED\",\n\t\t\t\"operator\": \"EQ\",\n\t\t\t\"value\": 1.0\n\t\t}\n\t],\n\t\"requests\": [\n\t\t{\n\t\t\t\"id\": \"89218b1d-7583-448e-8ba2-922e88ac4a07\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[DiagramFeedback, DiagramAction, Diagram, Navigation, Mobility, Tooltip, Visualization, Selection, Splitting] -  Hallo,im Diagramm Mobilit\u00e4t wird beim umstellen von Liter auf kWh trotzdem Liter angezeigt!\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t},\n\t\t{\n\t\t\t\"id\": \"7d17e402-a3fe-4c9b-80aa-013392f5dfb7\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[LogIn] -  Nach dem Login geht es leider nicht weiter!\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t},\n\t\t{\n\t\t\t\"id\": \"5d676362-4a6b-4f5d-bafc-6b1c8afe1975\",\n\t\t\t\"classification\": \"BugFixRequest\",\n\t\t\t\"accuracy\": 100.0,\n\t\t\t\"description\": \"[DataAction, Restore, Delete, Edit, Data, Add, ClickMonitorData, Enter, Lose, Create] -  ES wird aus den Daten keine Grafik erzeugt.\",\n\t\t\t\"positiveSentiment\": 0,\n\t\t\t\"negativeSentiment\": 0,\n\t\t\t\"overallSentiment\": 0,\n\t\t\t\"feedbackIDs\": [],\n\t\t\t\"features\": []\n\t\t}\n\t]\n}\n", json);
        TextMessage message = new TextMessageImpl(json);
        listener.onMessage(null);
        path = FileSystems.getDefault().getPath("src/test/resources/json", "alert2.json");
        json = new String(Files.readAllBytes(path));
        message = new TextMessageImpl(json);
    }

    @Test(timeout = 30000)
    public void testParsingAlerts_mg35_add376litString1705() throws IOException, JMSException {
        EvolutionAlertMessageListener listener = new EvolutionAlertMessageListener();
        Path path = FileSystems.getDefault().getPath("src/test/resources/json", "alert.json");
        String json = new String(Files.readAllBytes(path));
        Assert.assertEquals("{\"level\":\"Normal\",\"id\":\"1\",\"message\":\"Message\",\"value\":10.0}\n", json);
        TextMessage message = new TextMessageImpl(json);
        listener.onMessage(message);
        listener.onMessage(message);
        path = FileSystems.getDefault().getPath("src/test/resources/json", "alert2.json");
        Files.readAllBytes(path);
        json = new String(Files.readAllBytes(path));
        message = new TextMessageImpl(json);
        boolean o_testParsingAlerts_mg35__23 = listener.areMessageReceived();
    }

    @Test(timeout = 30000)
    public void testParsingAlertsnull102_add345_literalMutationString1449_failAssert0() throws IOException, JMSException {
        try {
            EvolutionAlertMessageListener listener = new EvolutionAlertMessageListener();
            FileSystems.getDefault().getPath("src/test/resources/json", "alert1.json");
            Path path = FileSystems.getDefault().getPath("src/test/resources/json", "alert1.json");
            String json = new String(Files.readAllBytes(path));
            TextMessage message = new TextMessageImpl(json);
            listener.onMessage(null);
            listener.onMessage(message);
            path = FileSystems.getDefault().getPath("", "alert2.json");
            json = new String(Files.readAllBytes(path));
            message = new TextMessageImpl(json);
            org.junit.Assert.fail("testParsingAlertsnull102_add345_literalMutationString1449 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            Assert.assertEquals("alert2.json", expected.getMessage());
        }
    }
}

