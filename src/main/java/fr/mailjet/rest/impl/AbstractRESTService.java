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


import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;import com.sun.jersey.core.util.MultivaluedMapImpl;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.EnumReturnType;
import fr.mailjet.rest.MailjetRESTService;

/**
 * Une implémentation abstraite afin de factoriser le code standard à tous les services REST.
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
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
	final protected Client _client;	

	/**
	 * Constructeur
	 * @param parContext {@link MailjetContext} le contexte utilisé pour les appels aux Web Services.
	 * @param parClient {@link Client} le client utilisé pour se connecter au serveur distant.
	 */
	AbstractRESTService(final MailjetContext parContext, final Client parClient) {
		_context = parContext;
		_client = parClient;
	}

	@Override
	public MailjetContext getContext() {
		return _context;
	}

	@Override
	public void setContext(final MailjetContext parContext) {
		_context = parContext;
	}

	@Override
	public void close() {
		_context = null;
		_client.destroy();
	}

	/**
	 * Crée une {@link MultivaluedMap} utilisé pour mettre les paramètres de la requête. La clé et la valeur
	 * correspondent respectivement à la clé et à la valeur de la requête.
	 * @param parType {@link EnumReturnType} le type de retour de la requête
	 * @return {@link MultivaluedMap} une map de tous les paramètres par défaut.	 * @throws NullPointerException Si le type de retour est null
	 * @see EnumReturnType
	 */
	protected final MultivaluedMap<String, String> createHTTPProperties(final EnumReturnType parType) {
		final MultivaluedMap<String, String> locParameters = new MultivaluedMapImpl();		final String locReturnType = parType.getValue();		// On vide les éventuels anciens paramètres.		locParameters.clear();
		locParameters.putSingle(OUTPUT, locReturnType);		return locParameters;
	}

	/**
	 * Crée une requête GET et renvoie le résultat dans le type de retour est spécifié.
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
	protected final String createGETRequest(final EnumReturnType parType, final String parURL) throws UniformInterfaceException, NullPointerException, IllegalArgumentException {
		final MultivaluedMap<String, String> locQueryParams = createHTTPProperties(parType);
		return createGETRequest(parURL, locQueryParams);
	}
	
	/**
	 * Crée une requête GET et renvoie le résultat dans le type de retour est spécifié.
	 * L'URL à spécifier correspond au chemin relatif, le contexte courant concatène cette valeur
	 * avec son URL. Si l'URL est null, une exception est levée.
	 * @param parURL {@link String} l'url de la requête
	 * @param parParameters {@link MultivaluedMap} les paramètres de la requête devant au moins contenir 
	 * @return {@link String} la réponse du serveur
	 * @throws UniformInterfaceException Si l'URL est invalide et que la requête renvoie autre chose qu'un status 200 OK
	 * @throws NullPointerException Si les paramètres sont null
	 * @throws IllegalArgumentException Si l'url est null ou vide ou que le paramètre {@link #OUTPUT} n'est pas présent.	 * @see MailjetContext#getRestUrl()
	 */
	protected final String createGETRequest(final String parURL, final MultivaluedMap<String,String> parParameters) throws UniformInterfaceException, IllegalArgumentException, NullPointerException {
		return sendRequest(parURL, parParameters, true);
	}			/**	 * Crée une requête POST et renvoie le résultat dans le type de retour est spécifié.	 * L'URL à spécifier correspond au chemin relatif, le contexte courant concatène cette valeur	 * avec son URL. Si l'URL est null, une exception est levée.	 * @param parURL {@link String} l'url de la requête	 * @param parParameters {@link MultivaluedMap} les paramètres de la requête devant au moins contenir 	 * @return {@link String} la réponse du serveur	 * @throws UniformInterfaceException Si l'URL est invalide et que la requête renvoie autre chose qu'un status 200 OK	 * @throws NullPointerException Si les paramètres sont null	 * @throws IllegalArgumentException Si l'url est null ou vide ou que le paramètre {@link #OUTPUT} n'est pas présent	 * @see MailjetContext#getRestUrl()	 */	protected final String createPOSTRequest(final String parURL, final MultivaluedMap<String, String> parParameters) throws UniformInterfaceException, IllegalArgumentException {		return sendRequest(parURL, parParameters, false);	}		private String sendRequest(final String parURL, final MultivaluedMap<String, String> parParameters, final boolean parIsGetRequest) throws UniformInterfaceException, IllegalArgumentException {		if(parParameters.containsKey(OUTPUT) == false) {			throw new IllegalArgumentException(String.format("Le paramètre \"%s\" n'est pas spécifié.", OUTPUT));		} 		if(parURL == null || parURL.isEmpty()) {			throw new IllegalArgumentException("L'URL est null ou vide.");		}		final WebResource locWebResource = _client.resource(MailjetContext.getRestUrl() + parURL).queryParams(parParameters);		return (parIsGetRequest == true) ? locWebResource.get(String.class) : locWebResource.post(String.class);	}

}
