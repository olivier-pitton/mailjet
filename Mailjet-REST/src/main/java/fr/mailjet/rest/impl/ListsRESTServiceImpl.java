package fr.mailjet.rest.impl;

/*
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

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.lang3.StringUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.ListsRESTService;
import fr.mailjet.rest.parameters.EnumReturnType;

/**
 * L'implémentation par défaut du service lists
 * 
 * @author Pitton Olivier
 * 
 */
public class ListsRESTServiceImpl extends AbstractRESTService implements ListsRESTService {
	/**
	 * Paramètre identifiant global à cette API
	 * @see ListsRESTService#contacts(EnumReturnType, Integer)
	 * @see ListsRESTService#email(EnumReturnType, Integer)
	 * @see ListsRESTService#statistics(EnumReturnType, Integer)
	 */
	static final private String _ListId = "id";
	/**
	 * Paramètre order_by de la méthode all
	 *<br /><a  href="https://fr.mailjet.com/docs/api/lists/all">Documentation Mailjet</a>
	 * @see ListsRESTService#all(EnumReturnType, Integer, String)
	 */
	static final private String _AllOrderBy = "order_by";
	/**
	 * Paramètre limit de la méthode all
	 *<br /><a  href="https://fr.mailjet.com/docs/api/lists/all">Documentation Mailjet</a>
	 * @see ListsRESTService#all(EnumReturnType, Integer)
	 */
	static final private String _AllLimit = "limit";
	
	/**
	 * Paramètre start de la méthode all
	 * <br /><a  href="https://fr.mailjet.com/docs/api/lists/all">Documentation Mailjet</a>
	 * @see ListsRESTService#all(EnumReturnType, Integer, String, Integer)
	 */
	static final private String _AllStart = "start";
	
	/**
	 * Paramètre contact 
	 * <br /><a href="https://fr.mailjet.com/docs/api/lists/addcontact">Documentation Mailjet</a>
	 * @see #addContact(EnumReturnType, Integer, String)
	 * @see #addContact(EnumReturnType, Integer, String, Boolean)
	 */
	static final private String _contact = "contact";

	/**
	 * Paramètre contacts 
	 * <br /><a href="https://fr.mailjet.com/docs/api/lists/addmanycontacts">Documentation Mailjet</a>
	 * @see #addManyContacts(EnumReturnType, Integer, List)
	 * @see #addManyContacts(EnumReturnType, Integer, List, Boolean)
	 */
	static final private String _contacts = "contacts";

	/**
	 * Paramètre force
	 * <br /><a href="https://fr.mailjet.com/docs/api/lists/addmanycontacts">AddManyContacts</a>
	 * <br /><a href="https://fr.mailjet.com/docs/api/lists/addcontact">AddContact</a>
	 * @see #addContact(EnumReturnType, Integer, String, Boolean)
	 * @see #addManyContacts(EnumReturnType, Integer, List, Boolean)
	 */
	static final private String _force = "force";
	
	/**
	 * Paramètre "name"
	 * <br /><a href="https://fr.mailjet.com/docs/api/lists/create">Documentation Mailjet</a>
	 * @see #create(EnumReturnType, String, String)
	 */
	static final private String _name = "name";
	
	/**
	 * Paramètre "label"
	 * <br /><a href="https://fr.mailjet.com/docs/api/lists/create">Documentation Mailjet</a>
	 * @see #create(EnumReturnType, String, String)
	 */
	static final private String _label = "label";	

	/**
	 * Constructeur
	 * 
	 * @param parContext
	 *          {@link MailjetContext} un contexte
	 * @param parClient
	 *          {@link Client} un client HTTP
	 */
	protected ListsRESTServiceImpl(MailjetContext parContext, Client parClient) {
		super(parContext, parClient);
	}

	@Override
	public String all(EnumReturnType parType) throws UniformInterfaceException {
		return all(parType, null);
	}

	@Override
	public String all(EnumReturnType parType, Integer parLimit) throws UniformInterfaceException {
		return all(parType, parLimit, null);
	}

	@Override
	public String all(EnumReturnType parType, Integer parLimit, String parOrderBy) throws UniformInterfaceException {
		return all(parType, parLimit, parOrderBy, null);
	}

	@Override
	public String all(EnumReturnType parType, Integer parLimit, String parOrderBy, Integer parStart) throws UniformInterfaceException {
		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		if (parLimit != null) {
			locParameters.putSingle(_AllLimit, parLimit.toString());
		}
		if (StringUtils.isNotEmpty(parOrderBy)) {
			locParameters.putSingle(_AllOrderBy, parOrderBy);
		}
		if (parStart != null) {
			locParameters.putSingle(_AllStart, parStart.toString());
		}
		return createGETRequest("listsAll", locParameters);
	}

	@Override
	public String contacts(EnumReturnType parType, Integer parListId) throws UniformInterfaceException, IllegalArgumentException {
		return contacts(parType, parListId, null);
	}

	@Override
	public String contacts(EnumReturnType parType, Integer parListId, Map<String, String> parParameters) throws UniformInterfaceException, IllegalArgumentException {
		if (parListId == null) {
			throw new IllegalArgumentException();
		}
		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parListId.toString());
		if (parParameters != null) {
			for (Map.Entry<String, String> locEntry : parParameters.entrySet()) {
				locParameters.putSingle(locEntry.getKey(), locEntry.getValue());
			}
		}
		return createGETRequest("listsContacts", locParameters);
	}

	@Override
	public String email(EnumReturnType parType, Integer parContactId) throws UniformInterfaceException, IllegalArgumentException {
		if (parContactId == null)
			throw new IllegalArgumentException();
		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parContactId.toString());
		return createGETRequest("listsEmail", locParameters);
	}

	@Override
	public String statistics(EnumReturnType parType, Integer parListId) throws UniformInterfaceException, IllegalArgumentException {
		if (parListId == null)
			throw new IllegalArgumentException();
		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parListId.toString());
		return createGETRequest("listsStatistics", locParameters);
	}

	@Override
	public String addContact(EnumReturnType parType, Integer parListId, String parEmail) throws UniformInterfaceException, IllegalArgumentException {
		return addContact(parType, parListId, parEmail, null);
	}

	@Override
	public String addContact(EnumReturnType parType, Integer parListId, String parEmail, Boolean parForce) throws UniformInterfaceException, IllegalArgumentException {
		if (parListId == null || StringUtils.isEmpty(parEmail))
			throw new IllegalArgumentException();

		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parListId.toString());
		locParameters.putSingle(_contact, parEmail);
		if (parForce != null) {
			locParameters.putSingle(_force, parForce.toString());
		}
		return createPOSTRequest("listsAddcontact", locParameters);
	}

	@Override
	public String addManyContacts(EnumReturnType parType, Integer parListId, List<String> parContacts) throws UniformInterfaceException, IllegalArgumentException {
		return addManyContacts(parType, parListId, parContacts, null);
	}

	@Override
	public String addManyContacts(EnumReturnType parType, Integer parListId, List<String> parContacts, Boolean parForce) throws UniformInterfaceException, IllegalArgumentException {
		if (parListId == null || parContacts == null || parContacts.isEmpty())
			throw new IllegalArgumentException();

		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parListId.toString());
		locParameters.putSingle(_contacts, toString(parContacts));
		if (parForce != null) {
			locParameters.putSingle(_force, parForce.toString());
		}
		return createPOSTRequest("listsAddmanycontacts", locParameters);
	}

	@Override
	public String create(EnumReturnType parType, String parLabel, String parName) throws UniformInterfaceException, IllegalArgumentException {
		if (StringUtils.isEmpty(parName) || StringUtils.isEmpty(parLabel))
			throw new IllegalArgumentException();

		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_label, parLabel);
		locParameters.putSingle(_name, parName);
		return createPOSTRequest("listsCreate", locParameters);
	}

	@Override
	public String delete(EnumReturnType parType, Integer parListId) throws UniformInterfaceException, IllegalArgumentException {
		if (parListId == null)
			throw new IllegalArgumentException();

		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parListId.toString());
		return createPOSTRequest("listsDelete", locParameters);
	}

	@Override
	public String removeContact(EnumReturnType parType, Integer parListId, String parContact) throws UniformInterfaceException, IllegalArgumentException {
		if (parListId == null || StringUtils.isEmpty(parContact))
			throw new IllegalArgumentException();

		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parListId.toString());
		locParameters.putSingle(_contact, parContact);
		return createPOSTRequest("listsRemovecontact", locParameters);
	}

	@Override
	public String removeManyContacts(EnumReturnType parType, Integer parListId, List<String> parContacts) throws UniformInterfaceException, IllegalArgumentException {
		if (parListId == null || parContacts == null || parContacts.isEmpty())
			throw new IllegalArgumentException();

		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parListId.toString());
		locParameters.putSingle(_contacts, toString(parContacts));
		return createPOSTRequest("listsRemovemanycontacts", locParameters);
	}

	@Override
	public String unsubContact(EnumReturnType parType, Integer parListId, String parContact) throws UniformInterfaceException, IllegalArgumentException {
		if (parListId == null || StringUtils.isEmpty(parContact))
			throw new IllegalArgumentException();

		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parListId.toString());
		locParameters.putSingle(_contact, parContact);
		return createPOSTRequest("listsUnsubcontact", locParameters);
	}

	@Override
	public String update(EnumReturnType parType, Integer parListId, String parLabel) throws UniformInterfaceException, IllegalArgumentException {
		return update(parType, parListId, parLabel, null);
	}

	@Override
	public String update(EnumReturnType parType, Integer parListId, String parLabel, String parName) throws UniformInterfaceException, IllegalArgumentException {
		if (parListId == null)
			throw new IllegalArgumentException();

		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parListId.toString());
		if (StringUtils.isEmpty(parName) == false)
			locParameters.putSingle(_name, parName);
		if (StringUtils.isEmpty(parLabel) == false)
			locParameters.putSingle(_label, parLabel);
		
		return createPOSTRequest("listsUpdate", locParameters);
	}

	private String toString(List<String> parContacts) {
		StringBuilder locBuilder = new StringBuilder();
		int locSizeList = parContacts.size();
		// On ajoute tous les contacts en y mettant une virgule
		for (int i = 0; i < locSizeList - 1; ++i) {
			locBuilder.append(parContacts.get(i)).append(",");
		}
		// On ajoute le dernier sans virgule à la fin
		locBuilder.append(parContacts.get(locSizeList - 1));
		return locBuilder.toString();
	}

}
