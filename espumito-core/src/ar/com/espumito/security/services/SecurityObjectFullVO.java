package ar.com.espumito.security.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import ar.com.espumito.security.vo.RoleVO;

public class SecurityObjectFullVO
    extends SecurityObjectVO
{

    private Map<RoleVO, PermissionVO> permissions = new HashMap<RoleVO, PermissionVO>();
    private Long                      permissionPolicyId;

    public void addPermission(RoleVO role, PermissionVO permission)
    {
        this.permissions.put(role, permission);
    }

    public Set<RoleVO> getAssignedRoles()
    {
        return this.permissions.keySet();
    }

    public PermissionVO getPermission(RoleVO role)
    {
        return this.permissions.get(role);
    }

    public Long getPermissionPolicyId()
    {
        return this.permissionPolicyId;
    }

    public Map<RoleVO, PermissionVO> getPermissions()
    {
        return this.permissions;
    }

    public void setPermissionPolicyId(Long permissionPolicyId)
    {
        this.permissionPolicyId = permissionPolicyId;
    }
}
