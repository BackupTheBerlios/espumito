/*
 * Created on 27-may-2005
 */
package ar.org.blah.util;

import java.util.Date;

/**
 * @author guybrush
 */
public interface Created {
    public static final Comparator CREATED_COMPARATOR = CreatedComparator.INSTANCE;

    public Date getCreationDate();

    public boolean createdBefore(Created created);

    public boolean createdBefore(Date date);
}
