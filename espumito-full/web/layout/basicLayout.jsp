<%@ page
    contentType="text/html; charset=iso-8859-1"
    language="java"%>
<%@ taglib
    uri="/tags/struts-tiles"
    prefix="tiles"%>
<%@ taglib
    uri="/tags/struts-bean"
    prefix="bean"%>
<%@ taglib
    uri="/tags/struts-html"
    prefix="html"%>
<%@ taglib
    uri="/tags/struts-logic"
    prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><bean:message bundle="portal" key="siteName" /></title>
<meta
    http-equiv="Content-Type"
    content="text/html; charset=iso-8859-1">
<link
    rel="stylesheet"
    type="text/css"
    href="<html:rewrite page='/style.css' module="" />" />
    
   <script src="<html:rewrite page='/scripts/prototype.js' module=""/>"></script>
   <script src="<html:rewrite page='/scripts/rico.js' module=""/>"></script>
   <script src="<html:rewrite page='/scripts/util.js' module=""/>"></script>
   <script>
	  var onloads = new Array();
	  function bodyOnLoad() {
		 new Effect.Round( null, 'roundNormal' );
		 new Effect.Round( null, 'roundCompact', {compact:true} );
		 for ( var i = 0 ; i < onloads.length ; i++ )
			onloads[i]();
	  }
	</script>
</head>
<%--<body onload="javascript:bodyOnLoad()">--%>
<body>
<table
    width="100%"
    border="0"
    cellspacing="0"
    cellpadding="0"
    height="100%"
    class="layout">
    <tr>
        <td class="siteHeader"><tiles:insert attribute="header" /></td>
    </tr>
    <tr>
        <td>
        <table width="100%">
            <tr>
                <td class="navBar">
                    <tiles:insert
                        attribute="menu"/>
                    <br/>
                    <logic:present role="admin">
                        <br>
                        <tiles:insert
                            attribute="adminMenu"/>
                    </logic:present>
                </td>
                <td class="content"><a name="top"></a>
                    <div class="sectionMenu">
                        <tiles:insert attribute="sectionMenu" ignore="true" />
                    </div>
                    <br />
                    <div class="body">
                        <tiles:insert attribute="body" />
                    </div>
                </td>
            </tr>
        </table>
        </td>
    </tr>
    <tr>
        <td><br/><tiles:insert attribute="footer" /></td>
    </tr>
</table>
</body>
</html>
