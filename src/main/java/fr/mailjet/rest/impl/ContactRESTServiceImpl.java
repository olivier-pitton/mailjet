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


import java.util.Map;import javax.ws.rs.core.MultivaluedMap;import com.sun.jersey.api.client.Client;import com.sun.jersey.api.client.UniformInterfaceException;import fr.mailjet.context.MailjetContext;import fr.mailjet.rest.ContactRESTService;import fr.mailjet.rest.EnumReturnType;import fr.mailjet.rest.parameters.EnumContactListParameters;
/**
 * L'implémentation par défaut du service contact
 *
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public final class ContactRESTServiceImpl extends AbstractRESTService implements ContactRESTService {
	/**	 * Constructeur	 * @param parContext {@link MailjetContext} un contexte	 * @param parClient {@link Client} un client HTTP	 */
  ContactRESTServiceImpl(final MailjetContext parContext, final Client parClient) {
    super(parContext, parClient);
  }

  @Override
  public final String infos(final EnumReturnType parType, final String parEmail) throws UniformInterfaceException, IllegalArgumentException {
    if (parEmail == null || parEmail.isEmpty()) {
      throw new IllegalArgumentException();
    }
    final MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    locParameters.putSingle(_infoMail, parEmail);
    return createGETRequest("contactInfos", locParameters);
  }

  @Override
  public final String list(final EnumReturnType parType) throws UniformInterfaceException {
    return list(parType, null);
  }

  @Override
  public final String list(final EnumReturnType parType, final Map<EnumContactListParameters, String> parParameters) throws UniformInterfaceException {
    final String locURL = "contactList";
    if (parParameters == null) {
      return createGETRequest(parType, locURL);
    }
    final MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
    for (final Map.Entry<EnumContactListParameters, String> locValue : parParameters.entrySet()) {
      locParameters.putSingle(locValue.getKey().getValue(), locValue.getValue());
    }
    return createGETRequest(locURL, locParameters);
  }

  @Override
  public final String openers(final EnumReturnType parType) throws UniformInterfaceException {
    return openers(parType, (Long) null);
  }

  @Override
  public final String openers(final EnumReturnType parType, final Long parLastActivity) throws UniformInterfaceException {
    return openers(parType, parLastActivity, null);
  }

  @Override
  public final String openers(final EnumReturnType parType, final Long parLastActivity, final Integer parLimit) throws UniformInterfaceException {
    return openers(parType, parLastActivity, parLimit, null);
  }

  @Override
  public final String openers(final EnumReturnType parType, final Long parLastActivity, final Integer parLimit, final Integer parStart) throws UniformInterfaceException {
    final MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
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
