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

import org.junit.Before;
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
	private FeedbackRepositoryProxy proxy;
	private String token;
	private Integer applicationId = 1;
	private Integer feedbackId = 69;
	private Integer userId = 1;
	
    @Before
    public void setup() throws Exception {
        proxy = new FeedbackRepositoryProxy();
        String user = "api_user";
    	String password = "password";
    	token = proxy.authenticate(user, password);
    }

    @Test
    public void testListAllFeedbacksForApplication() throws Exception{
    	List<Feedback> result = proxy.listAllFeedbacksForApplication(applicationId, token);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetFeedbackForApplication() throws Exception{
    	Feedback result = proxy.getFeedbackForApplication(feedbackId, applicationId, token);
    	Assert.notNull(result);
    }
    
    @Test
    public void testCreateFeedbackForApplication() throws Exception{
    	Feedback feedback = createFeedback();
    	Map<String, Path> attachments = new HashMap<>();
    	attachments.put("attachment1", FileSystems.getDefault().getPath("src/test/resources/files", "attachment1.txt"));
    	attachments.put("attachment2", FileSystems.getDefault().getPath("src/test/resources/files", "attachment2.txt"));
    	Map<String, Path> screenshots = new HashMap<>();
    	screenshots.put("screenshot1", FileSystems.getDefault().getPath("src/test/resources/files", "supersede_screenshot1.png"));
    	screenshots.put("screenshot2", FileSystems.getDefault().getPath("src/test/resources/files", "supersede_screenshot2.png"));
    	Map<String, Path> audios = new HashMap<>();
    	audios.put("audio1", FileSystems.getDefault().getPath("src/test/resources/files", "track.mp3"));
		Feedback result = 
			proxy.createFeedbackForApplication(feedback, attachments, screenshots, audios, applicationId, token);
    	Assert.notNull(result);
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
    	List<RatingFeedback> ratingFeedbacks = new ArrayList<>();
    	RatingFeedback rf = new RatingFeedback();
    	rf.setTitle("Test rating");
    	rf.setRating(4);
    	rf.setMechanismId(5);
    	ratingFeedbacks.add(rf);
    	feedback.setRatings(ratingFeedbacks);
    	
    	//Screenshot feedbacks
    	List<ScreenshotFeedback> screenshotFeedbacks = new ArrayList<>();
    	
    	ScreenshotFeedback ssf1 = new ScreenshotFeedback();
    	ssf1.setMechanismId(9);
    	ssf1.setName("annotatedImage1");
    	ssf1.setFileExtension("png");
    	ssf1.setPart("screenshot1");
    	List<TextAnnotation> textAnnotations = new ArrayList<>();
    	TextAnnotation ta = new TextAnnotation();
    	ta.setReferenceNumber(1);
    	ta.setText("Too big");
    	textAnnotations.add (ta);
    	ssf1.setTextAnnotations(textAnnotations);
    	screenshotFeedbacks.add(ssf1);
    	
    	ScreenshotFeedback ssf2 = new ScreenshotFeedback();
    	ssf2.setMechanismId(9);
    	ssf2.setName("annotatedImage2");
    	ssf2.setFileExtension("png");
    	ssf2.setPart("screenshot2");
    	screenshotFeedbacks.add(ssf2);
    	
    	feedback.setScreenshots(screenshotFeedbacks);
    	
		//Attachment feedbacks
    	List<AttachmentFeedback> attachmentFeedbacks = new ArrayList<>();
    	 
    	AttachmentFeedback af1 = new AttachmentFeedback();
    	af1.setMechanismId(10);
    	af1.setName("attachment1");
    	af1.setFileExtension("txt");
    	af1.setPart("attachment1");
    	attachmentFeedbacks.add(af1);
    	
    	AttachmentFeedback af2 = new AttachmentFeedback();
    	af2.setMechanismId(10);
    	af2.setName("attachment2");
    	af2.setFileExtension("txt");
    	af2.setPart("attachment2");
    	attachmentFeedbacks.add(af2);
    	
    	feedback.setAttachmentFeedbacks(attachmentFeedbacks);
    	
    	//Audio feedbacks
    	
    	List<AudioFeedback> audioFeedbacks = new ArrayList<>();
    	AudioFeedback auf = new AudioFeedback();
    	auf.setMechanismId(11);
    	auf.setName("audio1");
    	auf.setFileExtension("mp3");
    	auf.setPart("audio1");
    	audioFeedbacks.add(auf);
		feedback.setAudioFeedbacks(audioFeedbacks );
    	
		//Category feedbacks
		List<CategoryFeedback> categoryFeedbacks = new ArrayList<>();
		CategoryFeedback cf = new CategoryFeedback();
		cf.setParameterId(12);
		cf.setText("sample text");
		categoryFeedbacks.add(cf);
		feedback.setCategoryFeedbacks(categoryFeedbacks);
    	
		return feedback;
    }
   
    
    @Test
    public void testDownloadAttachment() throws Exception{
		byte[] result = proxy.downloadAttachement("57377_1478098152653.txt", token);
    	Assert.notNull(result);
    	Path path = Paths.get("attachment.att");
        Files.write(path, result);
    }
    
    @Test
    public void testDownloadScreenshot() throws Exception{
		byte[] result = proxy.downloadScreenshot("55684_1478181811604.jpeg", token, false);
    	Assert.notNull(result);
    	Path path = Paths.get("screenshot.png");
        Files.write(path, result);
    }
    
    @Test
    public void testDownloadScreenshotAsBase64() throws Exception{
		byte[] result = proxy.downloadScreenshot("55684_1478181811604.jpeg", token, true);
    	Assert.notNull(result);
    	Path path = Paths.get("screenshot.png");
        Files.write(path, result);
    }
    
    @Test
    public void testDownloadAudio() throws Exception{
		byte[] result = proxy.downloadAudio("535533_1478181811605.mp3", token);
    	Assert.notNull(result);
    	Path path = Paths.get("audio.mp3");
        Files.write(path, result);
    }
    

    @Test
    public void testListAllApiUsers() throws Exception{
    	List<ApiUser> result = proxy.listAllAPIUsers();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testApiUser() throws Exception{
    	ApiUser user = testCreateApiUser();
    	testGetApiUser (user);
    	testUpdateApiUser(user);
    	testDeleteApiUser(user);
    }
    
    public ApiUser testCreateApiUser() throws Exception{
    	ApiUser user = new ApiUser();
    	user.setName("user_test");
    	user.setPassword("password");
    	user.setRole(UserRole.ADMIN);
		ApiUser result = proxy.createAPIUser(user);
    	Assert.notNull(result);
    	return result;
    }
    
    public void testUpdateApiUser(ApiUser user){
    	user.setName("user_test_modified");
    	user.setPassword("password");
    	user.setRole(UserRole.USER);
		ApiUser result;
		try {
			result = proxy.updateAPIUser(user, token);
			Assert.notNull(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testGetApiUser(ApiUser user) throws Exception{
		ApiUser result = proxy.getAPIUser(user.getId());
		Assert.notNull(result);
    }
    
    public void testDeleteApiUser(ApiUser user) throws Exception{
		proxy.deleteAPIUser(user.getId(), token);
    }
    
    @Test
    public void testListApplicationPermissionsOfApiUser() throws Exception{
    	List<ApiUserPermission> result = proxy.listApplicationPermissionsOfApiUser(userId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testApplicationPermissionOfApiUser() throws Exception{
    	ApiUserPermission permission = testCreateApplicationPermissionOfApiUser();
    	testDeleteApplicationPermissionOfApiUser(permission);
    }
    
    public ApiUserPermission testCreateApplicationPermissionOfApiUser() throws Exception{
    	ApiUserPermission permission = new ApiUserPermission();
    	permission.setApplicationId(applicationId);
    	permission.setHasPermission(true);
		permission = proxy.createApplicationPermissionOfApiUser(permission , userId, token);
    	Assert.notNull(permission);
    	return permission;
    }
    
    public void testDeleteApplicationPermissionOfApiUser(ApiUserPermission permission) throws Exception{
		proxy.deleteApplicationPermissionsOfApiUser(permission.getId(), token);
    }
    
    @Test
    public void testGetGeneralStatusOfFeedbackInApplication() throws Exception{
    	Status result = proxy.getGeneralStatusOfFeedbackInApplication (feedbackId, applicationId, token);
    	Assert.notNull(result);
    }
    			
    @Test
    public void testGetUserSpecificStatusOfFeedbackInApplication() throws Exception{
    	Status result = proxy.getUserSpecificStatusOfFeedbackInApplication (feedbackId,  applicationId,  userId, token);
    	Assert.notNull(result);
    }
    
    @Test
    public void testListAllUserSpecificStatusOfFeedbackInApplication()throws Exception{
    	List<Status> result = proxy.listAllUserSpecificStatusOfFeedbackInApplication (applicationId,  userId, token);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testDeleteFeedbackStatusInApplication () throws Exception{
    	List<Status> result = proxy.listAllUserSpecificStatusOfFeedbackInApplication (applicationId,  userId, token);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    	Status status = result.get(result.size()-1);
    	proxy.deleteFeedbackStatusInApplication (applicationId,  status.getId(),  token);
    }
    
    @Test
    public void testUpdateFeedbackStatusInApplication() throws Exception{
    	List<Status> list = proxy.listAllUserSpecificStatusOfFeedbackInApplication (applicationId,  userId, token);
    	Assert.notNull(list);
    	Assert.isTrue(!list.isEmpty());
    	Status status = list.get(list.size()-1);
    	status.setStatus("approved");
    	Status result = proxy.updateFeedbackStatusInApplication (status, applicationId, token);
    	Assert.notNull(result);
    }
    
    @Test
    public void testListAllStatusOptions() throws Exception{
    	List<StatusOption> result = proxy.listAllStatusOptions();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testStatusOption() throws Exception{
    	StatusOption statusOption = testCreateStatusOption();
    	statusOption = testUpdateStatusOption (statusOption);
    	testDeleteStatusOption(statusOption.getId());
    }
    
    
    public StatusOption testCreateStatusOption() throws Exception{
    	StatusOption statusOption = new StatusOption();
    	statusOption.setName("new status");
    	statusOption.setOrder(3);
    	statusOption.setUserSpecific(false);
		StatusOption result = proxy.createStatusOption(statusOption , token);
		Assert.notNull(result);
		return result;
    }
    
    
    public StatusOption testUpdateStatusOption(StatusOption statusOption) throws Exception{
    	StatusOption result = proxy.updateStatusOption(statusOption, token);
    	Assert.notNull(result);
    	return result;
    }
    
    public void testDeleteStatusOption(Integer idStatusOption) throws Exception{
    	proxy.deleteStatusOption(idStatusOption, token);
    }

}
