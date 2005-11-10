<%@ page
    language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib
    uri="/tags/struts-bean"
    prefix="bean"%>
<%@ taglib
    uri="/tags/struts-logic"
    prefix="logic"%>
<%@ page import="ar.com.espumito.blogs.web.Symbols"%>
<div class="blogHeader">
<logic:present name="<%= Symbols.ATTR_BLOG_MODEL %>" scope="session">
    <bean:define
        id="blog"
        name="<%= Symbols.ATTR_BLOG_MODEL %>"
        scope="session"
        toScope="page" />
    <div>
        <h2><bean:write name="blog" property="name"/></h2> <br/>
        <h2 style="color: lime;"><bean:write  name="blog" property="title"/></h2>
    </div>
    <h3><bean:write name="blog" property="author" /></h3>
</logic:present>
</div>