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

package net.java.dev.weblets.impl.faces.util;

import net.java.dev.weblets.FacesWebletUtils;

import javax.faces.context.FacesContext;

/**
 * @author Werner Punz (latest modification by $Author$)
 * @version $Revision$ $Date$
 */

public class FacesElJSFWebletResource extends JSFDummyMap
{
    private class PathInfoMap extends JSFDummyMap
    {

        private String webletName = "";

        public PathInfoMap(String webletName)
        {
            this.webletName = webletName;
        }

        public Object get(Object resource)
        {
            if (!(resource instanceof String))
                throw new UnsupportedOperationException("Not supported yet.");
            return FacesWebletUtils.getJSFResource(FacesContext.getCurrentInstance(), webletName, (String) resource);
        }
    }

    public Object get(Object webletName)
    {
        if (!(webletName instanceof String))
            throw new UnsupportedOperationException("only String keys are allowed");
        return (new PathInfoMap((String) webletName));
    }
}
