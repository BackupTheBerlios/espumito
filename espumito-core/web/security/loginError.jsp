<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<tiles:insert definition="basic">
	<tiles:put name="pageName" type="string">
		<bean:message bundle="security" key="login.title"/>
	</tiles:put>
	<tiles:put name="body" type="string">
		<h2><bean:message bundle="security" key="login.error.loginFailed"/></h2>
		<p><bean:message bundle="security" key="login.error.recover1"/></p>
		<p><bean:message bundle="security" key="login.error.clickToRegister"/> <html:link page="/security/register.jsp"><bean:message bundle="security" key="login.error.clickToRegister.here"/></html:link>.</p>
		<p><bean:message bundle="security" key="login.error.recover"/></p>
		<form action="/recoverPassword">
		    <p><input name="email" type="text" disabled="true"></p>
            <p><input type="submit" disabled="true" value="<bean:message bundle="security" key='login.error.recoverSend'/>"></p>
        </form>
	</tiles:put>
</tiles:insert>
