package ar.com.espumito.util;

import java.util.Collection;

public class LinearFinder
    implements Finder
{
    private static LinearFinder instance = new LinearFinder();

    public static LinearFinder getInstance()
    {
        return instance;
    }

    protected LinearFinder()
    {
    }

    public <T, S, U extends FinderComparator<? super T, ? super S>> T find(Collection<T> collection, S id, U comparator)
    {
        if (collection == null || id == null || comparator == null)
            return null;
        for (T element : collection)
        {
            if (comparator.matches(element, id))
            {
                return element;
            }
        }
        return null;
    }
}
