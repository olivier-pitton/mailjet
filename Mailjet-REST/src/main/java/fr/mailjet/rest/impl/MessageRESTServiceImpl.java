package fr.mailjet.rest.impl;/*
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


import java.util.HashMap;import java.util.Locale;import java.util.Map;import javax.ws.rs.core.MultivaluedMap;import org.apache.commons.lang3.StringUtils;import com.sun.jersey.api.client.Client;import com.sun.jersey.api.client.UniformInterfaceException;import fr.mailjet.context.MailjetContext;import fr.mailjet.rest.MessageRESTService;import fr.mailjet.rest.parameters.EnumReturnType;
/**
 * Une implémentation par défaut du service <i>Message</i>
 *
 * @author Pitton Olivier
 *
 */
public class MessageRESTServiceImpl extends AbstractRESTService implements MessageRESTService {
	/**	 * Clé du paramètre "limit" de la requête campaigns.<br /><a 	 * href="https://fr.mailjet.com/docs/api/message/campaigns">Documentation Mailjet</a>	 */	static final private String _limitCampaign = "limit";	/**	 * Clé du paramètre "id" de différentes requêtes (statistiques, ...)	 */	static final private String _idCampaign = "id";	/**	 * Clé du paramètre "category" de la requête tplModel.<br /><a 	 * href="https://fr.mailjet.com/docs/api/message/tplmodels">Documentation Mailjet</a>	 */	static final private String _categoryTplModel = "category";	/**	 * Clé du paramètre "custom" de la requête tplModel.<br /><a 	 * href="https://fr.mailjet.com/docs/api/message/tplmodels">Documentation Mailjet</a>	 */	static final private String _customTplModel = "custom";	/**	 * Clé du paramètre "locale" de la requête tplModel.<br /><a 	 * href="https://fr.mailjet.com/docs/api/message/tplmodels">Documentation Mailjet</a>	 */	static final private String _localeTplModel = "locale";		/**	 * Clé du paramètre "email"	 * @see #testCampaign(EnumReturnType, Integer, String)	 */	static final private String _email = "email";	/**	 * Clé du paramètre "html"	 * @see #setHtmlCampaign(EnumReturnType, String, Integer)	 * @see #setHtmlCampaign(EnumReturnType, String, Integer, String)	 */	static final private String _html = "html";	/**	 * Clé du paramètre "text"	 * @see #setHtmlCampaign(EnumReturnType, String, Integer, String)	 */	static final private String _text = "text";	/**	 * Constructeur	 * @param parContext {@link MailjetContext} un contexte	 * @param parClient {@link Client} un client HTTP	 */
	protected MessageRESTServiceImpl(MailjetContext parContext, Client parClient) {
    super(parContext, parClient);
  }

  @Override
  public String campaigns(EnumReturnType parType) throws UniformInterfaceException {
    return campaigns(parType, (Integer) null);
  }

  @Override
  public String campaigns(EnumReturnType parType, Integer parLimit) throws UniformInterfaceException {
    if(parLimit == null) {
      return campaigns(parType, (Map<String, String>) null);
    }
    Map<String, String> locParameters = new HashMap<String, String>(2);
    locParameters.put(_limitCampaign, parLimit.toString());
    return campaigns(parType, locParameters);
  }

  @Override
  public String campaigns(EnumReturnType parType, Map<String, String> parMap) throws IllegalArgumentException, UniformInterfaceException {
    MultivaluedMap<String, String> locProperties = createHTTPProperties(parType);
    String locURL = "messageCampaigns";
    if(parMap == null || parMap.isEmpty()) {
      return createGETRequest(locURL, locProperties);
    }
    for(Map.Entry<String, String> locEntry : parMap.entrySet()) {
      locProperties.putSingle(locEntry.getKey(), locEntry.getValue());
    }
    return createGETRequest(locURL, locProperties);
  }

  @Override
  public String contacts(EnumReturnType parType, Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException {
    return contacts(parType, parCampaignId, null);
  }

  @Override
  public String contacts(EnumReturnType parType, Integer parCampaignId, Map<String, String> parMap) throws UniformInterfaceException, IllegalArgumentException {
    if (parCampaignId == null) {
      throw new IllegalArgumentException();
    }
    MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    // On ajoute l'id de la campagne
    locParameters.putSingle(_idCampaign, parCampaignId.toString());
    String locURL = "messageContacts";
    // Si aucun paramètre on lance la requête 
    if (parMap == null) {
      return createGETRequest(locURL, locParameters);
    }
    // On rajoute tous les paramètres
    for (Map.Entry<String, String> locCampaignEntry : parMap.entrySet()) {
      locParameters.putSingle(locCampaignEntry.getKey(), locCampaignEntry.getValue());
    }
    return createGETRequest(locURL, locParameters);
  }

  @Override
  public String htmlCampaign(EnumReturnType parType, Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException {
    if (parCampaignId == null) {
      throw new IllegalArgumentException();
    }
    MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    locParameters.putSingle(_idCampaign, parCampaignId.toString());
    return createGETRequest("messageHtmlcampaign", locParameters);
  }

  @Override
  public String list(EnumReturnType parType) throws UniformInterfaceException {
    return list(parType, null);
  }

  @Override
  public String list(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {
    String locURL = "messageList";
    if (parParameters == null) {
      return createGETRequest(parType, locURL);
    }
    MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    for (Map.Entry<String, String> locEntry : parParameters.entrySet()) {
      locParameters.putSingle(locEntry.getKey(), locEntry.getValue());
    }
    return createGETRequest(locURL, locParameters);
  }

  @Override
  public String statistics(EnumReturnType parType, Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException {
    if (parCampaignId == null) {
      throw new IllegalArgumentException();
    }

    MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    locParameters.putSingle(_idCampaign, parCampaignId.toString());
    return createGETRequest("messageStatistics", locParameters);
  }

  @Override
  public String tplCategories(EnumReturnType parType) throws UniformInterfaceException {
    return createGETRequest(parType, "messageTplcategories");
  }

  @Override
  public String tplModels(EnumReturnType parType) throws UniformInterfaceException {
    return tplModels(parType, (Integer) null);
  }

  @Override
  public String tplModels(EnumReturnType parType, Integer parCategory) throws UniformInterfaceException {
    return tplModels(parType, parCategory, null);
  }

  @Override
  public String tplModels(EnumReturnType parType, Integer parCategory, Boolean parCustom) throws UniformInterfaceException {
    return tplModels(parType, parCategory, parCustom, Locale.getDefault());
  }

  @Override
  public String tplModels(EnumReturnType parType, Integer parCategory, Boolean parCustom, Locale parLocale) throws UniformInterfaceException {
    MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
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
  }	@Override	public String createCampaign(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);		for(Map.Entry<String, String> locEntry : parParameters.entrySet()) {			locParameters.putSingle(locEntry.getKey(), locEntry.getValue());		}		return createPOSTRequest("messageCreatecampaign", locParameters);	}	@Override	public String duplicateCampaign(EnumReturnType parType, Integer parCampaignId, Map<String, String> parParameters) throws UniformInterfaceException, IllegalArgumentException {		if(parCampaignId == null) throw new IllegalArgumentException();		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);		locParameters.putSingle(_idCampaign, parCampaignId.toString());		for(Map.Entry<String, String> locEntry : parParameters.entrySet()) {			locParameters.putSingle(locEntry.getKey(), locEntry.getValue());		}		return createPOSTRequest("messageDuplicatecampaign", locParameters);	}	@Override	public String sendCampaign(EnumReturnType parType, Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException {		if(parCampaignId == null) throw new IllegalArgumentException();		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);		locParameters.putSingle(_idCampaign, parCampaignId.toString());		return createPOSTRequest("messageSendcampaign", locParameters);	}	@Override	public String setHtmlCampaign(EnumReturnType parType, String parHtml, Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException {		return setHtmlCampaign(parType, parHtml, parCampaignId, null);	}	@Override	public String setHtmlCampaign(EnumReturnType parType, String parHtml, Integer parCampaignId, String parText) throws UniformInterfaceException, IllegalArgumentException {		if(parCampaignId == null || StringUtils.isEmpty(parHtml)) throw new IllegalArgumentException();		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);		locParameters.putSingle(_idCampaign, parCampaignId.toString());		locParameters.putSingle(_html, parHtml);		if(StringUtils.isNotEmpty(parText)) {			locParameters.putSingle(_text, parText);		}		return createPOSTRequest("messageSethtmlcampaign", locParameters);	}	@Override	public String testCampaign(EnumReturnType parType, Integer parCampaignId, String parEmail) throws UniformInterfaceException, IllegalArgumentException {		if(parCampaignId == null || StringUtils.isEmpty(parEmail)) throw new IllegalArgumentException();		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);		locParameters.putSingle(_idCampaign, parCampaignId.toString());		locParameters.putSingle(_email, parEmail);		return createPOSTRequest("messageTestcampaign", locParameters);	}	@Override	public String updateCampaign(EnumReturnType parType, Integer parCampaignId, Map<String, String> parParameters) throws UniformInterfaceException, IllegalArgumentException {		if(parCampaignId == null || parParameters == null || parParameters.isEmpty()) throw new IllegalArgumentException();				MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);		locParameters.putSingle(_idCampaign, parCampaignId.toString());		if(parParameters != null) {			for(Map.Entry<String, String> locEntry : parParameters.entrySet()) {				locParameters.putSingle(locEntry.getKey(), locEntry.getValue());			}		}		return createPOSTRequest("messageUpdatecampaign", locParameters);	}
}
