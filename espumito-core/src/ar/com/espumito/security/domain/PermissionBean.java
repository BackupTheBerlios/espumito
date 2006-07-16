package ar.com.espumito.security.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * <p>
 * Permission on a security object for a role.
 * </p>
 * <p>
 * Date: 20-mar-2006
 * </p>
 * 
 * @author guybrush
 */
public class PermissionBean
{

    public static final PermissionBean  DENIED_PERMISSION    = new PermissionBean(null, false, false, false, false);
    public static final PermissionBean  ANONYMOUS_PERMISSION = new PermissionBean(null, false, true, true, false);
    private long                        id;
    private boolean                     delete;
    private boolean                     execute;
    private boolean                     read;
    private RoleBean                    role;
    private boolean                     write;
    private Set<ExtendedPermissionBean> extendedPermissions  = new HashSet<ExtendedPermissionBean>();
    private OperationBean               readOperation;
    private OperationBean               writeOperation;
    private OperationBean               deleteOperation;
    private OperationBean               executeOperation;

    public PermissionBean()
    {
        super();
    }

    public PermissionBean(RoleBean role, boolean delete, boolean execute, boolean read, boolean write)
    {
        super();
        this.delete = delete;
        this.execute = execute;
        this.read = read;
        this.role = role;
        this.write = write;
    }

    /**
     * @return the deleteOperation
     */
    public OperationBean getDeleteOperation()
    {
        return this.deleteOperation;
    }

    /**
     * @return the executeOperation
     */
    public OperationBean getExecuteOperation()
    {
        return this.executeOperation;
    }

    public Set<ExtendedPermissionBean> getExtendedPermissions()
    {
        return this.extendedPermissions;
    }

    /**
     * @return Returns the id.
     */
    public long getId()
    {
        return this.id;
    }

    public Collection<OperationBean> getOperations()
    {
        Vector<OperationBean> operations = new Vector<OperationBean>();
        operations.add(this.readOperation);
        operations.add(this.deleteOperation);
        operations.add(this.writeOperation);
        operations.add(this.executeOperation);
        for (ExtendedPermissionBean extendedPermission : this.extendedPermissions)
            operations.addAll(extendedPermission.getOperations());
        return operations;
    }

    /**
     * @return the readOperation
     */
    public OperationBean getReadOperation()
    {
        return this.readOperation;
    }

    /**
     * @return Returns the role.
     */
    public RoleBean getRole()
    {
        return this.role;
    }

    /**
     * @return the writeOperation
     */
    public OperationBean getWriteOperation()
    {
        return this.writeOperation;
    }

    /**
     * @return Returns the delete.
     */
    public boolean isDelete()
    {
        return this.delete;
    }

    /**
     * @return Returns the execute.
     */
    public boolean isExecute()
    {
        return this.execute;
    }

    /**
     * @return Returns the read.
     */
    public boolean isRead()
    {
        return this.read;
    }

    /**
     * @return Returns the write.
     */
    public boolean isWrite()
    {
        return this.write;
    }

    /**
     * @param delete
     *            The delete to set.
     */
    public void setDelete(boolean delete)
    {
        this.delete = delete;
    }

    /**
     * @param deleteOperation
     *            the deleteOperation to set
     */
    public void setDeleteOperation(OperationBean deleteOperation)
    {
        this.deleteOperation = deleteOperation;
    }

    /**
     * @param execute
     *            The execute to set.
     */
    public void setExecute(boolean execute)
    {
        this.execute = execute;
    }

    /**
     * @param executeOperation
     *            the executeOperation to set
     */
    public void setExecuteOperation(OperationBean executeOperation)
    {
        this.executeOperation = executeOperation;
    }

    public void setExtendedPermissions(Set<ExtendedPermissionBean> extendedPermissions)
    {
        this.extendedPermissions = extendedPermissions;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * @param read
     *            The read to set.
     */
    public void setRead(boolean read)
    {
        this.read = read;
    }

    /**
     * @param readOperation
     *            the readOperation to set
     */
    public void setReadOperation(OperationBean readOperation)
    {
        this.readOperation = readOperation;
    }

    /**
     * @param role
     *            The role to set.
     */
    public void setRole(RoleBean role)
    {
        this.role = role;
    }

    /**
     * @param write
     *            The write to set.
     */
    public void setWrite(boolean write)
    {
        this.write = write;
    }

    /**
     * @param writeOperation
     *            the writeOperation to set
     */
    public void setWriteOperation(OperationBean writeOperation)
    {
        this.writeOperation = writeOperation;
    }
}
