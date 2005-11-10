<%@ page
    language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib
    uri="/tags/struts-tiles"
    prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta
    http-equiv="Content-Type"
    content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style/blog.css" type="text/css">
<title>blogs</title>
</head>
<body>
<tiles:insert attribute="header" />
<table width="100%">
    <tr>
        <td rowspan="2" style="vertical-align: top; width: 150;">
            <tiles:insert attribute="navMenu" />
        </td>
        <td style="vertical-align: top; text-align: left;">
            <tiles:insert attribute="blogHeader" />
            <br/>
            <tiles:insert attribute="body" />
        </td>
    </tr>
</table>
<tiles:insert attribute="footer" />
</body>
</html>
