package ar.com.espumito.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import ar.com.espumito.services.ValueObject;

public class PermissionOperationsVO
    extends ValueObject
{

    private OperationVO       readOperation;
    private OperationVO       writeOperation;
    private OperationVO       deleteOperation;
    private OperationVO       executeOperation;
    private List<OperationVO> extendedOperations = new Vector<OperationVO>();

    public PermissionOperationsVO()
    {
        super();
    }
    
    public void addAllExtendedOperations(Collection<OperationVO> operations)
    {
        this.extendedOperations.addAll(operations);
    }

    public void addExtendedOperation(OperationVO operation)
    {
        this.extendedOperations.add(operation);
    }

    /**
     * @return the deleteOperation
     */
    public OperationVO getDeleteOperation()
    {
        return this.deleteOperation;
    }

    /**
     * @return the executeOperation
     */
    public OperationVO getExecuteOperation()
    {
        return this.executeOperation;
    }

    /**
     * @return the extendedOperations
     */
    public List<OperationVO> getExtendedOperations()
    {
        return this.extendedOperations;
    }

    /**
     * @return the readOperation
     */
    public OperationVO getReadOperation()
    {
        return this.readOperation;
    }

    /**
     * @return the writeOperation
     */
    public OperationVO getWriteOperation()
    {
        return this.writeOperation;
    }

    public void removeExtendedOperation(OperationVO operation)
    {
        this.extendedOperations.remove(operation);
    }

    /**
     * @param deleteOperation
     *            the deleteOperation to set
     */
    public void setDeleteOperation(OperationVO deleteOperation)
    {
        this.deleteOperation = deleteOperation;
    }

    /**
     * @param executeOperation
     *            the executeOperation to set
     */
    public void setExecuteOperation(OperationVO executeOperation)
    {
        this.executeOperation = executeOperation;
    }

    /**
     * @param readOperation
     *            the readOperation to set
     */
    public void setReadOperation(OperationVO readOperation)
    {
        this.readOperation = readOperation;
    }

    /**
     * @param writeOperation
     *            the writeOperation to set
     */
    public void setWriteOperation(OperationVO writeOperation)
    {
        this.writeOperation = writeOperation;
    }
}
