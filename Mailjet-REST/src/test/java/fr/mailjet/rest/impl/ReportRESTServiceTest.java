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
import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Test;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.ReportRESTService;
import fr.mailjet.rest.parameters.EnumReturnType;

/**
 * Tests unitaires du service "report"
 * 
 * @see ReportRESTService
 * @author Pitton Olivier
 * 
 */
public class ReportRESTServiceTest extends AbstractServiceTestBase {

	// En static pour close après les tests.
	static private ReportRESTService _service;

	@AfterClass
	static final public void afterClass() {
		_service.close();
		_service = null;
	}

	public ReportRESTServiceTest(EnumReturnType parType) {
		super(parType);
		_service = new RESTServiceFactory(this._context).createReportService();
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

	@Test(timeout = 30000L)
	public void testClickEnumReturnType() {
		final String locResult = _service.click(this._type);
		this.checkStatus(locResult);
		this.checkMinimumIntegerParameter(locResult, "cnt", 1);
	}

	@Test(timeout = 30000L)
	public void testClickEnumReturnTypeMapOfEnumReportParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		locParameters.put("start", "0");
		locParameters.put("order_by", "by_email");
		locParameters.put("from", this.MAIL);
		final String locResult = _service.click(this._type, locParameters);
		this.checkStatus(locResult);
		this.checkMinimumIntegerParameter(locResult, "cnt", 1);
	}

	@Test(timeout = 30000L)
	public void testDomainEnumReturnType() {
		final String locResult = _service.domain(this._type);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testDomainEnumReturnTypeMapOfEnumReportParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		locParameters.put("start", "0");
		locParameters.put("from", this.MAIL);
		final String locResult = _service.domain(this._type, locParameters);
		this.checkStatus(locResult);
		this.checkMinimumIntegerParameter(locResult, "cnt", 1, false);
	}

	@Test(timeout = 30000L)
	public void testEmailBounceEnumReturnType() {
		final String locResult = _service.emailBounce(this._type);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testEmailBounceEnumReturnTypeMapOfEnumReportParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		locParameters.put("start", "0");
		locParameters.put("from", this.MAIL);
		final String locResult = _service.emailBounce(this._type, locParameters);
		this.checkStatus(locResult);
		this.checkMinimumIntegerParameter(locResult, "cnt", 0, false);
	}

	@Test(timeout = 30000L)
	public void testEmailClientsEnumReturnType() {
		final String locResult = _service.emailClients(this._type);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testEmailClientsEnumReturnTypeMapOfEnumReportParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		locParameters.put("start", "0");
		locParameters.put("from", this.MAIL);
		final String locResult = _service.emailClients(this._type, locParameters);
		this.checkStatus(locResult);
		this.checkMinimumIntegerParameter(locResult, "cnt", 1);

	}

	@Test(timeout = 30000L)
	public void testEmailInfos() {
		final String locResult = _service.emailInfos(this._type, this.STATS_CAMPAIGN_ID);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testEmailSentEnumReturnType() {
		final String locResult = _service.emailSent(this._type);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testEmailSentEnumReturnTypeMapOfEnumReportParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		locParameters.put("start", "0");
		locParameters.put("from", this.MAIL);
		final String locResult = _service.emailSent(this._type, locParameters);
		this.checkStatus(locResult);
		this.checkMinimumIntegerParameter(locResult, "cnt", 1);

	}

	@Test(timeout = 30000L)
	public void testEmailStatisticsEnumReturnType() {
		final String locResult = _service.emailStatistics(this._type);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testEmailStatisticsEnumReturnTypeMapOfEnumReportParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		locParameters.put("start", "0");
		locParameters.put("from", this.MAIL);
		final String locResult = _service.emailStatistics(this._type, locParameters);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testGeoIpEnumReturnType() {
		final String locResult = _service.geoIp(this._type);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testGeoIpEnumReturnTypeMapOfEnumReportParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		locParameters.put("start", "0");
		locParameters.put("from", this.MAIL);
		final String locResult = _service.geoIp(this._type, locParameters);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testOpenEnumReturnType() {
		final String locResult = _service.open(this._type);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testOpenEnumReturnTypeMapOfEnumReportParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		locParameters.put("start", "0");
		locParameters.put("from", this.MAIL);
		final String locResult = _service.open(this._type, locParameters);
		this.checkStatus(locResult);
		this.checkMinimumIntegerParameter(locResult, "cnt", 1);
	}

	@Test(timeout = 30000L)
	public void testOpenedStatisticsEnumReturnType() {
		final String locResult = _service.openedStatistics(this._type);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testOpenedStatisticsEnumReturnTypeMapOfEnumReportParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		locParameters.put("start", "0");
		locParameters.put("from", this.MAIL);
		final String locResult = _service.domain(this._type, locParameters);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testUserAgentsEnumReturnType() {
		final String locResult = _service.userAgents(this._type);
		this.checkStatus(locResult);
	}

	@Test(timeout = 30000L)
	public void testUserAgentsEnumReturnTypeMapOfEnumReportParametersString() {
		Map<String, String> locParameters = new HashMap<String, String>();
		locParameters.put("limit", "1");
		locParameters.put("start", "0");
		locParameters.put("from", this.MAIL);
		final String locResult = _service.domain(this._type, locParameters);
		this.checkStatus(locResult);
		this.checkMinimumIntegerParameter(locResult, "cnt", 1, false);
	}
}
