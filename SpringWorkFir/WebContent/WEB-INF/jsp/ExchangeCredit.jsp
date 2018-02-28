<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>！！转让积分！！</title>
</head>

<body>

	<center>
		<h2>转让积分</h2>
	</center>
	<center>
		<form action="<c:url value="/Change.html"/>" method="post" name="form1" onsubmit="return mycheck()">
			 	
			 	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
                  <tr align="center">
                  	<td align="center"><label>每次转让5积分，由A到B</label></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>A：</td>
                    <td><input name="name1" type="text"  id="name1"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>B：</td>
                    <td><input name="name2" type="text"  id="name2"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="确认转让">  
                    </td>
                  </tr>
                </table>
			 	
		</form>
	</center>

</body>
</html>