package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Siji;

public interface SijiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Siji record);

    int insertSelective(Siji record);

    Siji selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Siji record);
	
    int updateByPrimaryKey(Siji record);
	public Siji quchongSiji(Map<String, Object> bianhao);
	public List<Siji> getAll(Map<String, Object> map);
	public List<Siji> getsysiji1(Map<String, Object> map);
	public List<Siji> getsysiji3(Map<String, Object> map);
	public List<Siji> getsysiji2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Siji> getByPage(Map<String, Object> map);
	public List<Siji> select(Map<String, Object> map);
//	所有List
}

