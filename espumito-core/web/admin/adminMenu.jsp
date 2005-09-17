<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<table class="menu" cellspacing="0">
	<tr><th id="title"><bean:message key="admin.menu.title"/></th></tr>
	<tr><td id="item"><html:link action="/security/admin/usersAdmin"><bean:message key="admin.menu.users"/></html:link></tr>
	<tr><td id="item"><html:link action="/security/admin/rolesAdmin"><bean:message key="admin.menu.roles"/></html:link></tr>
</table>
