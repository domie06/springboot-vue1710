package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.SijiMapper;
import com.entity.Siji;
import com.server.SijiServer;
@Service
public class SijiServerImpi implements SijiServer {
   @Resource
   private SijiMapper gdao;
	@Override
	public int add(Siji po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Siji po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Siji> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Siji> getsysiji1(Map<String, Object> map) {
		return gdao.getsysiji1(map);
	}
	public List<Siji> getsysiji2(Map<String, Object> map) {
		return gdao.getsysiji2(map);
	}
	public List<Siji> getsysiji3(Map<String, Object> map) {
		return gdao.getsysiji3(map);
	}
	
	@Override
	public Siji quchongSiji(Map<String, Object> account) {
		return gdao.quchongSiji(account);
	}

	@Override
	public List<Siji> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Siji> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Siji getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

