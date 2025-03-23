package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zulin;

public interface ZulinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zulin record);

    int insertSelective(Zulin record);

    Zulin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zulin record);
	
    int updateByPrimaryKey(Zulin record);
	public Zulin quchongZulin(Map<String, Object> zulinren);
	public List<Zulin> getAll(Map<String, Object> map);
	public List<Zulin> getsyzulin1(Map<String, Object> map);
	public List<Zulin> getsyzulin3(Map<String, Object> map);
	public List<Zulin> getsyzulin2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zulin> getByPage(Map<String, Object> map);
	public List<Zulin> select(Map<String, Object> map);
//	所有List
}

