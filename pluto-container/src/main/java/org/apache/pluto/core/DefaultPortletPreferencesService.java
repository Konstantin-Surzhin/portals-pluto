package org.apache.pluto.core;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.services.optional.PortletPreferencesService;

/**
 * Default implementation of the portlet preferences service. The portlet
 * preferences service is a singleton held by the pluto portlet container.
 * 
 * @see javax.portlet.PortletPreferences
 * @see org.apache.pluto.core.impl.PortletPreferencesImpl
 * @see org.apache.pluto.core.PortletPreference
 * 
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class DefaultPortletPreferencesService
implements PortletPreferencesService {
	
	/** Logger. */
	private static final Log LOG = LogFactory.getLog(
			DefaultPortletPreferencesService.class);
	
	
	// Private Member Variables ------------------------------------------------
	
	/**
	 * The in-memory portlet preferences storage: key is the preference name as
	 * a string, value is an array of PortletPreference objects.
	 */
	private Map storage = new HashMap();
	
	
	// Constructor -------------------------------------------------------------
	
	/**
	 * Default no-arg constructor.
	 */
	public DefaultPortletPreferencesService() {
		// Do nothing.
	}
	
	
	// PortletPreferencesService Impl ------------------------------------------
	
	/**
	 * Returns the stored portlet preferences array. The preferences managed by
	 * this service should be protected from being directly accessed, so this
	 * method returns a cloned copy of the stored preferences.
	 * 
	 * @see org.apache.pluto.core.PortletPreference#clone()
	 * 
	 * @param portletWindow  the portlet window.
	 * @param request  the portlet request from which the remote user is retrieved.
	 * @return a copy of the stored portlet preferences array.
	 * @throws PortletContainerException
	 */
	public PortletPreference[] getStoredPreferences(PortletWindow portletWindow,
	                                                PortletRequest request)
	throws PortletContainerException {
        String key = getFormattedKey(portletWindow, request);
        PortletPreference[] preferences = (PortletPreference[]) storage.get(key);
        if (preferences == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("No portlet preferences found for: " + key);
            }
            return new PortletPreference[0];
        } else {
        	if (LOG.isDebugEnabled()) {
        		LOG.debug("Got " + preferences.length + " stored preferences.");
        	}
        	return clonePreferences(preferences);
        }
    }
	
	/**
	 * Stores the portlet preferences to the in-memory storage. This method
	 * should be invoked after the portlet preferences are validated by the
	 * preference validator (if defined).
	 * <p>
	 * The preferences managed by this service should be protected from being
	 * directly accessed, so this method clones the passed-in preferences array
	 * and saves it.
	 * </p>
	 * 
	 * @see javax.portlet.PortletPreferences#store()
	 * @see org.apache.pluto.core.PortletPreference#clone()
	 * 
	 * @param portletWindow  the portlet window
	 * @param request  the portlet request from which the remote user is retrieved.
	 * @param preferences  the portlet preferences to store.
	 * @throws PortletContainerException
	 */
    public void store(PortletWindow portletWindow,
                      PortletRequest request,
                      PortletPreference[] preferences)
    throws PortletContainerException {
        String key = getFormattedKey(portletWindow, request);
        storage.put(key, clonePreferences(preferences));
        if (LOG.isDebugEnabled()) {
            LOG.debug("Portlet preferences stored for: " + key);
        }
    }
    
    
    // Private Methods ---------------------------------------------------------
    
    /**
     * Formats the preference key for the portlet preference using specified
     * portlet window and remote user.
     * @param portletWindow  the portlet window.
     * @param user  the remote user.
     */
    private String getFormattedKey(PortletWindow portletWindow,
                                   PortletRequest request) {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("user=").append(request.getRemoteUser()).append(";");
    	buffer.append("portletName=").append(portletWindow.getPortletName());
    	return buffer.toString();
    }
    
    /**
     * Clones a PortletPreference array. This method performs a deep clone on
     * the passed-in portlet preferences array. Every PortletPreference object
     * in the array are cloned (via the <code>PortletPreference.clone()</code>
     * method) and injected into the new array.
     * 
     * @see org.apache.pluto.core.PortletPreference#clone()
     * 
     * @param preferences  the portlet preferences array to clone.
     * @return a deep-cloned copy of the portlet preferences array.
     */
    private PortletPreference[] clonePreferences(PortletPreference[] preferences) {
    	if (preferences == null) {
    		return null;
    	}
    	PortletPreference[] copy = new PortletPreference[preferences.length];
    	for (int i = 0; i < preferences.length; i++) {
    		if (preferences[i] != null) {
    			copy[i] = (PortletPreference) preferences[i].clone();
    		} else {
    			copy[i] = null;
    		}
    	}
    	return copy;
    }
    
}

