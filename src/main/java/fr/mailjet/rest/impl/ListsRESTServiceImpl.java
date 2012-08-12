package fr.mailjet.rest.impl;
/*
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

import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.EnumReturnType;
import fr.mailjet.rest.ListsRESTService;
import fr.mailjet.rest.parameters.EnumListsContactParameters;

/**
 * L'implémentation par défaut du service lists
 * 
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 * 
 */
public final class ListsRESTServiceImpl extends AbstractRESTService implements ListsRESTService {


	/**
	 * Constructeur
	 * @param parContext {@link MailjetContext} un contexte
	 * @param parClient {@link Client} un client HTTP
	 */
	ListsRESTServiceImpl(final MailjetContext parContext, final Client parClient) {
		super(parContext, parClient);
	}

	@Override
	public final String all(final EnumReturnType parType) throws UniformInterfaceException {
		return all(parType, null);
	}

	@Override
	public final String all(final EnumReturnType parType, final Integer parLimit) throws UniformInterfaceException {
		return all(parType, parLimit, null);
	}

	@Override
	public final String all(final EnumReturnType parType, final Integer parLimit, final String parOrderBy) throws UniformInterfaceException {
		return all(parType, parLimit, parOrderBy, null);
	}

	@Override
	public final String all(final EnumReturnType parType, final Integer parLimit, final String parOrderBy, final Integer parStart)
			throws UniformInterfaceException {
		final MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		if (parLimit != null) {
			locParameters.putSingle(_AllLimit, parLimit.toString());
		}
		if (parOrderBy != null) {
			locParameters.putSingle(_AllOrderBy, parOrderBy);
		}
		if (parStart != null) {
			locParameters.putSingle(_AllStart, parStart.toString());
		}
		return createGETRequest("listsAll", locParameters);
	}

	@Override
	public final String contacts(final EnumReturnType parType, final Integer parListId) throws UniformInterfaceException, IllegalArgumentException {
		return contacts(parType, parListId, null);
	}

	@Override
	public final String contacts(final EnumReturnType parType, final Integer parListId, final Map<EnumListsContactParameters, String> parParameters)
			throws UniformInterfaceException, IllegalArgumentException {
		if (parListId == null) {
			throw new IllegalArgumentException();
		}
		final MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parListId.toString());
		if (parParameters != null) {
			for (final Map.Entry<EnumListsContactParameters, String> locEntry : parParameters.entrySet()) {
				locParameters.putSingle(locEntry.getKey().getValue(), locEntry.getValue());
			}
		}
		return createGETRequest("listsContacts", locParameters);
	}

	@Override
	public final String email(final EnumReturnType parType, final Integer parContactId) throws UniformInterfaceException, IllegalArgumentException {
		if (parContactId == null)
			throw new IllegalArgumentException();
		final MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parContactId.toString());
		return createGETRequest("listsEmail", locParameters);
	}

	@Override
	public final String statistics(final EnumReturnType parType, final Integer parListId) throws UniformInterfaceException, IllegalArgumentException {
		if (parListId == null)
			throw new IllegalArgumentException();
		final MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_ListId, parListId.toString());
		return createGETRequest("listsStatistics", locParameters);
	}
}
