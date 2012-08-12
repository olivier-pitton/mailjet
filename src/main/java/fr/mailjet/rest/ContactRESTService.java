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

import com.sun.jersey.api.client.UniformInterfaceException;

import fr.mailjet.rest.parameters.EnumContactListParameters;

/**
 * L'interface de tous les services de type <i>Contact</i>. Cette interface comprend toutes les méthodes définies dans
 * l'api officielle. <a href="http://fr.mailjet.com/docs/api/contact">doc</a>
 *
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public interface ContactRESTService extends MailjetRESTService {

  /**
   * Clé du paramètre "contact" de la requête infos. <a href="http://fr.mailjet.com/docs/api/contact/infos">doc</a>
   */
  static public final String _infoMail = "contact";
  /**
   * Clé du paramètre "last_activity" de la requête openers. <a
   * href="http://fr.mailjet.com/docs/api/contact/openers">doc</a>
   */
  static public final String _lastActivityOpener = "last_activity";
  /**
   * Clé du paramètre "limit" de la requête openers. <a href="http://fr.mailjet.com/docs/api/contact/openers">doc</a>
   */
  static public final String _limitOpener = "limit";
  /**
   * Clé du paramètre "start" de la requête openers. <a href="http://fr.mailjet.com/docs/api/contact/openers">doc</a>
   */
  static public final String _startOpener = "start";

  /**
   * Retourne les informations générales du contact dont le mail est spécifié. <a
   * href="http://fr.mailjet.com/docs/api/contact/infos">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parEmail {@link String} l'email du contact recherché
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   * @throws IllegalArgumentException Si l'adresse email est null
   */
  String infos(final EnumReturnType parType, final String parEmail) throws UniformInterfaceException, IllegalArgumentException;

  /**
   * Retourne la liste de tous les contacts de l'utilisateur <a
   * href="http://fr.mailjet.com/docs/api/contact/list">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String list(final EnumReturnType parType) throws UniformInterfaceException;

  /**
   * Retourne la liste de tous les contacts de l'utilisateur dont les filtres spécifiés sont appliqués par le biais de
   * la map en paramètres. <a href="http://fr.mailjet.com/docs/api/contact/list">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parParameters {@link Map} la liste des paramètres de filtre de la requête
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String list(final EnumReturnType parType, final Map<EnumContactListParameters, String> parParameters) throws UniformInterfaceException;

  /**
   * Retourne la liste de tous les contacts ouvrant des messages. <a
   * href="http://fr.mailjet.com/docs/api/contact/openers">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String openers(final EnumReturnType parType) throws UniformInterfaceException;

  /**
   * Retourne la liste de tous les contacts ouvrant des messages dont la dernière activité minimum est spécifiée. <a
   * href="http://fr.mailjet.com/docs/api/contact/openers">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parLastActivity {@link Long} la dernière activité minimum de l'utilisateur.
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String openers(final EnumReturnType parType, final Long parLastActivity) throws UniformInterfaceException;

  /**
   * Retourne la liste de tous les contacts ouvrant des messages dont la dernière activité minimum est spécifiée. Cette
   * requête limite le nombre de contacts en fonction du paramètre {@code parLimit} <a
   * href="http://fr.mailjet.com/docs/api/contact/openers">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parLastActivity {@link Long} la dernière activité minimum de l'utilisateur.
   * @param parLimit {@link Integer} le nombre maximum de lignes retournées
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String openers(final EnumReturnType parType, final Long parLastActivity, final Integer parLimit) throws UniformInterfaceException;

  /**
   * Retourne la liste de tous les contacts ouvrant des messages dont la dernière activité minimum est spécifiée. Cette
   * requête limite le nombre de contacts en fonction du paramètre {@code parLimit} et dont le numéro dans la liste
   * retournée est supérieure au paramètre {@code parStart}. Exemple : Si l'on spécifié une limite de 5 et un start de
   * 1, les contacts compris entre 1 et 5 (inclus) seront renvoyés. <a
   * href="http://fr.mailjet.com/docs/api/contact/openers">doc</a>
   *
   * @param parType {@link EnumReturnType} le format de retour de la requête
   * @param parLastActivity {@link Long} la dernière activité minimum de l'utilisateur.
   * @param parLimit {@link Integer} le nombre maximum de lignes retournées
   * @param parStart {@link Integer} l'offset de départ
   * @return {@link String} la réponse du serveur
   * @throws NullPointerException si le type de retour est null
   * @throws UniformInterfaceException Si le code de retour est supérieur ou égal à 300
   */
  String openers(final EnumReturnType parType, final Long parLastActivity, final Integer parLimit, final Integer parStart) throws UniformInterfaceException;
}
