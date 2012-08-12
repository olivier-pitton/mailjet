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


import java.util.Map;import javax.ws.rs.core.MultivaluedMap;import org.apache.commons.lang3.StringUtils;import com.sun.jersey.api.client.Client;import com.sun.jersey.api.client.UniformInterfaceException;import fr.mailjet.context.MailjetContext;import fr.mailjet.rest.ContactRESTService;import fr.mailjet.rest.parameters.EnumReturnType;
/**
 * L'implémentation par défaut du service contact
 *
 * @author Pitton Olivier
 *
 */
public class ContactRESTServiceImpl extends AbstractRESTService implements ContactRESTService {
	/**	 * Clé du paramètre "contact" de la requête infos.<br />	 * <a href="http://fr.mailjet.com/docs/api/contact/infos">Documentation	 * Mailjet</a>	 */	static final private String _infoMail = "contact";	/**	 * Clé du paramètre "last_activity" de la requête openers.<br />	 * <a href="http://fr.mailjet.com/docs/api/contact/openers">Documentation	 * Mailjet</a>	 */	static final private String _lastActivityOpener = "last_activity";	/**	 * Clé du paramètre "limit" de la requête openers.<br />	 * <a href="http://fr.mailjet.com/docs/api/contact/openers">Documentation	 * Mailjet</a>	 */	static final private String _limitOpener = "limit";	/**	 * Clé du paramètre "start" de la requête openers.<br />	 * <a href="http://fr.mailjet.com/docs/api/contact/openers">Documentation	 * Mailjet</a>	 */	static final private String _startOpener = "start";	/**	 * Constructeur	 * @param parContext {@link MailjetContext} un contexte	 * @param parClient {@link Client} un client HTTP	 */
	protected ContactRESTServiceImpl(MailjetContext parContext, Client parClient) {
    super(parContext, parClient);
  }

  @Override
  public String infos(EnumReturnType parType, String parEmail) throws UniformInterfaceException, IllegalArgumentException {
    if (StringUtils.isEmpty(parEmail)) {
      throw new IllegalArgumentException();
    }
    MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    locParameters.putSingle(_infoMail, parEmail);
    return createGETRequest("contactInfos", locParameters);
  }

  @Override
  public String list(EnumReturnType parType) throws UniformInterfaceException {
    return list(parType, null);
  }

  @Override
  public String list(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {
    String locURL = "contactList";
    if (parParameters == null) {
      return createGETRequest(parType, locURL);
    }
    MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    for (Map.Entry<String, String> locValue : parParameters.entrySet()) {
      locParameters.putSingle(locValue.getKey(), locValue.getValue());
    }
    return createGETRequest(locURL, locParameters);
  }

  @Override
  public String openers(EnumReturnType parType) throws UniformInterfaceException {
    return openers(parType, (Long) null);
  }

  @Override
  public String openers(EnumReturnType parType, Long parLastActivity) throws UniformInterfaceException {
    return openers(parType, parLastActivity, null);
  }

  @Override
  public String openers(EnumReturnType parType, Long parLastActivity, Integer parLimit) throws UniformInterfaceException {
    return openers(parType, parLastActivity, parLimit, null);
  }

  @Override
  public String openers(EnumReturnType parType, Long parLastActivity, Integer parLimit, Integer parStart) throws UniformInterfaceException {
    MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    if (parLastActivity != null) {
      locParameters.putSingle(_lastActivityOpener, parLastActivity.toString());
    }
    if (parLimit != null) {
      locParameters.putSingle(_limitOpener, parLimit.toString());
    }
    if (parStart != null) {
      locParameters.putSingle(_startOpener, parStart.toString());
    }
    return createGETRequest("contactOpeners", locParameters);
  }
}
