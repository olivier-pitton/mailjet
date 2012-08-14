package fr.mailjet.webservice;

/*
 *  Mailjet %% Copyright (C) 2012 Pitton Olivier - olivier dot pitton at
 * gmail dot com %% Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License. 
 */

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * L'implémentation du service web qui recevra les requêtes d'évènements. La
 * requête envoyée par le service Mailjet correspond au paramètre spécifié dans
 * la méthode {@link #mailjet(String)}. Si vous désirez modifier le chemin du
 * service web, vous pouvez modifier la valeur de l'annotation {@link Path} en
 * la faisant commencer par un "/".
 * 
 * @author Pitton Olivier
 * 
 */
@Path("/mailjet")
public class MailjetWebservice {

	/**
	 * Méthode principale recevant tous les évènements mailjet. Les paramètres
	 * envoyés sont passés en paramètre automatiquement. Attention si la
	 * {@link Response} renvoyée n'a pas un status 200, l'évènement sera renvoyé X
	 * fois - Voir la documentation ci-dessous. <br />
	 * <a href="https://fr.mailjet.com/docs/event_tracking">Documentation
	 * Mailjet</a>. Cette méthode attend exclusivement des requêtes POST dont le
	 * contenu est <b>obligatoirement</b> du JSON.
	 * 
	 * @param parEventContent
	 *          {@link String} le JSON envoyé par Mailjet
	 * @return {@link Response} la réponse à renvoyer au serveur.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response mailjet(String parEventContent) {
		// TODO : do action here
		// On retourne un code 200
		return Response.ok().build();
	}
}
