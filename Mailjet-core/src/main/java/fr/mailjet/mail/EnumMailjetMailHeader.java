package fr.mailjet.mail;

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

import fr.mailjet.util.IWithConstName;

/**
 * Enumération de tous les headers mail spécifiques à Mailjet <a
 * href="https://fr.mailjet.com/docs/emails_headers">headers</a>
 * 
 * @author Pitton Olivier
 * 
 */
public enum EnumMailjetMailHeader implements IWithConstName {
	/**
	 * Ajoute un identifiant unique au mail par campagne afin de regrouper tous
	 * les mails dans une même ligne
	 */
	CAMPAIGN("X-Mailjet-Campaign"),
	/**
	 * Evite les doublons lors de l'envoi de mail. A utiliser avec
	 * {@link EnumMailjetMailHeader#CAMPAIGN}
	 */
	DEDUPLICATE_CAMPAIGN("X-Mailjet-DeduplicateCampaign"),
	/**
	 * Indique si l'on veut activer le tracking. Outrepasse les droits du compte
	 * utilisateur
	 */
	TRACK_OPEN("X-Mailjet-TrackOpen"),
	/**
	 * Indique si l'on veut activer le tracking sur le clic des mails. Outrepasse
	 * les droits du compte utilisateur
	 */
	TRACK_CLICK("X-Mailjet-TrackClick");

	private String _name;

	private EnumMailjetMailHeader(String parName) {
		this._name = parName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getConstName() {
		return this._name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.getConstName();
	}

}
