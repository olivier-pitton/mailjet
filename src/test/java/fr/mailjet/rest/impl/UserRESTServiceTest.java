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

import org.junit.AfterClass;
import org.junit.Test;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.EnumReturnType;
import fr.mailjet.rest.UserRESTService;

/**
 * Tests unitaires du service user
 * @see UserRESTService
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public final class UserRESTServiceTest extends AbstractServiceTestBase {

	// En static pour close après les tests.
	static private UserRESTService _service;

	@AfterClass
	static public void afterClass() {		
		_service.close();
		_service = null;
	}
	
	public UserRESTServiceTest(final EnumReturnType parType) {
		super(parType);
		_service = new RESTServiceFactory(_context).createUserService();
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

	@Test (timeout = 10000L)
	public final void testInfos() {
		final String locResult = _service.infos(_type);
		checkStatus(locResult);
	}

	@Test (timeout = 10000L)
	public final void testDomainList() {
		final String locResult = _service.domainList(_type);
		checkStatus(locResult);
	}

	@Test (timeout = 10000L)
	public final void testSenderList() {
		final String locResult = _service.senderList(_type);
		checkStatus(locResult);
	}

	@Test (timeout = 10000L)
	public final void testTrackingCheck() {
		final String locResult = _service.trackingCheck(_type);
		checkStatus(locResult);
	}

}
