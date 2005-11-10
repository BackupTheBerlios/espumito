<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<%@ page import="ar.com.espumito.blogs.web.Symbols" %>
<%@ page import="ar.com.espumito.blogs.vo.BlogEntryVO" %>
<tiles:insert definition="blog">
    <tiles:put name="body" type="string">
        <logic:present name="<%= Symbols.ATTR_BLOG_ENTRY %>">
            <bean:define id="entry" name="<%= Symbols.ATTR_BLOG_ENTRY %>" type="BlogEntryVO"/>
            <div class="blogEntry roundNormal">
                <div class="date"><bean:write name="entry" property="publicationDate" formatKey="format.date"/></div>
                <div class="title"><bean:write name="entry" property="title"/></div>
                <br/>
                <div class="text"><bean:write name="entry" property="text" filter="true"/></div>
            </div>
            <br/>
            <div class="blogEntryComments">
                <logic:notEmpty name="entry" property="comments">
                    <div style="font-weight: bold;">Comentarios</div>
                    <br/>
                    <logic:iterate id="comment" name="entry" property="comments">
                    <div class="comment">
                        <div class="date"><bean:write name="comment" property="publicationDate" formatKey="format.date"/></div>
                        <div class="author"><bean:write name="comment" property="author"/> (<bean:write name="comment" property="authorEmail"/>)</div>
                        <br/>
                        <div class="text"><bean:write name="comment" property="text" filter="true"/></div>
                        <br/>
                        </div>
                    </logic:iterate>
                </logic:notEmpty>
                <logic:empty name="entry" property="comments">
                    <div style="font-weight: bold;">(No hay comentarios)</div>
                    <br/>
                </logic:empty>
            </div>
            <br/>
            <html:link action="/addComment?method=step1" paramId="<%= Symbols.PARAM_BLOG_ENTRY_ID %>" paramName="entry" paramProperty="id">Comentar esta entrada</html:link>
        </logic:present>
    </tiles:put>
</tiles:insert>