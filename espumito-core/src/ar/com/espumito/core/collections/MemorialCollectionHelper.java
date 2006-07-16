package ar.com.espumito.core.collections;

import java.util.Collection;
import java.util.HashSet;


public class MemorialCollectionHelper<E> implements MemorialCollection<E>
{
    private Collection<E> added;
    private Collection<Object> removed;
    
    public MemorialCollectionHelper()
    {
        this.added = new HashSet<E>();
        this.removed = new HashSet<Object>();
    }
    
    public MemorialCollectionHelper(Collection<E> added, Collection<Object> removed)
    {
        super();
        this.added = added;
        this.removed = removed;
    }

    public void add(E o)
    {
        this.added.add(o);
        this.removed.remove(o);
    }
    
    public void remove(Object o)
    {
        this.added.remove(o);
        this.removed.add(o);
    }
    
    public Collection<E> getAdded()
    {
        return this.added;
    }
    
    public Collection<Object> getRemoved()
    {
        return this.removed;
    }

    public int getAddedCount()
    {
        return this.added.size();
    }

    public int getRemovedCount()
    {
        return this.removed.size();
    }
}
