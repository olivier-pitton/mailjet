package fr.mailjet.rest.impl;/*
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


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.sun.jersey.api.client.Client;

import fr.mailjet.context.MailjetContext;
import fr.mailjet.rest.EnumReturnType;

/**
 * Classe abstraite permettant de factoriser le {@link MailjetContext} et le {@link Client} propre à tous les services.
 * Pour lancer les tests, il faut penser à mettre à jour les clés publique et secrète :
 * {@link AbstractServiceTestBase#getPublicKey()} et {@link AbstractServiceTestBase#getSecretKey()}
 *
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
@RunWith(Parameterized.class)
public abstract class AbstractServiceTestBase {

  static private final String API_KEY = "fdf491c20ea928ce0a659e8aea94f637";
  static private final String SECRET_KEY = "26f18931c35fba8a58eb83c0aae78b5a";
  /**   *  Un identifiant de campagne spécifique pour les tests   */
  static final Integer CAMPAIGN_ID = Integer.valueOf(350303358);
  /**   *  Un identifiant de contact spécifique pour les tests   */
  static final Integer CONTACT_ID = Integer.valueOf(241755226);
  /**   *  Un identifiant de liste spécifique pour les tests   */
  static final Integer LIST_ID = Integer.valueOf(68070);
  /**   *  Un mail spécifique pour les tests   */
  static final String MAIL = "olivier.pitton@gmail.com";

  /**
   * La liste des paramètres pour lancer les tests n fois. 
   * Les paramètres correspondent à toutes les valeurs de {@link EnumReturnType}
   * @return {@link List} la liste des paramètres pour chaque tests
   * @see EnumReturnType
   * @see Parameterized
   */
  @Parameters
  static public Collection<Object[]> parameters() {
    final EnumReturnType[] locReturnTypeValues = EnumReturnType.values();
    final List<Object[]> locParameters = new ArrayList<Object[]>(locReturnTypeValues.length);
    for (final EnumReturnType locReturnType : locReturnTypeValues) {
      locParameters.add(new Object[]{locReturnType});
    }
    return locParameters;
  }
  
  /**
   * Retourne la clé publique en dur pour les tests unitaires.
   * @return {@link String} la clé publique en dur pour les tests unitaires. 
   */
  static final public String getPublicKey() {
  	return API_KEY;
  }

  /**
   * Retourne la clé secrète en dur pour les tests unitaires.
   * @return {@link String} la clé secrète en dur pour les tests unitaires. 
   */
  static final public String getSecretKey() {
  	return SECRET_KEY;
  }
  
  /**
   * Le contexte courant pour les tests
   */
  protected final MailjetContext _context = new MailjetContext(getPublicKey(), getSecretKey());
  /**
   * Le type testé 
   */
  protected final EnumReturnType _type;
  /**
   * Un logger pour les tests non finalisés
   */
  protected final Logger _logger = Logger.getLogger("DEBUG");

  /**
   * Constructeur 
   * @param parType {@link EnumReturnType} le type courant testé
   */
  AbstractServiceTestBase(final EnumReturnType parType) {
    _type = parType;
  }

  /**
   * Vérifie que le status de la requête spécifiée est valide
   *
   * @param parResult {@link String} la requête
   */
  protected final void checkStatus(final String parResult) {
    assertNotNull(parResult);
    assertFalse(parResult.isEmpty());
    checkParameter(parResult, "status", "OK");
  }

  /**
   * Vérifie que le paramètre spécifié a bien la valeur spécifiée pour la réponse donnée. Exemple : Si l'on doit
   * vérifier que le status est "OK", la méthode va vérifier qu'il existe "status:"OK" en JSON, de même pour le XML. Si
   * le type {@link EnumReturnType} n'est pas testé, une assertion est levée volontairement.
   *
   * @param parResult {@link String} la réponse du serveur
   * @param parKey {@link String} la clé
   * @param parValue {@link Object} la valeur
   */
  protected final void checkParameter(final String parResult, final String parKey, final Object parValue) {
    assertNotNull(parKey);
    assertFalse(parKey.trim().isEmpty());
    assertNotNull(parValue);
    switch (_type) {
      case JSON:
        final String locRealValue = (parValue instanceof String) ? "\"" + parValue + "\"" : parValue.toString();
        final String locJSONProperty = "\"" + parKey + "\":" + locRealValue;
        assertTrue(parResult.contains(locJSONProperty));
        break;
      case XML:
        final String locXMLProperty = "<" + parKey + ">" + parValue + "</" + parKey + ">";
        assertTrue(parResult.contains(locXMLProperty));
        break;
      default:
        assertFalse(true);
    }
  }

  /**
   * Vérifie que le paramètre spécifié a un nombre entier comme valeur et que ce-dernier est supérieur ou égal à la valeur
   * spécifiée. 
   *
   * @param parResult {@link String} la réponse du serveur
   * @param parKey {@link String} la clé
   * @param parMinimum {@link Integer} la valeur minimum que doit avoir le valeur du paramètre
   * @see #doMinimumInteger(String, String, Integer, String, String, int)
   */
  protected final void checkMinimumIntegerParameter(final String parResult, final String parKey, final Integer parMinimum) {
    assertNotNull(parKey);
    assertFalse(parKey.trim().isEmpty());
    assertNotNull(parMinimum);

    switch (_type) {
      case JSON:
        doMinimumInteger("\"" + parKey + "\":\"[0-9]*\"", parResult, parMinimum, ":\"", "\"", 2);
        break;
      case XML:
        doMinimumInteger("<" + parKey + ">[0-9]*</" + parKey + ">", parResult, parMinimum, ">", "<", 1);
        break;
      default:
        assertFalse(true);
    }
  }

  private final void doMinimumInteger(final String parRegExp, final String parResult, final Integer parMinimum, final String parFirstIndexOf, final String parLastIndexOf, final int parAddToStart) {
    final Pattern locPattern = Pattern.compile(parRegExp);
    final Matcher locMatcher = locPattern.matcher(parResult);
    while (locMatcher.find()) {
      final String locValue = locMatcher.group();
      int locStart = locValue.indexOf(parFirstIndexOf) + parAddToStart;
      final int locEnd = locValue.lastIndexOf(parLastIndexOf);
      final int locRealIntegerValue = Integer.parseInt(locValue.substring(locStart, locEnd));
      assertTrue(parMinimum.intValue() <= locRealIntegerValue);
      return;
    }
    // Si la valeur n'a pas été trouvé on lève une erreur
    assertFalse(true);
  }
}
