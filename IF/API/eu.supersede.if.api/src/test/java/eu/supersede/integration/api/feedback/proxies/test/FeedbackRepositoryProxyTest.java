/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.integration.api.feedback.proxies.test;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.supersede.integration.api.feedback.proxies.FeedbackRepositoryProxy;
import eu.supersede.integration.api.feedback.repository.types.AttachmentFeedback;
import eu.supersede.integration.api.feedback.repository.types.AudioFeedback;
import eu.supersede.integration.api.feedback.repository.types.ContextInformation;
import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.api.feedback.repository.types.ScreenshotFeedback;
import eu.supersede.integration.api.feedback.repository.types.TextFeedback;

public class FeedbackRepositoryProxyTest {
	private static final Logger log = LoggerFactory.getLogger(FeedbackRepositoryProxyTest.class);
	private static FeedbackRepositoryProxy<Object, Object> proxy;
	private Integer applicationId = 1;
	private Integer feedbackId = 6341;
	private String userId = "u8102390";
	
    @BeforeClass
    public static void setup() throws Exception {
    	String user = "super_admin";
    	String password = "password";
        proxy = new FeedbackRepositoryProxy<Object, Object>(user, password);
    }

    @Test
    public void testGetFeedbacksForApplication() throws Exception{
    	List<Feedback> result = proxy.getFeedbacksForApplication(applicationId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetFeedbacksForApplicationWithOrchestratorConfiguration() throws Exception{
    	List<Feedback> result = proxy.getFeedbacksForApplicationWithOrchestratorConfiguration(applicationId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetFeedbacksForApplicationByUser() throws Exception{
    	List<Feedback> result = proxy.getFeedbacksForApplicationByUser(applicationId, userId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetFeedbackForApplication() throws Exception{
    	Feedback result = proxy.getFeedbackForApplication(feedbackId, applicationId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testCreateFeedbackForApplication() throws Exception{
    	Feedback result = createFeedbackForApplication();
    	Assert.notNull(result);
    }
    
    public <T> String convertToJSON(T object) throws JsonProcessingException {
		return proxy.convertToJSON(object);
	}
    
	private Feedback createFeedbackForApplication() throws Exception {
		Feedback feedback = createFeedback();
    	Map<String, Path> attachments = new HashMap<>();
    	attachments.put("attachment1", FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt"));
    	attachments.put("attachment2", FileSystems.getDefault().getPath("src/test/resources/files", "attachment2.txt"));
    	Map<String, Path> screenshots = new HashMap<>();
    	screenshots.put("screenshot1", FileSystems.getDefault().getPath("src/test/resources/files", "supersede_screenshot1.png"));
//    	screenshots.put("screenshot2", FileSystems.getDefault().getPath("src/test/resources/files", "supersede_screenshot2.png"));
    	Map<String, Path> audios = new HashMap<>();
    	audios.put("audio1", FileSystems.getDefault().getPath("src/test/resources/files", "track.mp3"));
		Feedback result = 
			proxy.createFeedbackForApplication(feedback, attachments, screenshots, audios, applicationId);
		return result;
	}
    
	private Feedback createFeedback(){
		Feedback feedback = new Feedback("New Feedback", userId, 1, 11, "en");
        feedback.setTextFeedbacks(new ArrayList<TextFeedback>(){{
            add(new TextFeedback("Text Feedback 1", 1));
            add(new TextFeedback("info@example.com", 2));
        }});
        feedback.setContextInformation(new ContextInformation(
        		"1920x1080", 
        		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", 
        		"5.0", new Date(), "+0200", 2.0f, "CH", "ZH", 
        		"http://example.com/subpage1", "{\"diagram\": \"diagramX2\"}"));
        feedback.setAttachmentFeedbacks(new ArrayList<AttachmentFeedback>(){{
            add(new AttachmentFeedback("attachment1", 3));
            add(new AttachmentFeedback("attachment2", 3));
        }});
        feedback.setScreenshotFeedbacks(new ArrayList<ScreenshotFeedback>(){{
            add(new ScreenshotFeedback("screenshot1", 4, null));
        }});
        feedback.setAudioFeedbacks(new ArrayList<AudioFeedback>(){{
            add(new AudioFeedback(4L, 2));
        }});
        
        return feedback;
	}
	

   
    
    @Test
    public void testDownloadAttachment() throws Exception{
    	//Upload Attachment
//    	Feedback feedback = createFeedbackForApplication();
//    	Assert.notNull(feedback);
//
//    	String feedbackPath = feedback.getAttachmentFeedbacks().get(0).getPath();
//		byte[] result = proxy.downloadAttachment(feedbackPath.substring(feedbackPath.lastIndexOf("/") + 1), applicationId);
    	String attachmentName = "57377_1508862074050.txt";
    	byte[] result = proxy.downloadAttachment(attachmentName, applicationId);
    	Assert.isTrue(result.length > 0);
    	Path path = Paths.get("attachment.att");
        Files.write(path, result);
    }
    
    @Test
    public void testDownloadScreenshot() throws Exception{
    	//Upload Screeenshot
//    	Feedback feedback = createFeedbackForApplication();
//    	Assert.notNull(feedback);
//
//    	String feedbackPath = feedback.getScreenshotFeedbacks().get(0).getPath();
    	
//		byte[] result = proxy.downloadScreenshot(feedbackPath.substring(feedbackPath.lastIndexOf("/") + 1), applicationId);
    	String screenshotName = "21794_1508918809103.png";
    	byte[] result = proxy.downloadScreenshot(screenshotName, applicationId);
    	Assert.isTrue(result.length > 0);
    	Path path = Paths.get("screenshot.png");
        Files.write(path, result);
    }
    
    @Test
    public void testDownloadAudio() throws Exception{
    	//Upload Audio
//    	Feedback feedback = createFeedbackForApplication();
//    	Assert.notNull(feedback);
//
//    	String feedbackPath = feedback.getAudioFeedbacks().get(0).getPath();
//    	
//		byte[] result = proxy.downloadAudio(feedbackPath.substring(feedbackPath.lastIndexOf("/") + 1), applicationId);
    	String audioName = "535533_1508250908348.mp3";
    	byte[] result = proxy.downloadAudio(audioName, applicationId);
    	Assert.isTrue(result.length > 0);
    	Path path = Paths.get("audio.mp3");
        Files.write(path, result);
    }
   
}
