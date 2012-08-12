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


import java.util.EnumMap;import java.util.Locale;import java.util.Map;import javax.ws.rs.core.MultivaluedMap;import com.sun.jersey.api.client.Client;import com.sun.jersey.api.client.UniformInterfaceException;import fr.mailjet.context.MailjetContext;import fr.mailjet.rest.EnumReturnType;import fr.mailjet.rest.MessageRESTService;import fr.mailjet.rest.parameters.EnumMessageCampaignsParameters;import fr.mailjet.rest.parameters.EnumMessageListParameters;
/**
 * Une implémentation par défaut du service <i>Message</i>
 *
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public final class MessageRESTServiceImpl extends AbstractRESTService implements MessageRESTService {
	/**	 * Constructeur	 * @param parContext {@link MailjetContext} un contexte	 * @param parClient {@link Client} un client HTTP	 */
  MessageRESTServiceImpl(final MailjetContext parContext, final Client parClient) {
    super(parContext, parClient);
  }

  @Override
  public final String campaigns(final EnumReturnType parType) throws UniformInterfaceException {
    return campaigns(parType, (Integer) null);
  }

  @Override
  public final String campaigns(final EnumReturnType parType, final Integer parLimit) throws UniformInterfaceException {
    if(parLimit == null) {
      return campaigns(parType, (Map<EnumMessageCampaignsParameters, String>) null);
    }
    final Map<EnumMessageCampaignsParameters, String> locParameters = new EnumMap<EnumMessageCampaignsParameters, String>(EnumMessageCampaignsParameters.class);
    locParameters.put(EnumMessageCampaignsParameters.LIMIT, parLimit.toString());
    return campaigns(parType, locParameters);
  }

  @Override
  public final String campaigns(final EnumReturnType parType, final Map<EnumMessageCampaignsParameters, String> parMap) throws IllegalArgumentException, UniformInterfaceException {
    final MultivaluedMap<String, String> locProperties = createHTTPProperties(parType);
    final String locURL = "messageCampaigns";
    if(parMap == null || parMap.isEmpty()) {
      return createGETRequest(locURL, locProperties);
    }
    for(final Map.Entry<EnumMessageCampaignsParameters, String> locEntry : parMap.entrySet()) {
      locProperties.putSingle(locEntry.getKey().getValue(), locEntry.getValue());
    }
    return createGETRequest(locURL, locProperties);
  }

  @Override
  public final String contacts(final EnumReturnType parType, final Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException {
    return contacts(parType, parCampaignId, null);
  }

  @Override
  public final String contacts(final EnumReturnType parType, final Integer parCampaignId, final Map<EnumMessageCampaignsParameters, String> parMap) throws UniformInterfaceException, IllegalArgumentException {
    if (parCampaignId == null) {
      throw new IllegalArgumentException();
    }
    final MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    // On ajoute l'id de la campagne
    locParameters.putSingle(_idCampaign, parCampaignId.toString());
    final String locURL = "messageContacts";
    // Si aucun paramètre on lance la requête 
    if (parMap == null) {
      return createGETRequest(locURL, locParameters);
    }
    // On rajoute tous les paramètres
    for (final Map.Entry<EnumMessageCampaignsParameters, String> locCampaignEntry : parMap.entrySet()) {
      locParameters.putSingle(locCampaignEntry.getKey().getValue(), locCampaignEntry.getValue());
    }
    return createGETRequest(locURL, locParameters);
  }

  @Override
  public final String htmlCampaign(final EnumReturnType parType, final Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException {
    if (parCampaignId == null) {
      throw new IllegalArgumentException();
    }
    final MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    locParameters.putSingle("id", parCampaignId.toString());
    return createGETRequest("messageHtmlcampaign", locParameters);
  }

  @Override
  public final String list(final EnumReturnType parType) throws UniformInterfaceException {
    return list(parType, null);
  }

  @Override
  public final String list(final EnumReturnType parType, final Map<EnumMessageListParameters, String> parParameters) throws UniformInterfaceException {
    final String locURL = "messageList";
    if (parParameters == null) {
      return createGETRequest(parType, locURL);
    }
    final MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    for (final Map.Entry<EnumMessageListParameters, String> locEntry : parParameters.entrySet()) {
      locParameters.putSingle(locEntry.getKey().getValue(), locEntry.getValue());
    }
    return createGETRequest(locURL, locParameters);
  }

  @Override
  public final String statistics(final EnumReturnType parType, final Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException {
    if (parCampaignId == null) {
      throw new IllegalArgumentException();
    }

    final MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    locParameters.putSingle(_idCampaign, parCampaignId.toString());
    return createGETRequest("messageStatistics", locParameters);
  }

  @Override
  public final String tplCategories(final EnumReturnType parType) throws UniformInterfaceException {
    return createGETRequest(parType, "messageTplcategories");
  }

  @Override
  public final String tplModels(final EnumReturnType parType) throws UniformInterfaceException {
    return tplModels(parType, (Integer) null);
  }

  @Override
  public final String tplModels(final EnumReturnType parType, final Integer parCategory) throws UniformInterfaceException {
    return tplModels(parType, parCategory, null);
  }

  @Override
  public final String tplModels(final EnumReturnType parType, final Integer parCategory, final Boolean parCustom) throws UniformInterfaceException {
    return tplModels(parType, parCategory, parCustom, Locale.getDefault());
  }

  @Override
  public final String tplModels(final EnumReturnType parType, final Integer parCategory, final Boolean parCustom, final Locale parLocale) throws UniformInterfaceException {
    final MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    if (parCategory != null) {
      locParameters.putSingle(_categoryTplModel, parCategory.toString());
    }
    if (parCustom != null) {
      locParameters.putSingle(_customTplModel, parCustom.toString());
    }
    if (parLocale != null) {
      locParameters.putSingle(_localeTplModel, parLocale.toString());
    }
    return createGETRequest("messageTplcategories", locParameters);
  }
}
