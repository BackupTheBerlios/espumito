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
    uri="/tags/espumito-core"
    prefix="espumito"%>
<%@ taglib
    uri="/tags/struts-logic"
    prefix="logic"%>
<%@ taglib
    uri="/tags/struts-nested"
    prefix="nested"%>
<%@ taglib
    uri="/tags/espumito-blogs"
    prefix="blogs"%>
<%@ taglib
    uri="/tags/espumito-core"
    prefix="core"%>
<%@ page import="ar.com.espumito.blogs.web.Symbols" %>
<%--        <bean:include id="searchBox" page="/searchBlogsDialog.jsp"/>
<bean:write name="searchBox" filter="false"/>--%>
<bean:define id="pagination" name="<%= Symbols.ATTR_BLOG_COLLECTION %>"/>
<bean:define id="navPage" name="pagination" property="nextPage"/>
<core:navigation name="pagination"/>
<table width="100%">
    <tr>
        <th><bean:message key="blog.title"/></th>
        <th><bean:message key="blog.author"/></th>
        <th><bean:message key="blog.lastEntry"/></th>
    </tr>
    <logic:iterate id="blog" name="navPage">
        <tr>
            <td>
                <html:link action="/displayBlog" paramId="<%= Symbols.PARAM_BLOG_ID %>" paramName="blog" paramProperty="id">
                    <bean:write name="blog" property="name"/>
                </html:link>
            </td>
            <td>
                <bean:write name="blog" property="author"/>
            </td>
            <td>&nbsp;</td>
        </tr>
     </logic:iterate>
</table>
