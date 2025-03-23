package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CheliangleixingMapper;
import com.entity.Cheliangleixing;
import com.server.CheliangleixingServer;
@Service
public class CheliangleixingServerImpi implements CheliangleixingServer {
   @Resource
   private CheliangleixingMapper gdao;
	@Override
	public int add(Cheliangleixing po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Cheliangleixing po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Cheliangleixing> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Cheliangleixing> getsycheliangleixing1(Map<String, Object> map) {
		return gdao.getsycheliangleixing1(map);
	}
	public List<Cheliangleixing> getsycheliangleixing2(Map<String, Object> map) {
		return gdao.getsycheliangleixing2(map);
	}
	public List<Cheliangleixing> getsycheliangleixing3(Map<String, Object> map) {
		return gdao.getsycheliangleixing3(map);
	}
	
	@Override
	public Cheliangleixing quchongCheliangleixing(Map<String, Object> account) {
		return gdao.quchongCheliangleixing(account);
	}

	@Override
	public List<Cheliangleixing> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Cheliangleixing> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Cheliangleixing getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

