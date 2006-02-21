package ar.com.espumito.links.services;

import ar.com.espumito.links.domain.LinkBean;
import ar.org.blah.j2ee.CreateException;
import java.util.Set;

public interface LinksService
{

    public abstract Set getLinks();

    public abstract void addLink(LinkBean linkbean)
        throws CreateException;
}
