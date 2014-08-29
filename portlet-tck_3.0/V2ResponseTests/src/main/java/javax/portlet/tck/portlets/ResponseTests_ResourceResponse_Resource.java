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

package javax.portlet.tck.portlets;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.xml.namespace.QName;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet ResponseTests_ResourceResponse_Resource_event
 *
 */
public class ResponseTests_ResourceResponse_Resource implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         ResponseTests_ResourceResponse_Resource.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2ResponseTests_ResourceResponse_Resource_fieldHTTP_STATUS_CODE  */
      /* Details: "Has String field HTTP_STATUS_CODE with value of            */
      /* \"portlet.http-status-code\""                                        */
      TestResult tr0 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_RESOURCE_FIELDHTTP_STATUS_CODE );
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_Resource_setLocale1       */
      /* Details: "Method setLocale(Locale): Sets the locale of the           */
      /* response"                                                            */
      TestResult tr1 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_RESOURCE_SETLOCALE1);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_Resource_setLocale4       */
      /* Details: "Method setLocale(Locale): Throws                           */
      /* IllegalArgumentException if the Locale parameter is null"            */
      TestResult tr2 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_RESOURCE_SETLOCALE4);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_Resource_setCharacterEncoding1 */
      /* Details: "Method setCharacterEncoding(String): Sets the character    */
      /* encoding of the response"                                            */
      TestResult tr3 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_RESOURCE_SETCHARACTERENCODING1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_Resource_setCharacterEncoding4 */
      /* Details: "Method setCharacterEncoding(String): Throws                */
      /* IllegalArgumentException if the Locale parameter is null"            */
      TestResult tr4 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_RESOURCE_SETCHARACTERENCODING4);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_Resource_setContentLength1 */
      /* Details: "Method setContentLength(int): Sets the length of the       */
      /* content body"                                                        */
      TestResult tr5 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_RESOURCE_SETCONTENTLENGTH1);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_Resource_createRenderURL2 */
      /* Details: "Method createRenderURL(): Throws IllegalStateException     */
      /* if the cacheability level for the resource URL triggering the        */
      /* serveResource call is not PAGE"                                      */
      TestResult tr6 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_RESOURCE_CREATERENDERURL2);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_Resource_createActionURL2 */
      /* Details: "Method createActionURL(): Throws IllegalStateException     */
      /* if the cacheability level for the resource URL triggering the        */
      /* serveResource call is not PAGE"                                      */
      TestResult tr7 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_RESOURCE_CREATEACTIONURL2);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2ResponseTests_ResourceResponse_Resource_createResourceURL2 */
      /* Details: "Method createResourceURL(): Throws IllegalStateException   */
      /* if the cacheability level for the resource URL triggering the        */
      /* serveResource call is not PAGE"                                      */
      TestResult tr8 = tcd.getTestResultFailed(V2RESPONSETESTS_RESOURCERESPONSE_RESOURCE_CREATERESOURCEURL2);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write("<div id=\"ResponseTests_ResourceResponse_Resource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"ResponseTests_ResourceResponse_Resource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
