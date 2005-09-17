<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ page import="ar.com.espumito.web.EspumitoSymbols"%>
<%@ page import="ar.com.espumito.util.*"%>
<%@ page import="ar.com.espumito.security.*"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%! String[] rowClasses = new String[] {"even", "odd"}; %>
<tiles:insert definition="usersAdmin">
	<tiles:put name="pageName" type="string">
		<bean:message key="usersAdmin.title"/>
	</tiles:put>
	<tiles:put name="body" type="string">
		<logic:present name="<%= EspumitoSymbols.USER_ADMIN_USERS%>">
			<table class="basicList" cellspacing="0">
				<tr>
					<th><bean:message key="usersAdmin.username"/></th>
					<th><bean:message key="usersAdmin.firstName"/></th>
					<th><bean:message key="usersAdmin.lastName"/></th>
					<th><bean:message key="usersAdmin.email"/></th>
					<th><bean:message key="usersAdmin.enabled"/></th>
				</tr>
				<% int i = 0; %>
				<logic:iterate id="user" name="<%= EspumitoSymbols.USER_ADMIN_USERS%>" type="ar.com.espumito.security.UserVO">
					<tr class="<%= rowClasses[i++ % 2] %>">
						<td><html:link action="/security/admin/editUserStep1" paramId="id" paramName="user" paramProperty="username"><bean:write name="user" property="username"/></html:link></td>
						<td><bean:write name="user" property="firstName"/></td>
						<td><bean:write name="user" property="lastName"/></td>
						<td><bean:write name="user" property="email"/></td>
						<td><html:checkbox name="user" property="enabled" disabled="true"/></td>
					</tr>
				</logic:iterate>
			</table>
		</logic:present>
	</tiles:put>
</tiles:insert>