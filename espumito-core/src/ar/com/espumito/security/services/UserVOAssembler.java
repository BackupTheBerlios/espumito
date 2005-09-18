/*
 * Created on 07-mar-2005
 */
package ar.com.espumito.security.services;

import java.io.Serializable;

import javax.ejb.CreateException;

import org.apache.log4j.Logger;

import ar.com.espumito.security.domain.UserBean;
import ar.com.espumito.security.vo.UserVO;
import ar.com.espumito.util.StringUtil;
import ar.org.blah.j2ee.persistence.PersistenceException;
import ar.org.blah.j2ee.vo.ValueObject;
import ar.org.blah.j2ee.vo.ValueObjectAssembler;
import ar.org.blah.j2ee.vo.ValueObjectAssemblerImpl;
import ar.org.blah.j2ee.vo.ValueObjectMappingException;

public class UserVOAssembler extends ValueObjectAssemblerImpl {
    private static Logger logger = Logger.getLogger(UserVOAssembler.class);

    private ValueObjectAssembler roleVOAssembler;

    public UserVOAssembler() {
        super();
    }
    
    public void setRoleVOAssembler(ValueObjectAssembler rolesVOAssembler) {
        this.roleVOAssembler = rolesVOAssembler;
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectAssembler#createInstance(java.io.Serializable,
     *      ar.org.blah.j2ee.vo.ValueObject)
     */
    public Object createInstance(Serializable id, ValueObject valueObject)
            throws ValueObjectMappingException {
        UserVO vo = null;
        try {
            vo = (UserVO) valueObject;

        } catch (ClassCastException e) {
            throw new IllegalArgumentException(valueObject.getClass().getName()
                    + " is not a valid value object type.");
        }
        UserBean user;
        try {
            user = new UserBean(vo.getUsername(), vo.getPassword(), vo
                    .getPasswordCheck(), vo.getEmail(), vo.getEmailCheck());
            user.setDisplayName(vo.getDisplayName());
            user.setFirstName(vo.getFirstName());
            user.setLastName(vo.getLastName());
            
            return user;
        } catch (CreateException e) {
            logger.debug("Error creando usuario", e);
            throw new ValueObjectMappingException(e);
        }
        
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectAssembler#createValueObject(java.lang.Object)
     */
    public ValueObject createValueObject(Object bean)
            throws ValueObjectMappingException {
        UserBean user = null;
        try {
            user = (UserBean) bean;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(bean.getClass().getName()
                    + " is not a valid bean type.");
        }
        UserVO vo = new UserVO();
        vo.setUsername(user.getUsername());
        vo.setDisplayName(user.getDisplayName());
        vo.setEmail(user.getEmail());
        vo.setRegistrationDate(user.getRegistrationDate());
        vo.setFirstName(user.getFirstName());
        vo.setLastName(user.getLastName());
        roleVOAssembler.createValueObjectCollection(user.getRoles(), vo.getRoles());
        vo.setEnabled(user.isEnabled());
        vo.setVersion(user.getVersion());
        return vo;
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectAssembler#updateBean(ar.org.blah.j2ee.vo.ValueObject,
     *      java.lang.Object)
     */
    public Object updateBean(ValueObject valueObject, Object bean)
            throws ValueObjectMappingException {
        UserBean user = (UserBean) bean;
        UserVO vo = (UserVO) valueObject;
        user.setDisplayName(vo.getDisplayName());
        if (StringUtil.isNotBlank(vo.getEmail())
                && !vo.getEmail().equals(user.getEmail()))
            user.setEmail(vo.getEmail(), vo.getEmailCheck());
        if (StringUtil.isNotBlank(vo.getPassword()))
            user.setPassword(vo.getPassword(), vo.getPasswordCheck());
        else
            logger.info("Password not changed since it's blank.");
        user.setEnabled(vo.isEnabled());
        user.setFirstName(vo.getFirstName());
        user.setLastName(vo.getLastName());
        user.setVersion(vo.getVersion());
        return user;
    }
}
