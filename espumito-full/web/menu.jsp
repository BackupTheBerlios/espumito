<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<table class="menu" cellspacing="0">
	<tr><th id="title"><bean:message key="sections"/></th></tr>
	<tr><td id="item"><html:link action="/showReflexionDeLaSemana" module="reflexiones"><bean:message key="reflexionDeLaSemana.title"/></html:link></tr>
	<tr><td id="item"><html:link action="/showLatestNews" module="news"><bean:message key="news.title"/></html:link></td></tr>
	<tr><td id="item"><html:link page="/forums"><bean:message key="forums.title"/></html:link></tr>
	<tr><td id="item"><html:link page="/guestbook"><bean:message key="guestbook.title"/></html:link></tr>
	<tr><td id="item"><html:link page="/links"><bean:message key="links.title"/></html:link></tr>
</table>
