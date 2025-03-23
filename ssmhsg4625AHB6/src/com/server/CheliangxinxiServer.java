package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Cheliangxinxi;

public interface CheliangxinxiServer {

  public int add(Cheliangxinxi po);

  public int update(Cheliangxinxi po);
  
  
  
  public int delete(int id);

  public List<Cheliangxinxi> getAll(Map<String,Object> map);
  public List<Cheliangxinxi> getsycheliangxinxi1(Map<String,Object> map);
  public List<Cheliangxinxi> getsycheliangxinxi2(Map<String,Object> map);
  public List<Cheliangxinxi> getsycheliangxinxi3(Map<String,Object> map);
  public Cheliangxinxi quchongCheliangxinxi(Map<String, Object> acount);

  public Cheliangxinxi getById( int id);

  public List<Cheliangxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Cheliangxinxi> select(Map<String, Object> map);
}
//	所有List
