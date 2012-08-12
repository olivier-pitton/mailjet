package fr.mailjet.rest.parameters;
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

import fr.mailjet.rest.ApiRESTService;
import fr.mailjet.util.IWithConstName;

/**
 * Enumération de tous les types de status proposés par l'API mailjet
 * dans le cadre de la méthode {@link ApiRESTService#keyList(EnumReturnType, Boolean, EnumCustomStatus)}
 * @see ApiRESTService#keyList(EnumReturnType, Boolean, EnumCustomStatus)
 * @see ApiRESTService#keyUpdate(EnumReturnType, String, EnumCustomStatus)
 * @see ApiRESTService#keyAdd(EnumReturnType, String, EnumCustomStatus)
 * @author Pitton Olivier
 *
 */
public enum EnumCustomStatus implements IWithConstName {
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

	private String _name;

	private EnumCustomStatus(String parName) {
		_name = parName;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getConstName() {
		return _name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return _name;
	}
}
