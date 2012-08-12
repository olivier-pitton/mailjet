package fr.mailjet.rest.impl;/*
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


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.ApiRESTService;
import fr.mailjet.rest.ContactRESTService;
import fr.mailjet.rest.ListsRESTService;
import fr.mailjet.rest.MessageRESTService;
import fr.mailjet.rest.UserRESTService;

/**
 * La factory de création de tous les services. 
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public final class RESTServiceFactory {

	/**
	 * Le contexte de la factory
	 */
	private MailjetContext _context;
	
	/**
	 * Constructeur
	 * @param parContext {@link MailjetContext} le contexte à passer à chaque service REST
	 * @throws IllegalArgumentException Si le contexte spécifié est null
	 */
	public RESTServiceFactory(final MailjetContext parContext) throws IllegalArgumentException {
		if(parContext == null) throw new IllegalArgumentException();
		
		_context = parContext;
	}
	
	/**
	 * Crée un service utilisateur
	 * @return {@link UserRESTService} un service utilisateur
	 */
	public final UserRESTService createUserService() {
		return new UserRESTServiceImpl(_context, createClient());
	}
	
	/**
	 * Crée un service api
	 * @return {@link ApiRESTService} un service api
	 */
	public final ApiRESTService createApiService() {
		return new ApiRESTServiceImpl(_context, createClient());
	}
	
	/**
	 * Crée un service message
	 * @return {@link MessageRESTService} un service message
	 */
	public final MessageRESTService createMessageService() {
		return new MessageRESTServiceImpl(_context, createClient());
	}
  
  /**
   * Crée un service contact
   * @return {@link ContactRESTService} un service contact
   */
  public final ContactRESTService createContactService() {
    return new ContactRESTServiceImpl(_context, createClient());
  }
  /**
   * Crée un service lists
   * @return {@link ListsRESTService} un service lists
   */
  public final ListsRESTService createListsService() {
    return new ListsRESTServiceImpl(_context, createClient());
  }
	
	/**
	 * Crée un nouveau {@link Client} et le configure 
	 * @return {@link Client} un nouveau client
	 */
	protected final Client createClient() {
		final Client locClient = Client.create();
		locClient.addFilter(new HTTPBasicAuthFilter(_context.getApiKey(), _context.getSecretKey()));
		return locClient;
	}

}
