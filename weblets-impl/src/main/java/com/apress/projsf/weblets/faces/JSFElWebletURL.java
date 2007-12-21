/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apress.projsf.weblets.faces;

import com.apress.projsf.weblets.misc.WebletsResource;

/**
 * Pseudo map for accessing the weblet url format
 * from legacy jsf applications via elwelbetResolver
 * <h:outputFormat value="#{webletUrl['weblet']['/test.js']}" />
 * 
 * @author Werner Punz
 */
public class JSFElWebletURL extends  JSFDummyMap {

    private class PathInfoMap extends  JSFDummyMap {
        
        private String webletName = "";
        
        public PathInfoMap(String webletName) {
          this.webletName = webletName;
        }


        public Object get(Object resource) {
            if(! (resource instanceof String))
                throw new UnsupportedOperationException("Not supported yet.");
            return  WebletsResource.getResource( webletName ,(String)resource);
        }
        
    }

    public Object get(Object webletName) {
       if(!(webletName instanceof String))
            throw new UnsupportedOperationException("only String keys are allowed");
       return (new PathInfoMap((String)webletName));
    }


}
