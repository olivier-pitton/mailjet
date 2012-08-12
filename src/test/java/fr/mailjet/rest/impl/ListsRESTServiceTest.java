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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.EnumMap;

import org.junit.AfterClass;
import org.junit.Test;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.EnumReturnType;
import fr.mailjet.rest.ListsRESTService;
import fr.mailjet.rest.parameters.EnumListsContactParameters;

/**
 * Tests unitaires du service "lists"
 * @see ListsRESTService
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public final class ListsRESTServiceTest extends AbstractServiceTestBase {

	// En static pour close après les tests.
	static private ListsRESTService	_service;

	@AfterClass
	static final public void afterClass() {
		_service.close();
		_service = null;
	}

	public ListsRESTServiceTest(final EnumReturnType parType) {
		super(parType);

		_service = new RESTServiceFactory(_context).createListsService();
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

	@Test(timeout = 15000L)
	public final void testAllEnumReturnType() {
		final String locResult = _service.all(_type);
		checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public final void testAllEnumReturnTypeInteger() {
		final String locResult = _service.all(_type, Integer.valueOf(1));
		checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public final void testAllEnumReturnTypeIntegerString() {
		final String locResult = _service.all(_type, Integer.valueOf(1), "ASC");
		checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public final void testAllEnumReturnTypeIntegerStringInteger() {
		final String locResult = _service.all(_type, Integer.valueOf(1), "DESC", Integer.valueOf(0));
		checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public final void testContactsEnumReturnTypeInteger() {
		final String locResult = _service.contacts(_type, LIST_ID);
		checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public final void testContactsEnumReturnTypeIntegerEnumMapOfEnumContactsParametersString() {
		final EnumMap<EnumListsContactParameters, String> locParameters = new EnumMap<EnumListsContactParameters, String>(EnumListsContactParameters.class);
		final String locBlockedAndLimitParameter = Integer.valueOf(1).toString();
		locParameters.put(EnumListsContactParameters.LIMIT, locBlockedAndLimitParameter);
		locParameters.put(EnumListsContactParameters.ORDER_BY, "ASC");
		locParameters.put(EnumListsContactParameters.START, Integer.valueOf(0).toString());
		final String locResult = _service.contacts(_type, LIST_ID, locParameters);
		checkStatus(locResult);
		checkMinimumIntegerParameter(locResult, "total_cnt", Integer.valueOf(1));
	}

	@Test(timeout = 3000L, expected = IllegalArgumentException.class)
	public final void testContactsIllegalArgumentException() {
		final EnumMap<EnumListsContactParameters, String> locParameters = new EnumMap<EnumListsContactParameters, String>(EnumListsContactParameters.class);
		final String locBlockedAndLimitParameter = Integer.valueOf(1).toString();
		locParameters.put(EnumListsContactParameters.LIMIT, locBlockedAndLimitParameter);
		locParameters.put(EnumListsContactParameters.ORDER_BY, "ASC");
		locParameters.put(EnumListsContactParameters.START, Integer.valueOf(0).toString());
		final String locResult = _service.contacts(_type, null, locParameters);
		checkStatus(locResult);
		checkMinimumIntegerParameter(locResult, "total_cnt", Integer.valueOf(1));
	}

	@Test(timeout = 15000L)
	public final void testEmail() {
		_logger.warning("Not tested because of 204 no content");
	}

	@Test(timeout = 3000L, expected = IllegalArgumentException.class)
	public final void testEmailIllegalArgumentException() {
		_service.email(_type, null);
	}

	@Test(timeout = 15000L)
	public final void testStatistics() {
		_logger.warning("Not tested because of 204 no content");
	}

	@Test(timeout = 3000L, expected = IllegalArgumentException.class)
	public final void testStatisticsIllegalArgumentException() {
		_service.statistics(_type, null);
	}

}
