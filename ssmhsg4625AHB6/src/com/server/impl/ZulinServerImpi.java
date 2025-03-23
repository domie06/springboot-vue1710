package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZulinMapper;
import com.entity.Zulin;
import com.server.ZulinServer;
@Service
public class ZulinServerImpi implements ZulinServer {
   @Resource
   private ZulinMapper gdao;
	@Override
	public int add(Zulin po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zulin po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zulin> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zulin> getsyzulin1(Map<String, Object> map) {
		return gdao.getsyzulin1(map);
	}
	public List<Zulin> getsyzulin2(Map<String, Object> map) {
		return gdao.getsyzulin2(map);
	}
	public List<Zulin> getsyzulin3(Map<String, Object> map) {
		return gdao.getsyzulin3(map);
	}
	
	@Override
	public Zulin quchongZulin(Map<String, Object> account) {
		return gdao.quchongZulin(account);
	}

	@Override
	public List<Zulin> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zulin> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zulin getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

