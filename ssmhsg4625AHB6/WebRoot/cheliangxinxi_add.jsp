<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<TITLE>添加车辆信息</TITLE>
	    

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
	document.location.href="cheliangxinxi_add.jsp?id=<%=id%>";
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
			<form action="addCheliangxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加车辆信息</td>
						</tr>
						<tr ><td width="200">车辆编号：</td><td><input name='cheliangbianhao' type='text' id='cheliangbianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">车辆名称：</td><td><input name='cheliangmingcheng' type='text' id='cheliangmingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelcheliangmingcheng' /></td></tr>		<tr ><td width="200">类型：</td><td><select name='leixing' id='leixing' style=' height:19px; border:solid 1px #000000; color:#666666'><%=connDbBean.hsggetoption("cheliangleixing","leixing")%></select></td></tr>		<tr ><td width="200">车牌号：</td><td><input name='chepaihao' type='text' id='chepaihao' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelchepaihao' /></td></tr>		<tr ><td width="200">图片：</td><td><input name='tupian' type='text' id='tupian' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('tupian')" style='border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">日租价：</td><td><input name='rizujia' type='text' id='rizujia' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelrizujia' />必需数字型</td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>




<script language=javascript >  
function hsgcheck() {
		var chepaihao = $("#chepaihao").val();
		if(chepaihao==""||(chepaihao.length<6||chepaihao.length>12)){
			 $("#clabelchepaihao").html("<font color=red>车牌号不能为空且长度在3～12位之间！</font>");
			 $("input[id=chepaihao]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelchepaihao").html("");
			$.ajax({
				url : "quchongCheliangxinxi.do",
				type : "post",
				data : "chepaihao=" + chepaihao,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelchepaihao").html("<font color=red>车牌号已存在，请更换！</font>");
					$("input[id=chepaihao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelchepaihao").html("系统异常，请检查错误！");
					$("input[id=chepaihao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>


<script language=javascript >  
 
 function checkform(){  
 
	var cheliangmingchengobj = document.getElementById("cheliangmingcheng"); if(cheliangmingchengobj.value==""){document.getElementById("clabelcheliangmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入车辆名称</font>";return false;}else{document.getElementById("clabelcheliangmingcheng").innerHTML="  "; } 	var chepaihaoobj = document.getElementById("chepaihao"); if(chepaihaoobj.value==""){document.getElementById("clabelchepaihao").innerHTML="&nbsp;&nbsp;<font color=red>请输入车牌号</font>";return false;}else{document.getElementById("clabelchepaihao").innerHTML="  "; } 	var rizujiaobj = document.getElementById("rizujia"); if(rizujiaobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(rizujiaobj.value)){document.getElementById("clabelrizujia").innerHTML=""; }else{document.getElementById("clabelrizujia").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
