
    <jsp:directive.page language="java"
        contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
    </jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>BDGest</title>
<link rel="stylesheet" type="text/css" href="css/bdgest.css" ></link>
<script src="script/jquery-1.4.1.min.js" ></script>
<script src="script/bdgest-jquery.js" ></script>
</head>
<body>
	<!-- La liste des boutons -->
		<table>
		<tr><td>
			<select id="objectType" onchange="displayItems()">
				<option selected="selected" value="albums">Albums</option>
				<option value="parabd">Para-BD</option>
				<option value="revues">Revues</option>
			</select></td></tr>
		<tr><td>
		<div id="listeBoutons"></div>
		</td></tr>
		<tr>
		<td style="vertical-align:top;">
		<div id="response" ></div>
		</td>
		<td style="vertical-align:top;">
		<div id="listeResume"></div>
		</td>
		</tr>
		</table>
</body>
</html>
