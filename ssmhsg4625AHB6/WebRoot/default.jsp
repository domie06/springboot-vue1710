<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<!DOCTYPE html>
<html class="no-js">
<head>
<meta  />
<title>工程车租赁系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="qtimages/css/reset.css" rel="stylesheet" />
<link href="qtimages/css/main.css" rel="stylesheet"/>
<script src="qtimages/jquery.js"></script> 
<script src="js/jquery.SuperSlide.2.1.1.js"></script>


<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<body>

<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
<div class="content">
	<div class="icon">
		<div class="wrap">
			<div class="icon_list">
				<ul>
					<li><a href="#" class="i1">品牌介绍</a></li>
					<li><a href="#" class="i2">企业荣誉</a></li>
					<li><a href="#" class="i3">团队力量</a></li>
					<li><a href="#" class="i4">专业技术</a></li>
					<li><a href="#" class="i5">相关视频</a></li>
				</ul>
			</div>
			
		</div>
	</div>
	<div class="wrap">
		
		<div class="pad20">
			<div class="title">
				<div class="name name2"><h3>站内新闻</h3>News</div>
				<div class="more"><a href="xwtzList.do?lb=站内新闻">更多 ></a></div>
			</div>
			<div class="f4_x"></div>
			<div class="wwdt">
				<div class="l_pic">
					<a href="xwtzList.do?lb=站内新闻"><img src="qtimages/news.jpg" width="288" height="188" /></a>
					<a href="xwtzList.do?lb=站内新闻">所有资讯,这里都有,快来看看！</a>
				</div>
				<div class="c_news">
				
					<div class="news_sj">
						<ul>
						 <c:forEach items="${syxinwentongzhi1 }" var="a">
							<li><a href="xwtzDetail.do?id=${a.id}"><span>${fn:substring(a.addtime, 0, 10)}</span> ${fn:substring(a.biaoti, 0, 20)}</a></li>
							
							 </c:forEach>
							
						</ul>
					</div>
					<a href="xwtzList.do?lb=站内新闻" class="more">更多动态</a>
				</div>
				<div class="r_tw">
					<ul class="r_tw_list">
						<li>
							<div class="pic"><a href="#"><img src="qtimages/news1.jpg"/></a></div>
							<div class="txt"><a href="#">我们的团队</a><span>xxxx-xx-xx</span></div>
						</li>
						<li>
							<div class="pic"><a href="#"><img src="qtimages/news2.jpg"/></a></div>
							<div class="txt"><a href="#">我们的风彩</a><span>xxxx-xx-xx</span></div>
						</li>
					</ul>
					<a href="xwtzList.do?lb=站内新闻" class="more">更多动态</a>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<!--<div id="adsBox" class="adsBox mrt20">
			<div class="hd">
				<ul>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
			<div class="bd">
				<ul>
					<li><a href="#" target="_blank"><img src="qtimages/ad1.jpg" /></a></li>
					<li><a href="#" target="_blank"><img src="qtimages/ad1.jpg" /></a></li>
					<li><a href="#" target="_blank"><img src="qtimages/ad1.jpg" /></a></li>
				</ul>
			</div>
		</div>-->
		<div class="pad20 slideGroup">
			<div class="title">
				<div class="name name2"><h3>车辆展示</h3>Products</div>
				<div class="more"><a href="#">更多 ></a></div>
				<div class="clear"></div>
			</div>
			 <div class="parBd">
				<div class="slideBox">
					<a class="sPrev" href="javascript:void(0)"></a>
					<ul>
					
					 <c:forEach items="${sycheliangxinxi1 }" var="a">
						<li>
							<div class="pic"><a href="clxxDetail.do?id=${a.id}" target="_blank"><img src="${a.tupian}" width="300" height="300" border="0" /></a></div>
							<div class="tit"><a href="clxxDetail.do?id=${a.id}" target="_blank">${a.cheliangmingcheng}</a><span class="eye">日租${a.rizujia}</span></div>
						</li>
						
						   </c:forEach>
					
					</ul>
					<a class="sNext" href="javascript:void(0)"></a>
				</div><!-- slideBox End -->

			
			</div><!-- parBd End -->
		</div>
		
		<div class="pad20">
			<div class="title">
				<div class="name name2"><h3>关于我们</h3>About us</div>
				<div class="more"><a href="dx_detail.php?lb=关于我们">更多 ></a></div>
			</div>
			<div class="f4_x"></div>
			<div class="wwdt">
				<div class="l_pic">
					<a href="#"><img src="qtimages/about.jpg" width="288" height="188" /></a>
					<a href="#">工程车租赁系统</a>
				</div>
				<div class="c_news l2em">
					　 公司行为准则:忠信仁义，以人为本。 
    忠：即忠诚，包括三重含义：企业忠于国家、忠于民族；企业忠于客户；员工忠于企业。 
    信：即诚信，做企业要立足根本道德、信义，要诚实、讲信用。 
    仁：即仁爱，上司对下属要仁爱、体贴，同事之间要关怀、友爱。 
    义：即大义，公司在与合作伙伴、客户的交往过程中，不做损人利己的事，维护自己利益的前提是不损害他人利益；对民族、社会要共襄义举，要识大义，明是非。 
    ...　<a href="dx_detail.php?lb=关于我们">[详细]</a>
				</div>
				<div class="r_tw">
					<ul class="about_list">
						<li>
							<div class="pic"><a href="#"><img src="qtimages/i_honor.jpg"/></a></div>
							<div class="txt"><h4><a href="#">我们的荣誉资质</a></h4>深受市政府的扶持和支持。共获得各类奖项2000多个...</div>
						</li>
						<li>
							<div class="pic"><a href="#"><img src="qtimages/i_sz.jpg"/></a></div>
							<div class="txt"><h4><a href="#">我们的团队力量</a></h4>拥有专业负责的技术人员20人......</div>
						</li>
						
					</ul>
					<a href="#" class="more2">查看更多</a>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="pad20">
			<div class="title">
				<div class="name name2"><h3>友情链接</h3>Links</div>
				<div class="more"><a href="#">更多 ></a></div>
			</div>
			<div class="f4_x"></div>
			<div class="links">
				
				 <%
			String sqlyqlj="select  * from youqinglianjie   order by id desc limit 0,5";
			ResultSet RS_resultyqlj=connDbBean.executeQuery(sqlyqlj);
while(RS_resultyqlj.next())
{
		%>
    	<a href="<%=RS_resultyqlj.getString("wangzhi")%>" target="_blank"><%=RS_resultyqlj.getString("wangzhanmingcheng")%></a>
		 <%
								  }
								  %>
					  
			</div>
		</div>
	
	</div>
</div>
<jsp:include page="qtdown.jsp"></jsp:include>
<!-- The Scripts -->

</body>
</html>
