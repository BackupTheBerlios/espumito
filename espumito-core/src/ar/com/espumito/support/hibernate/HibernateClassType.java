package ar.com.espumito.support.hibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.espumito.util.StringUtil;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.UserType;

/**
 * A Hibernate user type to store classes as strings. The fully qualified name
 * of the class is stored in the database column.
 * 
 * @author guybrush
 * 
 */
public class HibernateClassType implements UserType {
    private static final int[] SQL_TYPES = new int[] { java.sql.Types.VARCHAR };

    public Object deepCopy(Object value) throws HibernateException {
	return (Class) value;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
	return x.equals(y);
    }

    public boolean isMutable() {
	return false;
    }

    public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
	    throws HibernateException, SQLException {
	String value = rs.getString(rs.findColumn(names[0]));
	try {
	    return StringUtil.isNotBlank(value) ? Class.forName(value) : null;
	} catch (ClassNotFoundException e) {
	    throw new HibernateException(e);
	}
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index)
	    throws HibernateException, SQLException {
	Class clazz = (Class) value;
	st.setString(index, (clazz != null) ? clazz.getName() : null);
    }

    public Class returnedClass() {
	return Class.class;
    }

    public int[] sqlTypes() {
	return SQL_TYPES;
    }

}
