/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package net.java.dev.weblets;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * @author Werner Punz (latest modification by $Author$)
 * @version $Revision$ $Date$
 */

public class WebletResourceHandler extends ResourceHandlerWrapper
{
    public ResourceHandler _wrapped;

    @Override
    public Resource createResource(String resourceName, String libraryName)
    {
        String version = (resourceName.indexOf("/") != -1)? resourceName.substring(0, resourceName.indexOf("/")) : "";
        try
        {
            Float.parseFloat(version);
            resourceName = resourceName.substring(resourceName.indexOf("/") + 1);
        }
        catch (NumberFormatException ex)
        {
        }

        Resource res = super.createResource(resourceName, libraryName);
        if (res != null) return res;
        try
        {
            String resourceURL = WebletUtils.getURL(libraryName, resourceName);
            return new WebletResource(libraryName, resourceName);
        }
        catch (WebletException ex)
        {
            //no weblet found we return null to be in accordance with the jsf spec
            return null;
        }

    }

    @Override
    public Resource createResource(String resourceName, String libraryName, String contentType)
    {
        String version = (resourceName.indexOf("/") != -1)? resourceName.substring(0, resourceName.indexOf("/")) : "";
        try
        {
            Float.parseFloat(version);
            resourceName = resourceName.substring(resourceName.indexOf("/") + 1);
        }
        catch (NumberFormatException ex)
        {
        }
        Resource res = super.createResource(resourceName, libraryName, contentType);
        if (res != null) return res;
        try
        {
            String resourceURL = WebletUtils.getURL(libraryName, resourceName);
            return new WebletResource(libraryName, resourceName, contentType);
        }
        catch (WebletException ex)
        {
            //no weblet found we return null to be in accordance with the jsf spec
            return null;
        }

    }

    public WebletResourceHandler(ResourceHandler wrapped)
    {
        _wrapped = wrapped;
    }

    @Override
    public void handleResourceRequest(FacesContext context) throws IOException
    {
        super.handleResourceRequest(context);
    }

    @Override
    public ResourceHandler getWrapped()
    {
        return _wrapped;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
