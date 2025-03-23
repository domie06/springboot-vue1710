<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>租赁详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  租赁详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>车辆编号：</td><td width='39%'>${zulin.cheliangbianhao}</td>     <td width='11%'>车辆名称：</td><td width='39%'>${zulin.cheliangmingcheng}</td></tr><tr>     <td width='11%'>类型：</td><td width='39%'>${zulin.leixing}</td>     <td width='11%'>车牌号：</td><td width='39%'>${zulin.chepaihao}</td></tr><tr>     <td width='11%'>日租价：</td><td width='39%'>${zulin.rizujia}</td>     <td width='11%'>租赁天数：</td><td width='39%'>${zulin.zulintianshu}</td></tr><tr>     <td width='11%'>总价：</td><td width='39%'>${zulin.zongjia}</td>     <td width='11%'>租赁人：</td><td width='39%'>${zulin.zulinren}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

