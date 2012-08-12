package fr.mailjet.rest;

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

import java.util.List;
import java.util.Map;

import com.sun.jersey.api.client.UniformInterfaceException;

import fr.mailjet.rest.impl.RESTServiceFactory;
import fr.mailjet.rest.parameters.EnumReturnType;

/**
 * L'interface de tous les services de type <i>Lists</i>. Cette interface
 * comprend toutes les méthodes définies dans l'api officielle.<br />
 * <a href="http://fr.mailjet.com/docs/api/lists">Documentation Mailjet</a>
 * 
 * @see RESTServiceFactory#createListsService()
 * @author Pitton Olivier
 * 
 */
public interface ListsRESTService extends MailjetRESTService {
	/**
	 * Retourne la liste de tous les contacts <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/all">Documentation
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
	String all(EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne la liste de tous les contacts limitée au nombre spécifié <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/all">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parLimit
	 *          {@link Integer} la limite du nombre d'utilisateurs retournée
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String all(EnumReturnType parType, Integer parLimit) throws UniformInterfaceException;

	/**
	 * Retourne la liste de tous les contacts limitée au nombre spécifié, trié de
	 * la façon spécifiée. <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/all">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parLimit
	 *          {@link Integer} la limite du nombre d'utilisateurs retournée
	 * @param parOrderBy
	 *          {@link String} le type de tri
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String all(EnumReturnType parType, Integer parLimit, String parOrderBy) throws UniformInterfaceException;

	/**
	 * Retourne la liste de tous les contacts limitée au nombre spécifié, trié de
	 * la façon spécifiée commençant par le nombre spécifié (offset). <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/all">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parLimit
	 *          {@link Integer} la limite du nombre d'utilisateurs retournée
	 * @param parOrderBy
	 *          {@link String} le type de tri
	 * @param parStart
	 *          {@link Integer} le offset
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String all(EnumReturnType parType, Integer parLimit, String parOrderBy, Integer parStart) throws UniformInterfaceException;

	/**
	 * Retourne la liste de tous les contacts de la liste spécifiée. <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/contacts">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant de la liste
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant est null
	 */
	String contacts(EnumReturnType parType, Integer parListId) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Retourne la liste de tous les contacts de la liste spécifiée filtrée par le
	 * biais de la {@link Map} de paramètres. <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/contacts">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant de la liste
	 * @param parParameters
	 *          {@link Map} une map de paramètres
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant est null
	 */
	String contacts(EnumReturnType parType, Integer parListId, Map<String, String> parParameters) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Retourne l'unique email utilisé par Mailjet pour récupérer tous les
	 * contacts d'une liste. <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/email">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parContactId
	 *          {@link Integer} l'identifiant du contact
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant est null
	 */
	String email(EnumReturnType parType, Integer parContactId) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Retourne les statistiques avancés d'un contact d'une liste. <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/statistics">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant d'une liste
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant est null
	 */
	String statistics(EnumReturnType parType, Integer parListId) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Ajoute le contact dont l'email est spécifié dans la liste dont
	 * l'identifiant est spécifié. <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/addcontact">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant d'une liste
	 * @param parEmail
	 *          {@link String} le mail du contact à ajouter
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant ou le mail est null ou vide
	 */
	String addContact(EnumReturnType parType, Integer parListId, String parEmail) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Ajoute le contact dont l'email est spécifié dans la liste dont
	 * l'identifiant est spécifié. <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/addcontact">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant d'une liste
	 * @param parEmail
	 *          {@link String} le mail du contact à ajouter
	 * @param parForce
	 *          {@link Boolean} If the contact exists, reset unsub status.
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant ou le mail est null ou vide
	 */
	String addContact(EnumReturnType parType, Integer parListId, String parEmail, Boolean parForce) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Ajoute la liste des contacts dont les emails sont spécifiés dans la liste
	 * dont l'identifiant est spécifié. <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/addmanycontacts">
	 * Documentation Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant d'une liste
	 * @param parContacts
	 *          {@link List} la liste des emails à ajouter dans la liste
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant ou que la liste est null ou vide
	 */
	String addManyContacts(EnumReturnType parType, Integer parListId, List<String> parContacts) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Ajoute la liste des contacts dont les emails sont spécifiés dans la liste
	 * dont l'identifiant est spécifié. <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/addmanycontacts">
	 * Documentation Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant d'une liste
	 * @param parContacts
	 *          {@link List} la liste des emails à ajouter dans la liste
	 * @param parForce
	 *          {@link Boolean} If the contact exists, reset unsub status.
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant ou que la liste est null ou vide
	 */
	String addManyContacts(EnumReturnType parType, Integer parListId, List<String> parContacts, Boolean parForce) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Crée une liste de contacts <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/create">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parLabel
	 *          {@link String} le titre de la liste
	 * @param parName
	 *          {@link String} le nom de la liste
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si le label ou le nom sont null ou vides
	 */
	String create(EnumReturnType parType, String parLabel, String parName) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Supprime une liste de contacts dont l'identifiant est spécifié <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/delete">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant de la liste à supprimer
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant est null
	 */
	String delete(EnumReturnType parType, Integer parListId) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Supprime le contact de la liste dont l'identifiant est spécifié avec le
	 * mail spécifié <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/removecontact">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant de la liste à supprimer
	 * @param parContact
	 *          {@link String} le mail du contact à supprimer
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant est null ou que le mail est null ou vide
	 */
	String removeContact(EnumReturnType parType, Integer parListId, String parContact) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Supprime la liste de contacts de la liste dont l'identifiant est spécifié <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/removemanycontacts">
	 * Documentation Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant de la liste à supprimer
	 * @param parContacts
	 *          {@link List} la liste des mails des contacts à supprimer
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant est null ou que la liste est null ou vide
	 */
	String removeManyContacts(EnumReturnType parType, Integer parListId, List<String> parContacts) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/unsubcontact">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant de la liste
	 * @param parContact
	 *          {@link String} le mail du contact
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant est null ou que le mail est null ou vide
	 */
	String unsubContact(EnumReturnType parType, Integer parListId, String parContact) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Met à jour les informations de la liste dont l'identifiant est spécifié. <br />
	 * <a href="https://fr.mailjet.com/docs/api/lists/update">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant de la liste
	 * @param parLabel
	 *          {@link String} le titre de la liste
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant est null
	 */
	String update(EnumReturnType parType, Integer parListId, String parLabel) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Met à jour les informations de la liste dont l'identifiant est spécifié.
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parListId
	 *          {@link Integer} l'identifiant de la liste
	 * @param parLabel
	 *          {@link String} le titre de la liste
	 * @param parName
	 *          {@link String} le nom de la liste
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant est null
	 */
	String update(EnumReturnType parType, Integer parListId, String parLabel, String parName) throws UniformInterfaceException, IllegalArgumentException;
}
