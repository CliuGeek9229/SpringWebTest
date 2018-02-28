<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="web2017.team8.liucong.domain.Customer"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!-- 管理员登录成功之后的主界面 -->
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>主界面</title>
</head>
<body>
	<center>管理员：${user.getUsername() },恭喜你登录成功!</center>
	<center>上次登录时间为：${ lasttime }</center>
<body>
	<center>
		<table width="900" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="60" bgcolor="#E6F5FF"
					style="color: #06F; font-size: 19px; font-weight: bolder; padding-left: 50px;">会员管理系统</td>
			</tr>

			<tr>
				<td height="500" align="center" valign="top"><table width="900"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="191" height="500" align="center" valign="top"
								background="Images/leftbg.jpg"><%@ include file="Left.jsp"%>
							</td>
							<td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table
									width="709" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" background="Images/mainMenuBg.jpg"
											style="padding-left: 25px;">会员管理</td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form
												name="form1" method="post" action="<c:url value="/SelectCusCheck.html"/>">
												<table width="100%%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="30%" height="30" style="padding-left: 20px;">
															功能导航： 	<a href="/SpringWorkFir/CustomerAdd.html">添加会员</a>
																	<a href="/SpringWorkFir/ExchangeCredit.html">积分转让</a>
														</td>
														<!--  登陆时直接查询，这个地方做了调整，去除按姓名查询的前端
														<td width="70%">按姓名查询： 
														 
														<input name="selectfield" type="text" class="text1"
															id="selectfield" value="${ selectfield }"> <input type="submit"
															name="button" id="button" value="点击查询">
														</td>
														-->
													</tr>
												</table>
											</form>
											
 											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr align="center" class="t1">
													<td height="25" bgcolor="#D5E4F4"><strong>会员名</strong></td>
													<td bgcolor="#D5E4F4"><strong>年龄</strong></td>
													<td bgcolor="#D5E4F4"><strong>电话号码</strong></td>
													<td bgcolor="#D5E4F4"><strong>个人密码</strong></td>
													<td bgcolor="#D5E4F4"><strong>操作</strong></td>
												</tr>
												<%
												List<Customer> customers=(List<Customer>)request.getAttribute("Customer");
													if(customers.size()!=0){
														for(int i=0;i<customers.size();i++){
															pageContext.setAttribute("cus", customers.get(i));
												%>
													<tr align="center">
														<td>${cus.name}</td>
														<td>${cus.age}</td>
														<td>${cus.phonenum}</td>
														<td>${cus.password}</td>
														
														<td align="center"><a
															href="/SpringWorkFir/Customermodify.html?id=${ cus.id }">修改</a>
															
															<a href="/SpringWorkFir/Customerdelete.html?id=${ cus.id }"
															onClick="return confirm('确定要删除该会员吗？')">删除</a></td>
													</tr>
													<%
														}
													}
														else{
													%>
													<tr><td colspan="6">当前尚无可匹配的会员</td></tr>
													<%
														}																
													%>
												
											</table></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="35" background="Images/bootBg.jpg">&nbsp;</td>
			</tr>
		</table>

	</center>
</body>

</body>

</html>