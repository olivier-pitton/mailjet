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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Test;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.ListsRESTService;
import fr.mailjet.rest.parameters.EnumReturnType;

/**
 * Tests unitaires du service "lists"
 * 
 * @see ListsRESTService
 * @author Pitton Olivier
 * 
 */
public class ListsRESTServiceTest extends AbstractServiceTestBase {

	// En static pour close après les tests.
	static private ListsRESTService _service;

	@AfterClass
	static final public void afterClass() {
		_service.close();
		_service = null;
	}

	public ListsRESTServiceTest(EnumReturnType parType) {
		super(parType);

		_service = new RESTServiceFactory(_context).createListsService();
	}

	@Test(timeout = 1000L)
	public void testGetContext() {
		assertEquals(_context, _service.getContext());
	}

	@Test(timeout = 1000L)
	public void testSetContext() {
		_service.setContext(new MailjetContext("test", "test"));
		assertFalse(_service.getContext().equals(_context));
		_service.setContext(_context);
	}

	@Test(timeout = 15000L)
	public void testAllEnumReturnType() {
		String locResult = _service.all(_type);
		checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public void testAllEnumReturnTypeInteger() {
		String locResult = _service.all(_type, Integer.valueOf(1));
		checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public void testAllEnumReturnTypeIntegerString() {
		String locResult = _service.all(_type, Integer.valueOf(1), "ASC");
		checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public void testAllEnumReturnTypeIntegerStringInteger() {
		String locResult = _service.all(_type, Integer.valueOf(1), "DESC", Integer.valueOf(0));
		checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public void testContactsEnumReturnTypeInteger() {
		String locResult = _service.contacts(_type, LIST_ID);
		checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public void testContactsEnumReturnTypeIntegerEnumMapOfEnumContactsParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>(3);
		String locBlockedAndLimitParameter = Integer.valueOf(1).toString();
		locParameters.put("limit", locBlockedAndLimitParameter);
		locParameters.put("order_by", "ASC");
		locParameters.put("start", Integer.valueOf(0).toString());
		String locResult = _service.contacts(_type, LIST_ID, locParameters);
		checkStatus(locResult);
		checkMinimumIntegerParameter(locResult, "total_cnt", Integer.valueOf(1));
	}

	@Test(timeout = 3000L, expected = IllegalArgumentException.class)
	public void testContactsIllegalArgumentException() {
		Map<String, String> locParameters = new HashMap<String, String>(3);
		String locBlockedAndLimitParameter = Integer.valueOf(1).toString();
		locParameters.put("limit", locBlockedAndLimitParameter);
		locParameters.put("order_by", "ASC");
		locParameters.put("start", Integer.valueOf(0).toString());
		_service.contacts(_type, null, locParameters);
	}

	@Test(timeout = 15000L)
	public void testEmail() {
		_logger.warning("Not tested because of 204 no content");
	}

	@Test(timeout = 3000L, expected = IllegalArgumentException.class)
	public void testEmailIllegalArgumentException() {
		_service.email(_type, null);
	}

	@Test(timeout = 15000L)
	public void testStatistics() {
		_logger.warning("Not tested because of 204 no content");
	}

	@Test(timeout = 3000L, expected = IllegalArgumentException.class)
	public void testStatisticsIllegalArgumentException() {
		_service.statistics(_type, null);
	}

	@Test(timeout = 15000L)
	public void testAddContactEnumReturnTypeIntegerString() {
		_logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testAddContactEnumReturnTypeIntegerStringBoolean() {
		_logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testAddManyContactsEnumReturnTypeIntegerListOfString() {
		_logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testAddManyContactsEnumReturnTypeIntegerListOfStringBoolean() {
		_logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testCreate() {
		_logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testDelete() {
		_logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testRemoveContact() {
		_logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testRemoveManyContacts() {
		_logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testUnsubContact() {
		_logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testUpdateEnumReturnTypeIntegerString() {
		_logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testUpdateEnumReturnTypeIntegerStringString() {
		_logger.warning("Not tested because need a premium account");
	}

}
