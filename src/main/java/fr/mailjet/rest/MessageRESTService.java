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

import java.util.Map;
import java.util.Locale;

import com.sun.jersey.api.client.UniformInterfaceException;

import fr.mailjet.rest.parameters.EnumMessageCampaignsParameters;
import fr.mailjet.rest.parameters.EnumMessageListParameters;

/**
 * L'interface de tous les services de type <i>Message</i>. Cette interface comprend toutes les méthodes définies dans
 * l'api officielle. <a href="http://fr.mailjet.com/docs/api/message">doc</a>
 *
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public interface MessageRESTService extends MailjetRESTService {

  /**
   * Clé du paramètre "limit" de la requête campaigns. <a
   * href="https://fr.mailjet.com/docs/api/message/campaigns">doc</a>
   */
  static final public String _limitCampaign = "limit";
  /**
   * Clé du paramètre "id" de différentes requêtes (statistiques, ...)
   */
  static final public String _idCampaign = "id";

  /**
   * Clé du paramètre "category" de la requête tplModel. <a
   * href="https://fr.mailjet.com/docs/api/message/tplmodels">doc</a>
   */
  static final public String _categoryTplModel = "category";
  
  /**
   * Clé du paramètre "custom" de la requête tplModel. <a
   * href="https://fr.mailjet.com/docs/api/message/tplmodels">doc</a>
   */
  static final public String _customTplModel = "custom";
    /**
   * Clé du paramètre "locale" de la requête tplModel. <a
   * href="https://fr.mailjet.com/docs/api/message/tplmodels">doc</a>
   */
  static final public String _localeTplModel = "locale";
  

  /**
   * Retourne la liste de toutes les campagnes. <a href="https://fr.mailjet.com/docs/api/message/campaigns">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String campaigns(final EnumReturnType parType) throws UniformInterfaceException;

  /**
   * Retourne la liste de toutes les campagnes dans la limite spécifiée. <a
   * href="https://fr.mailjet.com/docs/api/message/campaigns">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parLimit {@link Integer} le nombre maximum de campagnes à retourner.
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String campaigns(final EnumReturnType parType, final Integer parLimit) throws UniformInterfaceException;

  
  /**
   * Retourne la liste de toutes les campagnes dans la limite spécifiée. 
   * Appeler cette méthode en spécifiant une map null revient à appeler {@link #campaigns(fr.mailjet.rest.EnumReturnType)}.
   * <a href="https://fr.mailjet.com/docs/api/message/campaigns">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parMap {@link Map} une map contenant tous les paramètres.
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String campaigns(final EnumReturnType parType, final Map<EnumMessageCampaignsParameters, String> parMap) throws UniformInterfaceException;

  /**
   * Retourna la liste de tous les contacts pour une campagne spécifiée. 
   * <a href="https://fr.mailjet.com/docs/api/message/contacts">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parCampaignId {@link Integer} l'identifiant de la campagne dont on cherche les contacts.
   * @return {@link String} la réponse du serveur
   * @throws IllegalArgumentException si l'identifiant de la campagne est null
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String contacts(final EnumReturnType parType, final Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException;

 /**
   * Retourna la liste de tous les contacts pour une campagne spécifiée avec les paramètres spécifiées.
   * Appeler cette méthode en spécifiant une map null revient à appeler {@link #contacts(fr.mailjet.rest.EnumReturnType, java.lang.Integer) }.
   * <a href="https://fr.mailjet.com/docs/api/message/contacts">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parCampaignId {@link Integer} l'identifiant de la campagne dont on cherche les contacts.
   * @param parParameters {@link Map} une map contenant tous les paramètres de la requêtes
   * @return {@link String} la réponse du serveur
   * @throws IllegalArgumentException si l'identifiant de la campagne est null
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String contacts(final EnumReturnType parType, final Integer parCampaignId, final Map<EnumMessageCampaignsParameters, String> parParameters) throws UniformInterfaceException, IllegalArgumentException;

  /**
   * Retourne le code RAW Html de la campagne spécifiée <a
   * href="https://fr.mailjet.com/docs/api/message/htmlcampaign">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parCampaignId {@link Integer} l'identifiant de la campagne.
   * @return {@link String} la réponse du serveur
   * @throws IllegalArgumentException si l'identifiant de la campagne est null
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String htmlCampaign(final EnumReturnType parType, final Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException;

  /**
   * Retourne la liste de tous les messages (transactionnels et de campagne). <a
   * href="https://fr.mailjet.com/docs/api/message/list">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String list(final EnumReturnType parType) throws UniformInterfaceException;

  /**
   * Retourne la liste de tous les messages (transactionnels et de campagne) avec les filtres spécifiées dans la map.
   * L'ensemble des paramètres et leur description est disponible <a
   * href="https://fr.mailjet.com/docs/api/message/list">ici</a>. Ceux-ci sont tous optionnels, ainsi spécifier une map
   * null ou vide revient à appeler la méthode {@link #list(fr.mailjet.rest.EnumReturnType) }.
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parParameters {@link Map} une map de tous les paramètres de filtres à appliquer à la requête
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String list(final EnumReturnType parType, final Map<EnumMessageListParameters, String> parParameters) throws UniformInterfaceException;

  /**
   * Retourne les statistiques depuis l'identifiant d'une campagne. <a
   * href="https://fr.mailjet.com/docs/api/message/statistics">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parCampaignId {@link Integer} l'identifiant de la campagne dont on cherche les statistiques.
   * @return {@link String} la réponse du serveur
   * @throws IllegalArgumentException si l'identifiant de la campagne est null
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String statistics(final EnumReturnType parType, final Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException;

  /**
   * Retourne la liste des différentes catégories de templates. <a
   * href="https://fr.mailjet.com/docs/api/message/tplcategories">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String tplCategories(final EnumReturnType parType) throws UniformInterfaceException;

  /**
   * Retourne la liste des différents templates. <a href="https://fr.mailjet.com/docs/api/message/tplmodels">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String tplModels(final EnumReturnType parType) throws UniformInterfaceException;

  /**
   * Retourne la liste des différents templates de la catégorie spécifiée. <a
   * href="https://fr.mailjet.com/docs/api/message/tplmodels">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parCategory {@link Integer} l'identifiant de la catégorie
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String tplModels(final EnumReturnType parType, final Integer parCategory) throws UniformInterfaceException;

  /**
   * Retourne la liste des différents templates de la catégorie spécifiée. Le paramètre {@code parCustom} spécifie s'il
   * faut retourner les templates utilisateurs, ou non. <a
   * href="https://fr.mailjet.com/docs/api/message/tplmodels">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parCategory {@link Integer} l'identifiant de la catégorie
   * @param parCustom {@link Boolean} vrai pour retourner les templates utilisateurs
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String tplModels(final EnumReturnType parType, final Integer parCategory, final Boolean parCustom) throws UniformInterfaceException;

    /**
   * Retourne la liste des différents templates de la catégorie spécifiée. Le paramètre {@code parCustom} spécifie s'il
   * faut retourner les templates utilisateurs, ou non. Le paramètre {@code parLocale} spécifie la locale.<a
   * href="https://fr.mailjet.com/docs/api/message/tplmodels">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parCategory {@link Integer} l'identifiant de la catégorie
   * @param parCustom {@link Boolean} vrai pour retourner les templates utilisateurs
   * @param parLocale {@link Locale} la locale
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String tplModels(final EnumReturnType parType, final Integer parCategory, final Boolean parCustom, final Locale parLocale) throws UniformInterfaceException;
}
