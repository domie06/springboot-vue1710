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

import com.entity.Cheliangxinxi;
import com.server.CheliangxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class CheliangxinxiController {
	@Resource
	private CheliangxinxiServer cheliangxinxiService;


   
	@RequestMapping("addCheliangxinxi.do")
	public String addCheliangxinxi(HttpServletRequest request,Cheliangxinxi cheliangxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		cheliangxinxi.setAddtime(time.toString().substring(0, 19));
		cheliangxinxiService.add(cheliangxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "cheliangxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:cheliangxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateCheliangxinxi.do")
	public String doUpdateCheliangxinxi(int id,ModelMap map,Cheliangxinxi cheliangxinxi){
		cheliangxinxi=cheliangxinxiService.getById(id);
		map.put("cheliangxinxi", cheliangxinxi);
		return "cheliangxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("cheliangxinxiDetail.do")
	public String cheliangxinxiDetail(int id,ModelMap map,Cheliangxinxi cheliangxinxi){
		cheliangxinxi=cheliangxinxiService.getById(id);
		map.put("cheliangxinxi", cheliangxinxi);
		return "cheliangxinxi_detail";
	}
//	前台详细
	@RequestMapping("clxxDetail.do")
	public String clxxDetail(int id,ModelMap map,Cheliangxinxi cheliangxinxi){
		cheliangxinxi=cheliangxinxiService.getById(id);
		map.put("cheliangxinxi", cheliangxinxi);
		return "cheliangxinxidetail";
	}
//	
	@RequestMapping("updateCheliangxinxi.do")
	public String updateCheliangxinxi(int id,ModelMap map,Cheliangxinxi cheliangxinxi,HttpServletRequest request,HttpSession session){
		cheliangxinxiService.update(cheliangxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:cheliangxinxiList.do";
	}

//	分页查询
	@RequestMapping("cheliangxinxiList.do")
	public String cheliangxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Cheliangxinxi cheliangxinxi, String cheliangbianhao, String cheliangmingcheng, String leixing, String chepaihao, String tupian, String rizujia1,String rizujia2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(cheliangbianhao==null||cheliangbianhao.equals("")){pmap.put("cheliangbianhao", null);}else{pmap.put("cheliangbianhao", cheliangbianhao);}		if(cheliangmingcheng==null||cheliangmingcheng.equals("")){pmap.put("cheliangmingcheng", null);}else{pmap.put("cheliangmingcheng", cheliangmingcheng);}		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(rizujia1==null||rizujia1.equals("")){pmap.put("rizujia1", null);}else{pmap.put("rizujia1", rizujia1);}		if(rizujia2==null||rizujia2.equals("")){pmap.put("rizujia2", null);}else{pmap.put("rizujia2", rizujia2);}		
		int total=cheliangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Cheliangxinxi> list=cheliangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "cheliangxinxi_list";
	}
	
	
	
	@RequestMapping("clxxList.do")
	public String clxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Cheliangxinxi cheliangxinxi, String cheliangbianhao, String cheliangmingcheng, String leixing, String chepaihao, String tupian, String rizujia1,String rizujia2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(cheliangbianhao==null||cheliangbianhao.equals("")){pmap.put("cheliangbianhao", null);}else{pmap.put("cheliangbianhao", cheliangbianhao);}		if(cheliangmingcheng==null||cheliangmingcheng.equals("")){pmap.put("cheliangmingcheng", null);}else{pmap.put("cheliangmingcheng", cheliangmingcheng);}		if(leixing==null||leixing.equals("")){pmap.put("leixing", null);}else{pmap.put("leixing", leixing);}		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(rizujia1==null||rizujia1.equals("")){pmap.put("rizujia1", null);}else{pmap.put("rizujia1", rizujia1);}		if(rizujia2==null||rizujia2.equals("")){pmap.put("rizujia2", null);}else{pmap.put("rizujia2", rizujia2);}		
		int total=cheliangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Cheliangxinxi> list=cheliangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "cheliangxinxilist";
	}
	
	@RequestMapping("deleteCheliangxinxi.do")
	public String deleteCheliangxinxi(int id,HttpServletRequest request){
		cheliangxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:cheliangxinxiList.do";
	}
	
	@RequestMapping("quchongCheliangxinxi.do")
	public void quchongCheliangxinxi(Cheliangxinxi cheliangxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("chepaihao", cheliangxinxi.getChepaihao());
		   System.out.println("chepaihao==="+cheliangxinxi.getChepaihao());
		   System.out.println("chepaihao222==="+cheliangxinxiService.quchongCheliangxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(cheliangxinxiService.quchongCheliangxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "车牌号可以用！");
				  
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
