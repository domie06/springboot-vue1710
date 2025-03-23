package com.controller;

import java.io.File;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.entity.Xinwentongzhi;
import com.entity.Yonghuzhuce;
import com.entity.Cheliangxinxi;import com.entity.Siji;//jixacxishxu1

import com.server.XinwentongzhiServer;
import com.server.YonghuzhuceServer;
import com.server.CheliangxinxiServer;import com.server.SijiServer;//jixacxishxu2

import com.util.PageBean;

@Controller
public class IndexController {
	
	
	@Resource
	private XinwentongzhiServer xinwentongzhiService;
	@Resource
	private YonghuzhuceServer yonghuzhuceServer;
	@Resource	private CheliangxinxiServer cheliangxinxiServer;	@Resource	private SijiServer sijiServer;	//jixacxishxu3
	
	
	
//	首页显示内容
	@RequestMapping("index.do")
	public String showIndex(ModelMap map){

		List<Xinwentongzhi> syxinwentongzhi1=xinwentongzhiService.getsyxinwentongzhi1(null);
		List<Xinwentongzhi> syxinwentongzhi2=xinwentongzhiService.getsyxinwentongzhi2(null);
		List<Xinwentongzhi> syxinwentongzhi3=xinwentongzhiService.getsyxinwentongzhi3(null);

		List<Yonghuzhuce> syyonghuzhuce1=yonghuzhuceServer.getsyyonghuzhuce1(null);
		List<Cheliangxinxi> sycheliangxinxi1=cheliangxinxiServer.getsycheliangxinxi1(null);		List<Cheliangxinxi> sycheliangxinxi2=cheliangxinxiServer.getsycheliangxinxi2(null);		List<Cheliangxinxi> sycheliangxinxi3=cheliangxinxiServer.getsycheliangxinxi3(null);		List<Siji> sysiji1=sijiServer.getsysiji1(null);		List<Siji> sysiji2=sijiServer.getsysiji2(null);		List<Siji> sysiji3=sijiServer.getsysiji3(null);		//jixacxishxu4
		
	    map.put("syxinwentongzhi1", syxinwentongzhi1);
	    map.put("syxinwentongzhi2", syxinwentongzhi2);
	    map.put("syxinwentongzhi3", syxinwentongzhi3);
	    map.put("syyonghuzhuce1", syyonghuzhuce1);
	    map.put("sycheliangxinxi1", sycheliangxinxi1);	    map.put("sycheliangxinxi2", sycheliangxinxi2);	    map.put("sycheliangxinxi3", sycheliangxinxi3);	    map.put("sysiji1", sysiji1);	    map.put("sysiji2", sysiji2);	    map.put("sysiji3", sysiji3);	    //jixacxishxu5

		return "default";
	}

	

	
}
