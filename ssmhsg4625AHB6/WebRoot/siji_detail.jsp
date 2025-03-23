<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>司机详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  司机详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>编号：</td><td width='39%'>${siji.bianhao}</td><td  rowspan=6 align=center><a href=${siji.zhaopian} target=_blank><img src=${siji.zhaopian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>姓名：</td><td width='39%'>${siji.xingming}</td></tr><tr><td width='11%' height=44>性别：</td><td width='39%'>${siji.xingbie}</td></tr><tr><td width='11%' height=44>所在地：</td><td width='39%'>${siji.suozaidi}</td></tr><tr><td width='11%' height=44>擅长车型：</td><td width='39%'>${siji.shanchangchexing}</td></tr><tr><td width='11%' height=44>联系手机：</td><td width='39%'>${siji.lianxishouji}</td></tr><tr><td width='11%' height=100  >个人简介：</td><td width='39%' colspan=2 height=100 >${siji.gerenjianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

