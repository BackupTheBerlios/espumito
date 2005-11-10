<%@ page
    language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ar.com.espumito.blogs.web.Symbols"%>
<%@ taglib
    uri="/tags/struts-bean"
    prefix="bean"%>
<%@ taglib
    uri="/tags/struts-logic"
    prefix="logic"%>
<%@ taglib
    uri="/tags/struts-tiles"
    prefix="tiles"%>
<%@ taglib
    uri="/tags/espumito-blogs"
    prefix="blogs"%>
<%@ taglib
    uri="/tags/espumito-core"
    prefix="core"%>
<logic:present name="<%= Symbols.ATTR_BLOG %>">
    <bean:define id="blog" name="<%= Symbols.ATTR_BLOG %>" toScope="page"/>
    <h2><bean:write name="blog" property="name"/></h2><br/>
    <h2><bean:write name="blog" property="title"/></h2><br/>
    <blogs:define name="blog" entriesPaginationName="entries" toScope="session">
        <core:navigation name="entries"/>
        <logic:iterate id="entry" name="blog" property="entries">
<%--            <h3><bean:write name="entry" property="title"/> - <bean:write name="entry" property="publicationDate" formatKey="format.date"/></h3>--%>
            <tiles:insert definition="blogEntry" flush="false">
                <tiles:put name="entry" beanName="entry"/>
            </tiles:insert>
<%--            <div class="blogEntryBox">
                <bean:write name="entry" property="text"/>
            </div>--%>
        </logic:iterate>
    </blogs:define>
</logic:present>
<logic:notPresent name="<%= Symbols.ATTR_BLOG %>">
    <h2>No recibi un blog</h2>
</logic:notPresent>