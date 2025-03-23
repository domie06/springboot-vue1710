package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Zulin;
import com.server.ZulinServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZulinController {
	@Resource
	private ZulinServer zulinService;


   
	@RequestMapping("addZulin.do")
	public String addZulin(HttpServletRequest request,Zulin zulin,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zulin.setAddtime(time.toString().substring(0, 19));
		zulinService.add(zulin);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "zulinList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:zulinList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateZulin.do")
	public String doUpdateZulin(int id,ModelMap map,Zulin zulin){
		zulin=zulinService.getById(id);
		map.put("zulin", zulin);
		return "zulin_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("zulinDetail.do")
	public String zulinDetail(int id,ModelMap map,Zulin zulin){
		zulin=zulinService.getById(id);
		map.put("zulin", zulin);
		return "zulin_detail";
	}
//	前台详细
	@RequestMapping("zlDetail.do")
	public String zlDetail(int id,ModelMap map,Zulin zulin){
		zulin=zulinService.getById(id);
		map.put("zulin", zulin);
		return "zulindetail";
	}
//	
	@RequestMapping("updateZulin.do")
	public String updateZulin(int id,ModelMap map,Zulin zulin,HttpServletRequest request,HttpSession session){
		zulinService.update(zulin);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zulinList.do";
	}

//	分页查询
	@RequestMapping("zulinList.do")
	public String zulinList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zulin zulin, String cheliangbianhao, String cheliangmingcheng, String leixing, String chepaihao, String rizujia, String zulintianshu1,String zulintianshu2, String zongjia, String zulinren, String issh, String iszf){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(cheliangbianhao==null||cheliangbianhao.equals("")){pmap.put("cheliangbianhao", null);}else{pmap.put("cheliangbianhao", cheliangbianhao);}
		if(cheliangmingcheng==null||cheliangmingcheng.equals("")){pmap.put("cheliangmingcheng", null);}else{pmap.put("cheliangmingcheng", cheliangmingcheng);}
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(rizujia==null||rizujia.equals("")){pmap.put("rizujia", null);}else{pmap.put("rizujia", rizujia);}
		if(zulintianshu1==null||zulintianshu1.equals("")){pmap.put("zulintianshu1", null);}else{pmap.put("zulintianshu1", zulintianshu1);}
		if(zulintianshu2==null||zulintianshu2.equals("")){pmap.put("zulintianshu2", null);}else{pmap.put("zulintianshu2", zulintianshu2);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(zulinren==null||zulinren.equals("")){pmap.put("zulinren", null);}else{pmap.put("zulinren", zulinren);}
		
		int total=zulinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zulin> list=zulinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zulin_list";
	}
	
	@RequestMapping("zulinList2.do")
	public String zulinList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zulin zulin, String cheliangbianhao, String cheliangmingcheng, String leixing, String chepaihao, String rizujia, String zulintianshu1,String zulintianshu2, String zongjia, String zulinren, String iszf,String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("zulinren", (String)request.getSession().getAttribute("username"));
		if(cheliangbianhao==null||cheliangbianhao.equals("")){pmap.put("cheliangbianhao", null);}else{pmap.put("cheliangbianhao", cheliangbianhao);}
		if(cheliangmingcheng==null||cheliangmingcheng.equals("")){pmap.put("cheliangmingcheng", null);}else{pmap.put("cheliangmingcheng", cheliangmingcheng);}
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(rizujia==null||rizujia.equals("")){pmap.put("rizujia", null);}else{pmap.put("rizujia", rizujia);}
		if(zulintianshu1==null||zulintianshu1.equals("")){pmap.put("zulintianshu1", null);}else{pmap.put("zulintianshu1", zulintianshu1);}
		if(zulintianshu2==null||zulintianshu2.equals("")){pmap.put("zulintianshu2", null);}else{pmap.put("zulintianshu2", zulintianshu2);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		
		
		int total=zulinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zulin> list=zulinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zulin_list2";
	}
	
	
	@RequestMapping("zlList.do")
	public String zlList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zulin zulin, String cheliangbianhao, String cheliangmingcheng, String leixing, String chepaihao, String rizujia, String zulintianshu1,String zulintianshu2, String zongjia, String zulinren, String iszf, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(cheliangbianhao==null||cheliangbianhao.equals("")){pmap.put("cheliangbianhao", null);}else{pmap.put("cheliangbianhao", cheliangbianhao);}
		if(cheliangmingcheng==null||cheliangmingcheng.equals("")){pmap.put("cheliangmingcheng", null);}else{pmap.put("cheliangmingcheng", cheliangmingcheng);}
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(rizujia==null||rizujia.equals("")){pmap.put("rizujia", null);}else{pmap.put("rizujia", rizujia);}
		if(zulintianshu1==null||zulintianshu1.equals("")){pmap.put("zulintianshu1", null);}else{pmap.put("zulintianshu1", zulintianshu1);}
		if(zulintianshu2==null||zulintianshu2.equals("")){pmap.put("zulintianshu2", null);}else{pmap.put("zulintianshu2", zulintianshu2);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(zulinren==null||zulinren.equals("")){pmap.put("zulinren", null);}else{pmap.put("zulinren", zulinren);}
		
		int total=zulinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zulin> list=zulinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zulinlist";
	}
	
	@RequestMapping("deleteZulin.do")
	public String deleteZulin(int id,HttpServletRequest request){
		zulinService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zulinList.do";
	}
	
	
}
