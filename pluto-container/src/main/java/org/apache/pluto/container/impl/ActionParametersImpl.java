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


package org.apache.pluto.container.impl;

import java.util.Map;

import javax.portlet.ActionParameters;
import javax.portlet.MutableActionParameters;
import javax.portlet.MutablePortletParameters;

import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.PortletURLProvider.ParamType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author nick
 *
 */
public class ActionParametersImpl extends PortletParametersImpl implements
      ActionParameters {
   private static final Logger   LOGGER     = LoggerFactory.getLogger(ActionParametersImpl.class);
   private static final boolean  isTrace    = LOGGER.isDebugEnabled();

   /**
    * For creating a new object from scratch
    * 
    * @param urlProvider
    * @param windowId
    */
   public ActionParametersImpl(PortletURLProvider urlProvider, String windowId) {
      super(urlProvider, windowId, ParamType.ACTION);
   }
   
   /**
    * For cloning an object
    * 
    * @param params
    * @param windowId
    */
   protected ActionParametersImpl(Map<String, String[]> params, String windowId) {
      super(params, windowId, ParamType.ACTION);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#mutableClone()
    */
   @Override
   public MutableActionParameters clone() {
      if (isTrace) {
         LOGGER.debug("Window ID: " + windowId + ", ParameterType: " + type);
      }

      // create a mutable clone, breaking link to the underlying URL provider.
      MutableActionParametersImpl map = new MutableActionParametersImpl(params, windowId);
      
      return map;
   }

}
