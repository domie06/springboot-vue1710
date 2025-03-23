package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Cheliangleixing;

public interface CheliangleixingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cheliangleixing record);

    int insertSelective(Cheliangleixing record);

    Cheliangleixing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cheliangleixing record);
	
    int updateByPrimaryKey(Cheliangleixing record);
	public Cheliangleixing quchongCheliangleixing(Map<String, Object> leixing);
	public List<Cheliangleixing> getAll(Map<String, Object> map);
	public List<Cheliangleixing> getsycheliangleixing1(Map<String, Object> map);
	public List<Cheliangleixing> getsycheliangleixing3(Map<String, Object> map);
	public List<Cheliangleixing> getsycheliangleixing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Cheliangleixing> getByPage(Map<String, Object> map);
	public List<Cheliangleixing> select(Map<String, Object> map);
//	所有List
}

