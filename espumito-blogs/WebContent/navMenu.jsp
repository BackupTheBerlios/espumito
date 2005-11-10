<%@ page
    language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ar.com.espumito.blogs.web.Symbols"%>
<%@ taglib
    uri="/tags/struts-html"
    prefix="html"%>
<%@ taglib
    uri="/tags/struts-bean"
    prefix="bean"%>
<%@ taglib
    uri="/tags/struts-logic"
    prefix="logic"%>
<div style="background-color: #FD8433;" class="roundNormal navMenu">
<html:link action="/index"> <bean:message key="blogs.link.home" /> </html:link> | 
<logic:present name="<%= Symbols.ATTR_BLOG_MODEL %>">
    <html:link page="/addBlogEntry.jsp"> <bean:message key="blogs.link.addEntry" /> </html:link> | 
    <html:link action="/blog?method=displayAllEntries"> <bean:message key="blogs.link.displayAllEntries" /> </html:link> |
</logic:present>
<html:link action="/searchBlogs"> <bean:message key="blogs.link.navigateBlogs" /> </html:link> |
<html:link page="#"> <bean:message key="blogs.link.mostRecent" /> </html:link> |
<html:link page="#"> <bean:message key="blogs.link.mostRecentlyUpdated" /> </html:link> |
<html:link action="/createBlogDialog" module="/blogs"><bean:message key="blogs.link.createNewBlog" /></html:link>
</div>
