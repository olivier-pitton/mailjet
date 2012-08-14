package fr.mailjet.context;

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

/**
 * Une classe contexte contenant toutes les informations pour se connecter via
 * les emails ou l'api REST.
 * 
 * @author Pitton Olivier
 * 
 */
public class MailjetContext {
	/**
	 * version de l'API REST
	 */
	static final private String API_VERSION = "0.1";
	/**
	 * Host mail
	 */
	static final private String MAILJET_HOST = "in.mailjet.com";
	/**
	 * Url pour l'API REST
	 */
	static final private String REST_URL = "https://api.mailjet.com/" + API_VERSION + "/";

	/**
	 * Retourne l'URL par défaut de connexion aux services REST
	 * 
	 * @return {@link String} l'URL par défaut de connexion aux services REST
	 */
	static final public String getRestUrl() {
		return REST_URL;
	}

	/**
	 * Retourne l'URL par défaut du service mail.
	 * 
	 * @return {@link String} l'URL par défaut du service mail.
	 */
	static final public String getHostname() {
		return MAILJET_HOST;
	}

	private String _apiKey;
	private String _secretKey;
	private int _smtpPort;
	private boolean _useSSL;

	/**
	 * Constructeur
	 * 
	 * @param parApiKey
	 *          {@link String} la clé publique du compte
	 * @param parSecretKey
	 *          {@link String} la clé privée du compte
	 */
	public MailjetContext(String parApiKey, String parSecretKey) {
		this(parApiKey, parSecretKey, 465);
	}

	/**
	 * Constructeur
	 * 
	 * @param parApiKey
	 *          {@link String} la clé publique du compte
	 * @param parSecretKey
	 *          {@link String} la clé privée du compte
	 * @param parSmtpPort
	 *          {@code int} le port SMTP
	 */
	public MailjetContext(String parApiKey, String parSecretKey, int parSmtpPort) {
		this(parApiKey, parSecretKey, parSmtpPort, true);
	}

	/**
	 * Constructeur
	 * 
	 * @param parApiKey
	 *          {@link String} la clé publique du compte
	 * @param parSecretKey
	 *          {@link String} la clé privée du compte
	 * @param parSmtpPort
	 *          {@code int} le port SMTP
	 */
	public MailjetContext(String parApiKey, String parSecretKey, int parSmtpPort, boolean parUseSSL) {
		super();
		this._apiKey = parApiKey;
		this._secretKey = parSecretKey;
		this._smtpPort = parSmtpPort;
		this._useSSL = parUseSSL;
	}

	/**
	 * Retourne le port SMTP sur lequel les mails sont envoyés. La valeur par
	 * défaut est 465.
	 * 
	 * @return {@code int} le port SMTP sur lequel les mails sont envoyés
	 */
	public int getSmtpPort() {
		return this._smtpPort;
	}

	/**
	 * Modifie le port SMTP sur lequel les mails sont envoyés.
	 * 
	 * @param parSmtpPort
	 *          {@link String} le nouveau port SMTP
	 */
	public void setSmtpPort(int parSmtpPort) {
		this._smtpPort = parSmtpPort;
	}

	/**
	 * Retourne vrai si le SSL est activé
	 * 
	 * @see fr.mailjet.mail.MailjetEmail
	 * @return {@code boolean} vrai si le SSL est activé
	 */
	public boolean isUseSSL() {
		return this._useSSL;
	}

	/**
	 * Modifie l'activation du SSL
	 * 
	 * @param parUseSSL
	 *          {@code boolean} la nouvelle valeur d'activation du SSL
	 */
	public void setUseSSL(boolean parUseSSL) {
		this._useSSL = parUseSSL;
	}

	/**
	 * Retourne la clé publique OAuth de l'utilisateur courant.
	 * 
	 * @return {@link String} la clé publique OAuth de l'utilisateur courant.
	 */
	public String getApiKey() {
		return this._apiKey;
	}

	/**
	 * Modifie la clé publique OAuth de l'utilisateur courant.
	 * 
	 * @param parApiKey
	 *          {@link String} la nouvelle clé publique
	 */
	public void setApiKey(String parApiKey) {
		this._apiKey = parApiKey;
	}

	/**
	 * Retourne la clé secrète OAuth de l'utilisateur courant.
	 * 
	 * @return {@link String} la clé secrète OAuth de l'utilisateur courant.
	 */
	public String getSecretKey() {
		return this._secretKey;
	}

	/**
	 * Modifie la clé secrète OAuth de l'utilisateur courant.
	 * 
	 * @param parSecretKey
	 *          {@link String} la nouvelle clé secrète
	 */
	public void setSecretKey(String parSecretKey) {
		this._secretKey = parSecretKey;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this._apiKey == null ? 0 : this._apiKey.hashCode());
		result = prime * result + (this._secretKey == null ? 0 : this._secretKey.hashCode());
		result = prime * result + this._smtpPort;
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MailjetContext))
			return false;
		MailjetContext other = (MailjetContext) obj;
		if (this._apiKey == null) {
			if (other._apiKey != null)
				return false;
		} else if (!this._apiKey.equals(other._apiKey))
			return false;
		if (this._secretKey == null) {
			if (other._secretKey != null)
				return false;
		} else if (!this._secretKey.equals(other._secretKey))
			return false;
		if (this._smtpPort != other._smtpPort)
			return false;
		return true;
	}
}
