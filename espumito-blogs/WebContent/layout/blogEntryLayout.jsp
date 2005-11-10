<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:useAttribute id="entry" name="entry"/>
<logic:present name="entry">
    <div class="blogEntry">
        <h3><bean:write name="entry" property="title"/> - <bean:write name="entry" property="publicationDate" formatKey="format.date"/></h3>
        <div class="blogEntryText">
            <bean:write name="entry" property="text"/>
        </div>
    </div>
</logic:present>