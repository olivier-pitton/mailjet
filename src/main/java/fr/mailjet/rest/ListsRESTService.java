package fr.mailjet.rest;
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

import java.util.Map;

import com.sun.jersey.api.client.UniformInterfaceException;

import fr.mailjet.rest.parameters.EnumListsContactParameters;

/**
 * L'interface de tous les services de type <i>List</i>.  Cette interface comprend toutes les méthodes définies dans
 * l'api officielle. <a href="http://fr.mailjet.com/docs/api/lists">doc</a>
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public interface ListsRESTService extends MailjetRESTService {
	
	/**
	 * Paramètre identifiant global à cette API
	 * @see ListsRESTService#contacts(EnumReturnType, Integer)
	 * @see ListsRESTService#email(EnumReturnType, Integer)
	 * @see ListsRESTService#statistics(EnumReturnType, Integer)
	 */
	static public final String _ListId = "id";
	/**
	 * Paramètre order_by de la méthode all
	 * <a href="https://fr.mailjet.com/docs/api/lists/all">doc</a>
	 * @see ListsRESTService#all(EnumReturnType, Integer, String)
	 */
	static public final String _AllOrderBy = "order_by";
	/**
	 * Paramètre limit de la méthode all
	 * <a href="https://fr.mailjet.com/docs/api/lists/all">doc</a>
	 * @see ListsRESTService#all(EnumReturnType, Integer)
	 */
	static public final String _AllLimit = "limit";
	
	/**
	 * Paramètre start de la méthode all
	 * <a href="https://fr.mailjet.com/docs/api/lists/all">doc</a>
	 * @see ListsRESTService#all(EnumReturnType, Integer, String, Integer)
	 */
	static public final String _AllStart = "start";

	/**
	 * Retourne la liste de tous les contacts
	 * <a href="https://fr.mailjet.com/docs/api/lists/all">doc</a>
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
	 */
	String all(final EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne la liste de tous les contacts limitée au nombre spécifié
	 * <a href="https://fr.mailjet.com/docs/api/lists/all">doc</a>
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parLimit {@link Integer} la limite du nombre d'utilisateurs retournée
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
	 */
	String all(final EnumReturnType parType, final Integer parLimit) throws UniformInterfaceException;

	/**
	 * Retourne la liste de tous les contacts limitée au nombre spécifié, trié de la façon spécifiée.
	 * <a href="https://fr.mailjet.com/docs/api/lists/all">doc</a>
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parLimit {@link Integer} la limite du nombre d'utilisateurs retournée
   * @param parOrderBy {@link String} le type de tri
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
	 */
	String all(final EnumReturnType parType, final Integer parLimit, final String parOrderBy) throws UniformInterfaceException;

	/**
	 * Retourne la liste de tous les contacts limitée au nombre spécifié, trié de la façon spécifiée
	 * commençant par le nombre spécifié (offset).
	 * <a href="https://fr.mailjet.com/docs/api/lists/all">doc</a>
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parLimit {@link Integer} la limite du nombre d'utilisateurs retournée
   * @param parOrderBy {@link String} le type de tri
   * @param parStart {@link Integer} le offset
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
	 */
	String all(final EnumReturnType parType, final Integer parLimit, final String parOrderBy, final Integer parStart) throws UniformInterfaceException;
	
	/**
	 * Retourne la liste de tous les contacts de la liste spécifiée.
	 * <a href="https://fr.mailjet.com/docs/api/lists/contacts">doc</a>
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parListId {@link Integer} l'identifiant de la liste
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   * @throws IllegalArgumentException Si l'identifiant est null
	 */
	String contacts(final EnumReturnType parType, final Integer parListId) throws UniformInterfaceException, IllegalArgumentException;
	

	/**
	 * Retourne la liste de tous les contacts de la liste spécifiée filtrée par le biais de la {@link Map}
	 * de paramètres.
	 * <a href="https://fr.mailjet.com/docs/api/lists/contacts">doc</a>
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parListId {@link Integer} l'identifiant de la liste
   * @param parParameters {@link Map} une map de paramètres
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   * @throws IllegalArgumentException Si l'identifiant est null
	 */
	String contacts(final EnumReturnType parType, final Integer parListId, final Map<EnumListsContactParameters, String> parParameters) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Retourne l'unique email utilisé par Mailjet pour récupérer tous les contacts d'une liste. 
	 * <a href="https://fr.mailjet.com/docs/api/lists/email">doc</a>
	 * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parContactId {@link Integer} l'identifiant du contact
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   * @throws IllegalArgumentException Si l'identifiant est null
	 */
	String email(final EnumReturnType parType, final Integer parContactId) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Retourne les statistiques avancés d'un contact d'une liste. 
	 * <a href="https://fr.mailjet.com/docs/api/lists/statistics">doc</a>
	 * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parListId {@link Integer} l'identifiant d'une liste
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   * @throws IllegalArgumentException Si l'identifiant est null
	 */
	String statistics(final EnumReturnType parType, final Integer parListId) throws UniformInterfaceException, IllegalArgumentException;
}
