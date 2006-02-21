package ar.com.espumito.links.services;

import ar.com.espumito.links.domain.LinkBean;
import ar.com.espumito.links.domain.LinksHome;
import ar.org.blah.j2ee.CreateException;
import java.util.Set;

public class LinksServiceImpl implements LinksService {

	private LinksHome linksHome;

	public LinksServiceImpl() {
	}

	public Set getLinks() {
		return linksHome.findAll();
	}

	public LinksHome getLinksHome() {
		return linksHome;
	}

	public void setLinksHome(LinksHome linksHome) {
		this.linksHome = linksHome;
	}

	public void addLink(LinkBean link) throws CreateException {
		linksHome.create(link);
	}
}
