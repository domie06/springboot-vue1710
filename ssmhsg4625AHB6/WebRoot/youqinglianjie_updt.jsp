﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改友情连接</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="youqinglianjie_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateYouqinglianjie.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改友情连接<input type="hidden" name="id" value="${youqinglianjie.id}" /></td>
						</tr>
						<tr ><td width="200">网站名称：</td><td><input name='wangzhanmingcheng' type='text' id='wangzhanmingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelwangzhanmingcheng' /></td></tr>		<tr ><td width="200">网址：</td><td><input name='wangzhi' type='text' id='wangzhi' value='' onblur='checkform()' size='50' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelwangzhi' /></td></tr>		<tr ><td width="200">LOGO：</td><td><input name='LOGO' type='text' id='LOGO' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('LOGO')" style='border:solid 1px #000000; color:#666666'/></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.wangzhanmingcheng.value='${youqinglianjie.wangzhanmingcheng}';</script>	<script language="javascript">document.form1.wangzhi.value='${youqinglianjie.wangzhi}';</script>	<script language="javascript">document.form1.LOGO.value='${youqinglianjie.LOGO}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var wangzhanmingchengobj = document.getElementById("wangzhanmingcheng"); if(wangzhanmingchengobj.value==""){document.getElementById("clabelwangzhanmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入网站名称</font>";return false;}else{document.getElementById("clabelwangzhanmingcheng").innerHTML="  "; } 	var wangzhiobj = document.getElementById("wangzhi"); if(wangzhiobj.value==""){document.getElementById("clabelwangzhi").innerHTML="&nbsp;&nbsp;<font color=red>请输入网址</font>";return false;}else{document.getElementById("clabelwangzhi").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
