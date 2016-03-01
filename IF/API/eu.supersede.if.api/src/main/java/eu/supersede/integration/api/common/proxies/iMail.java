package eu.supersede.integration.api.common.proxies;

import eu.supersede.integration.api.common.types.Email;

public interface iMail {
	void sendEmail (Email email) throws Exception;
}
