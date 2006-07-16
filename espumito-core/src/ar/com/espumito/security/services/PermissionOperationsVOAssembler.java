package ar.com.espumito.security.services;

import ar.com.espumito.security.domain.PermissionBean;
import ar.com.espumito.services.ValueObject;
import ar.com.espumito.services.ValueObjectAssemblerImpl;
import ar.com.espumito.services.ValueObjectMappingException;

public class PermissionOperationsVOAssembler
    extends ValueObjectAssemblerImpl
{

    private OperationVOAssembler operationVOAssembler;

    public PermissionOperationsVOAssembler(OperationVOAssembler operationVOAssembler)
    {
        super();
        this.operationVOAssembler = operationVOAssembler;
    }

    /**
     * @see ar.com.espumito.services.ValueObjectAssemblerImpl#createValueObject(java.lang.Object)
     */
    @Override
    public ValueObject createValueObject(Object bean)
        throws ValueObjectMappingException
    {
        PermissionBean permission = (PermissionBean) bean;
        PermissionOperationsVO ret = new PermissionOperationsVO();
        if (permission.getReadOperation() != null)
            ret.setReadOperation((OperationVO) this.operationVOAssembler.createValueObject(permission
                    .getReadOperation()));
        if (permission.getWriteOperation() != null)
            ret.setWriteOperation((OperationVO) this.operationVOAssembler.createValueObject(permission
                    .getWriteOperation()));
        if (permission.getExecuteOperation() != null)
            ret.setExecuteOperation((OperationVO) this.operationVOAssembler.createValueObject(permission
                    .getExecuteOperation()));
        if (permission.getDeleteOperation() != null)
            ret.setDeleteOperation((OperationVO) this.operationVOAssembler.createValueObject(permission
                    .getDeleteOperation()));
//        ret.addAllExtendedOperations(this.operationVOAssembler.createValueObjectCollection(permission
//                .getExtendedPermissionsOperations().values()));
        return ret;
    }
}
