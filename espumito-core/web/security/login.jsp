<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<tiles:insert definition="basic">
	<tiles:put name="body" type="string">
		<h2><bean:message bundle="security" key="login.mustLogin" /></h2>
		<form id="loginForm" action="j_security_check" method="POST">
		<table class="login">
			<tr>
				<td><bean:message bundle="security"  key="login.username" /></td>
				<td><input name="j_username" type="text" maxlength="15"></td>
			</tr>
			<tr>
				<td><bean:message bundle="security"  key="login.password" /></td>
				<td><input name="j_password" type="password" maxlength="15"></td>
			</tr>
		</table>
		<input type="submit" value="<bean:message bundle="security" key='login.login'/>"></form>
	</tiles:put>
</tiles:insert>
