<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<div class="footer">
<html:link href="/about.jsp"><bean:message key="footer.aboutUs"/></html:link>
 | <a href="#"><bean:message key="footer.siteMap"/></a>
 | <html:link href="/privacy.jsp"><bean:message key="footer.privacyPolicy"/></html:link>
 | <a href="mailto:espumito@gmail.com"><bean:message key="footer.contactUs"/></a>
 | <bean:message key="footer.copyright"/>
</div>