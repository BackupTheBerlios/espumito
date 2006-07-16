package ar.com.espumito.core.collections;

import java.util.Collection;


public interface MemorialCollection<E>
{
    public Collection<E> getAdded();
    public Collection<Object> getRemoved();
    public int getAddedCount();
    public int getRemovedCount();
}
