<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<tiles:insert definition="basic">
	<tiles:put name="pageName" type="string">
		<bean:message bundle="security" key="recoverPwd.title"/>
	</tiles:put>
	<tiles:put name="body" type="string">
	</tiles:put>
</tiles:insert>
