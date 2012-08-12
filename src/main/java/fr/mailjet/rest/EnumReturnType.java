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


import fr.mailjet.util.IWithValue;

/**
 * L'énumération de tous les types de retour disponibles par le biais de l'api officielle.
 * Cette énumération est utilisée dans les propriétés envoyées avec la clé "output" et la valeur
 * {@link EnumReturnType#getValue()}
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public enum EnumReturnType implements IWithValue {

	/**
	 * type de retour en XML
	 */
	XML("xml"),
	/**
	 * Type de retour en JSON
	 */
	JSON("json");
	
	final private String _output;
	
	private EnumReturnType(final String parOutput) {
		_output = parOutput;
	}
	
	@Override
	final public String getValue() {
		return _output;
	}
	
	@Override
	final public String toString() {
		return getValue();
	}
	
}
