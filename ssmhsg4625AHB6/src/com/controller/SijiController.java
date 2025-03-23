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

import com.entity.Siji;
import com.server.SijiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class SijiController {
	@Resource
	private SijiServer sijiService;


   
	@RequestMapping("addSiji.do")
	public String addSiji(HttpServletRequest request,Siji siji,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		siji.setAddtime(time.toString().substring(0, 19));
		sijiService.add(siji);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "sijiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:sijiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateSiji.do")
	public String doUpdateSiji(int id,ModelMap map,Siji siji){
		siji=sijiService.getById(id);
		map.put("siji", siji);
		return "siji_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("sijiDetail.do")
	public String sijiDetail(int id,ModelMap map,Siji siji){
		siji=sijiService.getById(id);
		map.put("siji", siji);
		return "siji_detail";
	}
//	前台详细
	@RequestMapping("sjDetail.do")
	public String sjDetail(int id,ModelMap map,Siji siji){
		siji=sijiService.getById(id);
		map.put("siji", siji);
		return "sijidetail";
	}
//	
	@RequestMapping("updateSiji.do")
	public String updateSiji(int id,ModelMap map,Siji siji,HttpServletRequest request,HttpSession session){
		sijiService.update(siji);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:sijiList.do";
	}

//	分页查询
	@RequestMapping("sijiList.do")
	public String sijiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Siji siji, String bianhao, String xingming, String xingbie, String zhaopian, String suozaidi, String shanchangchexing, String lianxishouji, String gerenjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(suozaidi==null||suozaidi.equals("")){pmap.put("suozaidi", null);}else{pmap.put("suozaidi", suozaidi);}		if(shanchangchexing==null||shanchangchexing.equals("")){pmap.put("shanchangchexing", null);}else{pmap.put("shanchangchexing", shanchangchexing);}		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}		if(gerenjianjie==null||gerenjianjie.equals("")){pmap.put("gerenjianjie", null);}else{pmap.put("gerenjianjie", gerenjianjie);}		
		int total=sijiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Siji> list=sijiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "siji_list";
	}
	
	
	
	@RequestMapping("sjList.do")
	public String sjList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Siji siji, String bianhao, String xingming, String xingbie, String zhaopian, String suozaidi, String shanchangchexing, String lianxishouji, String gerenjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(suozaidi==null||suozaidi.equals("")){pmap.put("suozaidi", null);}else{pmap.put("suozaidi", suozaidi);}		if(shanchangchexing==null||shanchangchexing.equals("")){pmap.put("shanchangchexing", null);}else{pmap.put("shanchangchexing", shanchangchexing);}		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}		if(gerenjianjie==null||gerenjianjie.equals("")){pmap.put("gerenjianjie", null);}else{pmap.put("gerenjianjie", gerenjianjie);}		
		int total=sijiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Siji> list=sijiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "sijilist";
	}
	
	@RequestMapping("deleteSiji.do")
	public String deleteSiji(int id,HttpServletRequest request){
		sijiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:sijiList.do";
	}
	
	@RequestMapping("quchongSiji.do")
	public void quchongSiji(Siji siji,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("bianhao", siji.getBianhao());
		   System.out.println("bianhao==="+siji.getBianhao());
		   System.out.println("bianhao222==="+sijiService.quchongSiji(map));
		   JSONObject obj=new JSONObject();
		   if(sijiService.quchongSiji(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "编号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
