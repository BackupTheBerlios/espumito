<%@ page
    language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib
    uri="/tags/struts-tiles"
    prefix="tiles"%>
<%@ taglib
    uri="/tags/struts-bean"
    prefix="bean"%>
<%@ taglib
    uri="/tags/struts-logic"
    prefix="logic"%>
<%@ taglib
    uri="/tags/struts-html"
    prefix="html"%>
<%@ page import="ar.com.espumito.blogs.web.Symbols"%>
<%@ page import="ar.com.espumito.blogs.vo.BlogEntryVO"%>
<tiles:insert definition="blog">
    <tiles:put
        name="body"
        type="string">
        <logic:present name="<%= Symbols.ATTR_BLOG_ENTRY_COLLECTION %>">
            <logic:iterate
                id="entry"
                name="<%= Symbols.ATTR_BLOG_ENTRY_COLLECTION %>"
                type="BlogEntryVO">
                <div>
                <html:link
                    action="/display?method=displayEntry"
                    paramId="<%= Symbols.PARAM_BLOG_ENTRY_ID %>"
                    paramName="entry"
                    paramProperty="id">
                    <bean:write
                        name="entry"
                        property="title" />
                    (<bean:write
                        name="entry"
                        property="publicationDate"
                        formatKey="format.date" />)
                </html:link>
                </div>
            </logic:iterate>
        </logic:present>
    </tiles:put>
</tiles:insert>
