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


import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.ApiRESTService;
import fr.mailjet.rest.EnumReturnType;
import fr.mailjet.rest.parameters.EnumCustomStatus;

/**
 * Tests unitaires du service api
 * 
 * @author pitton
 * 
 */
public class APIServiceTest extends AbstractServiceTestBase {

	// En static pour close après les tests.
	static private ApiRESTService	_service;

	@AfterClass
	static public void afterClass() {
		_service.close();
		_service = null;
	}

	public APIServiceTest(final EnumReturnType parType) {
		super(parType);
		_service = new RESTServiceFactory(_context).createApiService();
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
	public final void testKeyListEnumReturnTypeBoolean() {
		final String locResult = _service.keyList(_type, Boolean.TRUE);
		// Ne contient pas la propriété "status"
		assertNotNull(locResult);
		assertFalse(locResult.isEmpty());
		checkParameter(locResult, "apikey", _context.getApiKey());
		checkParameter(locResult, ApiRESTService._activeProperty, Integer.valueOf(1));
	}

	@Test(timeout = 10000L)
	public final void testKeyListEnumReturnTypeBooleanEnumCustomStatus() {
		final EnumCustomStatus locStatus = EnumCustomStatus.UP;
		final String locResult = _service.keyList(_type, Boolean.TRUE, locStatus);
		// Ne contient pas la propriété "status"
		assertNotNull(locResult);
		assertFalse(locResult.isEmpty());
		checkParameter(locResult, "apikey", _context.getApiKey());
		checkParameter(locResult, ApiRESTService._activeProperty, Integer.valueOf(1));
		checkParameter(locResult, ApiRESTService._customStatusProperty, locStatus.getValue());
	}

	@Test(timeout = 10000L)
	public final void testKeyListEnumReturnTypeBooleanEnumCustomStatusString() {
		final EnumCustomStatus locStatus = EnumCustomStatus.UP;
		final String locNameValue = "user";
		final String locResult = _service.keyList(_type, Boolean.TRUE, locStatus, locNameValue);
		// Ne contient pas la propriété "status"
		assertNotNull(locResult);
		assertFalse(locResult.isEmpty());
		checkParameter(locResult, "apikey", _context.getApiKey());
		checkParameter(locResult, ApiRESTService._activeProperty, Integer.valueOf(1));
		checkParameter(locResult, ApiRESTService._customStatusProperty, locStatus.getValue());
		checkParameter(locResult, ApiRESTService._nameProperty, locNameValue);
	}

	@Test(timeout = 10000L)
	public final void testKeyListEnumReturnTypeBooleanEnumCustomStatusStringBoolean() {
		final EnumCustomStatus locStatus = EnumCustomStatus.UP;
		final String locNameValue = "user";
		final String locResult = _service.keyList(_type, Boolean.TRUE, locStatus, locNameValue, Boolean.TRUE);
		// Ne contient pas la propriété "status"
		assertNotNull(locResult);
		assertFalse(locResult.isEmpty());
		checkParameter(locResult, "apikey", _context.getApiKey());
		checkParameter(locResult, ApiRESTService._activeProperty, Integer.valueOf(1));
		checkParameter(locResult, ApiRESTService._customStatusProperty, locStatus.getValue());
		checkParameter(locResult, ApiRESTService._nameProperty, locNameValue);
		checkParameter(locResult, ApiRESTService._typeProperty, "main");
	}

	@Test(timeout = 10000L)
	public final void testKeyListEnumReturnTypeMultivaluedMapOfStringString() {
		final String locResult = _service.keyList(_type, Boolean.TRUE, EnumCustomStatus.UP, "main", Boolean.TRUE);
		assertNotNull(locResult);
		assertFalse(locResult.isEmpty());
		checkStatus(locResult);
	}

	@Test(timeout = 10000L)
	public final void testKeySecret() {
		final String locResult = _service.keySecret(_type);
		assertNotNull(locResult);
		assertFalse(locResult.isEmpty());
		checkParameter(locResult, "secretkey", _context.getSecretKey());
	}

	@Test(timeout = 10000L)
	public final void testKeySecretChange() {
		_logger.warning("Not tested because not idempotent");
	}
}
