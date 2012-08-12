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
import java.util.Locale;

import org.junit.AfterClass;
import org.junit.Test;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.EnumReturnType;
import fr.mailjet.rest.MessageRESTService;
import fr.mailjet.rest.parameters.EnumMessageCampaignsParameters;
import fr.mailjet.rest.parameters.EnumMessageListParameters;

/**
 * Tests unitaires de base pour le service "message".
 * @see MessageRESTService
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public final class MessageRESTServiceTest extends AbstractServiceTestBase {

  // En static pour close après les tests.
  static private MessageRESTService _service;

  @AfterClass
  static public void afterClass() {
    _service.close();
    _service = null;
  }

  public MessageRESTServiceTest(final EnumReturnType parType) {
    super(parType);
    _service = new RESTServiceFactory(_context).createMessageService();
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
  public final void testCampaignsEnumReturnType() {
    // Les paramètres spécifiques ne sont pas testés car dépendant de l'utilisateur, on considère que le status
    // vérifie correctement le bon niveau du test.
    final String locResult = _service.campaigns(_type);
    checkStatus(locResult);
  }

  @Test(timeout = 10000L)
  public final void testCampaignsEnumReturnTypeInteger() {
    final Integer locCount = Integer.valueOf(1);
    final String locResult = _service.campaigns(_type, locCount);
    checkStatus(locResult);
    checkParameter(locResult, "cnt", "1");
  }

  @Test(timeout = 10000L)
  public final void testCampaignsEnumReturnTypeEnumMap() {
    final EnumMap<EnumMessageCampaignsParameters, String> locParameters = new EnumMap<EnumMessageCampaignsParameters, String>(EnumMessageCampaignsParameters.class);
    locParameters.put(EnumMessageCampaignsParameters.LIMIT, "1");
    locParameters.put(EnumMessageCampaignsParameters.ORDER_BY, "DESC");
    final String locResult = _service.campaigns(_type, locParameters);
    checkStatus(locResult);
    checkParameter(locResult, "cnt", "1");
  }

  @Test(timeout = 10000L)
  public final void testContactsEnumReturnTypeInteger() {
    final String locResult = _service.contacts(_type, CAMPAIGN_ID);
    checkStatus(locResult);
    checkMinimumIntegerParameter(locResult, "total_cnt", Integer.valueOf(1));
  }

  @Test(timeout = 10000L)
  public final void testContactsEnumReturnTypeIntegerEnumMap() {
    final EnumMap<EnumMessageCampaignsParameters, String> locParameters = new EnumMap<EnumMessageCampaignsParameters, String>(EnumMessageCampaignsParameters.class);
    locParameters.put(EnumMessageCampaignsParameters.LIMIT, "1");
    locParameters.put(EnumMessageCampaignsParameters.ORDER_BY, "DESC");
    final String locResult = _service.contacts(_type, CAMPAIGN_ID, locParameters);
    checkStatus(locResult);
    checkMinimumIntegerParameter(locResult, "total_cnt", Integer.valueOf(1));
  }

  @Test(timeout = 10000L)
  public final void testHtmlCampaign() {
    _logger.warning("Error 400 Bad request. Method not implemented yet.");
  }

  @Test(timeout = 10000L)
  public final void testListEnumReturnType() {
    final String locResult = _service.list(_type);
    checkStatus(locResult);
    checkMinimumIntegerParameter(locResult, "total_cnt", Integer.valueOf(1));
  }

  @Test(timeout = 10000L)
  public final void testListEnumReturnTypeEnumMapOfEnumMessageListParametersString() {
    final EnumMap<EnumMessageListParameters, String> locParameters = new EnumMap<EnumMessageListParameters, String>(EnumMessageListParameters.class);
    locParameters.put(EnumMessageListParameters.LIMIT, "1");
    final String locResult = _service.list(_type, locParameters);
    checkStatus(locResult);
    checkMinimumIntegerParameter(locResult, "total_cnt", Integer.valueOf(1));
  }

  @Test(timeout = 10000L)
  public final void testStatistics() {
    final String locResult = _service.statistics(_type, CAMPAIGN_ID);
    checkStatus(locResult);
  }

  @Test(timeout = 10000L)
  public final void testTplCategories() {
    final String locResult = _service.tplCategories(_type);
    checkStatus(locResult);
    checkParameter(locResult, "label", "basic");
  }

  @Test(timeout = 10000L)
  public final void testTplModelsEnumReturnType() {
    final String locResult = _service.tplModels(_type);
    checkStatus(locResult);
  }

  @Test(timeout = 10000L)
  public final void testTplModelsEnumReturnTypeInteger() {
    final String locResult = _service.tplModels(_type, Integer.valueOf(1));
    checkStatus(locResult);
  }

  @Test(timeout = 10000L)
  public final void testTplModelsEnumReturnTypeIntegerBoolean() {
    final String locResult = _service.tplModels(_type, Integer.valueOf(1), Boolean.FALSE);
    checkStatus(locResult);
  }

  @Test(timeout = 10000L)
  public final void testTplModelsEnumReturnTypeLocale() {
    final String locResult = _service.tplModels(_type, Integer.valueOf(1), Boolean.FALSE, Locale.getDefault());
    checkStatus(locResult);
  }
}
