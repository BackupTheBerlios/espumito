<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<tiles:insert definition="basic">
	<tiles:put name="pageName" type="string">
		<bean:message key="register.title"/>
	</tiles:put>
	<tiles:put name="body" type="string">
		<div style="text-align: center;">
			<h2><bean:message key="register.success"/></h2>
			<h3><bean:message key="register.success2"/></h3>
		</div>
	</tiles:put>
</tiles:insert>