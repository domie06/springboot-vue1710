package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Cheliangxinxi;

public interface CheliangxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cheliangxinxi record);

    int insertSelective(Cheliangxinxi record);

    Cheliangxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cheliangxinxi record);
	
    int updateByPrimaryKey(Cheliangxinxi record);
	public Cheliangxinxi quchongCheliangxinxi(Map<String, Object> cheliangbianhao);
	public List<Cheliangxinxi> getAll(Map<String, Object> map);
	public List<Cheliangxinxi> getsycheliangxinxi1(Map<String, Object> map);
	public List<Cheliangxinxi> getsycheliangxinxi3(Map<String, Object> map);
	public List<Cheliangxinxi> getsycheliangxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Cheliangxinxi> getByPage(Map<String, Object> map);
	public List<Cheliangxinxi> select(Map<String, Object> map);
//	所有List
}

