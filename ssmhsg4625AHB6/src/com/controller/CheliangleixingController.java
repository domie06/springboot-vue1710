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

import com.entity.Cheliangleixing;
import com.server.CheliangleixingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class CheliangleixingController {
	@Resource
	private CheliangleixingServer cheliangleixingService;


   
	@RequestMapping("addCheliangleixing.do")
	public String addCheliangleixing(HttpServletRequest request,Cheliangleixing cheliangleixing,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		cheliangleixing.setAddtime(time.toString().substring(0, 19));
		cheliangleixingService.add(cheliangleixing);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "cheliangleixingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:cheliangleixingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateCheliangleixing.do")
	public String doUpdateCheliangleixing(int id,ModelMap map,Cheliangleixing cheliangleixing){
		cheliangleixing=cheliangleixingService.getById(id);
		map.put("cheliangleixing", cheliangleixing);
		return "cheliangleixing_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("cheliangleixingDetail.do")
	public String cheliangleixingDetail(int id,ModelMap map,Cheliangleixing cheliangleixing){
		cheliangleixing=cheliangleixingService.getById(id);
		map.put("cheliangleixing", cheliangleixing);
		return "cheliangleixing_detail";
	}
//	前台详细
	@RequestMapping("cllxDetail.do")
	public String cllxDetail(int id,ModelMap map,Cheliangleixing cheliangleixing){
		cheliangleixing=cheliangleixingService.getById(id);
		map.put("cheliangleixing", cheliangleixing);
		return "cheliangleixingdetail";
	}
//	
	@RequestMapping("updateCheliangleixing.do")
	public String updateCheliangleixing(int id,ModelMap map,Cheliangleixing cheliangleixing,HttpServletRequest request,HttpSession session){
		cheliangleixingService.update(cheliangleixing);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:cheliangleixingList.do";
	}

//	分页查询
	@RequestMapping("cheliangleixingList.do")
	public String cheliangleixingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Cheliangleixing cheliangleixing, String leixing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}		
		int total=cheliangleixingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Cheliangleixing> list=cheliangleixingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "cheliangleixing_list";
	}
	
	
	
	@RequestMapping("cllxList.do")
	public String cllxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Cheliangleixing cheliangleixing, String leixing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}		
		int total=cheliangleixingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Cheliangleixing> list=cheliangleixingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "cheliangleixinglist";
	}
	
	@RequestMapping("deleteCheliangleixing.do")
	public String deleteCheliangleixing(int id,HttpServletRequest request){
		cheliangleixingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:cheliangleixingList.do";
	}
	
	
}
