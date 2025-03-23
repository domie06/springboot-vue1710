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
	<TITLE>租赁查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">租赁列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="zulinList.do" name="myform" method="post">
									查询   车辆编号：<input name="cheliangbianhao" type="text" id="cheliangbianhao" style='border:solid 1px #000000; color:#666666' size="12" />  车辆名称：<input name="cheliangmingcheng" type="text" id="cheliangmingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  类型：<input name="leixing" type="text" id="leixing" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>车辆编号</td>
    <td align='center'>车辆名称</td>
    <td align='center'>类型</td>
    <td align='center'>车牌号</td>
    <td align='center'>日租价</td>
    <td align='center'>租赁天数</td>
    <td align='center'>总价</td>
    <td align='center'>租赁人</td>
    <td  width='80' align='center'>是否支付</td>
    <td  width='80' align='center'>是否审核</td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.cheliangbianhao}</td>
    <td>${u.cheliangmingcheng}</td>
    <td>${u.leixing}</td>
    <td>${u.chepaihao}</td>
    <td>${u.rizujia}</td>
    <td>${u.zulintianshu}</td>
    <td>${u.zongjia}</td>
    <td>${u.zulinren}</td>
    <td align='center'>${u.iszf}</td>
    <td align='center'>${u.issh} <input type="button" value="审核" onClick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=zulin'"/></td>
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateZulin.do?id=${u.id }">编辑</a>  <a href="deleteZulin.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="zulinDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from zulin where 1=1 ";
				
if(request.getParameter("cheliangbianhao")=="" ||request.getParameter("cheliangbianhao")==null ){}else{String ncheliangbianhao=new String(request.getParameter("cheliangbianhao").getBytes("8859_1"));if(ncheliangbianhao.contains("?")){ncheliangbianhao=request.getParameter("cheliangbianhao");}sql=sql+" and cheliangbianhao like '%"+ncheliangbianhao+"%'";}
if(request.getParameter("cheliangmingcheng")=="" ||request.getParameter("cheliangmingcheng")==null ){}else{String ncheliangmingcheng=new String(request.getParameter("cheliangmingcheng").getBytes("8859_1"));if(ncheliangmingcheng.contains("?")){ncheliangmingcheng=request.getParameter("cheliangmingcheng");}sql=sql+" and cheliangmingcheng like '%"+ncheliangmingcheng+"%'";}
if(request.getParameter("leixing")=="" ||request.getParameter("leixing")==null ){}else{String nleixing=new String(request.getParameter("leixing").getBytes("8859_1"));if(nleixing.contains("?")){nleixing=request.getParameter("leixing");}sql=sql+" and leixing like '%"+nleixing+"%'";}
			sql+=" order by id desc";
double zongjiaz=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						zongjiaz=zongjiaz+Float.valueOf(RS_result.getString("zongjia")).floatValue();

						
						
			 }
			%>
		共计总价:<%=zongjiaz%>； 
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="zulinList.do?page=1" >首页</a>
             <a href="zulinList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="zulinList.do?page=${page.page+1 }">下一页</a>
			<a href="zulinList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
