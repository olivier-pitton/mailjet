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

import fr.mailjet.rest.ListsRESTService;
import fr.mailjet.util.IWithValue;

/**
 * L'énumération de tous les paramètres de la méthode {@link ListsRESTService#contacts(fr.mailjet.rest.EnumReturnType, Integer, java.util.Map)}
 * @see ListsRESTService#contacts(fr.mailjet.rest.EnumReturnType, Integer, java.util.Map)
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public enum EnumListsContactParameters implements IWithValue {
	/**
	 * Bloqué
	 */
	BLOCKED("blocked"),
	/**
	 * Dernière activité
	 */
	LAST_ACTIVITY("last_activity"),
	/**
	 * Limite
	 */
	LIMIT("limit"),
	/**
	 * Trié par
	 */
	ORDER_BY("order_by"),
	/**
	 * Début
	 */
	START("start"),
	/**
	 * Status
	 */
	STATUS("status"),
	/**
	 * Unsub
	 */
	UNSUB("unsub");
	
	final private String _value;
	
	private EnumListsContactParameters(final String parValue) {
		_value = parValue;
	}

	@Override
	final public String getValue() {
		return _value;
	}
	
	@Override
	public final String toString() {
		return getValue();
	}
}