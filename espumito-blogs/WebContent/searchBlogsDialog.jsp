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
<div class="roundCompact searchBox"><html:form
    action="/navigateBlogs"
    method="GET">
                Buscar blogs: <html:text property="searchCriteria" /> 
                Cantidad de registros por página: <html:select
        property="pageSize">
        <html:option value="5" />
        <html:option value="10" />
        <html:option value="20" />
        <html:option value="50" />
        <html:option value="100" />
    </html:select>
    <html:submit value="Buscar" />
</html:form></div>
