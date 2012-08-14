package fr.mailjet.rest.impl;

/*
 * 
 * Mailjet-REST
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

import org.apache.commons.lang3.StringUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.HelpRESTService;
import fr.mailjet.rest.parameters.EnumReturnType;

/**
 * Une implémentation par défaut du service <i>Help</i>
 * 
 * @author Pitton Olivier
 * 
 */
public class HelpRESTServiceImpl extends AbstractRESTService implements HelpRESTService {

	/**
	 * Clé du paramètre "name" <br />
	 * <a href="https://fr.mailjet.com/docs/api/Help/method">Documentation
	 * Mailjet</a> <br />
	 * <a href="https://fr.mailjet.com/docs/api/Help/category">Documentation
	 * Mailjet</a>
	 * 
	 * @see #method(EnumReturnType, String)
	 * @see #category(EnumReturnType, String)
	 */
	private final static String _name = "name";
	/**
	 * Clé du paramètre "category" <br />
	 * <a href="https://fr.mailjet.com/docs/api/Help/methods">Documentation
	 * Mailjet</a>
	 * 
	 * @see #methods(EnumReturnType, String)
	 */
	private final static String _category = "category";
	/**
	 * Clé du paramètre "code" <br />
	 * <a href="https://fr.mailjet.com/docs/api/Help/status">Documentation
	 * Mailjet</a>
	 * 
	 * @see #status(EnumReturnType, Integer)
	 */
	private final static String _code = "code";

	/**
	 * Constructeur
	 * 
	 * @param parContext
	 *          {@link MailjetContext} un contexte
	 * @param parClient
	 *          {@link Client} un client
	 */
	protected HelpRESTServiceImpl(MailjetContext parContext, Client parClient) {
		super(parContext, parClient);
	}

	@Override
	public String categories(EnumReturnType parType) throws UniformInterfaceException {
		return this.createGETRequest(parType, "HelpCategories");
	}

	@Override
	public String category(EnumReturnType parType, String parName) throws UniformInterfaceException, IllegalArgumentException {
		if (StringUtils.isEmpty(parName))
			throw new IllegalArgumentException();

		MultivaluedMap<String, String> locParameters = this.createHTTPProperties(parType);
		locParameters.putSingle(_name, parName);
		return this.createGETRequest("HelpCategory", locParameters);
	}

	@Override
	public String methods(EnumReturnType parType, String parCategory) throws UniformInterfaceException, IllegalArgumentException {
		if (StringUtils.isEmpty(parCategory))
			throw new IllegalArgumentException();

		MultivaluedMap<String, String> locParameters = this.createHTTPProperties(parType);
		locParameters.putSingle(_category, parCategory);
		return this.createGETRequest("HelpMethods", locParameters);
	}

	@Override
	public String method(EnumReturnType parType, String parName) throws UniformInterfaceException, IllegalArgumentException {
		if (StringUtils.isEmpty(parName))
			throw new IllegalArgumentException();

		MultivaluedMap<String, String> locParameters = this.createHTTPProperties(parType);
		locParameters.putSingle(_name, parName);
		return this.createGETRequest("HelpMethod", locParameters);
	}

	@Override
	public String status(EnumReturnType parType) throws UniformInterfaceException {
		return this.status(parType, null);
	}

	@Override
	public String status(EnumReturnType parType, Integer parStatus) throws UniformInterfaceException {
		MultivaluedMap<String, String> locParameters = this.createHTTPProperties(parType);
		if (parStatus != null) {
			locParameters.putSingle(_code, parStatus.toString());
		}
		return this.createGETRequest("HelpStatus", locParameters);
	}

}
