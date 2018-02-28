<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>！！修改会员！！</title>
</head>
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.name.value)){  
   alert("请输入用户名！"); 
   return false;
   }
   if(isNull(form1.password.value)){
   alert("请输入密码！");
   return false;
   }
   if(isNull(form1.confirmpw.value)){
   alert("请输入重复密码！");
   return false;
   }
   if (document.form1.password.value != document.form1.confirmpw.value) { 
   alert("您两次输入的密码不一致！请重新输入！"); 
   return false; 
   }
   if(isNull(form1.age.value)){
	   alert("请输入年龄！");
	   return false;
	   }
   if(isNull(form1.phonenum.value)){
   alert("请输入联系电话！");
   return false;
   }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
<body>

	<center>
		<h2>修改会员信息</h2>
	</center>
	<center>
		<c:if test="${!empty error }">
			<font color="red"><c:out value="${ error }" /></font>
		</c:if>
		<input type="hidden" name="id" value="${ Customer.id }">
		<form action="<c:url value="/Modify.html?id=${Customer.id}"/>" method="post" name="form1" onsubmit="return mycheck()">
			 	
			 	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>用户名：</td>
                    <td><input name="name" type="text"  id="name" value="${Customer.name}"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>密码：</td>
                    <td><input name="password" type="password"  id="password" value="${Customer.password}"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>确认密码：</td>
                    <td><input name="confirmpw" type="password"  id="confirmpw" value="${Customer.password}"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>年龄：</td>
                    <td><input name="age" type="text"  id="age" value="${Customer.age}"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>联系电话：</td>
                    <td><input name="phonenum" type="text"  id="phonenum" value="${Customer.phonenum}" ></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改会员">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
			 	
		</form>
	</center>

</body>
</html>
