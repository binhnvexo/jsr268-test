/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

/**
 * Created by The eXo Platform SAS
 * Author : BinhNV
 *          binhnv@exoplatform.com
 * Jun 27, 2012  
 */
public class Jsr286EventPublisherPortlet extends GenericPortlet {

  @RenderMode(name="view")
  public void viewNormal(RenderRequest request, RenderResponse response) throws PortletException, IOException {
    String name = (String) request.getParameter("name");
    String email = (String) request.getParameter("email");
    if (name != null && email != null) {
      request.setAttribute("name", name);
      request.setAttribute("email", email);
      getPortletContext().getRequestDispatcher("/xhtml/viewTest.jsp").include(request, response);
    } else {
      getPortletContext().getRequestDispatcher("/xhtml/view.jsp").include(request, response);
    }
  }
  
  @ProcessAction(name="savecontact")
  public void saveContact(ActionRequest request, ActionResponse response) throws PortletException, IOException {
    
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    
    String contactInfo = name + "," + email;
    
    response.setRenderParameter("name", name);
    response.setRenderParameter("email", email);
    response.setEvent(new QName("http:mycompany.com/events", "contactInfo"), contactInfo);
    
  }
  
}
