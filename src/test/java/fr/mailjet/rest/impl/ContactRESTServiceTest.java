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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.EnumMap;

import org.junit.AfterClass;
import org.junit.Test;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.ContactRESTService;
import fr.mailjet.rest.EnumReturnType;
import fr.mailjet.rest.parameters.EnumContactListParameters;

/**
 *  Tests unitaires du service "contact" *  @see ContactRESTService
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 * 
 */
public class ContactRESTServiceTest extends AbstractServiceTestBase {

	// En static pour close après les tests.
	static private ContactRESTService	_service;

	@AfterClass
	static public final void afterClass() {
		_service.close();
		_service = null;
	}

	public ContactRESTServiceTest(final EnumReturnType parType) {
		super(parType);
		_service = new RESTServiceFactory(_context).createContactService();
	}

	@Test(timeout = 1000L)
	public final void testGetContext() {
		assertEquals(_context, _service.getContext());
	}

	@Test(timeout = 1000L)
	public final void testSetContext() {
		_service.setContext(new MailjetContext("test", "test"));
		assertFalse(_service.getContext().equals(_context));
		_service.setContext(_context);
	}

	@Test(timeout = 10000L)
	public final void testInfos() {
		final String locResult = _service.infos(_type, MAIL);
		checkStatus(locResult);
		checkParameter(locResult, "email", MAIL);
	}

	@Test(timeout = 3000L, expected = IllegalArgumentException.class)
	public final void testInfosIllegalArgumentException() {
		_service.infos(_type, null);
	}

	@Test(timeout = 10000L)
	public final void testList_EnumReturnType() {
		final String locResult = _service.list(_type);
		// On considère que le status vérifie la validité du test, afin de ne pas le
		// rendre dépendant d'une liste de contacts
		checkStatus(locResult);
	}

	@Test(timeout = 10000L)
	public final void testList_EnumReturnType_EnumMap() {
		final EnumMap<EnumContactListParameters, String> locParameters = new EnumMap<EnumContactListParameters, String>(EnumContactListParameters.class);
		locParameters.put(EnumContactListParameters.LIMIT, "1");
		locParameters.put(EnumContactListParameters.BLOCKED, "1");
		final String locResult = _service.list(_type, locParameters);
		// On considère que le status vérifie la validité du test, afin de ne pas le
		// rendre dépendant d'une liste de contacts
		checkStatus(locResult);
	}

	@Test(timeout = 10000L)
	public final void testOpeners_EnumReturnType() {
		final String locResult = _service.openers(_type);
		// On considère que le status vérifie la validité du test, afin de ne pas le
		// rendre dépendant d'une liste de contacts
		checkStatus(locResult);
	}

	@Test(timeout = 10000L)
	public final void testOpeners_EnumReturnType_Long() {
		final String locResult = _service.openers(_type, null);
		// On considère que le status vérifie la validité du test, afin de ne pas le
		// rendre dépendant d'une liste de contacts
		checkStatus(locResult);
	}

	@Test(timeout = 10000L)
	public final void testOpeners_3args() {
		final String locResult = _service.openers(_type, null, Integer.valueOf(1));
		checkStatus(locResult);
		checkParameter(locResult, "total_cnt", "1");
	}

	@Test(timeout = 10000L)
	public final void testOpeners_4args() {
		final String locResult = _service.openers(_type, null, Integer.valueOf(1), Integer.valueOf(0));
		checkStatus(locResult);
		checkParameter(locResult, "total_cnt", "1");
	}
}
