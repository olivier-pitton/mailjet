package fr.mailjet;

/*
 * 
 * Mailjet-REST
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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.mailjet.parameters.EnumTests;
import fr.mailjet.rest.impl.ApiRESTServiceTest;
import fr.mailjet.rest.impl.ContactRESTServiceTest;
import fr.mailjet.rest.impl.ListsRESTServiceTest;
import fr.mailjet.rest.impl.MessageRESTServiceTest;
import fr.mailjet.rest.impl.UserRESTServiceTest;

/**
 * Suite de tests
 * 
 * @author Pitton Olivier
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ EnumTests.class, ApiRESTServiceTest.class, ContactRESTServiceTest.class, ListsRESTServiceTest.class, MessageRESTServiceTest.class, UserRESTServiceTest.class })
public class AllTestsSuite {
}
