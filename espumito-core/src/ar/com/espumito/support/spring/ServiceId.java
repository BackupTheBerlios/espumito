/*
 * Created on 28-ago-2005
 */
package ar.com.espumito.support.spring;

public class ServiceId {
    public static final ServiceId ROLE_GROUP_HOME = new ServiceId("roleGroupHome");
    public static final ServiceId SECURITY_SVC = new ServiceId("securitySvc");
    public static final ServiceId MENU_SVC = new ServiceId("menuSvc");
    
    private String id;
    
    protected ServiceId(String id) {
        super();
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

}
