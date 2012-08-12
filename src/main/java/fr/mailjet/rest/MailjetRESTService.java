package fr.mailjet.rest;/*
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


import java.io.Closeable;

import fr.mailjet.context.MailjetContext;

/**
 * L'interface de tous les services Mailjet. Ces services sont décomposés tels que décrit par la
 * documentation officielle.
 * <a href="http://fr.mailjet.com/docs/api">Documentation</a>
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public interface MailjetRESTService extends Closeable {

	/**
	 * Retourne le contexte courant par le biais duquel 
	 * le service se conencte et s'authentifie.
	 * @return {@link MailjetContext} le contexte courant
	 */
	MailjetContext getContext();
	
	/**
	 * Modifie le contexte courant du service.
	 * @param parContext {@link MailjetContext} le nouveau contexte
	 */
	void setContext(final MailjetContext parContext);
	
	/**
	 * {@inheritDoc}
	 */
  @Override
	void close();
	
}
