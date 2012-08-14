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

		_service = new RESTServiceFactory(this._context).createListsService();
	}

	@Test(timeout = 1000L)
	public void testGetContext() {
		assertEquals(this._context, _service.getContext());
	}

	@Test(timeout = 1000L)
	public void testSetContext() {
		_service.setContext(new MailjetContext("test", "test"));
		assertFalse(_service.getContext().equals(this._context));
		_service.setContext(this._context);
	}

	@Test(timeout = 15000L)
	public void testAllEnumReturnType() {
		String locResult = _service.all(this._type);
		this.checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public void testAllEnumReturnTypeInteger() {
		String locResult = _service.all(this._type, Integer.valueOf(1));
		this.checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public void testAllEnumReturnTypeIntegerString() {
		String locResult = _service.all(this._type, Integer.valueOf(1), "ASC");
		this.checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public void testAllEnumReturnTypeIntegerStringInteger() {
		String locResult = _service.all(this._type, Integer.valueOf(1), "DESC", Integer.valueOf(0));
		this.checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public void testContactsEnumReturnTypeInteger() {
		String locResult = _service.contacts(this._type, this.LIST_ID);
		this.checkStatus(locResult);
	}

	@Test(timeout = 15000L)
	public void testContactsEnumReturnTypeIntegerEnumMapOfEnumContactsParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>(3);
		String locBlockedAndLimitParameter = Integer.valueOf(1).toString();
		locParameters.put("limit", locBlockedAndLimitParameter);
		locParameters.put("order_by", "ASC");
		locParameters.put("start", Integer.valueOf(0).toString());
		String locResult = _service.contacts(this._type, this.LIST_ID, locParameters);
		this.checkStatus(locResult);
		this.checkMinimumIntegerParameter(locResult, "total_cnt", Integer.valueOf(1));
	}

	@Test(timeout = 3000L, expected = IllegalArgumentException.class)
	public void testContactsIllegalArgumentException() {
		Map<String, String> locParameters = new HashMap<String, String>(3);
		String locBlockedAndLimitParameter = Integer.valueOf(1).toString();
		locParameters.put("limit", locBlockedAndLimitParameter);
		locParameters.put("order_by", "ASC");
		locParameters.put("start", Integer.valueOf(0).toString());
		_service.contacts(this._type, null, locParameters);
	}

	@Test(timeout = 15000L)
	public void testEmail() {
		this._logger.warning("Not tested because of 204 no content");
	}

	@Test(timeout = 3000L, expected = IllegalArgumentException.class)
	public void testEmailIllegalArgumentException() {
		_service.email(this._type, null);
	}

	@Test(timeout = 15000L)
	public void testStatistics() {
		this._logger.warning("Not tested because of 204 no content");
	}

	@Test(timeout = 3000L, expected = IllegalArgumentException.class)
	public void testStatisticsIllegalArgumentException() {
		_service.statistics(this._type, null);
	}

	@Test(timeout = 15000L)
	public void testAddContactEnumReturnTypeIntegerString() {
		this._logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testAddContactEnumReturnTypeIntegerStringBoolean() {
		this._logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testAddManyContactsEnumReturnTypeIntegerListOfString() {
		this._logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testAddManyContactsEnumReturnTypeIntegerListOfStringBoolean() {
		this._logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testCreate() {
		this._logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testDelete() {
		this._logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testRemoveContact() {
		this._logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testRemoveManyContacts() {
		this._logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testUnsubContact() {
		this._logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testUpdateEnumReturnTypeIntegerString() {
		this._logger.warning("Not tested because need a premium account");
	}

	@Test(timeout = 15000L)
	public void testUpdateEnumReturnTypeIntegerStringString() {
		this._logger.warning("Not tested because need a premium account");
	}

}
