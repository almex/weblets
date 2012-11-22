package net.java.dev.weblets.impl.faces;

import net.java.dev.weblets.impl.faces.util.FacesELWebletJSFURL;
import net.java.dev.weblets.impl.faces.util.FacesELWebletURL;
import net.java.dev.weblets.impl.faces.util.FacesElExtWebletResource;
import net.java.dev.weblets.impl.faces.util.FacesElExtWebletURL;
import net.java.dev.weblets.impl.faces.util.FacesElIsResourceLoaded;
import net.java.dev.weblets.impl.faces.util.FacesElJSFWebletResource;
import net.java.dev.weblets.impl.faces.util.FacesElWebletResource;

import java.util.Map;

/**
 * Wrapper to enable . notation in our weblet jsf demos!
 *
 * @author: Werner Punz
 * @date: 13.02.2008.
 */
public class FacesElWebletImpl extends net.java.dev.weblets.FacesElWeblet
{
    FacesElWebletResource resourceHandler = new FacesElWebletResource();
    FacesELWebletURL urlHandler = new FacesELWebletURL();
    FacesElExtWebletURL extUrlHandler = new FacesElExtWebletURL();
    FacesElExtWebletResource extResourceHandler = new FacesElExtWebletResource();

    FacesElIsResourceLoaded resourceLoaded = new FacesElIsResourceLoaded();
    FacesELWebletJSFURL jsfURLHandler = new FacesELWebletJSFURL();
    FacesElJSFWebletResource jsfResourceHandler = new FacesElJSFWebletResource();

    /**
     * enables a weblet.resource[][] notation on the jsf side of things
     *
     * @return
     */
    public Map getResource()
    {
        return resourceHandler;
    }

    /**
     * enables a weblet.url[][] notation on the jsf side of things
     *
     * @return
     */
    public Map getUrl()
    {
        return urlHandler;
    }

    /**
     * @return a map which allows to check for duplicate parameters
     */
    public Map getExtResource()
    {
        return extResourceHandler;
    }

    /**
     * @return a map for urls which allows to check for duplicate parameters!
     */
    public Map getExtUrl()
    {
        return extUrlHandler;
    }

    /**
     * Resource loaded implementation on
     * el dummy map level!
     *
     * @return
     */
    public Map getResourceLoaded()
    {
        return resourceLoaded;
    }

    public Map getJsfURL()
    {
        return jsfURLHandler;
    }

    public Map getJsfResource()
    {
        return jsfResourceHandler;
    }
}
