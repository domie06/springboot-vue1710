package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Cheliangleixing;

public interface CheliangleixingServer {

  public int add(Cheliangleixing po);

  public int update(Cheliangleixing po);
  
  
  
  public int delete(int id);

  public List<Cheliangleixing> getAll(Map<String,Object> map);
  public List<Cheliangleixing> getsycheliangleixing1(Map<String,Object> map);
  public List<Cheliangleixing> getsycheliangleixing2(Map<String,Object> map);
  public List<Cheliangleixing> getsycheliangleixing3(Map<String,Object> map);
  public Cheliangleixing quchongCheliangleixing(Map<String, Object> acount);

  public Cheliangleixing getById( int id);

  public List<Cheliangleixing> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Cheliangleixing> select(Map<String, Object> map);
}
//	所有List
