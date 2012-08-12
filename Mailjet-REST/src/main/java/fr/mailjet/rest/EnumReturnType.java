package fr.mailjet.rest;/*
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


import fr.mailjet.util.IWithConstName;

/**
 * L'énumération de tous les types de retour disponibles par le biais de l'api officielle.
 * Cette énumération est utilisée dans les propriétés envoyées avec la clé "output" et la valeur
 * {@link EnumReturnType#getConstName()}
 * @author Pitton Olivier
 *
 */
public enum EnumReturnType implements IWithConstName {

	/**
	 * type de retour en XML
	 */
	XML("xml"),
	/**
	 * Type de retour en JSON
	 */
	JSON("json"),	/**	 * Type de retour en HTML	 */	HTML("html");
	
	private String _output;
	
	private EnumReturnType(String parOutput) {
		_output = parOutput;
	}
	
	@Override
	public String getConstName() {
		return _output;
	}
	
	@Override
	public String toString() {
		return getConstName();
	}
	
}
