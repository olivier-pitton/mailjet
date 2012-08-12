package fr.mailjet.context;
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

/**
 * Une classe contexte contenant toutes les informations pour se connecter 
 * via les emails ou l'api REST.
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public final class MailjetContext {
	/**
	 * version de l'API REST
	 */
  static private final String API_VERSION = "0.1";
  /**
   * Host mail
   */
	static private final String MAILJET_HOST = "in.mailjet.com";
	/**
	 * Url pour l'API REST
	 */
	static private final String REST_URL = "https://api.mailjet.com/" + API_VERSION + "/";
	
	/**
	 * Retourne l'URL par défaut de connexion aux services REST 
	 * @return {@link String} l'URL par défaut de connexion aux services REST
	 */
	static public final String getRestUrl() {
		return REST_URL;
	}
	
	/**
	 * Retourne l'URL par défaut du service mail.
	 * @return {@link String} l'URL par défaut du service mail.
	 */
	static public final String getHostname() {
		return MAILJET_HOST;
	}
	
	private String _apiKey;
	private String _secretKey;
	private int _smtpPort = 465;

	/**
	 * Constructeur
	 * @param parApiKey {@link String} la clé publique du compte
	 * @param parSecretKey {@link String} la clé privée du compte
	 */
	public MailjetContext(final String parApiKey, final String parSecretKey) {
		super();
		this._apiKey = parApiKey;
		this._secretKey = parSecretKey;
	}
	
	/**
	 * Retourne le port SMTP sur lequel les mails sont envoyés. La valeur par défaut
	 * est 465.
	 * @return {@code int} le port SMTP sur lequel les mails sont envoyés
	 */
	public final int getSmtpPort() {
		return this._smtpPort;
	}

	/**
	 * Modifie le port SMTP sur lequel les mails sont envoyés.
	 * @param parSmtpPort {@link String} le nouveau port SMTP
	 */
	public final void setSmtpPort(final int parSmtpPort) {
		this._smtpPort = parSmtpPort;
	}

	/**
	 * Retourne la clé publique OAuth de l'utilisateur courant.
	 * @return {@link String} la clé publique OAuth de l'utilisateur courant.
	 */
	public final String getApiKey() {
		return this._apiKey;
	}

	/**
	 * Modifie la clé publique OAuth de l'utilisateur courant.
	 * @param parApiKey {@link String} la nouvelle clé publique
	 */
	public final void setApiKey(final String parApiKey) {
		this._apiKey = parApiKey;
	}


	/**
	 * Retourne la clé secrète OAuth de l'utilisateur courant.
	 * @return {@link String} la clé secrète OAuth de l'utilisateur courant.
	 */
	public final String getSecretKey() {
		return this._secretKey;
	}


	/**
	 * Modifie la clé secrète OAuth de l'utilisateur courant.
	 * @param parSecretKey {@link String} la nouvelle clé secrète
	 */
	public final void setSecretKey(final String parSecretKey) {
		this._secretKey = parSecretKey;
	}
}
