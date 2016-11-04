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
package eu.supersede.integration.api.feedback.proxies;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.api.feedback.repository.types.Status;
import eu.supersede.integration.api.feedback.repository.types.StatusOption;
import eu.supersede.integration.api.feedback.types.ApiUser;
import eu.supersede.integration.api.feedback.types.ApiUserPermission;

public interface IFeedbackRepository {
	String authenticate(String user, String password) throws Exception;
	List<Feedback> listAllFeedbacksForApplication(Integer idApplication, String token) throws Exception;
//	public List<Feedback> getAllFeedbacksForApplication(Integer applicationId) throws Exception;
	Feedback getFeedbackForApplication(Integer idFeedback, Integer idApplication, String token) throws Exception;
	Feedback createFeedbackForApplication(
	Feedback feedback, Map<String, Path> attachmentsPaths, 
	Map<String, Path> screenshotsPaths, Map<String, Path> audiosPaths, 
	Integer idApplication, String token) throws Exception;
//	public void deleteFeedback(Integer id) throws Exception;
	byte[] downloadAttachement (String attachmentName, String token) throws Exception;
	byte[] downloadScreenshot (String screenshotName, String token, boolean base64) throws Exception;
	byte[] downloadAudio (String audioName, String token) throws Exception;
	
	List<ApiUser> listAllAPIUsers () throws Exception;
	ApiUser createAPIUser (ApiUser user) throws Exception;
	ApiUser updateAPIUser (ApiUser user, String token) throws Exception;
	ApiUser getAPIUser (Integer idUser) throws Exception;
	void deleteAPIUser (Integer idUser, String token) throws Exception;
	
	List<ApiUserPermission> listApplicationPermissionsOfApiUser (Integer userId) throws Exception;
	ApiUserPermission createApplicationPermissionOfApiUser (ApiUserPermission permission, Integer userId, String token) throws Exception;
	void deleteApplicationPermissionsOfApiUser (Integer permissionId, Integer userId) throws Exception;
	
	Status getGeneralStatusOfFeedbackInApplication (Integer idFeedback, Integer idApplication, String token) throws Exception;
	Status getUserSpecificStatusOfFeedbackInApplication (Integer idFeedback, Integer idApplication, Integer idUser, String token) throws Exception;
	List<Status> listAllUserSpecificStatusOfFeedbackInApplication (Integer idApplication, Integer idUser, String token) throws Exception;
	void deleteFeedbackStatusInApplication (Integer idApplication, Integer idStatus, String token) throws Exception;
	Status updateFeedbackStatusInApplication (Status status, Integer idApplication, String token) throws Exception;
	List<StatusOption> listAllStatusOptions() throws Exception; 
	StatusOption createStatusOption(StatusOption statusOption, String token) throws Exception; 
	StatusOption updateStatusOption(StatusOption statusOption, String token) throws Exception; 
	void deleteStatusOption(Integer idStatusOption, String token) throws Exception;
}
