package ar.com.espumito.util;

import java.util.Collection;

public interface Finder
{
    public <T, S, U extends FinderComparator<? super T, ? super S>> T find(Collection<T> collection, S id, U comparator); 
}
