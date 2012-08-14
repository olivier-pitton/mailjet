package fr.mailjet.event;

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
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Implémentation de base d'un évènement d'ouverture de mail.<br />
 * <a href="https://fr.mailjet.com/docs/event_tracking">Documentation
 * Mailjet</a>
 * 
 * @author Pitton Olivier
 * 
 */
public class OpenMailjetEvent extends AMailjetCampaignEvent {

	private static final long serialVersionUID = -1194599598775492542L;
	/**
	 * L'adresse IP (IPv4 ou IPv6)
	 */
	@JsonProperty(value = "ip")
	private String _ip;
	/**
	 * Code du pays de l'adresse IP
	 */
	@JsonProperty(value = "geo")
	private String _geo;
	/**
	 * Agent-utilisateur
	 */
	@JsonProperty(value = "agent")
	private String _agent;

	/**
	 * Constructeur
	 */
	public OpenMailjetEvent() {
		super();
	}

	protected OpenMailjetEvent(final String parEvent, final Long parTime, final String parEmail, final String parCampaignId, final String parContactId, final String parCustomCampaign,
			final String parIpAddress, final String parGeo, final String parAgent) {
		super(parEvent, parTime, parEmail, parCampaignId, parContactId, parCustomCampaign);
		this._ip = parIpAddress;
		this._geo = parGeo;
		this._agent = parAgent;
	}

	/**
	 * Retourne l'agent utilisateur
	 * 
	 * @return {@link String} l'agent utilisateur
	 */
	public String getAgent() {
		return this._agent;
	}

	/**
	 * Retourne le code du pays de l'adresse IP
	 * 
	 * @return {@link String} le code du pays de l'adresse IP
	 */
	public String getGeo() {
		return this._geo;
	}

	/**
	 * Retourne l'adresse IP (IPv4 ou IPv6)
	 * 
	 * @return {@link String} l'adresse IP (IPv4 ou IPv6)
	 */
	public String getIp() {
		return this._ip;
	}

	/**
	 * Modifie l'agent utilisateur
	 * 
	 * @param parAgent
	 *          {@link String} le nouvel agent utilisateur
	 */
	public void setAgent(final String parAgent) {
		this._agent = parAgent;
	}

	/**
	 * Modifie le code du pays de l'adresse IP
	 * 
	 * @param parGeo
	 *          {@link String} le nouveau code du pays de l'adresse IP
	 */
	public void setGeo(final String parGeo) {
		this._geo = parGeo;
	}

	/**
	 * Modifie l'adresse IP (IPv4 ou IPv6)
	 * 
	 * @param parIp
	 *          {@link String} la nouvelle adresse IP (IPv4 ou IPv6)
	 */
	public void setIp(final String parIp) {
		this._ip = parIp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object parObject) {
		if (this == parObject)
			return true;
		if (!super.equals(parObject))
			return false;
		if (!(parObject instanceof OpenMailjetEvent))
			return false;
		OpenMailjetEvent other = (OpenMailjetEvent) parObject;
		if (this._agent == null) {
			if (other._agent != null)
				return false;
		} else if (!this._agent.equals(other._agent))
			return false;
		if (this._geo == null) {
			if (other._geo != null)
				return false;
		} else if (!this._geo.equals(other._geo))
			return false;
		if (this._ip == null) {
			if (other._ip != null)
				return false;
		} else if (!this._ip.equals(other._ip))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this._agent == null ? 0 : this._agent.hashCode());
		result = prime * result + (this._geo == null ? 0 : this._geo.hashCode());
		result = prime * result + (this._ip == null ? 0 : this._ip.hashCode());
		return result;
	}

}
