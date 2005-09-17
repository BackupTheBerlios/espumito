<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><bean:message key="siteName" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<%--<link rel="stylesheet" type="text/css" href="<tiles:getAsString name='stylesheetRef' ignore='true'/>"/>--%>
<link rel="stylesheet" type="text/css"
	href="<html:rewrite page='/style.css'/>" />
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	height="100%" class="layout">
	<tr>
		<td class="siteHeader"><tiles:insert attribute="header" /></td>
	</tr>
	<tr>
		<td>
		<table width="100%">
			<tr>
				<td class="navBar"><tiles:insert attribute="menu" ignore="true"/> <br />
				<tiles:insert attribute="headlines" ignore="true"/> <logic:present role="admin">
					<br>
					<tiles:insert attribute="adminMenu" ignore="true"/>
				</logic:present></td>
				<td class="content"><a name="top"></a>
				<table class="sectionMenu" width="100%">
					<tr>
						<td id="pageName" style="width: 20%;">
						<h2><tiles:insert attribute="pageName" ignore="true"/></h2>
						</td>
						<td id="menuItems" style="width: 80%;"><tiles:insert
							attribute="sectionMenu" ignore="true"/></td>
					</tr>
				</table>
				<br />
				<div class="body"><tiles:insert attribute="body" /></div>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td><tiles:insert attribute="footer" /></td>
	</tr>
</table>
</body>
</html>
