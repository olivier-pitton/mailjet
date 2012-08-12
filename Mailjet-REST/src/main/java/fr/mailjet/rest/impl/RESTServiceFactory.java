package fr.mailjet.rest.impl;/*
 * 
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


import com.sun.jersey.api.client.Client;import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;import fr.mailjet.context.MailjetContext;import fr.mailjet.rest.ApiRESTService;import fr.mailjet.rest.ContactRESTService;import fr.mailjet.rest.HelpRESTService;import fr.mailjet.rest.ListsRESTService;import fr.mailjet.rest.MessageRESTService;import fr.mailjet.rest.ReportRESTService;import fr.mailjet.rest.UserRESTService;
/**
 * La factory de création de tous les services. 
 * @author Pitton Olivier
 *
 */
public class RESTServiceFactory {

	/**
	 * Le contexte de la factory
	 */
	private MailjetContext _context;
	
	/**
	 * Constructeur
	 * @param parContext {@link MailjetContext} le contexte à passer à chaque service REST
	 * @throws IllegalArgumentException Si le contexte spécifié est null
	 */
	public RESTServiceFactory(MailjetContext parContext) throws IllegalArgumentException {
		if(parContext == null) throw new IllegalArgumentException();
		
		_context = parContext;
	}		/**	 * Constructeur	 * @param parApiKey {@link String} La clé publique du compte	 * @param parSecretKey {@link String} La clé secrète du compte	 * @see #RESTServiceFactory(MailjetContext) 	 */	public RESTServiceFactory(String parApiKey, String parSecretKey) {		this(new MailjetContext(parApiKey, parSecretKey));	}
	
	/**
	 * Crée un service utilisateur
	 * @return {@link UserRESTService} un service utilisateur
	 */
	public UserRESTService createUserService() {
		return new UserRESTServiceImpl(_context, createClient());
	}
	
	/**
	 * Crée un service api
	 * @return {@link ApiRESTService} un service api
	 */
	public ApiRESTService createApiService() {
		return new ApiRESTServiceImpl(_context, createClient());
	}
	
	/**
	 * Crée un service message
	 * @return {@link MessageRESTService} un service message
	 */
	public MessageRESTService createMessageService() {
		return new MessageRESTServiceImpl(_context, createClient());
	}
  
  /**
   * Crée un service contact
   * @return {@link ContactRESTService} un service contact
   */
  public ContactRESTService createContactService() {
    return new ContactRESTServiceImpl(_context, createClient());
  }
	/**	 * Crée un service lists	 * 	 * @return {@link ListsRESTService} un service lists	 */	public ListsRESTService createListsService() {		return new ListsRESTServiceImpl(_context, createClient());	}
  /**   * Crée un service report   * @return {@link ListsRESTService} un service report   */  public ReportRESTService createReportService() {    return new ReportRESTServiceImpl(_context, createClient());  }  /**   * Crée un service help   * @return {@link HelpRESTService} un service help   */  public HelpRESTService createHelpService() {    return new HelpRESTServiceImpl(_context, createClient());  }
	/**
	 * Crée un nouveau {@link Client} et le configure 
	 * @return {@link Client} un nouveau client
	 */
	protected Client createClient() {
		Client locClient = Client.create();
		locClient.addFilter(new HTTPBasicAuthFilter(_context.getApiKey(), _context.getSecretKey()));		return locClient;
	}	/**	 * {@inheritDoc}	 */	@Override	public int hashCode() {		final int prime = 31;		int result = 1;		result = prime * result + ((this._context == null) ? 0 : this._context.hashCode());		return result;	}	/**	 * {@inheritDoc}	 */	@Override	public boolean equals(Object obj) {		if (this == obj)			return true;		if (obj == null)			return false;		if (!(obj instanceof RESTServiceFactory))			return false;		RESTServiceFactory other = (RESTServiceFactory) obj;		if (this._context == null) {			if (other._context != null)				return false;		} else if (!this._context.equals(other._context))			return false;		return true;	}
}
