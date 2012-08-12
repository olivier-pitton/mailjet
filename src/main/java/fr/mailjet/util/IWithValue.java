package fr.mailjet.util;
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

/**
 * L'interface de tous les types capables de renvoyer une valeur constante sous forme de chaines de caractères.
 * @author "Pitton Olivier <olivier dot pitton at gmail dot com>"
 *
 */
public interface IWithValue {

	/**
	 * Retourne la valeur associée à l'interface. Cette valeur est
	 * constante.
	 * @return {@link String} la valeur.
	 */
	String getValue();
	
}
