package eu.supersede.integration.api.feedback.proxies.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.proxies.FeedbackRepositoryProxy;
import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.api.feedback.repository.types.TextFeedback;

public class FeedbackRepositoryProxyTest {
	private static final Logger log = LoggerFactory.getLogger(FeedbackRepositoryProxyTest.class);
	private FeedbackRepositoryProxy proxy;
	
	
    @Before
    public void setup() throws Exception {
        proxy = new FeedbackRepositoryProxy();
    }

    @Test
    public void testGetAllFeedbacks() throws Exception{
    	List<Feedback> result = proxy.GetAllFeedbacks();
    	Assert.notNull(result);
//    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testInsertFeedback() throws Exception{
    	Feedback feedback = createFeedback();
		Feedback result = proxy.InsertFeedback(feedback);
    	Assert.notNull(result);
    }
    
    private Feedback createFeedback(){
    	Feedback feedback = new Feedback ();
    	feedback.setTitle("Feedback test");
    	feedback.setUserIdentification("u8102390");
    	feedback.setLanguage("EN");
    	feedback.setApplicationId(1);
    	feedback.setConfigurationId(77);
    	List<TextFeedback> textFeedbacks = new ArrayList<>();
    	TextFeedback tf = new TextFeedback();
    	tf.setText("This is the feedback text");
    	tf.setMechanismId(1);
    	textFeedbacks.add(tf);
    	feedback.setTextFeedbacks(textFeedbacks);
		return feedback;
    }
}
