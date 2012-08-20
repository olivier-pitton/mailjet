package fr.mailjet.servlet;

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

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * L'implémentation par défaut d'une {@link HttpServlet} qui reçoit les évènements
 * envoyés par Mailjet. La modification du path par défaut se fait dans le fichier WEB-INF/web.xml
 * @author Pitton Olivier
 *
 */
public class MailjetServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * {@inheritDoc}
   */
  @Override
  protected final void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    BufferedReader reader = req.getReader();
    String tmp = null;
    // Read the JSON content
    StringBuilder builder = new StringBuilder();
    while((tmp = reader.readLine()) != null) {
      builder.append(tmp);
    }
    //TODO : add code here
    resp.setStatus(HttpServletResponse.SC_OK);
  }

}
