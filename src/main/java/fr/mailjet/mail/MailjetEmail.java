package fr.mailjet.mail;/*
 * #%L
 * Mailjet
 * %%
 * Copyright (C) 2012 Pitton Olivier - olivier dot pitton at gmail dot com
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.apache.commons.mail.HtmlEmail;

import fr.mailjet.context.MailjetContext;

/**
 * Un simple {@link HtmlEmail} préconfiguré pour Mailjet. Par défaut, le SSL est configuré.
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public final class MailjetEmail extends HtmlEmail {
	
	/**
	 * Constructeur
	 * @param parContext {@link MailjetContext} un contexte mailjet
	 */
	public MailjetEmail(final MailjetContext parContext) {
		this.setAuthentication(parContext.getApiKey(), parContext.getSecretKey());
    final int locSmtpPort = parContext.getSmtpPort();
		this.setSmtpPort(locSmtpPort);
		this.setSSL(true);
		this.setSslSmtpPort(Integer.toString(locSmtpPort));
		this.setHostName(MailjetContext.getHostname());
	}
}
