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

public interface IFeedbackRepository {
	String authenticate(String user, String password) throws Exception;
	public List<Feedback> getAllFeedbacksForApplication(Integer idApplication, String token) throws Exception;
//	public List<Feedback> getAllFeedbacksForApplication(Integer applicationId) throws Exception;
	public Feedback getFeedbackForApplication(Integer idFeedback, Integer idApplication, String token) throws Exception;
	public Feedback createFeedbackForApplication(
			Feedback feedback, Map<String, Path> attachmentsPaths, 
			Map<String, Path> screenshotsPaths, Map<String, Path> audiosPaths, 
			Integer idApplication, String token) throws Exception;
//	public void deleteFeedback(Integer id) throws Exception;
	public byte[] downloadAttachement (String attachmentName, String token) throws Exception;
	public byte[] downloadScreenshot (String screenshotName, String token) throws Exception;
	public byte[] downloadAudio (String audioName, String token) throws Exception;
}
