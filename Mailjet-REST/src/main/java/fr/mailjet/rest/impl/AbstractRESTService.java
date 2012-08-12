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


import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;import com.sun.jersey.core.util.MultivaluedMapImpl;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.MailjetRESTService;
import fr.mailjet.rest.parameters.EnumReturnType;
/**
 * Une implémentation abstraite afin de factoriser le code standard à tous les services REST.
 * @author Pitton Olivier
 *
 */
public abstract class AbstractRESTService implements MailjetRESTService {

	/**
	 * Le paramètre de type de réponse 
	 * @see EnumReturnType
	 */
	static final private String OUTPUT = "output";

	/**
	 * Le contexte courant
	 */
	protected MailjetContext _context;

	/**
	 * Le client HTTP
	 */
	protected Client _client;	

	/**
	 * Constructeur
	 * @param parContext {@link MailjetContext} le contexte utilisé pour les appels aux Web Services.
	 * @param parClient {@link Client} le client utilisé pour se connecter au serveur distant.
	 */
	protected AbstractRESTService(MailjetContext parContext, Client parClient) {
		_context = parContext;
		_client = parClient;
	}
	/**	 * {@inheritDoc}	 */
	@Override
	public MailjetContext getContext() {
		return _context;
	}
	/**	 * {@inheritDoc}	 */
	@Override
	public void setContext(MailjetContext parContext) {
		_context = parContext;
	}
	/**	 * {@inheritDoc}	 */
	@Override
	public void close() {
		_context = null;
		_client.destroy();
	}		protected Integer toInteger(Boolean parValue) {		return (parValue.booleanValue()) ? 1 : 0;	}

	/**
	 * Crée une {@link MultivaluedMap} utilisé pour mettre les paramètres de la requête. La clé et la valeur
	 * correspondent respectivement à la clé et à la valeur de la requête.
	 * @param parType {@link EnumReturnType} le type de retour de la requête
	 * @return {@link MultivaluedMap} une map de tous les paramètres par défaut.	 * @throws NullPointerException Si le type de retour est null
	 * @see EnumReturnType
	 */
	protected MultivaluedMap<String, String> createHTTPProperties(EnumReturnType parType) {
		MultivaluedMap<String, String> locParameters = new MultivaluedMapImpl();		String locReturnType = parType.getConstName();		// On vide les éventuels anciens paramètres.		locParameters.clear();
		locParameters.putSingle(OUTPUT, locReturnType);		return locParameters;
	}

	/**
	 * Crée une requête GET et renvoie le résultat dans le type de retour spécifié.
	 * L'URL à spécifier correspond au chemin relatif, le contexte courant concatène cette valeur
	 * avec son URL. 
	 * @param parType {@link EnumReturnType} le type de retour de la requête
	 * @param parURL {@link String} l'URL où effectuer la requête.
	 * @return {@link String} le résultat de la requête GET dans le type de retour spécifié.
	 * @throws UniformInterfaceException Si l'URL est invalide et que la requête renvoie autre chose qu'un status 200 OK
	 * @throws NullPointerException Si le type de retour est null
	 * @throws IllegalArgumentException Si l'url est null ou vide.
	 * @see MailjetContext#getRestUrl()
	 */
	protected String createGETRequest(EnumReturnType parType, String parURL) throws UniformInterfaceException, NullPointerException, IllegalArgumentException {
		MultivaluedMap<String, String> locQueryParams = createHTTPProperties(parType);
		return createGETRequest(parURL, locQueryParams);
	}
	
	/**
	 * Crée une requête GET et renvoie le résultat dans le type de retour spécifié.
	 * L'URL à spécifier correspond au chemin relatif, le contexte courant concatène cette valeur
	 * avec son URL. Si l'URL est null, une exception est levée.
	 * @param parURL {@link String} l'url de la requête
	 * @param parParameters {@link MultivaluedMap} les paramètres de la requête devant au moins contenir 
	 * @return {@link String} la réponse du serveur
	 * @throws UniformInterfaceException Si l'URL est invalide et que la requête renvoie autre chose qu'un status 200 OK
	 * @throws NullPointerException Si les paramètres sont null
	 * @throws IllegalArgumentException Si l'url est null ou vide ou que le paramètre {@link #OUTPUT} n'est pas présent.	 * @see MailjetContext#getRestUrl()
	 */
	protected String createGETRequest(String parURL, MultivaluedMap<String,String> parParameters) throws UniformInterfaceException, IllegalArgumentException, NullPointerException {
		return sendRequest(parURL, parParameters, true);
	}		/**	 * Crée une requête POST et renvoie le résultat dans le type de retour spécifié.	 * L'URL à spécifier correspond au chemin relatif, le contexte courant concatène cette valeur	 * avec son URL. Si l'URL est null, une exception est levée. 	 * Les 2 paramètres clé / valeur peuvent être null.	 * @param parType {@link EnumReturnType} le format de réponse de la requête	 * @param parURL {@link String} l'url de la requête	 * @param parKey {@link String} la clé d'un paramètre. Peut être null.	 * @param parValue {@link String} la valeur associée à la clé spécifiée. Peut être null.	 * @return {@link String} la réponse du serveur	 * @throws UniformInterfaceException Si l'URL est invalide et que la requête renvoie autre chose qu'un status 200 OK	 * @throws NullPointerException Si le type de retour est null	 * @throws IllegalArgumentException Si l'url est null ou vide	 */	protected String createPOSTRequest(EnumReturnType parType, String parURL, String parKey, String parValue) throws UniformInterfaceException, IllegalArgumentException{		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);		if(parKey != null && parValue != null) {			locParameters.putSingle(parKey, parValue);		}		return createPOSTRequest(parURL, locParameters);	}		/**	 * Crée une requête POST et renvoie le résultat dans le type de retour spécifié.	 * L'URL à spécifier correspond au chemin relatif, le contexte courant concatène cette valeur	 * avec son URL. Si l'URL est null, une exception est levée.	 * @param parURL {@link String} l'url de la requête	 * @param parParameters {@link MultivaluedMap} les paramètres de la requête devant au moins contenir 	 * @return {@link String} la réponse du serveur	 * @throws UniformInterfaceException Si l'URL est invalide et que la requête renvoie autre chose qu'un status 200 OK	 * @throws NullPointerException Si les paramètres sont null	 * @throws IllegalArgumentException Si l'url est null ou vide ou que le paramètre {@link #OUTPUT} n'est pas présent	 * @see MailjetContext#getRestUrl()	 */	protected String createPOSTRequest(String parURL, MultivaluedMap<String, String> parParameters) throws UniformInterfaceException, IllegalArgumentException {		return sendRequest(parURL, parParameters, false);	}		private String sendRequest(String parURL, MultivaluedMap<String, String> parParameters, boolean parIsGetRequest) throws UniformInterfaceException, IllegalArgumentException {		if(parParameters.containsKey(OUTPUT) == false) {			throw new IllegalArgumentException(String.format("Le paramètre \"%s\" n'est pas spécifié.", OUTPUT));		} 		if(parURL == null || parURL.isEmpty()) {			throw new IllegalArgumentException("L'URL est null ou vide.");		}		WebResource locWebResource = _client.resource(MailjetContext.getRestUrl() + parURL).queryParams(parParameters);		return (parIsGetRequest == true) ? locWebResource.get(String.class) : locWebResource.post(String.class);	}
}
