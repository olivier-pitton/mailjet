package fr.mailjet.webservice;

/*
 *  Mailjet %% Copyright (C) 2012 Pitton Olivier - olivier dot pitton at
 * gmail dot com %% Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License. 
 */

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * Classe de configuration permettant d'enregistrer tous les services web à
 * déployer. Cette classe sera scannée par le serveur d'application au démarrage
 * et tous les services web de l'{@link Application} seront déployés.
 * 
 * @see Application
 * @author Pitton Olivier
 * 
 */
public class MailjetApplication extends Application {

	static final private Set<Class<?>> empty = new HashSet<Class<?>>(0);

	private final Set<Object> singletons = new HashSet<Object>(1);

	/**
	 * Constructeur
	 */
	public MailjetApplication() {
		this.singletons.add(new MailjetWebservice());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}
}
