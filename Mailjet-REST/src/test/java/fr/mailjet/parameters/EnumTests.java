package fr.mailjet.parameters;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.mailjet.mail.EnumMailjetMailHeader;
import fr.mailjet.rest.parameters.EnumCustomStatus;
import fr.mailjet.rest.parameters.EnumReturnType;
import fr.mailjet.util.IWithConstName;

/**
 * Tests unitaires des énumérations de paramètres
 * @author Pitton Olivier
 *
 */
@RunWith(Parameterized.class)
public class EnumTests {

	/**
	 * Retourne la {@link List} de tous les paramètres à tester.
	 * @see Parameterized
	 * @return {@link List} la liste de tous les paramètres à tester
	 */
	@Parameters
	static final public Collection<Object[]> parameters() {
		List<Object[]> locParameters = new ArrayList<Object[]>();
		locParameters.add(new Object[]{EnumMailjetMailHeader.values()});
		locParameters.add(new Object[]{EnumReturnType.values()});
		locParameters.add(new Object[]{EnumCustomStatus.values()});
		return locParameters;
	}

	private IWithConstName[] _enum;
	
	/**
	 * Constructeur utilisé avec {@link Parameters}
	 * @param parEnumArray {@link IWithConstName} le tableau d'enum
	 */
	public EnumTests(IWithConstName[] parEnumArray) {
		_enum = parEnumArray;
		assertNotNull(_enum);
		assertTrue(parEnumArray.length > 0);
		assertTrue(parEnumArray[0] instanceof Enum);
	}
	
	/**
	 * Vérifie que toutes les clés sont uniques pour une énumération
	 */
	@Test(timeout = 3000L)
	public void testUniqueGetValue() {
		Set<String> locUniqueSet = new HashSet<String>(_enum.length);
		for(IWithConstName locEnumValue : _enum) {
			assertTrue(" L'élément " + locEnumValue.getConstName() + " est déjà présent dans l'énumération " + locEnumValue.getClass() + ".",locUniqueSet.add(locEnumValue.getConstName()));
		}
		locUniqueSet.clear();
	}
	
	/**
	 * Vérifie que le {@link Object#toString()} de l'enum est
	 * identique à sa méthode {@link IWithConstName#getConstName()}
	 */
	@Test(timeout = 3000L)
	public void testIdenticalValueToString() {
		for(IWithConstName locEnumValue : _enum) {
			assertEquals(locEnumValue.getConstName(), locEnumValue.toString());
		}
	}
}
