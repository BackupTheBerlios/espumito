package ar.com.espumito.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Vector;
import ar.com.espumito.services.ValueObject;

public class PermissionVO
    extends ValueObject
{

    private Long                       id;
    private boolean                    delete;
    private boolean                    execute;
    private boolean                    read;
    private boolean                    write;
    private List<ExtendedPermissionVO> extendedPermissions = new Vector<ExtendedPermissionVO>();

    public PermissionVO()
    {
        super();
    }

    public PermissionVO(boolean delete, boolean execute, boolean read, boolean write)
    {
        super();
        this.delete = delete;
        this.execute = execute;
        this.read = read;
        this.write = write;
    }

    public void addAllExtendedPermissions(Collection<ExtendedPermissionVO> extendedPermissions)
    {
        this.extendedPermissions.addAll(extendedPermissions);
    }

    public void addExtendedPermission(ExtendedPermissionVO extendedPermission)
    {
        this.extendedPermissions.add(extendedPermission);
    }

    public List<ExtendedPermissionVO> getExtendedPermissions()
    {
        return this.extendedPermissions;
    }

    public Long getId()
    {
        return this.id;
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

    public void removeExtendedPermission(ExtendedPermissionVO extendedPermission)
    {
        this.extendedPermissions.remove(extendedPermission);
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
     * @param execute
     *            The execute to set.
     */
    public void setExecute(boolean execute)
    {
        this.execute = execute;
    }

    public void setId(Long id)
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
     * @param write
     *            The write to set.
     */
    public void setWrite(boolean write)
    {
        this.write = write;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "[read=" + this.read + " write=" + this.write + " delete=" + this.delete + " execute=" + this.execute
                + "]";
    }
}
