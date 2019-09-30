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
	List<Feedback> getFeedbacksForApplication(Integer idApplication) throws Exception;
	List<Feedback> getFeedbacksForApplicationWithOrchestratorConfiguration(Integer idApplication) throws Exception;
	List<Feedback> getFeedbacksForApplicationByUser(Integer idApplication, String idUser) throws Exception;
	Feedback getFeedbackForApplication(Integer idFeedback, Integer idApplication) throws Exception;
	Feedback createFeedbackForApplication(
			Feedback feedback, Map<String, Path> attachmentsPaths, 
			Map<String, Path> screenshotsPaths, Map<String, Path> audiosPaths, 
			Integer idApplication) throws Exception;
	void deleteFeedback(Integer idApplication, Integer idFeedback) throws Exception;
	byte[] downloadAttachment (String attachmentName, Integer idApplication) throws Exception;
	byte[] downloadScreenshot (String screenshotName, Integer idApplication) throws Exception;
	byte[] downloadAudio (String audioName, Integer idApplication) throws Exception;
}
