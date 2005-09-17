<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<tiles:insert definition="basic">
	<tiles:put name="pageName" type="string">
		<bean:message key="links.title"/>
	</tiles:put><tiles:put name="body" type="string">
	<div align="center">
		<p>&nbsp;</p>
			<table width="100%"  border="0" cellspacing="2" cellpadding="0">
				<tr>
					<th style="border: 2px solid #0099cc; ">Amigazos</th>
					<th style="border: 2px solid #0099cc; ">Copados</th>
					<th style="border: 2px solid #0099cc; ">Comerciales</th>
					<th style="border: 2px solid #0099cc; ">Fotologs</th>
				</tr>
                <tr style="vertical-align: top; ">
                    <td width="25%" scope="col" style="border: 1px solid #000000; ">
                        <div align="center">
                            <p><a href="http://www.grave.50g.com" target="_blank"><img src="grave.gif" alt="Grave (Escritos)"></a></p>
                            <p>Literatura de alto vuelo de un amigo de la casa. &iexcl;Solo para avisados!</p>
                            <p><a href="http://www.leonardorocca.com.ar"><img border="0" height="78" src="logoavatar.jpg" width="80"></a></p>
                            <p>&iexcl;Pixar go home!</p>
                            <p><a href="http://www.emilianoromero.com.ar">http://www.emilianoromero.com.ar</a></p>
                            <p>El cine importa, pero no se importa.</p>
                        </div>
                    </td>
                    <td width="25%" scope="col" style="border: 1px solid #000000; ">
                        <p align="center"><a href="http://www.locoarts.com.ar" target="_blank"><img src="locoarts.jpg" alt="LoCoARTS"></a></p>
                        <p align="center">Sitio oficial de las aventuras de Alejo y Valentina. ¡Imperdible!</p>
                        <p align="center"><a href="http://www.cualquiera.com.ar"><img border="0" height="30" src="cualquiera.gif" width="192"></a></p>
                        <p align="center">Realmente, cualquiera...</p>
                    </td>
                    <td width="25%" scope="col" style="border: 1px solid #000000; ">
                        <div align="center">
                            <p><a href="http://www.thinkgeek.com" target="_blank"><img src="tg-logo.gif" alt="ThinkGeek"></a></p>
                            <p>Lo que el nerd de hoy necesita para ser el mismo nerd de siempre.</p>
                            <p></p>
                        </div>
                    </td>
                    <td width="25%" scope="col" style="border: 1px solid #000000; ">
                        <div align="center">
                            <p><strong>Las chicas: </strong></p>
                            <p><a href="http://fotolog.terra.cl/lu1983" target="_blank">http://fotolog.terra.cl/lu1983</a></p>
                            <p><strong>Los pibes: </strong></p>
                            <p>&nbsp;</p>
                        </div>
                    </td>
                </tr>
            </table>
		</div>
	</tiles:put></tiles:insert>