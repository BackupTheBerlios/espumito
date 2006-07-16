package ar.com.espumito.util;

public interface FinderComparator<T, S>
{
    public boolean matches(T object, S id);
}
