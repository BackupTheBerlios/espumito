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
<tiles:insert definition="blog">
    <tiles:put
        name="body"
        type="string">
        <html:form action="/add" method="GET">
            <table
                style="width: 100%;"
                border="0"
                cellpadding="0"
                cellspacing="0">
                <tr>
                    <td style="vertical-align: top;" class="label">Titulo</td>
                    <td><html:text property="title" /></td>
                </tr>
                <tr>
                    <td style="vertical-align: top;" class="label">Texto</td>
                    <td><html:textarea rows="10" cols="60" property="text" /></td>
                </tr>
            </table>
            <html:hidden property="method" value="addEntry"/>
            <html:submit value="Agregar entrada"/>
            <html:reset value="Limpiar"></html:reset>
        </html:form>
    </tiles:put>
</tiles:insert>
