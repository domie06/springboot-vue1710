package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zulin;

public interface ZulinServer {

  public int add(Zulin po);

  public int update(Zulin po);
  
  
  
  public int delete(int id);

  public List<Zulin> getAll(Map<String,Object> map);
  public List<Zulin> getsyzulin1(Map<String,Object> map);
  public List<Zulin> getsyzulin2(Map<String,Object> map);
  public List<Zulin> getsyzulin3(Map<String,Object> map);
  public Zulin quchongZulin(Map<String, Object> acount);

  public Zulin getById( int id);

  public List<Zulin> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zulin> select(Map<String, Object> map);
}
//	所有List
