<%@ page
    contentType="text/html; charset=iso-8859-1"
    language="java"%>
<%@ taglib
    uri="/tags/struts-tiles"
    prefix="tiles"%>
<%@ taglib
    uri="/tags/struts-bean"
    prefix="bean"%>
<%@ taglib
    uri="/tags/struts-html"
    prefix="html"%>
<div style="background: #66CCFF;" class="roundNormal siteHeader">
<table style="width: 100%;">
    <tr>
        <td
            width="160"
            style="text-align:center; ">
            <img src="<html:rewrite page='/images/argend.gif' module=''/>" style="width: 120px; height:90px;" alt="Argentina, pa&iacute;s generoso..."/>
            </td>
        <td width="30%">
        <table>
            <tr>
                <td><span class="siteTitle"><html:link page="/" module="">
                    <bean:message bundle="portal" key="siteName" />
                </html:link></span> <span style="color: white; font-weight: bold;">Alpha1</span></td>
            </tr>
            <tr>
                <td><a href="#">no</a> | <a href="#">tenemos</a> | <a href="#">ni</a>
                | <a href="#">un</a> | <a href="#">solo</a> | <a href="#">link</a></td>
            </tr>
        </table>
        </td>
        <td
            width="55%"
            style="text-align: right; width:70%; padding-right: 10px; vertical-align: top;">
<%
    if (request.getUserPrincipal() != null) {%>
            <bean:message bundle="portal"
                key="connectedAs" />:
                <span class="username"><%= request.getUserPrincipal().getName() %></span><br />
                <%-- 
                <html:link
                    href="#">--%>
                    <bean:message bundle="portal"
                        key="myProfile" />
                <%-- </html:link> --%> |
                <html:link
                    action="/security/logout">
                    <bean:message bundle="portal" key="login.logout" />
                </html:link>
<%} else { %>
            <form
                action="j_security_check"
                method="POST">
                <div style="font-weight: bold;"><bean:message bundle="portal" key="login.username" />:
            <input
                name="j_username"
                type="text"
                size="7"
                maxlength="15"> <bean:message bundle="portal" key="login.password" />: <input
                name="j_password"
                type="password"
                size="7"
                maxlength="15"> <input
                name=""
                type="submit"
                value="<bean:message bundle="portal" key='login.login'/>"> <input
                name="currentUrl"
                type="hidden"
                value="<%= request.getRequestURL() %>"></div>
            <br />
            <html:link page="/core/admin/register.jsp" >
                <bean:message bundle="portal" key="register" />
            </html:link></form>
<%}	%>
        </td>
    </tr>
</table>
</div>
