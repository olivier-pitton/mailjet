package fr.mailjet.rest.impl;/* *  * Mailjet * %% * Copyright (C) 2012 Pitton Olivier - olivier dot pitton at gmail dot com * %% * Licensed under the Apache License, Version 2.0 (the "License"); * you may not use this file except in compliance with the License. * You may obtain a copy of the License at *  *      http://www.apache.org/licenses/LICENSE-2.0 *  * Unless required by applicable law or agreed to in writing, software * distributed under the License is distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. * See the License for the specific language governing permissions and * limitations under the License. * #L% */import static org.junit.Assert.assertEquals;import static org.junit.Assert.assertFalse;import org.junit.AfterClass;import org.junit.Test;import fr.mailjet.context.MailjetContext;import fr.mailjet.rest.UserRESTService;import fr.mailjet.rest.parameters.EnumReturnType;/** * Tests unitaires du service user *  * @see UserRESTService * @author Pitton Olivier *  */public class UserRESTServiceTest extends AbstractServiceTestBase {	// En static pour close après les tests.	static private UserRESTService _service;	@AfterClass	static final public void afterClass() {		_service.close();		_service = null;	}	public UserRESTServiceTest(EnumReturnType parType) {		super(parType);		_service = new RESTServiceFactory(_context).createUserService();	}	@Test(timeout = 1000L)	public void testGetContext() {		assertEquals(_context, _service.getContext());	}	@Test(timeout = 1000L)	public void testSetContext() {		_service.setContext(new MailjetContext("test", "test"));		assertFalse(_service.getContext().equals(_context));		_service.setContext(_context);	}	@Test(timeout = 10000L)	public void testInfos() {		String locResult = _service.infos(_type);		checkStatus(locResult);	}	@Test(timeout = 10000L)	public void testDomainList() {		String locResult = _service.domainList(_type);		checkStatus(locResult);	}	@Test(timeout = 10000L)	public void testSenderList() {		String locResult = _service.senderList(_type);		checkStatus(locResult);	}	@Test(timeout = 10000L)	public void testTrackingCheck() {		String locResult = _service.trackingCheck(_type);		checkStatus(locResult);	}	@Test(timeout = 10000L)	public void testDomainAdd() {	}	@Test(timeout = 10000L)	public void testDomainStatus() {	}	@Test(timeout = 10000L)	public void testSenderAdd() {	}	@Test(timeout = 10000L)	public void testSenderStatus() {	}	@Test(timeout = 10000L)	public void testTrackingUpdate() {	}	@Test(timeout = 10000L)	public void testUpdate() {	}}