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
 * Implémentation de base d'un évènement de clic sur un lien dans un mail. <br />
 * <a href="https://fr.mailjet.com/docs/event_tracking">Documentation
 * Mailjet</a>
 * 
 * @author Pitton Olivier
 * 
 */
public class ClickMailjetEvent extends OpenMailjetEvent {

	private static final long serialVersionUID = -1194599598775492542L;

	/**
	 * L'url du lien sur lequel l'utilisateur a cliqué
	 */
	@JsonProperty("url")
	private String _url;

	/**
	 * Constructeur
	 */
	public ClickMailjetEvent() {
		super();
	}

	protected ClickMailjetEvent(final String parEvent, final Long parTime, final String parEmail, final String parCampaignId, final String parContactId, final String parCustomCampaign,
			final String parIpAddress, final String parGeo, final String parAgent, final String parUrl) {

		super(parEvent, parTime, parEmail, parCampaignId, parContactId, parCustomCampaign, parIpAddress, parGeo, parAgent);
		this._url = parUrl;
	}

	/**
	 * Retourne l'url du lien sur lequel l'utilisateur a cliqué
	 * @return {@link String} l'url du lien sur lequel l'utilisateur a cliqué
	 */
	public String getUrl() {
		return this._url;
	}

	/**
	 * Modifie l'url du lien sur lequel l'utilisateur a cliqué
	 * @param parURL {@link String} la nouvelle url du lien sur lequel l'utilisateur a cliqué
	 */
	public void setUrl(final String parURL) {
		this._url = parURL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this._url == null ? 0 : this._url.hashCode());
		return result;
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
		if (this.getClass() != parObject.getClass())
			return false;
		ClickMailjetEvent other = (ClickMailjetEvent) parObject;
		if (this._url == null) {
			if (other._url != null)
				return false;
		} else if (!this._url.equals(other._url))
			return false;
		return true;
	}
}
