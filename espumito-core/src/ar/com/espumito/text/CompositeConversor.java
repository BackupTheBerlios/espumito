/*
 * Created on 27-mar-2005
 */
package ar.com.espumito.text;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class CompositeConversor implements TextConversor {
    private Collection conversors = new Vector();

    public CompositeConversor() {
        super();

    }

    public void addConversor(TextConversor conversor) {
        this.conversors.add(conversor);
    }

    public void removeConersor(TextConversor conversor) {
        this.conversors.remove(conversor);
    }

    public String convert(String string) {
        String ret = string;
        for (Iterator i = this.conversors.iterator(); i.hasNext();)
            ret = ((TextConversor) i.next()).convert(ret);
        return ret;
    }

}
