package ar.com.espumito.security.domain;

import java.util.List;
import javax.ejb.FinderException;


public interface PermissionPolicyHome
{
    public List<PermissionPolicyBean> findAll() throws FinderException;
}
