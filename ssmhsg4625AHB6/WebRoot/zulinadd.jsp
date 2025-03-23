<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html class="no-js">
<head>
<meta />
<title>租赁</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="qtimages/css/reset.css" rel="stylesheet" />
<link href="qtimages/css/main.css" rel="stylesheet"/>
<link href="qtimages/css/sub.css" rel="stylesheet"/>
<script src="qtimages/jquery.js"></script> 
<script src="js/jquery.SuperSlide.2.1.1.js"></script>

<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
</head>
<%
if(request.getSession().getAttribute("username")==null)
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.do';</script>");
	return;
}
  String id="";


 



   %>


	
	<script language="javascript">
function checkform()
{
	var zulintianshuobj = document.getElementById("zulintianshu"); if(zulintianshuobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(zulintianshuobj.value)){document.getElementById("clabelzulintianshu").innerHTML=""; }else{document.getElementById("clabelzulintianshu").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}      var zongjiaj=1;if(document.getElementById("rizujia").value!=""){zongjiaj=zongjiaj*parseFloat(document.getElementById("rizujia").value);}if(document.getElementById("zulintianshu").value!=""){zongjiaj=zongjiaj*parseFloat(document.getElementById("zulintianshu").value);}document.getElementById("zongjia").value=zongjiaj;	
}
function gow()
{
	document.location.href="zulinadd.jsp?id=<%=id%>";
}
</script>


<body>
<jsp:include page="qttop.jsp"></jsp:include>

<div class="content">
	<div class="wrap">
		<div class="pad0">
			<div class="s_title">
				<div class="name">租赁</div>
				<div class="menu">
					
				</div>
			</div>
			<div class="det_con"> 
					
					<% 




%>

  
<form action="addZulin.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						
						<tr ><td width="200">车辆编号：</td><td><input name='cheliangbianhao' type='text' id='cheliangbianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.cheliangbianhao.value='<%=connDbBean.readzd("cheliangxinxi","cheliangbianhao","id",request.getParameter("id"))%>';document.form1.cheliangbianhao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">车辆名称：</td><td><input name='cheliangmingcheng' type='text' id='cheliangmingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.cheliangmingcheng.value='<%=connDbBean.readzd("cheliangxinxi","cheliangmingcheng","id",request.getParameter("id"))%>';document.form1.cheliangmingcheng.setAttribute("readOnly",'true');</script>		<tr ><td width="200">类型：</td><td><input name='leixing' type='text' id='leixing' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.leixing.value='<%=connDbBean.readzd("cheliangxinxi","leixing","id",request.getParameter("id"))%>';document.form1.leixing.setAttribute("readOnly",'true');</script>		<tr ><td width="200">车牌号：</td><td><input name='chepaihao' type='text' id='chepaihao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.chepaihao.value='<%=connDbBean.readzd("cheliangxinxi","chepaihao","id",request.getParameter("id"))%>';document.form1.chepaihao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">日租价：</td><td><input name='rizujia' type='text' id='rizujia' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.rizujia.value='<%=connDbBean.readzd("cheliangxinxi","rizujia","id",request.getParameter("id"))%>';document.form1.rizujia.setAttribute("readOnly",'true');</script>		<tr ><td width="200">租赁天数：</td><td><input name='zulintianshu' type='text' id='zulintianshu' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelzulintianshu' />必需数字型</td></tr>		<tr ><td width="200">总价：</td><td><input name='zongjia' type='text' id='zongjia' value='' onblur='' style='border:solid 1px #000000; color:#666666' readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>		<tr ><td width="200">租赁人：</td><td><input name='zulinren' type='text' id='zulinren' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
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
			<script language="javascript">popheight = 450;</script>
					
			</div>	
		</div>
	</div>		
</div>
<jsp:include page="qtdown.jsp"></jsp:include>


</body>
</html>

