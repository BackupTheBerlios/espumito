<%@ page
    language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib
    uri="/tags/struts-html"
    prefix="html"%>
<%@ taglib
    uri="/tags/struts-bean"
    prefix="bean"%>
<html:form
    action="/createBlog"
    method="GET">
    <table
        cellpadding="0"
        cellspacing="3"
        border="0">
        <tr>
            <td><bean:message key="forms.createBlog.name" /></td>
            <td><html:text property="name" /></td>
            <td><html:messages
                id="nameErrorMessage"
                property="name">
                <span
                    style="text-align: left;"
                    class="formFieldError"> <bean:write
                    name="nameErrorMessage" /> </span>
            </html:messages></td>
        </tr>
        <tr>
            <td><bean:message key="forms.createBlog.title" /></td>
            <td><html:text property="title" /></td>
            <td><html:messages
                id="titleErrorMessage"
                property="title">
                <span
                    style="text-align: left;"
                    class="formFieldError"> <bean:write
                    name="titleErrorMessage" /> </span>
            </html:messages></td>
        </tr>
    </table>
    <html:submit value="Crear blog" />
</html:form>
