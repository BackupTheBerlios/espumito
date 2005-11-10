<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%!String[] rowClasses = new String[] { "even", "odd" }; %>
<tiles:insert definition="basic">
	<tiles:put name="pageName" type="string">
		<bean:message bundle="security" key="editUser.title" />
	</tiles:put>
	<tiles:put name="body" type="string">
		<logic:messagesPresent>
			<ul>
				<html:messages id="error">
					<li class="formFieldError"><bean:write name="error" /></li>
				</html:messages>
			</ul>
		</logic:messagesPresent>
		<html:form action="/admin/editUserStep2">
			<table width="100%">
				<tr>
					<td width="20%"><bean:message bundle="security" key="register.username" /></td>
					<td><bean:write name="editUser" property="username" /><html:hidden
						property="username" /></td>
				</tr>
				<tr>
					<td><bean:message bundle="security" key="register.password" /></td>
					<td><html:password property="password" size="15" /></td>
				</tr>
				<tr>
					<td><bean:message bundle="security" key="register.passwordCheck" /></td>
					<td><html:password property="passwordCheck" redisplay="false"
						size="15" /></td>
				</tr>
				<tr>
					<td><bean:message bundle="security" key="register.email" /></td>
					<td><html:text property="email" size="60" /></td>
				</tr>
				<tr>
					<td><bean:message bundle="security" key="register.firstName" /></td>
					<td><html:text property="firstName" size="45" /></td>
				</tr>
				<tr>
					<td><bean:message bundle="security" key="register.lastName" /></td>
					<td><html:text property="lastName" size="45" /></td>
				</tr>
				<tr>
					<td><bean:message bundle="security" key="register.displayName" /></td>
					<td><html:text property="displayName" size="45" /></td>
				</tr>
				<tr>
					<td><bean:message bundle="security" key="usersAdmin.enabled" /></td>
					<td><html:checkbox property="enabled" /></td>
				</tr>
			</table>
			<html:hidden property="version" />
			<html:submit value="Actualizar" />
		</html:form>
	</tiles:put>
</tiles:insert>
