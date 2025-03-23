package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CheliangxinxiMapper;
import com.entity.Cheliangxinxi;
import com.server.CheliangxinxiServer;
@Service
public class CheliangxinxiServerImpi implements CheliangxinxiServer {
   @Resource
   private CheliangxinxiMapper gdao;
	@Override
	public int add(Cheliangxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Cheliangxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Cheliangxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Cheliangxinxi> getsycheliangxinxi1(Map<String, Object> map) {
		return gdao.getsycheliangxinxi1(map);
	}
	public List<Cheliangxinxi> getsycheliangxinxi2(Map<String, Object> map) {
		return gdao.getsycheliangxinxi2(map);
	}
	public List<Cheliangxinxi> getsycheliangxinxi3(Map<String, Object> map) {
		return gdao.getsycheliangxinxi3(map);
	}
	
	@Override
	public Cheliangxinxi quchongCheliangxinxi(Map<String, Object> account) {
		return gdao.quchongCheliangxinxi(account);
	}

	@Override
	public List<Cheliangxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Cheliangxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Cheliangxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

