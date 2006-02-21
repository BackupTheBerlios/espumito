package ar.com.espumito.links.client;

import java.util.Set;

import org.springframework.core.io.ClassPathResource;

import ar.com.espumito.links.domain.LinkBean;
import ar.com.espumito.links.services.LinksService;
import ar.com.espumito.support.spring.SpringSupport;
import ar.org.blah.j2ee.CreateException;

public class LinksServiceBDlg implements LinksService {

	private LinksService linksService;

	public LinksServiceBDlg() {
		linksService = (LinksService) SpringSupport.getBeanFactory(
				new ClassPathResource(
						"META-INF/espumito-links-client-spring.xml")).getBean(
				"linksSvc");
	}

	public Set getLinks() {
		return linksService.getLinks();
	}

	public void addLink(LinkBean link) throws CreateException {
		linksService.addLink(link);
	}
}
