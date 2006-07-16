package ar.com.espumito.core.collections;

import java.util.Collection;

public class MemorialVector<E>
    extends java.util.Vector<E>
    implements MemorialCollection<E>
{

    private java.util.Vector<E>      added   = new java.util.Vector<E>();
    private java.util.Vector<Object> removed = new java.util.Vector<Object>();
    private MemorialCollectionHelper<E>      helper  = new MemorialCollectionHelper<E>(this.added, this.removed);

    @Override
    public synchronized boolean add(E o)
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
