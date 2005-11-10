<%@ page
    language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib
    uri="/tags/struts-tiles"
    prefix="tiles"%>
<%@ taglib
    uri="/tags/struts-html"
    prefix="html"%>
<%@ taglib
    uri="/tags/struts-bean"
    prefix="bean"%>
<%@ taglib
    uri="/tags/struts-logic"
    prefix="logic"%>
<tiles:importAttribute name="portals"/>
<% int i = 1; %>
<logic:iterate id="portal" name="portals">
    [Portal: <%= i++ %>]
    <tiles:insert name="portal.jsp">
        <tiles:put name="content" value="portal"/>
    </tiles:insert>
    <br/>
</logic:iterate>
