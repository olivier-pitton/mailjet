package fr.mailjet.rest;

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

import com.sun.jersey.api.client.UniformInterfaceException;

import fr.mailjet.rest.impl.RESTServiceFactory;
import fr.mailjet.rest.parameters.EnumReturnType;

/**
 * L'interface de tous les services de type <i>Help</i>. Cette interface
 * comprend toutes les méthodes définies dans l'api officielle.<br />
 * <a href="https://fr.mailjet.com/docs/api/Help">Documentation Mailjet</a>
 * 
 * @see RESTServiceFactory#createHelpService()
 * @author Pitton Olivier
 * 
 */
public interface HelpRESTService extends MailjetRESTService {
	/**
	 * Retourne la liste de toutes les catégories de méthodes de l'API REST. <br />
	 * <a href="https://fr.mailjet.com/docs/api/Help/categories">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String categories(EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne la description et les méthodes d'une catégorie de l'API REST <br />
	 * <a href="https://fr.mailjet.com/docs/api/Help/category">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parName
	 *          {@link String} le nom d'une catégorie
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si le nom de la catégorie est null ou vide
	 */
	String category(EnumReturnType parType, String parName) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Retourne la liste de toutes les méthodes de la catégorie spécifiée de l'API
	 * REST <br />
	 * <a href="https://fr.mailjet.com/docs/api/Help/methods">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parCategory
	 *          {@link String} le nom d'une catégorie
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si le nom de la catégorie est null ou vide
	 */
	String methods(EnumReturnType parType, String parCategory) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Retourne la description d'une méthode dont le nom est spécifiée de l'API
	 * REST. <br />
	 * <a href="https://fr.mailjet.com/docs/api/Help/method">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parName
	 *          {@link String} le nom d'une méthode
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si le nom de la méthode est null ou vide
	 */
	String method(EnumReturnType parType, String parName) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Retourne la liste de tous les status HTTP pouvant être renvoyés avec leur
	 * description. <br />
	 * <a href="https://fr.mailjet.com/docs/api/Help/status">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String status(EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne la description du status HTTP spécifié <br />
	 * <a href="https://fr.mailjet.com/docs/api/Help/status">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parStatus
	 *          {@link Integer} un status HTTP
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String status(EnumReturnType parType, Integer parStatus) throws UniformInterfaceException;

}
