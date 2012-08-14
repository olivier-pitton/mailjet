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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fr.mailjet.context.MailjetContext;

public class RESTServiceFactoryTest {

	static private final String API_KEY = "test";
	static private final String SECRET_KEY = "test";

	@Test(timeout = 3000L, expected = IllegalArgumentException.class)
	public void testRESTServiceFactoryMailjetContext() {
		// Have to throw an exception
		new RESTServiceFactory(null);
	}

	@Test(timeout = 3000L)
	public void testRESTServiceFactoryStringString() {
		assertEquals(new RESTServiceFactory(API_KEY, SECRET_KEY), new RESTServiceFactory(new MailjetContext(API_KEY, SECRET_KEY)));
	}

	@Test(timeout = 3000L)
	public void testCreateUserService() {
		assertNotNull(new RESTServiceFactory(API_KEY, SECRET_KEY).createUserService());
	}

	@Test(timeout = 3000L)
	public void testCreateApiService() {
		assertNotNull(new RESTServiceFactory(API_KEY, SECRET_KEY).createApiService());
	}

	@Test(timeout = 3000L)
	public void testCreateMessageService() {
		assertNotNull(new RESTServiceFactory(API_KEY, SECRET_KEY).createMessageService());
	}

	@Test(timeout = 3000L)
	public void testCreateContactService() {
		assertNotNull(new RESTServiceFactory(API_KEY, SECRET_KEY).createContactService());
	}

	@Test(timeout = 3000L)
	public void testCreateListsService() {
		assertNotNull(new RESTServiceFactory(API_KEY, SECRET_KEY).createListsService());
	}

	@Test(timeout = 3000L)
	public void testCreateReportService() {
		assertNotNull(new RESTServiceFactory(API_KEY, SECRET_KEY).createReportService());
	}

}
