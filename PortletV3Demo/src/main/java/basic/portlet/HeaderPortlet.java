/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package basic.portlet;

import java.io.IOException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ActionURL;
import javax.portlet.GenericPortlet;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortalContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.w3c.dom.Element;

import static javax.portlet.MimeResponse.Copy.*;
import static basic.portlet.Constants.*;

/**
 * Portlet for testing the redirect funtionality, including the new getRedirectURL API.
 */
public class HeaderPortlet extends GenericPortlet {

   private static final Logger  LOGGER  = Logger.getLogger(HeaderPortlet.class.getName());
   private static final boolean isDebug = LOGGER.isLoggable(Level.FINE);
   
   @Override
   public void renderHeaders(HeaderRequest req, HeaderResponse resp) throws PortletException, IOException {
      
      if (LOGGER.isLoggable(Level.FINE)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Doing the headers. ");
         txt.append("portal ctx prop names: ");
         txt.append(Collections.list(req.getPortalContext().getPropertyNames()).toString());
         txt.append(", markup head prop: ");
         txt.append(req.getPortalContext().getProperty(PortalContext.MARKUP_HEAD_ELEMENT_SUPPORT));
         txt.append(", RENDER_PART: ");
         txt.append((String)req.getAttribute(PortletRequest.RENDER_PART));
         LOGGER.fine(txt.toString());
      }

      // Add link tag to head section to include the style sheet
      Element link = resp.createElement("link");
      link.setAttribute("rel", "stylesheet");
      link.setAttribute("type", "text/css");
      String contextRoot = req.getContextPath();
      link.setAttribute("href", contextRoot + "/resources/css/styles.css");
      resp.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, link);

   }

   @Override
   protected void doView(RenderRequest req, RenderResponse resp) throws PortletException, IOException {
      
      if (LOGGER.isLoggable(Level.FINE)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Rendering. ");
         txt.append("RENDER_PART: ");
         txt.append((String)req.getAttribute(PortletRequest.RENDER_PART));
         LOGGER.fine(txt.toString());
      }

      resp.setContentType("text/html");

      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher("/WEB-INF/jsp/view-hdp.jsp");
      rd.include(req, resp);

   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp) throws PortletException, IOException {
   }

   public void processAction(ActionRequest req, ActionResponse resp) throws PortletException, IOException {
   }

}
