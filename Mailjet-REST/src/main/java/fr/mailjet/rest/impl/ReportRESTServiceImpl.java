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

import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.ReportRESTService;
import fr.mailjet.rest.parameters.EnumReturnType;

/**
 * L'implémentation par défaut des services report
 * 
 * @author Pitton Olivier
 * 
 */
public class ReportRESTServiceImpl extends AbstractRESTService implements ReportRESTService {

	/**
	 * Clé du paramètre "campaign_id" 
	 * @see #emailInfos(EnumReturnType, Integer)
	 */
	private static final String _campaignId = "campaign_id";
	

	protected ReportRESTServiceImpl(MailjetContext parContext, Client parClient) {
		super(parContext, parClient);
	}

	@Override
	public String click(EnumReturnType parType) throws UniformInterfaceException {
		return click(parType, null);
	}

	@Override
	public String click(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {
		return createGETRequest("reportClick", fillParameters(parType, parParameters));
	}

	@Override
	public String domain(EnumReturnType parType) throws UniformInterfaceException {
		return domain(parType, null);
	}

	@Override
	public String domain(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {
		return createGETRequest("reportDomain", fillParameters(parType, parParameters));
	}

	@Override
	public String emailBounce(EnumReturnType parType) throws UniformInterfaceException {
		return emailBounce(parType, null);
	}

	@Override
	public String emailBounce(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {
		return createGETRequest("reportEmailbounce", fillParameters(parType, parParameters));
	}

	@Override
	public String emailClients(EnumReturnType parType) throws UniformInterfaceException {
		return emailClients(parType, null);
	}

	@Override
	public String emailClients(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {
		return createGETRequest("reportEmailclients", fillParameters(parType, parParameters));
	}

	@Override
	public String emailInfos(EnumReturnType parType, Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException {
		if (parCampaignId == null)
			throw new IllegalArgumentException();

		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		locParameters.putSingle(_campaignId, parCampaignId.toString());
		return createGETRequest("reportEmailinfos", locParameters);
	}

	@Override
	public String emailSent(EnumReturnType parType) throws UniformInterfaceException {
		return emailSent(parType, null);
	}

	@Override
	public String emailSent(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {
		return createGETRequest("reportEmailsent", fillParameters(parType, parParameters));
	}

	@Override
	public String emailStatistics(EnumReturnType parType) throws UniformInterfaceException {
		return emailStatistics(parType, null);
	}

	@Override
	public String emailStatistics(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {
		return createGETRequest("reportEmailstatistics", fillParameters(parType, parParameters));
	}

	@Override
	public String geoIp(EnumReturnType parType) throws UniformInterfaceException {
		return geoIp(parType, null);
	}

	@Override
	public String geoIp(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {
		return createGETRequest("reportGeoip", fillParameters(parType, parParameters));
	}

	@Override
	public String open(EnumReturnType parType) throws UniformInterfaceException {
		return open(parType, null);
	}

	@Override
	public String open(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {
		return createGETRequest("reportOpen", fillParameters(parType, parParameters));
	}

	@Override
	public String openedStatistics(EnumReturnType parType) throws UniformInterfaceException {
		return openedStatistics(parType, null);
	}

	@Override
	public String openedStatistics(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {
		return createGETRequest("reportOpenedstatistics", fillParameters(parType, parParameters));
	}

	@Override
	public String userAgents(EnumReturnType parType) throws UniformInterfaceException {
		return userAgents(parType, null);
	}

	@Override
	public String userAgents(EnumReturnType parType, Map<String, String> parParameters) throws UniformInterfaceException {
		return createGETRequest("reportUseragents", fillParameters(parType, parParameters));
	}

	private MultivaluedMap<String, String> fillParameters(EnumReturnType parType, Map<String, String> parParameters) {
		MultivaluedMap<String, String> locParameters = createHTTPProperties(parType);
		if (parParameters != null) {
			for (Map.Entry<String, String> locEntry : parParameters.entrySet()) {
				locParameters.putSingle(locEntry.getKey(), locEntry.getValue());
			}
		}
		return locParameters;
	}

}
