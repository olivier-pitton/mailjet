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
import java.util.Locale;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Test;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.MessageRESTService;
import fr.mailjet.rest.parameters.EnumReturnType;

/**
 * Tests unitaires de base pour le service "message".
 * 
 * @see MessageRESTService
 * @author Pitton Olivier
 * 
 */
public class MessageRESTServiceTest extends AbstractServiceTestBase {

	// En static pour close après les tests.
	static private MessageRESTService _service;

	@AfterClass
	static final public void afterClass() {
		_service.close();
		_service = null;
	}

	public MessageRESTServiceTest(EnumReturnType parType) {
		super(parType);
		_service = new RESTServiceFactory(_context).createMessageService();
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
	public void testCampaignsEnumReturnType() {
		// Les paramètres spécifiques ne sont pas testés car dépendant de
		// l'utilisateur, on considère que le status
		// vérifie correctement le bon niveau du test.
		String locResult = _service.campaigns(_type);
		checkStatus(locResult);
	}

	@Test(timeout = 10000L)
	public void testCampaignsEnumReturnTypeInteger() {
		Integer locCount = Integer.valueOf(1);
		String locResult = _service.campaigns(_type, locCount);
		checkStatus(locResult);
		checkParameter(locResult, "cnt", "1");
	}

	@Test(timeout = 10000L)
	public void testCampaignsEnumReturnTypeEnumMap() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		locParameters.put("order_by", "DESC");
		String locResult = _service.campaigns(_type, locParameters);
		checkStatus(locResult);
		checkParameter(locResult, "cnt", "1");
	}

	@Test(timeout = 10000L)
	public void testContactsEnumReturnTypeInteger() {
		String locResult = _service.contacts(_type, STATS_CAMPAIGN_ID);
		checkStatus(locResult);
		checkMinimumIntegerParameter(locResult, "total_cnt", Integer.valueOf(1));
	}

	@Test(timeout = 10000L)
	public void testContactsEnumReturnTypeIntegerEnumMap() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		locParameters.put("order_by", "DESC");
		String locResult = _service.contacts(_type, STATS_CAMPAIGN_ID, locParameters);
		checkStatus(locResult);
		checkMinimumIntegerParameter(locResult, "total_cnt", Integer.valueOf(1));
	}

	@Test(timeout = 10000L)
	public void testHtmlCampaign() {
		String locResult = _service.htmlCampaign(_type, CAMPAIGN_ID);
		checkStatus(locResult);
	}

	@Test(timeout = 10000L)
	public void testListEnumReturnType() {
		String locResult = _service.list(_type);
		checkStatus(locResult);
		checkMinimumIntegerParameter(locResult, "total_cnt", Integer.valueOf(1));
	}

	@Test(timeout = 10000L)
	public void testListEnumReturnTypeEnumMapOfEnumMessageListParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		String locResult = _service.list(_type, locParameters);
		checkStatus(locResult);
		checkMinimumIntegerParameter(locResult, "total_cnt", Integer.valueOf(1));
	}

	@Test(timeout = 10000L)
	public void testStatistics() {
		String locResult = _service.statistics(_type, STATS_CAMPAIGN_ID);
		checkStatus(locResult);
	}

	@Test(timeout = 10000L)
	public void testTplCategories() {
		String locResult = _service.tplCategories(_type);
		checkStatus(locResult);
		checkParameter(locResult, "label", "basic");
	}

	@Test(timeout = 10000L)
	public void testTplModelsEnumReturnType() {
		String locResult = _service.tplModels(_type);
		checkStatus(locResult);
	}

	@Test(timeout = 10000L)
	public void testTplModelsEnumReturnTypeInteger() {
		String locResult = _service.tplModels(_type, Integer.valueOf(1));
		checkStatus(locResult);
	}

	@Test(timeout = 10000L)
	public void testTplModelsEnumReturnTypeIntegerBoolean() {
		String locResult = _service.tplModels(_type, Integer.valueOf(1), Boolean.FALSE);
		checkStatus(locResult);
	}

	@Test(timeout = 10000L)
	public void testTplModelsEnumReturnTypeLocale() {
		String locResult = _service.tplModels(_type, Integer.valueOf(1), Boolean.FALSE, Locale.getDefault());
		checkStatus(locResult);
	}

	@Test(timeout = 10000L)
	public void testCreateCampaign() {

	}

	@Test(timeout = 10000L)
	public void testDuplicateCampaign() {

	}

	@Test(timeout = 10000L)
	public void testSendCampaign() {

	}

	@Test(timeout = 10000L)
	public void testSetHtmlCampaign() {

	}

	@Test(timeout = 10000L)
	public void testTestCampaign() {

	}

	@Test(timeout = 10000L)
	public void testUpdateCampaign() {

	}
}
