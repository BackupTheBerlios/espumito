<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<div class="footer">
<html:link href="/about.jsp"><bean:message bundle="portal" key="footer.aboutUs"/></html:link>
 | <a href="#"><bean:message bundle="portal" key="footer.siteMap"/></a>
 | <html:link href="/privacy.jsp"><bean:message bundle="portal" key="footer.privacyPolicy"/></html:link>
 | <a href="mailto:espumito@gmail.com"><bean:message bundle="portal" key="footer.contactUs"/></a>
 | <bean:message bundle="portal" key="footer.copyright"/>
</div>