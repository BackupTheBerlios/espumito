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
<tiles:insert definition="blog">
    <tiles:put name="body" value="/searchBlogsDialog.jsp"/>
</tiles:insert>