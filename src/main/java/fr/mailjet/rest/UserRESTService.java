package fr.mailjet.rest;/*
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


import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * L'interface de tous les services de type <i>User</i>.
 * Cette interface comprend toutes les méthodes définies dans l'api officielle.
 * <a href="http://fr.mailjet.com/docs/api/user">Documentation</a> 
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public interface UserRESTService extends MailjetRESTService {

	/**
	 * Retourne les informations du compte et du profile courant.
	 * <a href="https://fr.mailjet.com/docs/api/user/infos">doc</a>
	 * @param parReturnType {@link EnumReturnType} le format de retour de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException si le type de retour  est null
	 * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300 
	 */
	String infos(final EnumReturnType parReturnType) throws UniformInterfaceException;

	/**
	 * Retourne la liste des domaines depuis les adresses d'envoi.
	 * <a href="https://fr.mailjet.com/docs/api/user/domainlist">doc</a>
	 * @param parReturnType {@link EnumReturnType} le format de retour de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException si le type de retour  est null
	 * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300 
	 */
	String domainList(final EnumReturnType parReturnType) throws UniformInterfaceException;

	/**
	 * 
	 * <a href="https://fr.mailjet.com/docs/api/user/senderlist">doc</a>
	 * @param parReturnType {@link EnumReturnType} le format de retour de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException si le type de retour  est null
	 * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300 
	 */
	String senderList(final EnumReturnType parReturnType) throws UniformInterfaceException;

	/**
	 * Retourne les préférences de suivi.
	 * <a href="https://fr.mailjet.com/docs/api/user/trackingcheck">doc</a>
	 * @param parReturnType {@link EnumReturnType} le format de retour de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException si le type de retour  est null
	 * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300 
	 */
	String trackingCheck(final EnumReturnType parReturnType) throws UniformInterfaceException;

}
