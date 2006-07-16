package ar.com.espumito.core.collections;

import java.util.Collection;

public class MemorialHashSet<E>
    extends java.util.HashSet<E>
    implements MemorialCollection<E>
{

    private java.util.HashSet<E>      added   = new java.util.HashSet<E>();
    private java.util.HashSet<Object> removed = new java.util.HashSet<Object>();
    private MemorialCollectionHelper<E>       helper  = new MemorialCollectionHelper<E>(this.added, this.removed);

    @Override
    public boolean add(E o)
    {
        this.helper.add(o);
        return super.add(o);
    }

    public Collection<E> getAdded()
    {
        return this.helper.getAdded();
    }

    public int getAddedCount()
    {
        return this.helper.getAddedCount();
    }

    public Collection<Object> getRemoved()
    {
        return this.helper.getRemoved();
    }

    public int getRemovedCount()
    {
        return this.helper.getRemovedCount();
    }

    @Override
    public boolean remove(Object o)
    {
        boolean ret = super.remove(o);
        if (ret)
            this.helper.remove(o);
        return ret;
    }
}
