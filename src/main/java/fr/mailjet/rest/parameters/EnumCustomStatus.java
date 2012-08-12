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

import fr.mailjet.rest.ApiRESTService;
import fr.mailjet.util.IWithValue;

/**
 * Enumération de tous les types de status proposés par l'API mailjet
 * dans le cadre de la méthode {@link ApiRESTService#keyList(fr.mailjet.rest.EnumReturnType, Boolean, EnumCustomStatus)}
 * @see ApiRESTService#keyList(fr.mailjet.rest.EnumReturnType, Boolean, EnumCustomStatus)
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public enum EnumCustomStatus implements IWithValue {
	/**
	 * Status activé
	 */
	UP("up"),
	/**
	 * Status suspendu
	 */
	SUSPEND("suspend"),
	/**
	 * Status désactivé
	 */
	DOWN("down");

	final private String _name;

	private EnumCustomStatus(final String parName) {
		_name = parName;
	}
	
	@Override
	public final String getValue() {
		return _name;
	}

	@Override
	final public String toString() {
		return _name;
	}
}
