/*
 * Generated by XDoclet - Do not edit!
 */
package ar.com.espumito.security.services;

/**
 * Home interface for SecuritySvcSession.
 */
public interface SecuritySvcSessionHome
	extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/SecuritySvcSession";
   public static final String JNDI_NAME="ejb/ar/com/espumito/core/SecuritySvcSession";

   public ar.com.espumito.security.services.SecuritySvcSession create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}