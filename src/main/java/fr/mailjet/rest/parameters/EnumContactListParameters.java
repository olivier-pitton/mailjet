package fr.mailjet.rest.parameters;
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

import fr.mailjet.rest.ContactRESTService;
import fr.mailjet.util.IWithValue;

/**
 * Une énumération de tous les paramètres possibles pour la fonction {@link ContactRESTService#list(fr.mailjet.rest.EnumReturnType, java.util.Map)}
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 */
public enum EnumContactListParameters implements IWithValue {

	/**
	 * Paramètre est bloqué.
	 */
  BLOCKED("blocked"),
	/**
	 * Paramètre dernière activité.
	 */
  LAST_ACTIVITY("last_activity"),
	/**
	 * Paramètre limite de résultat.
	 */
  LIMIT("limit"),
	/**
	 * Paramètre mj_contact_id.
	 */
  MJ_CONTACT_ID("mj_contact_id"),
	/**
	 * Paramètre start.
	 */
  START("start"),
	/**
	 * Paramètre status.
	 */
  STATUS("status"),
	/**
	 * Paramètre unsub.
	 */
  UNSUB("unsub");
  final private String _value;

  private EnumContactListParameters(final String parValue) {
    _value = parValue;
  }

  @Override
  public final String getValue() {
    return _value;
  }

  @Override
  public final String toString() {
    return getValue();
  }
}
