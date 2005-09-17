<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<div
	style="background-image: url(<html:rewrite page='/images/header-bkg.gif'/>);">
<table style="width: 100%;">
	<tr>
		<td width="160" style="text-align:center; "><html:image
			src="/images/argend.gif" style="width: 120px; height:90px;"
			alt="Argentina, pa&iacute;s generoso..." /></td>
		<td width="30%">
		<table>
			<tr>
				<td><span class="siteTitle"><html:link page="/">
					<bean:message key="siteName" />
				</html:link></span></td>
			</tr>
			<tr>
				<td><a href="#">no</a> | <a href="#">tenemos</a> | <a href="#">ni</a>
				| <a href="#">un</a> | <a href="#">solo</a> | <a href="#">link</a></td>
			</tr>
		</table>
		</td>
		<td width="55%"
			style="text-align: right; width:70%; padding-right: 10px; vertical-align: top;">
		<%if (request.getUserPrincipal() != null) {

                %> <bean:message
			bundle="security" key="connectedAs" />: <span class="username"><%=request.getUserPrincipal()%></span><br />
		<html:link href="" anchor="">
			<bean:message bundle="security" key="myProfile" />
		</html:link> | <html:link action="/security/logout" module="core">
			<bean:message key="login.logout" />
		</html:link> <%} else {

                %>
		<form action="j_security_check" method="POST">
		<div style="font-weight: bold;"><bean:message key="login.username" />:
		<input name="j_username" type="text" size="7" maxlength="15"> <bean:message
			key="login.password" />: <input name="j_password" type="password"
			size="7" maxlength="15"> <input name="" type="submit"
			value="<bean:message key='login.login'/>"> <input name="currentUrl"
			type="hidden" value="<%= request.getRequestURL() %>"></div>
		<br />
		<html:link page="/security/register.jsp">
			<bean:message key="register.register" />
		</html:link></form>
		<%}

        %></td>
	</tr>
</table>
</div>
