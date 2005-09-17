<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<tiles:insert definition="basic">
	<tiles:put name="pageName" type="string">
		<bean:message key="register.title"/>
	</tiles:put>
	<tiles:put name="body" type="string">
		<logic:messagesPresent>
			<ul>
				<html:messages id="error">
					<li class="formFieldError"><bean:write name="error"/></li>
				</html:messages>
			</ul>
		</logic:messagesPresent>
		<html:form action="/security/register">
			<table width="100%" >
				<tr>
					<td width="20%"><bean:message key="register.username"/></td>
					<td><html:text property="username" size="15"/></td>
				</tr>
				<tr>
					<td><bean:message key="register.password"/></td>
					<td><html:password property="password" size="15"/></td>
				</tr>
				<tr>
					<td><bean:message key="register.passwordCheck"/></td>
					<td><html:password property="passwordCheck" redisplay="false" size="15"/></td>
				</tr>
				<tr>
					<td><bean:message key="register.email"/></td>
					<td><html:text property="email" size="60"/></td>
				</tr>
				<tr>
					<td><bean:message key="register.emailCheck"/></td>
					<td><html:text property="emailCheck" size="60"/></td>
				</tr>
				<tr>
					<td><bean:message key="register.firstName"/></td>
					<td><html:text property="firstName" size="45"/></td>
				</tr>
				<tr>
					<td><bean:message key="register.lastName"/></td>
					<td><html:text property="lastName" size="45"/></td>
				</tr>
				<tr>
					<td><bean:message key="register.displayName"/></td>
					<td><html:text property="displayName" size="45"/></td>
				</tr>
			</table>
			<html:submit value="Registrar"/>
			<html:reset value="Limpiar"/>
		</html:form>
	</tiles:put>
</tiles:insert>
