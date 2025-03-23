package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Siji;

public interface SijiServer {

  public int add(Siji po);

  public int update(Siji po);
  
  
  
  public int delete(int id);

  public List<Siji> getAll(Map<String,Object> map);
  public List<Siji> getsysiji1(Map<String,Object> map);
  public List<Siji> getsysiji2(Map<String,Object> map);
  public List<Siji> getsysiji3(Map<String,Object> map);
  public Siji quchongSiji(Map<String, Object> acount);

  public Siji getById( int id);

  public List<Siji> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Siji> select(Map<String, Object> map);
}
//	所有List
