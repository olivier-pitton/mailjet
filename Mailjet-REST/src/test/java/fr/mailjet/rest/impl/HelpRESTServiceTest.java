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

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.HelpRESTService;
import fr.mailjet.rest.parameters.EnumReturnType;

public class HelpRESTServiceTest extends AbstractServiceTestBase {

	// En static pour close après les tests.
	static private HelpRESTService _service;

	@AfterClass
	static final public void afterClass() {
		_service.close();
		_service = null;
	}

	public HelpRESTServiceTest(EnumReturnType parType) {
		super(parType);

		_service = new RESTServiceFactory(_context).createHelpService();
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

	@Test(timeout = 10000L)
	public void testCategories() {
		String locResult = _service.categories(_type);
		checkStatus(locResult);
		checkParameter(locResult, "name", "api");
		checkParameter(locResult, "name", "message");
		checkParameter(locResult, "name", "contact");
		checkParameter(locResult, "name", "user");
		checkParameter(locResult, "name", "report");
		checkParameter(locResult, "name", "lists");
		checkParameter(locResult, "name", "Help");
	}

	@Test(timeout = 10000L)
	public void testCategory() {
		String locResult = _service.category(_type, "report");
		checkStatus(locResult);
		checkParameter(locResult, "name", "Click");
		checkParameter(locResult, "name", "EmailStatistics");
		checkParameter(locResult, "name", "Domain");
	}

	@Test(timeout = 2000L, expected = IllegalArgumentException.class)
	public void testCategoryError() {
		_service.category(_type, "");
	}

	@Test(timeout = 10000L)
	public void testMethods() {
		String locResult = _service.methods(_type, "report");
		checkStatus(locResult);
		checkParameter(locResult, "name", "EmailInfos");
		checkParameter(locResult, "name", "Domain");
		checkParameter(locResult, "name", "Click");
	}

	@Test(timeout = 2000L, expected = IllegalArgumentException.class)
	public void testMethodsError() {
		_service.methods(_type, "");
	}

	@Test(timeout = 10000L)
	public void testMethod() {
		String locResult = _service.method(_type, "HelpMethod");
		checkStatus(locResult);
		checkParameter(locResult, "category", "Help");
		checkParameter(locResult, "request_type", "get");
	}

	@Test(timeout = 2000L, expected = IllegalArgumentException.class)
	public void testMethodError() {
		_service.method(_type, "");
	}

	@Test(timeout = 10000L)
	public void testStatusEnumReturnType() {
		String locResult = _service.status(_type);
		checkParameter(locResult, "code", "204");
	}

	@Test(timeout = 10000L)
	public void testStatusEnumReturnTypeInteger() {
		String locResult = _service.status(_type, 204);
		checkParameter(locResult, "code", "204");
	}
}
