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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.proxies.FeedbackRepositoryProxy;
import eu.supersede.integration.api.feedback.repository.types.AttachmentFeedback;
import eu.supersede.integration.api.feedback.repository.types.AudioFeedback;
import eu.supersede.integration.api.feedback.repository.types.CategoryFeedback;
import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.api.feedback.repository.types.RatingFeedback;
import eu.supersede.integration.api.feedback.repository.types.ScreenshotFeedback;
import eu.supersede.integration.api.feedback.repository.types.Status;
import eu.supersede.integration.api.feedback.repository.types.StatusOption;
import eu.supersede.integration.api.feedback.repository.types.TextAnnotation;
import eu.supersede.integration.api.feedback.repository.types.TextFeedback;
import eu.supersede.integration.api.feedback.types.ApiUser;
import eu.supersede.integration.api.feedback.types.ApiUserPermission;
import eu.supersede.integration.api.feedback.types.UserRole;

public class FeedbackRepositoryProxyTest {
	private static final Logger log = LoggerFactory.getLogger(FeedbackRepositoryProxyTest.class);
	private static FeedbackRepositoryProxy<Object, Object> proxy;
	private Integer applicationId = 1;
	private Integer feedbackId = 69;
	private String userId = "u8102390";
	
    @BeforeClass
    public static void setup() throws Exception {
    	String user = "superadmin";
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
    
    @Ignore @Test
    public void testCreateFeedbackForApplication() throws Exception{
    	Feedback result = createFeedbackForApplication();
    	Assert.notNull(result);
    }

	private Feedback createFeedbackForApplication() throws Exception {
		Feedback feedback = createFeedback();
    	Map<String, Path> attachments = new HashMap<>();
//    	attachments.put("attachment1", FileSystems.getDefault().getPath("src/test/resources/files", "attachment1.txt"));
//    	attachments.put("attachment2", FileSystems.getDefault().getPath("src/test/resources/files", "attachment2.txt"));
    	Map<String, Path> screenshots = new HashMap<>();
//    	screenshots.put("screenshot1", FileSystems.getDefault().getPath("src/test/resources/files", "supersede_screenshot1.png"));
//    	screenshots.put("screenshot2", FileSystems.getDefault().getPath("src/test/resources/files", "supersede_screenshot2.png"));
    	Map<String, Path> audios = new HashMap<>();
//    	audios.put("audio1", FileSystems.getDefault().getPath("src/test/resources/files", "track.mp3"));
		Feedback result = 
			proxy.createFeedbackForApplication(feedback, attachments, screenshots, audios, applicationId);
		return result;
	}
    
    private Feedback createFeedback(){
    	//Feedback
    	Feedback feedback = new Feedback ();
    	feedback.setTitle("test_feedback");
    	feedback.setUserIdentification("u8102390");
    	feedback.setLanguage("EN");
    	feedback.setApplicationId(1);
    	feedback.setConfigurationId(1);
    	
    	//Text Feedbacks
    	List<TextFeedback> textFeedbacks = new ArrayList<>();
    	TextFeedback tf = new TextFeedback();
    	tf.setText("This is the feedback text");
    	tf.setMechanismId(1);
    	textFeedbacks.add(tf);
    	feedback.setTextFeedbacks(textFeedbacks);
    	
    	//Rating feedbacks
//    	List<RatingFeedback> ratingFeedbacks = new ArrayList<>();
//    	RatingFeedback rf = new RatingFeedback();
//    	rf.setTitle("Test rating");
//    	rf.setRating(4);
//    	rf.setMechanismId(5);
//    	ratingFeedbacks.add(rf);
//    	feedback.setRatingFeedbacks(ratingFeedbacks);
    	
    	//Screenshot feedbacks
//    	List<ScreenshotFeedback> screenshotFeedbacks = new ArrayList<>();
    	
//    	ScreenshotFeedback ssf1 = new ScreenshotFeedback();
//    	ssf1.setMechanismId(9);
//    	ssf1.setFileExtension("png");
//    	ssf1.setPart("screenshot1");
//    	List<TextAnnotation> textAnnotations = new ArrayList<>();
//    	TextAnnotation ta = new TextAnnotation();
//    	ta.setReferenceNumber(1);
//    	ta.setText("Too big");
//    	textAnnotations.add (ta);
//    	ssf1.setTextAnnotations(textAnnotations);
//    	screenshotFeedbacks.add(ssf1);
//    	
//    	ScreenshotFeedback ssf2 = new ScreenshotFeedback();
//    	ssf2.setMechanismId(9);
//    	ssf2.setFileExtension("png");
//    	ssf2.setPart("screenshot2");
//    	screenshotFeedbacks.add(ssf2);
//    	
//    	feedback.setScreenshotFeedbacks(screenshotFeedbacks);
    	
		//Attachment feedbacks
//    	List<AttachmentFeedback> attachmentFeedbacks = new ArrayList<>();
//    	 
//    	AttachmentFeedback af1 = new AttachmentFeedback();
//    	af1.setMechanismId(10);
//    	af1.setFileExtension("txt");
//    	af1.setPart("attachment1");
//    	attachmentFeedbacks.add(af1);
//    	
//    	AttachmentFeedback af2 = new AttachmentFeedback();
//    	af2.setMechanismId(10);
//    	af2.setFileExtension("txt");
//    	af2.setPart("attachment2");
//    	attachmentFeedbacks.add(af2);
//    	
//    	feedback.setAttachmentFeedbacks(attachmentFeedbacks);
    	
    	//Audio feedbacks
    	
//    	List<AudioFeedback> audioFeedbacks = new ArrayList<>();
//    	AudioFeedback auf = new AudioFeedback();
//    	auf.setMechanismId(11);
//    	auf.setFileExtension("mp3");
//    	auf.setPart("audio1");
//    	audioFeedbacks.add(auf);
//		feedback.setAudioFeedbacks(audioFeedbacks );
//    	
//		//Category feedbacks
//		List<CategoryFeedback> categoryFeedbacks = new ArrayList<>();
//		CategoryFeedback cf = new CategoryFeedback();
//		cf.setText("sample text");
//		categoryFeedbacks.add(cf);
//		feedback.setCategoryFeedbacks(categoryFeedbacks);
    	
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
    	Assert.notNull(result);
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
    	Assert.notNull(result);
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
    	Assert.notNull(result);
    	Path path = Paths.get("audio.mp3");
        Files.write(path, result);
    }
   
}
