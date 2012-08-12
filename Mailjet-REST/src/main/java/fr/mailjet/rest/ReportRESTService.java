package fr.mailjet.rest;

/*
 * 
 * Mailjet-REST
 * 
 * Copyright (C) 2012 Pitton Olivier - olivier dot pitton at gmail dot com
 * 
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
 * 
 */

import java.util.Map;

import com.sun.jersey.api.client.UniformInterfaceException;

import fr.mailjet.rest.impl.RESTServiceFactory;
import fr.mailjet.rest.parameters.EnumReturnType;

/**
 * L'interface de tous les services de type <i>Report</i>. Cette interface
 * comprend toutes les méthodes définies dans l'api officielle.<br />
 * <a href="http://fr.mailjet.com/docs/api/report">Documentation Mailjet</a>
 * 
 * @see RESTServiceFactory#createReportService()
 * @author Pitton Olivier
 * 
 */
public interface ReportRESTService extends MailjetRESTService {
	/**
	 * Retourne le nombre de liens clickés. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/click">Documentation
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
	String click(final EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne le nombre de liens clickés. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/click">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parParameters
	 *          {@link Map} les paramètres de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String click(final EnumReturnType parType, final Map<String, String> parParameters) throws UniformInterfaceException;

	/**
	 * Retourne le la liste des domaines où sont envoyés les mails. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/domain">Documentation
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
	String domain(final EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne le la liste des domaines où sont envoyés les mails. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/domain">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parParameters
	 *          {@link Map} les paramètres de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String domain(final EnumReturnType parType, final Map<String, String> parParameters) throws UniformInterfaceException;

	/**
	 * Retourne la liste des mails déclarés "bounce". <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/emailbounce">Documentation
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
	String emailBounce(final EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne la liste des mails déclarés "bounce". <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/emailbounce">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parParameters
	 *          {@link Map} les paramètres de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String emailBounce(final EnumReturnType parType, final Map<String, String> parParameters) throws UniformInterfaceException;

	/**
	 * Lists of email clients used to open your emails when tracked.. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/emailclients">Documentation
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
	String emailClients(final EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Lists of email clients used to open your emails when tracked.. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/emailclients">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parParameters
	 *          {@link Map} les paramètres de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String emailClients(final EnumReturnType parType, final Map<String, String> parParameters) throws UniformInterfaceException;

	/**
	 * Retourne toutes les informations des messages dont l'identifiant de la
	 * campagne est spécifié. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/emailinfos">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parCampaignId
	 *          {@link Integer} l'identifiant de la campagne
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 * @throws IllegalArgumentException
	 *           Si l'identifiant de la campagne est null
	 */
	String emailInfos(final EnumReturnType parType, final Integer parCampaignId) throws UniformInterfaceException, IllegalArgumentException;

	/**
	 * Retourne les emails envoyés. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/emailsent">Documentation
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
	String emailSent(final EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne les emails envoyés. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/emailsent">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parParameters
	 *          {@link Map} les paramètres de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String emailSent(final EnumReturnType parType, final Map<String, String> parParameters) throws UniformInterfaceException;

	/**
	 * Retourne des statistiques détaillés de tous les envois. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/emailstatistics">
	 * Documentation Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String emailStatistics(final EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne des statistiques détaillés de tous les envois. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/emailstatistics">
	 * Documentation Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parParameters
	 *          {@link Map} les paramètres de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String emailStatistics(final EnumReturnType parType, final Map<String, String> parParameters) throws UniformInterfaceException;

	/**
	 * Retourne les zones géographiques où sont ouverts les emails envoyés.<br />
	 * <a href="https://fr.mailjet.com/docs/api/report/geoip">Documentation
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
	String geoIp(final EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne les zones géographiques où sont ouverts les emails envoyés.<br />
	 * <a href="https://fr.mailjet.com/docs/api/report/geoip">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parParameters
	 *          {@link Map} les paramètres de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String geoIp(final EnumReturnType parType, final Map<String, String> parParameters) throws UniformInterfaceException;

	/**
	 * Retourne la liste des emails ouverts. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/open">Documentation
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
	String open(final EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne la liste des emails ouverts. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/open">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parParameters
	 *          {@link Map} les paramètres de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String open(final EnumReturnType parType, final Map<String, String> parParameters) throws UniformInterfaceException;

	/**
	 * Retourne les statistiques sur les mails ouverts. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/openedstatistics">
	 * Documentation Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String openedStatistics(final EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne les statistiques sur les mails ouverts. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/openedstatistics">
	 * Documentation Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parParameters
	 *          {@link Map} les paramètres de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String openedStatistics(final EnumReturnType parType, final Map<String, String> parParameters) throws UniformInterfaceException;

	/**
	 * Retourne la plateforme, les navigateurs et les versions des clients. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/useragents">Documentation
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
	String userAgents(final EnumReturnType parType) throws UniformInterfaceException;

	/**
	 * Retourne la plateforme, les navigateurs et les versions des clients. <br />
	 * <a href="https://fr.mailjet.com/docs/api/report/useragents">Documentation
	 * Mailjet</a>
	 * 
	 * @param parType
	 *          {@link EnumReturnType} le format de retour de la requête
	 * @param parParameters
	 *          {@link Map} les paramètres de la requête
	 * @return {@link String} la réponse du serveur
	 * @throws NullPointerException
	 *           si le type de retour est null
	 * @throws UniformInterfaceException
	 *           Si le code de retour est supérieur ou égal à 300
	 */
	String userAgents(final EnumReturnType parType, final Map<String, String> parParameters) throws UniformInterfaceException;

}
