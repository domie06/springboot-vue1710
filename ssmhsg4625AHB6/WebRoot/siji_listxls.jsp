<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="sijihsgb" scope="page" class="com.bean.SijiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=siji.xls");
%>
<html>
  <head>
    <title>司机</title>
  </head>

  <body >
 <%
			String sql="select * from siji  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>编号</td>    <td align='center'>姓名</td>    <td  width='40' align='center'>性别</td>    <td  width='90' align='center'>照片</td>    <td align='center'>所在地</td>    <td align='center'>擅长车型</td>    <td align='center'>联系手机</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=sijihsgb.getAllSiji(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.xingming}</td>    <td align='center'>${u.xingbie}</td>    <td width='90' align='center'><a href='${u.zhaopian}' target='_blank'><img src='${u.zhaopian}' width=88 height=99 border=0 /></a></td>    <td>${u.suozaidi}</td>    <td>${u.shanchangchexing}</td>    <td>${u.lianxishouji}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

